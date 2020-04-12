package br.com.bytebank.exceptions;

public class DuplicateBranchException extends Exception {
	public DuplicateBranchException(String msg) {
		super(msg);
	}
}
