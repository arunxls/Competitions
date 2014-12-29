#!/usr/bin/python

import fileinput

# https://www.hackerrank.com/challenges/common-child

def main():
    input = fileinput.input()
    string1 = str(input.readline().strip())
    string2 = str(input.readline().strip())

    # string1 = 'HARRY'
    # string2 = 'SALLY'

    print common(string1, string2)

def common(str1, str2):
    s1 = list(str1)
    s2 = list(str2)
    array = [ [0] * (len(s1) + 1) ] * (len(s1) + 1)

    for i in range(1, len(s1)+1):
        for j in range(1, len(s1)+1):
            count = 0
            if s1[i-1] == s2[j-1]:
                count = 1
            array[i][j] = max(array[i-1][j-1] + count, array[i-1][j], array[i][j-1])

    return array[len(s1)][len(s2)]

if __name__ == '__main__':
    main()

