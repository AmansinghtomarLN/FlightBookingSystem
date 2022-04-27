package bookingSystem;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVWriter;

public class PassengerDetailsValidator {
	
	public static ArrayList<String > failureMsg = new ArrayList<String>();

		public static List<String> flightNumberList(List<FlightDetails> flights){
			List<String> flightsNumbersList = new ArrayList<String>();
			for(FlightDetails f: flights) {
				flightsNumbersList.add(f.getFlightNumber());
			}
		//	System.out.println("total flights is "+flightsNumbersList.size());
			return flightsNumbersList;
		} 
	
		public static boolean seatAvailability(List<PassengerDetails> passengers, List<FlightDetails> flights) {
			boolean seat = true;
			
			for(PassengerDetails p: passengers) {
				for(FlightDetails f: flights) {
					if(p.getFlightNumber().equals(f.getFlightNumber())) {
							if(p.getNumberOfSeats()>f.getSeats()) {
								seat = false;
								failureMsg.add("Please enter correct booking details for "+p.getPassengerName()+ ": Invalid Seat Number");
								System.out.println(p.getNumberOfSeats()+" seats are not available for flight "+p.getFlightNumber()+" out of Total "+f.getSeats());
								break;	
							}		
						
					if(!seat) {break;}
					
					}if(!seat) {break;}
				}if(!seat) {break;}
			}
			
			return seat;
		}
		
		public static  boolean flightExists(List<PassengerDetails> passengers, List<FlightDetails> flights) {
			boolean exists = true;
			List<String> flightsNumberList = flightNumberList(flights);
			for(PassengerDetails p: passengers) {
				if(!flightsNumberList.contains(p.getFlightNumber())) {
					exists = false;
					failureMsg.add("Please enter correct booking details for "+p.getPassengerName()+ " : Invalid Flight Number");
				System.out.println("For passenger "+p.getPassengerName()+" Flight Number : "+p.getFlightNumber()+" Does Not Exists");
					break;
					}
				}		
			return exists;
		}
	
		public static int calculatePrice(List<PassengerDetails> passengers, List<FlightDetails> flights) throws IOException {
		int count = 0;
		
		CSVWriter bookingConfirm = new CSVWriter(new FileWriter("D://BookingSuccessful.csv"));
		String[] heading =  {"Name", "Flight", "Category", "Seats","Price"};
		bookingConfirm.writeNext(heading);	  
		//FileWriter failure = new FileWriter("D://fail.txt");
		
		SuccessfulBooking booking = new SuccessfulBooking();
			for(PassengerDetails p: passengers) {
				count++;
				for(FlightDetails f: flights) {
					if(p.getFlightNumber().equals(f.getFlightNumber()) && p.getSeatCategory().equals(f.getCategory())) {
						System.out.println("Total price is :"+p.getPassengerName()+" "+p.getNumberOfSeats()*f.getPrice()+ "for flight "+f.getFlightNumber()+" and "+ f.getCategory());
						// validate card number method
						if(validateCard(p.getPaymentCardNumber())) {
							System.out.println(booking);
						
							List<String> writeToCSV  = new ArrayList<String>();
							String[] print =  {p.getPassengerName(), p.getFlightNumber(), p.getSeatCategory(), Integer.toString(p.getNumberOfSeats()),Integer.toString(p.getNumberOfSeats()*f.getPrice())};
							bookingConfirm.writeNext(print);	  
						}else{
							System.out.println(p.getPassengerName() +"details is incorrect");
							failureMsg.add("Please enter correct booking details for "+ p.getPassengerName() +" : Invalid Card Number");
						}
					}
				}
			
			
		}	bookingConfirm.flush(); 	//failure.close(); 
		return 0;
		}
		
		
		public static boolean validateCard(String cardNumber) {
			boolean card = false;
			
			if(cardNumber.charAt(0)=='4' && cardNumber.length()==13 || cardNumber.length()==16 ) {
				System.out.println("Visa Card");
				card = true;
			}else if(cardNumber.charAt(0)=='5' && cardNumber.length()==16 ) {
				System.out.println("Master Card");
				card = true;
			}else if(cardNumber.length()==16 && cardNumber.substring(0, 4).equals("6011")) {
				System.out.println("Discover");
				card = true;
			}else if (cardNumber.length()==15 && cardNumber.charAt(0)=='3' && cardNumber.charAt(1)=='4' || cardNumber.charAt(1)=='7' ) {
				System.out.println("Amex");
				card = true;
			}else if (cardNumber.length()>=19) {
				System.out.println("Invalid card : length is more than or equal to  19 digits");
			}else {
				System.out.println("Please input valid card");
			}
		return card;	
		}
		
		
		
		
		public static boolean seatCategory(List<PassengerDetails> passengers, List<FlightDetails> flights) {
			boolean seat = true;
			
			for(PassengerDetails p: passengers) {
				for(FlightDetails f: flights) {
					if(p.getFlightNumber().equalsIgnoreCase(f.getFlightNumber()) ) {

						if(!(p.getSeatCategory().equalsIgnoreCase(f.getCategory()))) {
							seat = false;
							System.out.println("Flight Number "+ p.getFlightNumber() + " "+ f.getFlightNumber());
							System.out.println("Flight category does not exists"+ p.getSeatCategory()+ " "+ f.getCategory());
							failureMsg.add("Please enter correct booking details for "+ p.getPassengerName() +" : Invalid Seat Category");
							return seat;
						}
						
							
					}
				}
			}
			
			return seat;
		}
		
		
		
}
	