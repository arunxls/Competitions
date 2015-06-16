#!/usr/bin/python

def main():
    for i in range(int(raw_input().strip())):
        inp = list(reversed(list(raw_input().strip())))

        f = inp[0]

        index = 0
        flag = False
        for w in inp:
            if w > f:
                tmp = inp[index - 1]
                inp[index - 1] = inp[index]
                inp[index] = tmp
                print ''.join(str(x) for x in list(reversed(inp)))
                flag = True
                break
            f = w
            index += 1
        if not flag:
            print "no answer"


if __name__ == '__main__':
    main()