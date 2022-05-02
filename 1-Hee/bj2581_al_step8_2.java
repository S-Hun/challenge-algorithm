package bakjoon2;

import java.util.Scanner;

public class bj2581_al_step8_2 {
	
	public static boolean Prime(int n) {
		if(n==1) return false;
		if(n==2 || n==3) return true; 
		
		for(int i = 2 ; i*i <=n ; i++) {
			if(n%i==0) {
				return false;
			} 
		}
		return true;
		
	}

	public static void main(String[] args) {
		
		int First = 0;
		int total = 0;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int m = sc.nextInt();
		sc.nextLine();
		
		for(int i=n; i<=m ; i++) {
			if(Prime(i)==true) {
				total+=i;
				if(First==0) {
					First=i;
				}
			}
		}
		
		if(total!=0) {
			System.out.println(total);
			System.out.println(First);
		} else {
			System.out.println(-1);
		}

		
		

	}

}
