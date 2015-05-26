#!/usr/bin/python
import timeit

def main():
    test_cases = int(raw_input().strip())
    for x in range(test_cases):

        skill = [int(i) for i in raw_input().strip().split()]
        num = skill.pop(0)
        skill.sort()
        if num == 0:
            print 0
        else:
            unique = {}
            unique_skill = []
            for s in skill:
                if s not in unique:
                    unique[s] = 1
                    unique_skill.append(s)
                else:
                    unique[s] += 1
            # Start Heuristics based analysis for large inputs
            flag = False
            for u in range(len(unique_skill)):
                if u > 0 and u + 1 < len(unique_skill):
                    if unique_skill[u] - unique_skill[u-1] > 1 and unique_skill[u+1] - unique_skill[u] > 1:
                        flag = True
                    if unique[unique_skill[u]] - unique[unique_skill[u-1]] - unique[unique_skill[u+1]] > 0:
                        flag = True
            if flag:
                print 1
            elif team(unique_skill) == 1:
                print 1
            # End Heuristics
            else:
                print team(skill)

def team(skill):
    sets = [[skill.pop(0)]]
    prev = sets[0][0]
    i = 0
    for s in skill:
        index = len(sets) - 1
        if prev != s:
            i = index - 1
        if sets[index][len(sets[index]) - 1] + 1 == s:
            sets[index].append(s)
        elif sets[index][len(sets[index]) - 1] == s:
            if prev != s:
                i = index -1
            flag = True
            while i >= 0 and flag:
                if sets[i][len(sets[i]) - 1] + 1 == s:
                    sets[i].append(s)
                    flag = False
                i -= 1
            if flag:
                sets.append([s])
        else:
            index += 1
            sets.append([s])
        prev = s
    min = len(skill) + 1
    for a in sets:
        length = len(a)
        if length < min:
            min = length
    return min


if __name__ == '__main__':
    main()