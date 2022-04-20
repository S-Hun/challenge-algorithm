package test;

import java.util.Scanner;
import java.util.StringTokenizer;

public class bj2869_al_step7_4 {

	public static void main(String[] args) {
		
		long starttimes = System.currentTimeMillis();
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		StringTokenizer st = new StringTokenizer(input);
		int[] numbers = new int[3];
		
		for(int i = 0 ; i < numbers.length ; i++) numbers[i] = Integer.valueOf(st.nextToken());
		
		int sum = numbers[2]-numbers[0]+1;
		System.out.println(sum);
		
		long endtimes = System.currentTimeMillis();
		long diff = endtimes- starttimes;
		System.out.println(diff);

		
		// 정확히는 백준에서 시간초과로 오류나서 안되는 코드인데
		// 수동으로 입력해보면 300ms 까지 나옴
		// 아마문제풀이 언어가 달라서 안되는 것 같아서 일단 작성후 올림

	}

}
