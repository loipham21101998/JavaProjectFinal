package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import entities.Account;

public class AccountModel {
	
	public List<Account> findAll(){
		List<Account> accounts = new ArrayList<Account>();
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement("select * from account");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Account account = new Account();
				account.setId(rs.getInt("id"));
				account.setUsername(rs.getString("username"));
				account.setPassword(rs.getString("password"));
				account.setFullname(rs.getString("fullname"));
				account.setGender(rs.getBoolean("gender"));
				account.setAddress(rs.getString("address"));
				account.setPhone(rs.getString("phone"));
				account.setId_role(rs.getInt("id_role"));
				accounts.add(account);
			}
		} catch (Exception e) {
			e.printStackTrace();
			accounts = null;
		}finally {
			ConnectDB.disconnect();
		}
		return accounts;
	}
	
	public Account findById(int id) {
		Account account = null;
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement("select * from account where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				account = new Account();
				account.setId(rs.getInt("id"));
				account.setUsername(rs.getString("username"));
				account.setPassword(rs.getString("password"));
				account.setFullname(rs.getString("fullname"));
				account.setGender(rs.getBoolean("gender"));
				account.setAddress(rs.getString("address"));
				account.setPhone(rs.getString("phone"));
				account.setId_role(rs.getInt("id_role"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			account = null;
		}finally {
			ConnectDB.disconnect();
		}
		return account;
	}
	
	public Account findUser(String username) {
		Account account = null;
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement("select * from account where username = ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				account = new Account();
				account.setId(rs.getInt("id"));
				account.setUsername(rs.getString("username"));
				account.setPassword(rs.getString("password"));
				account.setFullname(rs.getString("fullname"));
				account.setGender(rs.getBoolean("gender"));
				account.setAddress(rs.getString("address"));
				account.setPhone(rs.getString("phone"));
				account.setId_role(rs.getInt("id_role"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			account = null;
		}finally {
			ConnectDB.disconnect();
		}
		return account;
	}
	
	public boolean login(String username, String password) {
		Account account = findUser(username);
		if(account != null) {
			if(BCrypt.checkpw(password, account.getPassword())) {
				return true;
			}
		}
		return false;
	}

	public boolean create(Account account) {
		boolean result = true;
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement("insert into "
					+ "account(username,password,fullname,gender,address,phone,id_role)"
					+ "values (?,?,?,?,?,?,?)");
			ps.setString(1,account.getUsername());
			ps.setString(2, account.getPassword());
			ps.setString(3, account.getFullname());
			ps.setBoolean(4, account.isGender());
			ps.setString(5, account.getAddress());
			ps.setString(6, account.getPhone());
			ps.setInt(7, account.getId_role());
			result = ps.executeUpdate() > 0;
			
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public boolean update(Account account) {
		boolean result = true;
		try {
			PreparedStatement ps = ConnectDB.connection()
					.prepareStatement("update account "
							+ "set fullname = ? , gender = ?, address = ?, phone = ?, id_role = ? where id = ?");//sql query ( truy van )
			ps.setString(1,account.getFullname());
			ps.setBoolean(2,account.isGender());
			ps.setString(3,account.getAddress());
			ps.setString(4, account.getPhone());
			ps.setInt(5, account.getId_role());
			ps.setInt(6, account.getId());
			result = ps.executeUpdate() > 0;
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	
	public boolean delete(int id) {
		boolean result = true;
		try {
			PreparedStatement ps = ConnectDB.connection()
					.prepareStatement("delete from account where id = ?");//sql query ( truy van )
			ps.setInt(1, id);
			result = ps.executeUpdate() > 0;
		} catch (Exception e) {
			result = false;
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	
}
