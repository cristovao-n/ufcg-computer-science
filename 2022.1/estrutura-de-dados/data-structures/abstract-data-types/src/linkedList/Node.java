package src.linkedList;

public class Node<T> {
    private Node<T> next;
    private Node<T> previous;
    private T value;

    public Node(T value, Node<T> previous, Node<T> next) {
        this.value = value;
        this.previous = previous;
        this.next = next;
    }

    public boolean hasNextNode() {
        return this.next != null;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(Node<T> node) {
        this.next = node;
    }

    public Node<T> getPrevious() {
        return this.previous;
    }

    public void setPrevious(Node<T> node) {
        this.previous = node;
    }

    public T getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        /*
         * We can't downcast the Object to the generic type T. If we try
         * to execute the .equals of T passing an Object as argument, it'll
         * always return false.
         * To solve that I had to parse both objects
         * to String and use the .equals of String.
         */
        return this.value.toString().equals(o.toString());

    }

    @Override
    public String toString() {
        return this.value.toString();
    }

}
