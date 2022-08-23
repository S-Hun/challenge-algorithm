package bakjoon2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj2798_al_step10_1 {

	public static void main(String[] args) {
		
		long beforeTime = System.currentTimeMillis(); //�ڵ� ���� ���� �ð� �޾ƿ���
        
		        		
		Scanner sc = new Scanner(System.in);
		
		String FirstLines = sc.nextLine(); 
		String SecondLines = sc.nextLine(); 
		
		// �Է°��� ���ڿ��� �޾������� �� ���� ������ ����.
		StringTokenizer st = new StringTokenizer(FirstLines);
		int Times = Integer.parseInt(st.nextToken());
		int Max = Integer.parseInt(st.nextToken());
		
		// ���� ���ڿ��� �迭�� ��ȯ��.
		String[] StrArr = SecondLines.split(" ");
		
		// ���ڿ� �迭�� ũ�⸸ŭ �����迭�� �����ϰ� �ݺ������� ���� �̽���.
		int[] IntArr = new int [StrArr.length];		
		for(int i = 0 ; i < StrArr.length; i ++) {
			IntArr[i] = Integer.parseInt(StrArr[i]);
		}
		
		// java.util.Arrays�� Arrays.sort() �޼��带 ���� �Էµ� �迭 ���� ������������ ����.
		Arrays.sort(IntArr);
				
		int N = IntArr.length;
		int temp = 0; // �ݺ������� max���� ��� ����� �� ����
		
		// ��ü Ž���� ���� �ݺ������� �ϴ� ����?
		// ���� ���� �ݺ����� 3��° ���ں��� ���������� Ž���Ѵ�. 
		// �׷��� �� Ž���� ����Ǹ� 1, 2��° ����(ī��)�� ��ĭ �Ű����� �ϱ� ������
		// �̷��� ������ �帧�� �����Ϸ��� ���߹ݺ����� �ʿ���
		// ���� �ݺ��� �ϳ��� �Ϸ� ������ �ݺ��� �ϳ��� �̷��� ������ �帧�� ��Ÿ���� �ʾ� ������.
		// �׷��� �ٸ� ��ʸ� �����ؼ� �ݿ���.
				
		for(int i = 0 ; i < N-2; i ++) {
			for(int j = i +1; j<N-1 ; j++) {
				for(int k = j+1; k<N ; k++) {
					// �ݺ����� ���ư��� ���� ����ؼ� ���� �����(for �Ѱ谪���� �񱳸� ����)
					int sum = IntArr[i]+IntArr[j]+IntArr[k];
					

					// Max(�Է¹��� �ִ�) ���� ���� ��쿡�� �񱳿����� �Ͽ� �ִ��� ������.
					if(sum<=Max) {
						temp = Math.max(temp, sum); 
					}
					if(sum==temp) {
						temp = sum;
						break;
					}					
				}
			}
		}
		
		System.out.println(temp);
				

	}

}
