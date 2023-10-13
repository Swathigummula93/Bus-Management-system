package SpringProject.BusManagement.Service;

import java.util.List;

import SpringProject.BusManagement.model.TravelAgency;

public interface TravelAgencyService {
	
		TravelAgency saveAgency(TravelAgency agency);
		TravelAgency getAgencyDetailsById(Integer agencyId);
		TravelAgency updateAgencyDetails(TravelAgency newAgency,Integer agencyId);
		//TravelAgency updateAgencyDetails(Integer agencyId);
		void deleteAgencyDetailsById(Integer agencyId);
		void deleteAllAgencyDetails();
		List<TravelAgency>getAllAgencyDetails();

}
