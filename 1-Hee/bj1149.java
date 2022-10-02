import java.util.Scanner;

public class sv1_1149 {
	
	static int[][] cost;
	static int[][] DP;

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		
		
		// cost 에서는 입력값을 모두 담는 배열로 사용
		cost = new int[N][3];
		
		// cost와 동일한 폼으로 배열을 생성해서 값을 담으면,
		// 모든 경우의 수에 대한 값을 저장할 수 있게 되며 단계별로도 저장이 가능해짐.
		// 예컨데 [1][2]인 경우 첫번째부터 두번째까지 색깔을 고를때, 두번째가 2(초록)인 경우의 최소 값을 담을 수 있음.
		// 아래의 배열 선언 자체로는 이 기능이 구현 안되지만, 밑에 새롭게 정의한 메서드 Paint_Cost와 함께라면 기능함.
		DP = new int[N][3];
		
		for(int i = 0 ; i < N ; i++) {
			cost[i][0] = sc.nextInt();
			cost[i][1] = sc.nextInt();
			cost[i][2] = sc.nextInt();
			sc.nextLine();
		}
		
		
		// 문제에서 선택지는 3가지이므로 총 경우의 수는 3가지이다.
		// 따라서 첫 시작 값을 R(0), G(1), B(2) 각각 세팅하고 시작한다.
		
		DP[0][0] = cost[0][0];
		DP[0][1] = cost[0][1];
		DP[0][2] = cost[0][2];
		
		// 아래의 코드는 사용자 정의 메서드를 사용해 최소값을 출력하는 코드인데,
		// 비교할 대상이 3개이므로 아래와 같이 Math.min()을 사용해 값을 비교하게 됨.
		// 하지만, 시작점의 "색상(선택지)"값은 아래와 같이 코드로 주어져야 하기 때문에 아래처럼 시작을 함.
		// 이 다음 단계는 아래 메서드에서 재귀적 흐름에 따라 계산되어 반환됨.
		int result = Math.min(Paint_Cost(N-1, 0), Math.min(Paint_Cost(N-1, 1), Paint_Cost(N-1, 2)));
		System.out.println(result);
		
	}
	
	static int Paint_Cost(int N, int color) {
		
		// 이 메서드에서는 시작 값 N이 들어온다, N은 문제에서 주어지는 입력값이며 본 재귀함수의 시작값이 된다.
		// 정확히는 N이 주어지면 N-1이 들어오게 되는데, 
		// N-1=N으로 취급하는 이유는 이 함수의 메개변수 N은 배열의 인덱스 번호를 가리키기 때문이다.
		// 본 함수에서 흐름을 따라가보면, 결국은 첫 계산의 시작점은 [0][0]부터 시작하게 된다.
		// 재귀적 구조에 따라서 첫 입력된 값 N부터 시작하는게 아니라 N-1, N-2, N-3... 이어지다가 결국 최솟값 여기서는 0으로 수렴하기 때문.
		// 그래서 본 메서드에서는 0부터 값을 누적하고 그 누적된 값을 아래의 코드의 흐름에 따라 다시 빠져나오다 보면
		// 우리가 원하는 최소 값을 누적하는 것이 가능하다. 여기서 구체적으로 "최소값"을 구분해주는 역할을 하는건 Math.min() 메서드이다.
		
		if(DP[N][color]==0) {
			
			if(color==0) {
				DP[N][0] = Math.min(Paint_Cost(N - 1, 1), Paint_Cost(N - 1, 2)) + cost[N][0]; // line1
				
			}else if (color==1) {
				DP[N][1] = Math.min(Paint_Cost(N - 1, 0), Paint_Cost(N - 1, 2)) + cost[N][1]; // line2
				
			}else {
				DP[N][2] = Math.min(Paint_Cost(N - 1, 0), Paint_Cost(N - 1, 1)) + cost[N][2]; // line3
				
			}			
			
		}
		
		// 1회 계산된 값은 아래처럼 값으로 반환이 되는데, 이 반환된 값은 윗 단계에서 line1~line3 들어가 계산이 수행되게 됨.		
		return DP[N][color];
		
	}

}
