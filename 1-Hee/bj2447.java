package bakjoon2;

import java.util.Arrays;
import java.util.Scanner;

public class bj2447_al_step9_4 {
	
	// 별찍기 문제,
	// 문제에서 주어지는 값은 3의 1제곱부터 3의 8제곱까지만 주어진다.
	// 별을 직는 규칙은 
	// 1제곱일 경우 3x3의 도형이 1번 만들어진다.
	// 2제곱일 경우 3x3의 도형이 1번 만들어진 것이 3번 만들어진다.
	// 3제곱일 경우(27) 3x3의 도형이 1번 만들어진 것의 3번만들어진 것을 3번 만들어진다.
	// 즉 도형의 길이가 주어진 숫자만큼 길어진다. 즉 3의 배수만큼 증가하는 패턴을 보인다.
	// 따라서, 3x3인 단위 배열을 먼저 만들고 그 배열을 입력된 숫자의 크기만큼 반복하는 것을 통해 문제를 해결해야 한다.
	
	
	// 최종적으로 출력한 문자들을 담아둘 배열을 선언한다.
	public static char[][] starContainer;

	
	// 문제에서 주어진 규칙을 갖는 배열을 만드는 함수
	public static void MakeStarArray(int n, int x, int y) {
		if(n==1) {
			// 주어진 수는 3의 배수이기 때문에 이 조건절 바로 아래의 코드에서 3으로 나누어주면 결국에는 1으로 수렴함.
			// 이 원리를 이용해서 점을 찍게됨.
			// 3x3 단위 배열의 가운데게 비어있을 수 있는 이유는 아래의 코드에서 재귀로 자기자신을 다시 호출할 때 반복문에서 가운데를 제거했기 때문임.
			starContainer[x][y] = '*';
			return;
		}
		int value = n/3;
		
		for(int i = 0 ; i < 3; i++) {
			for(int j = 0  ; j< 3 ; j++) {
				if(i==1 && j==1) {
					continue; // 가운데는 비워두게 하는 부분.
				} else {
					MakeStarArray(value, x+(value*i), y+(value*j)); // 3의 배수가 값으로 주어질 것이기 때문에 1에 수렵할때까지 반복하여 호출하게 됨.
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		starContainer = new char[n][n];
		
		for(int i = 0 ; i < n; i++) { // 배열을 먼저 아무것도 찍히지 않은 빈 상태로 생성함.
			Arrays.fill(starContainer[i], ' ');
		}
		
		MakeStarArray(n, 0, 0); // 주어진 숫자 n부터 시작하며, x=0, y=0에서부터 시작함.
		for(int i = 0 ; i < n ; i ++) {
			System.out.println(starContainer[i]); // MakeStarArray() 메서드를 통해 저장된 값을 출력.
		}
		

	}

}
