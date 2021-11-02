package entities;

import java.util.Date;

public class CheckIn {
	
	private int id;
	private int id_checkout;
	private int id_account;
	private Date dateout;
	private double fine;
	private int number_of_days_late;
	private double refund;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_checkout() {
		return id_checkout;
	}
	public void setId_checkout(int id_checkout) {
		this.id_checkout = id_checkout;
	}
	public int getId_account() {
		return id_account;
	}
	public void setId_account(int id_account) {
		this.id_account = id_account;
	}
	public Date getDateout() {
		return dateout;
	}
	public void setDateout(Date dateout) {
		this.dateout = dateout;
	}
	public double getFine() {
		return fine;
	}
	public void setFine(double fine) {
		this.fine = fine;
	}
	public int getNumber_of_days_late() {
		return number_of_days_late;
	}
	public void setNumber_of_days_late(int number_of_days_late) {
		this.number_of_days_late = number_of_days_late;
	}
	public double getRefund() {
		return refund;
	}
	public void setRefund(double refund) {
		this.refund = refund;
	}
	
	
}
