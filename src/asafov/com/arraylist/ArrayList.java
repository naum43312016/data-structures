package asafov.com.arraylist;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Resizable array implementation of the MyList interface
 * @author Naum Asafov
 * @param <T>
 */
public class ArrayList<T> implements List<T>,Iterable<T>{
    private Object[] data;
    private int size;
    private final int DEFAULT_CAPACITY = 2;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 5;


    /**
     * Empty list with an initial capacity of 16.
     */
    public ArrayList(){
        this.data = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Empty list with the specified initial capacity
     * @param capacity
     * @throws IllegalArgumentException
     */
    public ArrayList(int capacity){
        if (capacity > 0){
            this.data = new Object[capacity];
        }else if (capacity == 0){
            this.data = new Object[DEFAULT_CAPACITY];
        }else {
            throw new IllegalArgumentException("IllegalCapacity " + capacity);
        }
    }
    @Override
    public int size() {
        return size;
    }

    /**
     * Add element to list
     * @param elem
     * @return
     */
    @Override
    public boolean add(T elem) {
        if (size >= MAX_ARRAY_SIZE){
            throw new OutOfMemoryError("OutOfMemoryError " + size);
        }
        if (size >= data.length) increaseCapacity();
        data[size++] = elem;
        return true;
    }

    /**
     * add element to specify index
     * @param elem
     * @param index
     * @return
     */
    @Override
    public boolean add(int index,T elem) {
        if (!lenghtValidation(index)){
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException " + index + " Size " + data.length);
        }
        Object[] newData = new Object[data.length + 1];
        int i = 0;
        int y = 0;
        for(;y < newData.length;y++){
            if (y == index){
                newData[index] = elem;
                continue;
            }
            newData[y] = data[i];
            i++;
        }
        data = Arrays.copyOf(newData,newData.length);
        size++;
        return true;
    }
    /**
     * set element to specify index
     * @param elem
     * @param index
     * @return
     */
    @Override
    public boolean set(int index,T elem){
        if (!lenghtValidation(index)){
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException " + index);
        }
        data[index] = elem;
        return true;
    }

    private boolean lenghtValidation(int index){
        if (index >= data.length){
            return false;
        }else {
            return true;
        }
    }

    /**
     * increase capacity of array on half
     */
    private void increaseCapacity(){
        int oldCapacity = data.length;
        int newCapacity = oldCapacity + (oldCapacity>>1);
        if (newCapacity > MAX_ARRAY_SIZE){
            newCapacity = MAX_ARRAY_SIZE;
        }
        data = Arrays.copyOf(data,newCapacity);
    }

    /**
     * Get element of the list by idnex
     * @param index
     * @return T element
     * @throws IndexOutOfBoundsException if index >= 0
     */
    @Override
    public T get(int index) {
        if (index >= size){
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException " + index);
        }
        return (T) data[index];
    }

    /**
     * check if list is empty
     * @return
     */
    @Override
    public boolean isEmpty() {
        if (size == 0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * get index of element
     * @param elem
     * @return
     */
    @Override
    public int indexOf(T elem) {
        if (elem == null) {
            for (int i = 0; i < size; i++)
                if (data[i]==null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (elem.equals(data[i]))
                    return i;
        }
        return -1;
    }

    /**
     * check element in list
     * @param elem
     * @return
     */
    @Override
    public boolean contains(T elem) {
        return indexOf(elem) >= 0;
    }


    /**
     * removes ellement in index position
     * @param index
     * @return the element in index position(new element)
     */
    @Override
    public T remove(int index) {
        if (!lenghtValidation(index)){
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException " + index);
        }
        Object[] newData = new Object[data.length - 1];
        int i = 0;
        int y = 0;
        for (;i < data.length;i++){
            if (i == index){
                data[index] = null;
                continue;
            }
            newData[y] = data[i];
            y++;
        }
        size--;
        data = Arrays.copyOf(newData,newData.length);
        T newValue = (T) data[index];
        return newValue;
    }

    /**
     * removes ellement
     * @param elem
     * @return the element (new element)
     */
    @Override
    public T remove(T elem) {
        return remove(indexOf(elem));
    }


    /**
     * class ListIterator
     * implements Iterator
     */
    private class ListIterator implements Iterator<T>{

        private int index = 0;
        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (T) data[index++];
        }
    }
    /**
     * Iterator for list
     */
    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    @Override
    public void sort(Comparator<? super T> c) {
        Arrays.sort((T[])data,0,size,c);
    }
}