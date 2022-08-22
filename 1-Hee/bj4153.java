package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj4153_al_step8_9 {
	
	public static boolean JudgeRightTriangle(int[] arr) {
		Arrays.sort(arr); // 직각삼각형의 세변의 길이가 순서대로 정렬되어있지 않을 수 있으므로 오름차순으로 정렬해줌.
		if((arr[0]*arr[0]+arr[1]*arr[1])==arr[2]*arr[2]) { // 피타고라스의 정리.
			return true; // if 조건이 성립하면(true이면) 직각삼각형이므로 true를 리턴.
		}
		return false; // 아니면 직각삼각형이 아니므로 false를 리턴.
	}
	
	
	public static void main(String[] args) {
				
		// 피타고라스의 정리를 통해서 직각삼각형인지 아닌지를 판별하면 되는 문제.
		
		Scanner sc = new Scanner(System.in);
		String input = ""; // Scanner를 통해 값을 담을 변수, 빈문자열로 초기화 해줌
		int[] numbers = new int[3]; // 각 테스트 케이스마다 반복문 1회 돌때마다 처리를 하려고 값을 담을 배열 생성.
		ArrayList result = new ArrayList<>(); // 결과 값이 담길 배열인데, 길이가 가변적이므로 ArrayList를 사용.
				
		while(true) {
			input = sc.nextLine();
			if(!input.equals("0 0 0")) { // 0 0 0 도 계산되는걸 방지하기 위해 if문으로 필터링함.
				StringTokenizer st = new StringTokenizer(input);			
				for(int i = 0 ; i < 3 ; i++) {
					numbers[i] = Integer.valueOf(st.nextToken());
				}
				
				if(JudgeRightTriangle(numbers)==true) { // 사용자 정의 함수를 통해 직각삼각형이면 true를 반환받음.
					result.add("right"); 
				} else {
					result.add("wrong");		// 결과에 따라서 right or wrong을 배열에 저장해줌.		
				}
				
			}else {
				break;		// 0 0 0 이 입력되었을때 반복문을 종료시켜줌.
			}
		}
		
		for(int i = 0 ; i < result.size() ; i++) {
			System.out.println(result.get(i)); // 결과값을 출력.
		}
	}
}
