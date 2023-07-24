package src.queue;

import src.queue.exceptions.QueueOverflowException;
import src.queue.exceptions.QueueUnderflowException;

public class QueueImpl<T> implements Queue<T> {

    private T[] queue;
    private int head;
    private int tail;

    public QueueImpl(int size) {
        this.queue = (T[]) new Object[size];
        this.head = -1;
        this.tail = -1;
    }

    @Override
    public void enqueue(T element) throws QueueOverflowException {
        // TODO Auto-generated method stub
        // Se o tail estiver atras do head, a fila tá cheia (tail = head - 1)

    }

    @Override
    public T dequeue() throws QueueUnderflowException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T head() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isFull() {
        // TODO Auto-generated method stub
        return false;
    }

}
