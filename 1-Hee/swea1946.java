import java.util.Scanner;

public class sea_d2_1946 {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);

		int TestCase = sc.nextInt(); // ��ü�� TestCase ���� ���� ����
		sc.nextLine();
		StringBuilder sb = new StringBuilder(); // ������� �����ϱ� ���� ���ڿ� ����.
		
		
		for(int i = 0 ; i<TestCase; i++) {// �ܺ� �ݺ��� ����.
			int AlphabetCase = sc.nextInt(); // �� �׽�Ʈ ���̽����� ������ �����ϴ� ���ĺ��� ���� ���� ����.			
			sc.nextLine();

			String [][] AlphabetRes = new String [AlphabetCase][2]; // �� ���ĺ����� �ݺ����� �����ϱ� ���� 2���迭 ����.
			
			int stack = 0;
			sb.append("#").append(i+1).append("\n"); // �� �׽�Ʈ���̽����� �Ϸú�ȣ�� ���� �Է�.
			
			for(int j = 0 ; j<AlphabetCase; j ++) {
				AlphabetRes[j]= sc.nextLine().split(" "); // split�� ���� �ε��� 0������ ���ĺ��� ����, 1������ �ݺ�Ƚ�� ����.			
				for(int k = 0 ; k<Integer.parseInt(AlphabetRes[j][1]); k++) { 
					// �迭�� 1��°�� ����� �ݺ�Ƚ����ŭ �ݺ��ϳ�, String �ڷ������� ����ǹǷ� ��ȯ�Ͽ� ���������� �����.
					if(stack>9) { // 0���� �����ϹǷ� 9�� �Ѿ�� ���� �ٹٲ��� �ʿ��ϹǷ� �̷��� ���ǹ� ����.
						sb.append("\n");
						stack=0; // ó������ 10���� �� �� �ֶǷ� ���� stack�� �ʱ�ȭ ������.
					}
					sb.append(AlphabetRes[j][0]); // 2���迭�� 1�� �ε����� �ݺ�Ƚ����ŭ ���ڸ� �߰�����.
					stack++; // ����Ǵ� ���ڿ��� ���ڼ� ���.
				}
			}
			sb.append("\n"); // �� ���������� �׽�Ʈ ���̽��� ���ͷ� ������������ �ϹǷ� ���๮�� �߰�.
						
			
		}
		System.out.println(sb); // ��� ���.
		
	}

}
