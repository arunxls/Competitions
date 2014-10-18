#!/usr/bin/env python3

def find_ways():
    test_cases 	= int(input())
    for i in range(test_cases):
        num_integers = int(input())
        str_in 	= str(input()).strip()
        int_list = [int(x) for x in str_in.split(' ')]
        output = 1 
        for j in (int_list):
            output = output * j
        print (output%1234567)

def main():
    find_ways()
    
if __name__ == '__main__':
    main()