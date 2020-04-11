package br.com.bytebank.classes;

import br.com.bytebank.exceptions.SaldoInsuficienteException;

public abstract class Account {

	protected double balance;
	private int branch;
	private int accountNumber;
	private Client client;
	private static int clientTotal;

	public Account(int branch, int accountNumber, Client client) {

		try {

			if (branch < 0 || accountNumber < 0)
				throw new IllegalArgumentException("Número da agência e/ou número da conta estão incorretos.");
			if (client.getCpf() == null)
				throw new IllegalArgumentException("O cliente não existe.");

			this.branch = branch;
			this.accountNumber = accountNumber;
			this.client = client;
			clientTotal++;

		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}

	}

	public abstract void deposit(double value);

	public abstract boolean transfer(double value, Account destiny);

	public abstract boolean withdrawal(double value);

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setBranch(int branch) {
		this.branch = branch;
	}

	public void accountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Client getClient() {
		return this.client;
	}

	public double getBalance() {
		return this.balance;
	}

	public int getAccountNumber() {
		return this.accountNumber;
	}

	public static int getTotal() {
		return clientTotal;
	}

	@Override
	public String toString() {
		if (this.accountNumber == 0) {
			return "Esta conta não existe.";
		} else {
			return "Agência: " + this.branch + "\nConta: " + this.accountNumber;
		}
	}
}
