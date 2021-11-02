package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.CheckInDetails;
import entities.CheckInDetails;

public class CheckInDetailsModel {
	
	
	public boolean create(CheckInDetails checkInDetails) {
		boolean result = true;
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement("insert into "
					+ "check_in_details(id_checkin,id_book,id_checkout,status)"
					+ "values(?,?,?,?)");
			ps.setInt(1, checkInDetails.getId_checkin());
			ps.setInt(2, checkInDetails.getId_book());
			ps.setInt(3, checkInDetails.getId_checkout());
			ps.setBoolean(4, checkInDetails.isStatus());
			result = ps.executeUpdate() > 0;
			
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public List<CheckInDetails> search(int id) {
		List<CheckInDetails> checkInDetails = new ArrayList<CheckInDetails>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
				.prepareStatement("select * from check_in_details where id_checkin = ? ");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				CheckInDetails chDetails = new CheckInDetails();
				chDetails.setId_checkin(resultSet.getInt("id_checkin"));
				chDetails.setId_book(resultSet.getInt("id_book"));
				chDetails.setId_checkout(resultSet.getInt("id_checkout"));
				chDetails.setStatus(resultSet.getBoolean("status"));
				checkInDetails.add(chDetails);
			}
		} catch (Exception e) {
			checkInDetails = null;
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return checkInDetails;
	}
	

}
