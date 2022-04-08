package bakjoon2;

import java.util.*;

public class bj2675_al_step6_4 {

	public static void main(String[] args) {
		
//		2
//		3 ABC
//		5 /HTP
		Scanner sc = new Scanner(System.in);
		int play = sc.nextInt();
		sc.nextLine();
		String[][] info = new String[play][2];
		String[] result = new String[play];
		
		for(int i = 0 ; i <play ; i++) {
			String temp = sc.nextLine();
			info[i] = temp.split(" ");		
		}
		
		for(int i = 0 ; i < play ; i ++) {
			String temp2 = "";
			for(int j = 0 ; j < info[i][1].length(); j++) {
				for(int k = 0 ; k < Integer.valueOf(info[i][0]); k++) {
					temp2 += info[i][1].charAt(j);
				}
			}
			result[i]=temp2;
		}
		
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		

		
		
		
		

	}

}
