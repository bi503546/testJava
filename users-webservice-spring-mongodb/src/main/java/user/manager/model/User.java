package user.manager.model;

import java.time.LocalDate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;



/**
 * @author imenb
 *
 */
@Document(collection="User")
public class User {

	@Id
	private String _id;
	
	@NotNull
	private String firstname;
	
	@NotNull
	private String lastname;
	
	@Email @NotBlank(message="the email field is mandatory")
	private String email;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate dateOfBirth;
	
	@NotBlank(message="the country field is mandatory")
	private String country;
	
	private long phone;
	
	/**
	 * Constructor
	 * @param _id
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param dateOfBirth
	 * @param country
	 * @param phone
	 */
	public User(String _id, @NotNull String firstname, @NotNull String lastname,
			@Email @NotBlank(message = "the email field is mandatory") String email, LocalDate dateOfBirth,
			@NotBlank(message = "the country field is mandatory") String country, long phone) {
		super();
		this._id = _id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.country = country;
		this.phone = phone;
	}
	
	
	
	/**
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param dateOfBirth
	 * @param country
	 * @param phone
	 */
	public User(@NotNull String firstname, @NotNull String lastname,
			@Email @NotBlank(message = "the email field is mandatory") String email, LocalDate dateOfBirth,
			@NotBlank(message = "the country field is mandatory") String country, long phone) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.country = country;
		this.phone = phone;
	}



	public String getId() {
		return _id;
	}
	public void setId(String _id) {
		this._id = _id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDateOfbirth() {
		return dateOfBirth;
	}
	public void setDateOfbirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "User [_id=" + _id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", dateOfBirth=" + dateOfBirth + ", country=" + country + ", phone=" + phone + "]";
	}
	
	
}
