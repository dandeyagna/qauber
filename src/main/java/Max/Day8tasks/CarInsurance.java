
public class CarInsurance {
	private static String vinNumber;
	private static String licensePlate;
	private static String registeredOwner;
	private static int carAge;
	private static boolean isNew;
	private static double carValue;
	private static int driverAge;
	private static int numberTickets;
	private static double driverRating;
	private static double carPayment;

	public CarInsurance(String vinNumber, String licensePlate, String registeredOwner, double mileage,int carAge, boolean isNew, double carValue, int driverAge, int numberTickets, double driverRating, double carPayment) {
		CarInsurance.vinNumber = vinNumber;
		CarInsurance.licensePlate = licensePlate;
		CarInsurance.registeredOwner = registeredOwner;
		CarInsurance.isNew = isNew;
		CarInsurance.carValue = carValue;
		CarInsurance.driverAge = driverAge;
		CarInsurance.numberTickets = numberTickets;
		CarInsurance.driverRating = driverRating;
		CarInsurance.carPayment = carPayment;
	}
	
	public static double calculateDriverRating(int driverAge, int numberTickets) {
		driverRating = 100;
		if (driverAge < 18) {
			driverRating = driverRating / 2;
		}else if(driverAge < 21) {
			driverRating = driverRating / 1.5;
		}else if(driverAge < 30) {
			driverRating = driverRating / 1.25;
		}
		driverRating = driverRating - numberTickets * 5;
		return driverRating;
	}
	
	public static double calculateCarPayment(int carAge, boolean isNew, double carValue, double driverRating) {
		carPayment = carValue / 24 * 100 / driverRating;
		if (isNew == true) {
			carPayment = carPayment * 1.5;
		}else if(carAge < 5) {
			carPayment = carPayment * 1.2;
		}	
		
		return carPayment;
	}
	
	public static void printCarReport() {
		System.out.println("This vehicle has an identification number of " + vinNumber + " and license plate " + licensePlate);
		if(isNew == true) {
			System.out.println("This is a brand new car");
		}else {
			System.out.println("This car is not new. It has been used for " + carAge + " years.");
		}
		System.out.println("The value of the car is " + carValue);
		System.out.println("This policy is registered to " + registeredOwner + " who is " + driverAge + " years old, with " + numberTickets + " tickets on his record and a driver rating of " + driverRating + "/100");
		System.out.println("Due to the above factors, this person has qualified for a monthly payment of " + carPayment);
		//return lifeReport;
	}	
	
	public static void main(String[] args) {
		vinNumber = "VIN1234123412345";
		licensePlate = "D541234";
		registeredOwner = "Max Zinovskiy";
		carAge = 4;
		isNew = false;
		carValue = 10000;
		driverAge = 30;
		numberTickets = 2;		
		
		driverRating = calculateDriverRating(driverAge, numberTickets);
		//System.out.println(driverRating);
		carPayment = calculateCarPayment(carAge, isNew, carValue, driverRating);
		//System.out.println(carPayment);
		printCarReport();	
	}
}
