#!/usr/bin/python

import fileinput

# https://www.hackerrank.com/challenges/even-tree

adjacency = {}
rank = 0
count = 0
rank = {}


def main():
    # print read_file('EvenTree.txt') - 1
    print stdin() - 1


def stdin():
    input = fileinput.input()
    out = []
    for i in range(int(str(input.readline().strip()).split(' ')[1])):
        out.append(split_into_int(str(input.readline().strip())))

    make_adjacency(out)
    return even()


def read_file(file):
    out = [split_into_int(o) for o in open(file, 'r').read().splitlines()]
    make_adjacency(out[1:])
    return even()


def make_adjacency(graph):
    global adjacency
    for edge in graph:
        if not edge[0] in adjacency:
           adjacency[edge[0]] = []
        if not edge[1] in adjacency:
           adjacency[edge[1]] = []
        adjacency[edge[0]].append(edge[1])
        adjacency[edge[1]].append(edge[0])


def split_into_int(str):
    return [int(o) for o in str.split(' ')]


def even():
    return dfs(adjacency.keys()[0])


def dfs(start, visited=None):
    global count, rank
    if visited is None:
        visited = set()
    visited.add(start)
    rank[start] = 1
    for child in adjacency[start]:
        if child not in visited:
            dfs(child, visited)
            rank[start] += rank[child]
    if rank[start] % 2 == 0:
        count += 1
    return count

if __name__ == '__main__':
    main()

