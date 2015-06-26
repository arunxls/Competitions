#!/usr/bin/python

class Value:
    PATH    = '.'
    BLOCKED = 'X'
    INIT    = 'M'
    DEST    = '*'


class node:
    def __init__(self, row, column, value):
        self.row    = row
        self.column = column
        self.value  = value
        self.seen   = 0
        self.neigh  = set([])
        self.seen   = False
        self.parent = ()

    def is_dest(self):
        return self.value == Value.DEST

    def is_herm(self):
        return self.value == Value.INIT

    def is_path(self):
        return self.value != Value.BLOCKED

    def _print(self):
        # print self.row,self.column,self.value,self.neigh
        print self.row,self.column
        # print self.parent.row,self.parent.column

def main():
    test_cases = int(raw_input().strip())

    for t in xrange(test_cases):
        m_size = [int(o) for o in raw_input().strip().split()]
        rows = m_size[0]
        columns = m_size[1]
        matrix = [[0]*columns for x in xrange(rows)]

        herm = (0,0)
        dest = (0,0)

        for r in xrange(rows):
            c = 0
            for v in list(raw_input().strip()):
                matrix[r][c] = node(r, c, v)
                if matrix[r][c].is_dest():
                    dest = (r,c)
                if matrix[r][c].is_herm():
                    herm = (r,c)
                c += 1

        expected = int(raw_input().strip())

        for r in xrange(rows):
            for c in xrange(columns):
                n = matrix[r][c]
                if n.is_path():
                    if r + 1 < rows:
                        if matrix[r+1][c].is_path():
                            n.neigh.add(matrix[r+1][c])
                            matrix[r+1][c].neigh.add(n)
                    if r -1 > -1:
                        if matrix[r-1][c].is_path():
                            n.neigh.add(matrix[r-1][c])
                            matrix[r-1][c].neigh.add(n)
                    if c + 1 < columns:
                        if matrix[r][c+1].is_path():
                            n.neigh.add(matrix[r][c+1])
                            matrix[r][c+1].neigh.add(n)
                    if c -1 > -1:
                        if matrix[r][c-1].is_path():
                            n.neigh.add(matrix[r][c-1])
                            matrix[r][c-1].neigh.add(n)
                # n._print()

        current = matrix[dest[0]][dest[1]]

        queue = list(current.neigh)
        for n in queue:
            n.parent = current
        while len(queue) > 0:
            pos = queue.pop(0)
            pos.seen = True
            for n in pos.neigh:
                if n.seen == False:
                    n.parent = pos
                    n.seen = True
                    queue.append(n)
        count = 0

        if len(matrix[herm[0]][herm[1]].neigh) > 1:
            count += 1
        current = matrix[herm[0]][herm[1]].parent
        while not current.is_dest():
            # current._print()
            if len(current.neigh) > 2:
                count += 1
                # print current.row, current.column, " => ",
                # for n in current.neigh:
                #     print n.row, n.column,"|",
                # print
            current = current.parent

        if count == expected:
            print "Impressed"
        else:
            print "Oops!"



        # print "-------"


if __name__ == '__main__':
    main()