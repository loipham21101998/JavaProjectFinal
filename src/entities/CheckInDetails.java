package entities;

public class CheckInDetails {

	private int id_checkin;
	private int id_book;
	private int id_checkout;
	private boolean status;

	public int getId_checkin() {
		return id_checkin;
	}

	public void setId_checkin(int id_checkin) {
		this.id_checkin = id_checkin;
	}

	public int getId_book() {
		return id_book;
	}

	public void setId_book(int id_book) {
		this.id_book = id_book;
	}

	public int getId_checkout() {
		return id_checkout;
	}

	public void setId_checkout(int id_checkout) {
		this.id_checkout = id_checkout;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
