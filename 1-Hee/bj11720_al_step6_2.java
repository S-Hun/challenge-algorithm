package bakjoon2;

import java.util.Scanner;

public class bj11720_al_step6_2 {

	public static void main(String[] args) {
//		5
//		54321
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		String input = sc.nextLine();
		int sum = 0 ;
		for(int i = 0 ; i < input.length() ; i++) sum += Integer.valueOf(String.valueOf(input.charAt(i)));
		System.out.println(sum);
		

		

	}

}
