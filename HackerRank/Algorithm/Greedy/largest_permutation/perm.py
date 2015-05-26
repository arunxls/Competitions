#!/usr/bin/python

def main():
	num, swaps 	= raw_input().strip().split()
	num 		= int(num)
	swaps 		= int(swaps)
	inp 		= raw_input().strip().split()
	
	orig_index = {}
	orig_value = {}
	for i in range(len(inp)):
		orig_index[i] = inp[i]
		orig_value[inp[i]] = i
	
	# print orig_index
	# print orig_value

	inp.sort(comparator)
	sort_index = {}
	sort_value = {}
	for i in range(len(inp)):
		sort_index[i] = inp[i]
		sort_value[inp[i]] = i

	# print sort_index
	# print sort_value

	count = 0
	for i in range(len(inp)):
		if count == swaps:
			break
		if(sort_index[i] != orig_index[i]):
			count += 1
			# inp[i] = sort_index[i]
			# inp[orig_value[sort_index[i]]] = orig_index[] 
			
			# update index hash
			temp = orig_index[i]
			orig_index[i] = sort_index[i]
			orig_index[orig_value[sort_index[i]]] = temp

			# update value hash
			orig_value[temp] = orig_value[sort_index[i]]
			orig_value[sort_index[i]] = i
	
	for i in range(len(inp)):
		print orig_index[i],

def comparator(x, y):
    x = int(x)
    y = int(y)
    return (x > y) * -1
    return ((x+y) > (y+x)) * -1

if __name__ == '__main__':
	main()
