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
		// n���� ũ��, 2n���� �۰ų� ���� �Ҽ��� ������ ���ϴ� ���α׷�
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
