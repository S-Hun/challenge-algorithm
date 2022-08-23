import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class sv5_1181 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int N = Integer.parseInt(br.readLine());
		
		// 문제에서는 중복된 값은 한번만 출력하도록 조건을 걸었다.
		// 그래서 ArrayList의 Contains() 메서드를 통해
		// 중복값을 제외하여 배열을 생성하고자 ArrayList를 사용함.
		
		ArrayList<String> Words = new ArrayList<>();
		
		StringBuilder sb = new StringBuilder();
		
		// 처음 입력된 테스트 케이스 수 만큼 값을 입력받음.
		for(int i = 0 ; i < N ; i ++) {
			String temp = br.readLine();
			if(!Words.contains(temp)) {
				Words.add(temp);
			}
		}
		
		
		// 길이 상관 없이 사전순서대로 먼저 정렬.
		Collections.sort(Words);
		
		int ins, cmp;
		// 삽입정렬을 통해 문자열의 길이가 짧은게 먼저 오도록 정렬함.
		for(ins = 1 ; ins < Words.size(); ins ++) {
			
			int temp = Words.get(ins).length();
			String tempStr = Words.get(ins);
			
			for(cmp = ins-1 ; cmp >=0 ; cmp--) {
				// 조건식을 아래와 같이 하여 문자열의 길이가 같아도 정렬해버리지 않도록 함.				
				if(Words.get(cmp).length() > temp) {
					Words.set(cmp+1, Words.get(cmp));
				} else {
					break;
				}

			}			
			
			Words.set(cmp+1, tempStr);
		}
		
		
		// 출력시간의 단축을 위해 StringBuilder를 사용하여 출력값을 생성함.				
		for(int i = 0 ; i < Words.size(); i ++) {
			sb.append(Words.get(i)).append("\n");
		}
		
		// 한방에 문자열로 출력함.
		System.out.println(sb);


	}

}
