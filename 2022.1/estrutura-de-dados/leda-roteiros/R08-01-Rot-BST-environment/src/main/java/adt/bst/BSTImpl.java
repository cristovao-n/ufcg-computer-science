package adt.bst;

import java.util.ArrayList;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();

	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return this.height(this.root);
	}

	private int height(BSTNode<T> current) {
		if (current.isEmpty()) {
			return -1;
		}
		int leftHeight = this.height((BSTNode<T>) current.getLeft());
		int rightHeight = this.height((BSTNode<T>) current.getRight());
		return 1 + Math.max(leftHeight, rightHeight);

	}

	@Override
	public BSTNode<T> search(T element) {
		return this.search(this.root, element);

	}

	private BSTNode<T> search(BSTNode<T> currentNode, T element) {
		if (currentNode.isEmpty()) {
			return new BSTNode<T>();
		}

		if (currentNode.getData().equals(element)) {
			return currentNode;
		}

		boolean shouldGoToTheLeft = element.compareTo(currentNode.getData()) < 0;

		if (shouldGoToTheLeft) {
			return this.search((BSTNode<T>) currentNode.getLeft(), element);
		} else {
			return this.search((BSTNode<T>) currentNode.getRight(), element);

		}

	}

	@Override
	public void insert(T element) {
		if (this.isEmpty()) {
			BSTNode<T> newNode = new BSTNode<T>();
			newNode.setData(element);

			BSTNode<T> leftNil = new BSTNode<T>();
			leftNil.setParent(newNode);
			newNode.setLeft(leftNil);

			BSTNode<T> rightNil = new BSTNode<T>();
			rightNil.setParent(newNode);
			newNode.setRight(rightNil);

			BSTNode<T> parentNil = new BSTNode<T>();
			newNode.setParent(parentNil);

			this.root = newNode;
			return;
		}
		this.insert(this.root, element);

	}

	private void insert(BSTNode<T> currentNode, T element) {
		boolean isElementSmallerThanCurrentNode = element.compareTo(currentNode.getData()) < 0;
		if (isElementSmallerThanCurrentNode && this.hasLeftChild(currentNode)) {
			this.insert((BSTNode<T>) currentNode.getLeft(), element);
			return;
		}

		if (!isElementSmallerThanCurrentNode && this.hasRightChild(currentNode)) {
			this.insert((BSTNode<T>) currentNode.getRight(), element);
			return;
		}

		BSTNode<T> newNode = new BSTNode<T>();
		newNode.setParent(currentNode);
		newNode.setData(element);

		BSTNode<T> leftNil = new BSTNode<T>();
		leftNil.setParent(newNode);
		newNode.setLeft(leftNil);

		BSTNode<T> rightNil = new BSTNode<T>();
		rightNil.setParent(newNode);
		newNode.setRight(rightNil);

		if (isElementSmallerThanCurrentNode) {
			currentNode.setLeft(newNode);
		} else {
			currentNode.setRight(newNode);
		}

	}

	@Override
	public BSTNode<T> maximum() {
		if (this.isEmpty()) {
			return null;
		}
		return this.maximum(this.root);

	}

	private BSTNode<T> maximum(BSTNode<T> current) {
		if (!this.hasRightChild(current)) {
			return current;
		}

		return this.maximum((BSTNode<T>) current.getRight());

	}

	@Override
	public BSTNode<T> minimum() {
		if (this.isEmpty()) {
			return null;
		}
		return this.minimum(this.root);

	}

	private BSTNode<T> minimum(BSTNode<T> current) {
		if (!this.hasLeftChild(current)) {
			return current;
		}

		return this.minimum((BSTNode<T>) current.getLeft());

	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> node = this.search(element);
		if (node.isEmpty()) {
			return null;
		}

		if (this.hasRightChild(node)) {
			return this.minimum((BSTNode<T>) node.getRight());
		} else {
			return this.getParentGreaterThanNode((BSTNode<T>) node.getParent(), node);
		}
	}

	private BSTNode<T> getParentGreaterThanNode(BSTNode<T> current, BSTNode<T> node) {
		if (current.isEmpty()) {
			return null;
		}
		boolean parentIsSucessor = current.getData().compareTo(node.getData()) > 0;
		if (parentIsSucessor) {
			return current;
		}
		return this.getParentGreaterThanNode((BSTNode<T>) current.getParent(), node);
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = this.search(element);
		if (node.isEmpty()) {
			return null;
		}

		if (this.hasLeftChild(node)) {
			return this.maximum((BSTNode<T>) node.getLeft());
		} else {
			return this.getParentSmallerThanNode((BSTNode<T>) node.getParent(), node);
		}
	}

	private BSTNode<T> getParentSmallerThanNode(BSTNode<T> current, BSTNode<T> node) {
		if (current.isEmpty()) {
			return null;
		}
		boolean parentIsPredecessor = current.getData().compareTo(node.getData()) < 0;
		if (parentIsPredecessor) {
			return current;
		}
		return this.getParentSmallerThanNode((BSTNode<T>) current.getParent(), node);
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = this.search(element);
		if (node.isEmpty()) {
			return;
		}
		this.remove(node);

	}

	private void remove(BSTNode<T> node) {

		if (node.isLeaf()) {
			this.removeIsLeaf(node);
		} else if (this.hasOnlyOneChild(node)) {
			this.removeHasOnlyOneChild(node);
		} else {
			this.removeHasTwoChildren(node);
		}

	}

	private void removeIsLeaf(BSTNode<T> node) {
		BSTNode<T> parent = (BSTNode<T>) node.getParent();
		boolean isRoot = parent.isEmpty();

		if (isRoot) {
			this.root = new BSTNode<T>();
			return;
		}

		boolean isLeftChild = node.getData().compareTo(parent.getData()) < 0;
		if (isLeftChild) {
			parent.setLeft(new BSTNode<T>());
		} else {
			parent.setRight(new BSTNode<T>());
		}
	}

	private void removeHasOnlyOneChild(BSTNode<T> node) {
		BSTNode<T> parent = (BSTNode<T>) node.getParent();
		boolean isRoot = parent.isEmpty();
		if (isRoot) {
			if (this.hasLeftChild(node)) {
				this.root = (BSTNode<T>) node.getLeft();
			} else {
				this.root = (BSTNode<T>) node.getRight();
			}
			this.root.setParent(new BSTNode<T>());
			return;
		}

		boolean isLeftChild = node.getData().compareTo(parent.getData()) < 0;
		if (isLeftChild) {
			if (this.hasLeftChild(node)) {
				node.getLeft().setParent(parent);
				parent.setLeft(node.getLeft());
			} else {
				node.getRight().setParent(parent);
				parent.setLeft(node.getRight());
			}
		} else {
			if (this.hasLeftChild(node)) {
				node.getLeft().setParent(parent);
				parent.setRight(node.getLeft());
			} else {
				node.getRight().setParent(parent);
				parent.setRight(node.getRight());
			}
		}
	}

	private void removeHasTwoChildren(BSTNode<T> node) {
		BSTNode<T> sucessor = this.sucessor(node.getData());
		node.setData(sucessor.getData());
		this.remove(sucessor);
	}

	private boolean hasOnlyOneChild(BSTNode<T> node) {
		return this.hasLeftChild(node) ^ this.hasRightChild(node);
	}

	private boolean hasLeftChild(BSTNode<T> node) {
		return !node.getLeft().isEmpty();
	}

	private boolean hasRightChild(BSTNode<T> node) {
		return !node.getRight().isEmpty();
	}

	@Override
	public T[] preOrder() {
		if (this.isEmpty()) {
			return (T[]) new Comparable[0];
		}

		ArrayList<T> array = new ArrayList<T>();

		this.preOrder(array, this.root);
		return (T[]) array.toArray(new Comparable[0]);
	}

	private void preOrder(ArrayList<T> array, BSTNode<T> current) {
		if (current.isEmpty()) {
			return;
		}

		array.add(current.getData());
		this.preOrder(array, (BSTNode<T>) current.getLeft());
		this.preOrder(array, (BSTNode<T>) current.getRight());

	}

	@Override
	public T[] order() {
		if (this.isEmpty()) {
			return (T[]) new Comparable[0];
		}

		ArrayList<T> array = new ArrayList<T>();

		this.order(array, this.root);
		return (T[]) array.toArray(new Comparable[0]);
	}

	private void order(ArrayList<T> array, BSTNode<T> current) {
		if (current.isEmpty()) {
			return;
		}

		this.order(array, (BSTNode<T>) current.getLeft());
		array.add(current.getData());
		this.order(array, (BSTNode<T>) current.getRight());

	}

	@Override
	public T[] postOrder() {
		if (this.isEmpty()) {
			return (T[]) new Comparable[0];
		}

		ArrayList<T> array = new ArrayList<T>();

		this.postOrder(array, this.root);
		return (T[]) array.toArray(new Comparable[0]);
	}

	private void postOrder(ArrayList<T> array, BSTNode<T> current) {
		if (current.isEmpty()) {
			return;
		}

		this.postOrder(array, (BSTNode<T>) current.getLeft());
		array.add(current.getData());
		this.postOrder(array, (BSTNode<T>) current.getRight());

	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
