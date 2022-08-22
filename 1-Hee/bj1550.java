package solvedRanking;

import java.util.Scanner;

public class bz2_1550 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);		
		String input = sc.nextLine();		

		// 아래와 같은 폼을 사용하면 x진수를 10진수로 변환이 가능함.
		// 2진수도, 8진수도 가능함 두 번째 매개변수로 진수를 입력하면 자동 변환해줌.
		System.out.println(Integer.parseInt(input, 16));
		
		
	}

}
