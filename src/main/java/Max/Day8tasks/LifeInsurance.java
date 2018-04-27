package Max.Day8tasks;


public class LifeInsurance {
	private static String firstName;
	private static String lastName;
	private static double socialSecurity;
	private static int age;
	private static int healthRating;
	private static boolean previousCondition;
	private static double maxCoverageAmount;
	private static double monthlyPayment;
	//private static String lifeReport;
	
	//public LifeInsurance(String firstName, String lastName, String socialSecurity, int age, int healthRating, boolean previousCondition, int maxCoverageAmount, int monthlyPayment) {
		//LifeInsurance.firstName = firstName;
		//LifeInsurance.lastName = lastName;
		//LifeInsurance.socialSecurity = socialSecurity;
		//LifeInsurance.age = age;
		//LifeInsurance.healthRating = healthRating;
		//LifeInsurance.previousCondition = previousCondition;
		//LifeInsurance.maxCoverageAmount = maxCoverageAmount;		
	//}
	
	public static double calculateCoverageAmount(double maxCoverageAmount, int age, int healthRating, boolean previousCondition) {
		if (previousCondition == true){
			maxCoverageAmount = maxCoverageAmount / 2;
		}
		if (age > 60) {
			maxCoverageAmount = maxCoverageAmount * 0.75;			
		}
		maxCoverageAmount = maxCoverageAmount * healthRating / 10;
		return maxCoverageAmount;
	}
	
	public static double calculateMonthlyPayment(double maxCoverageAmount, int age, int healthRating, boolean previousCondition) {
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

	public static void printReport() {
		System.out.println("This Life Insurance Policy is registered to " + firstName + " " + lastName + " with social security number " + socialSecurity);
		System.out.println("This person is " + age + " years old, with a health rating of " + healthRating + "/10");
		if(previousCondition == true) {
			System.out.println("This person has a previous medical condition");
		}else {
			System.out.println("This person has NO pervious medical conditions");
		}
		System.out.println("Due to the above factors, this person has qualified for a maximum coverage amount of " + maxCoverageAmount + " and a monthly payment of " + monthlyPayment);
		//return lifeReport;
	}
	
	public static void main(String[] args) {
		firstName = "Max";
		lastName = "Zinovskiy";
		socialSecurity = 12345678;
		age = 30;
		healthRating = 9;
		previousCondition = false;		
		maxCoverageAmount = calculateCoverageAmount(1000000, age, healthRating, previousCondition);
		//System.out.println(maxCoverageAmount);
		monthlyPayment = calculateMonthlyPayment(maxCoverageAmount, age, healthRating, previousCondition);
		//System.out.println(monthlyPayment);
		printReport();
	}
}
