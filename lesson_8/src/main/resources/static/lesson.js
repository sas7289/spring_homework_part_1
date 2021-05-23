angular.module('app', []).controller('indexController', function ($scope, $http) {


    const contextPath = 'http://localhost:8080/app/v1';


    $scope.fillTable = function () {
        console.log($scope.filter);
        $http({
            url: contextPath + '/products',
            method: 'GET',
            params: {
                'title': $scope.filter ? $scope.filter.title : null,
                'cost': $scope.filter ? $scope.filter.cost : null
            }
        })
            .then(function (response) {
                $scope.ProductList = response.data;
            });
    };

    $scope.saveProduct = function () {
        console.log($scope.newProduct);
        $http.post(contextPath + '/save', $scope.newProduct)
            .then(function (response) {
                $scope.newProduct = null;
                $scope.fillTable();
            })

    };


    $scope.deleteProduct = function (productToDelete) {
        console.log(productToDelete);
        $http.post(contextPath + '/delete', productToDelete)
            .then(function (resp) {
                $scope.fillTable();
            })

    }

    $scope.nextPage = function () {
        $http({
            url: contextPath + '/next',
            method: 'GET',
            params: {
                'title': $scope.filter ? $scope.filter.title : null,
                'cost': $scope.filter ? $scope.filter.cost : null
            }
        })
            .then(function (response) {
                $scope.ProductList = response.data;
            });
    }

    $scope.prevPage = function () {
        $http({
            url: contextPath + '/prev',
            method: 'GET',
            params: {
                'title': $scope.filter ? $scope.filter.title : null,
                'cost': $scope.filter ? $scope.filter.cost : null
            }
        })
            .then(function (response) {
                $scope.ProductList = response.data;
            });
    }

    $scope.fillTable();

});