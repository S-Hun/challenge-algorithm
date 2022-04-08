package bakjoon2;


import java.util.*;

public class bj1065_al_step5_3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		sc.nextLine();
		
		System.out.println(ArithmeticSequence(input));
		

	}
	
	private static int ArithmeticSequence(int number) {
		int cnt=0;
		
		if(number<100) {
			return number;
		} else {
			cnt=99;
			if(number==1000) number =999;
			
			for(int i=100; i<=number; i++) {
				int a = i/100;
				int b = (i/10)%10;
				int c = i%10;
				if((a-b)==(b-c)) {
					cnt++;
				}
				
			}
		}
		
		return cnt;
	}

}
