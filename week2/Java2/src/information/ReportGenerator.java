package information;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class ReportGenerator {

	public static void main(String[] args) throws IOException, ParseException {

		String line;
		String name;
		String externalTransactionId;
		String clientId;
		String securityId;
		String transactionId;
		Date transactionDate;
		String transactionType;
		String marketValue;
		String priority;

		HashMap<String, ArrayList<Transaction>> report = new HashMap<>();
		HashMap<String, Transaction> transactions = new HashMap<>();

		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

		FileReader file = new FileReader("C:\\Users\\Abhimanyu\\Desktop\\Java2.csv");
		BufferedReader br = new BufferedReader(file);

		while ((line = br.readLine()) != null) {
			var record = line.split(",");
			name = record[0];
			externalTransactionId = record[1];
			clientId = record[2];
			securityId = record[3];
			transactionType = record[4];
			transactionDate = new SimpleDateFormat("MM/dd/yyyy").parse(record[5].toString());
			marketValue = record[6];
			priority = record[7];


			Transaction newTransaction = new Transaction(name, externalTransactionId, clientId, securityId,
					transactionType, transactionDate, marketValue, priority);
			String clientSecurityKey = clientId + "_" + securityId;
			if (!report.containsKey(clientSecurityKey)) {
				ArrayList<Transaction> reportValue = new ArrayList<Transaction>();
				reportValue.add(newTransaction);
				report.put(clientSecurityKey, reportValue);
			} else {
				ArrayList<Transaction> reportValue = report.get(clientSecurityKey);
				reportValue.add(newTransaction);
			}


			String newTransactionKey = clientId + "_" + securityId + "_" + record[5].toString() + "_" + transactionType;
			if (newTransaction.getTransactionType().contentEquals("Buy")) {
				if (!transactions.containsKey(newTransactionKey)) {
					transactions.put(newTransactionKey, newTransaction);
				}
				if (newTransaction.getPriority().contentEquals("Y")) {
					newTransaction.setTransactionCharge("500");
				} else {
					newTransaction.setTransactionCharge("50");
				}
			} else if (newTransaction.getTransactionType().contentEquals("Sell")) {
				String checkBuyKey = clientId + "_" + securityId + "_" + record[5].toString() + "_" + "Buy";
				if (!transactions.containsKey(checkBuyKey)) {
					transactions.put(newTransactionKey, newTransaction);
					if (newTransaction.getPriority().contentEquals("Y")) {
						newTransaction.setTransactionCharge("500");
					} else {
						newTransaction.setTransactionCharge("100");
					}
				} else {
					transactions.get(checkBuyKey).setTransactionCharge("10");
					newTransaction.setTransactionCharge("10");

				}

			} else if (newTransaction.getTransactionType().contentEquals("Withdraw")) {
				if (!transactions.containsKey(newTransactionKey)) {
					transactions.put(newTransactionKey, newTransaction);
				}
				if (newTransaction.getPriority().contentEquals("Y")) {
					newTransaction.setTransactionCharge("500");
				} else {
					newTransaction.setTransactionCharge("100");
				}
			} else if (newTransaction.getTransactionType().contentEquals("Deposit")) {
				if (!transactions.containsKey(newTransactionKey)) {
					transactions.put(newTransactionKey, newTransaction);
				}
				if (newTransaction.getPriority().contentEquals("Y")) {
					newTransaction.setTransactionCharge("500");
				} else {
					newTransaction.setTransactionCharge("50");
				}
			}

		}

		FileOutputStream fos = new FileOutputStream("C:\\Users\\Abhimanyu\\Desktop\\IOStream.txt");

		for (ArrayList<Transaction> currentTransactionList : report.values()) {
			for(Transaction currentTransaction:currentTransactionList) {
				String result = currentTransaction.getClientId() + " " + currentTransaction.getTransactionType() + " "
						+ currentTransaction.getTransactionDate() + " " + currentTransaction.getPriority() + " "
						+ currentTransaction.getTransactionCharge() + "\n";
				byte output[] = result.getBytes();
				fos.write(output);

			}
		}
		fos.close();


	}

}