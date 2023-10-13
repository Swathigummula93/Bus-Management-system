package SpringProject.BusManagement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SpringProject.BusManagement.model.TravelAgency;

@Repository
public interface TravelAgencyRepository extends JpaRepository<TravelAgency,Integer>{

			Optional<TravelAgency> findById(int agencyId);

			
}
