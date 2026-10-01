package com.gucarneiro.banco.model;

import java.math.BigDecimal;

public class ContaCorrente extends Conta{
    CartaoDeCredito cc = new CartaoDeCredito();

    public CartaoDeCredito getCc() {
        return cc;
    }

    public void setCc(CartaoDeCredito cc) {
        this.cc = cc;
    }

    public ContaCorrente(Cliente cliente, BigDecimal saldo, int numeroConta, int senha, CartaoDeCredito cc) {
        super(cliente, saldo, numeroConta, senha);
        this.cc = cc;
    }

    public ContaCorrente() {
    }

    public void realizarCompraCredito(BigDecimal valorCompra){
        if (this.cc == null){
            throw new IllegalStateException("Essa conta não possui cartão de credito!");
        }

        this.cc.comprar(valorCompra);
        registrarTransacao(valorCompra, TipoTransacao.COMPRA_CREDITO);
    }

    public void acessarFatura(){
        //todo
    }

    public void pagarFatura(){
        //todo
    }
}