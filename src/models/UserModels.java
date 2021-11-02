package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import entities.Account;
import entities.Book;
import entities.CheckOut;
import entities.User;




public class UserModels {
	
	
	public List<User> findAll(){
		List<User> users = new ArrayList<User>();
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement("select * from user");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setFullname(rs.getString("fullname"));
				user.setGender(rs.getBoolean("gender"));
				user.setAddress(rs.getString("address"));
				user.setPhone(rs.getString("phone"));
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
			users = null;
		}finally {
			ConnectDB.disconnect();
		}
		return users;
	}
	
	public boolean update(User user) {
		boolean result = true;
		try {
			PreparedStatement ps = ConnectDB.connection()
					.prepareStatement("update user "
							+ "set fullname = ? , gender = ?, address = ?, phone = ? where id = ?");//sql query ( truy van )
			ps.setString(1,user.getFullname());
			ps.setBoolean(2,user.isGender());
			ps.setString(3,user.getAddress());
			ps.setString(4, user.getPhone());
			ps.setInt(5, user.getId());
			result = ps.executeUpdate() > 0;
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public User search(String keyword) {
		User user = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
				.prepareStatement("select * from user where fullname like ?");
			preparedStatement.setString(1, "%" + keyword + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setFullname(rs.getString("fullname"));
				user.setGender(rs.getBoolean("gender"));
				user.setAddress(rs.getString("address"));
				user.setPhone(rs.getString("phone"));
				
			}
		} catch (Exception e) {
			user = null;
		} finally {
			ConnectDB.disconnect();
		}
		return user;
	}
	
	public User searchById(int id) {
		User user = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
				.prepareStatement("select * from user where id = ?");
			preparedStatement.setInt(1,id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setFullname(rs.getString("fullname"));
				user.setGender(rs.getBoolean("gender"));
				user.setAddress(rs.getString("address"));
				user.setPhone(rs.getString("phone"));
				
			}
		} catch (Exception e) {
			user = null;
		} finally {
			ConnectDB.disconnect();
		}
		return user;
	}
	public List<User> searchListbyId(int id) {
		List<User> users = new ArrayList<User>();
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement("select * from user where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setFullname(rs.getString("fullname"));
				user.setGender(rs.getBoolean("gender"));
				user.setAddress(rs.getString("address"));
				user.setPhone(rs.getString("phone"));
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
			users = null;
		} finally {
			ConnectDB.disconnect();
		}
		return users;
	}
	
	
	public User findById(int id) {
		User user = null;
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement("select * from user where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setFullname(rs.getString("fullname"));
				user.setGender(rs.getBoolean("gender"));
				user.setAddress(rs.getString("address"));
				user.setPhone(rs.getString("phone"));
			}	
		} catch (Exception e) {
			e.printStackTrace();
			user = null;
		}finally {
			ConnectDB.disconnect();
		}
		return user;
	}
	
	public boolean create( User user ) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement
					("insert into user(fullname, gender, address, phone) values(?,?,?,?) ");
			
		preparedStatement.setString(1, user.getFullname());
		preparedStatement.setBoolean(2, user.isGender());
		preparedStatement.setString(3, user.getAddress());
		preparedStatement.setString(4, user.getPhone());
		result = preparedStatement.executeUpdate() > 0 ;
			
			
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	
}
	
	
}
