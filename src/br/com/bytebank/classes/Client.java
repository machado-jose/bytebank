package br.com.bytebank.classes;

import java.util.HashSet;

public class Client {

	private String name;
	private String cpf;
	private String occupation;

	public Client(String name, String cpf, String occupation) {

		try {

			if (name.isEmpty() || cpf.isEmpty() || occupation.isEmpty())
				throw new IllegalArgumentException("É necessário preencher todos os dados do cliente.");

			this.name = name.toLowerCase();
			this.cpf = cpf;
			this.occupation = occupation.toLowerCase();

		} catch (IllegalArgumentException e) {

			System.out.println(e);

		}

	}

	public void setName(String name) {
		this.name = name.toLowerCase();
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation.toLowerCase();
	}

	public String getName() {
		return this.name.toUpperCase();
	}

	public String getCpf() {
		return this.cpf;
	}

	@Override
	public String toString() {
		if (this.cpf == null) {
			return "Este cliente não existe";
		} else {
			return "Cliente: " + this.name.toUpperCase() + ", CPF: " + this.cpf;
		}
	}

}
