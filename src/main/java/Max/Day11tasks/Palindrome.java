import java.util.ArrayList;
//import java.util.Collections;

public class Palindrome {
	public int i0;
	public int i1;
	public int i2;
	public int i3;
	public int i4;

	
	public Palindrome(int i0, int i1, int i2, int i3, int i4) {
		this.i0 = i0;
		this.i1 = i1;
		this.i2 = i2;
		this.i3 = i3;
		this.i4 = i4;
	}
	
	public static void checkPalindrome(int i0, int i1, int i2, int i3, int i4) {
		ArrayList<Integer> checkMe = new ArrayList<Integer>();
		checkMe.add(i0);
		checkMe.add(i1);
		checkMe.add(i2);
		checkMe.add(i3);
		checkMe.add(i4);
		System.out.println("Your number is :" + checkMe);
		
		ArrayList<Integer> reversed = new ArrayList<Integer>();
		reversed.add(i4);
		reversed.add(i3);
		reversed.add(i2);
		reversed.add(i1);
		reversed.add(i0);
		System.out.println("Backwards, it is :" + reversed);
		//Collections.reverse(reversed);

		if (reversed.toString().contentEquals(checkMe.toString())){
			System.out.println("YES! Same both ways, so its a PALINDROME!");
		}else {
			System.out.println("NO WAY! It's not the same if you reverse it! NOT A PALINDROME");
		}
	
	}

	public static void main(String[] args) {
		checkPalindrome(1, 3, 4, 3, 1);
	}
	
}
