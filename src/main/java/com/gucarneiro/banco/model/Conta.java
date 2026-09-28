package com.gucarneiro.banco.model;

import com.gucarneiro.banco.exception.SaldoInsuficienteException;
import com.gucarneiro.banco.exception.SenhaIncorretaException;
import com.gucarneiro.banco.exception.ValorInvalidoException;

import java.math.BigDecimal;

public abstract class Conta {
    Cliente cliente = new Cliente();

    private BigDecimal saldo;
    private int numeroConta;
    private int senha;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
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

    public Conta(Cliente cliente, BigDecimal saldo, int numeroConta, int senha) {
        setCliente(cliente);
        setSaldo(saldo);
        setNumeroConta(numeroConta);
        setSenha(senha);
    }

    public Conta() {
    }

    public void depositar(BigDecimal valorDeposito) {
        if (valorDeposito.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValorInvalidoException("O valor de deposito deve ser maior que 0!");
        }

        saldo = saldo.add(valorDeposito);
    }

    public void sacar(BigDecimal valorSaque, int senha) {
        if (valorSaque.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValorInvalidoException("O valor de saque deve ser maior que 0!");
        }
        else if (valorSaque.compareTo(this.saldo) > 0) {
            throw new SaldoInsuficienteException("O valor de saque é maior que o saldo da conta! Saldo insuficiente!");
        }
        if (senha != this.senha){
            throw new SenhaIncorretaException("Senha incorreta!");
        }
        saldo = saldo.subtract(valorSaque);
    }

    public void pagarBoleto() {
        //todo
    }
}