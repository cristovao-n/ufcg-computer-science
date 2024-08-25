package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
		DoubleLinkedListNode<T> firstNode = new DoubleLinkedListNode<T>();
		DoubleLinkedListNode<T> lastNode = new DoubleLinkedListNode<T>();

		firstNode.setNext(lastNode);
		lastNode.setPrevious(firstNode);

		this.head = firstNode;
		this.last = lastNode;

	}

	@Override
	public void insert(T element) {
		DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(element, this.last, this.last.previous);

		this.last.previous.next = newNode;
		this.last.previous = newNode;
	}

	@Override
	public void remove(T element) {
		DoubleLinkedListNode<T> current = this.last;
		while (!current.previous.isNIL()) {
			if (current.previous.getData().equals(element)) {
				current.previous = current.previous.previous;
				current.previous.next = current;
				return;
			}
			current = current.previous;
		}
	}

	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> firstNode = (DoubleLinkedListNode<T>) this.head;
		DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(element, (DoubleLinkedListNode<T>) firstNode.next,
				firstNode);
		((DoubleLinkedListNode<T>) firstNode.next).previous = newNode;
		firstNode.next = newNode;
	}

	@Override
	public void removeFirst() {
		if (this.isEmpty()) {
			return;
		}
		DoubleLinkedListNode<T> firstNode = (DoubleLinkedListNode<T>) this.head;
		((DoubleLinkedListNode<T>) firstNode.next.next).previous = firstNode;
		firstNode.next = firstNode.next.next;
	}

	@Override
	public void removeLast() {
		if (this.isEmpty()) {
			return;
		}

		this.last.previous.previous.next = this.last;
		this.last.previous = this.last.previous.previous;

	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
