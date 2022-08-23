import java.util.Scanner;

public class sea_d2_1946 {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);

		int TestCase = sc.nextInt(); // 전체의 TestCase 수를 받을 변수
		sc.nextLine();
		StringBuilder sb = new StringBuilder(); // 결과값을 저장하기 위한 문자열 생성.
		
		
		for(int i = 0 ; i<TestCase; i++) {// 외부 반복문 시작.
			int AlphabetCase = sc.nextInt(); // 각 테스트 케이스마다 문서를 구성하는 알파벳의 종류 수를 담음.			
			sc.nextLine();

			String [][] AlphabetRes = new String [AlphabetCase][2]; // 각 알파벳마다 반복수를 저장하기 위해 2차배열 생성.
			
			int stack = 0;
			sb.append("#").append(i+1).append("\n"); // 각 테스트케이스마다 일련변호를 먼저 입력.
			
			for(int j = 0 ; j<AlphabetCase; j ++) {
				AlphabetRes[j]= sc.nextLine().split(" "); // split을 통해 인덱스 0번에는 알파벳의 종류, 1번에는 반복횟수 저장.			
				for(int k = 0 ; k<Integer.parseInt(AlphabetRes[j][1]); k++) { 
					// 배열의 1번째에 저장된 반복횟수만큼 반복하나, String 자료형으로 저장되므로 변환하여 정수형으로 사용함.
					if(stack>9) { // 0부터 시작하므로 9를 넘어가는 순간 줄바꿈이 필요하므로 이렇게 조건문 설정.
						sb.append("\n");
						stack=0; // 처음부터 10개를 셀 수 있또록 변수 stack을 초기화 시켜줌.
					}
					sb.append(AlphabetRes[j][0]); // 2차배열의 1번 인덱스의 반복횟수만큼 문자를 추가해줌.
					stack++; // 저장되는 문자열의 문자수 계산.
				}
			}
			sb.append("\n"); // 본 문제에서는 테스트 케이스간 엔터로 구분지어져야 하므로 개행문자 추가.
						
			
		}
		System.out.println(sb); // 결과 출력.
		
	}

}
