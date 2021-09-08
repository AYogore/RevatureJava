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

    public AccountDAO(Connection conn) {
        accounts = new LinkedList<>();
        connection = conn;
    }

    @Override
    public Account get(int id) {
    	try {
   		 String sql = "SELECT balance FROM accounts WHERE account_id="+id;
   		 Account a = new Account();
   		 a.SetAccountId(id);
   		 Statement st = connection.createStatement();
   		 ResultSet rs = st.executeQuery(sql);
   		 
   		 rs.next();
   		 float balance = rs.getFloat(1);
   		 a.SetAccountBalance(balance);
   		 return a;
   		 
   		 
		} catch (Exception e) {
			//con.status(404);
			e.printStackTrace();
		}
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

		 try {
			String sql = "INSERT INTO accounts (customer_id, balance) VALUES (?,?);";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setFloat(1, account.GetCustomerId());
			pstmt.setDouble(2, 0);
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
    	try {
			String sql = "UPDATE accounts SET balance=? WHERE account_id=?";
					 // AND account_id=?";
			System.out.println(params[0]);
			System.out.println(params[1]);

			PreparedStatement pstmt = connection.prepareStatement(sql);
		
			double d = account.GetAccountBalance();
			//double startingBalance = d;
			System.out.println(d);
			double a = Double.valueOf(params[1]);
			switch(params[0])
			{
			case "withdraw": //add
				d -= a;
				System.out.println(d);
				break;
			case "deposit":
				d += a;
				System.out.println(d);

				break;
			}
			pstmt.setDouble(1, d); 
			pstmt.setFloat(2, account.GetAccountId());
			pstmt.executeQuery();

   		 	System.out.println("executed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
    
    /*public void transfer(Account a, Account b, int amt)
    {
    	try {
    		String sql = "UPDATE accounts SET balance= SUM(? + ?) FROM accounts WHERE customer_id=(?) AND account_id=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);pstmt.setFloat(1, a.GetAccountId()); 
			pstmt.setFloat(2, amt);
   		 	pstmt.setFloat(3, a.GetCustomerId());
   		 	pstmt.setFloat(4, a.GetAccountId());
   		 	
   		 	pstmt.executeQuery();
   		 	
   		 String sql = "SELECT balance SUM(? - ?) FROM accounts WHERE customer_id=(?) AND account_id=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);pstmt.setFloat(1, a.GetAccountId()); 
			pstmt.setFloat(2, amt);
		 	pstmt.setFloat(3, a.GetCustomerId());
		 	pstmt.setFloat(4, a.GetAccountId());
		 	
		 	pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    */

    @Override
    public void delete(Account account) {
    	try {
			String sql = "DELETE FROM accounts WHERE customer_id= ? AND account_id=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			
			pstmt.setFloat(1, account.GetCustomerId());
			pstmt.setFloat(2, account.GetAccountId());
			
			pstmt.executeQuery();
			System.out.println("Account " + account.GetAccountId() + " has been deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("deletion error");

			e.printStackTrace();
		}
    }
    
    public String getAllWithParams(int top, int bottom) {
 		String sql = "SELECT * FROM accounts WHERE amountLessThan=? AND amountGreaterThan=?";
 		StringBuilder sb = new StringBuilder("==========Accounts==========");
 		sb.append("\n    ID          Balance       ");
 		///=====================Customers==========
 		try {
 			PreparedStatement pstmt = connection.prepareStatement(sql);
 			pstmt.setInt(1, top);
 			pstmt.setInt(2, bottom);
 			ResultSet rs = pstmt.executeQuery(sql);
 			
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
	public String getAll(int... i) {
		StringBuilder sb = new StringBuilder("==========Accounts==========");
		sb.append("\n    ID          Balance       ");
		
			String sql = "SELECT * FROM accounts WHERE customer_id=(?) AND balance BETWEEN ? and ?";
			///=====================Customers==========customer_id=(?) AND
			try {
				PreparedStatement pstmt = connection.prepareStatement(sql);
				pstmt.setInt(1, i[0]);
				pstmt.setInt(2, i[1]);
				pstmt.setInt(3, i[2]);
				ResultSet rs = pstmt.executeQuery();
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
