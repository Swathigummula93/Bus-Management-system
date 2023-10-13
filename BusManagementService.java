package SpringProject.BusManagement.Service;

import java.util.List;

import SpringProject.BusManagement.model.BusDetails;

//service interface is created
public interface BusManagementService {
	BusDetails saveBus(BusDetails busDetailsObj);
	List<BusDetails>fetchbusesFromDb();
	BusDetails getBusdetailsById(int bus_Id);
	BusDetails updateBusdetailsById(BusDetails busDetailsObj, int bus_Id);
	void deleteBusdetailsById(int bus_Id);
	List<BusDetails> deleteallBusdetails();
	static List<BusDetails> fetchACBus(boolean b) {
		// TODO Auto-generated method stub
		return null;
	}
	
		
	}

