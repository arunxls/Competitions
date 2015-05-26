#!/usr/bin/python

def main():
	test_cases = int(raw_input().strip())
	for k in range(test_cases):
		rows = int(raw_input().strip())
		cols = 0
		grid = []
		for j in range(rows):
			r = raw_input().strip()
			grid.append(sorted(map(None, r)))
			cols = len(map(None, r))

		flag = True
		for i in range(cols):
			c = grid[0][i]
			for j in range(rows):
				if c > grid[j][i]:
					flag = False

		if flag:
			print "YES"
		else:
			print "NO"

if __name__ == '__main__':
	main()