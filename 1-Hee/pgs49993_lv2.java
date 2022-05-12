

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


		// ���� : 2, 3, 6, 0, 2, 1, 4, 0, 2 ,0

	}

}

class Solution6 {
    public int solution(String skill, String[] skill_trees) {
    	
    	
    	// ������ ���� ������ �迭 �� ������ �����ߴ�.
    	
    	int[] Log = new int[skill.length()]; // skill_trees���� �־��� String�� skill�� ���� ��, �� ���ڿ��� index���� �����ϱ� ���� ����.
		boolean Judge = false; 	// skill_trees�� ����ִ� ���ڿ��� ������ ������ �ƴ��� �����ϱ� ���� �Ҹ��� ���� ����.
		int answer = 0; 	// �Ҹ��𺯼� (Judge)�� ���� �־��� �迭 �ӿ��� ������ ����� ���� ���ϱ� ���� ����� ���� ����.
		
		// �������� skill�� "", null�� �־����� �ʴ´ٰ� �Ͽ����Ƿ� skill�� �ּҰ��� 1�̴�.
		// �׷��� skill�� ���ڿ��� ���̰� 1�̶�� � ����� ���� �����ϱ� ������, (skill�� ���ڿ��� ���� ��ųƮ���� ������ ���̴ϱ�)
		// �̶��� ���� �� skill_trees�� ���̰� �ǹǷ� ���� ����ó���� ���� if������ �б������.		
		if(skill.length()>2) { // ���ڿ��� 2�� �̻��� ������ �Ʒ��� ���� ������ �����Ͽ� ����� �����ؾ���.
			for(int i = 0 ; i< skill_trees.length ; i++) {
				
				String test = skill_trees[i]; // �迭 ��� 1���� ���ڿ��� ������.
				
				for(int j = 0 ; j < skill.length(); j++) {
					Log[j]= test.indexOf(skill.charAt(j)); //skill ���ڿ��� �������� �־��� ���ڿ��� �� ���ں� index ���� ������.
					// �̶� skill ���ڿ��� ���ڸ� skill_trees�� ���ڿ��� ���� �ڿ� ���� index ���� ������ ������
					// skill_trees�� index���� skill �� �������� �Ҷ� �������� �̾�߸� �ϱ� ������ �ƴ� ��츦 ������ ���ϱ� ���� ���� �����ص�.
				}
				
				for(int k  = 0; k<Log.length-1 ; k++) {
					
					// ������ skill�� ���ڿ��� ABC��� �Ҷ�, A�� �ְ� BC�� ������ �̰��� ������ ����̴�.
					// �׷���, A�� ���µ� BC�� ������ �̰��� �Ұ����� ����.
					// ���⼭ �Ѱ��� ������ ������ �� �ִµ�, skill�� �������� ������ index���� Ž���� ��,
					// skill�� ���Ե� ���ڿ����� -1�� ������ �Ǹ� �� ���ڿ� ������ ������ Ž���� �� ��� -1�� ���;� �Ѵ�.
					// ���� -1�� �߰��ϸ� �� skill�� ���� ���ڿ��� ��� -1���� Ž���ϴ� �޼��带 �����ߴ�.
					// ���⼭ ������� ���ϸ� �߸��� ��ųƮ���̹Ƿ� �̿� ���� �������� �����ߴ�.
					
					
					if(Log[k]==-1) {
						for(int l = k+1 ; l < Log.length ; l++) {
							if(Log[l]!=-1) {
								Judge = false;
								break;		
							} else Judge = true;
						}
						if(Judge==false) break; // �ݺ������� false�� ���� ��� �� false���� �����ؾ��� ���� for�� �ٱ��̹Ƿ� �ѹ��� break ���ش�.
					} else {		
						
						if(Log[k+1]==-1) { // Log[0]�϶� ���� ���� ���� -1 �̸� ������ �ݺ����� �ٽ� �ǻ��Ͽ� -1������ �����Ŵ.
							continue;
						} else {
							if(Log[k]>Log[k+1]) { // �� index������ ���������� �ƴ��� ����.
								Judge = false;
								break;
							} else Judge = true;

						}
					}
				}
				
				// ���������� ����� �Ҹ��� ���� ���� �������� ����� ������.
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
