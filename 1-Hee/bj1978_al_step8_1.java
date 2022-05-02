package bakjoon2;

import java.util.Scanner;
import java.util.StringTokenizer;

public class bj1978_al_step8_1 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String input = sc.nextLine();
		
		int[] member = new int[n];
		
		StringTokenizer st = new StringTokenizer(input);
		for(int i = 0  ; i < member.length; i++) {
			member[i] = Integer.valueOf(st.nextToken());
		}

		
		int count = 0;
		// �־��� �׽�Ʈ ���̽� �� �Ҽ��� ��츦 ���� ���� count�� ����

		boolean check = false;
		// ��ü �迭�� Ž���ϴ� ���� �迭�� ���ڰ� �Ҽ����� �ƴ��� ���������� �Ǵ����� �Ҹ��� ����
		
		for(int i = 0 ; i < n ; i ++) {
			if(member[i]>1 && member[i]<4) {
				count++;			
				continue;
				// �־��� ���� x �� 1< x < 4 ��, 2�Ǵ� 3�̸� ������ �Ҽ��̹Ƿ� count�� ������Ű�� i�� ������Ŵ.
			}
			
			for(int j = 2 ; j*j <= member[i]; j++) {
				// � ���� x�� ���ϱ� ������ ū ����� �ص�,
				// �� ���� �Ҽ����� �Ǵ��ϴ� ������ �� ���� ��Ʈ�� ����ŭ ������ �ڿ������� ���Ǹ� �ȴ�.
				// �ֳ��ϸ�, �� �̻��� ���ڴ� 1���� ��Ʈ x ���� ������ �ڿ����� ������ ǥ���� �� �ֱ� ����
				// ���� for���� ���ǽ��� �� ������ �ݿ��Ѵ�.
				if(member[i]%j==0) {
					check = false;
					break;
					// �ڱ� �ڽ� �̿ܿ� �μ��� �߰��ϸ� ��� �ݺ����� ������.
				} else {
					check = true;					
				}
			}
			if(check==true) count++;
			

		}
		
		System.out.println(count);
		
		
			

	}

}
