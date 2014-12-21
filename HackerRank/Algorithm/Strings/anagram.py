#!/usr/bin/python

import fileinput
import re
import sys

# https://www.hackerrank.com/challenges/anagram

alph = set()

def main():
    input = fileinput.input()
    for n in range(int(input.readline().strip())):
        anagram(input.readline().strip())

    # anagram('aujteqimwfkjoqodgqaxbrkrwykpmuimqtgulojjwtukjiqrasqejbvfbixnchzsahpnyayutsgecwvcqngzoehrmeeqlgknnb')

def anagram(string):
    if len(string)%2 != 0:
        print -1
    else:
        s = list(string)
        fh = s[:len(s)/2]
        lh = s[len(s)/2:]
        count = 0
        for i in range(len(fh)):
            if not (fh[i] in lh):
                count = count + 1
            else:
                list.remove(lh, fh[i])
        print count



if __name__ == '__main__':
    main()
