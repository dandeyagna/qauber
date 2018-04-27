package Max.Day13tasks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestBank {
	public static void main(String[] args) throws InsufficientFunds {
		
		//Objects of ChaseBank and WellsFargo bank called "chase1, wells1, chase2, etc" with Static type "BankAccount" 
		BankAccount chase1 = new ChaseBank("Max Zinovskiy", 10000, 1114567, "Checking");
		BankAccount wells1 = new WellsFargoBank("Max Zinovskiy", 50000, 2225212, "Savings");		
		BankAccount chase2 = new ChaseBank("Mark Simpson", 10000, 1234567, "Checking");
		BankAccount wells2 = new WellsFargoBank("John Doe", 50000, 44445212, "Savings");		
		BankAccount chase3 = new ChaseBank("Mark Simpson", 10000, 1234567, "Checking");	
		BankAccount wells3 = new WellsFargoBank("Jane Doe", 50000, 6665212, "Savings");
		
		//Depositing some funds, why not?
		chase1.depositFunds(1000000);
		chase2.depositFunds(133000);
		wells2.depositFunds(4400);
		
		try {
			wells1.withdrawFunds(1000000);
		}catch(InsufficientFunds NSF) {
			System.out.println("EXCEPTION: YOU ARE OVERDRAWN!!! ");
		}
		
		try {
			chase3.withdrawFunds(55500);
		}catch(InsufficientFunds NSF) {
			System.out.println("EXCEPTION: YOU ARE OVERDRAWN!!! ");
		}
		try {
			wells3.withdrawFunds(66000);
		}catch(InsufficientFunds NSF) {
			System.out.println("EXCEPTION: YOU ARE OVERDRAWN!!! ");
		}
		//ArrayList called accountList that I add the return of the getBalance() functions from my classes
		List <String> accountList = new ArrayList<String>();
		accountList.add(chase1.getBalance());
		accountList.add(wells1.getBalance());
		accountList.add(chase2.getBalance());
		accountList.add(wells2.getBalance());
		accountList.add(chase3.getBalance());
		accountList.add(wells3.getBalance());
		
		//Prints out the accountList arrayList
		System.out.println("arrayList with all the balances of my 6 accounts: " + accountList);
		
		//a "for" loop to iterate through the elements in my arrayList and add them 1 by 1 to the local total variable
		int total = 0;
		//loop starts with 0; and goes until the number of elements in the accountList array;  incrementing by one
		for (int i = 0; i < accountList.size(); i++) {
			total = total + Integer.parseInt(accountList.get(i));
			//System.out.println(accountList.get(i));
		}
		//print out the final total of all the accounts
		System.out.println("Total of all accounts: $" + total);
		
		//Adding all the account numbers to a HashSet, which will automatically remove the duplicate "Mark Simpson" by account number 1234567
		Set<Integer> accountSet = new HashSet<Integer>();
		accountSet.add(chase1.hashCode());
		accountSet.add(chase2.hashCode());
		accountSet.add(chase3.hashCode());
		accountSet.add(wells1.hashCode());
		accountSet.add(wells2.hashCode());
		accountSet.add(wells3.hashCode());

		//After printing this line, it only shows 5 accounts instead of 6 because it removed the duplicates.
		System.out.println("Remaining unique account numbers after hash list: " + accountSet);
		

	}
}
