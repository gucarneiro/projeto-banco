package com.gucarneiro.banco.main;

import com.gucarneiro.banco.exception.SaldoInsuficienteException;
import com.gucarneiro.banco.model.CartaoDeCredito;
import com.gucarneiro.banco.model.Cliente;
import com.gucarneiro.banco.model.ContaCorrente;
import com.gucarneiro.banco.model.Gerente;
import com.gucarneiro.banco.exception.ValorInvalidoException;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Gerente gerenteAdm = new Gerente();
        gerenteAdm.setLogin("adm");
        gerenteAdm.setSenha("admadm");

        Cliente cliente1 = new Cliente("12345", "gustavo carneiro", "gu@email.com", "2004-01-14");
        CartaoDeCredito cartao1 = new CartaoDeCredito("9876543210", 000, "2032-12", 200.0, 0, 0);
        ContaCorrente contaCorrente = new ContaCorrente(cliente1, 0.0, 4321, 1234, cartao1);


        try {
            contaCorrente.depositar(-50.0); // Vai lançar a exceção!
        } catch (ValorInvalidoException e) {
            System.out.println("Erro capturado: " + e.getMessage());
        }

        int opcao;
        do {
            System.out.print("1 - Login Gerente | 2 - Login Cliente | 0 - Sair\nOpcao: ");
            opcao = scan.nextInt();

            switch (opcao){
                case 1:
                    scan.nextLine();
                    System.out.print("login: ");
                    String login = scan.next();
                    System.out.print("Senha: ");
                    String senha = scan.next();

                    if (!login.equals(gerenteAdm.getLogin()) || !senha.equals(gerenteAdm.getSenha())){
                        System.out.println("Login ou senha incorretos.");
                    }
                    else {
                        int opcaoGerente;
                        do {
                            System.out.println("1 - Criar novo cliente | 2 - Localizar cliente | 3 - Consultar Score | 0 - Sair");
                            opcaoGerente = scan.nextInt();

                            switch (opcaoGerente){
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                default:
                                    if (opcaoGerente != 0){
                                        System.out.println("Opcao invalida!");
                                    }
                            }
                        } while (opcaoGerente != 0);
                    }
                    break;
                case 2:
                    scan.nextLine();
                    System.out.print("Digite o CPF: ");
                    String cpf = scan.nextLine();
                    System.out.print("Digite a senha: ");
                    int senhaCliente = scan.nextInt();
                    if (!cpf.equals(cliente1.getCpf()) || senhaCliente != contaCorrente.getSenha()){
                        System.out.println("CPF ou senha incorretos.");
                    }
                    else {
                        int opcaoGerente;
                        do {
                            System.out.println("1 - Acessar Saldo | 2 - Depositar | 3 - Sacar | 4 - Comprar no Credito | 5 - 10 compras | 0 - Sair");
                            opcaoGerente = scan.nextInt();

                            switch (opcaoGerente){
                                case 1:
                                    contaCorrente.acessarSaldo();
                                    break;
                                case 2:
                                    System.out.print("Informe o valor de deposito: R$");
                                    double valorDeposito = scan.nextDouble();

                                    try {
                                        contaCorrente.depositar(valorDeposito);
                                    }
                                    catch (ValorInvalidoException e) {
                                        System.out.println("Erro capturado: " + e.getMessage());
                                    }
                                    break;
                                case 3:
                                    System.out.print("Informe o valor de saque: R$");
                                    double valorSaque = scan.nextDouble();

                                    try {
                                        contaCorrente.sacar(valorSaque);
                                    }
                                    catch (SaldoInsuficienteException e){
                                        System.out.println("Aviso de saldo: " + e.getMessage());
                                    }
                                    catch (ValorInvalidoException e){
                                        System.out.println("Erro capturado: " + e.getMessage());
                                    }

                                    break;
                                case 4:
                                    System.out.print("Informe o valor da compra a ser feita: R$");
                                    double valorCompra = scan.nextDouble();

                                    contaCorrente.getCc().realizarCompra(valorCompra);
                                    break;
                                case 5:
                                    System.out.println("Simulação de 10 compras no credito: \n");
                                    for (int i = 0; i < 10; i++){
                                        contaCorrente.getCc().realizarCompra(10);
                                        System.out.println("\n--------------------------\n");
                                    }
                                    break;
                                default:
                                    if (opcaoGerente != 0){
                                        System.out.println("Opcao invalida!");
                                    }
                            }
                        } while (opcaoGerente != 0);
                    }
                    break;
                default:
                    if (opcao != 0){
                        System.out.println("Opcao invalida!");
                    }
            }
        } while (opcao != 0);
        System.out.println("Encerrando...");
    }
}
