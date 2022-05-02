package test;

import java.util.Scanner;

public class bj9020_al_step8_6 {
	
	public static Boolean JudgePrime(int n) {
		
		for(int i = 2 ; i*i <= n ; i++) {
			if(n%i==0) return false;
		}
		return true;

	}
	
	public static String GoldBahPartition(int n) {
		if(n<4) return null; // �������� 4 �̸��� ���� �־����� �����Ƿ� null�� ����ó����.
		else {
			// � ���� X�� �� ���� ���ڸ� ���ؼ� ǥ���ϰ�, ������ ������ ���̰� ���� �۰� �Ϸ��� 
			// �־��� �� X�� ������ ���� ���� ������ �Ҽ��� �۰��� �� �ִٰ� �����ߴ�. 
			// ��, X �� ������ ���� �߰������� �����ϴ� ���� X�� ǥ���ϴ� ��������Ƽ���� �ּ����� ���� ���ϴ� ������ ����̶�� �����ϰ�,
			// X�� ������ ���� �߰������� ���� �ϳ��� ���ҽ�Ű��, �ϳ��� ������Ű�鼭
			// ���ÿ� �� ���ڰ� ��� '�Ҽ�'�̾�� �ϹǷ� �Ҽ����� �Ǵ��ϴ� �޼��� JudgePrime()�� ����Ͽ�,
			// ���� ������Ű�鼭 �Ҽ������� ���ÿ� Ȯ���ߴ�.
			int lower = n/2;
			int upper = n/2;
			
			if(JudgePrime(lower)==true && JudgePrime(upper)==true) {
				return lower + " " + upper;
			} else {
				for(int i = lower-1; i>=2 ; i--) {
					upper++;
					if(JudgePrime(i)==true && JudgePrime(upper)==true) {
						return i + " " + upper;
					} else {
						continue;
					}
				}
				
			}						
		}
		return null;
	}

	public static void main(String[] args) {
		// 2���� ū ¦�� n�� �־����� ��, n�� ������ ��Ƽ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. 
		// ���� ������ n�� ������ ��Ƽ���� ���� ������ ��쿡�� �� �Ҽ��� ���̰� ���� ���� ���� ���
		// 4 �� n �� 10,000
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[] TestCase = new int[n];
		
		for(int i = 0 ; i< n ; i++) {
			TestCase[i] = sc.nextInt();
			sc.nextLine();
		}
		sc.close();
		
		for(int i = 0 ; i< TestCase.length ; i++) {
			System.out.println(GoldBahPartition(TestCase[i]));
		}
				

	}

}
