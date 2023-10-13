package SpringProject.BusManagement.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringProject.BusManagement.Repository.UserRepository;
import SpringProject.BusManagement.model.BusUser;

@Service

public class UserServiceImplementation {
	@Autowired
	private UserRepository userRepository;
	

	public void addUser( BusUser user) {
		
		this.userRepository.save(user);
		
	}

	public  Optional<BusUser> getUserByEmail(String email) {
		
		return this.userRepository.findByuserEmail(email);
		
	}
	public List<BusUser> getAllUser(){
		return userRepository.findAll();
	}
	public BusUser viewUser(Integer userId ) {
		Optional<BusUser> user =  userRepository.findById(userId);  //null , or it can 5tg person rec
		if(user.isPresent()) {
			return user.get();
		}
		else {
			return null;
		}
	}
}