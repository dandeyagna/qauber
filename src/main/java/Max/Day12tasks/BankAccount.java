package Max.Day12tasks;

//BankAccount Interface
public interface BankAccount {
	
	int withdrawFunds(int lastWithdrawal);

	int depositFunds(int lastDeposit);

	public String printReport();
	
	String getBalance();
}
 