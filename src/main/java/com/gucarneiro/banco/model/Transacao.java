package com.gucarneiro.banco.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transacao {
    private BigDecimal valor;
    private TipoTransacao tipo;
    private LocalDateTime dataHora;

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransacao tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Transacao(BigDecimal valor, TipoTransacao tipo) {
        this.valor = valor;
        this.tipo = tipo;
        this.dataHora = LocalDateTime.now();
    }
}
