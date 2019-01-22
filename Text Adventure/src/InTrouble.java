import java.util.*;

public class InTrouble implements Room {
	private List<Item> items;
	private Inventory invent;
	private Room east, north, south, west;

	public InTrouble(Inventory inv) {

		this.items = new ArrayList<>();
		items.add(new Item("large man"));
		items.add(new Item("alley"));
		items.add(new Item("window"));
		items.add(new Item("phone"));
		items.add(new Item("keys"));
		this.invent = inv;
	}

	@Override
	public Room waitCom() {
		System.out.println("You wait quietly for him to finish rifling through your belongings."
				+ " He snorts when he’s finished, cuz you haven’t got jack shit on you. He saunters "
				+ "away down the street, takes a turn, and then you’re alone on the sidewalk, listening "
				+ "to the applause of the crowd of Dancing With The Stars.");
		items.remove("large man");
		return this;
	}

	@Override
	public Room go(String next) {
		if (next.equalsIgnoreCase("east")) {
			if (items.contains("large man")) {
				System.out.println("You’re gonna just… wait here with your new frenemy.");
				return this;
			} else { // ——> Go to room: Outside apartment
				System.out.println("You book it back to your apartment.");
				return east;
			}
		} else if (next.equalsIgnoreCase("north")) {
			if (items.contains("large man")) {
				System.out.println("You’re gonna just… wait here with your new frenemy.");
				return this;
			} else { // —> Go to room: Quiet Alley
				System.out.println("You step into the alleyway.");
				return north;
			}
		} else if (next.equalsIgnoreCase("west")) {
			if (items.contains("large man")) {
				System.out.println("You’re gonna just… wait here with your new frenemy.");
				return this;
			} else {
				System.out.println("No. Nuh-uh. The guy JUST walked that way. You might never go west again.");
				return west;
			}
		} else {
			if (items.contains("large man")) {
				System.out.println("You’re gonna just… wait here with your new frenemy.");
				return this;
			} else {
				System.out.println("You are sooooo mentally unstable right now. You walk about four steps in some "
						+ "random direction and immediately kiss pavement.");
				System.out.println(
						"Congrats! You fainted from fatigue! Later, you’ll wake up in the back of a truck with some sticky, black substance on your face (you hope"
								+ " it’s melted black licorice), surrounded by people speaking a language you don’t understand. You obviously didn’t make it home, and you obviously aren’t safe.");
				return null;
			}
		}
	}

	@Override
	public Room talk(Item meti) {
		if (meti.getName().equalsIgnoreCase("large man")) {
			System.out.println("“So, uh, is that a gun in your pocket or are you just happy to see me?”");
			System.out.println(
					"He stares at you for a moment, then shoves a hand into his pocket, and takes out- Oh. OOH. THAT’S A GUN. OOOOOH NOOOO, THAT’S A GUN.");
			System.out.println(
					"You faint on the spot. Later, you’ll wake up in the back of a truck with some sticky, black substance on your face (you hope it’s melted black licorice),"
							+ " surrounded by people speaking a language you don’t understand. You obviously didn’t make it home, and you obviously aren’t safe.");
			return null;
		} else {
			System.out.println("You think you’re gonna keep your mouth shut.");
			return this;
		}
	}

	@Override
	public void pick(Item meti) {
		if (items.contains("large man")) {
			System.out.println("You wouldn’t dare move while this guy still has functioning eyes, ears, and a nose.");
		} else {
			System.out.println("There’s nothing to pick up here.");
		}
	}

	@Override
	public Room use(Item meti) {
		if (meti.getName().equalsIgnoreCase("phone")) {
			if (!invent.containsItem(meti)) {
				System.out.println("What phone? :-]");
				return this;
			} else {
				System.out.println("You have no idea where it is now.");
				return this;
			}
		} else if (meti.getName().equalsIgnoreCase("keys")) {
			if (!invent.containsItem(meti)) {
				System.out.println("What keys? :-]");
				return this;
			} else {
				if (!invent.containsItem(meti)) {
					System.out.println("You don’t know where your keys are.");
					return this;
				} else {
					System.out.println("Sure, you could stand in the street and pretend to drive away in a car without "
							+ "your apartment keys, but you’re not really in the mood. Your keys are in the alley.");
					return this;
				}
			}
		} else {
			System.out.println(
					"You had a dumb idea that you scrap immediately, and you can’t even blame it on a concussion.");
			return this;
		}
	}

