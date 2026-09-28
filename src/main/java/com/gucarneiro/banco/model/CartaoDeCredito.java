package com.gucarneiro.banco.model;

import com.gucarneiro.banco.exception.LimiteExcedidoException;

public class CartaoDeCredito {
    private String numeroCartao;
    private int codigoSeguranca;
    private String dataVencimento;
    private double limiteInicial;
    private double limiteDisponivel;
    private long qntdCompras;
    private int score;

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public int getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(int codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public double getLimiteInicial() {
        return limiteInicial;
    }

    public void setLimiteInicial(double limiteInicial) {
        this.limiteInicial = limiteInicial;
    }

    public double getLimiteDisponivel() {
        return limiteDisponivel;
    }

    public void setLimiteDisponivel(double limiteDisponivel) {
        this.limiteDisponivel = limiteDisponivel;
    }

    public long getQntdCompras() {
        return qntdCompras;
    }

    public void setQntdCompras(long qntdCompras) {
        this.qntdCompras = qntdCompras;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public CartaoDeCredito(String numeroCartao, int codigoSeguranca, String dataVencimento, double limiteInicial, long qntdCompras, int score) {
        this.numeroCartao = numeroCartao;
        this.codigoSeguranca = codigoSeguranca;
        this.dataVencimento = dataVencimento;
        this.limiteInicial = limiteInicial;
        this.limiteDisponivel = limiteInicial;
        this.qntdCompras = qntdCompras;
        this.score = score;
    }

    public CartaoDeCredito() {
    }

    public void realizarCompra(double valorCompra) {
        if (valorCompra > this.limiteDisponivel) {
            throw new LimiteExcedidoException("Valor da compra maior que o limite disponivel!");
        }
        if (qntdCompras == 0) {
            setLimiteDisponivel(getLimiteInicial() - valorCompra);
            qntdCompras++;
            setScore(getScore() + 10);

            System.out.println("Limite após compra no credito: R$ " + getLimiteDisponivel());
            System.out.println("Score atual: " + getScore() + "pts");
        } else {
            setLimiteDisponivel(getLimiteDisponivel() - valorCompra);
            qntdCompras++;
            setScore(getScore() + 10);

            System.out.println("Limite após compra no credito: R$ " + getLimiteDisponivel());
            System.out.println("Score atual: " + getScore() + "pts");
        }
        verificarScore(getScore());
    }

    public void verificarScore(int score) {
        if (score == 100) {
            setLimiteInicial(getLimiteInicial() + 150);
            setLimiteDisponivel(getLimiteDisponivel() + 150);
            System.out.println("Parabéns!! Seu limite aumento para: R$ " + getLimiteInicial());
            System.out.println("Seu limite atual é de: R$ " + getLimiteDisponivel());
        }
    }
}