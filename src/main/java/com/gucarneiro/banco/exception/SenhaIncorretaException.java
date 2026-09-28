package com.gucarneiro.banco.exception;

public class SenhaIncorretaException extends RuntimeException{
    public SenhaIncorretaException(String mensagem){
        super(mensagem);
    }
}
