import java.util.ArrayList;

public class Fiibbonacci {
	private static int a=0; 
	private static int b=1;
	private static int c = a+b;
	
	//static ArrayList<Fiibbonacci> fibNumbers = new ArrayList<Fiibbonacci>();
	
	public static void main(String[] args){
		ArrayList<Integer> integers = new ArrayList<Integer>();
		for(int i = 0;i<10;i++) {
			//System.out.print(c + " ");
			integers.add(c);
			a=b;
			b=c;
			c=a+b;
		}
		System.out.println(integers);
	}	
	
}
