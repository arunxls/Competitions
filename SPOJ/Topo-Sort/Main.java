import java.util.*;
import java.lang.*;
import java.io.*;

//http://www.spoj.com/problems/TOPOSORT/

class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] params = br.readLine().split(" ");
            Integer n = Integer.parseInt(params[0]);
            Integer m = Integer.parseInt(params[1]);

            ArrayList<Vertex> list = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                list.add(new Vertex(i));
            }

            String[] edges;

            for(int i = 0; i < m; i++) {
                edges = br.readLine().split(" ");
                list.get(Integer.parseInt(edges[0]) - 1 ).addVertex(list.get(Integer.parseInt(edges[1]) - 1 ));

            }

            Vertex start = list.get(edges[0]);


        } catch(Exception e) {
            System.err.println(e);
        }
    }
}

class Vertex {
    int seen;
    int index;
    ArrayList<Vertex> adj;

    Vertex(int index) {
        this.index = index;
        seen       = 0;
        this.adj   = new ArrayList<>();
    }

    void addVertex(Vertex v) {
        this.adj.add(v);
    }
}