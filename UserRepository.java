package SpringProject.BusManagement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import SpringProject.BusManagement.model.BusUser;
@Repository
public interface UserRepository extends JpaRepository<BusUser , Integer> {
	@Query(value = "SELECT * FROM BUS_USER u WHERE u.user_email = ?1",nativeQuery = true  )
	public Optional<BusUser> findByuserEmail(String email);
	
	
	@Query(value = "SELECT * FROM BUS_USER u WHERE u.user_email = ?1 AND u.user_password = ?2 ",nativeQuery = true  )
	public Optional<BusUser>  findByuserEmailAndPassword(String email, String password);
}