#include<iostream>

using namespace std;
int N, K;

int bitCount(int x) {
	int cnt = 0;
	while (x > 0) {
		x & 1 && cnt++;
		x >>= 1;
	}
	return cnt;
}

int genMask(int x) {
	int ret = 0;
	for (int i = 0; i < x; i++) {
		ret = ret << 1 | 1;
	}
	return ret;
}

int main() {
	cin >> N >> K;
	int total_cnt = bitCount(N);
	//cout << total_cnt << endl;
	if (total_cnt <= K) {
		cout << 0;
		return 0;
	}
	int cnt = 0, len = 0, temp = N;
	while (K - 1 != total_cnt - cnt) {
		++len;
		temp & 1 && ++cnt;
		temp >>= 1;
	}
	//cout << len << " " << genMask(len) << endl;
	cout << ((genMask(len) & N) ^ genMask(len)) + 1 << endl;
}