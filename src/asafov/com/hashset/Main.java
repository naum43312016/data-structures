package asafov.com.hashset;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.put(10);
        set.put(5);
        set.put(5);
        set.put(6);
        set.put(7);
        set.put(8);
        set.put(82);
        set.put(18);
        set.remove(82);
        set.print();
    }
}
