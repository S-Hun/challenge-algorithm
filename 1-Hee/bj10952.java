package test;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bakjoon10952_al_step3_12 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		
		String input = "";

		int a, b;
		
		ArrayList arr = new ArrayList<>();

		// 문제에서 입력은 출력보다 많으므로, do while문으로 입력을 받은 후 출력할 것을 결정함
		do {
			input = sc.nextLine();		
			StringTokenizer st = new StringTokenizer(input);
			a = Integer.valueOf(st.nextToken());
			b = Integer.valueOf(st.nextToken());
			int answer = a+b;
			if(a!=0 && b!=0) {
				// 바로 출력하지 않고 ArrayList에 값을 넣어둠
				arr.add(answer);
			}
			
		}				
		while(a!=0 && b!=0);
		
		for(int i = 0 ; i <arr.size() ;i++) {
			// while문이 깨지고 나오면서 그동안 ArrayList에 저장된 값들을 출력함.
			System.out.println(arr.get(i));
		}
		
		

		


	}
}
