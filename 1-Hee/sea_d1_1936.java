import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sea_d1_1946 {

	public static void main(String[] args) throws IOException {
		
		// 가위바위보 함수구현
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Comb = Integer.parseInt(st.nextToken()+st.nextToken()); 
		// BufferedReader로 읽은 입력 값을 공백빼고 붙여서 하나의 문자열로 만듦.
		StringBuilder sb = new StringBuilder();

		
		// 가위바위보는 비기는 경우를 제외하면 경우의 수가 총 6가지이므로, 
		// 6가지 경우의 수에 대한 조건문으로 해결하기로 함.
		// 윗 줄에서 Comb에 담은 입력 값은 곧 가위바위보의 경우의수, 
		// 그 경우의 수의 고유한 숫자가 될 수 있으므로 이 값을 고유값 및 경우의 수를 판단하는 지수로 삼음.
		switch(Comb) {
		case 12: // 여기의 경우 가위가 1 바위가 2이므로 가위 vs 바위 인 상황이고,
			sb.append("B"); // 바위가 이기므로 B가 승리.
			break;
		case 13:
			sb.append("A");
			break;
		case 21:
			sb.append("A");
			break;
		case 23:
			sb.append("B");
			break;
		case 31:
			sb.append("B");
			break;
		case 32:
			sb.append("A");
			break;
		}
		
		System.out.println(sb); // 결과 출력.
		
	}

}
