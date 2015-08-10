import java.io.*;
import java.util.*;
import java.lang.*;
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
                    Integer start  = Integer.parseInt(edges[0]);
                    Integer end    = Integer.parseInt(edges[1]);
                    Integer weight = Integer.parseInt(edges[2]);

                    graph.addEdge(start, end, weight);
                }

                graph.djikstra(Integer.parseInt(br.readLine()));
                graph.print();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}

class Graph {
    public ArrayList<Vertex> vertices;

    public Graph (Integer size) {
        this.vertices = new ArrayList<Vertex>(size);
        for(int i = 0; i < size; i++) {
            vertices.add(new Vertex(i + 1));
        }
    }

    public void print() {
        for(Vertex v: vertices) {
            if(v.distance != 0) {
                System.out.print(v.distance + " ");
            }
        }
        System.out.println("");
    }

    public void addEdge(Integer s, Integer e, Integer weight) {
        Vertex start = this.vertices.get(s - 1);
        Vertex end   = this.vertices.get(e - 1);
        Edge edge    = new Edge(start, end, weight);

        start.addEdge(end, edge); end.addEdge(start, edge);
    }

    public void djikstra(Integer s) {
        Vertex start   = this.vertices.get(s-1);
        Heap<Vertex> fringe = new Heap<Vertex>();
        HashSet<Vertex> seen = new HashSet<Vertex>();
        start.distance = 0;
        fringe.add(start);

        while(fringe.size() > 0) {
            Vertex current = fringe.pop();
            seen.add(current);

            for(Vertex v: current.neighbors) {
                if(!seen.contains(v)) {
                    Integer new_distance = current.distance + v.edges.get(current).weight;
                    if(new_distance < v.distance || v.distance == -1) {
                        v.distance = new_distance;
                        fringe.update(v);
                    }
                }
            }
        }
    }
}

class Heap<T extends Comparable<T>> {
    private ArrayList<T> elements;
    private HashMap<T, Integer> positions;

    public Heap() {
        this.elements = new ArrayList<T>();
        this.positions = new HashMap<T, Integer>();
        elements.add(null);
    }

    public void update(T elem) {
        if(positions.containsKey(elem)) {
            this.remove(positions.get(elem));
        }

        this.add(elem);
    }

    public Integer size() {
        return this.elements.size() -1;
    }

    public void add(T elem) {
        elements.add(elem);
        positions.put(elem, elements.size()-1);
        bubbleUp();
    }

    public void bubbleUp() {
        Integer last = elements.size()-1;
        Integer parent = this.getParent(last);

        while(elements.get(parent).compareTo(elements.get(last)) > 0) {
            this.swap(parent, last);
            last = parent;
            parent = this.getParent(last);
        }
    }

    public T pop() {
        return remove(1);
    }

    public T remove(Integer s) {
        T ret = elements.get(s);
        swap(s,elements.size() - 1);

        this.elements.remove(elements.size() -1);
        positions.remove(ret);
        bubbleDown(s);
        return ret;
    }

    public void bubbleDown(Integer s) {
        if(elements.size() > 1 && s < elements.size()) {
            Integer left  = left_sibling(s);
            Integer right = right_sibling(s);

            if(elements.get(left).compareTo(elements.get(right)) < 0) {
                if(elements.get(s).compareTo(elements.get(left)) > 0) {
                    swap(left, s);
                    bubbleDown(left);
                }
            } else {
                if(elements.get(s).compareTo(elements.get(right)) > 0) {
                    swap(right, s);
                    bubbleDown(right);
                }
            }
        }
    }

    public Integer left_sibling(Integer s) {
        Integer sib = 2*s;
        if(sib >= elements.size()) {
            sib = s;
        }
        return sib;
    }

    public Integer right_sibling(Integer s) {
        Integer sib = 2*s + 1;
        if(sib >= elements.size()) {
            sib = s;
        }
        return sib;
    }

    public void swap(Integer s1, Integer s2) {
        T elem1 = elements.get(s1);
        T elem2 = elements.get(s2);

        elements.set(s1, elem2);
        elements.set(s2, elem1);

        positions.put(elem2, s1);
        positions.put(elem1, s2);
    }

    public Integer getParent(Integer index) {
        if(index == 1) {
            return 1;
        } else {
            return (int) Math.floor((((float) index)/((float) 2)));
        }
    }
}

class Vertex implements Comparable<Vertex>{
    public Integer index;
    HashSet<Vertex> neighbors;
    Integer distance;
    HashMap<Vertex, Edge> edges;

    public Vertex(Integer index) {
        this.index     = index;
        this.edges     = new HashMap<Vertex, Edge>();
        this.neighbors = new HashSet<Vertex>();
        this.distance  = -1; // effectively +inifity
    }

    public void addEdge(Vertex v, Edge e) {
        if(this.edges.containsKey(v) && this.edges.get(v).weight < e.weight) {
            return;
        }
        this.edges.put(v, e);
        v.edges.put(this, e);

        this.neighbors.add(v);
        v.neighbors.add(this);
    }

    public int compareTo(Vertex v) {
        return this.distance.compareTo(v.distance);
    }
}

class Edge {
    public Integer weight;
    public HashSet<Vertex> vertices;

    public Edge (Vertex s, Vertex e, Integer weight) {
        this.weight   = weight;
        this.vertices = new HashSet<Vertex>();
        vertices.add(s); vertices.add(e);
    }
}