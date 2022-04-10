#include<iostream>
#include<cmath>

using namespace std;
int N, r, c; 

void init() {
	cin >> N >> r >> c;
}

int solution() {
	int size = pow(2, N), x = 0, y = 0, pos = 0;
	while (size > 0) {
		size /= 2;
		// cout << x << "," << y << endl;
		if (c >= x + size) { 
			x += size;
			pos += size * size;
		}
		if (r >= y + size) {
			y += size;
			pos += 2 * size * size;
		}
	}
	return pos;
}

int main() {
	init();
	cout << solution();
}