#include<iostream>
#include<string>

using namespace std;

struct coord {
	int x, y;

	bool operator==(coord& target) {
		if (x == target.x && y == target.y) return true;
		else return false;
	}

	coord operator+(coord& target) {
		return { x + target.x, y + target.y };
	}

	coord operator=(const coord& target) {
		x = target.x;
		y = target.y;
		return target;
	}
};

bool check(coord pos) {
	if (pos.x < 1 || pos.y < 1) return false;
	else if (pos.x > 8 || pos.y > 8) return false;
	else return true;
}

/*
R : 한 칸 오른쪽으로
L : 한 칸 왼쪽으로
B : 한 칸 아래로
T : 한 칸 위로
RT : 오른쪽 위 대각선으로
LT : 왼쪽 위 대각선으로
RB : 오른쪽 아래 대각선으로
LB : 왼쪽 아래 대각선으로
*/

coord selector(string com) {
	if (com == "R") return { 1, 0 };
	else if (com == "L") return { -1, 0 };
	else if (com == "B") return { 0, -1 };
	else if (com == "T") return { 0, 1 };
	else if (com == "RT") return { 1, 1 };
	else if (com == "LT") return { -1, 1 };
	else if (com == "RB") return { 1, -1 };
	else if (com == "LB") return { -1, -1 };
}

void move(const coord& src, coord& dst) {
	dst = src;
}

coord stone, king;

int main() {
	string S, K, com;
	int N;
	cin >> K >> S >> N;

	stone.x = S[0] - 'A' + 1;
	stone.y = S[1] - '0';
	king.x = K[0] - 'A' + 1;
	king.y = K[1] - '0';

	for (int i = 0; i < N; i++) 
	{
		cin >> com;
		coord next = selector(com) + king;
		if (check(next)) 
		{
			if (next == stone) 
			{
				coord s_next = selector(com) + stone;
				if (check(s_next))
				{
					move(s_next, stone);
					move(next, king);
				}
			}
			else
			{
				move(next, king);
			}
		}
	}

	cout << char(king.x - 1 + 'A') << king.y << '\n';
	cout << char(stone.x - 1 + 'A') << stone.y << '\n';
}