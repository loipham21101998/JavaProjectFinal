package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Account;
import entities.Book;
import entities.Category;

public class CategoryModel {
	
	public List<Category> findAll(){
		List<Category> categories = new ArrayList<Category>();
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement("select * from category");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				categories.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
			categories = null;
		}finally {
			ConnectDB.disconnect();
		}
		return categories;
	}
	
	public Category findByid(int id) {
		Category category = null;
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement("select * from category where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			category = null;
		}finally {
			ConnectDB.disconnect();
		}
		return category;
	}
	
	public Category findByName(String name) {
		Category category = null;
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement("select * from category where name like ?");
			ps.setString(1,"%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			category = null;
		}finally {
			ConnectDB.disconnect();
		}
		return category;
	}
	
	public boolean insert(Category category) {
		boolean result = true;
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement("insert into "
					+ "category(name)"
					+ "values (?)");
			ps.setString(1,category.getName());
			result = ps.executeUpdate() > 0;
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	

}
