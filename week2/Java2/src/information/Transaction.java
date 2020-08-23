package information;

import java.util.Date;

public class Transaction {
	String name;
	String externalTransactionId;
	String clientId;
	String securityId;
	String transactionType;
	Date transactionDate;
	String marketValue;
	private String transactionCharge;

	public Date getTransactionDate() {
		return transactionDate;
	}

	String priority;


	public Transaction(String name, String externalTransactionId, String clientId, String securityId,
			String transactionType, Date transactionDate, String marketValue, String priority) {
		super();
		this.name = name;
		this.externalTransactionId = externalTransactionId;
		this.clientId = clientId;
		this.securityId = securityId;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.marketValue = marketValue;
		this.priority = priority;
	}


	public String getName() {
		return name;
	}

	public String getExternalTransactionId() {
		return externalTransactionId;
	}

	public String getClientId() {
		return clientId;
	}

	public String getSecurityId() {
		return securityId;
	}

	public String getMarketValue() {
		return marketValue;
	}

	public String getPriority() {
		return priority;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public String getTransactionCharge() {
		return transactionCharge;
	}


	public void setTransactionCharge(String transactionCharge) {
		this.transactionCharge = transactionCharge;
	}



}
