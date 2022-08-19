package test;

import java.util.ArrayList;
import java.util.Scanner;

public class bj4948_al_8_5 {
	
	
	public static int RangePirmeNumber(int n) {
		
		int count = 0;
		boolean check = false;
		
		switch(n) {
		case 1:
			return 1;			
		default:
			for(int k = n+1 ; k<=2*n ; k++) {
				if(k==2 || k==3) {
					count++;
					continue;
				} else {
					for(int i = 2 ; i*i <= 2*n ; i++) {
						if(k%i==0) {
							check =false;
							break;
						} else check = true;
					}
					if(check==true) {
						count++;
						check = false;
					}
				}
			}
			return count;
		}		
	}
	

	public static void main(String[] args) {
		// n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하는 프로그램
		Scanner sc = new Scanner(System.in);
		ArrayList arr = new ArrayList<>();
		
		int n=-1;
		while(n!=0) {
			n=sc.nextInt();
			sc.nextLine();
			arr.add(n);			
		}
		
		for(int i = 0 ; i< arr.size(); i++) {
			if((int) arr.get(i)!=0) {
				System.out.println(RangePirmeNumber((int) arr.get(i)));
			}
		}
		
		
		

	}

}
