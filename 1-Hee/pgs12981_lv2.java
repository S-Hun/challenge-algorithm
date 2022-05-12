import java.util.ArrayList;

public class pgs12981_lv2 {

	public static void main(String[] args) {
		/*
		 * ����� �� n�� ������� ������� ���� �ܾ� words �� �Ű������� �־��� ��, 
		 * ���� ���� Ż���ϴ� ����� ��ȣ�� �� ����� �ڽ��� �� ��° ���ʿ� Ż���ϴ����� ���ؼ� 
		 * return �ϵ��� solution �Լ��� �ϼ����ּ���.
		 */
		
		int n = 3;
		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		
				
		Solution8 sol = new Solution8();
		int[] arr = sol.solution(n, words);

		
		System.out.println(arr[0]+"," + arr[1]);


	}
}

class Solution8 {
    public int[] solution(int n, String[] words) {

    	
    	ArrayList Right = new ArrayList<>(); // contains �޼��带 ���� �ߺ����� �ִ��� �����ҷ��� ArrayList ���.
    	int turn = 0; 				// ������ ���° �ϱ��� ����Ǿ����� ���ϴµ� ������ ������ ����
    	boolean finish = false;		// �迭�� ������ Ž������ ��, �������� ���� ������ ����Ǿ����� �ƴ����� �Ǻ��ϴ� �Ҹ��� ����.
    	
    	for(int i = 0 ; i < words.length; i++) { 		// �־��� ���ڿ� word�� Ž��    		
			turn++;			// i��° �÷��̾ �����̶� ���� ����� �� ȸ���� ���� �Ǳ� ������ turn ������ �������� ������Ŵ.
    		if(i==0) { 		// ù��°�� ���� �ܾ �͵� ������ �� �� �����Ƿ� ���� �ٷ� ������. 
    			Right.add(words[i]); 
    		} else { 			// 2��° ���ʺ��ʹ� (1) ���� �÷��̾ ������ �ʾҰ�, (2) ���� �÷��̾ ���� �ܾ��� ������ ���ڷ� �����ϴ� �ܾ������� Ž���ؾ���. 
        		int prevLength = words[i-1].length();
        		char prev = words[i-1].charAt(prevLength-1);
        		
        		if(words[i].charAt(0) == prev &&
        				!Right.contains(words[i])) {	// else�� �޾Ƴ��� �ּ��� ������ �Ǵ��ϴ� if���� ����.
        			Right.add(words[i]);
        		}else {
        			finish=true; 		// ������ �߻��� �ٷ� �迭 Ž���� �����ϰ� �Ҹ��� ������ true�� �ٲ㼭 �����ڰ� �־����� �����.
        		}
        		    			
    			if(finish==true) break;	// ����� �Ҹ��� ������ true�̸� ��ٷ� �Լ� Ž�� ����. (�ֳ��ϸ� �翬�� �� ���ʿ��� ������ �����̱� ����)
    		}
    		
    	}

    	int playtime;
    	if(finish == false) {	// �迭���� �����ڸ� ã�� ���ϸ� 0,0 �� �����ؾ���.
    		playtime = 0;
    		turn = 0;
    	} else {
            if(turn%n!=0) {
        		playtime = turn/n +1;	// �ݺ������� turn�� �������״µ� ���� turn�� 4��� 3��° �÷��̾���� �ϰ� ���� ���̹Ƿ� �ø��� �ؾ���. 
        	} else playtime = turn/n;	// �� ������ �������� �� ���� �� playtime�� ��.
        	
        	if(turn%n==0) {
        		turn = n;		// n�� 1���� �������ױ� ������, turn�� n���γ��������� �������� 0�̸� ������ �÷��̾��� ���̹Ƿ� �÷��̾���� n���� �ʱ�ȭ.
        	} else {
        		turn %= n;		// 0���� ����������� ������ turn�� n���� ���� �������� �÷��̾��� �����̹Ƿ� �� ������ �ʱ�ȭ.
        	}
    	}
    	    	
    	int[] answer = {turn, playtime};	// ������ ����� ������ ���� ������ ����.    	
        return answer;
    }
}