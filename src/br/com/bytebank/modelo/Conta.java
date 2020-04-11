package br.com.bytebank.modelo;

import br.com.bytebank.exceptions.SaldoInsuficienteException;

public abstract class Conta {

	protected double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	private static int totalCliente;

	public Conta(int agencia, int numero, Cliente cliente) {

		try {

			if (agencia < 0 || numero < 0)
				throw new IllegalArgumentException("Número da agência e/ou número da conta estão incorretos.");
			if (cliente.getCpf() == null)
				throw new IllegalArgumentException("O cliente não existe.");

			this.agencia = agencia;
			this.numero = numero;
			this.titular = cliente;
			totalCliente++;

		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}

	}

	public abstract void depositar(double valor);

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	public Cliente getTitular() {
		return this.titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public int getNumero() {
		return numero;
	}

	public static int getTotal() {
		return totalCliente;
	}

	public boolean sacar(double valor) {

		try {

			if (this.saldo < valor)
				throw new SaldoInsuficienteException("Saldo insuficiente na conta para realizar essa operação.");
			this.saldo -= valor;
			return true;

		} catch (SaldoInsuficienteException e) {

			System.out.println(e);
			return false;

		}

	}

	public boolean transferir(double valor, Conta destino) {

		try {
			if (this.getSaldo() >= valor) {
				this.saldo -= valor;
				destino.depositar(valor);
				return true;
			} else {
				throw new SaldoInsuficienteException("Saldo insuficiente na conta para realizar essa operação.");
			}
		} catch (SaldoInsuficienteException e) {
			System.out.println(e);
			return false;
		}

	}

	// Remover -> Usar Enumerator e constantes
	protected double taxaOperacao(String tipo) {
		switch (tipo) {
		case "transferencia":
			return 0.1;
		case "saque":
			return 0.01;
		default:
			return 0;
		}
	}

	@Override
	public String toString() {
		if (this.numero == 0) {
			return "Esta conta não existe.";
		} else {
			return "Agência: " + this.agencia + "\nConta: " + this.numero;
		}
	}
}
