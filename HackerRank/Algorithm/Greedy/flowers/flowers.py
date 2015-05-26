#!/usr/bin/python

import fileinput

class buddy:
	
	def __init__(self):
		self.flowers = []

	def cost(self):
		total = 0
		mult = 1
		for i in self.flowers:
			total += i*mult
			mult += 1
		return total

def main():
	num_flowers, num_friends = raw_input().split()
	num_flowers = int(num_flowers)
	num_friends = int(num_friends)
	cost = [int(o) for o in raw_input().split()]

	# Reverse sort
	cost.sort(reverse = True)
	friends = []
	for i in range(num_friends):
		friends.append(buddy())

	for c in range(len(cost)):
		friends[c%num_friends].flowers.append(cost[c])

	total_cost = 0
	for bud in friends:
		total_cost += bud.cost()

	print total_cost
	# for i in cost:
	# 	print i

if __name__ == '__main__':
	main()