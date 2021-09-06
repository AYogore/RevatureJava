package Models;

public class Customer {

	private String name;
	
	private float customerId;
	
	public Customer()
	{}
	
	public Customer(String n, float cid) {
		this.name = n;
		this.customerId = cid;
	}
	
	public String GetName(){
		return name;
	}
	
	public float GetCustomerId(){
		return customerId;
	}
	
	
	
	public void SetName(String n) {
		this.name = n;
	}
	
	
	public void SetCustomerId(float f) {
		this.customerId = f;
	}
}
