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
                String[] params = br.readLine().split(" ");

                Graph graph = new Graph(Integer.parseInt(params[0]));
                for(int i = 0; i < Integer.parseInt(params[1]); i++) {
                    String[] edges = br.readLine().split(" ");
                    Integer start = Integer.parseInt(edges[0]);
                    Integer end   = Integer.parseInt(edges[1]);
                    graph.addEdge(start, end);
                }

                graph.bfs(Integer.parseInt(br.readLine()));
                graph.print();
                System.out.println("");
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}

class Node {
    public Integer index;
    public HashSet<Node> neighbors;
    Integer distance;

    public Node(Integer index) {
        this.index    = index;
        neighbors     = new HashSet<Node>();
        this.distance = -1;
    }
}

class Graph {
    public ArrayList<Node> nodes;

    public Graph(Integer size) {
        this.nodes = new ArrayList<Node>(size);
        for(int i = 0; i < size; i++) {
            nodes.add(new Node(i));
        }
    }

    public void addEdge(Integer s, Integer e) {
        Node start = nodes.get(s-1);
        Node end = nodes.get(e-1);

        start.neighbors.add(end);
        end.neighbors.add(start);
    }

    public void bfs(Integer s) {
        Node start = nodes.get(s-1);

        ArrayList<Node> queue = new ArrayList<Node>();
        HashSet<Node> seen = new HashSet<Node>();
        start.distance = 0;
        queue.add(start);
        seen.add(start);

        while(queue.size() > 0) {
            Node current = queue.get(0);
            queue.remove(0);

            for(Node n : current.neighbors) {
                if(!seen.contains(n)) {
                    seen.add(n);
                    queue.add(n);
                    n.distance = current.distance + 6;
                }
            }
        }
    }

    public void print() {
        for(Node n : nodes) {
            if(n.distance != 0) {
                System.out.print(n.distance + " ");
            }
        }
    }
}