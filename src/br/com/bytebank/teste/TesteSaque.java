package br.com.bytebank.teste;

import br.com.bytebank.modelo.Cliente;
import br.com.bytebank.modelo.ContaCorrente;

public class TesteSaque {

	public static void main(String[] args) {
		// Instanciando os clientes
		Cliente alberto = new Cliente("Alberto Carlos", "14944444478", "Mecânico");

		// Instanciando as contas para cada cliente
		ContaCorrente c1 = new ContaCorrente(6130, 124578, alberto);

		c1.depositar(250);

		// Realizando uma transferencia
		System.out.println(c1.sacar(125));
		System.out.println(c1.getSaldo());
	}

}
