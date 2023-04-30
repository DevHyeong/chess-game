package com.exam.chess.exception;

public class ImmovableException extends RuntimeException{

    public ImmovableException(){
        super();
    }

    public ImmovableException(String s){
        super(s);
    }
}
