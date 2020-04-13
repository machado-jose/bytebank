package br.com.bytebank.exceptions;

public class DuplicateClientsException extends Exception {
	public DuplicateClientsException(String msg) {
		super(msg);
	}
}
