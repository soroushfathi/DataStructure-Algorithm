package gengeric;

public class MyClass<T>{
    private T first;
    private T last;

    public MyClass(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }
    public void setFirst(T first) {
        this.first = first;
    }
    public T getLast() {
        return last;
    }
    public void setLast(T last) {
        this.last = last;
    }
}
