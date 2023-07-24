package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (this.array.length == 0 || this.isFull()) {
			throw new QueueOverflowException();
		}

		if (this.isEmpty()) {
			this.head = 0;
			this.tail = 0;
			this.array[tail] = element;
		} else {
			this.tail += 1;
			this.array[this.getMod(tail)] = element;
		}
		this.elements += 1;

	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (this.isEmpty()) {
			throw new QueueUnderflowException();
		}
		T removedElement = this.array[this.head];
		this.elements -= 1;
		if (this.head == this.tail) {
			this.head = -1;
			this.tail = -1;
		} else {
			this.head += 1;
		}

		return removedElement;

	}

	@Override
	public T head() {
		if (this.isEmpty()) {
			return null;
		}
		return this.array[this.getMod(this.head)];
	}

	@Override
	public boolean isEmpty() {
		return this.elements == 0;
	}

	@Override
	public boolean isFull() {
		return this.elements == this.array.length;
	}

	private int getMod(int number) {
		return number % this.array.length;
	}

}
