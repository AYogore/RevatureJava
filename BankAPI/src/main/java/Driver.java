
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.AccountDAO;
import DAO.CustomerDAO;
import DAO.Dao;
import Models.Account;
import Models.Customer;
import Utils.ConnectionFactory;
import io.javalin.Javalin;


public class Driver {
	
	private static Dao<Customer> CustomerDAO;
	private static Dao<Account> AccountDAO;

	public static void main(String[] args) {
		//SQL Database Connection
		//Postman connection
		Javalin app = Javalin.create().start(7000);
		//ConnectDatabase();
		Connection con = ConnectionFactory.getConnection();
		CustomerDAO = new CustomerDAO(con);
		AccountDAO = new AccountDAO(con);
		
		
		//Postman commands
		app.get("/", ctx -> ctx.result("Hello World"));
		app.post("/send-data", ctx -> {
			System.out.println(ctx.body());
			//System.out.println(eee.body());
			});
		
		app.get("/hello", eee-> eee.html("Hello Javelin!"));
		app.get("/exception",ctx -> {
			throw new Exception("test");
			});
		//GET ALL CLIENTS
		app.get("/clients", ctx -> {
			//clients.result(PrintCustomers());
			ctx.result(CustomerDAO.getAll());
			
			//String s = CustomerDAO.
		});
		//GET CLIENT OF ID
		app.get("/clients/:id", ctx -> {
			try {
				int id = Integer.parseInt(ctx.pathParam("id"));
				Customer c = CustomerDAO.get(id);
				ctx.result(c.GetName());
			} catch (Exception e) {
				ctx.status(404);
				ctx.result("Client does not exist");
				e.printStackTrace();
			}
			//PrintCustomer(clients.pathParam("id"));
		});
		
		//CREATE NEW CLIENT
		app.post("/clients", ctx -> {
			//make new
			ctx.result("Made new client:" + ctx.body());
			ctx.status(201);
			Customer c = new Customer();
			c.SetName(ctx.body());
			System.out.println(c.GetName());
			//parse body
 			CustomerDAO.save(c);
			
		});
		
		//UPDATE CLIENT
		app.put("/clients/:id", ctx -> {
			//UPDATE
			try {
				int id = Integer.parseInt(ctx.pathParam("id"));
				Customer c = CustomerDAO.get(id);
	 			String[] str = ctx.body().split("\n");

				CustomerDAO.update(c, str);
				//run update method
				
				ctx.result(c.GetName());
			} catch (Exception e) {
				ctx.status(404);
				ctx.result("Client does not exist");
				e.printStackTrace();
			}
		});
		
		//DELETE
		//================================================
		app.delete("/clients/:id", ctx -> {
			try {
				int id = Integer.parseInt(ctx.pathParam("id"));
				Customer c = CustomerDAO.get(id);

				CustomerDAO.delete(c);
				
				ctx.result(c.GetName() + "has been deleted");
			} catch (Exception e) {
				ctx.status(404);
				ctx.result("Client does not exist");
				e.printStackTrace();
			}
		});
		
		//CREATE NEW ACCOUNT FOR CLIENT ID
		app.post("/clients/:id/accounts", ctx ->{
			try {
				int id = Integer.parseInt(ctx.pathParam("id"));
				Customer c = CustomerDAO.get(id);
				ctx.status(201);
				
				Account a = new Account(c.GetCustomerId());
				System.out.println(c.GetName() + "has made a new account");
				//CREATE ACCOUNT
				AccountDAO.save(a);
			} catch (Exception e) {
				ctx.status(404);
				ctx.result("Cannot make account for error: Client does not exist");
				e.printStackTrace();
			}
		});
		
		app.get("/clients/:id/accounts", ctx ->{
			try {
				int id = Integer.parseInt(ctx.pathParam("id"));
				Customer c = CustomerDAO.get(id);
				System.out.println("Showing all accounts of " + c.GetName());
				//Print Accounts
				ctx.result(AccountDAO.getAll());
			} catch (Exception e) {
				ctx.status(404);
				ctx.result("Client does not exist");
				e.printStackTrace();
			}
		});
		
		app.get("/runmethod", ctx -> {
		RunMethod();
		});
		
			
		
		//app.error(e)
		
		}
	public static String PrintCustomers() {
		Connection con = ConnectionFactory.getConnection();//"jdbc:mariadb://database-1.ct4rayfqtdoi.us-east-2.rds.amazonaws.com:3306/innodb?user=admin&password=Csamoan75");
		//"jdbc:mariadb://<RDS ENDPOINT FROM AWS RDS SERVICE>:<port>/<DATABASE NAME>?user=<USER NAME>&password=<PASSWORD>"
		//notation for URI in getConnection method
		String sql = "SELECT * FROM customers";
		StringBuilder sb = new StringBuilder("==========Customers==========");
		sb.append("\n    ID          Name       ");
		///=====================Customers==========
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			//System.out.println("==========Customers==========");
			while(rs.next()) {
				//invoke once since you start before the 1st and not on the 1st result
				//first invoke advances to 1st element
				sb.append("\nid: ["
						+ rs.getInt("customer_id")
						+ "] name: ["
						+ rs.getString("name")
						+ "]");
				
			}
			sb.append("\n==========Customers==========");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public static void PrintCustomer(String id) {
		Connection con = ConnectionFactory.getConnection();//"jdbc:mariadb://database-1.ct4rayfqtdoi.us-east-2.rds.amazonaws.com:3306/innodb?user=admin&password=Csamoan75");
		//"jdbc:mariadb://<RDS ENDPOINT FROM AWS RDS SERVICE>:<port>/<DATABASE NAME>?user=<USER NAME>&password=<PASSWORD>"
		//notation for URI in getConnection method
		//int intID = Integer.parseInt(id);
		String sql = "SELECT * FROM customers WITH(INDEX(id)) ";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			System.out.println("==========Customer==========");
			System.out.println("name: ["
					+ rs.getString("name")
					+ "] customer_id: ["
					+ rs.getInt("customer_id")
					+ "]");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static String CreateCustomer()
	{
		return null;
	}
	public static void RunMethod()
	{
		System.out.println("running method");
	}
	
		
	
}
