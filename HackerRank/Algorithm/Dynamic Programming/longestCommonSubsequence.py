#!/usr/bin/python

import fileinput

# https://www.hackerrank.com/challenges/common-child

def main():
    # print read_file('EvenTree.txt') - 1
    print ' '.join(str(x) for x in reversed(stdin()))
    # print common([3, 9, 8, 3, 9, 7, 9, 7, 0], [3, 3, 9, 9, 9, 1, 7, 2, 0, 6])

def stdin():
    input = fileinput.input()
    s1, s2 = [], []
    input.readline().strip()

    s1.extend(split_into_int(str(input.readline().strip())))
    s2.extend(split_into_int(str(input.readline().strip())))

    return common(s1, s2)

def split_into_int(s):
    return [int(o) for o in s.split(' ')]

def common(s1, s2):
    # array = [[0] * (len(s2) + 1)] * (len(s1) + 1)
    array = []
    for i in range(len(s1) + 1):
        s_array = []
        for j in range(len(s2) + 1):
            s_array.append(0)
        array.extend([s_array])
    sel = []
    for i in range(1, len(s1)+1):
        for j in range(1, len(s2)+1):
            count = 0
            if s1[i-1] == s2[j-1]:
                count = 1
            array[i][j] = max(array[i-1][j-1] + count, array[i-1][j], array[i][j-1])

    while i !=0 and j !=0:
        if s1[i-1] == s2[j-1]:
            sel.append(s1[i-1])
            i, j = i-1, j-1
        elif array[i][j] == array[i-1][j]:
            i -= 1
        elif array[i][j] == array[i][j-1]:
            j -= 1

    return sel
if __name__ == '__main__':
    main()