package jcha224_pr2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Represents a basic Queue.
 * @author John Chang
 * @version Autumn 2016
 * @param <E> is of any object type
 */
public class MyQueue<E> implements Iterable<E> {

	/**
	 * Default size of MyQueue.
	 */
	public static final int SIZE = 50;
	
	/**
	 * Array used to represent MyQueue.
	 */
	private E[] myList;
	
	/**
	 * Represents the first index.
	 */
	private int myFirst;
	
	/**
	 * Represents the last index.
	 */
	private int myLast;
	
	/**
	 * Represents the size of list.
	 */
	private int mySize;
	
	/**
	 * Default constructor of MyQueue.
	 */
	@SuppressWarnings("unchecked")
	public MyQueue() {
		myList = (E[]) new Object[SIZE];
		myFirst = -1;
		myLast = -1;
		mySize = 0;
	}
	
	/**
	 * Returns whether the list is empty.
	 * @return true if empty false otherwise.
	 */
	public boolean isEmpty() {
		return mySize == 0;
	}
	
	/**
	 * Returns whether the list is full.
	 * @return true if list is full false otherwise.
	 */
	public boolean isFull() {
		return mySize == SIZE;
	}
	
	/**
	 * Returns the number of values contained in this list.
	 * @return size of list.
	 */
	public int getSize() {
		return mySize;
	}
	
	/**
	 * Adds to the end of the list.
	 * @throws IllegalArgumentExeception when list is full.
	 */
	public void enqueue(E theElement) {
		if(this.isFull()) {
			throw new IllegalArgumentException();
		}
		if(this.isEmpty()) {
			myFirst++;
		}
		mySize++;
		myLast++;
		myList[myLast % SIZE] = theElement;
	}
	
	/**
	 * Removes from the front of the list.
	 * @throws NoSuchElementException when list is empty
	 */
	public E dequeue() {
		if(this.isEmpty()) {
			throw new NoSuchElementException();
		}
		myFirst++;
		mySize--;
		return myList[(myFirst - 1) % SIZE];
	}

	/**
	 * Returns an iterator for this list.
	 * @return the iterator for this list.
	 * {@inheritDoc}
	 */
	@Override
	public Iterator<E> iterator() {
		return new MyIterator();
	}

	private class MyIterator implements Iterator<E> {

		/**
		 * The position of iterator.
		 */
		private int myPosition;
		
		/**
		 * Constructs an Iterator for this list.
		 */
		public MyIterator() {
			myPosition = myFirst;
		}
		
		/**
		 * Returns whether there are more list elements.
		 * @return true if there are more elements false otherwise.
		 * {@inheritDoc}
		 */
		@Override
		public boolean hasNext() {
			return myPosition <= myLast && myPosition != -1;
		}

		/**
		 * Returns the next element in the list.
		 * @return the next element.
		 * @throws NoSuchElementException() when there is no next element.
		 */
		@Override
		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			myPosition++;
			return myList[(myPosition - 1) % SIZE];
		}
		
		/**
		 * This method is inapplicable for this list.
		 * @throws IllegalArgumentException when remove is attempted.
		 * @see java.util.Iterator#remove()
		 */
		@Override
		public void remove() {
			throw new IllegalArgumentException();
		}
	}
}
