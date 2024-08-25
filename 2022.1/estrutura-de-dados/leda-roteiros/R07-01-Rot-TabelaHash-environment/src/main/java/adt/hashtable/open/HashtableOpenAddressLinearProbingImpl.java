package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		for (int i = 0; i < this.table.length; i++) {
			int elementHash = ((HashFunctionLinearProbing) this.hashFunction).hash(element, i);
			if (this.table[elementHash] == null || this.table[elementHash].equals(element) ||
					this.table[elementHash].equals(this.deletedElement)) {
				this.table[elementHash] = element;
				this.elements += 1;
				return;
			}
			this.COLLISIONS += 1;

		}
	}

	@Override
	public void remove(T element) {
		for (int i = 0; i < this.table.length; i++) {
			int elementHash = ((HashFunctionLinearProbing) this.hashFunction).hash(element, i);
			if (this.table[elementHash] != null && this.table[elementHash].equals(element)) {
				this.table[elementHash] = this.deletedElement;
				this.elements -= 1;
				return;
			}
		}
	}

	@Override
	public T search(T element) {
		for (int i = 0; i < this.table.length; i++) {
			int elementHash = ((HashFunctionLinearProbing) this.hashFunction).hash(element, i);
			if (this.table[elementHash] != null && this.table[elementHash].equals(element)) {
				return (T) this.table[elementHash];
			}
		}
		return null;
	}

	@Override
	public int indexOf(T element) {
		for (int i = 0; i < this.table.length; i++) {
			int elementHash = ((HashFunctionLinearProbing) this.hashFunction).hash(element, i);
			if (this.table[elementHash] != null && this.table[elementHash].equals(element)) {
				return elementHash;
			}
		}
		return -1;
	}

}
