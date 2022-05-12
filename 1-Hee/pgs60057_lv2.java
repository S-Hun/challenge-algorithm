public class pgs60057_lv2 {

	public static void main(String[] args) {
		
		Solution  sol = new Solution();
		
		System.out.println(sol.solution("ababcdcdababcdcd"));

	}		
}

class Solution {
    public int solution(String s) {
    	
    	// �־��� ���ڿ��� subString���� �߶� ���غ��� ���̵��� ���ø��µ� �����ߴµ�,
    	// ó�� ���ڿ� ���� �ϳ��� �����ϰ� �� ������ ���� ��ҵ�� ���ϰ�, �ٸ��� ���� ������ ���� ��ü�ϰ� �ϴ� ������ ¥�°� �������.
    	// �׷��� �׺κ��� ������ ��Ǯ�ھ Ÿ���� �ڵ带 ���� ������ �����ϰ� ��.
    	
    	int answer = s.length(); 						// ������ ���� �ȵ� �� �����Ƿ�, ���ϰ� answer�� s�� ������ ���̷� �ʱ�ȭ.
    	for(int i = 1 ; i <= s.length()/2 ; i ++) { 	// ���ڿ� ������ �ִ� ���̴� s�� ������. ���� ���� ���� ���ǽ��� ����.
    		int level = 1; 								// ��������̸�, ���߿� 2ab �̷������� ǥ���Ҷ� ���� ������ ��.
    		String zipStr = s.substring(0,i); 			// ù��° ������ ������.
    		String temp = ""; 							// ����� ���ڿ��� ���� String ����.
    		
    		for(int j = i; j<=s.length() ; j +=i) { 								// ó����Һ��� ���߿�ұ��� ���ϱ� ���ؼ� �ݺ����� ������.
    			String next = s.substring(j, j+i > s.length() ? s.length() : j+i); 	// �� ����� �Ǵ� ���� ����.
    			if(zipStr.equals(next)) level ++; 									// ������ ��������� �ø�.
    			else { 															
    				temp += (level!=1 ? level : "") + zipStr;						// ������ �ٸ� ��� ���� ���� �ø��� ���� ���߰� temp�� ���� ����	
    				zipStr=next;													// ���ش����� �ʱ�ȭ��Ŵ.
    				level=1;														// ���� ���ص� 1�� �ʱ�ȭ.
    			}
    		}
    		temp += zipStr; 								// ������ ���� �ܿ� ������ ����, ���� ������ ���°� ������ ���������� �� ���ڿ���!
    		answer = Math.min(answer, temp.length());		// Math.min() �޼��带 ����, �ּڰ��� ���ϴ� �۾����� �������� �ּ� ���� ����.
    		
    	}
    	
    	return answer;  		// �Ϸ��� ������ ���� ���� �ּڰ��� ������.
    	
    }
}



