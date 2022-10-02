package algos;

import java.util.Scanner;

public class SWEA_5162_두가지빵의딜레마 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		for(int t = 1 ; t <= T ; t++) {
			sb.append("#"+t+" ");

			int Aprice = sc.nextInt();
			int Bprice = sc.nextInt();
			long money = sc.nextLong();
			
			if(Aprice>Bprice) sb.append(money/Bprice).append("\n");
			else sb.append(money/Aprice).append("\n");
			
		}
		System.out.print(sb.toString());
		

	}

}
