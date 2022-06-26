package solvedRanking;

import java.util.Scanner;

public class bz1_2816 {

	public static void main(String[] args) {
		
		// �������� �Է� ���� ���ͷ� ���еǾ� �����Ƿ� ��ĳ�ʷ� ���� �޾ƺ�.	
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		sc.nextLine();
		
		String[] Channel = new String[size];
		
		for(int i = 0 ; i < Channel.length; i++) {
			Channel[i] = sc.nextLine();
		}
		
		// �������� �����ϴ� ������ ���� ����� �� 4�����ε�, 
		// ���� �������̰� ȿ���� ������ ����� �����ϱ�� ��.
		// why? �� ���̰� 500�� �̳��� �ȴٴ� ���Ƕ����ε�,
		// �ѱ��� 100��¥�� �迭���� KBS1�� 100��°�� �ִٰ� �ص�, 1��°���� 100��°�� ������ 99�ܰ�, ����Ų �� �ű�µ����� 99�ܰ谡 �ҿ��.
		// �� 198�ܰ��̰�, KBS2�� �ִ��� 98�ܰ� + 98�ܰ� (why? KBS1�� ���� ������ ���̱� ������) 196�ܰ谡 �ҿ��.
		// ���� �ִ� ���̴� ������ 500�� �̳��� �ǹǷ� �� ����� �����ϱ�� ��. ����, ���������� ������ ��� & ȿ���� ������ ��� �Ѵ� �������� �����ϴ� �׽�Ʈ���̽��� ������.
		
		// �� �������� 4���� ������, ������ ����� C1, C2 2������ ����ϱ�� ����.
		
		String C1 = "1";
//		String C2 = "2";
//		String C3 = "3";
		String C4 = "4";
		String result = "";
		
		
		// idx1�� KBS1�� ã�µ��� ����� �ε��� ����
		// idx2�� KBS2�� ã�µ��� ����� �ε��� ����
		int idx1 = 0;
		int idx2 = 0;
		
				
		while(true) {
			if(Channel[idx1].equals("KBS1")) {
				break;
			} else {
				result += C1;
				idx1++;
			}			
		}
		
		// ���� �ݺ����� ���� KBS1�� ��ǥ�� Ž��������, �� ��ǥ�� �ִ� KBS1�� �迭 0��° �ڸ��� �ű�� �۾��� ��.
		for(int i = idx1 ; i>0; i --) {			
			result+=C4;
			String temp = Channel[i]; 
			Channel[i] = Channel[i-1];
			Channel[i-1] = temp;
		}
		
		
		
		while(true) {
			if(Channel[idx2].equals("KBS2")) {
				break;
			} else {
				result += C1;
				idx2++;
			}			
		}
		
		// ���������� ���� �ݺ����� ���� KBS2�� ��ǥ�� Ž��������, �� ��ǥ�� �ִ� KBS2�� �迭 1��° �ڸ��� �ű�� �۾��� ��.
		for(int i = idx2 ; i>1; i--) {
			result+=C4;
			String temp = Channel[i]; 
			Channel[i] = Channel[i-1];
			Channel[i-1] = temp;
		}
		
		
		System.out.println(result); // ��� ����.


	}

}
