#!/usr/bin/python

def main():
    testcases = int(raw_input().strip())

    for t in xrange(testcases):
        params = [int(o) for o in raw_input().strip().split()]
        modulo = params[1]

        inp = [int(o) for o in raw_input().strip().split()]

        max_seen_so_far = max_sum = 0
        for i in inp:
            max_seen_so_far = max(0, max_seen_so_far + i)


        # p_sum = [0]
        # sum = 0
        # max_sum = 0
        # flag = False
        # for i in inp:
        #     sum += i
        #     p_sum.append(sum)
        #     if sum == modulo - 1:
        #         flag = True
        #         break
        # if flag:
        #     print modulo - 1
        # else:
        #     max_sum = 0
        #     for i in xrange(len(p_sum)):
        #         for j in xrange(i,len(p_sum)):
        #             temp = (p_sum[j] - p_sum[i])%modulo
        #             if temp > max_sum:
        #                 max_sum = temp
        #             if temp == modulo - 1:
        #                 max_sum = modulo - 1
        #                 break
        #     print max_sum

if __name__ == '__main__':
    main()