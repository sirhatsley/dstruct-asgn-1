/**
Represents a SOL using Java's implementation of a Linked List

@author Tim Callies, Jacob Wiggins


*/
import java.util.*;


public class LinkedListSOL<E> implements SOL<E>{
    //Note: Your implementation must provide a constructor with no input parameters.

		/**
	Looks up and returns an item from the list AND moves the item ahead one position in the list.

		@param  target the item to be found.
		@return the item, if it exists, null otherwise

	*/
	private LinkedList<E> myList;
	
	public LinkedListSOL()
	{
		myList = new LinkedList();
	}
	
	public E solLookup(E target)
	{
		int targetIndex = myList.indexOf(target);
		E current = myList.remove(targetIndex);
		if(targetIndex != 0)
		{
			myList.add(targetIndex-1, current);
		}
		else {myList.add(targetIndex, current);}
		return current;
		
		/*
		O(n)
		Since the function calls the remove/add method in Java's list,
		the big O would be identical to the greatest of those functions.
		*/
	}
	/**
	Adds the given item to the list.

		@param toAdd the item to be added to the list.
		@return true if successful, false otherwise.

	*/
	public boolean solAdd(E toAdd)
	{
		myList.add(toAdd);
		return true;
		
		/*
		O(n)
		This function only calls the add method, which already has O(n)
		*/
	}
	/**
	returns a string that when printed gives a 'nice' list of all the items in the list.

		@return a string containing the formatted contents of the list.

	*/
	public String prettyStr()
	{
		StringBuilder output = new StringBuilder("{");
		ListIterator<E> iter = myList.listIterator();
		while (iter.hasNext())
		{
			output.append(iter.next().toString());
			if(iter.hasNext()){output.append(", ");}
		}
		output.append("}");
		return output.toString();
		
		/*
		O(n)
		StringBuilder's append method is more efficient than the using the +
		operator with String manipulation, since it doesn't need to iterate
		through the string to find the end. This means that it only needs to
		iterate through each node and run constant time operations.
		*/
	}
}//class
