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
		if(n<4) return null; // 문제에서 4 미만의 값을 주어지지 않으므로 null로 예외처리함.
		else {
			// 어떤 숫자 X를 두 개의 숫자를 더해서 표현하고, 각각의 숫자의 차이가 가장 작게 하려면 
			// 주어진 수 X를 반으로 나눈 값에 가깝게 할수록 작게할 수 있다고 가정했다. 
			// 즉, X 를 반으로 나눈 중간값에서 시작하는 것이 X를 표현하는 골드바흐파티션의 최소차이 값을 구하는 최적의 방법이라고 가정하고,
			// X를 반으로 나눈 중간값에서 값을 하나는 감소시키고, 하나는 증가시키면서
			// 동시에 두 숫자가 모두 '소수'이어야 하므로 소수인지 판단하는 메서드 JudgePrime()를 사용하여,
			// 값을 증감시키면서 소수인지를 동시에 확인했다.
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
		// 2보다 큰 짝수 n이 주어졌을 때, n의 골드바흐 파티션을 출력하는 프로그램을 작성하시오. 
		// 만약 가능한 n의 골드바흐 파티션이 여러 가지인 경우에는 두 소수의 차이가 가장 작은 것을 출력
		// 4 ≤ n ≤ 10,000
		
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
