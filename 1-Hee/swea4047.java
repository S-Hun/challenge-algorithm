package practiceIMSWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_4047_영준이의카드게임 {
	
	// 24 : 47
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T ; t++) {
			sb.append("#"+t+" ");
			String X = br.readLine();
			
			/*
			 * 입력값을 기준으로 포커카드의 종류별로 갯수만큼 배열만 만듦.
			 */
			
			int[] Spade = new int[14]; // 카드가 13장인데 인덱스도 1부터쓰려고 +1 해서 배열 크기를 14로 설정.
			int[] Diamond = new int[14];
			int[] Heart = new int[14];
			int[] Clover = new int[14];
			
			
			char order = '\u0000'; 
			
			for(int i = 0 ; i < X.length()-1; i ++) {
				// 카드 종류를 받고, 다음 문자열을 읽음.
				if(X.charAt(i)=='S' || X.charAt(i) == 'D' 
						|| X.charAt(i) == 'H' || X.charAt(i)=='C') {
					order = X.charAt(i);
					continue;
				}else {
					String rawNum = ""; // 카드번호는 2자리 고정이므로 2자리만큼 읽어서 문자열에 넣고 
					rawNum += X.charAt(i);
					rawNum += X.charAt(i+1);
					int number = Integer.parseInt(rawNum); // 정수형으로 형변환 한 뒤,
					
					// 카드의 종류에 따라
					switch(order){
						case 'S':
							Spade[number]++; // 해당 카드번호를 증가.
							break;
						case 'D':
							Diamond[number]++;
							break;
						case 'H':
							Heart[number]++;
							break;
						case 'C':
							Clover[number]++;
							break;
					}					
					i++; // 카드 2개를 셌으므로 카운트 계수를 하나 올려주고,
					continue; // 다음 반복문을 진행시킴.
				}
			}
			
			
			int spade = jugeExtraCards(Spade); // 추가로 필요한 카드 값을 정수형으로 리턴해주는 함수
			int diamond = jugeExtraCards(Diamond); // 혹시 같은 카드가 2장 이상이 발견되면 -1 값을 리턴함.
			int heart = jugeExtraCards(Heart);
			int clover = jugeExtraCards(Clover);
			
			if(spade < 0 || diamond < 0 || heart < 0 || clover < 0 ) {
				sb.append("ERROR").append("\n"); // jugeExtraCards 함수에서 오류값(-1)을 감지하면 에러 출력.
			}else {
				sb.append(spade+" "+diamond+" "+heart+" "+clover+"\n"); // 아니면 각각 종류별 카드 값을 저장.
			}
						
		}
		System.out.print(sb.toString());
		
	}

	private static int jugeExtraCards(int[] symbol) {
		
		int all = 13;
		
		for(int i = 1 ; i<= 13 ; i++) { // 0번 인덱스는 사용하지 않으므로 첫번째부터 순회하면서
			if(symbol[i]>1) { // 2장 이상인게 발견되면 -1을 리턴하고 함수 종료.
				return -1;
			}
			all -= symbol[i]; 
		}
		
		return all; 
	}

}
