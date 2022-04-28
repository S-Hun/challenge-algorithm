#include<iostream>
#include<vector>

using namespace std;

struct point {
	int x, y;

	point() : x(0), y(0) {}
	point(int x, int y) : x(x), y(y) {}

	point& operator=(const point& a) {
		this->x = a.x;
		this->y = a.y;
	}
};

vector<point> blanks;
int sudoku[9][9];

void input() {
	char s[10];
	for (int i = 0; i < 9; i++) {
		cin >> s;
		for (int j = 0; j < 9; j++) {
			sudoku[i][j] = s[j] - '0';
			if (sudoku[i][j] == 0) blanks.push_back(point(j, i));
		}
	}
}

bool check_sudoku(point p, int k) {
	for (int i = 0; i < 9; i++) {
		if (sudoku[p.y][i] == k || sudoku[i][p.x] == k) return false;
	}
	int x = p.x / 3 * 3, y = p.y / 3 * 3;
	for (int i = y; i < y + 3; i++) {
		for (int j = x; j < x + 3; j++) {
			if (sudoku[i][j] == k) return false;
		}
	}
	return true;
}

bool calc(int i) {
	if (i == blanks.size()) return true;
	bool check = false;
	for (int j = 1; j <= 9; j++) {
		if (check_sudoku(blanks[i], j)) {
			sudoku[blanks[i].y][blanks[i].x] = j;
			check = calc(i + 1);
		}
		if (check) return true;
	}
	sudoku[blanks[i].y][blanks[i].x] = 0;
	return false;
}

void solution() {
	if (calc(0)) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				cout << sudoku[i][j];
			}
			cout << '\n';
		}
	}
}

int main() {
	input();
	solution();
}