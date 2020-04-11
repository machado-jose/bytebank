package br.com.bytebank.modelo;

import java.util.HashSet;

public class Cliente {

	private String nome;
	private String cpf;
	private String profissao;

	public Cliente(String nome, String cpf, String profissao) {

		try {

			if (nome.isEmpty() || cpf.isEmpty() || profissao.isEmpty())
				throw new IllegalArgumentException("É necessário preencher todos os dados do cliente.");

			this.nome = nome.toLowerCase();
			this.cpf = cpf;
			this.profissao = profissao.toLowerCase();

		} catch (IllegalArgumentException e) {

			System.out.println(e);

		}

	}

	public void setNome(String nome) {
		this.nome = nome.toLowerCase();
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao.toLowerCase();
	}

	public String getNome() {
		return this.nome.toUpperCase();
	}

	public String getCpf() {
		return this.cpf;
	}

	@Override
	public String toString() {
		if (this.cpf == null) {
			return "Este cliente não existe";
		} else {
			return "Cliente: " + this.nome.toUpperCase() + ", CPF: " + this.cpf;
		}
	}

}
