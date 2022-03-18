package lists;

import java.util.Arrays;

public class DynamicArray<T> implements Lists<T> {
    private Object[] array;
    private int occupied = 0;

    public DynamicArray() {
        array = new Object[0];
    }
    public DynamicArray(int size) {
        occupied = size;
        array = new Object[size];
    }

    public DynamicArray(Object[] objs){
        occupied = objs.length;
        array = Arrays.copyOf(objs, objs.length);
    }

    @SafeVarargs
    @Override
    public final Lists<T> of(T... members) {
        return new DynamicArray<T>(members);
    }

    @Override
    public T get(int index) {
        return (T)array[index];
    }

    @Override
    public Lists<T> add(T value) {
        assureCapacity();
        array[occupied] = value;
        occupied++;
        return this;
    }

    @Override
    public Lists<T> insert(int index, T value) {
        if(index<0 || index>occupied)
            throw new IllegalArgumentException("Index out of bound : " + index);
        assureCapacity();
        if (occupied - index >= 0)
            System.arraycopy(array, index, array, index + 1, occupied - index);
        array[index] = value;
        occupied++;
        return this;
    }

    @Override
    public T remove(int index) {
        if(index<0 || index>=occupied)
            throw new IllegalArgumentException("Index out of bound : " + index);
        T val = (T) array[index];
        if ((occupied - 1) - index >= 0)
            System.arraycopy(array, index + 1, array, index, (occupied-1) - index);
        occupied--;
        return val;
    }

    @Override
    public Lists<T> pushBack(T value) {
        return insert(0, value);
    }

    @Override
    public Lists<T> pushFront(T value) {
        return insert(occupied,value);
    }

    @Override
    public void assureCapacity() {
        if(array.length==occupied)
            array = Arrays.copyOf(array,array.length+1);
    }
    @Override
    public int size(){
        return occupied;
    }

    @Override
    public T removeBack() {
        return remove(0);
    }

    @Override
    public T removeFront() {
        return remove(occupied-1);
    }

    @Override
    public String toString() {
        return "DynamicArray{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    public static void main(String[] args) {
        DynamicArray<Integer> intList = new DynamicArray<>();
        intList.add(7).add(4).add(5);
        intList.insert(2, 11);
        intList.pushBack(10).pushFront(21);
        intList.remove(1);
        System.out.println(intList.toString());
    }
}
