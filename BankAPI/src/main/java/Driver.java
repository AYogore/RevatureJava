
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.CustomerDAO;
import DAO.Dao;
import Models.Customer;
import Utils.ConnectionFactory;
import io.javalin.Javalin;


public class Driver {
	
	private static Dao<Customer> CustomerDAO;

	public static void main(String[] args) {
		//SQL Database Connection
		//Postman connection
		Javalin app = Javalin.create().start(7000);
		//ConnectDatabase();
		Connection con = ConnectionFactory.getConnection();
		CustomerDAO = new CustomerDAO(con);
		
		
		
		
		
		
		
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
		app.get("/clients", clients -> {
			clients.result(PrintCustomers());
		});
		app.get("/clients/:id", clients -> {
			try {
				int id = Integer.parseInt(clients.pathParam("id"));
				Customer c = CustomerDAO.get(id);
				clients.result(c.GetName());
				
			} catch (Exception e) {
				clients.status(404);
			}
			//PrintCustomer(clients.pathParam("id"));
		});
		app.post("/clients", clients -> {
			
			clients.html("creating clients");
			clients.status(201);
			//Customer newCustomer = new Customer("John", "Smith", 6);
			//newCustomer.g
			
			//PreparedStatement createCustomer = con.prepareStatement(createC);
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
