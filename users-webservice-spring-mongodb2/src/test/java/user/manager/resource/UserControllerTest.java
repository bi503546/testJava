package user.manager.resource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import user.manager.model.User;
import user.manager.repository.UserRepository;
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class UserControllerTest {

	private MockMvc mockMvc;


	@MockBean
	UserRepository userRepository;

	@InjectMocks
	@Autowired
	UserController userController;

	@BeforeAll
    public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

	/*@Test
	public void testRegisterUser() throws Exception {
		String userToRegister = "{ \"user\": [{ \"firstname\": \"Imen\", \"lastname\": \"Imen\", \"email\": \"imen@hotmail.com\", \"dateOfbirth\": \"1993-02-12\", \"country\": \"France\", \"phone\": \"1111\"}]}";
		MockHttpServletRequestBuilder req = post("http://localhost:5557/user").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.content(userToRegister);
		this.mockMvc.perform(req).andExpect(status().isOk());
		*//*User user = new User("Imen", "Boukadida", "imen@gmail.com", LocalDate.of(1993, 1, 8), "France", 11);
		User registredUser = new User();
		when(userRepository.save(user)).thenReturn(registredUser);

		assertEquals(user, userController.registerUser(registredUser));
	*//*}*/


	@Test
    public void testGetUser() {
            User user = new User("id2020","Imen", "Boukadida", "imen@gmail.com", LocalDate.of(1993, 1, 8), "France", 11);
			when(userRepository.findById("id2020")).thenReturn(Optional.of(user));
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
		List<User> result = userController.getUsers();
		assertNotNull(result);
		// then
		assertThat(result.size()).isEqualTo(2);

		assertThat(result.get(0).getFirstname())
						.isEqualTo(user1.getFirstname());
		
		assertThat(result.get(1).getFirstname())
						.isEqualTo(user2.getFirstname());
	}
}
