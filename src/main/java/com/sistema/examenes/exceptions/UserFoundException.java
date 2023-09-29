package com.sistema.examenes.exceptions;

public class UserFoundException extends Exception{
    
    public UserFoundException(){
        super("El usuario ya existe, vuelva a intentarlo");
    }

    public UserFoundException(String message){
        super(message);
    }
}
