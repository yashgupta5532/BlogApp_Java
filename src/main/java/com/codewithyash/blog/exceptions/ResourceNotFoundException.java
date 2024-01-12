package com.codewithyash.blog.exceptions;


public class ResourceNotFoundException extends RuntimeException {
    String resourceName;
    String fieldName;
    long fieldValue;

    public ResourceNotFoundException(String resourceName,String fieldName,Integer userId){
        super( String.format("%s not found with %s : %s", resourceName,fieldName,userId));
        this.resourceName=resourceName;
        this.fieldName=fieldName;
        this.fieldValue=userId;
            
    }

}
