package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.CheckOutDetails;
import entities.CheckOut;

public class CheckOutDetailsModel {
	
	public boolean create(int id_checkout , int id_book) {
		boolean result = true;
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement("insert into "
					+ "check_out_details(id_checkout,id_book)"
					+ "values(?,?)");
			ps.setInt(1, id_checkout);
			ps.setInt(2, id_book);
			result = ps.executeUpdate() > 0;
			
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public List<CheckOutDetails> search(int id) {
		List<CheckOutDetails> checkOutDetails = new ArrayList<CheckOutDetails>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
				.prepareStatement("select * from check_out_details where id_checkout = ? ");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				CheckOutDetails chDetails = new CheckOutDetails();
				chDetails.setId_book(resultSet.getInt("id_book"));
				chDetails.setId_checkout(resultSet.getInt("id_checkout"));
			
				checkOutDetails.add(chDetails);
			}
		} catch (Exception e) {
			checkOutDetails = null;
		} finally {
			ConnectDB.disconnect();
		}
		return checkOutDetails;
	}
	
	public boolean delete(int id_checkout, int id_book) {
		boolean result = true;
		try {
			PreparedStatement ps = ConnectDB.connection()
					.prepareStatement("delete from check_out_details where id_checkout = ? AND id_book= ?");
			ps.setInt(1, id_checkout);
			ps.setInt(2, id_book);
		result = ps.executeUpdate() > 0 ;
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public boolean updateQuantity(int id) {
		boolean result = true;
		try {
			PreparedStatement ps = ConnectDB.connection()
					.prepareStatement("update book "
							+ "set quantity = quantity - 1  "
							+ "where id = ?");
			
			ps.setInt(1, id);
			result = ps.executeUpdate() > 0 ;
			
			
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public boolean updateQuantityAdd(int id) {
		boolean result = true;
		try {
			PreparedStatement ps = ConnectDB.connection()
					.prepareStatement("update book "
							+ "set quantity = quantity + 1  "
							+ "where id = ?");
			
			ps.setInt(1, id);
			result = ps.executeUpdate() > 0 ;
			
			
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
}
