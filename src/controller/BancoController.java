package controller;

import java.util.List;

import model.Banco;
import model.Conta;

public class BancoController {
  Banco banco = new Banco();
  public void cadastrarConta(Conta conta){
    banco.adicionaConta(conta);
    System.out.println("Conta cadastrada no sistema");
  }

  public void exibeContas(){
    List<Conta> contas = banco.getContas();
    if(contas.size() == 0){
      System.out.println("Não há contas registradas");
    }else{
      for(Conta conta : contas){
        conta.imprimirExtrato();
        System.out.println("");
      }
    }
  }


  public int encontrarPosicaoConta(int agencia, int numero){
    List<Conta> contas = banco.getContas();
    for(Conta conta : contas){
      if(conta.getAgencia() == agencia && conta.getNumero() == numero){
        return contas.indexOf(conta);
      }
    }
    return -1;
  }

  public Conta encontrarConta(int posicao){
    List<Conta> contas = banco.getContas();
    return contas.get(posicao);
  }
  

  public Conta deposito(int posicao, double valor){
    List<Conta> contas = banco.getContas();
    Conta conta = contas.get(posicao);
    conta.depositar(valor);
    contas.set(posicao, conta);
    return conta;
  }

  public Conta saque(int posicao, double valor){
    List<Conta> contas = banco.getContas();
    Conta conta = contas.get(posicao);
    conta.sacar(valor);
    contas.set(posicao, conta);
    return conta;
  }
}
