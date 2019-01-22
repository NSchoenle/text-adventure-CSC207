import java.util.*;

public class DogPark implements Room {
	private List<Item> items;
	private Inventory invent;
	private Room east, north, south, west;

	public DogPark(Inventory inv) {

		this.items = new ArrayList<>();
		items.add(new Item("fire"));
		items.add(new Item("shapes"));
		items.add(new Item("phone"));
		items.add(new Item("keys"));
		items.add(new Item("tree"));
		items.add(new Item("bush"));
		items.add(new Item("bench"));
		items.add(new Item("figures"));
		items.add(new Item("self"));
		items.add(new Item("trash"));
		items.add(new Item("drawing"));
		this.invent = inv;
	}

	@Override
	public void printState() {
		System.out.println("The dog park is basically just a huge gated-in rectangle with grass and bushes. "
				+ "There’s only one exit (on the north side of the park) so that the little doggies can’t run away very easily. "
				+ "There’s a few benches and a paved, circular area in the center, but other than that the place is pretty boring. "
				+ "Except for the puppies. Puppies are always great. They don’t even have doggy-bag stations. It’s like they WANT "
				+ "you to leave shit everywhere. You’re somewhat in the mood to comply right now. ");
		System.out.println(
				"As you saunter towards the center area, you notice a light. It’s not like, a lamp light; it’s more like a "
						+ "fire. A shape blocks out part of the light, and then moves away again. Huh. It happens again. You get a little closer and hear chanting. ");
	}

	@Override
	public Room waitCom() {
		System.out.println(
				"The shapes keep moving in front of the fire and the chanting continues, low and steady. You don’t move. Nothing else does.");
		return this;
	}

	@Override
	public Room go(String next) {
		if (next.equalsIgnoreCase("north")) {
			System.out.println(
					"You decide you don’t wanna be a part of this party. You sneak back out of the dog park, and back to the office.");
			// —> Go to room: Outside Office
			return north;
		} else {
			System.out.println("You can't go that way!");
			return this;
		}
	}

	@Override
	public Room talk(Item meti) {
		if (meti.getName().equalsIgnoreCase("figures")) {
			System.out.println(
					"“Um, excuse me? Are you allowed to have bonfires here?” you ask the group of figures. They pay you no mind. That’s fine. ");
			return this;
		} else if (meti.getName().equalsIgnoreCase("self")) {
			System.out.println(
					"Maybe you’re just nuts. No. You’re definitely nuts, but still! You weren’t coming up with this kind of shit before! What has changed in the last three hours???");
			return this;
		} else {
			System.out.println(
					"You get the feeling there’s many more things in the area that you can’t see, but you really don’t want to try to start a conversation with them.");
			return this;
		}
	}

	@Override
	public void pick(Item meti) {
		System.out.println(
				"There is literally nothing but actual dog shit to pick up here, and you really don’t want to touch that.");
	}

