
/**
 *
 * A class to test the CustomSOL class
 *
 *
 * @author Tim Callies, Jacob Wiggins
 *
 */

public class CustomSOLDriver {



	public static void main(String[] args) {

		CustomSOL<String> list = new CustomSOL<String>();

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
		list.duplicate();
		System.out.print("TEST 4: PrettyStr() on an empty Directory. Expected: {Me, Me, Some, Some, Body, Body, Once, Once, Told, Told}. Actual: ");
		System.out.println(list.prettyStr());
		list.collapse();
		System.out.print("TEST 5: PrettyStr() on an empty Directory. Expected: {Me, Some, Body, Once, Told}. Actual: ");
		System.out.println(list.prettyStr());
	}

}
