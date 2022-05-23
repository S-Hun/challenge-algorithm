package bakjoon2;

import java.util.Arrays;
import java.util.Scanner;

public class bj2447_al_step9_4 {
	
	// ����� ����,
	// �������� �־����� ���� 3�� 1�������� 3�� 8���������� �־�����.
	// ���� ���� ��Ģ�� 
	// 1������ ��� 3x3�� ������ 1�� ���������.
	// 2������ ��� 3x3�� ������ 1�� ������� ���� 3�� ���������.
	// 3������ ���(27) 3x3�� ������ 1�� ������� ���� 3��������� ���� 3�� ���������.
	// �� ������ ���̰� �־��� ���ڸ�ŭ �������. �� 3�� �����ŭ �����ϴ� ������ ���δ�.
	// ����, 3x3�� ���� �迭�� ���� ����� �� �迭�� �Էµ� ������ ũ�⸸ŭ �ݺ��ϴ� ���� ���� ������ �ذ��ؾ� �Ѵ�.
	
	
	// ���������� ����� ���ڵ��� ��Ƶ� �迭�� �����Ѵ�.
	public static char[][] starContainer;

	
	// �������� �־��� ��Ģ�� ���� �迭�� ����� �Լ�
	public static void MakeStarArray(int n, int x, int y) {
		if(n==1) {
			// �־��� ���� 3�� ����̱� ������ �� ������ �ٷ� �Ʒ��� �ڵ忡�� 3���� �������ָ� �ᱹ���� 1���� ������.
			// �� ������ �̿��ؼ� ���� ��Ե�.
			// 3x3 ���� �迭�� ����� ������� �� �ִ� ������ �Ʒ��� �ڵ忡�� ��ͷ� �ڱ��ڽ��� �ٽ� ȣ���� �� �ݺ������� ����� �����߱� ������.
			starContainer[x][y] = '*';
			return;
		}
		int value = n/3;
		
		for(int i = 0 ; i < 3; i++) {
			for(int j = 0  ; j< 3 ; j++) {
				if(i==1 && j==1) {
					continue; // ����� ����ΰ� �ϴ� �κ�.
				} else {
					MakeStarArray(value, x+(value*i), y+(value*j)); // 3�� ����� ������ �־��� ���̱� ������ 1�� �����Ҷ����� �ݺ��Ͽ� ȣ���ϰ� ��.
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		starContainer = new char[n][n];
		
		for(int i = 0 ; i < n; i++) { // �迭�� ���� �ƹ��͵� ������ ���� �� ���·� ������.
			Arrays.fill(starContainer[i], ' ');
		}
		
		MakeStarArray(n, 0, 0); // �־��� ���� n���� �����ϸ�, x=0, y=0�������� ������.
		for(int i = 0 ; i < n ; i ++) {
			System.out.println(starContainer[i]); // MakeStarArray() �޼��带 ���� ����� ���� ���.
		}
		

	}

}
