import java.util.ArrayList;
import java.util.HashMap;


public class SeatHold {
	
	// SeatHold Id
	private int seatHoldId;
	// customer email
	private String customerEmail;
	// list of venues
	private ArrayList<Venue> listVenues = new ArrayList<Venue>();
	// seats per venue level
	private HashMap<Integer, Integer> seatsPerLevel = new HashMap<Integer, Integer>();
	// error message if any validation fails
	private String erroMsg = "";
	
	SeatHold(){
	
	}
	public int getSeatHoldId() {
		return seatHoldId;
	}
	public void setSeatHoldId(int seatHoldId) {
		this.seatHoldId = seatHoldId;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public ArrayList<Venue> getListVenues() {
		return listVenues;
	}
	public void setListVenues(ArrayList<Venue> listVenues) {
		this.listVenues = listVenues;
	}
	public HashMap<Integer, Integer> getSeatsPerLevel() {
		return seatsPerLevel;
	}
	public void setSeatsPerLevel(HashMap<Integer, Integer> seatsPerLevel) {
		this.seatsPerLevel = seatsPerLevel;
	}
	public String getErroMsg() {
		return erroMsg;
	}
	public void setErroMsg(String erroMsg) {
		this.erroMsg = erroMsg;
	}
	
}
