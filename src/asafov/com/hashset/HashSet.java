package asafov.com.hashset;

public class HashSet<T> {

    private Node[] table = new Node[INITIAL_CAPACITY];
    private int size;
    private static int INITIAL_CAPACITY = 16;
    private static int MAXIMUM_CAPACITY = 1 << 30;
    public HashSet() {
        this.size = 0;
    }

    private class Node<E>{
        T val;
        int hash;
        Node next;

        public Node(T v,int h) {
            this.val = v;
            this.hash = h;
        }

        @Override
        public boolean equals(Object obj) {
            Node node = (Node) obj;
            if (this.val.equals(node.val) && this.hash==node.hash){
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public void put(T elem){
        if (table.length>=Integer.MAX_VALUE-1) throw new OutOfMemoryError();
        if (size>=table.length-1){
            reHash();
        }
        int hash = getHash(elem);
        int cell = getCell(hash);
        Node node = new Node(elem,hash);
        put(node,cell);
        size++;
    }

    private void reHash() {
        Node[] newTable = new Node[table.length*2];
        for (int i=0;i<table.length;i++){
            if (table[i]!=null){
                Node n = table[i];
                while (n!=null){
                    int hash = n.hash;
                    Node node = new Node(n.val,hash);
                    int cell = hash % newTable.length;
                    if (newTable[cell]==null){
                        newTable[cell] = node;
                    }else{
                        Node t = newTable[cell];
                        while (t!=null){
                            if (t.equals(node)) return;
                            t=t.next;
                        }
                        node.next = newTable[cell];
                        newTable[cell] = node;
                    }
                    n=n.next;
                }
            }
        }
        table = newTable;
    }

    public boolean contains(T elem){
        int hash = getHash(elem);
        int cell = getCell(hash);
        Node n = table[cell];
        while (n!=null){
            if (elem.equals(n.val) && hash==n.hash){
                return true;
            }
            n=n.next;
        }
        return false;
    }

    public boolean remove(T elem){
        int hash = getHash(elem);
        int cell = getCell(hash);
        Node n = table[cell];
        if (n!=null){
            if (elem.equals(n.val) && hash==n.hash){
                table[cell] = n.next;
                size--;
                return true;
            }
        }
        while (n.next!=null){
            if (elem.equals(n.next.val) && hash==n.next.hash){
                n.next = n.next.next;
                size--;
                return true;
            }
            n=n.next;
        }
        return false;
    }

    private void put(Node node,int cell){
        if (table[cell]==null){
            table[cell] = node;
        }else{
            Node t = table[cell];
            while (t!=null){
                if (t.equals(node)) return;
                t=t.next;
            }
            node.next = table[cell];
            table[cell] = node;
        }
    }

    public void print(){
        for (int i = 0;i<table.length;i++){
            if (table[i]!=null){
                System.out.println(table[i]);
            }
        }
    }

    private int getHash(T elem){
        return elem.hashCode();
    }
    private int getCell(int hash){
        return hash % table.length;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return size==0;
    }
}
