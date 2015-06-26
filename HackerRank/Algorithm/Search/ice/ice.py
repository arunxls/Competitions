#!/usr/bin/python

import bisect

def main():
    for x in xrange(int(raw_input().strip())):
        sum = int(raw_input().strip())
        size = int(raw_input().strip())
        array = [int(o) for o in raw_input().strip().split()]
        s_array = sorted(array)

        left = 0
        right = 0
        for i in xrange(len(s_array) - 1):
            index = bisect.bisect(s_array, sum-s_array[i], lo=i + 1, hi=len(s_array))
            if s_array[index-1] == sum-s_array[i]:
                left = s_array[i]
                right = s_array[index-1]
                break

        for i in xrange(len(array)):
            if array[i] == left:
                print i+1,
                for j in xrange(i+1, len(array)):
                    if array[j] == right:
                        print j+1,
                        break
                print ""
                break
            elif array[i] == right:
                print i+1,
                for j in xrange(i+1, len(array)):
                    if array[j] == left:
                        print j+1,
                        break
                print ""
                break

if __name__ == '__main__':
    main()