package Models;

public class Account {

	private float customer_id;
	private float account_id;
	private double account_balance;
	
	
	public Account(){
		
	}
	public float GetCustomerId(){
		return customer_id;
	}
	
	public float GetAccountId() {
		return account_id;
	}
	
	public double GetAccountBalance() {
		return account_balance;
	}
	
	public void SetAccountId(float ac_id) {
		this.account_id = ac_id;
	}
	
	public void SetAccountBalance(double ac_balance) {
		this.account_balance += ac_balance;
	}
	
	public void SetCustomerId(float id) {
		this.customer_id = id;
	}
}
