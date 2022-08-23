package com.ssafy.problem.j0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기2 {

	static int T, N;
	static HashSet<Character> hset;
	
	// 조합을 통해서 푸는 문제였는데 경우의수가 최대 15 여서, 시간의 효율을 생각해야할 수도 있을 것 같았다.
	// 그래서 nextPermutation을 이용해서 시간 효율을 챙겨야겠다고 생각했고,
	// 문제에서 조건이 그냥 백트래킹을 요구해서 백트래킹을 이용하면 시간 복잡도가 더 줄어들 것이라고 예상되었다.
	
	/*
	 *  N개의 문자 중에서 C개의 를 고른다면, 숫자의 범위는 3 <= C <= N <= 15 였다.
	 *  
	 *  코드에서 구현해야할 포인트 2가지
	 *  1) 주어진 문자열을 통해 조합을 생성
	 *  2) 생성된 부분집합 중에서 모음의 개수 >= 1 && 자음의 개수 >= 2 인 경우만 채택.
	 *  따라서, 2) 번 조항으로 백트래킹을 구현해야함.
	 */
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		hset = new HashSet<>(); // 모음인지 검사하는데 쓸 HashSet 사용.
		
		// 모음 추가.
		hset.add('a');
		hset.add('e');
		hset.add('i');
		hset.add('o');
		hset.add('u');
		
		T = Integer.parseInt(st.nextToken()); // 암호의 길이.
		N = Integer.parseInt(st.nextToken()); // 전체 문자열의 수
		
		String X = br.readLine().replaceAll(" ", ""); // 입력에서 공백을 없애버림.
		char[] keys = X.toCharArray(); // 그리고 문자열로 변환.
		Arrays.sort(keys); // 오름차순으로 출력해야 하므로 오름차순 정렬.
		
		int[] indexs = new int[N];
		
		for(int i = 0 ; i < N-T ; i ++) { // N-T개의 스위치만 켜서 0을 기준으로 값을 출력하면, 오름차순으로 출력이 가능함.
			indexs[i] =1;
		}
		
		Arrays.sort(indexs); // key와 순서를 맞추기 위해 오름차순으로 정렬.
		
		char [] filtered = new char[T];
				
		do {			
			int start = 0;
			for(int i = 0 ; i < N ; i++) {
				if(indexs[i]==0) {
					filtered[start++] = keys[i];
				}
			}
			if(isVaild(filtered)) sb.append(filtered).append("\n");			
			
		} while (nextPermutation(indexs));
				
		System.out.println(sb.toString());// 결과 출력.	
		
	}
	
	// 넥스트 순열.
	private static boolean nextPermutation(int[] numbers) {
		int N = numbers.length;
		int i = N - 1;
		
		while(i > 0 && numbers[i-1] >= numbers[i]) --i;
		
		if(i==0) return false;
		
		int j = N - 1;
		
		while(numbers[i-1] >= numbers[j]) --j;
		
		swap(numbers, i-1, j);
		
		int k = N - 1;
		
		while( i < k ) swap(numbers, i++, k--);
		
		return true;
		
	}
	

	
	private static void swap(int[] numbers, int i, int j) {
		
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
		
	}

	// 모음이 1개 자음이 2개 이상인 것들인지 판단하는 백트래킹용 함수.
	private static boolean isVaild(char[] holder) {
		
		int m = 0, c = 0;
		
		for(char c1 : holder) {
			if(hset.contains(c1)) m++;
			else c++;
		}
		
		if( m>=1 && c >= 2 ) return true; 		
		return false;
	}	
}
