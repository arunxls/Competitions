#!/usr/bin/python

# https://www.hackerrank.com/challenges/cut-the-sticks

import fileinput

def main():
    input = fileinput.input()
    num = int(input.readline().strip())
    out = [int(i) for i in input.readline().strip().split(' ')]

    flag = True
    while(flag):
        count = len(out)
        minimum = min(out)
        reduction = 0
        for i in range(count):
            out[i] -= minimum
            if(out[i] == 0):
                reduction += 1

        for i in range(reduction):
            out.remove(0)

        print count
        flag = len(out) > 0
        
if __name__ == '__main__':
    main()
