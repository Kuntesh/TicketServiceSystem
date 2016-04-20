import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Logger;

public class TicketServiceSystem implements TicketService, Runnable {

	// hMap holding seatHold Id with SeatHold object
	HashMap<Integer, SeatHold> hMap = new HashMap<Integer, SeatHold>();
	// confirmationMap holding customer email with confirmation number
	HashMap<String, Integer> confirmationMap = new HashMap<String, Integer>();
	private static Logger logger = Logger
			.getLogger("TicketServiceSystem.class");

	/**
	 * This method makes sure that hold tickets will be reset after 1 min.
	 */
	public void run() {
		try {
			logger.info("enters run method");
			while (true) {
				Thread.sleep(1 * 60 * 1000);
				for (int i = 1; i <= 4; i++) {
					Venue venue = Venue.getInstance(i);
					if (venue.getHoldTickets() > 0) {
						venue.setAvailableTickets(venue.getAvailableTickets()
								+ venue.getHoldTickets());
						venue.setHoldTickets(0);
					}
				}
				logger.info("exits run method");
			}
		} catch (InterruptedException e) {
			logger.info("exception run method");
		}
	}

	/**
	 * This method is used for reserving tickets against the customer email and
	 * seat hold Id. It returns confirmation number
	 */
	@Override
	public String reserveSeats(int seatHoldId, String customerEmail) {

		logger.info("enters reserveSeats()");
		try {
			SeatHold obj = hMap.get(seatHoldId);
			ArrayList<Venue> list = obj.getListVenues();
			for (Venue v : list) {
				v.setReservedTickets(v.getHoldTickets());
				v.setHoldTickets(0);
			}
			Random random = new Random();
			int confirmNum = random.nextInt(9000000) + 1000000;
			confirmationMap.put(customerEmail, confirmNum);
			logger.info("exits reserveSeats()");
			return ((Integer) confirmNum).toString();
		} catch (Exception e) {
			logger.info("exception in reserveSeats()");
		}
		return null;
	}

	/**
	 * Returns the number of seats available for the specific venue level
	 */
	@Override
	public int numSeatsAvailable(int venueLevel) {
		logger.info("enters numSeatsAvailable()");
		Venue obj = Venue.getInstance(venueLevel);
		return obj.getAvailableTickets();
	}

	/**
	 * Finds and hold requested seats for the customer
	 */
	@Override
	public SeatHold findAndHoldSeats(int numSeats, int minLevel, int maxLevel,
			String customerEmail) {
		logger.info("enters findAndHoldSeats()");
		try {
			TicketServiceSystem sys = new TicketServiceSystem();
			Thread t = new Thread(sys);
			t.start();// running thread in parallel to make sure that hold
						// tickets are reset after set interval
			SeatHold obj = new SeatHold();
			// customer email validation
			if (null == customerEmail) {
				return null;
			}
			int holdId = 0;
			holdId = customerEmail.hashCode(); // generating hold id

			obj.setSeatHoldId(holdId);
			obj.setCustomerEmail(customerEmail);
			int count = 0;
			ArrayList<Venue> listVenues = new ArrayList<Venue>();
			// checking if the requested seats are available in all the venues
			for (int i = minLevel; i <= maxLevel; i++) {
				Venue venue = Venue.getInstance(i);
				listVenues.add(venue);
				count += venue.getAvailableTickets();
			}
			// returning error message if requested seats are not available
			if (count < numSeats) {
				obj.setErroMsg("Please change the number of requested seats as all of them are not available at this moment.");
				return obj;
			}
			int temp = numSeats;
			Collections.sort(listVenues);// sorting in descending order
			// choosing best available seats
			for (Venue v : listVenues) {
				obj.getListVenues().add(v);
				// Holding best available seats
				if (v.getAvailableTickets() > temp) { // if all seats are
														// available in one
														// venue then program
														// will hold those seats
					v.setHoldTickets(temp);
					obj.getSeatsPerLevel().put(v.getLevelId(), temp);// adding
																		// entry
																		// into
																		// SeatHold
																		// object
					break;
				} else {
					v.setHoldTickets(v.getAvailableTickets());
					obj.getSeatsPerLevel().put(v.getLevelId(),
							v.getAvailableTickets());
					temp -= v.getHoldTickets();// calculating remaining seats
												// which need to be booked in
												// other venues
				}
			}
			hMap.put(holdId, obj);// Adding SeatHold object against seatHold Id
			return obj;
		} catch (Exception e) {
			logger.info("exception findAndHoldSeats()");
		}
		return null;
	}
}
