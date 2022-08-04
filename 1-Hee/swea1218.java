package com.boj.problem.j0804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1218_SW문제해결기본_4일차_괄호짝짓기 {

	static int [] symbols = new int [4];

	public static void main(String[] args) throws IOException, FileNotFoundException {
		
		System.setIn(new FileInputStream("data/sw1218.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		for(int t = 1 ; t <= 10 ; t++) {
			int N = Integer.parseInt(br.readLine());
			String X = br.readLine();
			
			/**
			 ! 문제풀이 아이디어 : 괄호의 종류는 8가지이고 여는 괄호 ex) '('가 있으면,
			 반드시 어디엔가 ')'가 있어야 한다는 아이디어에서 출발했습니다.
			 이 문제에서는 세부적으로 8개 크게 4종류의 문자열에 대한 판독을 해보자고 생각했고, (like 천공카드)
			 여는 괄호가 오면 +1 닫는 괄호가 오면 -1 을 해줘서 만약에 페어가 맞으면 최종 연산 값은 0이 되게 해보자고 생각했습니다.
			 만약 닫는 괄호가 더 많으면 음의 값을 , 여는 괄호가 많으면 양의 값을 가질 것이라고 생각했고,
			 이 원리를 각 테스트 케이스별로 탐색을 해서 총 4칸의 배열에서 0이 아닌 값이 1개라도 존재하면 유효하지 않음으로
			 판단한다는 전략을 세워보았습니다.
			 **/
			
			
			// 초기 세팅은 모든 배열에서 0으로 초기화 해주었습니다.
			symbols[0] = 0;
			symbols[1] = 0;
			symbols[2] = 0;
			symbols[3] = 0;
			
			for(int i = 0 ; i < N; i ++) {
				
				// 입력된 문자열을 char 단위로 돌면서 조건문의 indexOf에서 -1이 아닌 값이 나오면
				// 그 값은  0~3의 index를 반환하므로 이것을 symbol[] 배열과 맵핑했습니다.
				if("({<[".indexOf(String.valueOf(X.charAt(i))) > 0) {
					symbols["({<[".indexOf(String.valueOf(X.charAt(i)))]++;
				}
				
				if(")}>]".indexOf(String.valueOf(X.charAt(i))) > 0) {
					symbols[")}>]".indexOf(String.valueOf(X.charAt(i)))]--;					
				}								
			}
			
			int ans = -1; // 일단 정답에 사용할 상태값 0, 1을 포현할 정수 ans를 선언과 초기화를 하고,
			// 아래의 조건문을 탐색해서 최종적으로 0 또는 1 이도록 했는데,
			// 지금의 조건에서는 조건문에서 OR 연산자(||)에 대한 단축평가가 여기에 적용되면
			// 조금이나마 효율성을 제고해주지 않을까 해서 아래와 같이 조건문을 설정했습니다.
			if(symbols[0] != 0 || symbols[1] != 0 || symbols[2] != 0 || symbols[3] != 0) {
				ans = 0;
			}else ans = 1;
			System.out.println("#"+t+" "+ans);// 각 케이스별 결과를 출력.
				
		}
		
		br.close();
			
			
			
			
//			System.out.println("#"+t+" "+st.size());
	}

}


