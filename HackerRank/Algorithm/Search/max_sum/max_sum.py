#!/usr/bin/python

def main():
    testcases = int(raw_input().strip())

    for t in xrange(testcases):
        params = [int(o) for o in raw_input().strip().split()]
        modulo = params[1]

        inp = [int(o) for o in raw_input().strip().split()]

        p_sum = []
        sum = 0
        for i in inp:
            sum += i
            p_sum.append(sum)
        print p_sum

if __name__ == '__main__':
    main()