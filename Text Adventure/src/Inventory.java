import java.util.*;

public class Inventory {
	private List<String> ls;
	private int sz;

	public Inventory() {
		this.ls = new ArrayList<>();
		this.sz = 0;
	}
/**
 * Adds item to inventory
 * @param item - item to add
 */
	public void pickUp(Item item) {
		String it = item.getName();
		if (!ls.contains(it)){
			ls.add(it);
			sz++;
		}
	}
/**
 * Removes item from inventory
 * @param item - item to remove
 */
	public void removeItem(Item item) {
		ls.remove(item.getName());
		sz--;
	}
/**
 * Checks if inventory has the item
 * @param item - the item to look for
 * @return - boolean of whether or not the item is in the inventory
 */
	public boolean containsItem(Item item) {
		return ls.contains(item.getName());
	}

	public int getSz() {
		return sz;
	}

	public List<String> getLs() {
		return ls;
	}
	/**
	 * Prints the items in the inventory (one per line)
	 */
	public void printInv(){
		for (int i = 0; i<sz; i++){
			System.out.println(ls.get(i));
		}
	}

}
