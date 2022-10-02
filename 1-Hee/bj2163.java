package solvedRanking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bz1_2163 {

	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//입력값이 항상 3x3과 같은 정사각형으로만 입력되면 한번에 값을 입력받고 다루면 되지만,
		//입력받은 값이 5x3이던지 3x5이던지 같이 가로와 세로 길이가 비대칭인 경우에는 두 숫자의 대소 비교가 필요하다.
		//그래서 우선 값을 입력받은 후 몇 단계를 거쳐서 일반식에 대입할 값으로 개조해야한다.
		
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		// if문 다음에 일반식에서 값을 재사용해야 하므로 if문 안의 변수로 사용할 수 없어서 별도로 밖으로 꺼냄.
		int W = 0;
		int H = 0;
		
		if(X>Y) {// 아래의 일반식에 대입할 때, W>H라고 하는 전제 조건을 세웠기 때문에 이 if문이 필요함.
			W = X;
			H = Y;
		} else {
			W = Y;
			H = X;
		}
		// 위의 조건문을 통해 무조건 W가 큰 값, H가 작은 값으로 매칭함.
		
		// 문제에서는 최소 분할 값을 원하므로 
		// 아래의 일반식에서 항상 최소 값을 반환하려면 W이 큰 수, H이 작은 수일 때 총 횟수인 result가 최소임.
		// 반대로 하면 최대가 되버림. 		
		int result = W-1 + (W * (H-1));
		
		// 초콜릿을 나눌때 처음에는 다 붙어있는 상태이므로 변의 길이가 긴 부분부터 반으로 쪼개야함.
		// 이렇게 하지 않고 변의 길이가 짧은 부분부터 쪼개게 되면, 작은 부분으로 반으로 쪼갠 후 그다음에 그 조각마다 쪼갤 금의 개수가 많아짐.
		// 그래서 위의 일반식에서 값을 최소로 줄이려면 W를 금이 가장 많은 변의 금의 갯수, 즉 길이가 긴 쪽부터 쪼개는 작업을 시작해야한다.
		// 위의 일반식에 3x4인 사각형일때, 3을 W 로한 경우와 4을 W로 한 경우 각각 값을 대입 해보고 결과값을 비교하면 바로 증명 가능.
		
		System.out.println(result);
		
		

	}

}
