package solvedRanking;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class bz1_2309 {

	public static void main(String[] args) {
		
		int[] members = new int[9];	// 일곱난쟁이 후보를 전부 담을 배열	
		boolean[] check = new boolean[9]; // 원래 난쟁이인지 아닌지 판별한 논리 값을 저장하는 배열
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0 ; i < 9 ; i ++) {
			members[i] = sc.nextInt();
			sc.nextLine();
		}
		
		
		// 계산 및 값 탐색에 용이하도록 배열을 오름차로 정리함.
		Arrays.sort(members);		
		
		// 난쟁이의 키의 합은 100을 만족, 주어진 값을 전부 합하면 무조건 100을 초과한다.		
		// 초과 값 (gap) = 난쟁이 후보들의 키의 총합 - 100 라고 할 때,
		// 초과 값 gap은 난쟁이 후보 속의 어떤 두 숫자의 합임을 알 수 있다.
		
		int sum = IntStream.of(members).sum();		
		int gap = sum-100;
		boolean JudgeFlag = false;		
		
		for(int i = 0 ; i < members.length; i ++) {			
			
			// 난쟁이 후보 중 하나의 키가 100을 초과하는 차이(gap)보다 크다면 그 난쟁이는 무조건 실제 난쟁이이다.
			if(members[i]>gap) {
				check[i] = false; 
			} else {
				
				for(int j = 0 ; j<members.length; j++) {
					// 위에서 혹시나 gap보다 큰 키를 갖는 난쟁이의 경우에는 탐색 대상에서 제외하고,
					// 반복문을 가속하기 위해 조건문을 통해 탐색후 continue로 반복문을 진행 시킴.
					if(check[j]) {
						continue;
					} else {
						if(members[i]+members[j]==gap) { // 현 조건문을 만족하는 숫자는 실제 난쟁이가 아니다. 
														 // 문제에서 다른 조합이 있더라도 중복 정답을 허용하므로 추가적으로 통해 한 쌍의 값을 추릴 필요는 없다. 
							check[i] = true;
							check[j] = true;
							JudgeFlag = true; // 이중 반복문이어서 바로 반복문을 종료시키기 위해 불리언 변수를 사용.
							break;
						}
					}
				}				
			}
			
			if(JudgeFlag) {				
				break; // 내부 반복문에서 값 탐색이 끝나면 바로 반복문이 종료되도록 함.
			}
			
		}
		
		for(int i = 0 ; i < members.length; i ++) {
			// 모든 난쟁이 후보 배열과 짝을 이루는 불리언 배열을 통해 값의 출력 여부를 결정.
			if(!check[i]) {
				System.out.println(members[i]);
			}
		}
				
	}

}
