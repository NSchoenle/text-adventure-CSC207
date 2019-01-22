import java.util.*;

public class Adventure implements Room{
	private List<Item> items;
	private Inventory invent;
	private Room east, north, south, west;
	
	public Adventure(Inventory inv) {
		this.items = new ArrayList<>();
		items.add(new Item("bridge"));
		items.add(new Item("phone"));
		items.add(new Item("keys"));
		items.add(new Item("drawing"));
		items.add(new Item("trash"));
		items.add(new Item("self"));
		this.invent = inv;
	}

	@Override
	public void printState() {
		System.out.println("You wander to the north of the office for a while. You get lost pretty quickly. "
				+ "You could probably hold the record for ‘least amount of steps taken to get lost’, but you’d"
				+ " have to find Ripley’s Believe It or Not’s office to report it. You sigh. You see a bridge in the "
				+ "distance- further north. It’s the first thing you’ve seen that wasn’t dark, dirty streets or beat-up apartments.");
	}

	@Override
	public Room waitCom() {
		System.out.println("You stand for a while, pace a bit, and look around. Yup. You’ve no idea where you are. It could be "
				+ "Alaska for all you know. Or Atlantis. You don’t have the energy to think of location names that don’t start with A.");
		return this;
	}

	@Override
	public Room go(String next) {
		if (next.equalsIgnoreCase("north")){
			System.out.println("You stumble your way to the bridge. You step close to the railing and look down below at the river. You "
					+ "consider climbing on top of the rail and re-enacting the bridge scene from Les Miserables, but not the sad live stageplay/musical "
					+ "version: you mean the anime version in which Javert watches the sun rise over the horizon, says, “People can change,” and then walks away. "
					+ "You’re pondering whether to go with Les Mis or the “Everything the light touches..” scene from the Lion King when the sun actually starts to rise. It’s beautiful. "
					+ "Gorgeous. You feel like a new person, standing here, watching the birth of a new day."
					+ " You realize then: Home is wherever you are. You were never lost, you simply were not looking within yourself.");
			
			if(invent.containsItem(new Item("trash"))){
				System.out.println("You take the newspaper and coupons out of your pocket and fashion them into a hat. "
						+ "You wear your crown with pride as you watch the dawn of a new day.");
			}
			return north;
		} else if (next.equalsIgnoreCase("south")){
			System.out.println("You turn back, figuring the easiest route to take is the one you just took. You wander for a long while. "
					+ "Eventually, you lose track of your surroundings until you come to a small village with houses built into the hills. "
					+ "You look down. Your feet have swollen and grown hair. You don’t even know where your shoes went. You look back up. "
					+ "The world suddenly seems so large outside of this tiny town. You don’t feel like adventuring anymore, and decide to look "
					+ "for somewhere in town to stay. Maybe you’ll write a book about your adventures instead.");
			return south;
		} else if (next.equalsIgnoreCase("east")){
			System.out.println("You turn and go east. You wander for much longer. You don’t even pay attention to your surroundings until "
					+ "you come to a small village with houses built into the hills. You look down. Your feet have swollen and grown hair. You don’t"
					+ " even know where your shoes went. You look back up. The world suddenly seems so large outside of this tiny town. You don’t "
					+ "feel like adventuring anymore, and decide to look for somewhere in town to stay. Maybe you’ll write a book about your adventures instead. ");
			return east;
		} else if  (next.equalsIgnoreCase("west")){
			System.out.println("You turn and go west. You wander for much longer. You don’t even pay attention to your surroundings until "
					+ "you come to a small village with houses built into the hills. You look down. Your feet have swollen and grown hair. You don’t "
					+ "even know where your shoes went. You look back up. The world suddenly seems so large outside of this tiny town. You don’t"
					+ " feel like adventuring anymore, and decide to look for somewhere in town to stay. Maybe you’ll write a book about your adventures instead. ");
			return west;
		} else {
			System.out.println("You can't go that way!");
			return this;
		}
	}

	@Override
	public Room talk(Item meti) {
		if (meti.getName().equalsIgnoreCase("self")){
			System.out.println("You open your mouth to scream, but the stale air dries out your throat and you cough weakly instead.");
			return this;
		} else {
			System.out.println("“Hello?” you tentatively ask the silence. No answer. That’s probably a good thing.");
			return this;
		}
	}

	@Override
	public void pick(Item meti) {
		System.out.println("There’s nothing here to pick up.");
	}

	@Override
	public Room use(Item meti) {
		if (meti.getName().equalsIgnoreCase("phone")){
			if(!invent.containsItem(meti)){
				System.out.println("You don't have your phone");
			} else {
				System.out.println("You take your phone out of your pocket and try to turn it on, but to no avail. It’s super dead- like, -20% battery dead. "
						+ "“Same,” you murmur as you slip it back into your pocket.");
			}
		} else if (meti.getName().equalsIgnoreCase("keys")){
			if(!invent.containsItem(meti)){
				System.out.println("You don't have your keys");
			} else {
				System.out.println("You take out your keys and throw them. Just for the hell of it. They hit the pavement a few feet from you. You tiredly waddle over to them and pick them back up. ");
			}
		} else if (meti.getName().equalsIgnoreCase("drawing")){
			if(!invent.containsItem(meti)){
				System.out.println("You don't have a drawing");
			} else {
				System.out.println("You take out the drawing of the dog. You stare at it longingly, as if it’s a picture of a lost lover. This is dumb and weird.");
			}
		} else if (meti.getName().equalsIgnoreCase("trash")){
			if(!invent.containsItem(meti)){
				System.out.println("You don't have any trash");
			} else {
				invent.removeItem(meti);
				System.out.println("You fold the coupons into a paper airplane and launch it. It actually flies pretty well. It catches an updraft and drifts up over the edge of a building. Cool.");
			}
		} else {
			System.out.println("You can't use that.");
		}
		return this;
	}

	@Override
	public Room attack(Item meti) {
		System.out.println("You lash out in anger at nothing. The battle against nothing rages for about 30 seconds before you start to feel lightheaded. ");
		System.out.println("Congrats! You fainted from fatigue! Later, you’ll wake up in the back of a truck with some sticky, black substance on your face (you hope it’s melted black licorice), surrounded by people speaking a language you don’t understand. You obviously didn’t make it home, and you obviously aren’t safe.");
		return null;
	}

	@Override
	public void look(Item meti) {
		if (meti.getName().equalsIgnoreCase("phone")){
			if(!invent.containsItem(meti)){
				System.out.println("You don't have your phone");
			} else {
				System.out.println("You look at your phone screen. It doesn’t actually look like you have any power.");
			}
		} else if (meti.getName().equalsIgnoreCase("keys")){
			if(!invent.containsItem(meti)){
				System.out.println("You don't have your keys");
			} else {
				System.out.println("You look at your keys. Nope. Nothing helpful.");
			}
		} else if (meti.getName().equalsIgnoreCase("drawing")){
			if(!invent.containsItem(meti)){
				System.out.println("You don't have a drawing");
			} else {
				System.out.println("You take out the drawing of the dog. You stare at it longingly, as if it’s a picture of a lost lover. This is dumb and weird.");
			}
		} else if (meti.getName().equalsIgnoreCase("bridge")){
				System.out.println("It's just sitting there. Alone. Like you.");
		} else {
			System.out.println("You see nothing but grime, grime, and more grime. And a little bit of guck.");
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
