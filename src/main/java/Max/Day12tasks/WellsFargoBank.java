package Max.Day12tasks;

//WellsFargoBank class (2 of 2)
public class WellsFargoBank implements BankAccount  {
	
	public String accountHolder;
	public int balance;
	public int accountNumber;
	public String accountType;
	public static int lastWithdrawal;
	public static int lastDeposit;
	
	public WellsFargoBank(String accountHolder, int balance, int accountNumber, String accountType) {
		this.accountHolder = accountHolder;
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
	}
		

	@Override
	public String printReport() {
		return "\"This \" + accountType + \" WellsFargo account with account #\" + accountNumber + \" belongs to \" + accountHolder. The current balance is $\" + balance";
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

	@Override  // 
	public int hashCode() { 
	  return accountNumber;
	}

	
}
