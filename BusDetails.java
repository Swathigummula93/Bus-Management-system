package SpringProject.BusManagement.model;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Bus_Management_System")
@DynamicUpdate
public class BusDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bus_Id;
	private String source;
	private String destination;
	private Double ticket_Price;
	private String driverName;
	private Integer no_Of_Tickets_Booked;
	private Integer no_Of_Tickets_Vaccant;
	public Double getTicket_Price() {
		return ticket_Price;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public Integer getNo_Of_Tickets_Booked() {
		return no_Of_Tickets_Booked;
	}
	public void setNo_Of_Tickets_Booked(Integer no_Of_Tickets_Booked) {
		this.no_Of_Tickets_Booked = no_Of_Tickets_Booked;
	}
	public Integer getNo_Of_Tickets_Vaccant() {
		return no_Of_Tickets_Vaccant;
	}
	public void setNo_Of_Tickets_Vaccant(Integer no_Of_Tickets_Vaccant) {
		this.no_Of_Tickets_Vaccant = no_Of_Tickets_Vaccant;
	}
	public void setTicket_Price(Double ticket_Price) {
		this.ticket_Price = ticket_Price;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	private Integer rating;
	
	
	public Integer getBus_Id() {
		return bus_Id;
	}
	public void setBus_Id(Integer bus_Id) {
		this.bus_Id = bus_Id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getNo_Of_Seats() {
		return no_Of_Seats;
	}
	public void setNo_Of_Seats(int no_Of_Seats) {
		this.no_Of_Seats = no_Of_Seats;
	}
	public boolean isACBus() {
		return isACBus;
	}
	public void setACBus(boolean isACBus) {
		this.isACBus = isACBus;
	}
	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	int no_Of_Seats;
	boolean isACBus;
	String agencyName;
	
	@JoinColumn(name="agencyId")
	@ManyToOne
	private TravelAgency travelAgency;
	public TravelAgency getTravelAgency() {
		return travelAgency;
	}

	public void setTravelAgency(TravelAgency travelAgency) {
		this.travelAgency = travelAgency;
	}
	@Override
	public String toString() {
		return "BusDetails [bus_Id=" + bus_Id + ", source=" + source + ", destination=" + destination
				+ ", ticket_Price=" + ticket_Price + ", driverName=" + driverName + ", no_Of_Tickets_Booked="
				+ no_Of_Tickets_Booked + ", no_Of_Tickets_Vaccant=" + no_Of_Tickets_Vaccant + ", rating=" + rating
				+ ", no_Of_Seats=" + no_Of_Seats + ", isACBus=" + isACBus + ", agencyName=" + agencyName
				+ ", travelAgency=" + travelAgency + "]";
	}

}
