#include <vector>
#include <map>
#include <string>
#include <algorithm>
#include <iostream>

int main() {
	int num;
	std::cin >> num;

	std::map<int, std::vector<int>> times;
	for(int x = 1; x <= num; x++) {
		int t, d;
		std::cin >> t >> d;
		times[t+d].push_back(x);
	}

	std::vector<int> keys;
	for(std::map<int, std::vector<int>>::iterator it = times.begin(); it != times.end(); it++) {
		keys.push_back(it->first);
	}

	std::sort(keys.begin(), keys.end());

	for(int i: keys) {
		for(int j: times[i]) {
			std::cout << j << " ";
		}
	}
	return 1;
}