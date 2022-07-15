import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class sv5_1181 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int N = Integer.parseInt(br.readLine());
		
		// ���������� �ߺ��� ���� �ѹ��� ����ϵ��� ������ �ɾ���.
		// �׷��� ArrayList�� Contains() �޼��带 ����
		// �ߺ����� �����Ͽ� �迭�� �����ϰ��� ArrayList�� �����.
		
		ArrayList<String> Words = new ArrayList<>();
		
		StringBuilder sb = new StringBuilder();
		
		// ó�� �Էµ� �׽�Ʈ ���̽� �� ��ŭ ���� �Է¹���.
		for(int i = 0 ; i < N ; i ++) {
			String temp = br.readLine();
			if(!Words.contains(temp)) {
				Words.add(temp);
			}
		}
		
		
		// ���� ��� ���� ����������� ���� ����.
		Collections.sort(Words);
		
		int ins, cmp;
		// ���������� ���� ���ڿ��� ���̰� ª���� ���� ������ ������.
		for(ins = 1 ; ins < Words.size(); ins ++) {
			
			int temp = Words.get(ins).length();
			String tempStr = Words.get(ins);
			
			for(cmp = ins-1 ; cmp >=0 ; cmp--) {
				// ���ǽ��� �Ʒ��� ���� �Ͽ� ���ڿ��� ���̰� ���Ƶ� �����ع����� �ʵ��� ��.				
				if(Words.get(cmp).length() > temp) {
					Words.set(cmp+1, Words.get(cmp));
				} else {
					break;
				}

			}			
			
			Words.set(cmp+1, tempStr);
		}
		
		
		// ��½ð��� ������ ���� StringBuilder�� ����Ͽ� ��°��� ������.				
		for(int i = 0 ; i < Words.size(); i ++) {
			sb.append(Words.get(i)).append("\n");
		}
		
		// �ѹ濡 ���ڿ��� �����.
		System.out.println(sb);


	}

}
