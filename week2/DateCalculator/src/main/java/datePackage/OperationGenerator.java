package datePackage;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class OperationGenerator {

	Random randomiser = new Random();

	List<String> operationNature = List.of("Mathematical", "English");
	List<String> keyPhrases = List.of("day", "week", "month", "year");

	List<String> generalPhrases = List.of("Today", "Tomorrow", "Day after tomorrow", "yesterday",
			"Day before yesterday", "Last week", "Previous week", "Next week", "Next month", "Next Year", "Last month",
			"Last year", "Month after", "Month before", "Exit");

	public String operationNatureGenerator() {
		return operationNature.get(randomiser.nextInt(2));
	}

	public int mathematicalCaseOptionNumber() {
		return randomiser.nextInt(8);
	}

	public int mathematicalCaseOperationValue() {
		return randomiser.nextInt(100);
	}

	public String genralPhraseGenerator() {
		return generalPhrases.get(randomiser.nextInt(generalPhrases.size()));
	}

	public static int createRandomIntBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}

	public static LocalDate createRandomDate(int startYear, int endYear) {
		int day = createRandomIntBetween(1, 28);
		int month = createRandomIntBetween(1, 12);
		int year = createRandomIntBetween(startYear, endYear);
		return LocalDate.of(year, month, day);
	}

	public LocalDate generateRandomDate() {
		LocalDate randomDate = createRandomDate(1000, 3000);
		return randomDate;
	}
}
