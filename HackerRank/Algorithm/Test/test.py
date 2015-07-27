# num_tc = 1
# for i in range(num_tc):
#     short_cuts = {}
#     num_ladders = 1
#     for i in range(num_ladders):
#         src, dest = (int(x) for x in raw_input().split())
#         short_cuts[src] = dest
#     num_snakes = int(input())
#     for i in range(num_snakes):
#         src, dest = (int(x) for x in input().split())
#         short_cuts[src] = dest

short_cuts = {}
short_cuts[3]  = 90
short_cuts[99] = 10
short_cuts[97] = 20
short_cuts[98] = 30
short_cuts[96] = 40
short_cuts[95] = 50
short_cuts[94] = 60
short_cuts[93] = 70

distance = {1 : 0}
fringe = [1]
while len(fringe) > 0:
    curr_idx = fringe.pop(0)
    curr_dist = distance[curr_idx]
    if curr_idx == 100:
        print(curr_dist)
        break
    elif curr_idx > 100:
        continue
    else:
        for i in range(curr_idx + 1, (curr_idx + 7)):
            if i in short_cuts:
                if short_cuts[i] not in distance:
                    fringe.append(short_cuts[i])
                    distance[short_cuts[i]] = curr_dist + 1
            elif i not in distance:
                fringe.append(i)
                distance[i] = curr_dist + 1
if len(fringe) == 0:
    print(-1)