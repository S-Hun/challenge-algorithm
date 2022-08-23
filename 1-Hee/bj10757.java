package bakjoon2;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj10757_al_step7_8 {

	public static void main(String[] args) {
		// 9223372036854775807 9223372036854775808
		
		
		// �ڹٿ����� unsigend long�� �������� �ʴ´�.
		// ��� long ������ �Ѿ�� ��쿡�� Math ���̺귯������ BigInteger��� �޼��带 �����ϴµ�,
		// �� �޼���� ���� ������(Int, Float, long..)�� �ƴ� ������(String)���� �����Ѵ�.
		// ���� int�� long�� ��Ģ����ó�� ��Ģ�����ڷ� ������ �Ұ��ϸ�,
		// �ش� ���̺귯������ �����ϴ� ��Ģ���� �޼���(add ��)�� ����ؾ��Ѵ�.
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		StringTokenizer st = new StringTokenizer(input);
				
		String n1 = st.nextToken();
		String n2 = st.nextToken();
		
		BigInteger bi1 = new BigInteger(n1);
		BigInteger bi2 = new BigInteger(n2);
		
		System.out.println(bi1.add(bi2));				

	}

}
