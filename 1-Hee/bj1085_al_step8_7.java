package test;

import java.util.Scanner;
import java.util.StringTokenizer;

public class bj1085_al_step8_7 {
	
	public static int MinimumLength(int[] arr) {
		
		int[] calcLength = new int[4];
		
		calcLength[0] = arr[0]; 		// 현재 x좌표에서 0으로 갈 때 필요한 거리
		calcLength[1] = arr[2]-arr[0]; 	// 현재 x좌표에서 직사각형의 x좌표 최댓값으로 갈때 필요한 거리
		calcLength[2] = arr[1]; 		// 현재 y좌표에서 0으로 갈때 필요한 거리
		calcLength[3] = arr[3]-arr[1];	// 현재 y좌표에서 직사각형의 y좌표 최댓값으로 갈때 필요한 거리
		
		
		int ins, cmp, temp;
		
		// 삽입정렬
		for (ins = 1 ; ins < calcLength.length ; ins++) {
			temp = calcLength[ins];
			for(cmp = ins-1 ; cmp >=0 ; cmp--) {
				if(calcLength[cmp] > temp) {
					calcLength[cmp+1] = calcLength[cmp];
				} else {
					break;
				}
			} calcLength[cmp+1] = temp;
		}
		
		// 정렬하여 최소값을 리턴시킴.
		
		return calcLength[0];
		
	}
	

	public static void main(String[] args) {
		// 한수는 지금 (x, y)에 있다. 직사각형은 각 변이 좌표축에 평행하고, 왼쪽 아래 꼭짓점은 (0, 0), 
		// 오른쪽 위 꼭짓점은 (w, h)에 있다. 직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성
		// 1 ≤ w, h ≤ 1,000
		// 1 ≤ x ≤ w-1
		// 1 ≤ y ≤ h-1
		// x, y, w, h는 정수
		
		Scanner sc = new Scanner(System.in);
		int[] PositionInfo = new int[4];
		String input = sc.nextLine();
		sc.close();
		StringTokenizer st = new StringTokenizer(input);
		
		for(int i = 0 ; i < PositionInfo.length ; i++) {
			PositionInfo[i] = Integer.valueOf(st.nextToken());
		}
		
		System.out.println(MinimumLength(PositionInfo));
		
	}
}
