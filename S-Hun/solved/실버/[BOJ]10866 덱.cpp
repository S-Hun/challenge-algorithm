#include<iostream>
#include<cstdlib>
#include<string>

using namespace std;
int N;

template <typename T>
class deque {
private:
	T* left;
	T* right;
	int lsz = 0;
	int rsz = 0;
	int fr = 0;
	int ba = 0;
public:
	deque() {
		left = new T[2];
		right = new T[2];
		lsz = 2; rsz = 2;
	}

	int size() {
		return ba + fr;
	}

	bool empty() {
		if (size() == 0) return true;
		else return false;
	}

	void push_front(T v) {
		if (fr >= lsz) {
			T* temp = (T*)realloc(left, lsz * 2 * sizeof(T));
			if (temp == NULL) exit(-1);
			else left = temp;
			lsz *= 2;
		}
		if (fr >= 0) left[fr] = v; 
		else right[-(fr + 1)] = v;
		fr++;
	}

	void push_back(T v) {
		if (ba >= rsz) {
			T* temp = (T*)realloc(right, rsz * 2 * sizeof(T));
			if (temp == NULL) exit(-1);
			else right = temp;
			rsz *= 2;
		}
		if (ba >= 0) right[ba] = v; 
		else left[-(ba + 1)] = v;
		ba++;
	}

	T pop_front() {
		if (empty()) return -1;
		else if (fr - 1 >= 0) return left[fr-- - 1];
		else return right[-(fr-- - 1) - 1];
	}

	T pop_back() {
		if (empty()) return -1;
		else if (ba - 1 >= 0) return right[ba-- - 1];
		else return left[-(ba-- - 1) - 1];
	}

	T front() {
		if (empty()) return -1;
		else if (fr - 1 >= 0) return left[fr - 1];
		else return right[-(fr - 1) - 1];
	}

	T back() {
		if (empty()) return -1;
		else if (ba - 1 >= 0) return right[ba - 1];
		else return left[-(ba - 1) - 1];
	}
};

void init() {
	cin >> N;
}

void solve() {
	string com;
	int v;
	deque<int> q;
	for (int i = 0; i < N; i++) {
		cin >> com;
		if (com == "push_front") {
			cin >> v;
			q.push_front(v);
		}
		else if (com == "push_back") {
			cin >> v;
			q.push_back(v);
		}
		else if (com == "pop_front") {
			cout << q.pop_front() << '\n';
		}
		else if (com == "pop_back") {
			cout << q.pop_back() << '\n';
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
