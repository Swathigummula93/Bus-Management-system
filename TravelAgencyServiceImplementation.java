package SpringProject.BusManagement.ServiceImplementation;

import java.util.ArrayList;
import java.util.List;



import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringProject.BusManagement.Repository.TravelAgencyRepository;
import SpringProject.BusManagement.Service.TravelAgencyService;
import SpringProject.BusManagement.model.TravelAgency;

@Service
public class TravelAgencyServiceImplementation implements TravelAgencyService {
	
	@Autowired
	private TravelAgencyRepository agencyRepository;

	public   TravelAgencyServiceImplementation(TravelAgencyRepository agencyRepository ){
		this.agencyRepository=agencyRepository;
	}
	@Override
	public TravelAgency saveAgency(TravelAgency agencyName) {

		return agencyRepository.save(agencyName);
	}

	@Override
	public TravelAgency  getAgencyDetailsById(Integer agencyId) {
		Optional<TravelAgency> agency = agencyRepository.findById(agencyId);
		if(agency.isPresent())
			return agency.get();
		else
			return null;

	}

	@Override
	public TravelAgency updateAgencyDetails(TravelAgency newAgency ,Integer agencyId) {
		Optional<TravelAgency> agency= agencyRepository.findById(agencyId);
		if(agency.isPresent()) {
			TravelAgency existingAgency = agency.get();
			existingAgency.setTravelAgencyOwnerName(newAgency.getTravelAgencyOwnerName());
			existingAgency.setTravelAgencyEmail(newAgency.getTravelAgencyEmail());
			existingAgency.setAgencyId(newAgency.getAgencyId());
			existingAgency.setEstablishedYear(newAgency.getEstablishedYear());
			agencyRepository.save(existingAgency);
			return newAgency;

		}
		else {
			return null;
		}
	}
	@Override
	public void deleteAgencyDetailsById(Integer agencyId) {
		Optional<TravelAgency> agency = agencyRepository.findById(agencyId);
		if(agency.isPresent())
			agencyRepository.deleteById(agencyId);

	}

	@Override
	public void deleteAllAgencyDetails() {
		agencyRepository.deleteAll();
		System.out.println("All AgencyDetails are deleted");

	}
	@Override
	public List<TravelAgency>getAllAgencyDetails() {
		List<TravelAgency> agency = new ArrayList<TravelAgency>();
		agency = agencyRepository.findAll();
		return agency;
	}
	
} 
