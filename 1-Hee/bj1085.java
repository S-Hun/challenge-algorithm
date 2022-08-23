package test;

import java.util.Scanner;
import java.util.StringTokenizer;

public class bj1085_al_step8_7 {
	
	public static int MinimumLength(int[] arr) {
		
		int[] calcLength = new int[4];
		
		calcLength[0] = arr[0]; 		// ���� x��ǥ���� 0���� �� �� �ʿ��� �Ÿ�
		calcLength[1] = arr[2]-arr[0]; 	// ���� x��ǥ���� ���簢���� x��ǥ �ִ����� ���� �ʿ��� �Ÿ�
		calcLength[2] = arr[1]; 		// ���� y��ǥ���� 0���� ���� �ʿ��� �Ÿ�
		calcLength[3] = arr[3]-arr[1];	// ���� y��ǥ���� ���簢���� y��ǥ �ִ����� ���� �ʿ��� �Ÿ�
		
		
		int ins, cmp, temp;
		
		// ��������
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
		
		// �����Ͽ� �ּҰ��� ���Ͻ�Ŵ.
		
		return calcLength[0];
		
	}
	

	public static void main(String[] args) {
		// �Ѽ��� ���� (x, y)�� �ִ�. ���簢���� �� ���� ��ǥ�࿡ �����ϰ�, ���� �Ʒ� �������� (0, 0), 
		// ������ �� �������� (w, h)�� �ִ�. ���簢���� ��輱���� ���� �Ÿ��� �ּڰ��� ���ϴ� ���α׷��� �ۼ�
		// 1 �� w, h �� 1,000
		// 1 �� x �� w-1
		// 1 �� y �� h-1
		// x, y, w, h�� ����
		
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
