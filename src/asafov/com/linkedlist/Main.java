package asafov.com.linkedlist;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
