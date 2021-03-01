package week1;

import java.util.*;

public class Main2 
{
	public static void main(String[] args)
	{
		int i, indexHari = 0, indexHitung, countingDay;
		String tempHari;
		String[] daftarHari = {"senin", "selasa", "rabu", "kamis", "jumat", "sabtu", "minggu" };
		Scanner inputHari = new Scanner(System.in);
		Scanner scanner = new Scanner(System.in);
		System.out.print("Masukan hari : ");
		tempHari = inputHari.nextLine();
		tempHari.toLowerCase();
		
		// Searching day
		for(i = 0 ; i < 7 ; i++)
		{
			if(tempHari.equals(daftarHari[i]))
			{
				indexHari = i;
				break;
			}
		}
		
		System.out.print("Masukan jumlah Hari : ");
		indexHitung = scanner.nextInt();
		
		countingDay = indexHari + (indexHitung % 7) ; 
		countingDay = countingDay % 7 ;
		System.out.println(indexHitung + " hari dari hari " + tempHari + " adalah hari " + daftarHari[countingDay]);
	}
}
