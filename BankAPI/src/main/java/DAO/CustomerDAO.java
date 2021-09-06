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
     public List<Customer> getAll() {
    	 //for each loop, return all names with id table
         return customers;
     }

     @Override
     public void save(Customer customer) {
    	 try {
			PreparedStatement create = connection.prepareStatement(null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }

     @Override
     public void update(Customer customer, String[] params) {
    	 customer.SetName(Objects.requireNonNull(params[0], "Name cannot be null"));
     }

     @Override
     public void delete(Customer customer) {
    	 //delete line
    	 customers.remove(customer);
     }
 }
