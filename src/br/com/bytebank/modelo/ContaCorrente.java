package br.com.bytebank.modelo;

import br.com.bytebank.exceptions.SaldoInsuficienteException;
import br.com.bytebank.interfaces.Tributavel;

public class ContaCorrente extends Conta implements Tributavel {

	public ContaCorrente(int agencia, int numero, Cliente cliente) {
		super(agencia, numero, cliente);
	}

	@Override
	public void depositar(double valor) {
		super.saldo += valor;
	}
	
	@Override
	public boolean sacar(double valor) {
		return super.sacar(valor + valor * super.taxaOperacao("saque"));
	}
	
	@Override
	public boolean transferir(double valor, Conta destino) {
		return super.transferir(valor + valor * super.taxaOperacao("transferencia"), destino);
	}

	@Override
	public double getValorImposto() {
		return super.getSaldo() * 0.01;
	}

}
