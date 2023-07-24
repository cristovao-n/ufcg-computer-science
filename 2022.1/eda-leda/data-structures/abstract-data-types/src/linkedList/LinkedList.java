package src.linkedList;

import src.genericDataStructure.GenericDataStructure;

public class LinkedList<T> implements GenericDataStructure<T> {
    private Node<T> firstNode = new Node<T>(null, null, null);

    public LinkedList() {
    }

    public LinkedList(T[] initialElements) {
        for (int i = 0; i < initialElements.length; i++) {
            this.add(initialElements[i]);
        }
    }

    @Override
    public void add(T element) {
        Node<T> current = this.firstNode;
        while (current.hasNextNode()) {
            current = current.getNext();
        }

        current.setNext(new Node<T>(element, current, null));

    }

    @Override
    public void add(T element, int index) {
        Node<T> targetNode = this.iterateUntilDesiredIndex(index);
        Node<T> addedNode = new Node<T>(element, targetNode.getPrevious(), targetNode);
        this.adjustNodeReferences(targetNode, addedNode);
    }

    private void adjustNodeReferences(Node<T> targetNode, Node<T> addedNode) {
        targetNode.getPrevious().setNext(addedNode);
        targetNode.setPrevious(addedNode);
    }

    @Override
    public T get(int index) {
        Node<T> targetNode = this.iterateUntilDesiredIndex(index);
        return targetNode.getValue();
    }

    @Override
    public void remove(int index) {
        Node<T> targetNode = this.iterateUntilDesiredIndex(index);

        if (targetNode.hasNextNode()) {
            targetNode.getPrevious().setNext(targetNode.getNext());
            targetNode.getNext().setPrevious(targetNode.getPrevious());
        } else {
            targetNode.getPrevious().setNext(null);
        }

    }

    private Node<T> iterateUntilDesiredIndex(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + "is invalid. Negative indexes are invalid.");
        }

        Node<T> current = this.firstNode;
        for (int i = 0; i <= index; i++) {
            if (!current.hasNextNode()) {
                throw new IndexOutOfBoundsException("Index " + index + " is out of length " + this.length());
            }
            current = current.getNext();
        }
        return current;
    }

    @Override
    public boolean contains(T element) {
        Node<T> current = this.firstNode;

        while (current.hasNextNode()) {
            current = current.getNext();
            if (current.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int length() {
        int length = 0;
        Node<T> current = this.firstNode;
        while (current.hasNextNode()) {
            current = current.getNext();
            length += 1;
        }
        return length;
    }

    @Override
    public boolean isEmpty() {
        return !this.firstNode.hasNextNode();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        Node<T> current = this.firstNode;
        while (current.hasNextNode()) {
            current = current.getNext();
            stringBuilder.append(current.toString() + ", ");

        }

        if (stringBuilder.length() > 0) {
            String lastNodeFormattedString = stringBuilder.toString().trim().substring(0,
                    stringBuilder.toString().length() - 2);

            return "[" + lastNodeFormattedString + "]";

        }

        return "[]";

    }

}
