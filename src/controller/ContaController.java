package controller;

import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;
import utils.ContaException;

public class ContaController {
  public Conta criarConta(Cliente cliente, String tipoConta){
      if(tipoConta.equals("cc")){
        Conta contaCorrente = criaContaCorrente(cliente);
        return contaCorrente;
      }else{
        Conta contaPoupanca = criaContaPoupanca(cliente);
        return contaPoupanca;
      }
  }

  public boolean depositar(Conta conta, String entradaValor, BancoController bancoController){
    try{
      validaValor(entradaValor);
      double valor = Double.parseDouble(entradaValor);
      int posicao = bancoController.encontrarPosicaoConta(conta.getAgencia(), conta.getNumero());
      bancoController.deposito(posicao, valor);
      System.out.println("Deposito realizado com sucesso"); 
      return true;
    }catch(ContaException e){
      System.out.println(e);
      System.out.println("Valor inválido");
    }catch(NumberFormatException e){
      System.out.println("Somente números");
    }
    return false;
  }

  public boolean sacar(Conta conta, String entradaValor, BancoController bancoController){
    try{
      validaValor(entradaValor);
      double valor = Double.parseDouble(entradaValor);
      int posicao = bancoController.encontrarPosicaoConta(conta.getAgencia(), conta.getNumero());
      if(conta.getSaldo() >= valor){
        bancoController.saque(posicao, valor);
        System.out.println("Saque realizado com sucesso"); 
        return true;
      }else{
        System.out.println("Saldo insuficiente");
        return false;
      }
    }catch(ContaException e){
      System.out.println(e);
      System.out.println("Valor inválido");
    }catch(NumberFormatException e){
      System.out.println("Somente números");
    }
    return false;
  }

  public Conta conta(String entradaAgencia, String entradaNumero, BancoController bancoController){
      try{
        int agencia = Integer.parseInt(entradaAgencia);
        int numero = Integer.parseInt(entradaNumero);
        int posicao = bancoController.encontrarPosicaoConta(agencia, numero);
        Conta conta = bancoController.encontrarConta(posicao);
        return conta;
      }catch(NumberFormatException e){
        System.out.println("Os campos so aceitam entradas numéricas");
      }catch(ArrayIndexOutOfBoundsException e){
        System.out.println("Conta nao encontrada");
      }
      return null;
  }

  public void transferir(Conta origem, Conta destino, String entradaValor, BancoController bancoController){
    boolean sacou = sacar(origem, entradaValor, bancoController);
    if(sacou){
      depositar(destino, entradaValor, bancoController);
      System.out.println("Transferencia realizada com sucesso");
    }else{
      System.out.println("Saldo insuficiente para transferencia");
    }
  }

  public void exibeExtrato(Conta conta, BancoController bancoController){
      if(conta != null){
        conta.imprimirExtrato();
      }else{
        System.out.println("Conta não encontrada");
      }
  }

  private Conta criaContaCorrente(Cliente cliente){
    Conta contaCorrente = new ContaCorrente(cliente);
    System.out.println("Criando uma conta corrente");
    return contaCorrente;
  }

  private Conta criaContaPoupanca(Cliente cliente){
    Conta contaPoupanca = new ContaPoupanca(cliente);
    System.out.println("Criando uma conta poupança");
    return contaPoupanca;
  }

  private void validaValor(String entradaValor) throws ContaException{
    double valor = Double.parseDouble(entradaValor);
    if(valor <= 0){
      throw new ContaException("Não é aceito números negativos ou iguais a zero");
    }
  }
}
