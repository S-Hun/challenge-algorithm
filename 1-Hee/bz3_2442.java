package solvedRanking;

import java.util.Scanner;

public class bz3_2442 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int max = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0 ; i < max ; i ++) {
			
			for(int j=0 ; j<i+max; j++ ) {
				if(j>=max-i-1) {
					System.out.print("*");					
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();			
		}		
		
	}
}
