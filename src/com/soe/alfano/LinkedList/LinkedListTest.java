package com.soe.alfano.LinkedList;



public class LinkedListTest {

	public static void main(String[] args){
		
		LinkedList list = new LinkedList();
		
		list.addFirst("String");
		list.addLast("Mid");
		list.addLast("Last");
		
		ListIterator iter = list.listIterator();
		while(iter.hasNext())
			System.out.println(iter.next());
		
		System.out.println(list.getSize());
	}
}
