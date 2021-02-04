package user.manager.resource;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author imenb
 *
 */
public class AgeCalculator {

	private Date dateOfBirth;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	

	/**
	 * @param dateOfBirth of User who want to register
	 * @return calculated age
	 * @throws ParseException to parse dateOfBirth
	 */
	public static int Age(LocalDate dateOfBirth) throws ParseException {
	  
		LOGGER.info("=================== inside Age Calculator ===================");
		LOGGER.info("Date of birth "+ dateOfBirth.toString());
		LocalDate l = LocalDate.of(dateOfBirth.getYear(), dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth()); //specify year, month, date directly
		LocalDate now = LocalDate.now(); //gets localDate
		Period diff = Period.between(l, now); //difference between the dates is calculated
		System.out.println(diff.getYears() + "years" + diff.getMonths() + "months" + diff.getDays() + "days");
				
		return diff.getYears();
	}
	
}
