
/**
 *
 * A class to test the LinkedListSOLDriver
 *
 * @author Tim Callies, Jacob Wiggins
 *
 */

public class LinkedListSOLDriver {


	public static void main(String[] args) {

		LinkedListSOL<String> list = new LinkedListSOL<String>();

		//TEST 1: PrettyStr on an empty directory
		System.out.print("TEST 1: PrettyStr() on an empty Directory. Expected: {}. Actual: ");
		System.out.println(list.prettyStr());
		list.solAdd("Some");
		list.solAdd("Body");
		list.solAdd("Once");
		list.solAdd("Told");
		list.solAdd("Me");
		System.out.print("TEST 2: PrettyStr() on an empty Directory. Expected: {Some, Body, Once, Told, Me}. Actual: ");
		System.out.println(list.prettyStr());
		list.solLookup("Me");
		list.solLookup("Me");
		list.solLookup("Me");
		list.solLookup("Me");
		list.solLookup("Me");
		System.out.print("TEST 3: PrettyStr() on an empty Directory. Expected: {Me, Some, Body, Once, Told}. Actual: ");
		System.out.println(list.prettyStr());
	}
}
