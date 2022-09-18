package algoDay01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_5658_모의SW역량테스트_보물상자_비밀번호 {

	public static void main(String[] args) throws IOException {
				
		/* 풀이 전략
		 * 
		 * 링크드 리스트롤 통해서 자물쇠가 돌아가는 로직을 구현함.
		 * 자물쇠의 모양은 마름모이므로 한면의 비밀번호의 길이는 전체 비밀번호 길이 N을 4로 나누는 값이 됨.
		 * 
		 * 자물쇠를 회전시켰을 때 비밀번호가 하나라도 다른 경우의 수는
		 * 초기 비밀번호의 각 면의 비밀번호들이 이웃한 면으로 이동할 때 까지임.
		 * 
		 * 예컨데 자물쇠 총 비밀번호 길이가 12라면 N/4
		 * 이 크기가 곧 자물쇠가 회전할 수 있는 회전 수 "cycle"이라고 정의했고 변수를 만들어 관리 및 회전 시킴
		 *  
		 * 회전하며 나오는 모든 비밀번호 경우의 수를 각 면 단위로 배열에 저장
		 * 
		 * 문자열인 비밀번호를 그냥 정렬만 해도 16진수 오름차순 내림차순으로 정렬이 됨
		 * 그래서 Integer.parseInt() 메서드를 이용해 값 변환해주는 거랑
		 * k를 셈하는 것에 주의하여 로직 작성.
		 */
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1 ; t <= T ; t++) {
			sb.append("#"+t+" ");
			st = new StringTokenizer(br.readLine());
			
			int size = Integer.parseInt(st.nextToken());
			int cycle = size/4;
			int k = Integer.parseInt(st.nextToken());
			
			// 총 비밀번호를 담아줄 링크드 리스트
			LinkedList<Character> passWord = new LinkedList<>();
			String rawPass = br.readLine(); // 입력값을 받은 뒤
			
			for(int i = 0 ; i < rawPass.length(); i ++) {
				passWord.add(rawPass.charAt(i)); // char 단위로 배열에 저장
			}
						
			ArrayList<String> allpass = new ArrayList<>(); // 모든 경우에서 각면 비밀번호들의 값을 저장하기 위한 ArrayList
			for(int i = 0 ; i < cycle ; i ++) {
				
				String[] temp = checkPass(passWord, cycle);
				concatPass(allpass, temp);				
				passWord.addLast(passWord.removeFirst());
				
			}
			
			
			Collections.sort(allpass);	// 내림차순으로 정렬		

			String temp = "";			

			int rank = 1; // 1부터 셈하고
			for(int i = allpass.size()-1; i >= 0 ; i --) {
				
				if(temp.equals(allpass.get(i))) continue; // 같으면 rank ++ 하면 안되니까 반복문을 continue;
				temp = allpass.get(i);			
				if(rank == k) break;
				rank++;
			}
			sb.append(Integer.parseInt(temp,16)).append("\n"); // 결과값 저장
						
		}
		
		System.out.print(sb.toString());
		
		
	}
		
	// 1회전 마다의 각 면의 비밀번호들을 리턴해주는 메서드
	private static String[] checkPass (LinkedList input, int cycle){
		
		String[] passArr = new String[4];
		int idx = 0;
		for(int i = 0 ; i < input.size(); i += cycle) {
			String tempPass = "";
			for(int j = 0 ; j < cycle ; j ++ ) {
				tempPass+=input.get(i+j);
			}
			passArr[idx++] = tempPass;
		}
		return passArr;
	}
	
	// 1회전마다 얻어낸 각 면의 비밀번호들을 하나의 배열로 합쳐주는 메서드
	private static void concatPass(ArrayList<String> allpass, String[] input) {
		
		for(int i = 0 ; i < input.length; i ++) {
			allpass.add(input[i]);
		}
		
	}

}
