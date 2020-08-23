package datePackage;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

public class DateOperations {
	private Date inputDate;
	private LocalDate localdate;

	public DateOperations(LocalDate inputDate) throws ParseException {
		super();
		this.localdate = inputDate;
	}

	public LocalDate getLocaldate() {
		return localdate;
	}

	public int day() {
		return localdate.getDayOfMonth();
	}

	public int month() {
		return localdate.getMonthValue();
	}

	public int year() {
		return localdate.getYear();
	}

	public LocalDate addDays(int daysToAdd) {
		return localdate.plusDays(daysToAdd);
	}

	public LocalDate subtractDays(int daysToSubtract) {
		return localdate.minusDays(daysToSubtract);
	}

	public LocalDate addWeeks(int weeksToAdd) {
		return localdate.plusWeeks(weeksToAdd);
	}

	public LocalDate subtractWeeks(int weeksToSubtract) {
		return localdate.minusWeeks(weeksToSubtract);
	}

	public LocalDate addMonths(int monthsToAdd) {
		return localdate.plusMonths(monthsToAdd);
	}

	public LocalDate subtractMonths(int monthsToSubtract) {
		return localdate.minusMonths(monthsToSubtract);
	}

	public LocalDate addYears(int yearsToAdd) {
		return localdate.plusYears(yearsToAdd);
	}

	public LocalDate subtractYears(int yearsToStubtract) {
		return localdate.minusYears(yearsToStubtract);
	}

	public DayOfWeek dayOfWeek() {
		return localdate.getDayOfWeek();
	}

}
