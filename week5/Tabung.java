package week5;

class Tabung {

	 Tabung(){ 
	 }

		double radius = 1;
		double tinggi = 1;
		
		Tabung (double rad, double height){
			radius = rad;
			tinggi = height;
		}
		
		double getVolume(){
			return radius* radius * tinggi * Math.PI;
		}
		
		double getLuasAlas() {
			return radius*radius * Math.PI;
		}
		
		void setRadius(double rad) {
			radius = rad;
		}
		void setTinggi(double height) {
			tinggi = height;
		}
	}
