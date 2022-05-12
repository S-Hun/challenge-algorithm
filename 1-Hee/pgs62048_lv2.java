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


// ���� �ڷ����� ������ ���ؼ� �� �˾ƾ� �ߴ� ����,
// �׽�Ʈ ���̽��� ���������, ������ ������� ���ؼ� �ٸ� ����� ����� �����Ͽ� ���� ǽ���� �������� �ľ���.

// ���� ������ �����ߴ� �����, �־��� �׽�Ʈ���̽������� ������ ������ �����߱⿡ �ٸ� �������� ���� �ʾ� ������ Ʋ�� ���̾���.

// �ڼ��� Ǯ�� ������ �ڵ����� �̿��� md ���Ϸ� ÷����.



class Solution2_1 {
	  public long solution(int w, int h) {
		  
		  		  
		  int gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();
		  
		  long answer = (long) w * (long) h - ((long) w + (long) h - gcd); // �������� ����Ǵ� �Ϲݽ�
		  
		  return answer;
	  }
}

class Solution2_2 {
	  public long solution(int w, int h) {
		  
		  BigInteger W = BigInteger.valueOf(w);		  
		  BigInteger H = BigInteger.valueOf(h);		  

		  
		  return (W.multiply(H)).subtract((W.add(H)).subtract(W.gcd(H))).longValue(); // �������� ����Ǵ� �Ϲݽ�

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
		  
		  return (long) w * (long) h - ((long) w + (long) h - W); // �������� ����Ǵ� �Ϲݽ�
		  

	  }
}

