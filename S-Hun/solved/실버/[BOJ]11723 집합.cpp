#include<iostream>
#include<string>

using namespace std;
int n;

void init() {
	cin >> n;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	init();

	int v;
	int set = 0;
	string com;
	while (n--) {
		cin >> com;
		if (com == "add") {
			cin >> v;
			set |= 1 << (v - 1);
		}
		else if (com == "remove") {
			cin >> v;
			set = ~(~set | 1 << (v - 1));
		}
		else if (com == "check") {
			cin >> v;
			if (set & (1 << (v - 1))) cout << "1\n";
			else cout << "0\n";
		}
		else if (com == "toggle") {
			cin >> v;
			set ^= 1 << (v - 1);
		}
		else if (com == "all") {
			set = (1 << 21) - 1;
		}
		else if (com == "empty") set = 0;
	}
}