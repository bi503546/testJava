package user.manager.resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AgeCalculatorTest {



    @Test
    public void AgeTest() throws ParseException {
        assertEquals(AgeCalculator.age((LocalDate.of(1993, 02, 18))), 27);
    }
}