import java.util.ArrayList;

public class pgs49994_lv2 {

	public static void main(String[] args) {
		
		String s1 = "ULURRDLLU"; // 7
		String s2 = "LULLLLLLU"; //7
		String s3 = "UDUDUDUDUD"; // 1
		String s4 = "LULLLLLLUDUD"; // 7
		String s5 = "UUUUUUUUUUUUUUUUUUUUUUUUDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR"; //20

		
		Solution3 sol = new Solution3();			
    	
		System.out.println(sol.solution(s1));
		System.out.println(sol.solution(s2));
		System.out.println(sol.solution(s3));
		System.out.println(sol.solution(s4));
		System.out.println(sol.solution(s5));


	}

}

class Solution3 {
    public int solution(String dirs) {
        
        int x=0;
        int y=0;
        
        ArrayList<String> before = new ArrayList<>();
        ArrayList<String> after = new ArrayList<>();

                        
        for(int i = 0 ; i< dirs.length(); i++){
        	 
        	int tempX = x;
        	int tempY = y;
           
        	switch(dirs.charAt(i)){
                    case 'U':
                        y++;
                        break;
                    case 'D':
                        y--;
                        break;
                    case 'L':
                        x--;
                        break;
                    case 'R':
                        x++;
                        break;                        
            }
            if(x>5) {
               x=5;
            } else if(x<-5) {
               x=-5;
            } else if(y>5) {
               y=5;
            } else if(y<-5) {
               y=-5;
            } else {
            	before.add(String.valueOf(tempX)+String.valueOf(tempY));
            	after.add(String.valueOf(x)+String.valueOf(y));
            }
        }
                        
        
        ArrayList Arr = new ArrayList<>();
        int count = 0;
        String temp1 = "";
        String temp2 = "";
                
        
        for(int i = 0 ; i<before.size(); i++){ 
            temp1 = (String) before.get(i);
            temp2 = (String) after.get(i);
            
            if(temp1.equals(temp2)) {
               continue;
            }
            
            if(!Arr.contains(temp1+temp2) && !Arr.contains(temp2+temp1)) {
                Arr.add(temp1+temp2);
                count++;
            }              
        }
                
        return count;
    }
}
