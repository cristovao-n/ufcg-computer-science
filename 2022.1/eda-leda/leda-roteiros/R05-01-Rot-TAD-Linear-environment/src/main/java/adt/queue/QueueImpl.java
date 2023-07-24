package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		if (this.isEmpty()) {
			return null;
		}

		return this.array[0];

	}

	@Override
	public boolean isEmpty() {
		return this.tail == -1;
	}

	@Override
	public boolean isFull() {
		return this.tail == this.array.length - 1;
	}

	private void shiftLeft() {
		for (int i = 0; i < this.array.length - 1; i++) {
			this.array[i] = this.array[i+1];
		}
		this.tail -= 1;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		boolean queueIsFull = this.tail == this.array.length - 1;
		if (queueIsFull) {
			throw new QueueOverflowException();
		}

		this.array[++this.tail] = element;

	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (this.tail == -1) {
			throw new QueueUnderflowException();
		}
		T removedElement = this.array[0];
		this.shiftLeft();
		return removedElement;
	}

}
