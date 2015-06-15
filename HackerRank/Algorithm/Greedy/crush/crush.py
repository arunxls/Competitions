#!/usr/bin/python

def main():
    params = [ int(o) for o in raw_input().strip().split()]

    array = [0] * params[0]

    for l in xrange(params[1]):
        val = [int(o) for o in raw_input().strip().split()]
        a = val[0]
        b = val[1]
        k = val[2]

        # for i in xrange(a-1,b):
        #     array[i] += k

    # print max
    max = 0
    for i in array:
        if i > max:
            max = i
    print max

if __name__ == '__main__':
    main()