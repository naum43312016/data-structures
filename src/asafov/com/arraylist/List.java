package asafov.com.arraylist;

import java.util.Comparator;


public interface List<T> extends Iterable<T> {
    /**
     * size of list
     * @return int
     */
    int size();

    /**
     * add element to list
     * @param elem element to add
     * @return true if aded
     */
    boolean add(T elem);

    /**
     * add element to specify index
     * @param elem element to add
     * @param index index of element
     * @return
     */
    boolean add(int index,T elem);

    /**
     * get element by idnex
     * @param index
     * @return
     */
    T get(int index);

    /**
     * set element to index
     * @param index
     * @param elem
     * @return
     */
    boolean set(int index,T elem);

    /**
     * check if list is empty
     * @return
     */
    boolean isEmpty();

    /**
     * index of element
     * @param elem
     * @return index
     */
    int indexOf(T elem);

    /**
     * return true if list contains elelemt
     * @param elem
     * @return
     */
    boolean contains(T elem);


    /**
     * removes ellement in index position
     * @param index
     * @return the element in index position(new element)
     */
    T remove(int index);

    /**
     * removes ellement
     * @param elem
     * @return the element (new element)
     */
    T remove(T elem);

    void sort(Comparator<? super T> c);

}