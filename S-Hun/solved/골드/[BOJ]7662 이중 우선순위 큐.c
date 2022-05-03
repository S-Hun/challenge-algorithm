#include<iostream>
#include<set>

using namespace std;
typedef long long ll;
multiset<ll> tree;
int tc;

void solve() {
	int k;
	char c; 
	ll v;
	cin >> k;
	while (k--) {
		cin >> c >> v;
		if (c == 'I') tree.insert(v);
		else if (c == 'D') {
			if (tree.empty()) continue;
			else if (v == 1) tree.erase(next(tree.rbegin()).base());
			else if (v == -1) tree.erase(tree.begin());
		}
	}
	if (tree.empty()) cout << "EMPTY\n";
	else cout << *tree.rbegin() << ' ' << *tree.begin() << '\n';
	tree.clear();
}

int main() {
	cin >> tc;
	while (tc--) solve();
}