package user.manager.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import user.manager.model.User;

/**
 * @author imenb
 *
 */
public interface UserRepository extends MongoRepository<User, String>{

	List<User> findAll();


}
