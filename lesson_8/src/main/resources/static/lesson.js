angular.module('app', []).controller('indexController', function ($scope, $http) {


    const contextPath = 'http://localhost:8080/app/v1';


    $scope.fillTable = function (pageIndex = 1) {
        console.log($scope.filter);
        $http({
            url: contextPath + '/products',
            method: 'GET',
            params: {
                'title': $scope.filter ? $scope.filter.title : null,
                'cost': $scope.filter ? $scope.filter.cost : null,
                'pageNumber': pageIndex
            }
        })
            .then(function (response) {
                $scope.ProductsPage = response.data;

                let minPageIndex = pageIndex - 2;
                if (minPageIndex < 1) {
                    minPageIndex = 1;
                }

                let maxPageIndex = pageIndex + 2;
                if (maxPageIndex > $scope.ProductsPage.totalPages) {
                    maxPageIndex = $scope.ProductsPage.totalPages;
                }

                $scope.PaginationArray = $scope.generatePageIndex(minPageIndex, maxPageIndex);
            });
        $http.get(contextPath + '/categories')
            // $http({
            //     url: contextPath + '/categories',
            //     method: 'GET'
            // })
            .then(function (response) {
                $scope.Categories = response.data;
            });
    };

    $scope.generatePageIndex = function (minPageIndex, maxPageIndex) {
        let arr = [];
        for (let i = minPageIndex; i < maxPageIndex + 1; i++) {
            arr.push(i);
        }
        return arr;
    }

    $scope.saveProduct = function () {
        console.log($scope.newProduct);
        $http.post(contextPath + '/save', $scope.newProduct)
            .then(function (response) {
                $scope.newProduct = null;
                $scope.fillTable();
            })

    };


    $scope.deleteProduct = function (productIdToDelete) {
        console.log(productIdToDelete);
        $http.delete(contextPath + '/' + productIdToDelete)
            .then(function (resp) {
                $scope.fillTable($scope.ProductsPage.number + 1);
            })

    }

    $scope.selectCategory = function () {
        $http.get(contextPath + '/categories')
        // $http({
        //     url: contextPath + '/categories',
        //     method: 'GET'
        // })
            .then(function (response) {
                $scope.Categories = response.data;
            });
    }

    $scope.fillTable();

});