package asafov.com.queue;

public class Queue<T> {
    private int size;
    private Node first;
    private Node last;
    public Queue() {
        this.size = 0;
    }

    private class Node{
        T elem;
        Node next;

        public Node(T elem) {
            this.elem = elem;
        }
    }

    public void add(T elem){
        if (first==null){
            first = new Node(elem);
        }else if (last==null){
            last = new Node(elem);
            first.next=last;
        }else {
            Node n = new Node(elem);
            last.next = n;
            last = n;
        }
        size++;
    }

    public T poll(){
        if (first==null) return null;
        T elem = first.elem;
        first = first.next;
        if (first==last){
            last=null;
        }
        size--;
        return elem;
    }

    public T peek(){
        if (first==null) return null;
        return first.elem;
    }

    public int size(){
        return this.size;
    }
}
