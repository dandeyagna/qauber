package Max.Day13tasks;

//BankAccount Interface
public interface BankAccount {
	
	int withdrawFunds(int lastWithdrawal) throws InsufficientFunds;

	int depositFunds(int lastDeposit);

	public String printReport();
	
	String getBalance();
}
 