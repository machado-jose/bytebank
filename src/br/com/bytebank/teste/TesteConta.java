package br.com.bytebank.teste;

import br.com.bytebank.modelo.Cliente;
import br.com.bytebank.modelo.Conta;
import br.com.bytebank.modelo.ContaCorrente;

public class TesteConta {

	public static void main(String[] args) {
		//Instaciando o cliente alberto
		Cliente alberto = new Cliente("", "14944444478", "Mecânico");
		//Instanciando c1
		ContaCorrente c1 = new ContaCorrente(6130, 124578, alberto);

		//Buscando o numero total de conta (Retirar esse método)
		System.out.println(c1.getTotal());
		
		System.out.println(c1);
	}

}
