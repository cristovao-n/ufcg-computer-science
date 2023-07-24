package src.genericDataStructure;

public interface GenericDataStructure<T> {
    public void add(T element);

    public void add(T element, int index);

    public T get(int index);

    public void remove(int index);

    public boolean contains(T element);

    public int length();

    public boolean isEmpty();
}