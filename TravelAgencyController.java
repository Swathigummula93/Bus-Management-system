package SpringProject.BusManagement.Controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import SpringProject.BusManagement.ServiceImplementation.TravelAgencyServiceImplementation;
import SpringProject.BusManagement.model.TravelAgency;

@CrossOrigin
@RestController
@RequestMapping("/edubridge.com")
public class TravelAgencyController {
	@Autowired
	private TravelAgencyServiceImplementation agencyService;

	public TravelAgencyController(TravelAgencyServiceImplementation agencyService) {
		this.agencyService = agencyService;
	}

	@PostMapping("/saveAgencyDetails")
	public ResponseEntity<TravelAgency> createAgency(@RequestBody TravelAgency agency)throws Exception{
		try {
			return new ResponseEntity<TravelAgency>(agencyService.saveAgency(agency),HttpStatus.CREATED);
		}
		catch(Exception exc) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/updateAgencyName/{agencyId}")
	public ResponseEntity<TravelAgency> updateAgency(@PathVariable("agencyId") Integer agencyId ,@RequestBody TravelAgency agency) throws Exception{
		try {
			return new ResponseEntity<TravelAgency>(agencyService.updateAgencyDetails(agency, agencyId),HttpStatus.OK);
		}
		catch(Exception exc){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getAgencyDetailsById/{agencyId}")
	public ResponseEntity<TravelAgency>readAgencyDetailsById(@PathVariable("agencyId")Integer agencyId) throws Exception{
		try {
			return new ResponseEntity<TravelAgency>(agencyService.getAgencyDetailsById(agencyId),HttpStatus.OK);
		}
		catch(Exception exc) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/deleteAgencyDetails/{agencyId}")
	public void deleteAgencyDetailsById(@PathVariable("agencyId") Integer agencyId) throws Exception{
		try {
			agencyService.deleteAgencyDetailsById(agencyId);
		}
		catch(Exception exc) {
			System.out.println(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/deleteAllAgencyDetails")
	public void deleteAllAgency()throws Exception{
		try {
			agencyService.deleteAllAgencyDetails();
		}
		catch(Exception exc) {
			System.out.println(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getAllAgencyDetails")
	public ResponseEntity<List<TravelAgency>>fetchAllAgency(){
		try {
			return new ResponseEntity<List<TravelAgency>>(agencyService.getAllAgencyDetails(),HttpStatus.OK);
		}
		catch(Exception exc) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
}
