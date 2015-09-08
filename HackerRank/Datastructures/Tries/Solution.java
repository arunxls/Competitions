import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            Trie trie = new Trie();
            boolean flag = false;
            String word = "";

            for(int i = 0; i < n; i++) {
                if(!flag) {
                    word = br.readLine();
                    if(trie.add(word)) {
                        flag = true;
                    }
                }
            }

            if(word.equals("")) {
                System.out.println("GOOD SET");
            } else {
                System.out.println("BAD SET");
                System.out.println(word);
            }
        } catch(Exception e) {
            System.err.println(e);
        }
    }
}

class Trie {
    Node root;

    Trie() {
        root = new Node();
    }

    public boolean add(String word) {
        Node current = root;
        Boolean flag = false;

        char[] words = word.toCharArray();

        int index = words[0] - 'a';
        current = current.get(index);

        for (int i = 1; i < words.length; i++) {
            Character w = words[i];
            index = w - 'a';
            current = current.get(index);
        }

        for (int i = 2; i < words.length; i++) {
            Character w = words[i];
            index = w - 'a';
            if(current.p[index] != null) {
                flag = true;
            }
            current = current.get(index);
        }

        current.word = true;

        return flag;
    }
}

class Node {
    Node[] p = new Node[10];
    boolean word;

    Node() {
        word = false;
    }

    public Node get(int index) {
        if(p[index] == null) {
            p[index] = new Node();
        }

        return p[index];
    }

    public int size() {
        int s = 0;
        for(Node n : p) {
            if(n != null) {
                s++;
            }
        }
        return s;
    }
}