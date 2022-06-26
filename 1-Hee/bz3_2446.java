package solvedRanking;

import java.util.Scanner;

public class bz3_2446 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int max = sc.nextInt();
		sc.nextLine();
		
		for(int i = max ; i > 0 ; i--) {
			
			for(int j=1 ; j<i+max; j++ ) {
				if(j>max-i) {
					System.out.print("*");					
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
			
		}	
		
		for(int i = 1 ; i < max ; i ++) {
			
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
