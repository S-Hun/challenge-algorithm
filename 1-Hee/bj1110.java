package test;

import java.util.*;

public class bakjoon1110_al_step3_14 {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		int Input = sc.nextInt();
		int x = 0, count =0;
		int answer = Input;
		boolean check=false;
		
		
		while(check!=true) {
			count++;
			
			int n1 = answer/10;
			int n2 = answer%10;
			
			if(n1+n2>9) {
				x= (n1+n2)%10;
			} else {
				x = n1+n2;
			}
			
			if(n2*10 + x==Input) {
				check = true;
				answer = n2*10 + x;
			} else {
				answer = n2*10 + x;

			}
		}
		
		System.out.println(count);
		
		

	}

}
