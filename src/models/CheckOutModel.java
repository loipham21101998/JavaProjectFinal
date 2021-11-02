package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.CheckOut;

public class CheckOutModel {
	
	
	
	
	public boolean delete(int id) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
				.prepareStatement("delete from check_out where id = ? ");
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

	
	
	public List<CheckOut> search(int id) {
		List<CheckOut> checkOuts = new ArrayList<CheckOut>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
				.prepareStatement("select * from check_out where id_user = ? ");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				CheckOut checkOut = new CheckOut();
				checkOut.setId(resultSet.getInt("id"));
				checkOut.setId_user(resultSet.getInt("id_user"));
				checkOut.setId_account(resultSet.getInt("id_account"));
				checkOut.setDate_in(resultSet.getDate("date_in"));
				checkOut.setReturn_date(resultSet.getDate("return_date"));
				checkOut.setDeposit(resultSet.getDouble("deposit"));
				checkOut.setStatus(resultSet.getBoolean("status"));
				checkOuts.add(checkOut);
			}
		} catch (Exception e) {
			checkOuts = null;
		} finally {
			ConnectDB.disconnect();
		}
		return checkOuts;
	}
	
	
	public CheckOut find(int id) {
		CheckOut checkOut = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from check_out where id = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				checkOut = new CheckOut();
				checkOut.setId(resultSet.getInt("id"));
				checkOut.setId_user(resultSet.getInt("id_user"));
				checkOut.setId_account(resultSet.getInt("id_acccount"));
				checkOut.setDate_in(resultSet.getDate("date_in"));
				checkOut.setReturn_date(resultSet.getDate("return_date"));
				checkOut.setDeposit(resultSet.getDouble("deposit"));
				checkOut.setStatus(resultSet.getBoolean("status"));
				
			}
		} catch (Exception e) {
			checkOut = null;
		} finally {
			ConnectDB.disconnect();
		}
		return checkOut;
	}
	
	
	public List<CheckOut> findAll() {
		List<CheckOut> checkOuts = new ArrayList<CheckOut>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
				.prepareStatement("select * from check_out where status = false");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				CheckOut checkOut = new CheckOut();
				checkOut.setId(resultSet.getInt("id"));
				checkOut.setId_user(resultSet.getInt("id_user"));
				checkOut.setId_account(resultSet.getInt("id_account"));
				checkOut.setDate_in(resultSet.getDate("date_in"));
				checkOut.setReturn_date(resultSet.getDate("return_date"));
				checkOut.setDeposit(resultSet.getDouble("deposit"));
				checkOut.setStatus(resultSet.getBoolean("status"));
				
				checkOuts.add(checkOut);
			}
		} catch (Exception e) {
			checkOuts = null;
		} finally {
			ConnectDB.disconnect();
		}
		return checkOuts;
	}	
	
	public int latestId(){
		int id = 0 ;
		try {
			PreparedStatement ps = ConnectDB.connection()
					.prepareStatement("select id from check_out order by id desc limit 1");
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

	
	public boolean updateSub(double deposit,int id) {
		boolean result = true;
		try {
			PreparedStatement ps = ConnectDB.connection()
					.prepareStatement("update check_out "
							+ "set deposit = deposit - ? "
							+ "where id = ?");
			ps.setDouble(1, deposit);
			ps.setInt(2, id);
			result = ps.executeUpdate() > 0 ;
			
			
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public boolean updateAdd(double deposit,int id) {
		boolean result = true;
		try {
			PreparedStatement ps = ConnectDB.connection()
					.prepareStatement("update check_out "
							+ "set deposit = deposit + ? "
							+ "where id = ?");
			ps.setDouble(1, deposit);
			ps.setInt(2, id);
			result = ps.executeUpdate() > 0 ;
			
			
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	

	public boolean delete() {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("delete from check_out where id = (select id from check_out order by id desc limit 1)");
		result = preparedStatement.executeUpdate() > 0 ;
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public boolean create(CheckOut checkOut) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement
					("insert into check_out(id_user, id_account, date_in, return_date, deposit, status  ) values(?,?,?,?,?,?) ");
		preparedStatement.setInt(1, checkOut.getId_user());
		preparedStatement.setInt(2, checkOut.getId_account());
		preparedStatement.setDate(3, new java.sql.Date(checkOut.getDate_in().getTime()));
		preparedStatement.setDate(4, new java.sql.Date(checkOut.getReturn_date().getTime()));
		preparedStatement.setDouble(5, checkOut.getDeposit());
		preparedStatement.setBoolean(6, checkOut.isStatus());
		
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
