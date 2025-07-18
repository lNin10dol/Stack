package org.example;


import com.sun.source.tree.ArrayAccessTree;

import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.util.*;

class ArrayStack<T> implements Iterable<T>{

    private T[] array;
    private int size;



    @SuppressWarnings("unchecked")
    public ArrayStack(int initialCapacity){
        this.array = (T[]) new Object[initialCapacity];
        this.size = 0;
    }
    public void push(T item){
        if(size == array.length){
            resize(2 * array.length);
        }
        array[size++] = item;

    }
    public void resize(int newCapacity){
        T[] newArray = (T[]) new Object[newCapacity];
        System.arraycopy(array,0,newArray,0,size);
        array = newArray;
    }
    public T pop(){
        if(isEmpty()){
            throw new NoSuchElementException("Stack overflow");
        }
        T item = (T) array[size - 1];
        array[size] = null;
        return item;
    }
    public T peek(){
        if(isEmpty()){
            throw new NoSuchElementException("Stack overflow");
        }
        return (T) array[size - 1];
    }



    public boolean isEmpty(){
        return size == 0;
    }





    public  Iterator<T> iterator(){
        return new ArrayStackIterator<>();


    }
    public class ArrayStackIterator<T> implements Iterator<T> {
        private int current = size - 1;


        @Override
        public boolean hasNext()
        {

            return current >= 0 ;
        }
        @Override
        public T next() {
            if (!hasNext()) {
                System.out.println("Pusto");
            }

            return (T) array[current--];
        }
        @Override
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }






}







public class Main {
    public static void main(String[] args)
    {
        ArrayStack<Integer> arrayStack = new ArrayStack<>(5);
        arrayStack.push(2);
        arrayStack.push(4);
        arrayStack.push(6);
        System.out.println(arrayStack.peek());
        for(Integer item : arrayStack){
            System.out.println(item);
        }





    }

}