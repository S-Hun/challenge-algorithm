

public class pgs49993_lv2 {
	public static void main(String[] args) {
		
		String st1 = "CBD"; // 2
		String[] stArr1 = {"BACDE", "CBADF", "AECB", "BDA"};
		
		String st2 = "ABC"; // 3
		String[] stArr2 = {"AGEBFC", "CDEABF", "AGZBERC", "EZGBRC", "OAHBZ", "RATCH"};
							// o 		// x 	// o		// x	   //o	   //x
		
		String st3 = ""; // 6
		String[] stArr3 = {"AGEBFC", "CDEABF", "AGZBERC", "EZGBRC", "OAHBZ", "RATCH"};
		
		String st4 = "CBD"; // 0
		String[] stArr4 = {"CAD"};
		
		String st5 = "CBD"; // 2
		String[] stArr5 = {"AEF", "ZJW"};

		String st6 = "REA"; // 1
		String[] stArr6 = {"REA", "POA"};

		String st7 = "CBDK"; // 4
		String[] stArr7 = {"CB", "CXYB", "BD", "AECD", "ABC", "AEX", "CDB", "CBKD", "IJCB", "LMDK"};

		String st8 = "BDC"; // 0
		String[] stArr8 = {"AAAABACA"};

		String st9 = "CBD"; // 2
		String[] stArr9 = {"C", "D", "CB", "BDA"};
		
		String st10 = "CBD";
		String[] stArr10 = {"CED"};
		
		
		Solution6 sol2 = new Solution6();
		
		
		System.out.println(sol2.solution(st1, stArr1));
		System.out.println(sol2.solution(st2, stArr2));		
		System.out.println(sol2.solution(st3, stArr3));
		System.out.println(sol2.solution(st4, stArr4));
		System.out.println(sol2.solution(st5, stArr5));		
		System.out.println(sol2.solution(st6, stArr6)); 		
		System.out.println(sol2.solution(st7, stArr7)); // 4		
		System.out.println(sol2.solution(st8, stArr8));						
		System.out.println(sol2.solution(st9, stArr9)); // 2
		System.out.println(sol2.solution(st10, stArr10));


		// 정답 : 2, 3, 6, 0, 2, 1, 4, 0, 2 ,0

	}

}

class Solution6 {
    public int solution(String skill, String[] skill_trees) {
    	
    	
    	// 연산을 위해 세가지 배열 및 변수를 선언했다.
    	
    	int[] Log = new int[skill.length()]; // skill_trees에서 주어질 String을 skill로 비교한 뒤, 각 문자열의 index값을 저장하기 위해 생성.
		boolean Judge = false; 	// skill_trees에 들어있는 문자열이 가능한 것인지 아닌지 판정하기 위한 불리언 변수 선언.
		int answer = 0; 	// 불리언변수 (Judge)를 통해 주어진 배열 속에서 가능한 경우의 수를 셈하기 위해 사용할 변수 선언.
		
		// 문제에서 skill은 "", null이 주어지지 않는다고 하였으므로 skill의 최소값은 1이다.
		// 그런데 skill의 문자열의 길이가 1이라면 어떤 경우의 수도 가능하기 때문에, (skill의 문자열이 없는 스킬트리도 가능한 것이니까)
		// 이때의 답은 곧 skill_trees의 길이가 되므로 빠른 연산처리를 위해 if문으로 분기시켜줌.		
		if(skill.length()>2) { // 문자열이 2개 이상일 때에는 아래와 같은 연산을 수행하여 결과를 판정해야함.
			for(int i = 0 ; i< skill_trees.length ; i++) {
				
				String test = skill_trees[i]; // 배열 요소 1개씩 문자열을 가져옴.
				
				for(int j = 0 ; j < skill.length(); j++) {
					Log[j]= test.indexOf(skill.charAt(j)); //skill 문자열을 기준으로 주어진 문자열의 각 문자별 index 값을 저장함.
					// 이때 skill 문자열의 문자를 skill_trees의 문자열과 비교한 뒤에 얻은 index 값을 저장한 이유는
					// skill_trees의 index값은 skill 을 기준으로 할때 오름차순 이어야만 하기 때문에 아닌 경우를 빠르게 셈하기 위해 값을 저장해둠.
				}
				
				for(int k  = 0; k<Log.length-1 ; k++) {
					
					// 예컨데 skill의 문자열이 ABC라고 할때, A만 있고 BC가 없으면 이것은 가능한 경우이다.
					// 그런데, A가 없는데 BC가 있으면 이것은 불가능한 경우다.
					// 여기서 한가지 연산을 도출할 수 있는데, skill을 기준으로 저장한 index값을 탐색할 때,
					// skill에 포함된 문자열에서 -1이 나오게 되면 그 문자열 이후의 값들은 탐색할 때 모두 -1이 나와야 한다.
					// 따라서 -1을 발견하면 그 skill의 뒤쪽 문자열은 모두 -1인지 탐색하는 메서드를 구현했다.
					// 여기서 통과되지 못하면 잘못된 스킬트리이므로 이에 따른 논리연산을 수행했다.
					
					
					if(Log[k]==-1) {
						for(int l = k+1 ; l < Log.length ; l++) {
							if(Log[l]!=-1) {
								Judge = false;
								break;		
							} else Judge = true;
						}
						if(Judge==false) break; // 반복문에서 false로 나올 경우 이 false값이 도달해야할 곳은 for문 바깥이므로 한번더 break 해준다.
					} else {		
						
						if(Log[k+1]==-1) { // Log[0]일때 값이 다음 값이 -1 이면 빠르게 반복문을 다시 실생하여 -1연산을 수행시킴.
							continue;
						} else {
							if(Log[k]>Log[k+1]) { // 각 index값들이 오름차순이 아닌지 판정.
								Judge = false;
								break;
							} else Judge = true;

						}
					}
				}
				
				// 최종적으로 얻어진 불리언 변수 값을 기준으로 결과를 판정함.
				if(Judge == true) {
					Judge = false;
					answer++;
				} else continue;
				
			}
			
		}else {			
			answer=skill_trees.length;			
		}
		
		
		return answer;
		
    }
}
