package SpringProject.BusManagement.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
@DynamicUpdate
public class TravelAgency {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private  Integer agencyId;
    @Column(length=20,nullable=false)
    private String travelAgencyOwnerName;
    @Column(nullable=false,unique=true,updatable=true)
    private String travelAgencyEmail;
    @Column(length=20,nullable=false)
    private String travelAgencyName;
    @Column(nullable=true)
    private Integer establishedYear;
    
    public String getTravelAgencyName() {
		return travelAgencyName;
	}
	public void setTravelAgencyName(String travelAgencyName) {
		this.travelAgencyName = travelAgencyName;
	}
	
	public Integer getAgencyId() {
		return agencyId;
	}
	public void setAgencyId(Integer agencyId) {
		this.agencyId = agencyId;
	}
	public String getTravelAgencyOwnerName() {
		return travelAgencyOwnerName;
	}
	public void setTravelAgencyOwnerName(String travelAgencyOwnerName) {
		this.travelAgencyOwnerName = travelAgencyOwnerName;
	}
	public String getTravelAgencyEmail() {
		return travelAgencyEmail;
	}
	public void setTravelAgencyEmail(String travelAgencyEmail) {
		this.travelAgencyEmail = travelAgencyEmail;
	}
	public Integer getEstablishedYear() {
		return establishedYear;
	}
	public void setEstablishedYear(Integer establishedYear) {
		this.establishedYear = establishedYear;
	}
	@Override
	public String toString() {
		return "TravelAgency [agencyId=" + agencyId + ", travelAgencyOwnerName=" + travelAgencyOwnerName
				+ ", travelAgencyEmail=" + travelAgencyEmail + ", travelAgencyName=" + travelAgencyName
				+ ", establishedYear=" + establishedYear + ", bus=" + bus + "]";
	}
	@JsonIgnore
	@OneToMany(mappedBy = "travelAgency" ,cascade=CascadeType.ALL)
	private List<BusDetails> bus = new ArrayList<>();

	public List<BusDetails> getBus() {
		return bus;
	}
	public void setBus(List<BusDetails> bus) {
		this.bus = bus;
	} 
}
