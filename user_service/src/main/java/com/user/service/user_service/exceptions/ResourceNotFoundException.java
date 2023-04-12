package com.user.service.user_service.exceptions;

public class ResourceNotFoundException  extends RuntimeException {
   
    public ResourceNotFoundException(){
        super("resource is not found on server !!");
    }

    public ResourceNotFoundException(String message){
       
        super(message);
    }

}
