package com.julio;
/**
 * @author Julio Rivaldo
 * NIM 2301943491
 * Sport App
 * First login :
 * Admin : username: admin ; password: admin
 * Organizer : uname : organizers ; pass : organizers
 * Player : uname : players ; pass : players
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static boolean loggedIn = false;
	public static String login ="";
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int ch = 0;
		
		ArrayList<Organizer> organizers = new ArrayList<>();
		ArrayList<Player> players = new ArrayList<>();
		ArrayList<Berita> beritas = new ArrayList<>();
		ArrayList<Event> events = new ArrayList<>();
		
        String fOrganizers = "organizers.txt";
        String fPlayers = "players.txt";
        String fEvents = "events.txt";
        String fBerita = "berita.txt";
		
		//Load File
		try {
            //Load Organizer
            ObjectInputStream inOrganizers = new ObjectInputStream(new FileInputStream(fOrganizers));
            organizers = (ArrayList<Organizer>) inOrganizers.readObject();
            inOrganizers.close();

            //Load Player
            ObjectInputStream inPlayers = new ObjectInputStream(new FileInputStream(fPlayers));
            players = (ArrayList<Player>) inPlayers.readObject();
            inPlayers.close();

            //Load Event
            ObjectInputStream inEvents = new ObjectInputStream(new FileInputStream(fEvents));
            events = (ArrayList<Event>) inEvents.readObject();
            inEvents.close();

            //Load Berita
            ObjectInputStream inBerita = new ObjectInputStream(new FileInputStream(fBerita));
            beritas = (ArrayList<Berita>) inBerita.readObject();
            inBerita.close();
            System.out.println("LOAD SUCCESS\n");

        } catch(IOException e) {
            System.out.println("IOException is caught\n");
        } catch(ClassNotFoundException e) {
            System.out.println("ClassNotFoundException is caught");
        }
		
		do {
			firstpage();
			System.out.println("Input choice: ");
			try{
                ch = scan.nextInt();
            }catch (Exception e){
                System.out.println("out of choice");
            }scan.nextLine();
			switch(ch) {
			case 1 :
				login(organizers,players,beritas,events);
				loggedIn=false;
				break;
			case 2 : 
				create_acc(organizers,players);
				loggedIn=false;
				break;
			case 3 :
				save_exit(organizers, players, events, beritas, fOrganizers, fPlayers, fEvents, fBerita);
			}
		}while(ch!=3);
	}
	private static void save_exit(ArrayList<Organizer> organizers, ArrayList<Player> players, ArrayList<Event> events, ArrayList<Berita> beritas,
			String fOrganizers, String fPlayers, String fEvents, String fBerita) {
        try
        {
            //Save files
            //Save Organizer.txt
            ObjectOutputStream outOrganizers = new ObjectOutputStream(new FileOutputStream(fOrganizers));
            outOrganizers.writeObject(organizers);

            //Save Players.txt
            ObjectOutputStream outPlayers = new ObjectOutputStream(new FileOutputStream(fPlayers));
            outPlayers.writeObject(players);

            //Save Events.txt
            ObjectOutputStream outEvents = new ObjectOutputStream(new FileOutputStream(fEvents));
            outEvents.writeObject(events);

            //Save Berita.txt
            ObjectOutputStream outBerita = new ObjectOutputStream(new FileOutputStream(fBerita));
            outBerita.writeObject(beritas);

            System.out.println("\nFile Saved");
        }
        catch(IOException ex)
        {
            System.out.println("Error Occured");
        }
    }
	
	public static void firstpage() {
		System.out.println("---Sport App---");
		System.out.println("1. Login to App");
		System.out.println("2. Create Account");
		System.out.println("3. Save and Exit");
	}
	public static void login(ArrayList<Organizer> organizers, ArrayList<Player> players, ArrayList<Berita> beritas, ArrayList<Event> events) {
        Scanner scan = new Scanner(System.in);
        String user,pass;
        String position="";
		
		System.out.println("Announcements :");
        if (beritas.size() < 1){
            System.out.print("Check Again Later!");
        }else{
            for(Berita b : beritas) {
            	System.out.println(b.getBerita());
            }
        }
        //Login
        System.out.println("\nApp Login");
        do{
            System.out.print("username : ");
            user = scan.nextLine();
            System.out.print("password : ");
            pass = scan.nextLine();
            //Check if login as organizer
            for (Organizer o : organizers){
                if (o.getUser().equals(user) && o.getPass().equals(pass)){
                	if(o.isBlock()) System.out.println("Blocked!");
                	else if(!o.isRegis()) System.out.println("Wait For Approval <3");
                	else {
                		position = "organizer";
                		login = o.getUser();
                        loggedIn = true;	
                		}
                    }
                }
            //Check if login as player
            for (Player o : players){
                if (o.getUser().equals(user) && o.getPass().equals(pass)){
                	if(o.isBlock()) System.out.println("Blocked!");
                	else if(!o.isRegis()) System.out.println("Wait For Approval <3");
                	else {
                		position = "player";
                		login = o.getUser();
                        loggedIn = true;	
                		}
                    }
                }
            //Check if login as admin
            if(user.equals("admin") && pass.equals("admin")){
            	position = "admin";
            	loggedIn = true;
            }
        }while (!loggedIn);
        
        switch(position) {
        case "admin" :
        	System.out.println("Admin");
        	adminmenu(organizers,players,beritas);
        	loggedIn=false;
        	break;
        case "organizer" :
        	System.out.println("Organizer");
        	organizermenu(organizers,events);
        	loggedIn=false;
        	break;
        case "player" :
        	System.out.println("Player");
        	playermenu(players,events);
        	loggedIn=false;
        	break;
        }
	}
	public static void adminmenu(ArrayList<Organizer> organizers, ArrayList<Player> players, ArrayList<Berita> beritas) {
		int ch = 0;
		do {
		Scanner scan = new Scanner(System.in);
		System.out.println("--ADMIN MENU--");
		System.out.println("1.Post Pengumuman");
		System.out.println("2.Regis Akun");
		System.out.println("3.Block Akun");
		System.out.println("4.EXIT");
		System.out.print("Input Choice: ");
			try{
                ch = scan.nextInt();
            }catch (Exception e){
                System.out.print("out of choice");
            }scan.nextLine();
            switch(ch) {
            case 1 :
            	add_announcement(beritas);
            	break;
            case 2 :
            	regist_akun(organizers,players);
            	break;
            case 3 :
            	block_account(organizers,players);
            	break;
            }
		}while(ch !=4 );
		
	}
	
	public static void regist_akun(ArrayList<Organizer> organizers, ArrayList<Player> players) {
		String position,temp;
		boolean status=false;
		Scanner scan = new Scanner(System.in);
		System.out.println("--Regist akun--");
		do {
			System.out.print("Registrasi akun [organizer/player]: ");
			position=scan.nextLine();
		}while(!position.equals("organizer") && !position.equals("player"));
		switch(position) {
		case "organizer":
		dataorganizer(organizers);
			do
			{
				System.out.print("Masukkan nama untuk regist: ");
				temp = scan.nextLine();
				for(Organizer o : organizers) {
					if(o.getUser().equals(temp)) {
						status=true;
						o.setRegis(true);
					}
				}
			}while(!status);
			break;
		case "player" :
			dataplayer(players);
			do
			{
				System.out.print("Masukkan nama untuk regist: ");
				temp = scan.nextLine();
				for(Player o : players) {
					if(o.getUser().equals(temp)) {
						status=true;
						o.setRegis(true);
					}
				}
			}while(!status);
			break;
		}
	}
	public static void dataorganizer(ArrayList<Organizer> organizers) {
		System.out.println(" USERNAME        | REGISTRASI | BLOCKED");
	     System.out.println("***************************************");
	     for(Organizer o : organizers) {
	        System.out.printf("%-16s |", o.getUser());
	        if (o.isRegis()){
	        	System.out.print(" YA          |");
	            } else System.out.print(" TIDAK       |");
	        	if (o.isBlock()){
	            System.out.println(" YA ");
	            } else System.out.println(" TIDAK    ");
	        }
	}
	public static void dataplayer(ArrayList<Player> players) {
		 System.out.println(" USERNAME        | REGISTRASI | BLOCKED");
	     System.out.println("***************************************");
	     for(Player o : players) {
	        System.out.printf("%-16s |", o.getUser());
	        if (o.isRegis()){
	        	System.out.print(" YA          |");
	            } else System.out.print(" TIDAK       |");
	        	if (o.isBlock()){
	            System.out.println(" YA   ");
	            } else System.out.println(" TIDAK    ");
	        }
	}
	public static void block_account(ArrayList<Organizer> organizers, ArrayList<Player> players) {
		String position,temp;
		boolean status=false;
		Scanner scan = new Scanner(System.in);
		System.out.println("--Block Account--");
		do {
			System.out.print("Block akun [organizer/player]: ");
			position=scan.nextLine();
		}while(!position.equals("organizer") && !position.equals("player"));
		switch(position) {
		case "organizer":
		dataorganizer(organizers);
			do
			{
				System.out.print("Masukkan nama untuk setblock: ");
				temp = scan.nextLine();
				for(Organizer o : organizers) {
					if(o.getUser().equals(temp)) {
						status=true;
						o.setBlock(true);
					}
				}
			}while(!status);
			break;
		case "player" :
			dataplayer(players);
			do
			{
				System.out.print("Masukkan nama untuk regist: ");
				temp = scan.nextLine();
				for(Player o : players) {
					if(o.getUser().equals(temp)) {
						status=true;
						o.setBlock(true);
					}
				}
			}while(!status);
			break;
		}
	}
	public static void create_acc(ArrayList<Organizer> organizers, ArrayList<Player> players) {
		Scanner scan = new Scanner(System.in);
		String username, password,position;
		
		System.out.println("--Create Account--");
		System.out.println("1. Organizer");
		System.out.println("2. Player");
		do {
			System.out.print("Input Choice [organizer/player]: ");
			position=scan.nextLine();
		}while(!position.equals("organizer") && !position.equals("player"));
        do {
        	//Create username and password
            do {
                System.out.print("\nInput username [15]: ");
                username = scan.nextLine();
            }while (username.length()>15 || username.length()<1);
            do {
                System.out.print("Input password [15]: ");
                password = scan.nextLine();
            }while (password.length()>15 || password.length()<1);
            
            if(position.equals("organizer")) {
            	for (Organizer o : organizers){
                    if (o.getUser().equals(username)){
                        System.out.println("Invalid! Try other username");
                        loggedIn=false;
                        break;
                    }
                    loggedIn=true;
                }
            }
            if(position.equals("player")) {
            	for (Player o : players){
                    if (o.getUser().equals(username)){
                        System.out.println("Invalid! Try other username");
                        loggedIn=false;
                        break;
                    }
                    loggedIn=true;
                }
            } 
        }while (!loggedIn);
        //Adding user to list (organizers/players)
        if(position.equals("organizer")) organizers.add(new Organizer(username, password));
        if(position.equals("player")) players.add(new Player(username,password));
        System.out.println("Berhasil membuat akun silahkan tunggu verifikasi admin untuk melanjutkan");
	}
	public static void organizermenu(ArrayList<Organizer> organizers, ArrayList<Event> events) {
		int ch;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("--" + login + ", Menu--");
			showevents(events);
			System.out.println("1.Add Event");
			System.out.println("2.Edit Event Status");
			System.out.println("3.Exit");		
			System.out.print("Input Choice: ");
			ch=scan.nextInt();
			switch(ch) {
			case 1 :
				add_event(events);
				break;
			case 2 :
				edit_event(events);
				break;
			}
		}while(ch !=3);
	}
	public static void showevents(ArrayList<Event> events) {
		int no=1; 
		System.out.println("----Events----");
	    System.out.println("| NO | NAMA            | ORGANIZER      | KATEGORI  | LEVEL        | D / M / Y      | TEMPAT               |    MIN      |      MAX    | SLOT TERISI      | BIAYA    | STATUS |");
	    System.out.println("===============================================================================================================================================================================");
	    for (Event k : events){
	    	System.out.printf("| %-2d | %-15s | %-20s | %-10s | %-12s | %-2d / %-2d / %-4d | %-20s | %-11d | %-11d | %-16d | %-8d |", no, k.getNama(), k.getOrganizer(), k.getKategori(), k.getLevel(), k.getTanggal(), k.getBulan(), k.getTahun(), k.getTempat(), k.getMin_player(), k.getMax_player(), k.getPlayer(), k.getBiaya());
	        if (k.isAvail()){
	        	System.out.println(" OPEN   |");
	        } else System.out.println(" CLOSE |");
	        no++;
	    }
	        System.out.println("===============================================================================================================================================================================");

	}
	public static void add_event(ArrayList<Event> events) {
		String kategori, level, tempat, nama;
        int tanggal, bulan, tahun, min_player, max_player, biaya;
        Scanner scan = new Scanner(System.in);
        //Create new Event
        do{
            System.out.print("Event's name: ");
            nama = scan.nextLine();
        }while (nama.length()<1);
        do {
            System.out.print("Category [Badminton | Tenis | Swim | GYM] : ");
            kategori = scan.nextLine();
        }while (!kategori.equals("Badminton") && !kategori.equals("Tenis") && !kategori.equals("Swim") && !kategori.equals("GYM"));
        do {
            System.out.print("Level [beginner | intermediate | advanced] : ");
            level = scan.nextLine();
        }while (!level.equals("beginner") && !level.equals("intermediate") && !level.equals("advanced"));
        do{
            System.out.print("Date [1-31] : ");
            try{
                tanggal = scan.nextInt();
            }catch (Exception e){
                System.out.println("wrong input");
                tanggal=0;
            }scan.nextLine();
        }while (tanggal<1 || tanggal>31);
        do{
            System.out.print("Month [1-12] : ");
            try{
                bulan = scan.nextInt();
            }catch (Exception e){
                System.out.println("wrong input");
                bulan=0;
            }scan.nextLine();
        }while (bulan<1 || bulan>12);
        do{
            System.out.print("Year: ");
            try{
                tahun = scan.nextInt();
            }catch (Exception e){
                System.out.println("wrong input");
                tahun=0;
            }scan.nextLine();
        }while (tahun<2000 || tahun>3000);
        do{
            System.out.print("Place : ");
            tempat = scan.nextLine();
        }while (tempat.length()<1);
        do{
            System.out.print("Minimal player : ");
            try{
                min_player = scan.nextInt();
            }catch (Exception e){
                System.out.println("wrong input");
                min_player=0;
            }scan.nextLine();
        }while (min_player<1 );
        do{
            System.out.print("Maximum player : ");
            try{
                max_player = scan.nextInt();
            }catch (Exception e){
                System.out.println("wrong input");
                max_player=0;
            }scan.nextLine();
        }while (max_player < min_player);
        do{
            System.out.print("Masukkan biaya pendaftaran[>1000] : ");
            try{
                biaya = scan.nextInt();
            }catch (Exception e){
                System.out.print("wrong input\n");
                biaya=0;
            }scan.nextLine();
        }while (biaya<1000);

        events.add(new Event(kategori, nama, login, level, tempat, tanggal, bulan, tahun, min_player, max_player, biaya));
        System.out.println("Event Created");
	}
	//function for validation events
	public static void edit_event(ArrayList<Event> events) {
		String name,temp;
		boolean status=false;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("Name of Event: ");
			name = scan.nextLine();
			for(Event e : events) {
				if(e.getOrganizer().equals(login)) status=true;
			}
		}while(!status);
		System.out.print("Switch status?[yes/no]: ");
		do {
			temp=scan.nextLine();
		}while(!temp.equals("yes") && !temp.equals("no"));
		if(temp.equals("yes")) {
			for(Event e: events) {
				if(e.getNama().equals(name) && e.getOrganizer().equals(login)) {
					if(e.isAvail() == true) e.setAvail(false);
					else e.setAvail(true);
				}
			}
		}
	}
	public static void playermenu(ArrayList<Player> players, ArrayList<Event> events) {
		int ch;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("---" + login + ", Menu---");
			playerevents(events);
			System.out.println("1.Join Event");
			System.out.println("2.Add title to friends");
			System.out.println("3.Cancel event");	
			System.out.println("4. Exit");
			System.out.print("Input Choice: ");
			ch=scan.nextInt();
			switch(ch) {
			case 1 :
				join_event(players,events);
				break;
			case 2 :
				add_title(players);
				break;
			case 3 :
				cancel_event(events);
				break;
			}
		}while(ch !=4);
	}
	public static void join_event(ArrayList<Player> players, ArrayList<Event> events) {
		boolean status=false;
		String event,player;
		int i=0;
		Scanner scan = new Scanner(System.in);	
		showevents(events);
		do {
			System.out.println("Name of Event: ");
			event = scan.nextLine();
			for(Event e : events) {
				if(e.getNama().equals(event)) {
					status=true;
					break;
				}
				i++;
			}
		}while(!status);
            Event e = events.get(i);
            if (!e.isAvail()){
                System.out.println("Registration Closed");
            } else if (e.getMax_player() <= e.getPlayer()){
                System.out.println("Event is Full");
            } else if (e.getList_pemain().contains(login)){
                System.out.println(login + " have been Registered");
            } else {
                e.setList_pemain(login);
                e.add_player();
                System.out.println("Success");
            }
        }
	public static void playerevents(ArrayList<Event> events) {
		int no = 1;
		System.out.println(login+ ", Events--");
		for(Event e : events) {
			if(e.getList_pemain().contains(login)) {
				System.out.println(no + ". " + e.getNama());
				no++;
			}
		}System.out.println();
		if(no == 1)System.out.println("No Events");
	}
	public static void add_title(ArrayList<Player> players) {
		int no=1, temp=0, count =0;
		Scanner scan = new Scanner(System.in);
		boolean status= false;
		String nama,title;
		Player player =null;
		System.out.println("Players Registered");
		for(Player p : players) {
			System.out.println(no + ". " + p.getUser());
		}
		do{
            System.out.print("Input Player name : ");
            nama = scan.nextLine();
            for(Player p : players) {
            	if(p.getUser().equals(nama)) {
            		temp = count;
            		status = true;
            		break;
            	}
            	count++;
            }
        }while (!status);

        do {
            System.out.print("Add Title[15]: ");
            title = scan.nextLine();
        }while (title.length()<1 || title.length()>15);
	}
	public static void cancel_event(ArrayList<Event> events) {
		boolean status=false;
		String event;
		Scanner scan = new Scanner(System.in);	
		playerevents(events);
		do {
			System.out.println("Name of Event: ");
			event = scan.nextLine();
			for(Event e : events) {
				if(e.getNama().equals(event)) {
					Event.del_player(login);
					e.subtract_player();
					status=true;
					break;
				}
			}
		}while(!status);
	}
	public static void add_announcement(ArrayList<Berita> beritas) {
		String new_berita;
		Scanner scan = new Scanner(System.in);
		System.out.print("Masukkan berita : ");
		new_berita = scan.nextLine();
		beritas.add(new Berita(new_berita));
	}
}