package com.soe.alfano.LinkedList;

import com.soe.alfano.LinkedList.ListIterator;
import java.util.NoSuchElementException;

public class LinkedList {

	private Node first;
	private Node last;
	private int size;
	
	/**
	 * Creates a new linked list
	 */
	public LinkedList() {
		first = null;
		last = null;
		size = 0;
	}
	
	/**
	 * Returns First Element if not null
	 * @return first.data
	 */
	public Object getFirst(){
		if ( first == null)
			throw new NoSuchElementException();
		return first.data;
	}
	
	/**
	 * Get last element from list
	 * @return
	 */
	public Object getLast(){
		if( last == null )
			throw new NoSuchElementException();
		return last.data;
	}
	
	/**
	 * Return size of List
	 * @return
	 */
	public int getSize(){
		return size;
	}
	
	/**
	 * add an Object to the first position
	 * @param obj
	 */
	public void addFirst(Object obj){
		Node newNode = new Node();
		newNode.data = obj;
		newNode.next = first;
		newNode.previous = null;
		first = newNode;
		if(last == null)
			last = first;
		size = size + 1;
	}
	
	/**
	 * Add Object at the end of the list
	 * @param obj
	 */
	public void addLast(Object obj){
		Node newNode = new Node();
		newNode.data = obj;
		newNode.next = null;

		if(last == null){
			if(first == null){
				newNode.previous = newNode;
				first.data = newNode;
				first.next = newNode;
				first.previous = null;
			}
			last = newNode;
		}
		else {
			newNode.previous = last;
			last.next = newNode;
			last = newNode;
		}		
		size = size + 1;
	}
	
	/**
	 * Remove first element from list
	 * @return
	 */
	public Object removeFirst(){
		if(first == null)
			throw new NoSuchElementException();
		Object obj = first.data;
		first = first.next;
		size = size - 1;
		return obj;
	}
	
	/**
	 * Remove last element from list
	 * @return
	 */
	public Object removeLast(){
		if(last == null)
			throw new NoSuchElementException();
		Object obj = last.data;
		last = last.previous;
		size = size -1;
		return obj;
	}
	
	/**
	 * returns new listIterator
	 * @return
	 */
	public ListIterator listIterator(){
		return new LinkedListIterator();
	}
	
	/**
	 * Private Inner ListIterator Class
	 * @author Sam
	 */
	private class LinkedListIterator implements ListIterator{
		private Node position;
		private Node previous; // Exists for remove Method, for referencing to last element
		
		public LinkedListIterator(){
			position = null;
			previous = null;
		}
		

		public boolean hasNext() {
			if(position == null)
				return first != null;
			else
				return position.next != null;
		}

		public Object next() {
			if(!hasNext())
				throw new NoSuchElementException();
			previous = position;
			if(position == null)
				position = first;
			else
				position = position.next;
			return position.data;
		}

		public void remove() {
			if(previous == position) // Twice in a row a remove executed
				throw new IllegalArgumentException();

			if(position == first)
				removeFirst();
			else
				previous.next = position.next;

			if(position == last)
				removeLast();
			else
				previous.previous = position.previous;
			position = previous;
		}

		public void set(Object e) {
			if(position == null)
				throw new NoSuchElementException();
			position.data = e;
		}

		public void add(Object e) {
			if(position == null){
				addFirst(e);
				position = first;
			}
			else {
				addLast(e);
				Node newNode = new Node();
				newNode.data = e;
				newNode.next = position.next;
				position.next = newNode;
				position = newNode;
			}
			previous = position;
		}
	}
	
	private class Node
	{
		public Object data;
		public Node next;
		public Node previous;
		
	}
}
