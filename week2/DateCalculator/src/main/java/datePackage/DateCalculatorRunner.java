package datePackage;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class DateCalculatorRunner {


	private static OperationListSerializer serializer;

	public static void main(String[] args) throws ParseException, ClassNotFoundException, IOException {
		boolean entireRepeat = true;
		LocalDate result;
		Operation operationToBeSerialized;
		ArrayList<Operation> operationsList = new ArrayList<>();
		OperationGenerator generator = new OperationGenerator();
		int operationCount = 0;

		while(entireRepeat) {
			boolean currentRepeat = true;
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please enter a date:");

			System.out.println(OperationGenerator.createRandomDate(1900, 2000));
			DateOperations localDate = new DateOperations(OperationGenerator.createRandomDate(1900, 2000));
			if (operationCount >= 100000) {
				entireRepeat = false;
				break;
			}

			System.out.println("All the following operations will be performed with respect to the above date");
			int year = localDate.year();
			int month = localDate.month();
			int day = localDate.month();

			System.out.println("What type of operations do you want to perform? Mathematical/English-based");

			String typeOfOperation = generator.operationNatureGenerator();

			switch (typeOfOperation) {

			case "Mathematical":

				while (currentRepeat) {

					System.out.println("Please select an operation by entering the corresponding operation ID:");
					System.out.println("1: Add DAYS to given Date");
					System.out.println("2: Subtract DAYS from given Date");
					System.out.println("3: Add WEEKS to given Date");
					System.out.println("4: Subtract WEEKS from given Date");
					System.out.println("5: Add MONTHS to given Date");
					System.out.println("6: Subtract MONTHS from given Date");
					System.out.println("7: Exit");

					generator = new OperationGenerator();
					int option = generator.mathematicalCaseOptionNumber();

					switch (option) {
					case 1:
						System.out.println("Enter number of days to add");
						int daysToAdd = generator.mathematicalCaseOperationValue();
						result = localDate.addDays(daysToAdd);
						operationToBeSerialized = new Operation(
								result,
								localDate.getLocaldate(), "add", "days", daysToAdd);
						//						operationToBeSerialized.serliazeOperation();
						operationsList.add(operationToBeSerialized);
						operationCount += 1;
						System.out.println(result);
						break;

					case 2:
						System.out.println("Enter number of days to subtract");
						int daysToSubtract = generator.mathematicalCaseOperationValue();
						result = localDate.subtractDays(daysToSubtract);
						operationToBeSerialized = new Operation(
								result,
								localDate.getLocaldate(), "subtract", "days", daysToSubtract);
						//						operationToBeSerialized.serliazeOperation();
						operationsList.add(operationToBeSerialized);
						operationCount += 1;
						System.out.println(result);
						break;

					case 3:
						System.out.println("Enter number of weeks to add");
						int weeksToAdd = generator.mathematicalCaseOperationValue();
						result = localDate.addWeeks(weeksToAdd);
						operationToBeSerialized = new Operation(
								result,
								localDate.getLocaldate(), "add", "weeks", weeksToAdd);
						//						operationToBeSerialized.serliazeOperation();
						operationsList.add(operationToBeSerialized);
						operationCount += 1;
						System.out.println(result);
						break;

					case 4:
						System.out.println("Enter number of weeks to subtract");
						int weeksToSubtract = generator.mathematicalCaseOperationValue();
						result = localDate.subtractWeeks(weeksToSubtract);
						operationToBeSerialized = new Operation(
								result,
								localDate.getLocaldate(), "subtract", "weeks", weeksToSubtract);
						//						operationToBeSerialized.serliazeOperation();
						operationsList.add(operationToBeSerialized);
						operationCount += 1;
						System.out.println(result);
						break;

					case 5:
						System.out.println("Enter number of months to add");
						int monthsToAdd = generator.mathematicalCaseOperationValue();
						result = localDate.addMonths(monthsToAdd);
						operationToBeSerialized = new Operation(
								result,
								localDate.getLocaldate(), "add", "months", monthsToAdd);
						//						operationToBeSerialized.serliazeOperation();
						operationsList.add(operationToBeSerialized);
						operationCount += 1;
						System.out.println(result);
						break;

					case 6:
						System.out.println("Enter number of months to subtract");
						int monthsToSubtract = generator.mathematicalCaseOperationValue();
						result = localDate.subtractMonths(monthsToSubtract);
						operationToBeSerialized = new Operation(
								result,
								localDate.getLocaldate(), "subtract", "months", monthsToSubtract);
						//						operationToBeSerialized.serliazeOperation();
						operationsList.add(operationToBeSerialized);
						operationCount += 1;
						System.out.println(result);
						break;
					case 7:
						currentRepeat = false;
						break;

					}
				}

			case "English-based":

				while (currentRepeat) {

					System.out.println("Enter your query. (Use spaces between words)");
					generator = new OperationGenerator();
					String query = generator.genralPhraseGenerator();

					boolean containsDay = query.toLowerCase().contains("day");
					boolean containsWeek = query.toLowerCase().contains("week");
					boolean containsMonth = query.toLowerCase().contains("month");
					boolean containsYear = query.toLowerCase().contains("year");

					if(query.toLowerCase().contentEquals("today")) {
						result = localDate.getLocaldate();
						operationToBeSerialized = new Operation(
								result,
								localDate.getLocaldate(), "get", "today", 0);
						//						operationToBeSerialized.serliazeOperation();
						operationsList.add(operationToBeSerialized);
						operationCount += 1;
						System.out.println(result);
					}
					else if (query.toLowerCase().contains("yesterday")) {
						if (query.toLowerCase().contains("before")) {
							result = localDate.subtractDays(2);
							operationToBeSerialized = new Operation(
									result,
									localDate.getLocaldate(), "subtract", "days", 2);
							//							operationToBeSerialized.serliazeOperation();
							operationsList.add(operationToBeSerialized);
							operationCount += 1;
						} else {
							result = localDate.subtractDays(1);
							operationToBeSerialized = new Operation(
									result,
									localDate.getLocaldate(), "subtract", "days", 1);
							//							operationToBeSerialized.serliazeOperation();
							operationsList.add(operationToBeSerialized);
							operationCount += 1;
						}
						System.out.println(result);
					}
					else if (query.toLowerCase().contains("tomorrow")) {
						if (query.toLowerCase().contains("after")) {
							result = localDate.addDays(2);
							operationToBeSerialized = new Operation(
									result,
									localDate.getLocaldate(), "add", "days", 2);
							//							operationToBeSerialized.serliazeOperation();
							operationsList.add(operationToBeSerialized);
							operationCount += 1;
						} else {
							result = localDate.addDays(1);
							operationToBeSerialized = new Operation(
									result,
									localDate.getLocaldate(), "add", "days", 1);
							//							operationToBeSerialized.serliazeOperation();
							operationsList.add(operationToBeSerialized);
							operationCount += 1;
						}
						System.out.println(result);
					} else if (containsWeek) {
						if (query.toLowerCase().contains("previous") || query.toLowerCase().contains("last")) {
							result = localDate.subtractWeeks(1);
							operationToBeSerialized = new Operation(
									result,
									localDate.getLocaldate(), "subtract", "weeks", 1);
							//							operationToBeSerialized.serliazeOperation();
							operationsList.add(operationToBeSerialized);
							operationCount += 1;
							System.out.println(result);
						} else if (query.toLowerCase().contains("next")) {
							result = localDate.addWeeks(1);
							operationToBeSerialized = new Operation(
									result,
									localDate.getLocaldate(), "add", "weeks", 1);
							//							operationToBeSerialized.serliazeOperation();
							operationsList.add(operationToBeSerialized);
							operationCount += 1;
							System.out.println(result);
						} else if (query.toLowerCase().contains("earlier")) {
							String temp = query.toLowerCase().replaceAll("\\D+","");
							if (!temp.contentEquals("")) {
								int reducedWeeks = Integer.parseInt(temp);
								result = localDate.subtractWeeks(reducedWeeks);
								operationToBeSerialized = new Operation(
										result,
										localDate.getLocaldate(), "subtract", "weeks", reducedWeeks);
								//								operationToBeSerialized.serliazeOperation();
								operationsList.add(operationToBeSerialized);
								operationCount += 1;
							} else {
								result = localDate.subtractWeeks(1);
								operationToBeSerialized = new Operation(
										result,
										localDate.getLocaldate(), "subtract", "weeks", 1);
								//								operationToBeSerialized.serliazeOperation();
								operationsList.add(operationToBeSerialized);
								operationCount += 1;
							}
							System.out.println(result);
						} else if (query.toLowerCase().contains("from") && query.toLowerCase().contains("now")) {
							String temp = query.toLowerCase().replaceAll("\\D+","");
							if (!temp.contentEquals("")) {
								int addedWeeks = Integer.parseInt(temp);
								result = localDate.addWeeks(addedWeeks);
								operationToBeSerialized = new Operation(
										result,
										localDate.getLocaldate(), "add", "weeks", addedWeeks);
								//								operationToBeSerialized.serliazeOperation();
								operationsList.add(operationToBeSerialized);
								operationCount += 1;
							} else {
								result = localDate.addWeeks(0);
								operationToBeSerialized = new Operation(
										result,
										localDate.getLocaldate(), "add", "weeks", 0);
								//								operationToBeSerialized.serliazeOperation();
								operationsList.add(operationToBeSerialized);
								operationCount += 1;
							}
							System.out.println(result);
						}
					} else if (containsMonth) {
						if (query.toLowerCase().contains("previous") || query.toLowerCase().contains("last")) {
							result = localDate.subtractMonths(1);
							operationToBeSerialized = new Operation(
									result,
									localDate.getLocaldate(), "subtract", "months", 1);
							//							operationToBeSerialized.serliazeOperation();
							operationsList.add(operationToBeSerialized);
							operationCount += 1;
							System.out.println(result);
						} else if (query.toLowerCase().contains("next") && query.toLowerCase().contains("after")) {
							result = localDate.addMonths(1);
							operationToBeSerialized = new Operation(
									result,
									localDate.getLocaldate(), "add", "months", 1);
							//							operationToBeSerialized.serliazeOperation();
							operationsList.add(operationToBeSerialized);
							operationCount += 1;
							System.out.println(result);
						} else if (query.toLowerCase().contains("earlier") || query.toLowerCase().contains("before")) {
							String temp = query.toLowerCase().replaceAll("\\D+", "");
							if (!temp.contentEquals("")) {
								int reducedMonths = Integer.parseInt(temp);
								result = localDate.subtractMonths(reducedMonths);
								operationToBeSerialized = new Operation(
										result,
										localDate.getLocaldate(), "subtract", "months", reducedMonths);
								//								operationToBeSerialized.serliazeOperation();
								operationsList.add(operationToBeSerialized);
								operationCount += 1;
							} else {
								result = localDate.subtractMonths(1);
								operationToBeSerialized = new Operation(
										result,
										localDate.getLocaldate(), "subtract", "months", 1);
								//								operationToBeSerialized.serliazeOperation();
								operationsList.add(operationToBeSerialized);
								operationCount += 1;
							}
							System.out.println(result);
						} else if (query.toLowerCase().contains("from") && query.toLowerCase().contains("now")) {
							String temp = query.toLowerCase().replaceAll("\\D+", "");
							if (!temp.contentEquals("")) {
								int addedMonths = Integer.parseInt(temp);
								result = localDate.addMonths(addedMonths);
								operationToBeSerialized = new Operation(
										result,
										localDate.getLocaldate(), "add", "months", addedMonths);
								//								operationToBeSerialized.serliazeOperation();
								operationsList.add(operationToBeSerialized);
								operationCount += 1;
							} else {
								result = localDate.addMonths(0);
								operationToBeSerialized = new Operation(
										result,
										localDate.getLocaldate(), "add", "months", 0);
								//								operationToBeSerialized.serliazeOperation();
								operationsList.add(operationToBeSerialized);
								operationCount += 1;
							}
							System.out.println(result);
						}
					} else if (containsYear) {
						if (query.toLowerCase().contains("previous") || query.toLowerCase().contains("last")) {
							result = localDate.subtractYears(1);
							operationToBeSerialized = new Operation(
									result,
									localDate.getLocaldate(), "subtract", "years", 1);
							//							operationToBeSerialized.serliazeOperation();
							operationsList.add(operationToBeSerialized);
							operationCount += 1;
							System.out.println(result);
						} else if (query.toLowerCase().contains("next") && query.toLowerCase().contains("after")) {
							result = localDate.addYears(1);
							operationToBeSerialized = new Operation(
									result,
									localDate.getLocaldate(), "add", "years", 1);
							//							operationToBeSerialized.serliazeOperation();
							operationsList.add(operationToBeSerialized);
							operationCount += 1;
							System.out.println(result);
						} else if (query.toLowerCase().contains("earlier") || query.toLowerCase().contains("before")) {
							String temp = query.toLowerCase().replaceAll("\\D+", "");
							if (!temp.contentEquals("")) {
								int reducedYears = Integer.parseInt(temp);
								result = localDate.subtractYears(reducedYears);
								operationToBeSerialized = new Operation(result, localDate.getLocaldate(), "subtract",
										"years", reducedYears);
								//								operationToBeSerialized.serliazeOperation();
								operationsList.add(operationToBeSerialized);
								operationCount += 1;
							} else {
								result = localDate.subtractYears(1);
								operationToBeSerialized = new Operation(result, localDate.getLocaldate(), "subtract",
										"years", 1);
								//								operationToBeSerialized.serliazeOperation();
								operationsList.add(operationToBeSerialized);
								operationCount += 1;
							}
							System.out.println(result);
						} else if (query.toLowerCase().contains("from") && query.toLowerCase().contains("now")) {
							String temp = query.toLowerCase().replaceAll("\\D+", "");
							if (!temp.contentEquals("")) {
								int addedYears = Integer.parseInt(temp);
								result = localDate.addYears(addedYears);
								operationToBeSerialized = new Operation(result, localDate.getLocaldate(), "add",
										"years", addedYears);
								//								operationToBeSerialized.serliazeOperation();
								operationsList.add(operationToBeSerialized);
								operationCount += 1;
							} else {
								result = localDate.addWeeks(0);
								operationToBeSerialized = new Operation(result, localDate.getLocaldate(), "add",
										"years", 0);
								//								operationToBeSerialized.serliazeOperation();
								operationsList.add(operationToBeSerialized);
								operationCount += 1;
							}
							System.out.println(result);
						}
					} else if (containsDay) {
						if (query.toLowerCase().contains("previous") || query.toLowerCase().contains("last")) {
							result = localDate.subtractDays(1);
							operationToBeSerialized = new Operation(result, localDate.getLocaldate(), "subtract",
									"days", 1);
							//							operationToBeSerialized.serliazeOperation();
							operationsList.add(operationToBeSerialized);
							operationCount += 1;
							System.out.println(result);
						} else if (query.toLowerCase().contains("next") && query.toLowerCase().contains("after")) {
							result = localDate.addDays(1);
							operationToBeSerialized = new Operation(result, localDate.getLocaldate(), "add", "days", 1);
							//							operationToBeSerialized.serliazeOperation();
							operationsList.add(operationToBeSerialized);
							operationCount += 1;
							System.out.println(result);
						} else if (query.toLowerCase().contains("earlier") || query.toLowerCase().contains("before")) {
							String temp = query.toLowerCase().replaceAll("\\D+", "");
							if (!temp.contentEquals("")) {
								int reducedDays = Integer.parseInt(temp);
								result = localDate.subtractDays(reducedDays);
								operationToBeSerialized = new Operation(result, localDate.getLocaldate(), "subtract",
										"days", reducedDays);
								//								operationToBeSerialized.serliazeOperation();
								operationsList.add(operationToBeSerialized);
								operationCount += 1;
							} else {
								result = localDate.subtractDays(1);
								operationToBeSerialized = new Operation(result, localDate.getLocaldate(), "subtract",
										"days", 1);
								//								operationToBeSerialized.serliazeOperation();
								operationsList.add(operationToBeSerialized);
								operationCount += 1;
							}
							System.out.println(result);
						} else if (query.toLowerCase().contains("from") && query.toLowerCase().contains("now")) {
							String temp = query.toLowerCase().replaceAll("\\D+", "");
							if (!temp.contentEquals("")) {
								int addedDays = Integer.parseInt(temp);
								result = localDate.addDays(addedDays);
								operationToBeSerialized = new Operation(result, localDate.getLocaldate(), "add", "days",
										addedDays);
								//								operationToBeSerialized.serliazeOperation();
								operationsList.add(operationToBeSerialized);
								operationCount += 1;
							} else {
								result = localDate.addDays(0);
								operationToBeSerialized = new Operation(result, localDate.getLocaldate(), "get",
										"today", 0);
								//								operationToBeSerialized.serliazeOperation();
								operationsList.add(operationToBeSerialized);
								operationCount += 1;
							}
							System.out.println(result);
						}
					} else {
						System.out.println("Program will now exit");
						currentRepeat = false;
					}

				}


			}



		}

		System.out.println(operationsList);
		serializer = new OperationListSerializer(operationsList);
		serializer.serliazeOperation();
		//
		System.out.println("Serialized Perfectly");
		//
		serializer.deserializeOperation();

		System.out.println("Deserialized perfectly");

	}
}
