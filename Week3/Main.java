package Week3;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		int randNum1, inputNum;
		
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		randNum1 = rand.nextInt(101);
		// Delete slash if want to show the random number
		//System.out.println(randNum1);
		
		System.out.println("\nGuess a Magic Number between 0 and 100\n\n");
		
		do
		{
			do
			{
				System.out.print("Enter your Guess[0-100]: ");
				inputNum = scan.nextInt();
			}while(inputNum > 100 || inputNum < 0);
			
			//Conditions
			if(inputNum > randNum1)
			{
				System.out.println("Your Guess is too High\n\n");
			}
			else if(inputNum < randNum1)
			{
				System.out.println("Your Guess is too Low\n\n");
			}
		}while(inputNum != randNum1);
		
		System.out.println("Yes, the number is " + randNum1);
	}

}
