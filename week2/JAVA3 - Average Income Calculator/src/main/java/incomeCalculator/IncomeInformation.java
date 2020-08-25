package incomeCalculator;

public class IncomeInformation {
	private String city;
	private String country;
	private String gender;
	private String currency;
	private Double averageIncome;
	private int counter;

	public IncomeInformation(String city, String country, String gender, String currency, Double averageIncome) {
		super();
		this.city = city;
		this.country = country;
		this.gender = gender;
		this.currency = currency;
		this.averageIncome = averageIncome;
		this.counter = 1;

	}

	public void addValue(Double value) {
		averageIncome += value;
		counter += 1;
	}

	public Double averageIncomeValue() {
		CurrencyRate rate = new CurrencyRate();
		Double averageIncomeWithoutConversion = averageIncome / counter;
		Double currencyRate = rate.getRate(this.currency);
		return averageIncomeWithoutConversion / currencyRate;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getGender() {
		return gender;
	}

	public String getCurrency() {
		return currency;
	}

	public Double getAverageIncome() {
		return averageIncome;
	}

	public int getCounter() {
		return counter;
	}

}
