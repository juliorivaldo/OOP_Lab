package week1;

import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Scanner tempSecond = new Scanner(System.in);
		int timeSecond, hours = 0, minutes = 0, seconds = 0;
		System.out.print("Enter a integer for seconds: " );
		timeSecond = tempSecond.nextInt(); 
		
		System.out.print(timeSecond + " seconds is ");
		
		//Count hours
		hours = timeSecond / 3600;
		
		if (hours >= 1)
		{
			System.out.print(hours + " hours ");
		}
		
		//Count minutes
		minutes = timeSecond - (hours * 3600);
		minutes = minutes / 60;	
		
		if(minutes >= 1)
		{
			if (hours !=0)
			{
				System.out.print("and ");
			}
			System.out.print(minutes + " minutes ");
		}
		
		//Count Seconds
		seconds = timeSecond - (hours * 3600) - (minutes * 60);	
		
		if(seconds >= 1)
		{
			if (hours !=0 || minutes !=0)
			{
				System.out.print("and ");
			}
			System.out.print(seconds + " seconds");
		}
	}

}