import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] params = br.readLine().split(" ");
            Integer n = Integer.parseInt(params[0]);
            Integer m = Integer.parseInt(params[1]);
            Integer k = Integer.parseInt(params[2]);

            Board board = new Board(n, m);
            for(int i = 0; i < n; i++) {
                String[] row = br.readLine().split("");
                for(int j = 0; j < m; j++) {
                    board.addCell(i, j, row[j]);
                }
            }

            board.flood();
            System.out.println(board.minChanges(0,0,k));
        } catch(Exception e) {
            System.err.println(e);
        }
    }
}

class Cell {
    public String direction;
    public Integer row;
    public Integer column;

    public Cell left;
    public Integer changes_left;
    public Integer path_left;

    public Cell right;
    public Integer changes_right;
    public Integer path_right;

    public Cell up;
    public Integer changes_up;
    public Integer path_up;

    public Cell down;
    public Integer changes_down;
    public Integer path_down;

    public Cell(Integer row, Integer column, String direction) {
        this.row       = row;
        this.column    = column;
        this.direction = direction;

        this.changes   = 0;
        this.path      = 0;
    }
}

class Board {
    public Integer rows;
    public Integer columns;
    public Cell[][] board;
    public Cell start;

    public Board(Integer rows, Integer columns) {
        this.rows    = rows;
        this.columns = columns;
        this.board   = new Cell[rows][columns];
    }

    public void addCell(Integer row, Integer column, String direction) {
        board[row][column] = new Cell(row, column, direction);
        if(direction.equals("*")) {
            start = board[row][column];
        }
    }

    public Integer minChanges(Integer row, Integer column, Integer k) {
        Cell c = board[row][column];
        ArrayList<Cell> adj = new ArrayList<>();
        adj.add(c.left); adj.add(c.right); adj.add(c.up); adj.add(c.down);

        Integer min = 10000;
        for(Cell temp : adj){
            if(temp != null) {
                if(temp.path <= k) {
                    min = Math.min(min, temp.changes);
                }
            }
        }

        return min;
    }

    public void flood() {
        ArrayList<Cell> queue = new ArrayList<Cell>();
        HashSet<Cell> seen    = new HashSet<>();
        queue.add(start);

        while(queue.size() > 0) {
            Cell c = queue.get(0);
            seen.add(c);
            queue.remove(c);
            ArrayList<Cell> bulkAdd = new ArrayList<>();
            Cell temp;
            if(c.column > 0) {
                temp = board[c.row][c.column-1];
                bulkAdd.add(temp);

                temp.right = c;
                temp.path = c.path + 1;

                if(temp.direction.equals("R")) {
                    temp.changes = c.changes;
                } else {
                    temp.changes = c.changes + 1;
                }

            }

            if(c.column < columns - 1) {
                temp = board[c.row][c.column+1];
                bulkAdd.add(temp);

                temp.left = c;
                temp.path = c.path + 1;

                if(temp.direction.equals("L")) {
                    temp.changes = c.changes;
                } else {
                    temp.changes = c.changes + 1;
                }

            }

            if(c.row > 0) {
                temp = board[c.row-1][c.column];
                bulkAdd.add(temp);

                temp.down = c;
                temp.path = c.path + 1;

                if(temp.direction.equals("D")) {
                    temp.changes = c.changes;
                } else {
                    temp.changes = c.changes + 1;
                }
            }

            if(c.row < rows - 1) {
                temp = board[c.row+1][c.column];
                bulkAdd.add(temp);

                temp.up = c;
                temp.path = c.path + 1;

                if(temp.direction.equals("U")) {
                    temp.changes = c.changes;
                } else {
                    temp.changes = c.changes + 1;
                }
            }

            for(Cell s: bulkAdd) {
                if(!seen.contains(s)) {
                    queue.add(s);
                }
            }
        }
    }
}