package br.com.bytebank.enums;

public enum Taxs {

	WITHDRAWAL_TAX(0.01), TRANSFER_TAX(0.1), INCOME_TAX(0.04);

	private double tax;

	Taxs(double tax) {
		this.tax = tax;
	}

	public double getTax() {
		return this.tax;
	}
}
