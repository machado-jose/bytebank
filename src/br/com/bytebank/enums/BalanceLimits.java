package br.com.bytebank.enums;

public enum BalanceLimits {
	INCOME_TAX_LIMIT(20000);

	private double value;

	private BalanceLimits(double value) {
		this.value = value;
	}

	public double getValue() {
		return this.value;
	}
}
