package bakjoon2;

import java.util.Scanner;
import java.util.StringTokenizer;

public class bj1978_al_step8_1 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String input = sc.nextLine();
		
		int[] member = new int[n];
		
		StringTokenizer st = new StringTokenizer(input);
		for(int i = 0  ; i < member.length; i++) {
			member[i] = Integer.valueOf(st.nextToken());
		}

		
		int count = 0;
		// 주어진 테스트 케이스 중 소수인 경우를 셈할 변수 count를 선언

		boolean check = false;
		// 전체 배열을 탐색하는 동안 배열속 숫자가 소수인지 아닌지 최종적으로 판단해줄 불리언 변수
		
		for(int i = 0 ; i < n ; i ++) {
			if(member[i]>1 && member[i]<4) {
				count++;			
				continue;
				// 주어진 숫자 x 가 1< x < 4 즉, 2또는 3이면 무조건 소수이므로 count를 증가시키고 i를 증가시킴.
			}
			
			for(int j = 2 ; j*j <= member[i]; j++) {
				// 어떤 숫자 x가 셈하기 굉장히 큰 수라고 해도,
				// 그 수가 소수인지 판단하는 데에는 그 수의 루트한 값만큼 까지의 자연수만을 살피면 된다.
				// 왜냐하면, 그 이상의 숫자는 1부터 루트 x 범위 사이의 자연수의 곱으로 표현할 수 있기 때문
				// 따라서 for문의 조건식은 이 조건을 반영한다.
				if(member[i]%j==0) {
					check = false;
					break;
					// 자기 자신 이외에 인수를 발견하면 즉시 반복문을 종료함.
				} else {
					check = true;					
				}
			}
			if(check==true) count++;
			

		}
		
		System.out.println(count);
		
		
			

	}

}
