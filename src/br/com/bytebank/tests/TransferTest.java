package br.com.bytebank.tests;

import br.com.bytebank.classes.Client;
import br.com.bytebank.classes.Account;
import br.com.bytebank.classes.CurrentAccount;

public class TransferTest {

	public static void main(String[] args) {
		// Instanciando os clientes
		Client alberto = new Client("Alberto Carlos", "14944444478", "Mecânico");
		Client belchior = new Client("Belchior da Silva", "11114547441", "Cantor");

		// Instanciando as contas para cada cliente
		CurrentAccount c1 = new CurrentAccount(6130, 124578, alberto);
		CurrentAccount c2 = new CurrentAccount(6130, 521458, belchior);

		c1.deposit(-1);
		c2.deposit(100);

		// Realizando uma transferencia
		System.out.println(c1.transfer(150, c2));
		System.out.println("C1: " + c1.getBalance());
		System.out.println("C2: " + c2.getBalance());

	}

}
