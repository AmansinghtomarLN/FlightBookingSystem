package bookingSystem;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;


public class RunClient { 
	public static void main(String... args) throws IOException { 

// First way of providing files
/*
		String passengerFilePath = "D:/PassengerDetails.csv";
		String flightFilePath = "D:/FlightDetails.csv";
		FileWriter failure = new FileWriter("D://FailureLogs.txt");
*/		

// Second way of providing files through command line
		String passengerFilePath = args[0];
		String flightFilePath = args[1];
		FileWriter failure = new FileWriter(args[2]);

		
		List<PassengerDetails> passenger = readPassengerDetailsFromCSV(passengerFilePath); // let's print all the person read from CSV file 
		List<FlightDetails> flight = readFlightDetailsFromCSV(flightFilePath);
		
		
		
		
//		for (PassengerDetails b : passenger) { System.out.println(b); }
//		for (FlightDetails f : flight) { System.out.println(f); }
	

		
		// First Approach of Running 
		if(PassengerDetailsValidator.flightExists(passenger, flight)) {
			if(PassengerDetailsValidator.seatAvailability(passenger, flight)) {
				if(PassengerDetailsValidator.seatCategory(passenger, flight)) {
					PassengerDetailsValidator.calculatePrice(passenger, flight);
				}
			}
		}
		
		for(String s: PassengerDetailsValidator.failureMsg) {
			failure.write(s);
			failure.write("");
		}failure.close();
		
// Second Approach of Running
		/*		PassengerDetailsValidator.flightExists(passenger, flight);
		PassengerDetailsValidator.seatAvailability(passenger, flight);
		PassengerDetailsValidator.seatCategory(passenger, flight);
		PassengerDetailsValidator.calculatePrice(passenger, flight);
	*/	
	}
	
	

	
	public static List<PassengerDetails> readPassengerDetailsFromCSV(String fileName) {
		List<PassengerDetails> passenger = new ArrayList(); 
		Path pathToFile = Paths.get(fileName); // create an instance of BufferedReader 
		// using try with resource, Java 7 feature to close resources 
		
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) { 
			// read the first line from the text file 
			int count = 0;
			String line = br.readLine(); // loop until all lines are read
			while (line != null) {
				
					
				
					// use string.split to load a string array with the values from 
					// each line of 
					// the file, using a comma as the delimiter 
					String[] attributes = line.split(","); 
					PassengerDetails passenge = createpassenge(attributes); 
					// adding passenge into ArrayList 
					
					passenger.add(passenge); 
					// read next line before looping 
					// if end of file reached, line would be null 
					
					line = br.readLine(); 
					
				
				} 
			} catch (IOException ioe) { 
				ioe.printStackTrace(); 
				} return passenger; 
			} 
	
	
	public static List<FlightDetails> readFlightDetailsFromCSV(String fileName) {
		List<FlightDetails> flights = new ArrayList(); 
		Path pathToFile = Paths.get(fileName); // create an instance of BufferedReader 
		// using try with resource, Java 7 feature to close resources 
		
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) { 
			// read the first line from the text file 
			int count = 0;
			String line = br.readLine(); // loop until all lines are read
			while (line != null) {
				
					
				
					// use string.split to load a string array with the values from 
					// each line of 
					// the file, using a comma as the delimiter 
					String[] attributes = line.split(","); 
					FlightDetails flight = createFlight(attributes); 
					// adding passenge into ArrayList 
					
					flights.add(flight); 
					// read next line before looping 
					// if end of file reached, line would be null 
					
					line = br.readLine(); 
					
				
				} 
			} catch (IOException ioe) { 
				ioe.printStackTrace(); 
				} return flights; 
			} 
	
	
	
	
	public static PassengerDetails createpassenge(String[] metadata) { 
				String passengeingName = metadata[0]; 
				String flightNumber = metadata[1]; 
				String seatCategory= metadata[2];
				String numberOfSeats= metadata[3];
				String paymentCardNumber= metadata[4];
				
				PassengerDetails passenge = new PassengerDetails();
				
				passenge.setPassengerName(passengeingName);
				passenge.setFlightNumber(flightNumber);
				passenge.setSeatCategory(seatCategory);
				passenge.setNumberOfSeats(Integer.parseInt(numberOfSeats));
				passenge.setPaymentCardNumber(paymentCardNumber);
				
				return passenge;
				} 
			

public static FlightDetails  createFlight(String[] metadata) { 
	
	String category = metadata[0]; 
	String flightNumber = metadata[1]; 
	String seats = metadata[2];
	String price= metadata[3];
	String arrivalCity= metadata[3];
	String departureCity= metadata[4];
	
	FlightDetails flight = new FlightDetails();
	
	flight.setCategory(category);
	flight.setFlightNumber(flightNumber);
	flight.setSeats(Integer.parseInt(seats));
	flight.setPrice(Integer.parseInt(price));
	flight.setArrivalCity(arrivalCity);
	flight.setDepartureCity(departureCity);
	
	return flight;
	} 
} 


	class passenge { 
			
	}
			
		
