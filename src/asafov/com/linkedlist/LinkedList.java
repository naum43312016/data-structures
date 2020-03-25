package asafov.com.linkedlist;

import java.util.Iterator;

public class LinkedList<T> implements List<T>, Iterable<T> {
    private Node first;
    private Node last;
    private int size;

    public LinkedList() {
        this.size =0;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator(first);
    }

    private class ListIterator implements Iterator<T>{
        private Node node;
        public ListIterator(Node n) {
            node = n;
        }

        @Override
        public boolean hasNext() {
            return node!=null;
        }

        @Override
        public T next() {
            if (node==null) return null;
            T elem = node.elem;
            node=node.next;
            return elem;
        }
    }


    private class Node{
        T elem;
        Node next;

        public Node(T elem) {
            this.elem = elem;
        }
    }

    @Override
    public boolean add(T elem) {
        if (first==null){
            first = new Node(elem);
            size++;
            return true;
        }else if (last==null){
            last = new Node(elem);
            first.next = last;
            size++;
            return true;
        }else{
            Node node = new Node(elem);
            last.next = node;
            last=node;
            size++;
            return true;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(T elem) {
        if (size<1) return false;
        Node node = first;
        while (node!=null){
            if (node.elem.equals(elem)){
                return true;
            }
            node=node.next;
        }
        return false;
    }

    @Override
    public T get(int index) {
        if (size<1) throw new EmptyListException("Empty List");
        if (index>=size) throw new IndexOutOfBoundsException();
        if (index==size-1) return getLast();
        Node node = first;
        int i = 0;
        while (i!=index){
            i++;
            node=node.next;
        }
        return node.elem;
    }

    @Override
    public T getFirst() {
        if (first==null) return null;
        return first.elem;
    }

    @Override
    public T getLast() {
        if (last==null){
            if (first!=null){
                return first.elem;
            }else {
                return null;
            }
        }
        return last.elem;
    }


    @Override
    public boolean remove(T elem) {
        if (size<1 || first==null) throw new EmptyListException("Empty List");
        if (first.elem.equals(elem)){
            Node n = first.next;
            first = n;
            size--;
        }
        Node node = first;
        while (node.next!=null){
            if (node.next.elem.equals(elem)){
                if (node.next==last){
                    node.next = null;
                    last = node;
                    size--;
                    return true;
                }else {
                    node.next = node.next.next;
                    size--;
                    return true;
                }
            }
            node=node.next;
        }
        return false;
    }

    @Override
    public boolean remove(int index) {
        if (size<1) throw new EmptyListException("Empty List");
        if (index>=size) throw new IndexOutOfBoundsException();
        if (index==0){
            Node n = first.next;
            first = n;
            size--;
            return true;
        }
        if (index==size-1){
            return removeLast();
        }
        int i = 0;
        Node node = first;
        while (i<index-1){
            node=node.next;
            i++;
        }
        node.next = node.next.next;
        return true;
    }

    private boolean removeLast() {
        int i = 0;
        Node node = first;
        while (i<size-2){
            node=node.next;
            i++;
        }
        size--;
        node.next = null;
        last = node;
        return true;
    }
}
