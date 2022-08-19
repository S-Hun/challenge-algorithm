package test;

import java.util.*;

public class bakjoon2577_al_step4_3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		sc.nextLine();
		int b = sc.nextInt();
		sc.nextLine();
		int c = sc.nextInt();
		sc.nextLine();
		
		String numbers = String.valueOf(a*b*c);
		int[] member = new int[numbers.length()];
		
		for(int i=0; i < numbers.length() ; i++) member[i] = Integer.valueOf(String.valueOf(numbers.charAt(i)));		
		int count = 0;
		
		for(int i =0; i < 10 ; i++) {
			for(int j =0 ; j < member.length ;j++) {
				if(member[j]==i) {
					count++;
				}
			}
			System.out.println(count);
			count =0;
		}
				
		
		
	
	}

}
