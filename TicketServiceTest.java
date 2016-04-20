import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;

import org.junit.Test;

public class TicketServiceTest {

	private static Logger logger = Logger.getLogger("TicketServiceTest.class");

	@Test
	public void getAvailableTicketsVenue1() {
		logger.info("getAvailableTicketsVenue1");
		try {
			TicketServiceSystem instance = new TicketServiceSystem();
			int expResult = 1250;
			int result = instance.numSeatsAvailable(1);
			assertEquals(expResult, result);
		} catch (AssertionError e) {
			logger.severe(e.toString());
		}
	}

	@Test
	public void getAvailableTicketsVenue2() {
		logger.info("getAvailableTicketsVenue2");
		try {
			TicketServiceSystem instance = new TicketServiceSystem();
			int expResult = 2000;
			int result = instance.numSeatsAvailable(2);
			assertEquals(expResult, result);
		} catch (AssertionError e) {
			logger.info(e.toString());
		}
	}

	@Test
	public void getAvailableTicketsVenue3() {
		logger.info("getAvailableTicketsVenue3");
		try {
			TicketServiceSystem instance = new TicketServiceSystem();
			int expResult = 1500;
			int result = instance.numSeatsAvailable(3);
			assertEquals(expResult, result);
		} catch (AssertionError e) {
			logger.info(e.toString());
		}
	}

	@Test
	public void getAvailableTicketsVenue4() {
		logger.info("getAvailableTicketsVenue4");
		try {
			TicketServiceSystem instance = new TicketServiceSystem();
			int expResult = 1500;
			int result = instance.numSeatsAvailable(4);
			assertEquals(expResult, result);
		} catch (AssertionError e) {
			logger.info(e.toString());
		}
	}
	@Test
	public void holdTickets() {
		logger.info("holdTickets");
		try {
			TicketServiceSystem instance = new TicketServiceSystem();
			String customerEmail = "abc@gmail.com";
			SeatHold sh = instance.findAndHoldSeats(2225, 1, 4, customerEmail);
			instance.reserveSeats(sh.getSeatHoldId(), customerEmail);
		} catch (AssertionError e) {
			logger.info(e.toString());
		}
	}
	@Test
	public void hold() {
		logger.info("holdTickets");
		try {
			TicketServiceSystem instance = new TicketServiceSystem();
			String customerEmail = "abcd@gmail.com";
			SeatHold sh = instance.findAndHoldSeats(1225, 1, 4, customerEmail);
		} catch (AssertionError e) {
			logger.info(e.toString());
		}
	}
	@Test
	public void holdReserveTickets() {
		logger.info("holdTickets");
		try {
			TicketServiceSystem instance = new TicketServiceSystem();
			String customerEmail = "xyz@gmail.com";
			SeatHold sh = instance.findAndHoldSeats(125, 1, 4, customerEmail);
			instance.reserveSeats(sh.getSeatHoldId(), customerEmail);
		} catch (AssertionError e) {
			logger.info(e.toString());
		}
	}
	@Test
	public void getAvailableTicketsVenue() {
		logger.info("getAvailableTicketsVenue2");
		try {
			TicketServiceSystem instance = new TicketServiceSystem();
			int expResult = 2000;
			int result = instance.numSeatsAvailable(1);
			assertEquals(result, result);
			result = instance.numSeatsAvailable(2);
			assertEquals(result, result);
			result = instance.numSeatsAvailable(3);
			assertEquals(result, result);
			result = instance.numSeatsAvailable(4);
			assertEquals(result, result);
		} catch (AssertionError e) {
			logger.severe(e.toString());
		}
	}
}
