package asafov.com.linkedlist;

public interface List<T> {
    int size();
    boolean isEmpty();
    boolean contains(T elem);
    T get(int index);
    T getFirst();
    T getLast();
    boolean add(T elem);
    boolean remove(T elem);
    boolean remove(int index);
}
