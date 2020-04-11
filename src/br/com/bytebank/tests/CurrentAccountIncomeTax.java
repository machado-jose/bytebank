package br.com.bytebank.tests;

import br.com.bytebank.classes.Client;
import br.com.bytebank.classes.CurrentAccount;

public class CurrentAccountIncomeTax {

	public static void main(String[] args) {
		// Instanciando o cliente
		Client alberto = new Client("Alberto Carlos", "14944444478", "Mecânico");

		// Instanciando a conta
		CurrentAccount c1 = new CurrentAccount(6130, 124578, alberto);

		c1.deposit(250000);

		// Verificado o valor que deve ser pago para o imposto de renda
		System.out.println("Valor que deverá ser tributado no imposto de renda: " + c1.getIncomeTaxTotal());

	}

}
