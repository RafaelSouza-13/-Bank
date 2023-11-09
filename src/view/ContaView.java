package view;

import java.util.Scanner;

import controller.BancoController;
import controller.ContaController;
import model.Conta;

public class ContaView {
  public void depositar(Scanner scanner, ContaController contaController, BancoController bancoController){
    System.out.print("Agencia da conta: ");
    String entradaAgencia = scanner.nextLine();
    System.out.print("Número da conta: ");
    String entradaNumero = scanner.nextLine();
    System.out.print("Valor: ");
    String entradaValor = scanner.nextLine();
    Conta conta = contaController.conta(entradaAgencia, entradaNumero, bancoController);
    if(conta != null){
      System.out.println("Deposito na conta do titular: "+conta.titular());
      System.out.println("s - confirmar");
      System.out.println("n - cancelar");
      System.out.print("confirmação: ");
      String confirmacao = scanner.nextLine().toLowerCase();
      switch (confirmacao) {
        case "s":
          contaController.depositar(conta, entradaValor, bancoController);
          break;
        default:
          System.out.println("Deposito cancelado");
          break;
      }
    }
  }

  public void sacar(Scanner scanner, ContaController contaController, BancoController bancoController){
    System.out.print("Agencia da conta: ");
    String entradaAgencia = scanner.nextLine();
    System.out.print("Número da conta: ");
    String entradaNumero = scanner.nextLine();
    System.out.print("Valor: ");
    String entradaValor = scanner.nextLine();
    Conta conta = contaController.conta(entradaAgencia, entradaNumero, bancoController);
    if(conta != null){
      contaController.sacar(conta, entradaValor, bancoController);
    }
  }

  public void transferir(Scanner scanner, ContaController contaController, BancoController bancoController){
    System.out.print("Agencia do origem: ");
    String agenciaOrigem = scanner.nextLine();
    System.out.print("Número da origem: ");
    String numeroOrigem = scanner.nextLine();
    System.out.print("Valor: ");
    String entradaValor = scanner.nextLine();
    System.out.print("Agencia de destino: ");
    String agenciaDestino = scanner.nextLine();
    System.out.print("Número de destino: ");
    String numeroDestino = scanner.nextLine();
    Conta origem = contaController.conta(agenciaOrigem, numeroOrigem, bancoController);
    Conta destino = contaController.conta(agenciaDestino, numeroDestino, bancoController);
    if(origem != null){
      if(destino != null){
        if(origem == destino){
          System.out.println("Não pode realizar transferencia para voce mesmo");
        }else{
          contaController.transferir(origem, destino, entradaValor, bancoController);
        }
      }else{
        System.out.println("Conta de destino nao encontrada"); 
      }
    }else{
      System.out.println("Conta de origem nao encontrada");
    }
  }

  public void extrato(Scanner scanner, ContaController contaController, BancoController bancoController){
    System.out.print("Agencia da conta: ");
    String agenciaOrigem = scanner.nextLine();
    System.out.print("Número da conta: ");
    String numeroOrigem = scanner.nextLine();
    Conta conta = contaController.conta(agenciaOrigem, numeroOrigem, bancoController);
    contaController.exibeExtrato(conta, bancoController);
  }
}
