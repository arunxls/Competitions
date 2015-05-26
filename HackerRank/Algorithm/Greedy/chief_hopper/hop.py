#!/usr/bin/python

import math

def main():
	b = int(raw_input().strip())
	cost = [int(i) for i in raw_input().strip().split()]

	total = 0
	i = 2
	min = 0
	prev = {}
	for c in cost:
		total = 2*total + c
		soln = math.ceil(total/(i))
		if total%i > 0:
			soln += 1
		i = i*2
		if soln > min:
			min = soln
		prev[c] = 1
	print int(min)

if __name__ == '__main__':
	main()