package test;

import java.util.*;

public class bakjoon10951_al_step3_13 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList Arr = new ArrayList<>();
		
			
		while(sc.hasNext()) { // �������� �Է��� ���� ������� �ʾ����Ƿ� EOF ������� ���� ��� �Է� �޾ƾ� ��.
			String input = sc.nextLine();
			StringTokenizer st = new StringTokenizer(input);
			int st1 = Integer.valueOf(st.nextToken());
			int st2 = Integer.valueOf(st.nextToken());
			if((st1!=0 && st1<10)&&(st2!=0 && st2<10)) {
				Arr.add(st1+st2); // ���� �Է¹޾� ���� ����� ����ؼ� �迭�� �Է�
			}
		}
		
		for(int i = 0 ; i < Arr.size() ; i++) {
			System.out.println(Arr.get(i));
		}
		

		
		
		

	}

}
