package bakjoon2;

import java.util.Scanner;

public class bj1193_al_step7_3 {

	public static void main(String[] args) {
		
			Scanner sc = new Scanner(System.in);
		
			// ���ϰ� ���� ���� ������ x�� ���Ѵ�, ���⼭ 14�� �Է��ϸ� 14��° ��Ҹ� ���ϴ� ��.
			int x = sc.nextInt();
			int sum = 1; // �Է��� ���ڰ� ���° �밢�� �迭�� ��ġ�ϴ��� �����ϱ� ���� �ӽ÷� ���� ������.
			int line = 1; // ���� ù��° ��Ҹ� 1��° �밢��, line=1�� ������.
			
			while(x>sum) {
				line++;
				sum+=line;
				// �ݺ����� ���������� ������ �����Ͽ�, �Է��� ������ �밢�� ���� ���� ������ �� ����.
			}
			int index = line - (sum-x); 
			// �Է��� ���ڰ� �ش� �밢���� ���°�� �ش��ϴ��� �����ϱ� ���� �Ϲݽ�
			// �迭 �� ������ ��ġ�� ������׷� �����Ǿ�����, �Էµ� ���ڸ� ���ϴ� ���� �������� �ϱ� ������ �ش� �Ϲݽ��� ������ �� ����.
		
			
			int left =0;
			int right =0;
			
			// �迭�� �м��� ���ڸ� left�� �ϰ�, �и� right�� ���� ��,
			// line�� ¦���̸� �ش� �밢�� ������ ���� 1���� �����ϰ�, right�� line���� ������.
			// line�� Ȧ���̸� �ش� �밢�� ������ ���� line���� �����ϰ�, right�� 1���� ������.
			// �̸� �Ʒ��� �ڵ�� ����.
			
			
			if(line%2==0) {
				left=1;
				right=line;
				for(int i = 1 ; i<index; i++) {
					left++;
					right--;				
				}
				
			} else {
				left=line;
				right=1;
				for(int i = 1 ; i<index; i++) {
					left--;
					right++;
				}						
			}
					
			System.out.println(left+"/"+right);
			
	}

}
