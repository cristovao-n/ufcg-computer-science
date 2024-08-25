package src.stack;

import src.stack.exceptions.StackOverflowException;
import src.stack.exceptions.StackUnderflowException;

public interface Stack<T> {
  public void push(T element) throws StackOverflowException;

  public T pop() throws StackUnderflowException;

  public T peek();

  public boolean isEmpty();

  public boolean isFull();

}