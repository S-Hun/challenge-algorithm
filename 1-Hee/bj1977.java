package solvedRanking;

import java.util.Scanner;

public class bz2_1977 {

	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		sc.nextLine();
		int N = sc.nextInt();
		sc.nextLine();
		sc.close();

		
		// ������ Ǯ�� ���� �����ϰ� ���������� �ڵ�� ���� ���� �� ����ǵ��� ���� ���ؼ� �ٸ� Ǯ�̸� ������ ����.
		// �������� ���ϴ� ���� ���� �������� ����.
		// �׷��Ƿ� �־��� ���� M~N������ �������� M, N�� ������ ������ ���� �����Ͽ� ���� �� ���� >> �̷��� �ϸ� ����Ž������ ã�� �ʿ� �����Ƿ� �ð� ���� ����.
		// �׷��� �� �������� �߿��� ���� ������ �ڵ�� �� �ۼ��ϴ� ���� �߿�.
		// M �̻�  N �����̹Ƿ�, M�� ���ؼ��� "�ø�" �ؾ��ϰ�, N�����ؼ��� "����" �ؾ���.
		// ������ M�� 64�� N�� 65�̸� 64�� 8�� ������ �̹Ƿ� �� ���������� 8�� ������ 64�� �����ϰ� ���� 64 �ּڰ��� 64�� ��.
		// �� ������ �ڵ�� �����ϸ� �Ʒ��� ����.
		
		
		
		int min = (int) Math.ceil(Math.sqrt(M));
		int sum = 0;
		
		for(int i =min ; i<= Math.floor(Math.sqrt(N)); i++) {
			sum+= (int) Math.pow(i, 2);
		}
		
		if(sum > 0 ) {
			System.out.println(sum);
			System.out.println((int)Math.pow(min, 2));
		}else System.out.println(-1);
		
	
		
	}
		
}


