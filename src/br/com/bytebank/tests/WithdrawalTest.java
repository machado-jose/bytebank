package br.com.bytebank.tests;

import br.com.bytebank.classes.Client;
import br.com.bytebank.classes.CurrentAccount;

public class WithdrawalTest {

	public static void main(String[] args) {
		// Instanciando o cliente
		Client alberto = new Client("Alberto Carlos", "14944444478", "Mecânico");

		// Instanciando a conta
		CurrentAccount c1 = new CurrentAccount(6130, 124578, alberto);

		c1.deposit(250);

		// Realizando um depósito
		System.out.println(c1.withdrawal(150));
		System.out.println(c1.getBalance());
	}

}
