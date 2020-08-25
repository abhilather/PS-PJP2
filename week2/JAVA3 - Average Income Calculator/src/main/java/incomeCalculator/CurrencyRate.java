package incomeCalculator;

import java.util.HashMap;

public class CurrencyRate {

	HashMap<String, Double> rates = new HashMap<String, Double>();

	public CurrencyRate() {
		this.rates.put("INR", (double) 66);
		this.rates.put("GBP", 0.67);
		this.rates.put("SGP", 1.5);
		this.rates.put("HKD", (double) 8);
		this.rates.put("USD", (double) 1);

	}

	public Double getRate(String currency) {
		return rates.get(currency);
	}




}
