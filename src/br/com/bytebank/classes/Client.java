package br.com.bytebank.classes;

import java.util.HashSet;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.bytebank.exceptions.DuplicateClientsException;

public class Client {

	private String name;
	private String cpf;
	private String occupation;

	private static Set<Client> clientsList = new HashSet<Client>();

	public Client(String name, String cpf, String occupation) {

		try {

			if (name.isEmpty() || cpf.isEmpty() || occupation.isEmpty())
				throw new IllegalArgumentException("É necessário preencher todos os dados do cliente.");

			this.name = name.toLowerCase();
			this.cpf = cpf;
			this.occupation = occupation.toLowerCase();

			if (clientsList.contains(this)) {
				this.name = null;
				this.cpf = null;
				this.occupation = null;
				throw new DuplicateClientsException("Já existe um cliente registrado com os mesmos dados.");
			}

			this.addClientsList();

		} catch (IllegalArgumentException e) {

			System.out.println(e);

		} catch (DuplicateClientsException e) {
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

	private void addClientsList() {
		try {
			if (this.cpf == null || this.name == null || this.occupation == null)
				throw new NullPointerException("Cliente inválido.");
			clientsList.add(this);
		} catch (NullPointerException e) {
			System.out.println(e);
		}
	}

	public JSONObject getClientJson() {
		JSONObject client = new JSONObject();
		try {
			client.put("name", this.name);
			client.put("cpf", this.cpf);
			client.put("occupation", this.occupation);
		} catch (JSONException e) {
			System.out.println(e);
		}
		return client;
	}

	@Override
	public String toString() {
		if (this.cpf == null) {
			return "Cliente inválido.";
		} else {
			return "Cliente: " + this.name.toUpperCase() + ", CPF: " + this.cpf;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
