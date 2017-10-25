/**
Represents a SOL using a custom implementation of a Linked List

@author Tim Callies, Jacob Wiggins


*/
import java.util.Deque;
import java.util.LinkedList;

public class CustomSOL<E> implements SOL<E>{
    //Note: Your implementation must provide a constructor with no input parameters.
	
	private NodeBoy firstNodeBoy;
	//Head
	private NodeBoy lastNodeBoy;
	//Tail
	private int size;
	
    public CustomSOL()
	{
		firstNodeBoy=null;
		lastNodeBoy=null;
		size=0;
	}
	
	public E solLookup(E target)
	{
		NodeBoy currentNodeBoy = firstNodeBoy;
		NodeBoy oneBefore = null;
		NodeBoy twoBefore = null;
		
		boolean keepLooping = true;
		int index=0;
		while(keepLooping)
		{
			if(currentNodeBoy==null) {return null;}
			if(currentNodeBoy.getData().equals(target)) {keepLooping=false;}
			else
			{
				twoBefore=oneBefore;
				oneBefore=currentNodeBoy;
				currentNodeBoy=currentNodeBoy.getNextNode();
			}
			index++;
		}
		if(index==1)
		{
			//Doesn't change anything if the desired item is already at the
			//front of the list
			return currentNodeBoy.getData();
		}
		else if(index==2)
		{
			//Swaps the first and second items in the list, and changes the
			//first node of the list
			oneBefore.setNextNode(currentNodeBoy.getNextNode());
			currentNodeBoy.setNextNode(oneBefore);
			firstNodeBoy=currentNodeBoy;
		}
		else
		{
			//Used in most cases, moves the desired node back by one index
			twoBefore.setNextNode(currentNodeBoy);
			oneBefore.setNextNode(currentNodeBoy.getNextNode());
			currentNodeBoy.setNextNode(oneBefore);
		}
		if(index==size)
		{
			//If the target is the last item in the list, then it will change
			//the last node.
			lastNodeBoy=oneBefore;
		}
		return currentNodeBoy.getData();
		
		/*
		O(n)
		The function iterates through the nodes, and once it reaches the nodes,
		it only modifies the nodes before and after it, as well as the head/tail
		references.
		*/
	}
	/**
	Adds the given item to the list.

		@param toAdd the item to be added to the list.
		@return true if successful, false otherwise.

	*/
	public boolean solAdd(E toAdd)
	{
		NodeBoy newNodeBoy = new NodeBoy(toAdd, null);
		if(lastNodeBoy==null)
		{
			//Changes the head if the list is empty
			firstNodeBoy=newNodeBoy;
		}
		else
		{
			//Puts the new node at the end.
			lastNodeBoy.setNextNode(newNodeBoy);
		}
		lastNodeBoy=newNodeBoy;
		size++;
		return true;
		
		/*
		O(1)
		Since this particular implementation has a reference to the tail, the
		item is added to the end without needing to iterate through anything.
		*/
	}
	/**
	returns a string that when printed gives a 'nice' list of all the items in the list.

		@return a string containing the formatted contents of the list.

	*/
	public String prettyStr()
	{
            StringBuilder output = new StringBuilder("{");
            NodeBoy currentNode = firstNodeBoy;
            while(currentNode!=null)
            {
                    //Loops through the list and adds each string to the output
                    output.append(currentNode.getData().toString());
                    currentNode=currentNode.getNextNode();
                    if (currentNode!=null)
                    {
                            //Adds a comma for formatting
                            output.append(", ");
                    }
            }
            output.append("}");
            return output.toString();

            /*
            O(n)
            StringBuilder's append method is more efficient than the using the +
            operator with String manipulation, since it doesn't need to iterate
            through the string to find the end. This means that it only needs to
            iterate through each node and run constant time 
            */
    }
    /**
    For each item in the list, create a copy of it.

    */
    public void duplicate()
    {
            NodeBoy currentNode=firstNodeBoy;
            while(currentNode!=null)
            {
                    //Sets the next node (for each node) to an identical node that points to the next node
                    currentNode.setNextNode(new NodeBoy(currentNode.getData(),currentNode.getNextNode()));
                    currentNode=currentNode.getNextNode().getNextNode();
            }

            /*
            O(n)
            This method performs 2 operations (which run under constant time) for
            each node in the list.
            */
    }
    /**
    For each item in the list, if there is a copy or copies adjacent to the item, delete the copies.

    */
    public void collapse()
    {
            NodeBoy currentNode=firstNodeBoy;
            boolean keepSearching;
            while(currentNode!=null)
            {
                    keepSearching=false;
                    if (currentNode.nextNode!=null)
                    {
                            //Checks if the next node is null, then checks if they have the same data
                            if (currentNode.getData().equals(currentNode.getNextNode().getData()))
                            {
                                    keepSearching=true;
                            }
                    }
                    while(keepSearching)
                    {
                            //Repeatedly removes subsequent nodes that have identical data to the current node.
                            currentNode.setNextNode(currentNode.getNextNode().getNextNode());

                            keepSearching=false;
                            if (currentNode.nextNode!=null)
                            {
                                    //Checks if the next node is null, then checks if they have the same data
                                    if (currentNode.getData().equals(currentNode.getNextNode().getData()))
                                    {
                                            keepSearching=true;
                                    }
                            }
                    }
                    currentNode=currentNode.getNextNode();
            }

            /*
            O(n)
            This function will only iterate through each node once. It removes references
            to copied nodes before continuing to iterate, so it does not repeat itself.
            */
	}
        
        /*
        Takes the entire list and reverses it.
        */
        public void reverse()
        {
            Deque<NodeBoy> myStack = new LinkedList<NodeBoy>();
            if(size>1)
            {
                for(int i=0; i<size-1; i++)
                {
                    //Takes every element in the list (except the tail) and
                    //places it in a stack.
                    myStack.push(firstNodeBoy);
                    firstNodeBoy=firstNodeBoy.nextNode;
                }
                NodeBoy thisNode;
                while(myStack.size()>0)
                {
                    //Starting from the tail, rebuilds the list.
                    thisNode=myStack.pop();
                    lastNodeBoy.setNextNode(thisNode);
                    lastNodeBoy=thisNode;
                }
                lastNodeBoy.setNextNode(null);
            }
            /*
            O(n)
            This function only uses references to head and tail, so it only has
            to iterate through the list once to take it apart, and once to put
            it back together.
            */
        }

	private class NodeBoy
	{
		/*
		Inner class which defines a Node object, which will exclusively be used
		in this class.
		*/
		private E data;
		private NodeBoy nextNode;
		
		public NodeBoy(E data, NodeBoy nextNode)
		{
			this.data=data;
			this.nextNode=nextNode;
		}
		
		public NodeBoy getNextNode()
		{
			return nextNode;
		}
		
		public E getData()
		{
			return data;
		}
		
		public void setNextNode(NodeBoy nextNode)
		{
			this.nextNode=nextNode;
		}
	}
}//class
