package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Account;
import entities.Role;

public class RoleModel {
	
	public List<Role> findAll(){
		List<Role> roles = new ArrayList<Role>();
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement("select * from role");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Role role= new Role();
				role.setId(rs.getInt("id"));
				role.setName(rs.getString("name"));
				roles.add(role);
			}
		} catch (Exception e) {
			e.printStackTrace();
			roles = null;
		}finally {
			ConnectDB.disconnect();
		}
		return roles;
	}
	
	
	public Role findById(int id) {
		Role role = null;
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement("select * from role where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				role= new Role();
				role.setId(rs.getInt("id"));
				role.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			role = null;
		}finally {
			ConnectDB.disconnect();
		}
		return role;
	}

}
