
public class Parser {
	private String text;

	public Parser() {
		this.text = "";
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
/**
 * Parses commands given by the user 
 * @param r - the current room
 * @return - A command containing the appropriate verb and object for the room
 */
	public Command parse(Room r) {
		String t = text.toLowerCase();
		if (t.equalsIgnoreCase("wait")) {
			return new Command("wait", "", r);
		} else if (t.startsWith("go")) {
			return new Command("go", t.substring(3), r);
		} else if (t.startsWith("talk to")) {
			return new Command("talk", t.substring(8), r);
		} else if (t.startsWith("pick up")) {
			return new Command("pick", t.substring(8), r);
		} else if (t.startsWith("use")) {
			return new Command("use", t.substring(4), r);
		} else if (t.startsWith("attack")) {
			return new Command("attack", t.substring(7), r);
		} else if (t.startsWith("look at")) {
			return new Command("look", t.substring(8), r);
		} else if (t.startsWith("inventory")) {
			return new Command("inventoryCheck", "",r);
		} else {
			return new Command("", "", r);
		}
	}
}
