#!/usr/bin/python

def main():
    for x in xrange(int(raw_input().strip())):
        size = int(raw_input().strip())
        array = [int(o) for o in raw_input().strip().split()]

        psum = [0] * size
        for i in xrange(1, len(array)):
            psum[i] = psum[i-1] + array[i-1]

        sum = 0
        flag = False
        for i in reversed(xrange(0, len(array))):
            if sum == psum[i]:
                flag = True
                break
            sum = sum + array[i]

        print "YES" if flag else "NO"

if __name__ == '__main__':
    main()