package org.vipul.dockerfirst.exception;

public class FileStorageException extends RuntimeException{
    public FileStorageException(String message, Throwable cause){
        super(message, cause);
    }
}
