package src.stack;

import src.stack.exceptions.StackOverflowException;
import src.stack.exceptions.StackUnderflowException;

public class StackImpl<T> implements Stack<T> {

  private T[] stack;
  private int peek = -1;

  public StackImpl(int size) {
    this.stack = (T[]) new Object[size];
  }

  @Override
  public void push(T element) throws StackOverflowException {
    if (peek >= this.stack.length - 1) {
      throw new StackOverflowException("The Stack is full and can't store more elements");
    }

    this.peek += 1;
    this.stack[this.peek] = element;

  }

  @Override
  public T pop() throws StackUnderflowException {
    if (this.peek <= -1) {
      throw new StackUnderflowException("The Stack is empty and does not have elements to be removed.");
    }
    T removedElement = this.stack[this.peek];
    this.peek -= 1;

    return removedElement;
  }

  @Override
  public T peek() {
    if (this.peek == -1) {
      throw new StackUnderflowException("The Stack is empty and does not have a peek.");
    }
    return this.stack[this.peek];
  }

  @Override
  public boolean isEmpty() {
    return this.peek == -1;
  }

  @Override
  public boolean isFull() {
    return this.peek == this.stack.length - 1;
  }

}
