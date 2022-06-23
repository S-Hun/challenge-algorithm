package solvedRanking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bz2_1297 {

	public static void main(String[] args) throws IOException {
		
		
		// 피타고라스의 정리를 이용하여 비율로 실제 값을 구할 수 있는 문제
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력될 값은 최소 2회 이상 사용되어서 변수에 담는 것이 타당하므로 별도의 변수로 값을 담음. 
		int D = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		
		// 계산식에 대한 설명
		// 문제에서는 대각선의 "실제"길이와 가로 세로의 "비율"이 주어지므로, a2 + b2 = c2를 이용하여
		// c2에 해당하는 대각선의 실제길이의 제곱은 비율인 H와 W의 합의 몇배인지 구하는 것이 필요.
		// 몇배인지 구해진 비율은 제곱된 값이므로 이 값의 제곱근을 구해야 실제 길이를 구할 수 있음.
		// 여기서 구해진 제곱근을 x라고 할 때, 실제 가로와 세로 값은 각각 W * x / H * x로 구할 수 있음.
		
		double ratio = Math.sqrt(Math.pow(D, 2)/(Math.pow(H, 2) + Math.pow(W, 2)));
		
		StringBuilder sb = new StringBuilder();
		
		// 실제 문제에서 원하는 값은 소수점 값을 내림한 것이므로 아래와 같이 형변환을 통해 값을 내림 처리함.
		// 이 코드에서는 그냥 강제 형변환으로 내림 처리를 했지만, 엄연히 제대로 작성한다면 Math.ceil 등을 이용하는 것이 정석일 듯.
		// 결과적으로 구한 값들을 원하는 양식에 맞게 이어 붙여서 문자열을 생성함.
		sb.append((int)(H*ratio)+ " " + (int)(W*ratio));
		
				
		System.out.println(sb.toString());

	}

}
