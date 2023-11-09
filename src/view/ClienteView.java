package view;
import java.util.Scanner;

import controller.BancoController;
import controller.ClienteController;
import controller.ContaController;
import model.Cliente;
import model.Conta;

public class ClienteView {
  public void cadastrarCliente(Scanner scanner, ClienteController clienteController, ContaController contaController, BancoController bancoController){
    System.out.print("Digite o nome do cliente: ");
    String nome = scanner.nextLine();
    System.out.print("Idade: ");
    String idade = scanner.nextLine();
    System.out.println("cc - conta corrente");
    System.out.println("cp - conta poupança");
    System.out.print("Tipo da conta: ");
    String tipoConta = scanner.nextLine();
    if(tipoConta.equals("cc") || tipoConta.equals("cp")){
        Cliente cliente = clienteController.criaCliente(nome, idade);
        if(cliente != null){
          Conta conta = contaController.criarConta(cliente, tipoConta);
          bancoController.cadastrarConta(conta);
        }else{
           System.out.println("Não foi possivel criar uma conta");
        }
    }else{
        System.out.println("Opção de conta inválida");
    }
  }
}
