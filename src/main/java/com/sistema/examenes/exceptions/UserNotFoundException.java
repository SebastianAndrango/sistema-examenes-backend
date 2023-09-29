package com.sistema.examenes.exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(){
        super("El usuario no existe, vuelva a intentarlo");
    }

    public UserNotFoundException(String message){
        super(message);
    }
}
