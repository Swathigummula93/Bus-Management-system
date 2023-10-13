package SpringProject.BusManagement.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import SpringProject.BusManagement.Repository.TravelAgencyRepository;
import SpringProject.BusManagement.Service.BusManagementService;
import SpringProject.BusManagement.ServiceImplementation.BusManagementServiceImplementation;
import SpringProject.BusManagement.model.BusDetails;


@CrossOrigin
@RestController
@RequestMapping("/edubridge.com")
public class BusManagementController {
	@Autowired
	private TravelAgencyRepository agencyRepository;
	@Autowired
	private BusManagementServiceImplementation busService;
	public  void BusController(BusManagementServiceImplementation busService) {
		this.busService =busService;
	}

	@GetMapping("/getAllBuses")
	public ResponseEntity<List<BusDetails>> getAllbuses(@RequestParam(required = false) String agencyName) {
		try {
			List<BusDetails> buses = new ArrayList<BusDetails>();

			if (agencyName == null)
				busService.fetchbusesFromDb().forEach(buses::add);
			else
				busService.fetchOptionedDetails(agencyName).forEach(buses::add);

			if (buses.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(buses, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
//	// create bus rest api
//	@PostMapping("/savebus")
//	public ResponseEntity<BusDetails> saveBus(@RequestBody BusDetails busDetailsObj) {
//		try {
//			return new ResponseEntity<>(busService.saveBus(busDetailsObj), HttpStatus.CREATED);
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
	@PostMapping("/saveBusDetails/{agencyId}")
	public ResponseEntity<BusDetails> saveBus(@PathVariable("agencyId") int agencyId,@RequestBody BusDetails bus) {
		try {
			agencyRepository.findById(agencyId).map(travelAgency -> {
				bus.setTravelAgency(travelAgency);
			return new ResponseEntity<BusDetails>(busService.saveBus(bus), HttpStatus.CREATED);
			}).orElseThrow(() -> new Exception("Internal_Server_Error"));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
		};

	// to get bus by id rest api
	@GetMapping("/getAllBuses/{bus_Id}")
	public ResponseEntity<BusDetails> getBusById(@PathVariable Integer bus_Id) {

		//serv.method name 
		return new ResponseEntity<>(busService.getBusdetailsById(bus_Id), HttpStatus.OK);


	}

	// update bus rest api
	@PutMapping("/updatebus/{bus_Id}")
	public ResponseEntity<BusDetails> updateBus(@PathVariable Integer bus_Id, @RequestBody BusDetails busDetailsObj){
		return new ResponseEntity<>(busService.updateBusdetailsById(busDetailsObj,bus_Id), HttpStatus.OK);

	}

	// delete employee rest api
	@DeleteMapping("/deleteBus/{bus_Id}")
	public ResponseEntity<BusDetails> deleteBus(@PathVariable("bus_Id")int bus_Id){
		Optional<BusDetails> busdata = 	Optional.empty();
		try {
			if (busdata.isPresent()) {
				busService.deleteBusdetailsById(bus_Id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//delete all details rest api
	@DeleteMapping("/deleteAllBuses")
	public ResponseEntity<HttpStatus> deleteAllDetails() {
		//return new ResponseEntity<>(busservice.deleteallBusdetails(),HttpStatus.OK);
		try {
			busService.deleteallBusdetails();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//api to get AC bus details 	
	@GetMapping("/getAllBuses/isACBus")
	public ResponseEntity<List<BusDetails>> findIsACBuses() {
		try {
			//call serv
			//getallbusbyACbusdomain()
			List<BusDetails> buses= busService.fetchACBus(true);

			if (buses.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(buses, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//api to get non AC bus details
	@GetMapping("/getAllBuses/NonACbus")
	public ResponseEntity<List<BusDetails>> findNonACBuses() {
		try {
			//call serv
			//getallbusbyACbusdomain()
			List<BusDetails> buses= busService.fetchNonACBus(false);

			if (buses.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(buses, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/searchBusesBySourceAndDestination")
	public ResponseEntity<List<BusDetails>> getBusBySourceAndDestination(@RequestParam(required = true) String source,String destination){
		try {
			List<BusDetails> buses = busService.fetchBySourceAndDestination(source,destination);

			if (buses.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(buses, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/searchBusesByAgencyName")
	public ResponseEntity<List<BusDetails>> getBusByAgencyName(@RequestParam(required = true) String agencyName){
		try {
			List<BusDetails> buses = busService.fetchByAgencyName(agencyName);

			if (buses.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(buses, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/sortByPrice/{direction}")
	public ResponseEntity<List<BusDetails>> getAllBusesByPriceSort(@PathVariable("direction") String direction, @RequestParam(required = true)String fieldName){
		try {
		List<BusDetails> buses = new ArrayList<BusDetails>();
		buses = busService.sortByTicketPrice(direction, fieldName);
		if(buses.isEmpty())
			return new ResponseEntity<List<BusDetails>>(HttpStatus.NO_CONTENT);
		
	    return new ResponseEntity<List<BusDetails>>(buses,HttpStatus.OK);
	    
	}
		catch(Exception exc) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping("/sortByRating/{direction}")
	public ResponseEntity<List<BusDetails>> getAllBusesByRatingSort(@PathVariable("direction") String direction, @RequestParam(required = true)String fieldName){
		try {
		List<BusDetails> buses = new ArrayList<BusDetails>();
		buses = busService.sortByRating(direction, fieldName);
		if(buses.isEmpty())
			return new ResponseEntity<List<BusDetails>>(HttpStatus.NO_CONTENT);
		
	    return new ResponseEntity<List<BusDetails>>(buses,HttpStatus.OK);
	    
	}
		catch(Exception exc) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}



