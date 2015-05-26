#include <vector>
#include <iostream>
#include <string>
#include <algorithm>

int main() {
	int num;
	std::cin >> num;

	for(int i = 0; i < num; i++) {
		int col, row;
		std::cin >> col;
		std::vector<std::vector<char>> grid;
		for(int j = 0; j < col; j++) {
			std::string s;
			std::cin >> s;
			std::vector<char> inp;
			s.erase(std::remove(s.begin(), s.end(), '\n'), s.end());
			for(char c: s) {
				inp.push_back(c);
			}

			std::sort(inp.begin(), inp.end());
			row = inp.size();
			grid.push_back(inp);
		}

		bool flag = true;
		for (int k = 0; k < col; k++) {
			char c = grid[0][k];
			for(int j = 0; j < row; j++) {
				if(c > grid[j][k]) {
					flag &= false;
				} else {
					flag &= true;
				}
				c = grid[j][k];
			}
		}

		if(flag) {
			std::cout << "YES\n";
		} else {
			std::cout << "NO\n";
		}
	}

	
	return 1;
}