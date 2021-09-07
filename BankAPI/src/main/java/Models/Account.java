package Models;

public class Account {

	private float customer_id;
	private String account_id;
	private double account_balance;
	
	
	public Account(float c_id){
		this.customer_id = c_id;
	}
	public float GetCustomerId(){
		return customer_id;
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
