#!/usr/bin/python

def main():
	num = int(raw_input())
	times = {}
	index = 0
	for x in range(num):
		index += 1
		inp = raw_input().split()
		key = int(inp[0]) + int(inp[1])
		if key in times:
			times[key].append(index)
		else:
			times[key] = [index]

	b_times = sorted(times.keys())
	for k in b_times:
		for t in times[k]:
			print(t),

if __name__ == '__main__':
	main()