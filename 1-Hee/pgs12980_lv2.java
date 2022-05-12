
public class pgs12980_lv2 {
	public static void main(String[] args) {
		Solution7 so = new Solution7();
		System.out.println(so.solution(5));
		System.out.println(so.solution(6));
		System.out.println(so.solution(5000));
				
		

	}
}


// 본 문제는 두가지 연산만을 사용해서 목표값을 산출할줄 아는지를 판별할 문제인 듯 하다.
// 문제에서는 두가지 연산만을 허용하는데, 더하기와 곱하기이다.
// 여기서 더하기에는 추가적인 패널티를 적용해서 최소한의 더하기를 사용해 목표값을 도출해야 한다.


class Solution7 {
    public int solution(int n) {
        int ans = 0;
        
        // 모든 수는 크게 볼때 홀수 또는 짝수이다.
        // 따라서, 어떤 수 x가 2의 제곱수라면 2로 나누었을때 1이 될때까지 나뉠 것이다.
        // 그러나 홀수이거나, 제곱수가 아니라면 2로 나누다보면 반드시 홀수가 생기게 된다.
        // 이때 홀수에 대해서는 뺄셈을 하여 2로 나누면 다시 2로 나뉜다.
        // 문제에서는 덧셈연산을 허용했지만, 사실 뺄셈은 덧셈의 역이니까. 뺄셈으로 뒤집어 생각해도 상관이 없다.
        

        while(n!=0){
            if(n%2==0){ // 곱하기 연산에는 cost가 없으므로 2로 나누어떨어지면 무한정 나눌 수 있도록 하였다.
                n/=2;
            } else { // 홀수를 마주하는 경우이다. 이때에는 1을 차감하고 나누면 다시 2로 나뉠 수 있다.
                n-=1;
                n/=2;
                ans++; // 덧셈(이 코드에서는 뺄셈)을 사용한 셈이므로 cost를 증가시켰다.
            }
        }

        return ans; // 전체 cost를 계산하여 값을 리턴한다.
    }
}
