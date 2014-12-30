#!/usr/bin/python

import fileinput

# https://www.hackerrank.com/challenges/maxsubarray


def main():
    stdin()
    # print max_cont('-1 -2 -3 -4 -5 -6'.split(' '))
    # print max_total('-1 -2 -3 -4 -5 -6'.split(' '))


def stdin():
    input = fileinput.input()

    for i in range(int(input.readline().strip())):
        input.readline().strip()
        str = input.readline().strip().split(' ')
        if str == '':
            continue
        print max_cont(str), max_total(str)


def max_total(a):
    max_sum, m_sum = 0, int(a[0])

    for i in range(len(a)):
        num = int(a[i])
        m_sum = max(m_sum, num)
        if num > 0:
            max_sum += num
    return max_sum if max_sum > 0 else m_sum


def max_cont(a):
    max_sum, sum, m_sum = 0, 0, int(a[0])

    for i in range(len(a)):
        num = int(a[i])
        m_sum = max(m_sum, num)
        sum += num
        if sum < 0:
            sum = 0
        max_sum = max(max_sum, sum)
    return max_sum if max_sum > 0 else m_sum

if __name__ == '__main__':
    main()