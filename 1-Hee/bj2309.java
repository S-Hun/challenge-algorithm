package solvedRanking;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class bz1_2309 {

	public static void main(String[] args) {
		
		int[] members = new int[9];	// �ϰ������� �ĺ��� ���� ���� �迭	
		boolean[] check = new boolean[9]; // ���� ���������� �ƴ��� �Ǻ��� �� ���� �����ϴ� �迭
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0 ; i < 9 ; i ++) {
			members[i] = sc.nextInt();
			sc.nextLine();
		}
		
		
		// ��� �� �� Ž���� �����ϵ��� �迭�� �������� ������.
		Arrays.sort(members);		
		
		// �������� Ű�� ���� 100�� ����, �־��� ���� ���� ���ϸ� ������ 100�� �ʰ��Ѵ�.		
		// �ʰ� �� (gap) = ������ �ĺ����� Ű�� ���� - 100 ��� �� ��,
		// �ʰ� �� gap�� ������ �ĺ� ���� � �� ������ ������ �� �� �ִ�.
		
		int sum = IntStream.of(members).sum();		
		int gap = sum-100;
		boolean JudgeFlag = false;		
		
		for(int i = 0 ; i < members.length; i ++) {			
			
			// ������ �ĺ� �� �ϳ��� Ű�� 100�� �ʰ��ϴ� ����(gap)���� ũ�ٸ� �� �����̴� ������ ���� �������̴�.
			if(members[i]>gap) {
				check[i] = false; 
			} else {
				
				for(int j = 0 ; j<members.length; j++) {
					// ������ Ȥ�ó� gap���� ū Ű�� ���� �������� ��쿡�� Ž�� ��󿡼� �����ϰ�,
					// �ݺ����� �����ϱ� ���� ���ǹ��� ���� Ž���� continue�� �ݺ����� ���� ��Ŵ.
					if(check[j]) {
						continue;
					} else {
						if(members[i]+members[j]==gap) { // �� ���ǹ��� �����ϴ� ���ڴ� ���� �����̰� �ƴϴ�. 
														 // �������� �ٸ� ������ �ִ��� �ߺ� ������ ����ϹǷ� �߰������� ���� �� ���� ���� �߸� �ʿ�� ����. 
							check[i] = true;
							check[j] = true;
							JudgeFlag = true; // ���� �ݺ����̾ �ٷ� �ݺ����� �����Ű�� ���� �Ҹ��� ������ ���.
							break;
						}
					}
				}				
			}
			
			if(JudgeFlag) {				
				break; // ���� �ݺ������� �� Ž���� ������ �ٷ� �ݺ����� ����ǵ��� ��.
			}
			
		}
		
		for(int i = 0 ; i < members.length; i ++) {
			// ��� ������ �ĺ� �迭�� ¦�� �̷�� �Ҹ��� �迭�� ���� ���� ��� ���θ� ����.
			if(!check[i]) {
				System.out.println(members[i]);
			}
		}
				
	}

}
