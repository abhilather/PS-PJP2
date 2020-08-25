package incomeCalculator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

import com.opencsv.CSVWriter;

public class SummaryReport {

	TreeMap<String, IncomeInformation> report;

	public SummaryReport(TreeMap<String, IncomeInformation> report) {
		this.report = report;
	}

	public void generateReport() throws IOException {
		FileWriter outputfile = new FileWriter("C:\\Users\\Abhimanyu\\Desktop\\report.csv");

		// create CSVWriter object filewriter object as parameter
		CSVWriter writer = new CSVWriter(outputfile);

		String[] header = { "Country/City", "Gender", "Average Income(in USD)" };
		writer.writeNext(header);
		for (String record : report.keySet()) {
			var country_city_gender = record.split("_");
			String location = country_city_gender[0];
			String gender = country_city_gender[1];
			IncomeInformation reportRecord = report.get(record);
			String[] data = {location.toString(), gender.toString(), (reportRecord.averageIncomeValue()).toString()};
			writer.writeNext(data);

		}

		writer.close();

	}


}

