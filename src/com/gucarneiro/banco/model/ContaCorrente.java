package com.gucarneiro.banco.model;

public class ContaCorrente extends Conta{
    CartaoDeCredito cc = new CartaoDeCredito();

    public CartaoDeCredito getCc() {
        return cc;
    }

    public void setCc(CartaoDeCredito cc) {
        this.cc = cc;
    }



    public ContaCorrente(Cliente cliente, double saldo, int numeroConta, int senha, CartaoDeCredito cc) {
        super(cliente, saldo, numeroConta, senha);
        this.cc = cc;
    }

    public ContaCorrente() {
    }

    public void acessarFatura(){
        //todo
    }

    public void pagarFatura(){
        //todo
    }

    @Override
    public void acessarSaldo(){
        System.out.println("Saldo da conta: R$ "+getSaldo());
        System.out.println("Limite da conta: R$ "+ cc.getLimiteDisponivel());
    }
}