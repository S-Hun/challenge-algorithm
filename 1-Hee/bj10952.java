package test;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bakjoon10952_al_step3_12 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		
		String input = "";

		int a, b;
		
		ArrayList arr = new ArrayList<>();

		// �������� �Է��� ��º��� �����Ƿ�, do while������ �Է��� ���� �� ����� ���� ������
		do {
			input = sc.nextLine();		
			StringTokenizer st = new StringTokenizer(input);
			a = Integer.valueOf(st.nextToken());
			b = Integer.valueOf(st.nextToken());
			int answer = a+b;
			if(a!=0 && b!=0) {
				// �ٷ� ������� �ʰ� ArrayList�� ���� �־��
				arr.add(answer);
			}
			
		}				
		while(a!=0 && b!=0);
		
		for(int i = 0 ; i <arr.size() ;i++) {
			// while���� ������ �����鼭 �׵��� ArrayList�� ����� ������ �����.
			System.out.println(arr.get(i));
		}
		
		

		


	}
}
