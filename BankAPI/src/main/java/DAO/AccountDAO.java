package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import Models.Account;
import Models.Customer;

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
    public List<Account> getAll() {
        return null;
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

	
}
