package SpringProject.BusManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SpringProject.BusManagement.model.BusDetails;

//repository interface is created
@Repository
public interface BusManagementRepository extends JpaRepository<BusDetails,Integer>{
	//List<BusDetails> findBySource(String source);
		//	List<BusDetails> findBySourceAndDestination(String source, String destination);
		//	List<BusDetails> findBySourceOrDestination(String  source, String destination);
		
		List<BusDetails> findByIsACBus(Boolean booleanObj);
		
		List<BusDetails> findByagencyNameContainingIgnoreCase(String agencyName);
	//List<BusDetails> fetchOptionedDetails(String agencyName);
	//List<BusDetails> findByIsNonACBus(Boolean booleanObj);

		List<BusDetails> findByagencyName(String agencyName);

		Iterable<BusDetails> findBySourceAndDestination(String source, String destination);
	    
		//List<BusDetails> sortByRating(Integer rating);
		
		//List<BusDetails> sortByTicketPrice(Double ticket_Price);

}
		



