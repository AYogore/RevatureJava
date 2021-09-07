 package DAO;

 import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import Models.Customer;
import Utils.ConnectionFactory;

 public class CustomerDAO implements Dao<Customer>{

     private List<Customer> customers;
     Connection connection;

     public CustomerDAO(Connection con) {
         customers = new ArrayList<>();
         connection = con;
     }

     @Override
     public Customer get(int id) {
    	 //return name and id
    	 try {
    		 String sql = "SELECT name FROM customers WHERE customer_id="+id;
    		 Customer c = new Customer();
    		 c.SetCustomerId(id);
    		 Statement st = connection.createStatement();
    		 ResultSet rs = st.executeQuery(sql);
    		 
    		 rs.next();
    		 String name = rs.getString(1);
    		 c.SetName(name);
    		 return c;
    		 
    		 
		} catch (Exception e) {
			//con.status(404);
			e.printStackTrace();
		}
    	return null;
     }

     @Override
     public String getAll() {
    	 
 		Connection con = ConnectionFactory.getConnection();
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

     @Override
     public void save(Customer customer) throws SQLException {
    	 try {
 			 String[] str = customer.GetName().split("\n");

    		 String sql = "INSERT INTO customers (name, address_id) VALUES (?,?);";
    		 PreparedStatement pstmt = connection.prepareStatement(sql);
    		 pstmt.setString(1, str[0]);
    		 pstmt.setString(2, str[1]);

    		 pstmt.executeQuery();
    		 
    		 
		} catch (Exception e) {
			//con.status(404);
			e.printStackTrace();
		}
     }

     @Override
     public void update(Customer customer, String[] params) {
		 try {
			String sql = "UPDATE customers SET name = (?), address_id = (?) WHERE customer_id=(?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, params[0]); 
   		 	pstmt.setString(2, params[1]);
   		 	pstmt.setFloat(3, customer.GetCustomerId());
   		 	
   		 	pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }

     @Override
     public void delete(Customer customer) {
		 try {
			String sql = "DELETE FROM customers WHERE  customer_id=(?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			
			pstmt.setFloat(1, customer.GetCustomerId());
			
			pstmt.executeQuery();
			System.out.println(customer.GetName() + "has been deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("deletion error");

			e.printStackTrace();
		}
    	 //delete line
    	 //customers.remove(customer);
     }
 }
