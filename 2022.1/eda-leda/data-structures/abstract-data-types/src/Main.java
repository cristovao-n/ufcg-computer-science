package src;

import src.stack.StackImpl;
import src.stack.Stack;

public class Main {
  public static void main(String[] args) {
    Stack<Integer> stack = new StackImpl<Integer>(5);

    System.out.println(stack.isEmpty());
    System.out.println(stack.isFull());

    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);

    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    stack.push(5);
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());

  }
}