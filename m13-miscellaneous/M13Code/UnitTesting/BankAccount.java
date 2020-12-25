

public class BankAccount {
	
	private double balance;
	
	public BankAccount(double balance) {
		this.balance = balance;
	}
	
	public void deposit(double amount) {
		if(amount > 0) {
			balance += amount;
		} 
	}
	
	public void withdraw(double amount) {
		if(amount > 0 && amount <= balance) {
			balance -= amount;
		}	
	}

	public double getBalance() {
		return balance;
	}

}
