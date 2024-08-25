package src.queue;

import src.queue.exceptions.QueueOverflowException;
import src.queue.exceptions.QueueUnderflowException;

public interface Queue<T> {
    public void enqueue(T element) throws QueueOverflowException;
    public T dequeue() throws QueueUnderflowException;
    public T head();
    public boolean isEmpty();
    public boolean isFull();
}
