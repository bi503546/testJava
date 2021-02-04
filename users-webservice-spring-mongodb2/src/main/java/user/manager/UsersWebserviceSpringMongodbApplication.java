package user.manager;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author imenb
 *
 */
@SpringBootApplication
public class UsersWebserviceSpringMongodbApplication {

	public static void main(String[] args) {
		
		 SpringApplication app = new SpringApplication(UsersWebserviceSpringMongodbApplication.class);
	     app.setDefaultProperties(Collections.singletonMap("server.port", "5557"));
	     app.run(args);
		
	}
}
