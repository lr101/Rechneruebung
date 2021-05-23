package de.hska.iwi.ads.solution.tree;

import de.hska.iwi.ads.dictionary.AbstractBinaryTree;

public class BinarySearchTree <K extends Comparable<K>, V> extends AbstractBinaryTree <K,V> {

    @SuppressWarnings("unchecked")
    public V get (Object o) {
        if (o == null) throw new NullPointerException();
        Node tempNode = binaryTreeSearch(root, (K) o);
        return tempNode != null ? tempNode.entry.getValue() : null;
    }

    private Node binaryTreeSearch(Node n, K key) {
        if (n == null || key.compareTo(n.entry.getKey()) == 0) {
            return n;
        } else if (key.compareTo(n.entry.getKey()) < 0) {
            return binaryTreeSearch(n.left, key);
        } else {
            return binaryTreeSearch(n.right, key);
        }
    }


    public V put (K key, V value) {
        if (key == null || value == null) throw new NullPointerException();

        Node x = root;  //Current Node
        Node y = null;  //Parentnode of x
        while (x != null) {
            //key already in tree
            if (key.compareTo(x.entry.getKey()) == 0){
                V tempValue = x.entry.getValue();
                x.entry.setValue(value);
                return tempValue;
            }
            //Set Parentnode as current Node
            y = x;
            //get next Childnode
            if (key.compareTo(x.entry.getKey()) < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        //Add Leaf to correct position in tree
        if (y == null) {
            root = new Node(key, value);
        } else if (key.compareTo(y.entry.getKey()) < 0) {
            y.left = new Node (key, value);
        } else  {
            y.right = new Node (key, value);
        }
        size++;
        return null;
    }
}
