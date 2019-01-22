import java.util.*;

public class OutsideApartment implements Room {
	private List<Item> items;
	private Inventory invent;
	private Room east, north, south, west;

	public OutsideApartment(Inventory inv) {

		this.items = new ArrayList<>();
		items.add(new Item("door"));
		items.add(new Item("hallway"));
		items.add(new Item("phone"));
		items.add(new Item("keys"));
		items.add(new Item("trash"));
		items.add(new Item("battle axe"));
		items.add(new Item("door"));
		this.invent = inv;
	}

	@Override
	public Room waitCom() {
		System.out.println("You take a moment to congratulate yourself on making it back. "
				+ "That moment takes a bit too long, however, and you faint right in front of your door. "
				+ "You wake up with a piece of candy on your lap. It’s either from the old woman two doors "
				+ "down who keeps a stash of vintage candies in her purse, or it’s from the toddler that lives in"
				+ " the room across from yours. Either way, you’re touched."
				+ "You’re mostly home, mostly safe, and more than satisfied with that.");
		return null;
	}

	@Override
	public Room go(String next) {
		if (next.equalsIgnoreCase("east")) {
			System.out.println("You take a few steps down the hallway. There’s nothing over here either, and you don’t"
					+ " know why you had to come over here to know that when you could see the rest of the hallway pretty "
					+ "clearly from in front of your door. Sure, you could knock on a door, but you know for a fact that no one"
					+ " ever answers past 9’o’clock; either because they’re passed out, or drunk, or both. You make your way back over to your door.");
			return east;
		} else if (next.equalsIgnoreCase("north")) {
			System.out.println(
					"Alright, cool, you leave the building again. For some reason. Hopefully good one. You walk a little ways and then pass out from fatigue.");
			return north;
		} else if (next.equalsIgnoreCase("south")) {
			System.out.println(
					"You stride right into your door, forgetting that you didn’t get beaten to death in some dark alleyway and are not a ghost. "
							+ "Anyways, you knock yourself out.");
			System.out.println(
					"You wake up with a piece of candy on your lap. It’s either from the old woman two doors down who keeps a stash of vintage"
							+ " candies in her purse, or it’s from the toddler that lives in the room across from yours. Either way, you’re touched.");
			System.out.println("You’re mostly home, mostly safe, and more than satisfied with that.");
			return south;
		} else if (next.equalsIgnoreCase("west")) {
			System.out.println("You take a few steps down the hallway. There’s nothing over here either, and you don’t"
					+ " know why you had to come over here to know that when you could see the rest of the hallway pretty "
					+ "clearly from in front of your door. Sure, you could knock on a door, but you know for a fact that no one "
					+ "ever answers past 9’o’clock; either because they’re passed out, or drunk, or both. You make your way back over to your door.");
			return west;
		} else {
			System.out.println(
					"You decide to pick an entirely ridiculous destination. You walk about four steps in some random direction and immediately kiss pavement.");
			return this;
		}
	}

	@Override
	public Room talk(Item meti) {
		System.out.println("You think you’re gonna keep your mouth shut. It's too much effort to open it.");
		return this;
	}

	@Override
	public void pick(Item meti) {
		System.out.println("There’s nothing to pick up here.");
	}

