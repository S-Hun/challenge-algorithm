package bakjoon2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj2798_al_step10_1 {

	public static void main(String[] args) {
		
		long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        
		        		
		Scanner sc = new Scanner(System.in);
		
		String FirstLines = sc.nextLine(); 
		String SecondLines = sc.nextLine(); 
		
		// 입력값을 문자열로 받았음으로 이 값을 변수에 담음.
		StringTokenizer st = new StringTokenizer(FirstLines);
		int Times = Integer.parseInt(st.nextToken());
		int Max = Integer.parseInt(st.nextToken());
		
		// 먼저 문자열을 배열로 전환함.
		String[] StrArr = SecondLines.split(" ");
		
		// 문자열 배열의 크기만큼 정수배열을 선언하고 반복문으로 값을 이식함.
		int[] IntArr = new int [StrArr.length];		
		for(int i = 0 ; i < StrArr.length; i ++) {
			IntArr[i] = Integer.parseInt(StrArr[i]);
		}
		
		// java.util.Arrays의 Arrays.sort() 메서드를 통해 입력된 배열 값을 오름차순으로 정렬.
		Arrays.sort(IntArr);
				
		int N = IntArr.length;
		int temp = 0; // 반복문에서 max값을 담는 기능을 할 변수
		
		// 전체 탐색을 삼중 반복문으로 하는 이유?
		// 가장 안쪽 반복문은 3번째 숫자부터 마지막까지 탐색한다. 
		// 그런데 이 탐색이 종료되면 1, 2번째 숫자(카드)가 한칸 옮겨져야 하기 때문에
		// 이러한 순서의 흐름을 구현하려면 삼중반복문이 필요함
		// 나는 반복문 하나로 하려 했으나 반복문 하나로 이러한 순서의 흐름이 나타나지 않아 실패함.
		// 그래서 다른 사례를 참고해서 반영함.
				
		for(int i = 0 ; i < N-2; i ++) {
			for(int j = i +1; j<N-1 ; j++) {
				for(int k = j+1; k<N ; k++) {
					// 반복문이 돌아감에 따라 계속해서 값을 계산함(for 한계값과의 비교를 위해)
					int sum = IntArr[i]+IntArr[j]+IntArr[k];
					

					// Max(입력받은 최댓값) 보다 작을 경우에만 비교연산을 하여 최댓값을 갱신함.
					if(sum<=Max) {
						temp = Math.max(temp, sum); 
					}
					if(sum==temp) {
						temp = sum;
						break;
					}					
				}
			}
		}
		
		System.out.println(temp);
				

	}

}
