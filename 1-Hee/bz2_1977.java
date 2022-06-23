package solvedRanking;

import java.util.Scanner;

public class bz2_1977 {

	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		sc.nextLine();
		int N = sc.nextInt();
		sc.nextLine();
		sc.close();

		
		// 문제의 풀이 법은 동일하게 생각했으나 코드로 예외 없이 잘 적용되도록 구현 못해서 다른 풀이를 참고한 문제.
		// 문제에서 원하는 것은 완전 제곱수를 원함.
		// 그러므로 주어진 숫자 M~N사이의 제곱수는 M, N의 제곱근 사이의 수를 제곱하여 구할 수 있음 >> 이렇게 하면 완전탐색으로 찾을 필요 없으므로 시간 단축 가능.
		// 그러나 이 문제에서 중요한 것은 범위를 코드로 잘 작성하는 것이 중요.
		// M 이상  N 이하이므로, M에 대해서는 "올림" 해야하고, N에대해서는 "내림" 해야함.
		// 예컨데 M이 64고 N이 65이면 64는 8의 제곱수 이므로 이 범위에서는 8의 제곱인 64가 가능하고 합은 64 최솟값도 64가 됨.
		// 이 설명을 코드로 구현하면 아래와 같음.
		
		
		
		int min = (int) Math.ceil(Math.sqrt(M));
		int sum = 0;
		
		for(int i =min ; i<= Math.floor(Math.sqrt(N)); i++) {
			sum+= (int) Math.pow(i, 2);
		}
		
		if(sum > 0 ) {
			System.out.println(sum);
			System.out.println((int)Math.pow(min, 2));
		}else System.out.println(-1);
		
	
		
	}
		
}


