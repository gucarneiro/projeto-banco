package com.gucarneiro.banco.exception;

public class LimiteExcedidoException extends RuntimeException{
    public LimiteExcedidoException (String mensagem){
        super(mensagem);
    }
}
