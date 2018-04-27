package Max.Day10tasks;

public class InsurancePolicy {
	//LifeInsurance attributes
	protected String firstName;
	protected String lastName;
	protected String socialSecurity;
	protected int age;
	protected int healthRating;
	protected boolean previousCondition;
	protected double maxCoverageAmount;
	protected double monthlyPayment;
	
	//CarInsurance attributes
	protected String vinNumber;
	protected String licensePlate;
	protected String registeredOwner;
	protected int carAge;
	protected boolean isNew;
	protected double carValue;
	protected int driverAge;
	protected int numberTickets;
	protected double driverRating;
	
	


	public double calculateCoverageAmount(double maxCoverageAmount, int age, int healthRating, boolean previousCondition) {
		if (previousCondition == true){
			maxCoverageAmount = maxCoverageAmount / 2;
		}
		if (age > 60) {
			maxCoverageAmount = maxCoverageAmount * 0.75;			
		}
		maxCoverageAmount = maxCoverageAmount * healthRating / 10;
		return maxCoverageAmount;
	}
	
	public double calculateMonthlyPayment(double maxCoverageAmount, int age, int healthRating, boolean previousCondition) {
		monthlyPayment = maxCoverageAmount / 30;
		if (age > 80) {
			monthlyPayment = maxCoverageAmount / 20;
		}else if (age > 70) {
			monthlyPayment = maxCoverageAmount / 15;
		}else if (age > 80) {
			monthlyPayment = maxCoverageAmount / 10;
		}
		if (previousCondition == true) {
			monthlyPayment = monthlyPayment *2;
		}
		monthlyPayment = monthlyPayment / healthRating / 10;
		return monthlyPayment;
	}
	
	public double calculateDriverRating(int driverAge, int numberTickets) {
		driverRating = 100;
		if (driverAge < 18) {
			driverRating = driverRating / 2;
		}else if(driverAge < 21) {
			driverRating = driverRating / 1.5;
		}else if(driverAge < 30 || driverAge > 75) {
			driverRating = driverRating / 1.25;
		}
		driverRating = driverRating - numberTickets * 5;
		return driverRating;
	}
	
	public double calculateCarPayment(int carAge, boolean isNew, double carValue, double driverRating) {
		monthlyPayment = carValue / 50 * 100 / driverRating;
		if (isNew == true) {
			monthlyPayment = monthlyPayment * 1.5;
		}else if(carAge < 5) {
			monthlyPayment = monthlyPayment * 1.2;
		}	
		
		return monthlyPayment;
	}	
	
	//Constructor 
	public InsurancePolicy(String firstName, String lastName, String socialSecurity, int age, int healthRating, boolean previousCondition, int maxCoverageAmount){
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurity = socialSecurity;
		this.age = age;
		this.healthRating = healthRating;
		this.previousCondition = previousCondition;
		this.maxCoverageAmount = calculateCoverageAmount(maxCoverageAmount, age, healthRating, previousCondition);
		this.monthlyPayment = calculateMonthlyPayment(maxCoverageAmount, age, healthRating, previousCondition);
		
	}	
	
	public InsurancePolicy(String vinNumber, String licensePlate, String registeredOwner, int carAge, boolean isNew, double carValue, int driverAge, int numberTickets) {
		this.vinNumber = vinNumber;
		this.licensePlate = licensePlate;
		this.registeredOwner = registeredOwner;
		this.carAge = carAge;
		this.isNew = isNew;
		this.carValue = carValue;
		this.driverAge = driverAge;
		this.numberTickets = numberTickets;
		this.driverRating = calculateDriverRating(driverAge, numberTickets);
		this.monthlyPayment = calculateCarPayment(carAge, isNew, carValue, driverRating);			
	}
	
	
	
	
}
