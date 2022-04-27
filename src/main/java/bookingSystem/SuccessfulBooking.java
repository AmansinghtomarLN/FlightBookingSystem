package bookingSystem;

public class SuccessfulBooking {

	public String name;
	public String flightNumber;
	public String category;
	public String noOfSeats;
	public String totalPrice;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(String noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "SuccessfulBooking [name=" + name + ", flightNumber=" + flightNumber + ", category=" + category
				+ ", noOfSeats=" + noOfSeats + ", totalPrice=" + totalPrice + "]";
	}
	
	
	
}
