package solvedRanking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bz1_2163 {

	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//�Է°��� �׻� 3x3�� ���� ���簢�����θ� �ԷµǸ� �ѹ��� ���� �Է¹ް� �ٷ�� ������,
		//�Է¹��� ���� 5x3�̴��� 3x5�̴��� ���� ���ο� ���� ���̰� ���Ī�� ��쿡�� �� ������ ��� �񱳰� �ʿ��ϴ�.
		//�׷��� �켱 ���� �Է¹��� �� �� �ܰ踦 ���ļ� �ϹݽĿ� ������ ������ �����ؾ��Ѵ�.
		
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		// if�� ������ �ϹݽĿ��� ���� �����ؾ� �ϹǷ� if�� ���� ������ ����� �� ��� ������ ������ ����.
		int W = 0;
		int H = 0;
		
		if(X>Y) {// �Ʒ��� �ϹݽĿ� ������ ��, W>H��� �ϴ� ���� ������ ������ ������ �� if���� �ʿ���.
			W = X;
			H = Y;
		} else {
			W = Y;
			H = X;
		}
		// ���� ���ǹ��� ���� ������ W�� ū ��, H�� ���� ������ ��Ī��.
		
		// ���������� �ּ� ���� ���� ���ϹǷ� 
		// �Ʒ��� �ϹݽĿ��� �׻� �ּ� ���� ��ȯ�Ϸ��� W�� ū ��, H�� ���� ���� �� �� Ƚ���� result�� �ּ���.
		// �ݴ�� �ϸ� �ִ밡 �ǹ���. 		
		int result = W-1 + (W * (H-1));
		
		// ���ݸ��� ������ ó������ �� �پ��ִ� �����̹Ƿ� ���� ���̰� �� �κк��� ������ �ɰ�����.
		// �̷��� ���� �ʰ� ���� ���̰� ª�� �κк��� �ɰ��� �Ǹ�, ���� �κ����� ������ �ɰ� �� �״����� �� �������� �ɰ� ���� ������ ������.
		// �׷��� ���� �ϹݽĿ��� ���� �ּҷ� ���̷��� W�� ���� ���� ���� ���� ���� ����, �� ���̰� �� �ʺ��� �ɰ��� �۾��� �����ؾ��Ѵ�.
		// ���� �ϹݽĿ� 3x4�� �簢���϶�, 3�� W ���� ���� 4�� W�� �� ��� ���� ���� ���� �غ��� ������� ���ϸ� �ٷ� ���� ����.
		
		System.out.println(result);
		
		

	}

}
