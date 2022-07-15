import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sea_d2_1989 {

	public static void main(String[] args) throws IOException {
		
		// �־��� ���ڿ��� �¿� ��Ī���� Ȯ���ϴ� �˰����� �䱸�ϴ� ����.	
				
		// �ӵ������ ���� BufferedReader ���.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		// ���� ��ü �׽�Ʈ ���̽��� ũ�⸦ ����.
		int N = Integer.parseInt(br.readLine());		
		// �ݺ����� ���������� �Ʒ��� ���ڿ� ���� Text���� ���ο� ���� ���� ����.(��Ȱ��)
		String Text = "";
		StringBuilder sb = new StringBuilder(); // ������� �ٷ� ���ڿ��� �ٲٱ� ���� StringBuilder ���� ����.
				
		for(int i = 0 ; i < N ; i++) { // �Էµ� �׽�Ʈ ���̽� ũ�⸸ŭ �ݺ��� ����.
			Text = br.readLine();			// �� �׽�Ʈ ���̽��� ����.
			int TextLength = Text.length(); // ���� �ݺ����� �ݺ� Ƚ���� ���ϱ� ���� ���ڿ��� ���̸� ���.
			boolean check = false; // �� �׽�Ʈ ���̽� ���� ȸ���� �Ǵ����� �Ǻ��� �Ҹ��� ����.

			
			// �� �������� �־����� ���ڿ��� Ȧ�� or ¦����
			// Ȧ���� ��쿡�� �������� �������� �¿� ���ڿ��� ��Ī���� �Ǻ�
			// ¦���� ���� ������ ������ �ƴ϶� ������ ������ ���ڿ��� ��Ī���� �Ǻ��ؾ���.
			
			if(TextLength%2!=0) {
				int middle = TextLength/2;	// �ݺ������� ���������� �ݺ����� �ݺ�Ƚ���� �������� ������ ����.		
				for(int j = 0 ; j<middle; j ++) { 
					if(Text.charAt(j)!=Text.charAt(TextLength-1-j)) { 
						// ���� ���ǹ� �� �Ϲݽ����� ���ϸ� ù��° - ������ �̷������� ���������� ���� ��Ī�Ͽ� �� ����.
						check = false;
						break; // ��Ī�� �ƴ� ��츦 ���⿡ �߰��ϸ� ���� �ݺ����� �����Ͽ� ȿ���� ����ų �� �ֵ��� break �߰�.
					}else check = true;				
				}
											
			}else {
				int middle = TextLength/2-1; // �� ��쿡�� �������� �ƴϰ�, �ܾ ������ ������ ù��° ����(?)�� �ִ� �ε��� ���� ������.								
				for(int j = 0 ; j<=middle; j ++) { // Ȧ���ʹ� �ٸ��� ������ ������ middle���� "����" �Ͽ� �������Ѿ���. (Ȧ���� <�� ����ϹǷ� ����X)
										
					if(Text.charAt(j)!=Text.charAt(TextLength-1-j)) {
						check = false;
						break;
					}else check = true;				
				}

				
			}

			
			if(check) {// StringBuilder�� �������� ������ ���ڿ� ���Ĵ�� ���� ����.
				sb.append("#").append(i+1).append(" ").append(1).append("\n");
			}else sb.append("#").append(i+1).append(" ").append(0).append("\n");

		}
		
		
		System.out.println(sb); // ���� ��� ���.
		

	}

}
