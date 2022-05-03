package bakjoon2;

import java.util.*;

public class bj5622_al_step6_8 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		input = input.toUpperCase();
		
		HashMap<String,Integer> Dial = new HashMap<String,Integer>();
		int start = 65;		
		for(int i = 2 ; i <= 9 ; i++) {
			
			if(i!=7 && i!=9) {
				for(int j = 0 ; j < 3 ; j++) {
					Dial.put(String.valueOf((char) start), i);
					start++;
				}			
			} else {
				for(int j = 0 ; j < 4 ; j++) {
					Dial.put(String.valueOf((char) start), i);
					start++;
				}			
			}
		}

				
		int sum = 0;		
		for(int i = 0 ; i < input.length() ; i++) {
			sum += (Dial.get(String.valueOf(input.charAt(i))) + 1);
		}
		System.out.println(sum);	

	}

}
