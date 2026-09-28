package com.gucarneiro.banco.model;

import com.gucarneiro.banco.exception.SaldoInsuficienteException;
import com.gucarneiro.banco.exception.ValorInvalidoException;

public abstract class Conta {
    Cliente cliente = new Cliente();

    private double saldo;
    private int numeroConta;
    private int senha;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public Conta(Cliente cliente, double saldo, int numeroConta, int senha) {
        setCliente(cliente);
        setSaldo(saldo);
        setNumeroConta(numeroConta);
        setSenha(senha);
    }

    public Conta() {
    }

    public void acessarSaldo() {
        System.out.println("Saldo da conta: R$ " + this.saldo);
    }

    public void depositar(double valorDeposito) {
        if (valorDeposito <= 0) {
            throw new ValorInvalidoException("O valor de deposito deve ser maior que 0!");
        }

        this.saldo += valorDeposito;
        System.out.println("Saldo após deposito: R$ " + this.saldo);
    }

    public void sacar(double valorSaque) {
        if (valorSaque <= 0) {
            throw new ValorInvalidoException("O valor de saque deve ser maior que 0!");
        }
        else if (valorSaque > this.saldo) {
            throw new SaldoInsuficienteException("O valor de saque é maior que o saldo da conta! Saldo insuficiente!");
        }
        saldo -= valorSaque;
        System.out.println("Saldo após saque: R$ " + getSaldo());
    }

    public void pagarBoleto() {
        //todo
    }
}