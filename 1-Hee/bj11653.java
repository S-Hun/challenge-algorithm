package bakjoon2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class bj11653_al_step8_3 {
	
	public static int[] Factorization(int n) {
		
		ArrayList Members = new ArrayList<>();
		
		int[] Return = new int[1];
		
		switch(n) {
		case 1:
			Return[0]=1;
			return Return;
		case 2:
			Return[0]=2;
			return Return;
		case 3:
			Return[0]=3;
			return Return; // 3������ ���ڴ� ������ �Ҽ��̹Ƿ� ���μ����ظ� �ص� �ڱ��ڽŸ� �����Ƿ� �ڱ� �ڽ��� ��������
		default:
			int s; //���μ��� ���� ���� ���� s�� �����ϰ� for���� �����Ŀ� ����
			for(s = 2 ; s*s<=n; s++) { // ���μ����ش� ��� �Ҽ�ã�⸦ ��¦ �����ϸ� �ذ��ϱ� ���� ����
				if(n%s==0) { // �������� ���ڴ� ���μ��̹Ƿ� ArrayList�� ���� �߰��Ͽ� ���μ��� ������. 
					Members.add(s);
					n/=s; // �Է°��� s�γ����� �۾��� if���� �������� ���� �� ���� ������׽� ü�� ������ ������.
					s--; // �� ���� ���� �� ������׽� ü�� ����Ǵ��� �˼� �ִµ�, 
						 // ������ ���� �����Ͽ� 4�� �Ǵ��� �̹� 2���� ��� 2�� ������ ��������ȱ� ������
						 // 2�� ����� ���μ��� ������ ����. ���� for���� ���� �����Ҷ�, �Ҽ����� ������ ��� ���μ��� �� �� ����.
				}				
			}
			if(n!=1) { 
				if(n%s==0) Members.add(s);
				else Members.add(n);
			}
			
			int[] answer = new int[Members.size()];
			
			for(int i = 0 ; i < Members.size() ; i++) {
				answer[i] = (int) Members.get(i);
			}
			return answer;
			//
		
		}
		
		
	}
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		
		int[] get = Factorization(n); // ��ĳ�ʸ� ���� ���� �Է¹ް� ���� ������ �޼��� Factorization�� ���ؼ� ���μ��� ����.
		if(get[0]!=1) { // �������� 1�� �ԷµǸ� �ƹ��͵� �Է����� ���� ���Ƕ����� ���� if���� ����
			// �Լ� Factorization()���� �Ű������� 1�� �Է��ϸ� �迭 ũ�Ⱑ 1�̰� �迭 ��Ұ� 1�� �迭�� �����ϹǷ� ���͸� ����
			for(int i= 0 ; i < get.length; i++) System.out.println(get[i]);
		}
		
		

	}

}
