/**
	An interface of a Self-Organizing list.
	A list is Self-Organizing if
	for every method that targets a given item,
		it shifts that item forward one position in the list.

    DO NOT MODIFY THIS FILE

*/

public interface SOL<E>{

	/**
	Looks up and returns an item from the list AND moves the item ahead one position in the list.

		@param  target the item to be found.
		@return the item, if it exists, null otherwise

	*/
	public E solLookup(E target);
	/**
	Adds the given item to the list.

		@param toAdd the item to be added to the list.
		@return true if successful, false otherwise.

	*/
	public boolean solAdd(E toAdd);
	/**
	returns a string that when printed gives a 'nice' list of all the items in the list.

		@return a string containing the formatted contents of the list.

	*/
	public String prettyStr();


}
