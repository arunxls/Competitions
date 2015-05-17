#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

// https://www.hackerrank.com/challenges/cut-the-sticks

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */ 
    int num = 0;
    cin >> num;
    vector<int> input;
    while(num > 0) {
    	num--;
    	int i;
    	cin >> i;
    	input.push_back(i);
    }

    bool flag = true;
    while(flag) {
    	int result = *min_element(begin(input), std::end(input));
	    int count = 0;

	    for(vector<int>::iterator it = input.begin(); it != input.end(); it++) {
    		if(*it != 0) {
	    		count++;
	    		*it -= result;
	    	}
	    }

	    input.erase(remove(input.begin(), input.end(), 0), input.end());
	    flag = count != 0;

	    if(count == 0) {
	    	break;
	    }
	    // cout << "\n=========" << "\n" << count << "\n=========" << "\n";
	    // for(int x : input) {
    	// 	cout << x << "\n";
    	// }
    	// break;

    	cout << count << "\n";
	}

    return 0;
}