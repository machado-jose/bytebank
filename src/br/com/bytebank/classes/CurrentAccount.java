package br.com.bytebank.classes;

import br.com.bytebank.enums.BalanceLimits;
import br.com.bytebank.enums.Taxs;
import br.com.bytebank.exceptions.SaldoInsuficienteException;
import br.com.bytebank.interfaces.Tributavel;

public class CurrentAccount extends Account implements Tributavel {

	public CurrentAccount(int agencia, int numero, Client cliente) {
		super(agencia, numero, cliente);
	}

	@Override
	public void deposit(double value) {
		this.balance += value;
	}

	@Override
	public boolean withdrawal(double value) {

		try {

			if (this.balance < value * (1 + Taxs.WITHDRAWAL_TAX.getTax()))
				throw new SaldoInsuficienteException("Saldo insuficiente na conta para realizar essa operação.");
			this.balance -= value * (1 + Taxs.WITHDRAWAL_TAX.getTax());
			return true;

		} catch (SaldoInsuficienteException e) {

			System.out.println(e);
			return false;

		}
	}

	@Override
	public boolean transfer(double value, Account destination) {

		try {
			if (this.getBalance() >= value * (1 + Taxs.TRANSFER_TAX.getTax())) {
				this.balance -= value * (1 + Taxs.TRANSFER_TAX.getTax());
				destination.deposit(value);
				return true;
			} else {
				throw new SaldoInsuficienteException("Saldo insuficiente na conta para realizar essa operação.");
			}
		} catch (SaldoInsuficienteException e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public double getIncomeTaxTotal() {

		if (this.getBalance() >= BalanceLimits.INCOME_TAX_LIMIT.getValue()) {
			return this.getBalance() * Taxs.INCOME_TAX.getTax();
		} else {
			return 0;
		}

	}

}
