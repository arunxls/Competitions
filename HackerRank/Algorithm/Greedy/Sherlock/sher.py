#!/usr/bin/python

import bisect

def main():
    r_num = int(raw_input().strip())
    r_array = sorted([int(o) for o in raw_input().strip().split()])
    r_range = sorted([int(o) for o in raw_input().strip().split()])

    min = -1
    elem = r_range[0]
    # check_array = xrange(r_range[0], r_range[1]+1)

    check_array = [r_range[0]]
    index = 1
    for i in xrange(len(r_array)):
        if i + 1 < len(r_array):
            x = (r_array[i] + r_array[i + 1])/2
            if x <= r_range[1] and x >= r_range[0]:
                check_array.append(x)
            if x+1 <= r_range[1] and x+1 >= r_range[0]:
                check_array.append(x+1)
            if x-1 <= r_range[1] and x+1 >= r_range[0]:
                check_array.append(x-1)
    check_array.append(r_range[1])


    for i in check_array:
        index = bisect.bisect(r_array, i)
        left = index - 1
        right = index

        diff = abs(r_array[len(r_array) - 1])
        if left > -1:
            d = abs(r_array[left] - i)
            if d < diff:
                diff = d

        if right < len(r_array):
            d = abs(r_array[right] - i)
            if d < diff:
                diff = d
        if diff > min:
            min = diff
            elem = i

    print elem

if __name__ == '__main__':
    main()