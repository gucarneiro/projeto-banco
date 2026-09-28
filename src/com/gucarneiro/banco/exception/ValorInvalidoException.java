package com.gucarneiro.banco.exception;

public class ValorInvalidoException extends RuntimeException{
    public ValorInvalidoException(String mensagem){
        super(mensagem);
    }
}
