import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sea_d1_2058 {

	public static void main(String[] args) throws IOException {
		
		// �־��� ���ڰ� �ԷµǸ� �� ���ڵ��� �ڸ����� ���� ���ϴ� ����.
		
		// �ӵ������ ���� BufferedReader�� ����.		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		int length = input.length(); // �ݺ����� ���� �ִ� ����.
		int sum = 0; // �ڸ����� ���� ���� ���� ����.
		for(int i = 0 ; i <length ; i ++) { 
			// String ���� char�� �����Ͽ� int�� �� ��ȯ�� ���� ����. 
			sum += Character.getNumericValue(input.charAt(i));
		}
		System.out.println(sum); // ���� ���� ���� ���.
		

		



	}

}
