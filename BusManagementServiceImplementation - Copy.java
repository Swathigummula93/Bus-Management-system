package SpringProject.BusManagement.ServiceImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import SpringProject.BusManagement.Repository.BusManagementRepository;
import SpringProject.BusManagement.Service.BusManagementService;
import SpringProject.BusManagement.model.BusDetails;
@Service
public class BusManagementServiceImplementation implements BusManagementService {

	@Autowired
	private BusManagementRepository busRepository;

	public BusManagementServiceImplementation(BusManagementRepository busRepository) {
		this.busRepository = busRepository;
	}
	//save bus details	
	public BusDetails saveBus(BusDetails busDetailsObj) {
		return  busRepository.save(busDetailsObj);
	}
	//get all bus details

	@Override
	public List<BusDetails> fetchbusesFromDb() {
		return busRepository.findAll();  
	}
	//get bus details by id
	@Override//5
	public BusDetails getBusdetailsById(int bus_Id) { //23
		Optional<BusDetails> busDetailsObj =  busRepository.findById(bus_Id);  //null , or it can 5tg person rec
		if(busDetailsObj.isPresent()) {
			return busDetailsObj.get();
		}
		else {
			return null;
		}
	}
	//update bus details by id
	public BusDetails updateBusdetailsById(BusDetails newVal,int bus_Id) {
		Optional<BusDetails>bus=busRepository.findById(bus_Id);
		if(bus.isPresent()) {
			BusDetails existingbus=bus.get();
			existingbus.setSource(newVal.getSource());
			existingbus.setDestination(newVal.getDestination());
			busRepository.save(existingbus);
			return existingbus;
		}
		else {
			return null;

		}

	}

	//delete bus details by bus_id
	@Override
	public void deleteBusdetailsById(int bus_Id) {
		Optional<BusDetails> busDetailsObj = busRepository.findById(bus_Id);
		if(busDetailsObj.isPresent()) {
			busRepository.deleteById(bus_Id);
		}	
	}
		
	
	//delete all bus details
	@Override
	public List<BusDetails> deleteallBusdetails() {
		return busRepository.findAll(); 
	}	
	//	public List<Bus>getBusBysource(String source){
	//		return busRepository.findBySource(source);
	//	}
	//public List<Bus> getBusesByNames(String source,String destination) {
	//return busRepository.findBySourceAndDestination(source, destination);
	//}
	//	@Override
	//	public Bus savebus(Bus busmanagement) {
	// TODO Auto-generated method stub
	//return null;
	//}
	//@Override
	//public Bus updateBusDetailsById(Bus busmanagement, int bus_id) {
	// TODO Auto-generated method stub
	//return null
	
	//get all AC buses details
	public List<BusDetails> fetchACBus(boolean booleanObj) {
		List<BusDetails> busDetailsObj = busRepository.findByIsACBus(true);
		return busDetailsObj;
	}
	
	//get all non AC buses details
	public List<BusDetails> fetchNonACBus(boolean booleanObj) {
		List<BusDetails> busDetailsObj = busRepository.findByIsACBus(false);
		return busDetailsObj;
}
	
	
	
	public List<BusDetails> fetchOptionedDetails(String agencyName) {
		List<BusDetails> busDetailsObj = busRepository.findByagencyName(agencyName);
		return busDetailsObj;
	}
	
	//search bus details by source and destination
	public List<BusDetails> fetchBySourceAndDestination(String source ,String destination){
		List<BusDetails> buses = new ArrayList<BusDetails>();
		busRepository.findBySourceAndDestination(source, destination).forEach(buses::add);
		return buses;
	}
	
	//search bus details by agency name	
	public List<BusDetails> fetchByAgencyName(String agencyName) {
		List<BusDetails> busDetailsObj = busRepository.findByagencyName(agencyName);
		return busDetailsObj;
	}
	
	// sort bus details by ticket price
	public  List<BusDetails> sortByTicketPrice(String direction, String fieldName) {
		
		List<BusDetails> buses = new ArrayList<BusDetails>();
		buses = busRepository.findAll(Sort.by(getSortDirection(direction), fieldName));
		return buses;
	}
	private Sort.Direction getSortDirection(String direction) {
	    if (direction.equals("asc")) {
	      return Sort.Direction.ASC;
	    } else if (direction.equals("desc")) {
	      return Sort.Direction.DESC;
	    }

	    return Sort.Direction.ASC;
	  }
	
   //sort bus details by ratings	
   public  List<BusDetails> sortByRating(String direction, String fieldName) {
		
		List<BusDetails> buses = new ArrayList<BusDetails>();
		buses = busRepository.findAll(Sort.by(getSortDirection(direction), fieldName));
		return buses;
	}
public List<BusDetails> findByIsACBus(boolean b) {
	// TODO Auto-generated method stub
	return null;
}
}
	
		


	
	
	
		
	

