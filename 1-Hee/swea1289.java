package com.ssafy.problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA_1289_원재의메모리복구하기 {

	public static void main(String[] args) throws FileNotFoundException {
				
		System.setIn(new FileInputStream("data/sw1289.txt"));
		Scanner sc = new Scanner(System.in);
		
		
		int tc = sc.nextInt(); // 전체 테스트 케이스 입력.
		
		for(int i = 0 ; i < tc; i++) { 
			
			String origin_data = sc.next(); 
			int [] bits = new int[origin_data.length()]; // 전체 문자열의 배열을 맨듦.

			for(int j = 0 ; j < bits.length; j ++) {
				bits[j] = Integer.parseInt(String.valueOf(origin_data.charAt(j))); // 배열을 생성하고
			}
			
			int cnt = 0;
			int temp = 0;
			
			// 첫 기준 값은 배열을 모두 0으로 초기화한다고 했으므로, 0이 첫 기준값이다.
			// 비트 복구 과정은 제일 왼쪽부터, 0인지 1인지를 기준 값과 대조하여 검사한다.
			// 이 검사에서 연속적으로 0이라면 그 지점까지는 복구할 필요가 없으므로 계속 진행한다 (카운트 증가 x)
			// 1인 지점을 만나면 카운를 증가시키고 기준 값을 1로 바꾼다.
			// 이 지점부터 뒤까지 모든 값이 1로 반전되므로 이번에는 원래 데이터 대조하여 0이어야 하는 지점을 찾고,
			// 위와 같은 과정을 반복하면 데이터가 복구 되는데,
			// 그걸 실제 배열을 바꾸진 않고, 원래 배열을 탐색하며 어느 지점에서 기준값이 switch 되는지 셈해서
			// 그걸 결과값으로 리턴하였음.
			
			for (int k = 0 ; k < bits.length; k ++) {
				if(bits[k]!=temp) {
					cnt++;
					temp = bits[k];
				}
			}
			
			System.out.printf("#%d %d\n", i+1, cnt);
			
						
		}
		sc.close();

				
		//3
		//0011
		//100
		//01100
		

	}

}
