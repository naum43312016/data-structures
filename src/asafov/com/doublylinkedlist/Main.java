package asafov.com.doublylinkedlist;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);
        l.remove(1);
        Iterator<Integer> i = l.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }
    }
}
