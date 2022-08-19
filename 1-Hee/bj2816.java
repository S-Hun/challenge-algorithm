package solvedRanking;

import java.util.Scanner;

public class bz1_2816 {

	public static void main(String[] args) {
		
		// 문제에서 입력 값이 엔터로 구분되어 들어오므로 스캐너로 값을 받아봄.	
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		sc.nextLine();
		
		String[] Channel = new String[size];
		
		for(int i = 0 ; i < Channel.length; i++) {
			Channel[i] = sc.nextLine();
		}
		
		// 문제에서 제공하는 리모콘 조작 방법은 총 4가지인데, 
		// 가장 직관적이고 효율을 무시한 방법을 선택하기로 함.
		// why? 총 길이가 500자 이내면 된다는 조건때문인데,
		// 총길이 100개짜리 배열에서 KBS1가 100번째에 있다고 해도, 1번째에서 100번째로 가더라도 99단계, 가르킨 후 옮기는데에는 99단계가 소요됨.
		// 총 198단계이고, KBS2는 최댓값이 98단계 + 98단계 (why? KBS1을 먼저 정렬할 것이기 때문에) 196단계가 소요됨.
		// 따라서 최대 길이는 무조건 500자 이내가 되므로 이 방법을 선택하기로 함. 또한, 문제에서도 무지성 방법 & 효율을 선택한 방법 둘다 정답으로 인정하는 테스트케이스를 보여줌.
		
		// 총 선택지는 4가지 였지만, 선택할 방법은 C1, C2 2가지만 사용하기로 결정.
		
		String C1 = "1";
//		String C2 = "2";
//		String C3 = "3";
		String C4 = "4";
		String result = "";
		
		
		// idx1은 KBS1를 찾는데에 사용할 인덱스 변수
		// idx2는 KBS2를 찾는데에 사용할 인덱스 변수
		int idx1 = 0;
		int idx2 = 0;
		
				
		while(true) {
			if(Channel[idx1].equals("KBS1")) {
				break;
			} else {
				result += C1;
				idx1++;
			}			
		}
		
		// 위의 반복문을 통해 KBS1의 좌표를 탐색했으면, 그 좌표에 있는 KBS1을 배열 0번째 자리로 옮기는 작업을 함.
		for(int i = idx1 ; i>0; i --) {			
			result+=C4;
			String temp = Channel[i]; 
			Channel[i] = Channel[i-1];
			Channel[i-1] = temp;
		}
		
		
		
		while(true) {
			if(Channel[idx2].equals("KBS2")) {
				break;
			} else {
				result += C1;
				idx2++;
			}			
		}
		
		// 마찬가지로 위의 반복문을 통해 KBS2의 좌표를 탐색했으면, 그 좌표에 있는 KBS2를 배열 1번째 자리로 옮기는 작업을 함.
		for(int i = idx2 ; i>1; i--) {
			result+=C4;
			String temp = Channel[i]; 
			Channel[i] = Channel[i-1];
			Channel[i-1] = temp;
		}
		
		
		System.out.println(result); // 결과 도출.


	}

}
