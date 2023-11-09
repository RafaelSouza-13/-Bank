package controller;

import model.Cliente;
import utils.ClienteException;

public class ClienteController {

  public Cliente criaCliente(String nome, String entradaIdade){
    try{
      int idade = Integer.parseInt(entradaIdade);
      verificaNome(nome);
      verificaIdade(idade);
      Cliente cliente = new Cliente(nome, idade);
      return cliente;
    }catch(NumberFormatException e){
      System.out.println("O campo idade só aceita entradas numéricas");
    }catch(ClienteException e){
      System.out.println(e);
    }
    return null;
  }

  private void verificaNome(String nome) throws ClienteException{
    nome = nome.trim();
    if(nome.length() == 0){
      throw new ClienteException("O campo nome não pode estar vazio");
    }
    if(nome.length() < 3){
      throw new ClienteException("O campo nome deve conter no mínimo 3 caracteres");
    }
  }

  private void verificaIdade(int idade) throws ClienteException{
    if(idade < 18){
      throw new ClienteException("O campo idade inválido, para abrir uma conta é preciso ter mais de 18 anos");
    }
  }
}
