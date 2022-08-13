import java.io.*;
import java.util.*;

public class hw_0801_bj_1224 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader 생성
		int N = Integer.parseInt(br.readLine()); // 배열의 크기 입력

		String rawString = br.readLine(); // 배열 요소들 입력 = String 으로!
		StringTokenizer st = new StringTokenizer(rawString, " "); // 공백도 같이 문자열에 포함되므로 공백을 기준으로 문자열을 토큰화
		
		int[] Switches = new int[N]; // 스위치 on/off를 담는 배열 생성.
		
		for (int i = 0 ; i < N ; i ++) {
			Switches[i] = Integer.parseInt(st.nextToken()); // 반복문을 순회하며 토큰에 담긴 배열 요소들 입력.
		}

		int Student = Integer.parseInt(br.readLine()); // 스위치 on/off 작업의 횟수 즉, 학생들의 수를 입력받음.
		
		for (int j = 0 ; j < Student; j ++) {
			
			String people = br.readLine(); // 1 3 이런식으로 입력을 받아서
			st = new StringTokenizer(people, " "); // 공백을 기준으로 토큰화하고,
			
			int sex = Integer.parseInt(st.nextToken()); // 첫번째는 성별 정보 (로직의 분기점의 기준)
			int nums = Integer.parseInt(st.nextToken());  // 두번째는 카드의 위치 (로직의 시작점의 기준)
											
			if ( sex == 1 ) { // 남학생(= 1) 이라면?
								
				for (int k = nums-1; k < N ; k+=nums) { // 받은 카드 넘버의 배수를 반전.
					if(Switches[k] == 0) {
						Switches[k] = 1;
					}else {
						Switches[k] = 0;
					}
				}
								
				
			} else if (sex == 2){ // 여학생이라면?
						
				if(Switches[nums-1]==0) { // 카드를 받은 위치는 무조건 반전시키고,
					Switches[nums-1] = 1;
				}else {
					Switches[nums-1] = 0;
				}
				
				// 좌우로 방사형으로 대칭인지를 펠린드롬 문자 찾듯이 퍼져나가야 함.
				int left_idx = nums-2; // 왼쪽 인덱스
				int right_idx = nums; // 오른쪽 인덱스
				
				while(true) {
					if(left_idx >=0 && right_idx < N) { // 먼저 left, right 인덱스를 선언했어도, 이게 배열 index를 벗어나는지 확인함.
						if(Switches[left_idx]==Switches[right_idx]) { // 배열의 실제 값이 서로 동일한지 = 대칭인지 점검함.
							if(Switches[left_idx] == 0){ // 위 조건을 충족하면, 둘중 하나만 확인해도 결과는 같이 바뀌므로 하나만 검사하여 값을 반전.
								Switches[left_idx] = 1;
								Switches[right_idx] = 1;
							}else {
								Switches[left_idx] = 0;
								Switches[right_idx] = 0;
							}
						}else {
							break;
						}
						
					}else {
						break;
					}
					left_idx-=1; 
					right_idx+=1;
				}
				
												
			}			
			
		}
		
		StringBuilder sb = new StringBuilder(); // 메모리 절약?? 용으로 StringBuilder 사용.
		
		for (int m = 0 ; m <Switches.length; m++) { // 반복문 순회하면서
			if(m%20!=0 || m==0) { // 20줄 넘어가면 끊어줘야하고, 끊은 후의 동작이 첫 번째에서는 해당 없도록 조건을 설정.
				sb.append(Switches[m]).append(" ");
			} else {
				sb.append("\n").append(Switches[m]).append(" "); // 20줄 넘으면 개행문자 추가해야함.
			}
			
		}
		
		System.out.println(sb.toString()); // 최종 결과값을 출력!
	
	}

}
