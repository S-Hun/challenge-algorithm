import java.util.ArrayList;

public class pgs12981_lv2 {

	public static void main(String[] args) {
		/*
		 * 사람의 수 n과 사람들이 순서대로 말한 단어 words 가 매개변수로 주어질 때, 
		 * 가장 먼저 탈락하는 사람의 번호와 그 사람이 자신의 몇 번째 차례에 탈락하는지를 구해서 
		 * return 하도록 solution 함수를 완성해주세요.
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

    	
    	ArrayList Right = new ArrayList<>(); // contains 메서드를 통해 중복값이 있는지 판정할려고 ArrayList 사용.
    	int turn = 0; 				// 게임이 몇번째 턴까지 진행되었는지 셈하는데 쓰려고 선언한 변수
    	boolean finish = false;		// 배열의 끝까지 탐색했을 때, 오답으로 인해 게임이 종료되었는지 아닌지를 판별하는 불리언 변수.
    	
    	for(int i = 0 ; i < words.length; i++) { 		// 주어진 문자열 word를 탐색    		
			turn++;			// i번째 플레이어가 오답이라도 추후 계산할 때 회차는 셈이 되기 때문에 turn 변수를 선행으로 증가시킴.
    		if(i==0) { 		// 첫번째는 무슨 단어가 와도 오답이 될 수 없으므로 값을 바로 저장함. 
    			Right.add(words[i]); 
    		} else { 			// 2번째 차례부터는 (1) 이전 플레이어가 말하지 않았고, (2) 이전 플레이어가 말한 단어의 마지막 문자로 시작하는 단어인지를 탐색해야함. 
        		int prevLength = words[i-1].length();
        		char prev = words[i-1].charAt(prevLength-1);
        		
        		if(words[i].charAt(0) == prev &&
        				!Right.contains(words[i])) {	// else에 달아놓은 주석의 조건을 판단하는 if문과 조건.
        			Right.add(words[i]);
        		}else {
        			finish=true; 		// 오답자 발생시 바로 배열 탐색을 종료하고 불리언 변수를 true로 바꿔서 오답자가 있었음을 기록함.
        		}
        		    			
    			if(finish==true) break;	// 기록한 불리언 변수가 true이면 곧바로 함수 탐색 종료. (왜냐하면 당연히 그 차례에서 게임이 종료이기 때문)
    		}
    		
    	}

    	int playtime;
    	if(finish == false) {	// 배열에서 오답자를 찾지 못하면 0,0 을 리턴해야함.
    		playtime = 0;
    		turn = 0;
    	} else {
            if(turn%n!=0) {
        		playtime = turn/n +1;	// 반복문에서 turn을 증가시켰는데 만약 turn이 4라면 3번째 플레이어까지 하고 다음 턴이므로 올림을 해야함. 
        	} else playtime = turn/n;	// 딱 나누어 떨어지면 그 몫이 곧 playtime이 됨.
        	
        	if(turn%n==0) {
        		turn = n;		// n을 1부터 증가시켰기 때문에, turn을 n으로나누었을때 나머지가 0이면 마지막 플레이어라는 뜻이므로 플레이어수인 n으로 초기화.
        	} else {
        		turn %= n;		// 0으로 나누어떨어지지 않으면 turn을 n으로 나눈 나머지가 플레이어의 순서이므로 이 값으로 초기화.
        	}
    	}
    	    	
    	int[] answer = {turn, playtime};	// 위에서 계산한 값들을 최종 값으로 리턴.    	
        return answer;
    }
}