package com.example.pokemonapp.exception;

public class ApiException extends Exception {
    public ApiException(String message) {
        super(message);
    }
}