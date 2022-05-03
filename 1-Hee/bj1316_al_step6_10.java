package bakjoon2;

import java.util.ArrayList;
import java.util.Scanner;

public class bj1316_al_step6_10 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int inputNumber = 0;
		inputNumber = sc.nextInt();
		sc.nextLine();
		
		String[] input = new String[inputNumber];
		Boolean[] Judge = new Boolean[inputNumber];
		
		for(int i = 0 ; i<inputNumber; i ++) {
			input[i] = sc.nextLine();
		}
				
		
		ArrayList arr = new ArrayList<>();		
		boolean check = true;
		int count = 0;
		
		for(int i = 0 ; i < inputNumber ; i++) {
			for(int j = 0 ; j <input[i].length(); j++) {
				if(arr.contains(input[i].charAt(j))) {
					if(j>0) {
						if(input[i].charAt(j)!=input[i].charAt(j-1)) {
							check = false;
						}
					}
				} else {
					arr.add(input[i].charAt(j));
				}
			}
			if(check == true) count++;
			check =  true;		
			arr.clear();			
		}
		
		System.out.println(count);

		

	}

}
