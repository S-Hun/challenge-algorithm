import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sea_d1_2058 {

	public static void main(String[] args) throws IOException {
		
		// 주어진 숫자가 입력되면 그 숫자들의 자릿수의 합을 구하는 문제.
		
		// 속도향상을 위해 BufferedReader로 읽음.		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		int length = input.length(); // 반복문을 위한 최댓값 저장.
		int sum = 0; // 자릿수의 합을 더할 변수 선언.
		for(int i = 0 ; i <length ; i ++) { 
			// String 에서 char을 추출하여 int로 형 변환해 값을 저장. 
			sum += Character.getNumericValue(input.charAt(i));
		}
		System.out.println(sum); // 최종 저장 값을 출력.
		

		



	}

}
