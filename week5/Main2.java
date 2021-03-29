package week5;

import java.util.*;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GregorianCalendar gcal = new GregorianCalendar();
		
        System.out.println("Date :" + gcal.get(Calendar.DATE) + "-" + (gcal.get(Calendar.MONTH)+1) + "-" + gcal.get(Calendar.YEAR));
        
        long temp = gcal.getTimeInMillis();
        
        System.out.print(((int)(temp/3.154e+10) + " Years") + " ");
        temp = (long) (temp %  3.154e+10) ;
        System.out.print(((int)(temp/2.628e+9) + " Months") + " ");
        temp = (long) (temp % 2.628e+9) ;
        System.out.print(((int)(temp/8.64e+7) + " Days") + " ");
		System.out.print("Setelah tanggal 1 Januari 1970");
	}

}
