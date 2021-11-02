package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.*;
public class CheckInModel {

	public List<CheckIn> findAll(){
		List<CheckIn> checkins = new ArrayList<CheckIn>();
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement("select * from check_in");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CheckIn checkin = new CheckIn();
				checkin.setId(rs.getInt("id"));
				checkin.setId_checkout(rs.getInt("id_checkout"));
				checkin.setId_account(rs.getInt("id_account"));
				checkin.setDateout(rs.getDate("date_out"));
				checkin.setFine(rs.getDouble("fine"));
				checkin.setNumber_of_days_late(rs.getInt("number_of_days_late"));
				checkin.setRefund(rs.getDouble("refund"));
				checkins.add(checkin);
			}
		} catch (Exception e) {
			e.printStackTrace();
			checkins = null;
		}finally {
			ConnectDB.disconnect();
		}
		return checkins;
	}
	
	public int latestId(){
		int id = 0 ;
		try {
			PreparedStatement ps = ConnectDB.connection()
					.prepareStatement("select id from check_in order by id desc limit 1");
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				id= rs.getInt("id");
			}
		} catch (Exception e) {
			id = 0;
			e.printStackTrace();
		}finally {
			ConnectDB.disconnect();
		}
		return id;
	}

	public CheckIn findById(int id) {
		CheckIn checkIn = null;
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement("select * from check_in where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				checkIn = new CheckIn();
				checkIn.setId(rs.getInt("id"));
				checkIn.setId_checkout(rs.getInt("id_checkout"));
				checkIn.setId_account(rs.getInt("id_account"));
				checkIn.setDateout(rs.getDate("date_out"));
				checkIn.setFine(rs.getDouble("fine"));
				checkIn.setNumber_of_days_late(rs.getInt("number_of_days_late"));
				checkIn.setRefund(rs.getDouble("refund"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			checkIn = null;
		}finally {
			ConnectDB.disconnect();
		}
		return checkIn;
	}
	
	public CheckIn findUser(String username) {
		CheckIn checkIn = null;
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement("select * from check_in where username = ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				checkIn = new CheckIn();
				checkIn.setId(rs.getInt("id"));
				checkIn.setId_checkout(rs.getInt("id_checkout"));
				checkIn.setId_account(rs.getInt("id_account"));
				checkIn.setDateout(rs.getDate("date_out"));
				checkIn.setFine(rs.getDouble("fine"));
				checkIn.setNumber_of_days_late(rs.getInt("number_of_days_late"));
				checkIn.setRefund(rs.getDouble("refund"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			checkIn = null;
		}finally {
			ConnectDB.disconnect();
		}
		return checkIn;
	}
	
	public boolean delete(int id) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
				.prepareStatement("delete from check_in where id = ? ");
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate() > 0;
			
		}
		 catch (Exception e) {
			result = false;
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public boolean create(CheckIn checkIn) {
		// TODO Auto-generated method stub
		boolean result = true;
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement("insert into "
					+ "check_in(id_checkout,id_account,fine,date_out,number_of_days_late,refund)"
					+ "values (?,?,?,?,?,?)");
			ps.setInt(1,checkIn.getId_checkout());
			ps.setInt(2, checkIn.getId_account());
			ps.setDouble(3, checkIn.getFine());
			ps.setDate(4, new java.sql.Date(checkIn.getDateout().getTime()));
			ps.setInt(5, checkIn.getNumber_of_days_late());
			ps.setDouble(6, checkIn.getRefund());
			result = ps.executeUpdate() > 0;
			
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public boolean update(CheckIn checkIn) {
		// TODO Auto-generated method stub
		boolean result = true;
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement("update check_in "
					+ "set id_checkout = ? , id_account = ?, fine = ?, date_out = ?, number_of_days_late = ?, refund = ? where id = ?");
			ps.setInt(1,checkIn.getId_checkout());
			ps.setInt(2, checkIn.getId_account());
			ps.setDouble(3, checkIn.getFine());
			ps.setDate(4, new java.sql.Date(checkIn.getDateout().getTime()));
			ps.setInt(5, checkIn.getNumber_of_days_late());
			ps.setDouble(6, checkIn.getRefund());
			ps.setInt(7, checkIn.getId());
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
