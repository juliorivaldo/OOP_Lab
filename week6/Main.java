package week6;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		String[][] value = {{"A","B","A","C","C","D","E","E","A","D"}, 
							{"D","B","A","B","C","A","E","E","A","D"},
							{"E","D","D","A","C","B","E","E","A","D"},
							{"C","B","A","E","D","C","E","E","A","D"},
							{"A","B","D","C","C","D","E","E","A","D"}, 
							{"B","B","E","C","C","D","E","E","A","D"},
							{"B","B","A","C","C","D","E","E","A","D"},
							{"E","B","E","C","C","D","E","E","A","D"}};
		
		count_ans(value,8);
		
	}
	
	static void count_ans(String[][] ans, int jumlah) {
		
		int count_temp = 0;
		String[] key_temp = {"D","B","D","C","C","D","A","E","A","D"};
		
		for(int i = 0; i < jumlah ; i++) {
			for(int j = 0 ; j < 10 ; j++) {
				if(ans[i][j].equals(key_temp[j])) {
					count_temp+=1;
				}
			}
			System.out.println("Mhs " + i + " jumlah jawaban yang benar adalah " + count_temp);
			count_temp = 0;
		}
	}

}
