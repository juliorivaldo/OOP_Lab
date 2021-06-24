/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TA;

import java.util.Scanner;

public class Main {
    final static private String EASY = "134862705";
    final static private String MEDIUM = "281043765";
    final static private String HARD = "567408321";
    final static private String GOAL = "123804765";

    public static void main(String[] args) {
        String root = null;
        String inputUser;
        int ch;
        Scanner scan = new Scanner(System.in);
        
        do {
            System.out.println("8 Puzzle AI");
            System.out.println("1. Choose State");
            System.out.println("2. Create State");
            System.out.println("Enter number : ");
            ch = scan.nextInt();
        }while(ch > 2 || ch < 1);
        
        switch(ch) {
        case 1 :
        	do {
        	System.out.println("1. Easy");
            	System.out.println("2. Medium");
            	System.out.println("3. Hard");
            	ch = scan.nextInt();
            }while(ch > 3 || ch < 1);
        	switch(ch) {
        	case 1 : 
        		root = EASY;
        		break;
        	case 2 :
        		root = MEDIUM;
        		break;
        	case 3 :
        		root = HARD;
        	}
        	break;
        case 2 :
        	do {
            	System.out.println("Masukkan Matrix dalam bentuk String[0-8]: ");
                scan.nextLine();
            	inputUser = scan.nextLine();
            }while(inputUser.length() > 9);
            root = inputUser;
        }
        
        BFS search = new BFS(new Node(root), GOAL);
        search.BreadthFirstSearch();


    }
}