	@Override
	public Room attack(Item meti) {
		if (meti.getName().equalsIgnoreCase("large man")) {
			System.out.println(
					"You try to throw a punch at the thug. You miss horribly. You probably got so excited that you forgot you "
							+ "were beat tired and need a nap. The guy helps you fulfill your goal of a nice long rest by smashing your face in. ");
			System.out.println(
					"You wake up much later in a hospital bed with a broken nose and, like, 6 black eyes, probably. You aren’t sure. You’re gonna be here for a while.");
			return null;
		} else {
			System.out.println(
					"You swing your arms at some invisible object. The man is confused, and then just perturbed. He backs "
							+ "off of you a few steps, and then saunters away down the street, takes a turn, and then you’re alone on the sidewalk, "
							+ "listening to the applause of the crowd of Dancing With The Stars.");
			items.remove("large man");
			return this;
		}
	}

	@Override
	public void look(Item meti) {
		if (meti.getName().equalsIgnoreCase("large man")) {
			System.out.println("He’s got a squinty eye and a huge jaw. Christ, this guy probably chews on"
					+ " jawbreakers like they’re marshmallows. You figure the squinty eye is a side effect of the"
					+ " drugs that this guy probably beats out of his victims. / You figure you should try to memorize "
					+ "this guy’s face. Oh, wait, he’s not here anymore.");
		} else if (meti.getName().equalsIgnoreCase("alley")) {
			System.out.println(
					"The guy in the alley isn’t making anymore noises. You hope that just means he fell asleep. ");
		} else if (meti.getName().equalsIgnoreCase("window")) {
			System.out.println(
					"You spit in the direction of the window. “Mr. T didn’t deserve to win anyways,” you mumble to yourself.");
		} else {
			System.out.println("You blink and decide you're going insane.");
		}
	}

	@Override
	public void printState() {
		System.out.println(
				"Wow, you’re much better at stealth in video games. The not-hulk is standing on the sidewalk, staring at you with "
						+ "suspicion. He figures you heard everything going down in the alley, but since you didn’t call police or anything, he thinks you’re "
						+ "either nuts or you don’t have a phone on you.");
		if (!invent.containsItem(new Item("phone"))) {
			System.out.println("He is right about both of those things.");
		}
		System.out.println("“Panicking,” you answer.");
		System.out.println(
				"He grunts. You’re not sure if that was amusement or sympathy. “Show me what’s in your pockets.”");
		System.out.println("You open your pockets.");
		if (invent.containsItem(new Item("phone"))) {
			System.out.println(
					"He spots your phone, and flicks his eyes back up to your face. Now you both know that you’re batshit crazy. He takes your phone.");
			invent.removeItem(new Item("phone"));
		} else if (invent.containsItem(new Item("keys"))) {
			System.out.println(
					"He sees your apartment keys. You know he doesn’t know where you live, and he can kinda tell that you don’t have "
							+ "anything worth stealing anyways. He takes them and throws them into a trash bin in the alley. Shit. You just got robbed by Kobe.");
			invent.removeItem(new Item("keys"));
		} else if (invent.containsItem(new Item("trash"))) {
			System.out.println(
					"He sees the crumpled ball of trash. He’s confused for a moment, but then he sees the coupons. “Oh, shit,” he says excitedly as he "
							+ "takes the coupons from you, but then he sees that they’ve expired, and his face falls. “Never mind.” He gives them back to you.");
		} else {
			System.out.println("Nothing is in your pockets. Jokes on him?");
		}
	}

	@Override
	public void setRooms(Room east, Room south, Room north, Room west) {
		this.east = east;
		this.south = south;
		this.north = north;
		this.west = west;
	}
}
