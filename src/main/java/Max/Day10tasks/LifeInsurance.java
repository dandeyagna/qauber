package Max.Day10tasks;


public class LifeInsurance extends InsurancePolicy {
	
	
	
	public LifeInsurance(String firstName, String lastName, String socialSecurity, int age, int healthRating,
			boolean previousCondition, int maxCoverageAmount) {
		super(firstName, lastName, socialSecurity, age, healthRating, previousCondition, maxCoverageAmount);
		// TODO Auto-generated constructor stub
	}

//	public double calculateCoverageAmount(double maxCoverageAmount, int age, int healthRating, boolean previousCondition) {
//		if (previousCondition == true){
//			maxCoverageAmount = maxCoverageAmount / 2;
//		}
//		if (age > 60) {
//			maxCoverageAmount = maxCoverageAmount * 0.75;			
//		}
//		maxCoverageAmount = maxCoverageAmount * healthRating / 10;
//		return maxCoverageAmount;
//	} 
	
//	public double calculateMonthlyPayment(double maxCoverageAmount, int age, int healthRating, boolean previousCondition) {
//		monthlyPayment = maxCoverageAmount / 30;
//		if (age > 80) {
//			monthlyPayment = maxCoverageAmount / 20;
//		}else if (age > 70) {
//			monthlyPayment = maxCoverageAmount / 15;
//		}else if (age > 80) {
//			monthlyPayment = maxCoverageAmount / 10;
//		}
//		if (previousCondition == true) {
//			monthlyPayment = monthlyPayment *2;
//		}
//		monthlyPayment = monthlyPayment / healthRating / 10;
//		return monthlyPayment;

	public void printReport() {
		System.out.println("This Life Insurance Policy is registered to " + firstName + " " + lastName + " with social security number " + socialSecurity);
		System.out.println("This person is " + age + " years old, with a health rating of " + healthRating + "/10");
		if(previousCondition == true) {
			System.out.println("This person has a previous medical condition");
		}else {
			System.out.println("This person has NO pervious medical conditions");
		}
		System.out.println("Due to the above factors, this person has qualified for a maximum coverage amount of $" + maxCoverageAmount + " and a monthly payment of $" + monthlyPayment);
		//return lifeReport;
	}
	

}
