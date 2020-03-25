package asafov.com.doublylinkedlist;

import asafov.com.linkedlist.List;

import java.util.Iterator;

public class DoublyLinkedList<T> implements List<T>,Iterable<T> {

    private Node first;
    private Node last;
    private int size;

    public DoublyLinkedList() {
        this.size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator(first);
    }

    private class ListIterator implements Iterator<T>{
        private Node node;
        public ListIterator(Node f) {
            this.node = f;
        }

        @Override
        public boolean hasNext() {
            return node!=null;
        }

        @Override
        public T next() {
            T elem = node.elem;
            node=node.next;
            return elem;
        }
    }

    private class Node{
        T elem;
        Node next;
        Node prev;
        public Node(T elem) {
            this.elem = elem;
        }
    }


    @Override
    public int size() {
        return this.size;
    }


    @Override
    public boolean add(T elem) {
        Node n = new Node(elem);
        if (size==0){
            first = n;
            size++;
            return true;
        }else {
            if (last==null){
                n.prev = first;
                first.next = n;
                last = n;
                size++;
                return true;
            }else {
                n.prev = last;
                last.next = n;
                last = n;
                size++;
                return true;
            }
        }
    }
    public void print(){
        System.out.println(first);
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
        if (index>=size) return null;
        if (index==0) return first.elem;
        if (index==size-1) return last.elem;
        int mid = size/2;
        if ((size-index)<=mid){//from last
            Node n = last;
            int i = size-1;
            while (index<i){
                n=n.prev;
                i--;
            }
            return n.elem;
        }else{//from first
            Node n = first;
            int i = 0;
            while (i<index){
                n=n.next;
                i++;
            }
            return n.elem;
        }
    }

    @Override
    public T getFirst() {
        if (first==null) return null;
        return first.elem;
    }

    @Override
    public T getLast() {
        if (last==null){
            if (first==null){
                return null;
            }else {
                return first.elem;
            }
        }
        return last.elem;
    }

    @Override
    public boolean remove(T elem) {
        if (size==0) return false;
        if (first.elem.equals(elem)){
            first = first.next;
            first.prev = null;
            size--;
            return true;
        }
        if (last!=null && last.elem.equals(elem)){
            last = last.prev;
            last.next = null;
            size--;
            return true;
        }
        Node n = first;
        while (n.next!=null && !n.next.elem.equals(elem)){
            n=n.next;
        }
        if (n.next!=null){
            n.next = n.next.next;
            n.next.prev = n.next;
            size--;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(int index) {
        if (index >= size) return false;
        if (index == 0) {
            first = first.next;
            if (first!=null){
                first.prev=null;
            }
            size--;
            return true;
        }
        if (index == size - 1) {
            last = last.prev;
            last.next=null;
            size--;
            return true;
        }
        int mid = size / 2;
        if ((size - index) <= mid) {//from last
            Node n = last;
            int i = size-1;
            while (index<i){
                n=n.prev;
                i--;
            }
            n.prev.next = n.next;
            n.next.prev = n.prev;
            size--;
            return true;
        }else {
            Node n = first;
            int i = 0;
            while (i<index){
                n=n.next;
                i++;
            }
            n.prev.next = n.next;
            n.next.prev = n.prev;
            size--;
            return true;
        }
    }
}
