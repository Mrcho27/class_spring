package com.example.task01.exception;

public class DuplicateUserException extends Exception{
    public DuplicateUserException(String msg) {
        super(msg);
    }
}
