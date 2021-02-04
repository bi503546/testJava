package user.manager.resource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import user.manager.model.User;
import user.manager.repository.UserRepository;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	UserController userController;
	
	@Mock
	UserRepository userRepository;
	
    @BeforeAll
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

	/*
	 * @Test public void testGetUser(String id) {
	 * this.mockMvc.perform(get("/user/"+id)).andExpect(status().isOk())
	 * .andExpect(content().string()); }
	 */

    @Test
    public void testGetUser() {
            User user = new User("Imen", "Boukadida", "imen@gmail.com", LocalDate.of(1993, 1, 8), "France", 11);
       
 
    }
    
    @Test
	public void testGetUsers() 
	{
		// given
		User user1 = new User("1", "Imen", "Boukadida", "imen@gmail.com", LocalDate.of(1993, 1, 8), "France", 11);
		User user2 = new User("2", "test", "Boukadida", "imenboukdid@gmail.com", LocalDate.of(1993, 1, 8), "France", 11);
		
		List<User> list = new ArrayList<User>();
		list.addAll(Arrays.asList(user1, user2));

		when(userRepository.findAll()).thenReturn(list);

		// when
		List<User> result = userController.getUsers();

		// then
		assertThat(result.size()).isEqualTo(2);
		
		assertThat(result.get(0).getFirstname())
						.isEqualTo(user1.getFirstname());
		
		assertThat(result.get(1).getFirstname())
						.isEqualTo(user2.getFirstname());
	}
}
