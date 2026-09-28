package com.gucarneiro.banco.model;

import com.gucarneiro.banco.exception.LimiteExcedidoException;

import java.math.BigDecimal;

public class CartaoDeCredito {
    private String numeroCartao;
    private String codigoSeguranca;
    private String dataVencimento;
    private BigDecimal limiteInicial;
    private BigDecimal limiteDisponivel;
    private long qntdCompras;
    private int score;

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(String codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public BigDecimal getLimiteInicial() {
        return limiteInicial;
    }

    public void setLimiteInicial(BigDecimal limiteInicial) {
        this.limiteInicial = limiteInicial;
    }

    public BigDecimal getLimiteDisponivel() {
        return limiteDisponivel;
    }

    public void setLimiteDisponivel(BigDecimal limiteDisponivel) {
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

    public CartaoDeCredito(String numeroCartao, String codigoSeguranca, String dataVencimento, BigDecimal limiteInicial, long qntdCompras, int score) {
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

    public void realizarCompra(BigDecimal valorCompra) {
        if (valorCompra.compareTo(this.limiteDisponivel) > 0) {
            throw new LimiteExcedidoException("Valor da compra maior que o limite disponivel!");
        }
        if (qntdCompras == 0) {
            this.limiteDisponivel = this.limiteInicial.subtract(valorCompra);
            qntdCompras++;
            this.score+=10;

            System.out.println("Limite após compra no credito: R$ " + getLimiteDisponivel());
            System.out.println("Score atual: " + getScore() + "pts");
        } else {
            this.limiteDisponivel = this.limiteDisponivel.subtract(valorCompra);
            qntdCompras++;
            this.score+=10;

            System.out.println("Limite após compra no credito: R$ " + this.limiteDisponivel);
            System.out.println("Score atual: " + this.score + "pts");
        }
        verificarScore(getScore());
    }

    public void verificarScore(int score) {
        if (score == 100) {
            this.limiteInicial.add(BigDecimal.valueOf(150));
            this.limiteDisponivel.add(BigDecimal.valueOf(150));
            System.out.println("Parabéns!! Seu limite aumento para: R$ " + getLimiteInicial());
            System.out.println("Seu limite atual é de: R$ " + getLimiteDisponivel());
        }
    }
}