package br.com.bytebank.tests;

import br.com.bytebank.classes.Client;
import br.com.bytebank.classes.Account;
import br.com.bytebank.classes.CurrentAccount;

public class AccountTest {

	public static void main(String[] args) {
		//Instaciando o cliente alberto
		Client alberto = new Client("", "14944444478", "Mecânico");
		//Instanciando c1
		CurrentAccount c1 = new CurrentAccount(6130, 124578, alberto);

		//Buscando o numero total de conta (Retirar esse método)
		System.out.println(c1.getTotal());
		
		System.out.println(c1);
	}

}
