package com;

import java.util.Arrays;

public class IntList {
    // intArray is private, because we want to creat ads(abstract data type)
    private int[] intArray;
    private int occupied;

    public IntList(){
        occupied = 0;
        intArray = new int[0];
    }
    /**
     * Creates an int list of given size. All members set to zero initially;
     * @param size the length of int list
     */
    public IntList(int size) {
        occupied =size;
        intArray = new int[size];
    }

    public IntList(int[] input){
        occupied = input.length;
        intArray = Arrays.copyOf(input,input.length);
    }

    /**
     * set refactor method
     * @param members (varag) list of numbers
     * @return list
     */
    public static IntList of(int... members){
        return new IntList(members);
    }

    public int get(int index){
        return intArray[index];
    }

    /**
     * @return this(refactor method)
     */
    public IntList set(int index, int var){
        if(index<0 || index>occupied)
            throw new IllegalArgumentException("Index out of bound : " + index);
        intArray[index] = var;
        return this;
    }
    private void assureCapacity(){
        if(intArray.length==occupied){
            intArray = Arrays.copyOf(intArray,intArray.length+1);
        }
    }
    /**
     * this will insert an value
     * @return return IntList to be fluent(refactor method), but it can be void,
     */
    public IntList insert(int index, int value){
        if(index<0 || index>occupied)
            throw new IllegalArgumentException("Index out of bound : " + index);
        assureCapacity();
        if (occupied - index >= 0)
            System.arraycopy(intArray, index, intArray, index + 1, occupied - index);
        set(index,value);
        occupied++;
        return this;
    }

    /**
     * TODO make remove method shrinkable
     * @param index input
     * @return value of array that has been removed
     */
    public int remove(int index) {
        if(index<0 || index>=occupied)
            throw new IllegalArgumentException("Index out of bound : " + index);
        int val = intArray[index];
        if ((occupied - 1) - index >= 0)
            System.arraycopy(intArray, index + 1, intArray, index, (occupied-1) - index);
        occupied--;
        return val;
    }
    public int removeBack(){
        return remove(0);
    }
    public int removeFront(){
        return remove(occupied - 1);
    }

    public IntList pushBack(int val){
        return insert(0,val);
    }
    public IntList pushFront(int val){
        return insert(occupied,val);
    }
    public int size(){
        return occupied;
    }
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(intArray,occupied));
    }

    public static void main(String[] args) {
        IntList intList = IntList.of(3,7,4);
        System.out.println(intList);
        intList.insert(2,11);
        intList.set(2,2);
        intList.pushBack(5).pushFront(21);
        System.out.println(intList);
        intList.remove(0);
        intList.remove(1);
        intList.remove(intList.occupied-1);
        System.out.println(intList);
    }
}