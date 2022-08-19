package bakjoon2;

import java.util.Scanner;
import java.util.StringTokenizer;

public class bj1712_al_step7_1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		
		String input = sc.nextLine();
		
		StringTokenizer st = new StringTokenizer(input);
		int[] Calc = new int[st.countTokens()];
		for(int i = 0 ; i < Calc.length ; i++) {
			Calc[i] = Integer.valueOf(st.nextToken());
		}
		
		
		int answer = 1;
		if(Calc[1]-Calc[2]>0 || Calc[1]-Calc[2]==0) {
			answer = -1;
		} else {
			int Diff = Calc[2]-Calc[1];
			int Times = Calc[0]/Diff;
			answer = Times+1;			
		}
				
		System.out.println(answer);

	}

}
