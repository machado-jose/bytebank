package br.com.bytebank.classes;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import br.com.bytebank.exceptions.DuplicateBranchException;

public class Branch {

	private int numberBranch;
	private String address;

	private static Set<Branch> branchList = new HashSet<Branch>();

	public Branch(int numberBranch, String address) {

		try {

			if (numberBranch <= 0 || address == null || address.isEmpty())
				throw new NullPointerException("Os valores do número da conta e o endereço são obrigatórios.");

			this.numberBranch = numberBranch;
			this.address = address.toLowerCase();

			if (Branch.existsBranch(this)) {
				this.numberBranch = 0;
				this.address = null;
				throw new DuplicateBranchException("Número de Agência já existente.");
			}

			this.addBranchList();
		} catch (NullPointerException e) {
			System.out.println(e);
		} catch (DuplicateBranchException e) {
			System.out.println(e);
		}
	}

	private void addBranchList() {
		try {
			if (this.numberBranch <= 0 || this.address == null)
				throw new NullPointerException("Agência Inválida.");
			branchList.add(this);
		} catch (NullPointerException e) {
			System.out.println(e);
		}
	}

	public static Set<Branch> allBranches() {
		return Collections.unmodifiableSet(branchList);
	}

	public static boolean existsBranch(Branch branch) {
		return branchList.contains(branch);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numberBranch;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Branch other = (Branch) obj;
		if (numberBranch != other.numberBranch)
			return false;
		return true;
	}

	@Override
	public String toString() {
		if (this.numberBranch == 0 || this.address == null) {
			return "Agência inválida.";
		} else {
			return "Agência: " + this.numberBranch;
		}
	}
}
