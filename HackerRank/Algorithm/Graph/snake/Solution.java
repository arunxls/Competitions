import java.io.*;
import java.lang.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            Integer test_cases = Integer.parseInt(br.readLine());
            for(int t = 0; t < test_cases; t++) {
                Board board = new Board(100);
                Integer ladders = Integer.parseInt(br.readLine());
                for(int i = 0; i < ladders; i++) {
                    String[] params = br.readLine().split(" ");
                    Integer start = Integer.parseInt(params[0]);
                    Integer end   = Integer.parseInt(params[1]);
                    board.addEdge(start, end);
                }

                Integer snakes = Integer.parseInt(br.readLine());
                for(int i = 0; i < snakes; i++) {
                    String[] params = br.readLine().split(" ");
                    Integer start = Integer.parseInt(params[0]);
                    Integer end   = Integer.parseInt(params[1]);
                    board.addEdge(start, end);
                }

                // board.print();
                System.out.println(board.countToEnd());
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}

class Square {
    public Integer index;
    public HashSet<Square> neighbors;
    public Square parent;

    public Square (Integer index, Square neighbor) {
        this.index = index;
        this.parent = null;
        this.neighbors = new HashSet<Square>();
        if(neighbor != null) {
            this.neighbors.add(neighbor);
        }
    }

    public void addNeighbor(Square neighbor) {
        this.neighbors.add(neighbor);
    }

    public void print() {
        System.out.println(index);
    }
}

class Board {
    public ArrayList<Square> game;
    public Integer size;
    public Board(Integer size) {
        this.size = size;
        this.game = new ArrayList<Square>();

        Square prev = new Square(size-1, null);
        game.add(0,prev);
        for(int i = size - 2; i >= 0; i--) {
            prev = new Square(i, prev);
            game.add(0,prev);
        }
    }

    public void addEdge(Integer start, Integer end) {
        Square s = game.get(start - 1);
        Square e = game.get(end - 1);

        s.addNeighbor(e);
    }

    public void addSnake(Integer start, Integer end) {
        Square s = game.get(start - 1);
        Square e = game.get(end - 1);

        // s.neighbors.clear();
        s.addNeighbor(e);
    }

    public Integer countToEnd() {
        //Perform BFS to the exit.
        Square start = game.get(0);
        Square end = game.get(size-1);

        ArrayList<Square> path = bfs(start, end);
        if(path.size() == 0) {
            return -1;
        }
        Integer count = 0;
        Integer sub_count = 0;

        Square prev = path.get(0);
        for(int i = 1; i < path.size(); i++) {
            Square current = path.get(i);
            if(current.index - prev.index == 1) {
                sub_count++;
            } else {
                count += (int) Math.ceil(((float) sub_count)/((float) 6));
                sub_count = 0;
            }
            prev = current;
        }

        count += (int) Math.ceil(((float) sub_count)/((float) 6));

        return count;
    }

    public void print() {
        for(Square s : game) {
            System.out.print(s.index + " -> ");
            for(Square q: s.neighbors) {
                System.out.print(q.index + ",");
            }
            System.out.println("");
        }
    }

    public ArrayList<Square> bfs(Square start, Square end) {
        ArrayList<Square> queue = new ArrayList<Square>();
        HashSet<Square> seen = new HashSet<Square>();
        start.parent = null;
        queue.add(start);
        seen.add(start);

        while(queue.size() != 0) {
            Square current = queue.get(0);
            queue.remove(0);

            for(Square neighbor : current.neighbors) {
                if(!seen.contains(neighbor)) {
                    neighbor.parent = current;
                    queue.add(neighbor);
                    seen.add(neighbor);
                }
            }
        }

        ArrayList<Square> path = new ArrayList<Square>();
        if(end.parent != null) {
            path.add(end);
            Square parent = end.parent;
            while(parent != null) {
                path.add(0, parent);
                parent = parent.parent;
            }
        }

        for(Square p : path) {
            System.out.print(p.index + " -> ");
        }
        System.out.println("");

        return path;
    }
}