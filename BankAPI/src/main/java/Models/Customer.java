package Models;

public class Customer {

	private String firstName;
	private String lastName;
	
	private float customerId;
	
	public Customer()
	{}
	
	public Customer(String fn, String ln, float cid) {
		this.firstName = fn;
		this.lastName = ln;
		this.customerId = cid;
	}
	
	public String GetName(){
		return firstName + " " + lastName;
	}
	
	public float GetCustomerId(){
		return customerId;
	}
	
	public void SetLastName(String ln){
		this.lastName = ln;
	}
	
	public void SetFirstName(String fn) {
		this.firstName = fn;
	}
}
