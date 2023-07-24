package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {

		try {
			this.stack1.push(element);
		} catch (StackOverflowException exception) {
			throw new QueueOverflowException();
		}

	}

	@Override
	public T dequeue() throws QueueUnderflowException {

		if (this.isEmpty()) {
			throw new QueueUnderflowException();
		}

		try {

			this.transferToStack2();
			T removedElement = this.stack2.pop();
			this.transferToStack1();
			return removedElement;

		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public T head() {
		this.transferToStack2();
		T headElement = this.stack2.top();
		this.transferToStack1();
		return headElement;
	}

	@Override
	public boolean isEmpty() {
		return this.stack1.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.stack1.isFull();
	}

	private void transferToStack2() {
		try {
			while (!this.stack1.isEmpty()) {
				T element = this.stack1.pop();
				this.stack2.push(element);
			}
		} catch (Exception e) {
		}
	}

	private void transferToStack1() {
		try {
			while (!this.stack2.isEmpty()) {
				T element = this.stack2.pop();
				this.stack1.push(element);
			}
		} catch (Exception e) {
		}
	}

}
