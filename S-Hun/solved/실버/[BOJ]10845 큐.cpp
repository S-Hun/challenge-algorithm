#include<iostream>
#include<cstdlib>
#include<string>

using namespace std;
int N;

template <typename T>
class queue {
private:
	T* values;
	int sz = 0;
	int fr = 0;
	int ba = 0;
public:
	queue() {
		values = new T[2];
		sz = 2;
	}

	queue(int n) {
		values = new T[n];
		sz = n;
	}

	queue(int n, T v) {
		values = new T[n];
		sz = n;
		memset(values, v, n * sizeof(T));
	}

	int size() {
		return ba - fr;
	}

	bool empty() {
		if (size() == 0) return true;
		else return false;
	}

	void push(T v) {
		if (ba >= sz) {
			realloc(values, sz * 2 * sizeof(T));
			sz *= 2;
		}
		values[ba++] = v;
	}

	T pop() {
		if (empty()) return -1;
		else return values[fr++];
	}

	T front() {
		if (empty()) return -1;
		else return values[fr];
	}

	T back() {
		if (empty()) return -1;
		else return values[ba-1];
	}
};

void init() {
	cin >> N;
}

void solve() {
	string com;
	int v;
	queue<int> q;
	for (int i = 0; i < N; i++) {
		cin >> com;
		if (com == "push") {
			cin >> v;
			q.push(v);
		}
		else if (com == "pop") {
			cout << q.pop() << '\n';
		}
		else if (com == "size") {
			cout << q.size() << '\n';
		}
		else if (com == "empty") {
			if (q.empty()) cout << 1 << '\n';
			else cout << 0 << '\n';
		}
		else if (com == "front") {
			cout << q.front() << '\n';
		}
		else if (com == "back") {
			cout << q.back() << '\n';
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	init();
	solve();
}
