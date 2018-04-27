package Max.Day10tasks;

public class TestInsurance {
	//Health Insurance attributes
	static String firstName = "Max";
	static String lastName = "Zinovskiy";
	static String socialSecurity = "666-11-2222";
	static int age = 30;
	static int healthRating = 9;
	static boolean	previousCondition = false;
	static int	maxCoverageAmount = 1000000;
	
	//CarInsurance attributes
	static String vinNumber = "VIN12345678910";
	static String licensePlate = "MAX-123";
	static String registeredOwner = "Max Zinovskiy";
	static int	carAge = 4;
	static boolean	isNew = false;
	static int carValue = 10000;
	static int	driverAge = 30;
	static int numberTickets = 2;
	
	public static void main(String[] args) {
		//Static vs Dynamic types
		LifeInsurance life1 = new LifeInsurance(firstName, lastName, socialSecurity, age, healthRating, previousCondition, maxCoverageAmount);
		life1.printReport();
		System.out.println("");
		LifeInsurance life2 = new LifeInsurance("John", "Doe", "222-22-2222", 67, 5, true, maxCoverageAmount);
		life2.printReport();
		System.out.println("");
		LifeInsurance life3 = new LifeInsurance("Jane", "Mclane", "333-33-3333", 17, 10, false, maxCoverageAmount);
		life3.printReport();
		System.out.println("");
		
		CarInsurance car1 = new CarInsurance(vinNumber, licensePlate, registeredOwner, carAge, isNew, carValue, driverAge, numberTickets);
		car1.printCarReport();
		System.out.println("");
		CarInsurance car2 = new CarInsurance("VIN22222222222", "KLL-222", "John Doe", 45, false, 2000, 78, 0);
		car2.printCarReport();
		System.out.println("");
		CarInsurance car3 = new CarInsurance("VIN33333333333", "MKK-333", "Susan Mclane", 0, true, 38000, 17, 0);
		car3.printCarReport();
		System.out.println("");
		
		InsurancePolicy car4 = new InsurancePolicy("VIN33333333333", "MKK-333", "Susan Mclane", 0, true, 38000, 17, 0);
		double mPay = car4.calculateMonthlyPayment(maxCoverageAmount, age, healthRating, previousCondition);
		System.out.println(mPay);
		
		
		//Arrays
		LifeInsurance[] lifeArray =  {life1, life2, life3};
		double lifeMonthly = 0;
		for(int i=0; i<lifeArray.length;i++) {
			lifeMonthly = lifeMonthly + lifeArray[i].monthlyPayment;
		}	
		CarInsurance[] carArray =  {car1, car2, car3};
		double carMonthly = 0;
		for(int i=0; i<carArray.length;i++) {
			carMonthly = carMonthly + carArray[i].monthlyPayment;
		}
		
		System.out.println("Total life insurance payments for all 3 people: " + lifeMonthly);
		System.out.println("Total car insurance payments for all 3 people: " + carMonthly);

		
	}
}
