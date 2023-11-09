package view;

import java.util.Scanner;

import controller.BancoController;

public class BancoView {
  public String menu(Scanner scanner){
    System.out.println();
    System.out.println("1 - Criar uma conta");
    System.out.println("2 - Depositar");
    System.out.println("3 - Sacar");
    System.out.println("4 - Transferir");
    System.out.println("5 - Extrato");
    System.out.println("6 - Listar contas");
    System.out.println("0 - Encerrar o programa");
    System.out.print("Opção: ");
    String escolha = scanner.nextLine();
    System.out.println();
    return escolha;
  }
  public void exibeContas(BancoController bancoController){
    bancoController.exibeContas();
  }
}
