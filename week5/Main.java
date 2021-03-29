package week5;

public class Main {public static void main(String[] args){
	
	Tabung tabung = new Tabung(5,10);
	Tabung tabung1 = new Tabung(7.5,15.5);
	Tabung tabung2 = new Tabung();
	
	System.out.println("radius: " + (int) tabung.radius + " tinggi: " + (int)tabung.tinggi);
	System.out.println("Luas alas : " +tabung.getLuasAlas());
	System.out.println("Volume : " + tabung.getVolume() + "\n");
	
	System.out.println("radius: " +  tabung1.radius + " tinggi: " +  tabung1.tinggi);
	System.out.println("Luas alas : " +tabung1.getLuasAlas());
	System.out.println("Volume : " + tabung1.getVolume() + "\n");
	
	System.out.println("radius: " + tabung2.radius + " tinggi: " + tabung2.tinggi);
	System.out.println("Luas alas : " +tabung2.getLuasAlas());
	System.out.println("Volume : " + tabung2.getVolume() + "\n");
	}

}
