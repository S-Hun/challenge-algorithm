package bakjoon2;

import java.util.Scanner;

public class bj10872_al_step9_1 {
	
	public static int Factotrial (int n) {
		
		if(n<=1) return 1; //0 팩토리얼은 1이므로 1 리턴.
		
		return n*Factotrial(n-1); // 팩토리얼을 재귀함수로 구현한 식
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		sc.nextLine();
		
		System.out.println(Factotrial(X));
		
		

	}

}
