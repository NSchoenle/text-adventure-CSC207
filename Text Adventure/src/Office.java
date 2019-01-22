import java.util.ArrayList;
import java.util.*;

public class Office implements Room {
	private List<Item> items;
	private Inventory invent;
	private Room east, north, south, west;

	public Office(Inventory inv) {
		
		this.items = new ArrayList<>();
		items.add(new Item ("desk"));
		items.add(new Item ("chair"));
		items.add(new Item("cabinet"));
		items.add(new Item("ghost"));
		items.add(new Item("office"));
		items.add(new Item("self"));
		items.add(new Item("phone"));
		items.add(new Item("computer"));
		items.add(new Item("keys"));
		this.invent = inv;
	}

	public Room waitCom() {
		System.out.println(
				"Seriously? You really don’t want to, but you stand around silently for another five minutes. Maybe you’re just that tired.");
		return this;
	}
	
	@Override
	public Room go(String next) {
		if (next.equalsIgnoreCase("south")) {
			System.out.println("You make your way over to the exit, and step outside. The door closes behind you. You're 20% sure it's locked but you don't care.");
			return south;
		} System.out.println("That's a wall, not a door.");
			return this;
	}
	
	@Override
	public Room talk(Item meti) {
		if (meti.getName().equalsIgnoreCase("ghost")) {
			System.out.println("Hahahahahahaha. No, let’s not.");
			return this;
		} else if (meti.getName().equalsIgnoreCase("self")) {
			System.out.println("You’re reaaaaaally tired.");
			return this;
		} else {
			System.out.println("You say 'Hey " + meti.getName() + "!' No answer.What a surprise.");
			return this;
		}
	}

	@Override
	public void pick(Item meti) {
		if (meti.getName().equalsIgnoreCase("keys")) {
			items.remove(meti);
			invent.pickUp(meti);
			System.out.println("Hey! " + "There’s a good idea! " + "You shove your keys into your pocket.");
		} else if (meti.getName().equalsIgnoreCase("phone")) {
			items.remove(meti);
			invent.pickUp(meti);
			System.out.println("Nice. Good job. You’re proud of yourself for being so coherent, "
					+ "considering the circumstances. " + "You shove your phone into your pocket.");
		} else if (meti.getName().equalsIgnoreCase("cabinet")) {

			System.out.println(" Heck no. You don’t want this piece of junk.");
		} else if (meti.getName().equalsIgnoreCase("computer")) {

			System.out.println(" One day, you will have had Enough of This Shit, "
					+ "and you’ll just steal every piece of junk in this building "
					+ "worth more than $10. But today is not that day.");
		} else {
			System.out.println(" Hmmmmm. Nah. Nuh-uh.");
		}
	}

	@Override
	public Room use(Item meti) {
		if (meti.getName().equalsIgnoreCase("phone")) {
			if (invent.containsItem(meti)) {
				System.out.println("You pull your phone out of your pocket, and open it up. You have 9% battery left. "
						+ "You have no new texts. There are a few junk apps on your main screen, and the Uber app and "
						+ "Pokemon Go (sure, it died out 4 months ago, but you gotta catch ‘em all)." 
						+ " You happen to know that the Uber drivers around here are disgusting &/or creepy. "
						+ "You would rather not call for one. You put your phone away in your pocket.");
			} else {
				System.out.println("You stare at the phone. It doesn’t do anything. So much for the force.");
			}
		} else if (meti.getName().equalsIgnoreCase("computer")) {
			System.out.println("Let it sleep. It's taken enough of your shit for one day.");
		} else if (meti.getName().equalsIgnoreCase("keys")) {
			System.out.println("You pull your keys out of your pocket and carve a tally mark into the side of your desk. You sigh and put your keys back into your pocket.");
		} else {
			System.out.println("You’re not sure what you were thinking, but it was a really dumb idea.");
		}
		return this;
	}

	@Override
	public Room attack(Item meti) {
		if (meti.getName().equalsIgnoreCase("cabinet")) {
			System.out.println(" It may be small, but you have a feeling that would be a losing battle.");
		} else if (meti.getName().equalsIgnoreCase("computer")) {
			System.out.println(" You viciously attack the computer. It’s defenseless and unaware, "
					+ "so it doesn’t see you coming. You’re gonna have to pay for that later.");
		} else if (meti.getName().equalsIgnoreCase("chair")) {
			System.out.println("Yeah, it’s not like it’s broken enough already. (You leave it alone.)");
		} else {
			System.out.println("You’re too tired to do that.");
		}
		return this;
	}

	@Override
	public void look(Item meti) {
		if (meti.getName().equalsIgnoreCase("office")) {
			System.out.println(
					"Uh, it’s actually pretty dark and eerie in here. You really hope your buddy Kal was joking "
					+ "when he said some guy hung himself in the break room years ago. Although, you’d kinda "
					+ "understand it if someone did. The donuts are always stale. ");
		} else if (meti.getName().equalsIgnoreCase("cabinet")) {
			System.out.println(
					"Yeah. You’ve never used this thing. It barely holds a children’s book, much less the stacks of "
					+ "paper your supervisor dumps on your desk on a daily basis.");
		} else if (meti.getName().equalsIgnoreCase("computer")) {
			System.out.println(
					" It’s asleep. Much like you should be. There’s bits of food stuck in the keyboard. Also much "
					+ "like you should be. That didn’t make sense. God, you need a nap.");
		} else if (meti.getName().equalsIgnoreCase("desk")) {
			System.out.println(
					"Your apartment keys and phone are sitting on the desk, next to some dumb coffee cup your "
					+ "aunt gave you for Christmas. You don’t even drink coffee. There was a pile of papers on your "
					+ "desk earlier, but you finished reading through them just now (they are all sitting in the trash bin "
					+ "next to your desk). There’s nothing in the drawers besides a few crude caricatures of your supervisor.");
		} else {
			System.out.println("You’re not sure where that’s at. Maybe you’re hallucinating.");
		}
	}

	@Override
	public void printState() {
		System.out.println("You’ve had a grueling day at work, and you really don’t wanna be here anymore. You’ve cleaned up "
				+ "your workstation (a desk that’s about a foot too short, a chair that leans too far back, and a filing cabinet made for a"
				+ " Hobbit). It’s dark outside; everyone else has been gone for at least an hour or two. The office is quiet; even your desktop"
				+ " computer is already asleep. Lucky bastard.");
	}
	@Override
	public void setRooms(Room east, Room south, Room north, Room west) {
		this.east = east;
		this.south = south;
		this.north = north;
		this.west = west;
	}
}
