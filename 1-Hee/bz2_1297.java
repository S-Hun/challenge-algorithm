package solvedRanking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bz2_1297 {

	public static void main(String[] args) throws IOException {
		
		
		// ��Ÿ����� ������ �̿��Ͽ� ������ ���� ���� ���� �� �ִ� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// �Էµ� ���� �ּ� 2ȸ �̻� ���Ǿ ������ ��� ���� Ÿ���ϹǷ� ������ ������ ���� ����. 
		int D = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		
		// ���Ŀ� ���� ����
		// ���������� �밢���� "����"���̿� ���� ������ "����"�� �־����Ƿ�, a2 + b2 = c2�� �̿��Ͽ�
		// c2�� �ش��ϴ� �밢���� ���������� ������ ������ H�� W�� ���� ������� ���ϴ� ���� �ʿ�.
		// ������� ������ ������ ������ ���̹Ƿ� �� ���� �������� ���ؾ� ���� ���̸� ���� �� ����.
		// ���⼭ ������ �������� x��� �� ��, ���� ���ο� ���� ���� ���� W * x / H * x�� ���� �� ����.
		
		double ratio = Math.sqrt(Math.pow(D, 2)/(Math.pow(H, 2) + Math.pow(W, 2)));
		
		StringBuilder sb = new StringBuilder();
		
		// ���� �������� ���ϴ� ���� �Ҽ��� ���� ������ ���̹Ƿ� �Ʒ��� ���� ����ȯ�� ���� ���� ���� ó����.
		// �� �ڵ忡���� �׳� ���� ����ȯ���� ���� ó���� ������, ������ ����� �ۼ��Ѵٸ� Math.ceil ���� �̿��ϴ� ���� ������ ��.
		// ��������� ���� ������ ���ϴ� ��Ŀ� �°� �̾� �ٿ��� ���ڿ��� ������.
		sb.append((int)(H*ratio)+ " " + (int)(W*ratio));
		
				
		System.out.println(sb.toString());

	}

}
