package test;

import java.util.Scanner;

public class bj2292_al_step7_2 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int[][] range = new int[18259][2];
		
		int input = sc.nextInt();
		sc.nextLine();		
		
		range[0][0] = 1;
		range[0][1] = 1;
		
		int i = 1;
		int count = 0;
		while(i<1000000000) {
			if(input<=i) break;
			count++;			
			range[1][0] = i+1;			
			i=i+(6*count);			
			range[1][1] = i;	
		}
		System.out.println(count+1);
	}

}