	@Override
	public Room use(Item meti) {
		if (meti.getName().equalsIgnoreCase("phone")) {
			if (!invent.containsItem(meti)) {
				System.out.println("You don't have your phone.");
				return this;
			} else {
				System.out.println("You pull out your phone and press the ‘on’ button. The screen flickers and then dies. Hoooooo boy.");
				return this;
			}
		} else if (meti.getName().equalsIgnoreCase("trash")) {
			if (!invent.containsItem(meti)) {
				System.out.println("You don't have any of that.");
				return this;
			} else {
				invent.removeItem(meti);
				System.out.println(
						"You fold the coupons into a paper airplane and launch it. It actually flies pretty well, but it also "
								+ "dive-bombs into the fire pretty well. D’awwwww. :-[");
				return this;
			}
		} else if (meti.getName().equalsIgnoreCase("keys")) {
			if (!invent.containsItem(meti)) {
				System.out.println("You don't have your keys.");
				return this;
			} else {
				System.out.println("You jingle your keys and try whistling for a dog. None show up. Oh, thank heavens. ");
				return this;
			}
		} else if (meti.getName().equalsIgnoreCase("napkin")) {
			if (!invent.containsItem(meti)) {
				System.out.println("You don't have any napkins.");
				return this;
			} else {
				System.out.println(
						" You notice one of the figures on the edge of the spectacle looking in your direction. You "
								+ "shift uncomfortably and a branch snaps under your feet. More figures turn to you and you panic. Some"
								+ " of the figures approach you, you think, but you can’t tell for sure. You feel dizzy and light headed. The first "
								+ "figure is before you now. Your arm reaches into your pocket, out of your control. You grab the picture of a dog"
								+ " on a napkin and hold it out to the figure. ");
				System.out.println(
						"Many of the figures step back in surprise. Some of them gasp. The one before you removes their hood. Your dizziness dissipates. Before you stands an older man, with gray hair and a trimmed beard. He looks kindly, but wise. He grips your shoulder reassuringly- almost proudly.");
				System.out.println("We have been waiting for you.");
				System.out.println(
						"Years later you’ll remember the night you stumbled upon the Canine Cult with fondness. Both you and the cult were confused to see each other in the park, but when you revealed the token to them, they realized that you were the prophet they had been waiting for. "
								+ "Their leader explained their prophecies to you, and extended an invitation to you to join. It didn’t sound like a bad idea, so you went with it. Now you are the leader of the cult, with millions of members worldwide. You don’t remember ever feeling this happy in life. "
								+ "You don’t remember feeling like you belonged like this. You have thrown off the false security of your past life, and finally found your true home. ");
				return null;
			}
		} else {
			System.out.println("You don't have that");
			return this;
		}
	}

	@Override
	public Room attack(Item meti) {
		if (meti.getName().equalsIgnoreCase("figures")) {
			System.out.println(
					"You lunge at one of the figures. You successfully tackle one to the ground and stop their ritualistic dancing. "
							+ "The others flock to you. They grab and scratch at you, and you try to fight them off, but your fatigue catches up with you "
							+ "and your vision fades to black as you faint. ");
			System.out.println(
					"You wake up in your apartment in your pajamas. Your things are strewn across your desk. Everything looks normal. Was that a dream?");
			return null;
		} else if (meti.getName().equalsIgnoreCase("fire")) {
			System.out.println(
					"You madly rush forth from your hiding place and throw yourself into the fire. You feel the heat and pain"
							+ " searing the flesh from your bones. It gets worse when you start to think there are hands grabbing at you. Everything goes black.");
			System.out.println(
					"You wake up in your apartment in your pajamas. Your things are strewn across your desk. Everything looks normal. Was that a dream?");
			return null;
		} else {
			System.out.println(
					"You might be having a panic attack because you just considered fighting something that wasn’t here. "
							+ "Or maybe it’s whatever voodoo-magic-shit going on in the dog park that’s messing with your head. You don’t know "
							+ "anymore! BUSH DID 9/11 !!!!");
			return this;
		}
	}

	@Override
	public void look(Item meti) {
		if (meti.getName().equalsIgnoreCase("fire") || meti.getName().equalsIgnoreCase("shapes")) {
			System.out.println(
					"You creep a bit closer and hide behind a tree. When you crane your neck around the trunk to see the shapes, you notice "
							+ "they’re very Jedi-like. Or, wait, human, but they’re wearing robes. You can’t tell the color of the robes, but they look dark, so maybe "
							+ "they’re Sith? Anyways, this is definitely a cult thing. ");
		} else if (meti.getName().equalsIgnoreCase("phone")) {
			if (!invent.containsItem(meti)) {
				System.out.println("You don't have your phone");
			} else {
				System.out.println("You look at your phone screen. It doesn’t actually look like you have any power.");
			}
		} else if (meti.getName().equalsIgnoreCase("keys")) {
			if (!invent.containsItem(meti)) {
				System.out.println("You don't have your keys");
			} else {
				System.out.println("You look at your keys. Nope. Nothing helpful.");
			}
		} else {
			System.out.println("You don’t see anything else interesting in the area. ");
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
