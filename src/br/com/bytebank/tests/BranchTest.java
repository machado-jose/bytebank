package br.com.bytebank.tests;

import br.com.bytebank.classes.Branch;

public class BranchTest {

	public static void main(String[] args) {

		Branch branch1 = new Branch(6130, "rua a");
		Branch branch2 = new Branch(1254, "rua b");
		Branch branch3 = new Branch(6130, "rua c");

		System.out.println(Branch.allBranches());
		System.out.println(branch3);
	}

}
