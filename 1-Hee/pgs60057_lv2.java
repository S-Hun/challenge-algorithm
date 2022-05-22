public class pgs60057_lv2 {

	public static void main(String[] args) {
		
		Solution  sol = new Solution();
		
		System.out.println(sol.solution("ababcdcdababcdcd"));

	}		
}

class Solution {
    public int solution(String s) {
    	
    	// 주어진 문자열을 subString으로 잘라서 비교해보는 아이디어는 떠올리는데 성공했는데,
    	// 처음 문자열 단편 하나를 생성하고 그 단편을 다음 요소들과 비교하고, 다르면 다음 단편을 새로 교체하고 하는 로직을 짜는게 어려웠음.
    	// 그래서 그부분을 도저히 못풀겠어서 타인의 코드를 보고 로직은 따라하게 됨.
    	
    	int answer = s.length(); 						// 압축이 전혀 안될 수 있으므로, 리턴값 answer를 s의 압축전 길이로 초기화.
    	for(int i = 1 ; i <= s.length()/2 ; i ++) { 	// 문자열 단편의 최대 길이는 s의 절반임. 따라서 위와 같은 조건식을 세움.
    		int level = 1; 								// 압축수준이며, 나중에 2ab 이런식으로 표현할때 쓰일 변수의 값.
    		String zipStr = s.substring(0,i); 			// 첫번째 단편을 생성함.
    		String temp = ""; 							// 압축된 문자열을 담을 String 변수.
    		
    		for(int j = i; j<=s.length() ; j +=i) { 								// 처음요소부터 나중요소까지 비교하기 위해서 반복문을 시작함.
    			String next = s.substring(j, j+i > s.length() ? s.length() : j+i); 	// 비교 대상이 되는 다음 단편.
    			if(zipStr.equals(next)) level ++; 									// 같으면 압축수준을 올림.
    			else { 															
    				temp += (level!=1 ? level : "") + zipStr;						// 단편이 다를 경우 압축 수준 올리는 것을 멈추고 temp에 값을 저장	
    				zipStr=next;													// 기준단편을 초기화시킴.
    				level=1;														// 압축 수준도 1로 초기화.
    			}
    		}
    		temp += zipStr; 								// 마지막 남은 잔여 단편을 붙임, 만약 단편이 딱맞게 나누어 떨어졌으면 빈 문자열임!
    		answer = Math.min(answer, temp.length());		// Math.min() 메서드를 통해, 최솟값을 비교하는 작업으로 최종에는 최솟 값만 남김.
    		
    	}
    	
    	return answer;  		// 일련의 과정을 통해 얻은 최솟값을 리턴함.
    	
    }
}



