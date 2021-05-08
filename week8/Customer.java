package week8;

import java.util.*;

public class Customer extends User {
	private String customer_name;
	private String address;
	private String email;
	private String credit_card_info;
	private String shipping_info;
	
	public ArrayList<Customer> arr_cust = new ArrayList<Customer>();
	
	private void calculate_next_bill_amount() {
		
	}
	
	public void tambah_customer() {
		Customer customer = new Customer();
		String temp;
		Scanner scan = new Scanner(System.in);
	
		System.out.print("Nama : ");
		temp = scan.nextLine();
		customer.set_custName(temp);
		System.out.print("Alamat : ");
		temp = scan.nextLine();
		customer.set_address(temp);
		System.out.print("email : ");
		temp = scan.nextLine();
		customer.set_email(temp);
		System.out.print("user_id : ");
		temp = scan.nextLine();
		customer.set_userId(temp);
		System.out.print("pass : ");
		temp = scan.nextLine();
		customer.set_pass(temp);
		arr_cust.add(customer);
		
		System.out.println(arr_cust.get(0).get_userId());
	}
	
	public void show_user() {
		for(int i=0 ; i < arr_cust.size() ; i++) {
			System.out.println("Nama user     : " + arr_cust.get(i).get_custName());
			System.out.println("Alamat user   : " + arr_cust.get(i).get_address());
			System.out.println("Email user    : " + arr_cust.get(i).get_email());
			System.out.println("User_id user  : " + arr_cust.get(i).get_userId());
			System.out.println("Password user : " + arr_cust.get(i).get_pass());
			System.out.print("\n");
		}
	}
	
	//setter function
	
	public void set_custName(String customer_name) {
		this.customer_name=customer_name;
	}
	
	public void set_address(String address) {
		this.address = address;
	}
	
	public void set_email(String email) {
		this.email = email;
	}
	
	//getter function
	public String get_custName() {
		return customer_name;
	}
	
	public String get_address() {
		return address;
	}
	
	public String get_email() {
		return email;
	}
	
	public void bill() {
		
	}
	
	public void register() {
		
	}
	
	public void login() {
		
	}
	
	public void update_profile() {
		
	}
}
