package bakjoon2;

import java.util.Scanner;

public class bj10872_al_step9_1 {
	
	public static int Factotrial (int n) {
		
		if(n<=1) return 1; //0 ���丮���� 1�̹Ƿ� 1 ����.
		
		return n*Factotrial(n-1); // ���丮���� ����Լ��� ������ ��
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		sc.nextLine();
		
		System.out.println(Factotrial(X));
		
		

	}

}
