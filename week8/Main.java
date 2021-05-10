package week8;

import java.util.*;

public class Main {
	private String username;
	private String pass;
	private static Customer customer = new Customer();
	private static Admin admin = new Admin();
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int ch = 0;
		String user, pass;
		
		System.out.println("--- User Data ---");
		do {
			System.out.println("1. Tambah data");
			System.out.println("2. Tampilkan data");
			System.out.println("3. Exit");
			System.out.print("Input: ");
			try {
				ch = scan.nextInt();
			}catch(Exception e) {
				System.out.println("Input number only!");
				scan.nextLine();
			}
			
			switch(ch) {
			case 1 :
				menu_tambah();
				break;
			case 2 :
				customer.show_user();
				admin.show_admin();
			}
			
		}while(ch!=3); 
	}
	
	static void menu_tambah() {
		int ch=0;
		Scanner scan = new Scanner(System.in);
			System.out.println("1. Tambah customer");
			System.out.println("2. Tambah admin");
			
			do {
				System.out.print("Input: ");
				try {
					ch = scan.nextInt();
				}catch(Exception e) {
					System.out.println("Input number only!");
					scan.nextLine();
				}
			}while(ch>2);
			
			
			switch(ch) {
			case 1 :
				customer.tambah_customer();
				break;
			
			case 2 :
				admin.tambah_admin();
				break;
			}while(ch>2);
				
	}
	
}
