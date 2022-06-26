package solvedRanking;

import java.util.ArrayList;
import java.util.Scanner;

public class bz4_1264 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = "";
		ArrayList Count = new ArrayList<>();
		int cnt = 0;
		
		do {
			str = sc.nextLine();
			str = str.toLowerCase();
			
			for(int i = 0 ; i < str.length(); i ++) {
				switch(str.charAt(i)) {
				case 'a':
					cnt++;
					break;
				case 'e':
					cnt++;
					break;
				case 'i':
					cnt++;
					break;
				case 'o':
					cnt++;
					break;
				case 'u':
					cnt++;
					break;
				}
								
			}
			if(str.charAt(0)!='#') {
				Count.add(cnt);
			}
			cnt = 0;
						
		}while(str.charAt(0)!='#');
		
		for(int i = 0 ; i < Count.size(); i ++) {
			System.out.println(Count.get(i));
		}
				
	}

}
