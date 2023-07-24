package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		SingleLinkedListNode<T> nil = new SingleLinkedListNode<T>(); 
		this.head = new SingleLinkedListNode<T>(null, nil);
	}

	@Override
	public boolean isEmpty() {
		return this.head.next.isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> current = this.head.next;
		while (!current.isNIL()) {
			size += 1;
			current = current.next;
		}
		return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> current = this.head.next;
		while(!current.isNIL()) {
			if (current.getData().equals(element)) {
				return element;
			}
			current = current.next;
		}
		return null;
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> current = this.head;
		while (!current.next.isNIL()) {
			current = current.next;
		}
		SingleLinkedListNode<T> newElement = new SingleLinkedListNode<T>(element, current.next);
		current.next = newElement;
	}

	@Override
	public void remove(T element) {
		SingleLinkedListNode<T> current = this.head;
		while(!current.next.isNIL()) {
			if (current.next.getData().equals(element)) {
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[this.size()];
		SingleLinkedListNode<T> current = this.head.next;

		int index = 0;
		while(!current.isNIL()) {
			array[index] = current.getData();
			index += 1;
			current = current.next;
		}

		return array;

	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
