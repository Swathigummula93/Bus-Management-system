package SpringProject.BusManagement.model;

import java.util.Date;
import org.hibernate.annotations.DynamicUpdate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
@DynamicUpdate
public class BusUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(length = 100, nullable = false)
	private String userName;
	
	@Column(length = 20, updatable = true)
	@Size(min = 8, max =20,message = "password must be between 8 to 20 characters long.")
	private String userPassword;
	
	
	@Column(length = 50, updatable = false, unique = true)
	@Email(message = "Email id format is incorrect.")
	private String userEmail;
	
	@Column(updatable = true)
	private Date dob;
	
	@Column(length = 150, updatable = true)
	private String about;
	
	@Column(length = 20, nullable = false, updatable = true)
	private String role;


	//@OneToMany(mappedBy = "user" ,cascade=CascadeType.ALL)
	//private List<Feedback> review = new ArrayList<>();
	

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userEmail="
				+ userEmail + ", dob=" + dob + ", about=" + about + ", role=" + role + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	//public List<Feedback> getReview() {
	//	return review;
	//}

	//public void setReview(List<Feedback> review) {
	//	this.review = review;
	//}

}
