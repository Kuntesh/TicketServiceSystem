
// Singleton class for each venue
public class Venue implements Comparable<Venue>{
	// venue level id ranging from 1 to 4
	private int levelId;
	// venue name
	private String levelName;
	// cost of the ticket per venue
	private double price;
	// num of rows
	private int rows;
	// seats per row
	private int seatsInRow;
	// total tickets
	private int totalTickets;
	// num of available tickets
	private int availableTickets;
	// num of hold tickets
	private int holdTickets;
	// num of reserved tickets
	private int reservedTickets;
	
	// Several Singleton instances representing different venue levels
	public static Venue instance1;
	public static Venue instance2;
	public static Venue instance3;
	public static Venue instance4;
	
	private Venue(int levelId, String levelName, double price, int rows, int seatsInRow){
		this.levelId = levelId;
		this.levelName = levelName;
		this.price = price;
		this.rows = rows;
		this.seatsInRow = seatsInRow;
		totalTickets = rows*seatsInRow;
		availableTickets = totalTickets-holdTickets-reservedTickets; 
	}
	// creating single instance per venue level for the entire application
	public static Venue getInstance(int levelId){
		if (levelId == 1){
			if (null == instance1){
				instance1 = new Venue(1, "Orchestra", 100.00, 25, 50);
			}
			return instance1;
		} else if (levelId == 2){
			if (null == instance2){
				instance2 = new Venue(2, "Main", 75.00, 20, 100);
			}
			return instance2;
		} else if (levelId == 3){
			if (null == instance3){
				instance3 = new Venue(3, "Balcony1", 50.00, 15, 100);
			}
			return instance3;
		} else if (levelId == 4){
			if (null == instance4){
				instance4 = new Venue(4, "Balcony2", 40.00, 15, 100);
			}
			return instance4;
		}
		return null;
	}
	// returning available tickets
	public int getAvailableTickets() {
		this.availableTickets = this.totalTickets-this.holdTickets-this.reservedTickets;
		return this.availableTickets;
	}
	public void setAvailableTickets(int t) {
		this.availableTickets = t;
	}
	public int getHoldTickets() {
		return holdTickets;
	}

	public void setHoldTickets(int holdTickets) {
		this.holdTickets = holdTickets;
	}
	public void setReservedTickets(int reservedTickets) {
		this.reservedTickets = reservedTickets;
	}

	public int getLevelId() {
		return levelId;
	}

	// Sorting the venues in such a way that the available tickets for best venue is available to the user to hold and book the tickets
	@Override
	public int compareTo(Venue o) {
		return o.getAvailableTickets() - this.getAvailableTickets();
	}
}

