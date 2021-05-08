package week8;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User {
	private String admin_name;
	private String email;
	
	public ArrayList<Admin> arr_admin = new ArrayList<Admin>();
	
	public void tambah_admin() {
		Admin admin = new Admin();
		String temp;
		Scanner scan = new Scanner(System.in);
	
		System.out.print("Nama : ");
		temp = scan.nextLine();
		admin.set_adminName(temp);;
		System.out.print("email : ");
		temp = scan.nextLine();
		admin.set_email(temp);
		System.out.print("user_id : ");
		temp = scan.nextLine();
		admin.set_userId(temp);
		System.out.print("pass : ");
		temp = scan.nextLine();
		admin.set_pass(temp);
		arr_admin.add(admin);
		
		System.out.println(arr_admin.get(0).get_userId());
	}
	
	public void show_admin() {
		for(int i=0 ; i < arr_admin.size() ; i++) {
			System.out.println("Nama admin     : " + arr_admin.get(i).get_adminName());
			System.out.println("Email admin    : " + arr_admin.get(i).get_email());
			System.out.println("User_id admin  : " + arr_admin.get(i).get_userId());
			System.out.println("Password admin : " + arr_admin.get(i).get_pass());
			System.out.print("\n");
		}
	}
	
	//setter
	public void set_adminName(String admin_name) {
		this.admin_name = admin_name;
	}
	
	public void set_email(String email) {
		this.email = email;
	}
	
	//getter
	public String get_adminName() {
		return admin_name;
	}
	
	public String get_email() {
		return email;
	}
	
	public void update_catalog() {
		
	}
	
}
