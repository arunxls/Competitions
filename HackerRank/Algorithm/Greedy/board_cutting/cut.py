#!/usr/bin/python

def main():
    test_cases = int(raw_input().strip())
    

    # test_cases = 1
    # cols = 6
    # rows = 4

    for x in range(test_cases):
        cols, rows = raw_input().strip().split()
        cols = int(cols)
        rows = int(rows)
        col_cost = [int(o) for o in raw_input().strip().split()]
        row_cost = [int(o) for o in raw_input().strip().split()]

        # col_cost = [2, 1, 3, 1, 4]
        # row_cost = [4, 1, 2]

        col_cost.sort(reverse = True)
        row_cost.sort(reverse = True)

        # print row_cost
        # print col_cost

        row_index = 0
        col_index = 0

        row_count = 1
        col_count = 1

        cost = 0
        for i in range(rows - 1 + cols - 1):
            # print "Here! ROW - " + str(row_index) + " COL - " + str(col_index)
            if row_index >= rows - 1:
                cost += col_cost[col_index] * (col_count)
                row_count += 1
                col_index += 1
            elif col_index >= cols - 1:
                cost += row_cost[row_index] * (row_count)
                col_count += 1
                row_index += 1
            elif row_cost[row_index] > col_cost[col_index]:
                cost += row_cost[row_index] * (row_count)
                col_count += 1
                row_index += 1
            else:
                cost += col_cost[col_index] * (col_count)
                row_count += 1
                col_index += 1
            
            if cost >= (10**9 + 7):
                cost = cost%(10**9+7)
        print cost


if __name__ == '__main__':
    main()
