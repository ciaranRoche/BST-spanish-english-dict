import java.util.NoSuchElementException;

/**
 * Created by muldoon on 02/03/17.
 */
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node{
        private Key key;
        private Value val;
        private Node left, right;
        private int size;

        public Node(Key key, Value val, int size){
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public BST(){}

    public boolean isEmpty(){
        return size() == 0;
    }

    public int size(){
        return size(root);
    }

    private int size(Node x){
        if (x==null) return 0;
        else return x.size;
    }

    public boolean contains(Key key){
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    public Value get(Key key){
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }

    public void put(Key key, Value val){
        if(key==null) throw new IllegalArgumentException("first argument to put() is null");
        if(val==null){
            delete(key);
            return;
        }
        root=put(root,key,val);
        assert check();
    }

    private Node put(Node x, Key key, Value val){
        if(x==null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if(cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.size = 1+size(x.left) + size(x.right);
        return x;
    }

    public void deleteMin(){
        if(isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMin(root);
        assert check();
    }

    private Node deleteMin(Node x){
        if(x.left==null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMax(){
        if(isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root=deleteMax(root);
        assert check();
    }

    private Node deleteMax(Node x){
        if(x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key){
        if(key==null) throw new IllegalArgumentException("argument to delete() is null");
        root = delete(root, key);
        assert check();
    }

    private Node delete(Node x, Key key){
        if(x==null) return null;

        int cmp = key.compareTo(x.key);
        if(cmp<0) x.left = delete(x.left, key);
        else if(cmp>0) x.right = delete(x.right, key);
        else{
            if(x.right==null) return x.left;
            if(x.left==null) return x.right;
            Node t = x;
            x=min(t.right);
            x.right=deleteMin(t.right);
            x.left = t.left;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    private boolean check(){
        if(!isBST())                System.out.println("Not in symmetric order");
        if(!isSizeConsistent())     System.out.println("Subtree counts not consistent");
        if(!isRankConsistent())     System.out.println("Ranks not consistent");
        return isBST() && isSizeConsistent() && isRankConsistent();
    }

    private boolean isBST(){
        return isBST(root, null, null);
    }

    private boolean isBST(Node x, Key min, Key max){
        if(x==null) return true;
        if (min != null && x.key.compareTo(min) <= 0) return false;
        if (max != null && x.key.compareTo(max) >= 0) return false;
        return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
    }


    private boolean isSizeConsistent() { return isSizeConsistent(root); }
    private boolean isSizeConsistent(Node x) {
        if (x == null) return true;
        if (x.size != size(x.left) + size(x.right) + 1) return false;
        return isSizeConsistent(x.left) && isSizeConsistent(x.right);
    }

    private boolean isRankConsistent() {
        return false;
    }
}
