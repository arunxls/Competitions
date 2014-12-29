#!/usr/bin/python

import fileinput
import re
import sys

# https://www.hackerrank.com/challenges/palindrome-index

def main():
    input = fileinput.input()
    for n in range(int(input.readline().strip())):
        print palindrome(input.readline().strip())

        # print palindrome('hgygsvlfcwnswtuhmyaljkqlqjjqlqkjlaymhutwsnwcwflvsgygh')


def palindrome(string):
    s = list(string)
    fh = s[:len(s) / 2]
    lh = s[len(s) / 2:]
    for i in range(len(fh)):
        if fh[i] != lh[len(lh) - i - 1]:
            fh.remove(fh[i])
            if _pal(''.join(fh[i:] + lh[:len(lh) - i])) == -1:
                return i
            else:
                return len(string) - i - 1
    return -1


def _pal(string):
    s = list(string)
    fh = s[:len(s) / 2]
    lh = s[len(s) / 2:]
    for i in range(len(fh)):
        if fh[i] != lh[len(lh) - i - 1]:
            return 0
    return -1


if __name__ == '__main__':
    main()
