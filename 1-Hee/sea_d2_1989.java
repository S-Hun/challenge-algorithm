import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sea_d2_1989 {

	public static void main(String[] args) throws IOException {
		
		// 주어진 문자열이 좌우 대칭인지 확인하는 알고리즘을 요구하는 문제.	
				
		// 속도향상을 위해 BufferedReader 사용.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		// 먼저 전체 테스트 케이스의 크기를 받음.
		int N = Integer.parseInt(br.readLine());		
		// 반복문을 돌릴때마다 아래의 문자열 변수 Text에는 새로운 값을 넣을 예정.(재활용)
		String Text = "";
		StringBuilder sb = new StringBuilder(); // 결과값을 바로 문자열로 바꾸기 위해 StringBuilder 변수 생성.
				
		for(int i = 0 ; i < N ; i++) { // 입력된 테스트 케이스 크기만큼 반복문 실행.
			Text = br.readLine();			// 각 테스트 케이스를 담음.
			int TextLength = Text.length(); // 내부 반복문의 반복 횟수를 정하기 위해 문자열의 길이를 계산.
			boolean check = false; // 각 테스트 케이스 마다 회문이 되는지를 판별할 불리언 변수.

			
			// 본 문제에서 주어지는 문자열은 홀수 or 짝수임
			// 홀수의 경우에는 중위수를 기준으로 좌우 문자열이 대칭인지 판별
			// 짝수의 경우는 중위수 기준이 아니라 반으로 나누어 문자열이 대칭인지 판별해야함.
			
			if(TextLength%2!=0) {
				int middle = TextLength/2;	// 반복문에서 중위수이자 반복문의 반복횟수를 결정해줄 정수형 변수.		
				for(int j = 0 ; j<middle; j ++) { 
					if(Text.charAt(j)!=Text.charAt(TextLength-1-j)) { 
						// 위의 조건문 속 일반식으로 비교하면 첫번째 - 마지막 이런식으로 중위수까지 값을 매칭하여 비교 가능.
						check = false;
						break; // 대칭이 아닌 경우를 조기에 발견하면 빨리 반복문을 종료하여 효율을 향상시킬 수 있도록 break 추가.
					}else check = true;				
				}
											
			}else {
				int middle = TextLength/2-1; // 이 경우에는 중위수는 아니고, 단어를 반으로 나눌때 첫번째 파편(?)의 최대 인덱스 값을 저장함.								
				for(int j = 0 ; j<=middle; j ++) { // 홀수와는 다르게 위에서 구해진 middle값을 "포함" 하여 증가시켜야함. (홀수는 <를 사용하므로 포함X)
										
					if(Text.charAt(j)!=Text.charAt(TextLength-1-j)) {
						check = false;
						break;
					}else check = true;				
				}

				
			}

			
			if(check) {// StringBuilder에 문제에서 제시한 문자열 형식대로 값을 저장.
				sb.append("#").append(i+1).append(" ").append(1).append("\n");
			}else sb.append("#").append(i+1).append(" ").append(0).append("\n");

		}
		
		
		System.out.println(sb); // 최종 결과 출력.
		

	}

}
