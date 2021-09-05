package Models;

public class Account {

	private String account_id;
	private double account_balance;
	
	
	
	public Account(String ac_id, double ac_balance){
		this.account_id = ac_id;
		this.account_balance = ac_balance;
	}
	
	public String GetAccountId() {
		return account_id;
	}
	
	public double GetAccountBalance() {
		return account_balance;
	}
	
	public void SetAccountId(String ac_id) {
		this.account_id = ac_id;
	}
	
	public void SetAccountBalance(double ac_balance) {
		this.account_balance += ac_balance;
	}
}
