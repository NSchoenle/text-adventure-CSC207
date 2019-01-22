
public class Command {
	private String verb;
	private Item object;
	private Room r;

	public Command(String v, String n, Room r) {
		this.verb = v;
		this.object = new Item(n);
		this.r = r;
	}

	/**
	 * Calls the appropriate commands based on the text from a parser
	 * and the current room
	 * @param inv - an inventory
	 * @return - the next room for the player to play in
	 */
	public Room doTheThing(Inventory inv) {

		if (verb.equalsIgnoreCase("wait")) {
			return r.waitCom();
		} else if (verb.startsWith("go")) {
			return r.go(object.getName());
		} else if (verb.startsWith("talk")) {
			return r.talk(object);
		} else if (verb.startsWith("pick")) {
			if (inv.containsItem(object)){System.out.println ("Check your inventory.");}
			else {r.pick(object);}
			return r;
		} else if (verb.startsWith("use")) {
			if (inv.containsItem(object)){return r.use(object);}
			else {
				System.out.println("This item you don't have, dipshit.");
				return r;
			}
		} else if (verb.startsWith("attack")) {
			return r.attack(object);
		} else if (verb.startsWith("look")) {
			r.look(object);
			return r;
		}else if (verb.startsWith("inventory")) {
			inv.printInv();
			return r;
		} else {
			System.out.println("Unidentified Command. Try again, sucker.");
			return r;
		}
	}

	public String getVerb() {
		return verb;
	}
}
