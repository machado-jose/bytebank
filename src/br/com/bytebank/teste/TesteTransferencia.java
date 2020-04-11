package br.com.bytebank.teste;

import br.com.bytebank.modelo.Cliente;
import br.com.bytebank.modelo.Conta;
import br.com.bytebank.modelo.ContaCorrente;

public class TesteTransferencia {

	public static void main(String[] args) {
		// Instanciando os clientes
		Cliente alberto = new Cliente("Alberto Carlos", "14944444478", "Mecânico");
		Cliente belchior = new Cliente("Belchior da Silva", "11114547441", "Cantor");

		// Instanciando as contas para cada cliente
		ContaCorrente c1 = new ContaCorrente(6130, 124578, alberto);
		ContaCorrente c2 = new ContaCorrente(6130, 521458, belchior);

		c1.depositar(250);
		c2.depositar(100);

		// Realizando uma transferencia
		System.out.println(c1.transferir(250, c2));
		System.out.println("C1: " + c1.getSaldo());
		System.out.println("C2: " + c2.getSaldo());

	}

}
