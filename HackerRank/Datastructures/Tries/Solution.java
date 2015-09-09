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

            if(!flag) {
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
    Node root = new Node();

    public boolean add(String word) {
        Node current = root;
        Boolean flag = false;

        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char w = charArray[i];
            int index = w - 'a';
            if (current.p[index] != null && ((current.p[index].word) || i == charArray.length - 1)) {
                flag = true;
            }
            current = current.get(index);
        }

        current.word = true;

        return flag;
    }
}

class Node {
    Node[] p = new Node[40];
    boolean word = false;

    public Node get(int index) {
        if(p[index] == null) {
            p[index] = new Node();
        }

        return p[index];
    }
}