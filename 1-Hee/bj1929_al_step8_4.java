package bakjoon2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj1929_al_step8_4 {
	
	public static int[] PrimeRange(int m, int n) {
		
		// �־��� ���� ���� �Ҽ��� ������ �������̾ �̸� �ӽ÷� ��Ƶ� �迭�� ����
		ArrayList PrimeArr = new ArrayList<>();
		
		for(int x = m ; x<=n ; x++) {
			// ������ ���ǿ� ���� 1�� �Ҽ��� �ƴϹǷ� �����ϰ�,
			if(x==1) continue;
			// 2���� �Ҽ��� �� �ִµ� 3������ ������ �Ҽ��̹Ƿ� 
			// �־��� ���ڰ� 2�� 3�� ��� �迭�� �ٷ� �ְ� �ż��ϰ� �ݺ����� �簳��.
			else if (x==2) {
				PrimeArr.add(x);
				continue;
			}
			else if (x==3) {
				PrimeArr.add(x);
				continue;			
			}
			else {
				// 4�̻��� ���ڿ� ���� �Ҽ� �Ǻ��� ���� �˰���
				boolean check = false;
				for(int i =2 ; i*i <=x; i++) {
					if(x%i==0) {
						check = false; 
						break;				
					}else {
						check = true;
					}
				}
				if(check==true) {
					PrimeArr.add(x);
				} else continue;			
			}		
		}
		
		// �ӽ÷� ArrayList�� ��Ƶ� �Ҽ� ������ �迭�� �Ű� ����.
		int[] answer = new int[PrimeArr.size()];
		for(int i = 0 ; i< answer.length ; i++) {
			answer[i]=(int) PrimeArr.get(i);
		}
		return answer;
		
	}


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		// �̹����� StringTokenizer ���� split�� �̿��ؼ� ���� �����
		// �ֳ��ϸ�, ������ ���� �������� ���е� �ΰ��� �����̹Ƿ�,
		String[] range = input.split(" ");
		
		// Ȥ�� ���� �Ųٷ� �ԷµǾ��� ��츦 ����Ͽ� ��Ұ��踦 ���ϴ� ���ǹ�
		int m, n;
		if(Integer.valueOf(range[0])<Integer.valueOf(range[1])) {
			m = Integer.valueOf(range[0]);
			n = Integer.valueOf(range[1]);
		} else {
			n = Integer.valueOf(range[0]);
			m = Integer.valueOf(range[1]);
		}

		
		int[] get = PrimeRange(m, n);
		for(int i = 0 ; i<get.length ; i++) System.out.println(get[i]); 
		

	}

}
