package bakjoon2;

import java.util.Scanner;

public class bj10870_al_step9_2 {

	public static int[] FiboRes = new int[21];
	
	public static int Fibonacci(int n) {
		
		for(int i = 0 ; i <= n ; i ++) {
			if(i==0) FiboRes[i]=0;
			else if (i==1) FiboRes[i] = 1;
			else FiboRes[i] = FiboRes[i-1] + FiboRes[i-2];
		}
		return FiboRes[n];
	}
	
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		int n = sc .nextInt();
		sc.nextLine();
		System.out.println(Fibonacci(n));
		sc.close();

	}

}
