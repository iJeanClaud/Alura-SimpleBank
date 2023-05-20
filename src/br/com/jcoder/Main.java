package br.com.jcoder;

import java.util.Scanner;

public class Main {
    static String _nome;
    static String _tipoConta;
    static double _saldoInicial;

    String teste = "";

    public static void main(String[] args) {
        //Definir dados iniciais
        setNome("Jean");
        setTipoConta("Corrente");
        setSaldo(1200);

        // Mostra as informações iniciais do usuário
        mostrarInfoInicial();

        // Menu
        menu();
    }

    private static void mostrarInfoInicial(){
        System.out.print(
            "**************************\n" +
            "Dados iniciais do cliente:\n" +
            "Nome: " + _nome + "\n" +
            "Tipo conta: " + _tipoConta + "\n" +
            "Saldo inicial: R$ " + _saldoInicial + "\n" +
            "**************************\n\n"
        );
    }

    private static void menu(){

        System.out.print("Operações\n\n");

        while(true){
            System.out.print(
                "1- Consultar saldos\n" +
                "2- Depositar valor\n" +
                "3- Sacar valor\n" +
                "4- Sair\n\n"
            );
            System.out.println("Digite a opção desejada:");
            Scanner opcoes = new Scanner(System.in);
            int opDigitada = opcoes.nextInt();

            if(opDigitada < 1 || opDigitada > 3){
                if(opDigitada == 4){
                    System.exit(0);
                }
                System.out.print("[Erro!] Opção inválida! \n\n");
            }else{
                if(opDigitada == 1){consultarSaldo();}
                if(opDigitada == 2){depositarValor();}
                if(opDigitada == 3){sacarValor();}
            }

        }
    }

    private static void consultarSaldo(){
        System.out.print("Seu saldo atual é de: R$ " + _saldoInicial + "\n\n");

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void depositarValor(){
        Scanner input = new Scanner(System.in);
        System.out.print("Quanto deseja depositar?\n> R$ ");
        double novoValor = input.nextDouble();

        _saldoInicial += novoValor;
        System.out.print("Depósito realizado com sucesso!\nSeu novo saldo é de R$ " + _saldoInicial + "\n\n");

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void sacarValor(){
        Scanner in = new Scanner(System.in);
        System.out.print(
            "Saldo atual: " + _saldoInicial + "\n" +
            "Digite o valor que deseja sacar:\n" +
            "> R$");
        double valorSaque = in.nextDouble();

        if(valorSaque > _saldoInicial || valorSaque < 0){
            System.out.println("[Erro!] Você não pode sacar um valor superior ou inferior ao seu saldo!");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }else{
            _saldoInicial -= valorSaque;
            System.out.println("Saque realizado com sucesso!");
            System.out.print("Novo saldo: " + _saldoInicial + "\n\n");
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void setNome(String nome){_nome = nome;}
    private static void setTipoConta(String tipoConta){_tipoConta = tipoConta;}
    private static void setSaldo(double saldo){_saldoInicial = saldo;}
}
