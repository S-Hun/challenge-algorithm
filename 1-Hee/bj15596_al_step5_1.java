package bakjoon2;

public class bj15596_al_step5_1 {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4};
		Test test = new Test();
		System.out.println(test.sum(arr));
		//

	}

}

class Test {
	long sum(int[] a) {
		
		long ans = 0;
		for(int i = 0 ; i < a.length; i++) ans+=a[i];				
		return ans;
		
	}
}



