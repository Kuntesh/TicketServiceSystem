README

included:
All source files: TicketServiceSystem.java, TicketService.java, SeatHold.java, Venue.java and TicketServiceTest.java
Required jars for executing test cases: junit-4.10.jar, rt.jar(for loggers and other java.util classes)

Regarding the implementation:
I have used same interface as provided in the given assignment. I have named it as TicketService.java which has 3 important methods
as mentioned in the assignment. I have modified numSeatsAvailable and findAndHoldSeats by accepting integers instead of given Optional<Integer>

I have implemented this interface into my actual TicketServiceSystem class. I have written 4 methods in this class. Out of them, 3 are implemented 
from the interface and run() method is used to reset the hold tickets count to 0 after few secs.

SeatHold class has some attributes and holds critical information for the customer after holding the seats. It's logic is implemented in 
findAndHoldSeats method.

Venue is a singleton class which creates one instance for each venue. There are some key attributes in this class.

TicketServiceTest is for testing purpose where several methods are written to run different test cases.

Algorithm explanation:
Since Venue is singleton, we will have only one instance for each venue levels. For example, if someone asks for available tickets information
or any other hold/ reserve functions, we will have updated value of the Venue class for each instance called.

For numSeatsAvailable(), we will have available seats returned to the user for the requested venue level.

In findAndHoldSeats(), seperate thread will be started which will make sure that any hold tickets are reset after few secs. Also, we will have 
seat hold id created for each customer email and it will be set in the SeatHold object.
We will check if the requested number of seats are available for the venues. If not, we will return an error message. Else, we will continue 
with our flow. I have sorted the venues according to their available seats so that maximum requested seats are at same venue level.
This is used for obtaining best possible venues for requested seats.
I will check if the requested seats can be fulfilled at the same level. 
If not, then I will distribute seats accordingly so that most of the seats are together at the same venue level.
I have used HashMap for holding seatHold id against SeatHold object for easy retrieval while reserving those seats.

reserveSeats() takes seatHold id and customer email.
Program will get SeatHold object based on the seatHold Id. Based on that, I will get list of venues for which user has hold the tickets.
I will reserve those seats and reset hold tickets count for that venue. Since, it's singleton, we will always have updated value for any venue.
Lastly, I will generate confirmation number randomly and set my confirmation map with confirmation number and customer email 
to keep the record of each user. I will return this confirmation number back to the user.

For testing, I have written some junit test cases in TicketServiceTest.java which contains methods for some test cases.
One can modify these methoda to check desired result.

Issues faced during implementation:
I didn't actually get why we need Optional<Integer> instead of just an integer. I assumed it should be integer and moved ahead.
Initially, I wasn't sure how to reset the hold tickets count. Thought of using thread as the best option.
Due to time constraint, I implemented numSeatsAvailable() which returns number of seats for the requested venue but couldn't do it by seating level.
I was facing some problem while designing SeatHold object but to my best knowledge I have designed it accordingly so that it contains all key elements.
