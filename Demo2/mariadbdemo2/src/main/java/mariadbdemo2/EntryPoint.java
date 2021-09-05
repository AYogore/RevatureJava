package mariadbdemo2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EntryPoint {

	public static void main(String[] args) {
		
		Connection con = ConnectionFactory.getConnection();//"jdbc:mariadb://database-1.ct4rayfqtdoi.us-east-2.rds.amazonaws.com:3306/innodb?user=admin&password=Csamoan75");
		//"jdbc:mariadb://<RDS ENDPOINT FROM AWS RDS SERVICE>:<port>/<DATABASE NAME>?user=<USER NAME>&password=<PASSWORD>"
		//notation for URI in getConnection method
		
		String sql = "SELECT * FROM test_table";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			System.out.println("==========test_table==========");
			while(rs.next()) {
				//invoke once since you start before the 1st and not on the 1st result
				//first invoke advances to 1st element
				System.out.println("string_id: ["
						+ rs.getInt("string_id")
						+ "] string: ["
						+ rs.getString("string")
						+ "]");

			}
			System.out.println("==========test_table==========");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
