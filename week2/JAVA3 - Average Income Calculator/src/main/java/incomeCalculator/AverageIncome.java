package incomeCalculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class AverageIncome {



	public static void main(String[] args) throws IOException {
		FileReader file = new FileReader("C:\\Users\\Abhimanyu\\Downloads\\Sample input file Assignment 3.csv");
		BufferedReader br = new BufferedReader(file);
		TreeMap<String, IncomeInformation> incomeRecords = new TreeMap<>();


		String line;
		while ((line = br.readLine()) != null) {
			var record = line.split(",");
			String city = record[0];
			String country = record[1];
			String gender = record[2];
			String currency = record[3];
			Double averageIncome = (double) Integer.parseInt(record[4]);

			String locationGenderKey;
			if (country.length() > 0) {
				locationGenderKey = country + "_" + gender;
				if (!incomeRecords.containsKey(locationGenderKey)) {
					IncomeInformation incomeRecord = new IncomeInformation(city, country, locationGenderKey, currency,
							averageIncome);
					incomeRecords.put(locationGenderKey, incomeRecord);
				} else {
					IncomeInformation incomeRecord = incomeRecords.get(locationGenderKey);
					incomeRecord.addValue(averageIncome);
				}
			} else {
				locationGenderKey = city + "_" + gender;
				if (!incomeRecords.containsKey(locationGenderKey)) {
					IncomeInformation incomeRecord = new IncomeInformation(city, country, locationGenderKey, currency,
							averageIncome);
					incomeRecords.put(locationGenderKey, incomeRecord);
				} else {
					IncomeInformation incomeRecord = incomeRecords.get(locationGenderKey);
					incomeRecord.addValue(averageIncome);
				}
			}

		}

		SummaryReport report = new SummaryReport(incomeRecords);
		report.generateReport();


	}

}
