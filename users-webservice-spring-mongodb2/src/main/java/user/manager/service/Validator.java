package user.manager.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author imenb
 *
 */
public class Validator {

	private Date dateOfBirth;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Validator.class);
	

	/**
	 * @param dateOfBirth of User who want to register
	 * @return calculated age
	 * @throws ParseException to parse dateOfBirth
	 */
	public static int age(LocalDate dateOfBirth) throws ParseException {
	  
		LOGGER.info("=================== inside Age Calculator ===================");
		LOGGER.info("Date of birth "+ dateOfBirth);
		LocalDate l = LocalDate.of(dateOfBirth.getYear(), dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth()); //specify year, month, date directly
		LocalDate now = LocalDate.now(); //gets localDate
		Period diff = Period.between(l, now); //difference between the dates is calculated
		System.out.println(diff.getYears() + "years" + diff.getMonths() + "months" + diff.getDays() + "days");
				
		return diff.getYears();
	}
	
}
