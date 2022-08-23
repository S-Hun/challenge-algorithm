package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj4153_al_step8_9 {
	
	public static boolean JudgeRightTriangle(int[] arr) {
		Arrays.sort(arr); // �����ﰢ���� ������ ���̰� ������� ���ĵǾ����� ���� �� �����Ƿ� ������������ ��������.
		if((arr[0]*arr[0]+arr[1]*arr[1])==arr[2]*arr[2]) { // ��Ÿ����� ����.
			return true; // if ������ �����ϸ�(true�̸�) �����ﰢ���̹Ƿ� true�� ����.
		}
		return false; // �ƴϸ� �����ﰢ���� �ƴϹǷ� false�� ����.
	}
	
	
	public static void main(String[] args) {
				
		// ��Ÿ����� ������ ���ؼ� �����ﰢ������ �ƴ����� �Ǻ��ϸ� �Ǵ� ����.
		
		Scanner sc = new Scanner(System.in);
		String input = ""; // Scanner�� ���� ���� ���� ����, ���ڿ��� �ʱ�ȭ ����
		int[] numbers = new int[3]; // �� �׽�Ʈ ���̽����� �ݺ��� 1ȸ �������� ó���� �Ϸ��� ���� ���� �迭 ����.
		ArrayList result = new ArrayList<>(); // ��� ���� ��� �迭�ε�, ���̰� �������̹Ƿ� ArrayList�� ���.
				
		while(true) {
			input = sc.nextLine();
			if(!input.equals("0 0 0")) { // 0 0 0 �� ���Ǵ°� �����ϱ� ���� if������ ���͸���.
				StringTokenizer st = new StringTokenizer(input);			
				for(int i = 0 ; i < 3 ; i++) {
					numbers[i] = Integer.valueOf(st.nextToken());
				}
				
				if(JudgeRightTriangle(numbers)==true) { // ����� ���� �Լ��� ���� �����ﰢ���̸� true�� ��ȯ����.
					result.add("right"); 
				} else {
					result.add("wrong");		// ����� ���� right or wrong�� �迭�� ��������.		
				}
				
			}else {
				break;		// 0 0 0 �� �ԷµǾ����� �ݺ����� ���������.
			}
		}
		
		for(int i = 0 ; i < result.size() ; i++) {
			System.out.println(result.get(i)); // ������� ���.
		}
	}
}
