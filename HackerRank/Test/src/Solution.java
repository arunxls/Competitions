import java.lang.*;
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int ROW = 3;
        int COLUMN = 3;

        Grid grid = new Grid(ROW, COLUMN);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println("Enter Input (row,column):");
                String[] input = br.readLine().split(",");
                int row = Integer.parseInt(input[0]);
                int column = Integer.parseInt(input[1]);
                if ((row >= ROW) || (column >= COLUMN)) {
                    System.err.println("Invalid input - try again!");
                } else {
                    grid.set(row, column, State.X);

                    grid.print();
                }


            } catch (Exception e) {
                System.err.println(e);
            }
        }

    }
}

enum State {
    X, O, NONE
}

class Grid {
    Cell[][] board;

    Grid(int row, int column) {
        board = new Cell[row][column];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    void set(int r, int c, State state) {
        board[r][c].value = state;
    }

    void print() {
        for(Cell[] row: board) {
            String[] contents = new String[row.length];
            for(int i = 0; i < row.length; i++) {
                contents[i] = row[i].toString();
            }
            System.out.println(String.join(" | ", contents));
            System.out.println(new String(new char[3 * row.length]).replace('\0', '-'));
        }
    }
}

class Cell {
    public State value;

    Cell() {
        this.value = State.NONE;
    }

    @Override
    public String toString() {
        if(value == State.X) {
            return "X";
        } else if(value == State.O) {
            return "O";
        } else {
            return " ";
        }
    }
}

