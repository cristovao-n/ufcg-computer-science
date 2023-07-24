package adt.linkedList;

import java.util.ArrayList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {
		this.data = null;
		this.next = null;
	}

	public RecursiveSingleLinkedListImpl(T element, RecursiveDoubleLinkedListImpl<T> next) {
		this.data = element;
		this.next = next;
	}


	@Override
	public boolean isEmpty() {
		return this.next == null;
	}

	@Override
	public int size() {
		if (this.isEmpty()) {
			return 0;
		}
		return this.next.size() + 1;
	}

	@Override
	public T search(T element) {
		if (element.equals(this.data)) {
			return element;
		}
		if (this.isEmpty()) {
			return null;
		}
		return this.next.search(element);
	}

	@Override
	public void insert(T element) {
		if (this.isEmpty()) {
			RecursiveSingleLinkedListImpl<T> newNode = new RecursiveSingleLinkedListImpl<T>(element, null);
			this.next = newNode;
			return;
		}
		this.next.insert(element);

	}

	@Override
	public void remove(T element) {
		RecursiveSingleLinkedListImpl<T> nextNode = this.next;
		if (nextNode == null) {
			return;
		}
		if (nextNode.data.equals(element)) {
			this.next = nextNode.next;
			return;
		}
		nextNode.remove(element);
	}

	@Override
	public T[] toArray() {
		ArrayList<T> array = new ArrayList<T>();
		return this.toArray(array);
	}

	private T[] toArray(ArrayList<T> array) {
		if (this.isEmpty()) {
			return (T[]) array.toArray();
		}
		array.add(this.next.data);
		return this.next.toArray(array);

	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
