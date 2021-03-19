package week4;

import java.util.*;

public class Main {
	
	static void stringCompare(String string1 , String string2) {
		if (string1.compareTo(string2) > 0) {
			System.out.println("Urutan Alphabetical : " + string2 + " ," + string1 );
		} else System.out.println("Urutan Alphabetical : " + string1 + " ," + string2 );
	}
	
	public static void main(String[] args)
	{
		String temp1 , temp2 ;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Masukan String 1 : ");
		temp1 = scan.nextLine().toLowerCase();
		
		System.out.print("Masukan String 2 : ");
		temp2 = scan.nextLine().toLowerCase();
		
		stringCompare(temp1,temp2);
		
	}
	
}
