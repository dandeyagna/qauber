//ChaseBank class (1 of 2)
public class ChaseBank implements BankAccount {
	public String accountHolder;
	public int balance;
	public int accountNumber;
	public String accountType;
	public int lastWithdrawal;
	public int lastDeposit;
	
	public ChaseBank(String accountHolder, int balance, int accountNumber, String accountType) {
		this.accountHolder = accountHolder;
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
	}
	
	@Override
	public String printReport() {
		System.out.println("This " + accountType + " Chase account with account #" + accountNumber + " belongs to " + accountHolder);
		System.out.println("The current balance is $" + balance);
		return "";
	}

	@Override
	public int depositFunds(int lastDeposit) {
		balance = balance + lastDeposit;
		//System.out.println("The last deposit was $" + lastDeposit + " which brings the current balance up to $" + balance);
		return balance;
	}

	@Override
	public int withdrawFunds(int lastWithdrawal) {
		balance = balance - lastWithdrawal;
		//System.out.println("The last withdrawal was $" + lastWithdrawal + " which brings the current balance down to $" + balance);
		return balance;
	}
	
	public String getBalance() {
		return Integer.toString(balance);
	}

	public int hashCode() { 
		return accountNumber;
	}

}
