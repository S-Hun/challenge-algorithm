import java.math.BigInteger;
import java.util.ArrayList;

public class pgs62048_lv2 {

	public static void main(String[] args) {
		
		Solution2_1 sol1 = new Solution2_1();
		Solution2_2 sol2 = new Solution2_2();
		Solution2_3 sol3 = new Solution2_3();

		
		System.out.println(sol1.solution(8, 12));
		System.out.println(sol1.solution(5, 6));
		
		System.out.println(sol2.solution(8, 12));
		System.out.println(sol2.solution(5, 6));
		
		System.out.println(sol3.solution(8, 12));
		System.out.println(sol3.solution(5, 6));


		
	}
}


// 숫자 자료형의 범위에 대해서 잘 알아야 했던 문제,
// 테스트 케이스는 통과하지만, 문제를 통과하지 못해서 다른 사람의 답안을 참고하여 나의 퓰이의 문제점을 파악함.

// 내가 문제를 접근했던 방식은, 주어진 테스트케이스에서의 도형의 패턴을 구현했기에 다른 도형에서 맞지 않아 문제를 틀린 것이었다.

// 자세한 풀이 과정은 코드파일 이외의 md 파일로 첨부함.



class Solution2_1 {
	  public long solution(int w, int h) {
		  
		  		  
		  int gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();
		  
		  long answer = (long) w * (long) h - ((long) w + (long) h - gcd); // 최종으로 도출되는 일반식
		  
		  return answer;
	  }
}

class Solution2_2 {
	  public long solution(int w, int h) {
		  
		  BigInteger W = BigInteger.valueOf(w);		  
		  BigInteger H = BigInteger.valueOf(h);		  

		  
		  return (W.multiply(H)).subtract((W.add(H)).subtract(W.gcd(H))).longValue(); // 최종으로 도출되는 일반식

	  }
}

class Solution2_3 {
	  public long solution(int w, int h) {
		  
		  long W = w;		  
		  long H = h;
		  
		  while (W!=H) {
			  if(W>H) {
				  W-=H;
			  } else {
				  H-=W;
			  }
		  }
		  
		  return (long) w * (long) h - ((long) w + (long) h - W); // 최종으로 도출되는 일반식
		  

	  }
}

