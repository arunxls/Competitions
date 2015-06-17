#!/usr/bin/python

def main():

    cases = int(raw_input().strip())
    for i in range(cases):
        inp = list(raw_input().strip())
        s_inp = sorted(inp, reverse = 1)

        if ''.join(str(x) for x in inp) == ''.join(str(x) for x in s_inp):
            print "no answer"
        else:
            start = 0
            for i in range(len(inp) - 1):
                if inp[i] < inp[i+1]:
                    start = i

            end = 0
            for j in range(len(inp)):
                if inp[start] < inp[j]:
                    end = j


            tmp = inp[start]
            inp[start] = inp[end]
            inp[end] = tmp

            inp[start+1:] = sorted(inp[start+1:])
            print ''.join(str(x) for x in inp)

if __name__ == '__main__':
    main()