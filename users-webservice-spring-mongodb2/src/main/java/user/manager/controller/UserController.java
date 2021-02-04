package user.manager.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import user.manager.model.User;
import user.manager.service.Validator;
import user.manager.repository.UserRepository;

/**
 * @author imenb
 *
 */
@RestController
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	private static final String ERROR_OF_AGE = "You must have 18 years old to register !";
	private static final String ERROR_OF_COUNTRY = "You must be in France to register !";

	@Autowired
	UserRepository userRepository;

	/**
	 * @param user a User to add in db
	 * @return ResponseEntity in case of valid request or error message
	 * @throws ParseException to parse the DateOfBirth
	 */
	@PostMapping("/user")
	public ResponseEntity registerUser(@Valid @RequestBody User user) throws ParseException {
		
		LOGGER.info("===================inside registerUser ===================");
		LOGGER.info("Enregistration with "+ user);
		
		int age = Validator.age(user.getDateOfbirth());
		
		if(age < 18 ) {
			LOGGER.error(ERROR_OF_AGE);
			return new ResponseEntity<>(ERROR_OF_AGE, HttpStatus.NOT_ACCEPTABLE);

		}
		
		else if(!user.getCountry().equalsIgnoreCase("France")) {
			LOGGER.error(ERROR_OF_COUNTRY);
			return new ResponseEntity<>(ERROR_OF_COUNTRY, HttpStatus.NOT_ACCEPTABLE);
		}
		else {
			
			LOGGER.info("Age valid ! "+ age);
			LOGGER.info("Country valid ! "+ user.getCountry());
			userRepository.save(user);
			LOGGER.info("User registred successfully !" + userRepository.findById(user.getId()));			
			return new ResponseEntity<>(userRepository.findById(user.getId()), HttpStatus.OK);
			
		}
	}
	
	/**
	 * @return List<User> list of Users if exist in db or a message
	 */
	@GetMapping("/users")
	public List<User> getUsers(){
		LOGGER.info("=================== inside getUsers ===================");
		return userRepository.findAll();
	}
	
	/**
	 * @param id associated or not to a specific User
	 * @return ResponseEntity if user exists  
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping("/user/{id}")
	public ResponseEntity getUser(@PathVariable String id){
		
		LOGGER.info("=================== inside getUser ===================");
		
		if(userRepository.findById(id).isPresent()) {
			LOGGER.info("User associated to id : "+ id + " : "+ userRepository.findById(id) );
			return new ResponseEntity<>(userRepository.findById(id), HttpStatus.OK);
		}
		else {
			LOGGER.info("User associated to id : "+ id + " not found!");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}
}
