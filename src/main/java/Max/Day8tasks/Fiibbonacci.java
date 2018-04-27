package Max.Day8tasks;



public class Fiibbonacci {
	private static int a=0; 
	private static int b=1;
	private static int c = a+b;
	
	public static void main(String[] args){
		for(int i = 0;i<10;i++) {
			System.out.print(c + " ");
			a=b;
			b=c;
			c=a+b;
		}
	}
}
