#include<iostream>
#include<vector>
#include<cmath>

using namespace std;
int paper[50][5];
int cnt = 0;

int cdigit(int a) {
	int v = 0;
	while (a > 0) {
		a /= 10;
		v += 1;
	}
	return v;
}

int main() {
	int mid = 5000;
	/*int  len = 0, x, y, cnt;
	paper[mid][mid] = 1;
	x = mid; y = mid;
	cnt = 1;
	while (cnt < 100'000'000) {
		len += 1;
		for (int i = 0; i < len; i++) paper[y][++x] = ++cnt;
		for (int i = 0; i < len; i++) paper[--y][x] = ++cnt;
		len += 1;
		for (int i = 0; i < len; i++) paper[y][--x] = ++cnt;
		for (int i = 0; i < len; i++) paper[++y][x] = ++cnt;
	}*/
	int r1, c1, r2, c2;
	cin >> r1 >> c1 >> r2 >> c2;
	for (int i = r1; i <= r2; i++) {
		for (int j = c1; j <= c2; j++) {
			int temp = max(abs(i), abs(j));
			if (i == 0 && j == 0) {
				paper[i - r1][j - c2] = 1;
				cnt = max(cnt, 1);
			}
			if (i < temp && j == temp) {
				paper[i - r1][j - c2] = (2 * temp + 1) * (2 * temp + 1) - 6 * temp - (temp + i);
				cnt = max(cnt, cdigit(paper[i - r1][j - c2]));
			}
			else if (i == -temp && j < temp) {
				paper[i - r1][j - c2] = (2 * temp + 1) * (2 * temp + 1) - 4 * temp - (temp + j);
				cnt = max(cnt, cdigit(paper[i - r1][j - c2]));
			}
			else if (i > -temp && j == -temp) {
				paper[i - r1][j - c2] = (2 * temp + 1) * (2 * temp + 1) - 2 * temp - (temp - i);
				cnt = max(cnt, cdigit(paper[i - r1][j - c2]));
			}
			else if (i == temp && j > -temp) {
				paper[i - r1][j - c2] = (2 * temp + 1) * (2 * temp + 1) - 0 * temp - (temp - j);
				cnt = max(cnt, cdigit(paper[i - r1][j - c2]));
			}
		}
	}

	for (int i = r1; i <= r2; i++) {
		for (int j = c1; j <= c2; j++) {
			cout.width(cnt);
			cout << paper[i - r1][j - c2] << " ";
		}
		cout << "\n";
	}
}