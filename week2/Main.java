package week2;

import java.util.*;

public class Main 
{
	public static void main(String[] args)
	{
		System.out.println("--Java Loterry--");
		Scanner scan = new Scanner(System.in);
		int tempNum1, tempNum2;
		
		//Generate random number
		Random rand = new Random();
		int randNum1 = rand.nextInt(10);
		int randNum2 = rand.nextInt(10);
		
		//System.out.print(randNum1);
		//System.out.println(randNum2);
		
		//Scan num1 and num2 until user input right number
		do
		{
			System.out.print("Masukan Nomor pertama anda[0-9] : ");
			tempNum1 = scan.nextInt();
			System.out.print("Masukan Nomor kedua anda[0-9] : ");
			tempNum2 = scan.nextInt();
		}while(tempNum1 > 9 || tempNum2 > 9);
		
		
		System.out.print(tempNum1);
		System.out.println(tempNum2);
		
		//Conditions in lottery
		if(randNum1 == tempNum1 && randNum2 == tempNum2)
		{
			System.out.println("you've got $10,000");
		}
		else if (randNum1 == tempNum2 && randNum2 == tempNum1)
		{
			System.out.println("you've got $3,000");
		}
		else if (randNum1 == tempNum1 || randNum2 == tempNum2 || randNum1 == tempNum2 || randNum2 == tempNum1)
		{
			System.out.println("you've got $1,000");
		}
		else
		{
			System.out.println("you'r unlucky");
		}
		
	}
}
