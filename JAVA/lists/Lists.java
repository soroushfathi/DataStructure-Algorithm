package lists;

public interface Lists<T> {
    T get(int index);
    /**
     * this will insert an value
     * @return return IntList to be fluent(refactor method), but it can be void,
     */
    Lists<T> insert(int index, T value);
    Lists<T> of(T... members);
    int size();
    Lists<T> add(T value);
    /**
     * TODO make remove method shrinkable
     * @param index input
     * @return value of array that has been removed
     */
    T remove(int index);
    Lists<T> pushBack(T index);
    Lists<T>  pushFront(T index);
    T removeBack();
    T removeFront();
    void assureCapacity();
}
