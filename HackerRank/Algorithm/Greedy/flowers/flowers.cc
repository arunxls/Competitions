#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

// https://www.hackerrank.com/challenges/flowers

class buddy {
	public:
		vector<long long> flowers;

	long long cost() {
		long long mult = 1;
		int total = 0;
		for(auto i: flowers) {
			total += i*mult;
			mult++;
		}

		return total;
	}

	void print() {
		cout << "\n";
		for(auto i : flowers) {
			cout << "\t" << i;
		}
		cout << "\n";
	}
};

int main() {

	long long num_flowers, num_friends;
	vector<long long> cost;
	cin >> num_flowers >> num_friends;

	for(long long i = 0; i < num_flowers; i++) {
		long long c;
		cin >> c;
		cost.push_back(c);
	}

	sort(cost.begin(), cost.end(), greater<long long>());

	vector<buddy*> friends;
	for(long long i = 0; i < num_friends; i++) {
		friends.push_back(new buddy());
	}

	long long index;
	while(cost.size() > 0) {
		long long flower_cost = cost[0];
		friends[index%num_friends]->flowers.push_back(flower_cost);
		cost.erase(cost.begin());
		index++;
	}

	long long total_cost = 0;
	for(auto i : friends) {
		total_cost += i->cost();
	}

	cout << total_cost;

	return 0;
}