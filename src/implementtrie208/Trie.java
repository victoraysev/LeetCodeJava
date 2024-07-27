package implementtrie208;

import java.util.*;

class Node {
    public List<Node> children;
    public boolean isEnd;
    public char c;

    public Node() {
        children = new ArrayList<>();
        isEnd = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node node)) return false;
        return c == node.c && isEnd == node.isEnd;
    }

    @Override
    public int hashCode() {
        return Objects.hash(c, isEnd);
    }
}

public class Trie {
    public Node root;

    public Trie() {
        root = new Node();
    }

    /*
    fafae, fafa, fafaef
    f
    a
    f
    a a!
    e! e
    f!
    */


    public void insert(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            var childrenList = current.children;
            Node next = null;
            for (Node node : childrenList) {
                if (node.c == c) {
                    if (i == word.length() - 1 && !node.isEnd) {
                    }
                    else if (i < word.length() - 1 &&node.isEnd) {
                    }
                    else{
                        next = node;
                        break;
                    }
                }
            }
            if (next == null) {
                next = new Node();
                next.c = c;
                childrenList.add(next);
            }
            if (i == word.length() - 1) {
                next.isEnd = true;
            }
            current = next;
        }
    }

    public boolean search(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            var childrenList = current.children;
            for (Node child : childrenList) {
                if (child.c == c) {
                    if (i == word.length() - 1 && child.isEnd) {
                        return true;
                    }
                    else if (i < word.length() - 1 && child.isEnd) {
                        continue;
                    }
                    current = child;
                }
            }
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        Node current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            var childrenList = current.children;
            for (Node child : childrenList) {
                if (child.c == c) {
                    if (i == prefix.length() - 1) {
                        return true;
                    }
                    else if (i < prefix.length() - 1 && child.isEnd) {
                        continue;
                    }
                    current = child;
                    break;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("pr");
        trie.insert("pre");
        trie.insert("pref");
        trie.insert("prefi");
        trie.insert("prefix");
        System.out.println(trie.startsWith("prefi"));

//        trie.search("ab");
//        trie.search("a");


    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */