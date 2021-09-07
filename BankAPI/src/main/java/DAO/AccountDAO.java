package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import Models.Account;
import Models.Customer;
import Utils.ConnectionFactory;

public class AccountDAO implements Dao<Account>{
    private List<Account> accounts;
    Connection connection;
    private int noOfAccounts;

    public AccountDAO(Connection conn) {
        accounts = new LinkedList<>();
        connection = conn;
        noOfAccounts = 0;
    }

    @Override
    public Account get(int id) {
        return null;
    }

    @Override
    public String getAll() {
    	Connection con = ConnectionFactory.getConnection();
 		String sql = "SELECT * FROM accounts";
 		StringBuilder sb = new StringBuilder("==========Accounts==========");
 		sb.append("\n    ID          Balance       ");
 		///=====================Customers==========
 		try {
 			Statement stmt = con.createStatement();
 			ResultSet rs = stmt.executeQuery(sql);
 			
 			//System.out.println("==========Customers==========");
 			while(rs.next()) {
 				//invoke once since you start before the 1st and not on the 1st result
 				//first invoke advances to 1st element
 				sb.append("\nid: ["
 						+ rs.getInt("account_id")
 						+ "] balance: ["
 						+ rs.getString("balance")
 						+ "]");
 				
 			}
 			sb.append("\n==========Accounts==========");
 			
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 		return sb.toString();
    }
    @Override
    public void save(Account account) {
		 noOfAccounts++;

		 try {
			String sql = "INSERT INTO accounts (customer_id, account_id, balance) VALUES (?,?,?);";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setFloat(1, account.GetCustomerId());
			pstmt.setInt(2, noOfAccounts);
			pstmt.setDouble(3, 0);
			//System.out.println("account created for: " + c.GetName());
			//
 			pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    public void update(Account account, String[] params) {

    }

    @Override
    public void delete(Account account) {

    }
    
    public String PrintAccounts() {
 		Connection con = ConnectionFactory.getConnection();
 		String sql = "SELECT * FROM accounts";
 		StringBuilder sb = new StringBuilder("==========Accounts==========");
 		sb.append("\n    ID          Balance       ");
 		///=====================Customers==========
 		try {
 			Statement stmt = con.createStatement();
 			ResultSet rs = stmt.executeQuery(sql);
 			
 			//System.out.println("==========Customers==========");
 			while(rs.next()) {
 				//invoke once since you start before the 1st and not on the 1st result
 				//first invoke advances to 1st element
 				sb.append("\nid: ["
 						+ rs.getInt("account_id")
 						+ "] balance: ["
 						+ rs.getString("balance")
 						+ "]");
 				
 			}
 			sb.append("\n==========Accounts==========");
 			
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 		return sb.toString();
    }

	
}
