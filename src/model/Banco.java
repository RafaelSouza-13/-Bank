package model;
import java.util.ArrayList;
import java.util.List;

public class Banco {

	private String nome = "Bank";
	private List<Conta> contas = new ArrayList<>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public void adicionaConta(Conta conta){
		this.contas.add(conta);
	}

}