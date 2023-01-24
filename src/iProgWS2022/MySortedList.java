package iProgWS2022;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * MySortedList provides a list of sorted elements.
 * An Iterator can be used to visit all elements in increasing order
 */
public class MySortedList<T extends Object &
        Comparable<? super T>> implements Iterable<T> { // wild cards
    private T[] data; // array containing the actual data
    private int size; // also position of next element

    /**
     * Creates and returns new empty MySortedList with capacity 1
     */
    @SuppressWarnings("unchecked")
    public MySortedList() { // Constructor
        this.size = 0;
        this.data = (T[]) new Object[1];
    }
/*
    @Override
    public Iterator<T> iterator() {
        return null;
    }

 */
    /**
     * add one item into the sorted list
     * @param item
     * @return reference to list, supports cascading add operations
     */
    @SuppressWarnings("unchecked")
    public MySortedList<T> add(T item){
        if (size == data.length) { // if no free space : enlarge
            T[] newData = (T[]) new Object[2*size]; // new array of double capacity
            for (int i=0; i < size; i++){ // move data
                newData[i] = data[i];
            }
            data = newData; // change reference
        }
        int i = size;
        while (i>0 && data[i-1].compareTo(item)>0){ // insert item into sorted order
            data[i] = data[--i];
        }
        data[i] = item;
        size++;
        return this; // allowing cascading adds
    }
    /**
     * add many items into the sorted list
     * @param arr
     * @return reference to list, supports cascading add operations
     */
    public MySortedList<T> add(T[] arr){
        for (T i : arr){ // add them all
            this.add(i);
        }
        return this;
    }
    /**
     * @return size of list, number of contained items
     */
    public int size(){
        return size;
    }
    /**
     * @param index
     * @return item at index
     * @throws NoSuchElementException
     */
    public T itemAt(int index){
        if (index < 0 || index >= size) { throw new NoSuchElementException(); }
        return data[index];
    }
    public Iterator<T> iterator(){
        return new Iterator<T>(){ // anonyme Klasse implementiert Interface ...
            int index = 0; // of next element to be returned
            public boolean hasNext(){
                return index < size;
            }
            public T next(){
                if (index >= size) {
                    throw new NoSuchElementException();
                }
                return data[index++];
            }
            public void remove(){ // want to remove last element
                if (index > 0){
                    for (int i=index; i<size; i++){
                        data[i-1] = data [i];
                    }
                    index--;
                    size--;
                }
            }
        }; // end of return
    }


}
