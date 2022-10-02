package algos;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2805_농작물수확하기 {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		System.setIn(new FileInputStream("data/sw2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		int start, N, sum; 
		String X = "";
		int[][] farms;
		
		for(int t = 1 ; t <= TC ; t++) {
			sb.append("#").append(t).append(" ");
			
			N = Integer.parseInt(br.readLine());			
			farms = new int[N][N]; 					// 테스트 케이스마다 농장의 크기를 재정의함.
						
			
			for(int r = 0 ; r < N ; r++) { // 농장의 크기만큼 반복문을 돌리면서 값을 입력받는데, 공백자로 구분되지 않음.
				X = br.readLine(); // 그래서 일단 문자열로 한줄씩 읽고,
				for(int c = 0 ; c < N ; c++) { //숫자 한 '글자'당 (두자리가 숫자 입력 값이 없다는 뜻) 배열 한칸에 저장함. 
					farms[r][c] = Integer.parseInt(String.valueOf(X.charAt(c)));
				}
			}
			
			start = N/2;
			sum  = 0;
			
			// 현재 배열에서 값을 탐색하는 범위가 피라미드 꼴이 아니라 마름모 꼴임
			// 그래서 경우의 수를 두 가지로 나누어 값을 증가시키다가 감소시키는 로직이 필요.			
			
			// 일단 가장 행을 순회하는 반복문의 경우 증감이 필요가 없으므로 그냥 범위만큼 순회시킴 
			for(int r = 0 ; r < N ; r ++) { 
				// 이때 행의 index, 즉 r이 해당 배열의 중위값인 
				// farms.length/2가 될때까지 범위는 증가해야하므로 아래와 같이 피라미드식 반복문을 조건을 설정. 
				if(r <= start) {
					for(int c = start-r ; c <= start+r ; c++ ) {						
						sum += farms[r][c];						
					}
				}else {
					// 행의 index r은 시간이 지날 수록 값이 감소하므로, 처음에는 넓었다가 계단식으로 줄어드 조건이 필요함.
					int gap = (N-1) - r; // 여기서 구해지는 값으로 열의 반복문의 조건을 조절하면 역피라미드식이 가능. 					
					for(int c = start-gap ; c <= start+gap ; c++ ) {	
						sum += farms[r][c];												
					}
				}								
			}
			sb.append(sum).append("\n"); 
						
		}
				
		System.out.println(sb.toString());
//		StringTokenizer st = new StringTokenizer(sb.toString(), "\n");
//		int count = 0;
//		System.out.println("---------------------");
//		
//		for(int t = 0 ; t < TC ; t++) {
//			String answer = br.readLine();
//			if(answer.equals(st.nextToken())) count++;
////			System.out.println(answer + "|" + st.nextToken());
//		}
//		System.out.println("틀린 개수는 : " + (TC-count));

		
	}

}
