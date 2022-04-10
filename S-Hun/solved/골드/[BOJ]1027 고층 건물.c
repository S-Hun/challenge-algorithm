#include<iostream>
#include<vector>

using namespace std;
int N;
vector<int> height;

void init() {
	cin >> N;
	int temp;
	for (int i = 0; i < N; i++) {
		cin >> temp;
		height.push_back(temp);
	}
}

int mostInSide() {
	int ans = 0, cnt = 0;
	for (int i = 0; i < N; i++) {
		cnt = 0;
		double left, right;
		//cout << i << " left ";
		for (int j = i-1; j >= 0; j--) {
			if (j == i - 1) { 
				cnt++; 
				left = double(height[i] - height[j]) / (i - j); 
			}
			else if (double(height[i] - height[j]) / (i - j) < left) {
				//cout << j << "," << double(height[i] - height[j]) / (i - j) << " ";
				left = double(height[i] - height[j]) / (i - j);
				cnt++;
			}
		}
		//cout << " right ";
		for (int k = i + 1; k < N; k++) {
			if (k == i + 1) {
				cnt++;  
				right = double(height[k] - height[i]) / (k - i);
			}
			else if (double(height[k] - height[i]) / (k - i) > right) {
				//cout << k << "," << double(height[k] - height[i]) / (k - i) << " ";
				right = double(height[k] - height[i]) / (k - i);
				cnt++;
			}
		}
		ans = max(cnt, ans);
	}
	return ans;
}

int main() {
	init();
	cout << mostInSide();
}