
import io.javalin.Javalin;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Utils.ConnectionFactory;

public class Driver {

	public static void main(String[] args) {
		//SQL Database Connection
		ConnectDatabase();
		
		//Postman connection
		Javalin app = Javalin.create().start(7000);
		app.get("/", ctx -> ctx.result("Hello World"));
		app.post("/send-data", ctx -> {
			System.out.println(ctx.body());
			//System.out.println(eee.body());
			});
		
		app.get("/hello", eee-> eee.html("Hello Javelin!"));
		app.get("/exception",ctx -> {
			throw new Exception("test");
			});
		app.get("/clients", clients -> clients.html("all clients"));
		//app.exception(Exception.class, (e.ctx) ->{
		//	System.out.println("exception!!!");
		//	ctx.status(500);
		//});
		app.get("/runmethod", ctx -> {
		RunMethod();
		});
		
			
		
		//app.error(e)
		
		}
	public static void ConnectDatabase() {
		Connection con = ConnectionFactory.getConnection();//"jdbc:mariadb://database-1.ct4rayfqtdoi.us-east-2.rds.amazonaws.com:3306/innodb?user=admin&password=Csamoan75");
		//"jdbc:mariadb://<RDS ENDPOINT FROM AWS RDS SERVICE>:<port>/<DATABASE NAME>?user=<USER NAME>&password=<PASSWORD>"
		//notation for URI in getConnection method
		
		String sql = "SELECT * FROM accounts";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			System.out.println("==========test_table==========");
			while(rs.next()) {
				//invoke once since you start before the 1st and not on the 1st result
				//first invoke advances to 1st element
				System.out.println("account_id: ["
						+ rs.getInt("account_id")
						+ "] balance: ["
						+ rs.getString("balance")
						+ "]");
				
			}
			System.out.println("==========test_table==========");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void RunMethod()
	{
		System.out.println("running method");
	}
	
		
	
}
