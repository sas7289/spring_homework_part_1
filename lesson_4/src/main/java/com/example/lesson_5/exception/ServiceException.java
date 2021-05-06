package com.example.lesson_5.exception;

public class ServiceException extends  RuntimeException{
    public ServiceException(String message) {
        super("Lesson_4 " + message);
    }
}
