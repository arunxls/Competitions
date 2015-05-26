#!/usr/bin/python

def main():
	toys = int(raw_input().strip())
	weight = sorted([int(o) for o in raw_input().strip().split()])

	current = -10
	count = 0
	for w in weight:
		if w > current:
			count += 1
			current = w + 4
	print count

if __name__ == '__main__':
	main()