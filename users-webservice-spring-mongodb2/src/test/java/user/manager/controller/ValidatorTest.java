package user.manager.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import user.manager.service.Validator;

import java.text.ParseException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ValidatorTest {



    @Test
    public void AgeTest() throws ParseException {
        assertEquals(Validator.age((LocalDate.of(1993, 02, 18))), 27);
    }
}