	@Override
	public Room use(Item meti) {
		if (meti.getName().equalsIgnoreCase("phone")) {
			if (!invent.containsItem(meti)) {
				System.out.println("You don’t have your phone.");
				return this;
			} else {
				System.out.println("You pull your phone out of your pocket. It’s dead, which is okay, because "
						+ "you don’t know what you were gonna do with it anyways. You shove it back in your pocket.");
				return this;
			}
		} else if (meti.getName().equalsIgnoreCase("trash")) {
			if (!invent.containsItem(meti)) {
				System.out.println("You don’t have any trash. Ew.");
				return this;
			} else {
				System.out
						.println("You think the newspaper and junk you picked up earlier would make for a pretty cool,"
								+ " abstract door sign. You smack it onto the door. It falls. Huh. You forgot about gravity. You pick the"
								+ " papers back up; you don’t want any dirty looks from your elderly neighbors.");
				return this;
			}
		} else if (meti.getName().equalsIgnoreCase("battle axe")) {
			if (!invent.containsItem(meti)) {
				System.out.print("A what????? Why would you have that???");
				return this;
			} else {
				System.out.println(
						"Heh, nah. You like your door being reusable, and taking an axe to it would ruin that. ");
				return this;
			}
		} else if (meti.getName().equalsIgnoreCase("keys")) {
			if (!invent.containsItem(meti)) {
				System.out.print("You don’t have your keys.");
				return this;
			} else {
				System.out.println(
						"You pull your keys out of your pocket and slide them into the keyhole. In one swift motion, "
								+ "you step into your apartment, lock the door, and shove the door firmly shut behind you. You turn and jump "
								+ "at the sight of someone wielding an axe before you. Your heart is beating a bit faster now, but you calm down "
								+ "when you remember that you have a twisted sense of humor and decided to place a cardboard standee of Cannibal"
								+ " Shia Leboeuf just inside your door. You kinda hate yourself for that, but you’re also kinda proud.");
				System.out.println(
						"You flop into a beanbag chair (you can’t afford real furniture), and immediately doze off - safe and sound.");
				return null;
			}
		} else {
			System.out.println("You don’t have any of those.");
			return this;
		}
	}

	@Override
	public Room attack(Item meti) {
		if (meti.getName().equalsIgnoreCase("door")) {
			System.out.println(
					"Your anger from working ridiculous hours at work and possibly encountering a murderer bubbles up from somewhere"
							+ " not-so-deep inside you. You move to punch down the door, but you’re super weak and tired. Your fist makes a soft thud on the door "
							+ "and you faint right there. ");
		} else {
			System.out.println(
					"Your anger from working ridiculous hours at work and possibly encountering a murderer bubbles up from somewhere "
							+ "not-so-deep inside you. You whip around semi-silently in the hallway in search of something to hit, but that also makes you dizzy. "
							+ "You lose consciousness halfway to the floor.");
		}
		System.out.println(
				"You wake up with a piece of candy on your lap. It’s either from the old woman two doors down who keeps a stash of vintage"
						+ " candies in her purse, or it’s from the toddler that lives in the room across from yours. Either way, you’re touched. ");
		System.out.println("You’re mostly home, mostly safe, and more than satisfied with that.");
		return null;
	}

	@Override
	public void look(Item meti) {
		if (meti.getName().equalsIgnoreCase("door")) {
			System.out.println("Ahhhhhhhhhhhhh home. Just gotta, you know, go in it.");
		} else if (meti.getName().equalsIgnoreCase("hallway")) {
			System.out.println("It’s empty.");
		} else if (meti.getName().equalsIgnoreCase("phone")) {
			if (!invent.containsItem(meti)) {
				System.out.println("You don't have your phone");
			} else {
				System.out.println("You pull your phone out of your pocket, and turn on the screen. "
						+ "No, wait. Never mind, it’s dead. You shove the dead hunk of plastic back into your pocket. ");
			}
		} else if (meti.getName().equalsIgnoreCase("keys")) {
			if (!invent.containsItem(meti)) {
				System.out.println("You don’t have your keys. Those are kinda important for this step, buddy.");
			} else {
				System.out
						.println("You pull out your keys and look at them. You shift your vision from the keys to the "
								+ "door, and then back again. You repeat this a few times. You kinda look like a caveman about to "
								+ "discover fire, but it’s okay because the only people that know/see what you’re doing are the writers, "
								+ "and it’s their fault you’re like this.");
			}
		} else {
			System.out.println("There’s nothing there.");
		}
	}

	@Override
	public void printState() {
		System.out.println(
				"You’re finally at your apartment door! Phew! The exit on the north side of the building closed behind you when you ran in, "
						+ "so there shouldn’t be anymore danger if you were being followed.");
	}

	@Override
	public void setRooms(Room east, Room south, Room north, Room west) {
		this.east = east;
		this.south = south;
		this.north = north;
		this.west = west;
	}
}
