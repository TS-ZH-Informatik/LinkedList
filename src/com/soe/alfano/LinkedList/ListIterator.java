package com.soe.alfano.LinkedList;

/**
 * ListIterator interface
 * @author Sam
 * @version v0.1
 */
public abstract interface ListIterator {

	/**
	 * Check if List has an next element
	 * @return
	 */
	public abstract boolean hasNext();
	
	/**
	 * Return next element
	 * @return
	 */
	public abstract Object next();
	
	/**
	 * Remove element at the current position
	 */
	public abstract void remove() ;

	/**
	 * Set a new element at the current position
	 */
	public abstract void set(Object e);
	
	/**
	 * Add a new element to the list
	 * @param e
	 */
	public abstract void add(Object e);
}
