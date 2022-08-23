import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sea_d1_1946 {

	public static void main(String[] args) throws IOException {
		
		// ���������� �Լ�����
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Comb = Integer.parseInt(st.nextToken()+st.nextToken()); 
		// BufferedReader�� ���� �Է� ���� ���黩�� �ٿ��� �ϳ��� ���ڿ��� ����.
		StringBuilder sb = new StringBuilder();

		
		// ������������ ���� ��츦 �����ϸ� ����� ���� �� 6�����̹Ƿ�, 
		// 6���� ����� ���� ���� ���ǹ����� �ذ��ϱ�� ��.
		// �� �ٿ��� Comb�� ���� �Է� ���� �� ������������ ����Ǽ�, 
		// �� ����� ���� ������ ���ڰ� �� �� �����Ƿ� �� ���� ������ �� ����� ���� �Ǵ��ϴ� ������ ����.
		switch(Comb) {
		case 12: // ������ ��� ������ 1 ������ 2�̹Ƿ� ���� vs ���� �� ��Ȳ�̰�,
			sb.append("B"); // ������ �̱�Ƿ� B�� �¸�.
			break;
		case 13:
			sb.append("A");
			break;
		case 21:
			sb.append("A");
			break;
		case 23:
			sb.append("B");
			break;
		case 31:
			sb.append("B");
			break;
		case 32:
			sb.append("A");
			break;
		}
		
		System.out.println(sb); // ��� ���.
		
	}

}
