package com.gucarneiro.banco.model;

public class Cliente {
    private String nome;
    private String email;
    private String dataNascimento;
    private String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Cliente(String cpf, String nome, String email, String dataNascimento) {
        setCpf(cpf);
        setNome(nome);
        setEmail(email);
        setDataNascimento(dataNascimento);
    }

    public Cliente (){}
}