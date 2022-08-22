package test;

import java.util.Scanner;
import java.util.StringTokenizer;

public class bj1002_al_step8_11 {
	
	public static int CalcCaseEnemy(int[] arr) {
		
		
		// �ͷ� �������� ������ ����� ���� �� �װ����̴�.
		// ù��°��, 
		// �� �ͷ��� ������ �����Ͽ� x��ǥ, y��ǥ�� ���� �������� ���� ���. 
		// -> �� ���� ����� ���� ���Ѵ�. ���� ���� -1;
		
		// �ι�°��, 
		// �ο��� ���� �ٸ� ��ġ�� �ְ� ��� ������ ��ġ�� �ʰų�(r1+r2<d),
		// ū�� �ӿ� ���� ���� �����ϰ�, ���� ���� �ѷ��� ū���� �߽����� ������ �ʴ� ���(r1-r2 >d)
		// -> �̶��� ����� ���� �������� ����. ���� ���� 0;
		
		
		// ����°��,
		// �� ���� ���� �ܺο��� �������� ������ ���(r1+r2=d, (x1,y1)!=(x2,y2)) �Ǵ�,
		// ū�� �ȿ��� �������� �����Ǿ� ������, �������� �ѷ��� ū���� �ѷ��� �� ������ ������ ���
		// (�������� ���ְ� ū���� �߽����� ����) (r1-r2 = d);
		// -> �̶��� ����� ���� 1����, ���� ���� 1;
		
		// �׹�°��,
		// �� ���� �߽����� ���� �޸��ϰ�, �������� ������ ���
		// else�� ó���ص� ������, 
		// Ȯ���� ���ظ� ���� �Ϲݽ����� ǥ���ϸ� (r1-r2) < d && (r1+r2) > d �� ���
		// -> �̶��� ����� ���� 2����, ���ϰ��� 2;
		
		double d = Math.sqrt(Math.pow(arr[0]-arr[3], 2)+Math.pow(arr[1]-arr[4], 2));
		
		if(arr[0]==arr[3] && arr[1]==arr[4] && arr[2]==arr[5]) {
			return -1;
		} else if(arr[2]+arr[5]<d || Math.abs(arr[2]-arr[5]) > d 
				|| (arr[0]==arr[3]&&arr[1]==arr[4]&&arr[2]!=arr[5])) {
			return 0;
		} else if(arr[2]+arr[5]==d || Math.abs(arr[2]-arr[5])==d) {
			return 1;
		} else {
			return 2;			
		}

		
	}
	

	public static void main(String[] args) {
		
		// �ο��� �������� ��ġ�� ���Ͽ� ����� ���� �����ϴ� ����.
		// ���⼭ ���� �߿��� ���� ũ�� ������, �ͷ��� �������� �� �ͷ������� �Ÿ�
				
		
		int[] info = new int[6]; // �׽�Ʈ���̽��� 1ȸ �Է¹��������� ���� �����ϰ� ó���ϱ� ���� ���� �迭.
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[] answer = new int[n]; //���� ������ �׽�Ʈ ���̽��� ���� ���� ������.

		
		for(int i = 0 ; i < n ; i ++) {
			String input = sc.nextLine(); // �ѹ��� ���� �ޱ� ����, �켱 String ���ڿ����ؼ� ���� ������.
			StringTokenizer st = new StringTokenizer(input);  // StringTokenizer�� ���ڿ� ���� �ɰ�.
			for(int j = 0 ; j < 6 ; j++) {
				info[j] = Integer.valueOf(st.nextToken()); // Integer.valueOf() �޼���� ����ȯ�� ��.
			}
			
			answer[i]=CalcCaseEnemy(info); // ����� ���� �Լ� CalcCaseEnemy()�� ����� ���� ����ϰ� �ٷ� ���� �迭�� ������.									
		}
		
		for(int i = 0 ; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
		
		
		
		
		 

	}

}
