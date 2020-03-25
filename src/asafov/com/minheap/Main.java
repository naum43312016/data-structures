package asafov.com.minheap;

public class Main {
    public static void main(String[] args) {
        MinHeap m = new MinHeap(100);
        m.insert(5);
        m.insert(3);
        m.insert(85);
        m.insert(122);

        m.print();
    }
}
