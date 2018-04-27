package Max.Day10tasks;


public class CarInsurance extends InsurancePolicy {
	
	public CarInsurance(String vinNumber, String licensePlate,
			String registeredOwner, int carAge, boolean isNew, double carValue, int driverAge, int numberTickets) {
		super(vinNumber, licensePlate, registeredOwner, carAge, isNew, carValue, driverAge, numberTickets);
		// TODO Auto-generated constructor stub
	}


//public double calculateDriverRating(int driverAge, int numberTickets) {
//		driverRating = 100;
//		if (driverAge < 18) {
//			driverRating = driverRating / 2;
//		}else if(driverAge < 21) {
//			driverRating = driverRating / 1.5;
//		}else if(driverAge < 30) {
//			driverRating = driverRating / 1.25;
//		}
//		driverRating = driverRating - numberTickets * 5;
//		return driverRating;
//	}
//	
//	public double calculateCarPayment(int carAge, boolean isNew, double carValue, double driverRating) {
//		carPayment = carValue / 24 * 100 / driverRating;
//		if (isNew == true) {
//			carPayment = carPayment * 1.5;
//		}else if(carAge < 5) {
//			carPayment = carPayment * 1.2;
//		}	
//		
//		return carPayment;
//	}
	
	public void printCarReport() {
		System.out.println("This vehicle has an identification number of " + vinNumber + " and license plate " + licensePlate);
		if(isNew == true) {
			System.out.println("This is a brand new car");
		}else {
			System.out.println("This car is not new. It has been used for " + carAge + " years.");
		}
		System.out.println("The value of the car is $" + carValue);
		System.out.println("This policy is registered to " + registeredOwner + " who is " + driverAge + " years old, with " + numberTickets + " tickets on his record");
		System.out.println("Due to the above factors, we calculated his driver rating at " + driverRating + "/100 and therefore this person has qualified for a monthly payment of $" + monthlyPayment);
		//return lifeReport;
	}	
	

}
