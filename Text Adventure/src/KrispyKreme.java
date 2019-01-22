import java.util.*;
public class KrispyKreme implements Room{
	private List<Item> items;
	private Inventory invent;
	private Room east, north, south, west;
	
	public KrispyKreme(Inventory inv) {

		this.items = new ArrayList<>();
		items.add(new Item("doughnut machine"));
		items.add(new Item("display"));
		items.add(new Item("cashier"));
		items.add(new Item("table"));
		items.add(new Item("keys"));
		items.add(new Item("phone"));
		items.add(new Item("trash"));
		items.add(new Item("self"));
		items.add(new Item("donuts/doughnuts"));
		this.invent = inv;
}

	@Override
	public Room waitCom() {
		System.out.println("You take in the smells some more. The cashier is starting to give you angry looks.");
		return this;
	}

	@Override
	public Room go(String next) {
		if (next.equalsIgnoreCase("north")) {
			System.out.println("You try to walk north to the kitchen but you are stopped by the cashier. "
					+ "They call for backup and you are overpowered. You pass out as someone calls the cops. "
					+ "Not the worst thing on your criminal record. In fact, you think there’s a nice juxtaposition "
					+ "to donut-dream-walker and lit-their-hair-on-fire-as-a-seven-year-old.");
			return north;
		} else if (next.equalsIgnoreCase("south")){
			System.out.println("You exit the donut shop, because seriously, what were you even gonna do in there "
					+ "with no money or sanity? Carry out the world’s greatest donut heist? Fly off into the night with "
					+ "a duffel full of sugar-coated death? “Some day…” you mumble grumpily while kicking at the pavement.");
			// ——> Go to room: Outside Office
			return south;
		}else 
			System.out.println("You try to leave the doughnut shop via a window. You fight your way free of the glass,"
					+ " but are stopped by police as you try to flee the Krispy Kreme you just trashed. You think the place needed "
					+ "more exits anyways. That place gets PACKED at lunch time, and you’re pretty sure a building full of slow-moving"
					+ " foodies with only one exit is a fire hazard. The cops don’t agree.");
			return this;
	}

	@Override
	public Room talk(Item meti) {
		if (meti.getName().equalsIgnoreCase("cashier")){
			System.out.println("You try to chat up the person at the register: “How do you spell do(ugh)nuts, amig- uhh, friend?” "
					+ "They aren't feeling friendly and ask you to order. When you say you don't have any cash, they just yell 'WHO'S NEEEEEEXXTTT!!!!' "
					+ "at the empty line behind you.");
		} else if (meti.getName().equalsIgnoreCase("self")){
			System.out.println("“Doooooooooooonuuuuuuuuuuutsssss.”");
		} else if (meti.getName().equalsIgnoreCase("donuts") || meti.getName().equalsIgnoreCase("doughnuts")){
			System.out.println("“Hey hot stuff,” you call to the gooey dough rings. They don’t answer, but you’re pretty sure one winked at you.");
		} else {
			System.out.println("You are entirely too enraptured with the sweets before you to think about anything else.");
		}
		return this;
	}

	@Override
	public void pick(Item meti) {
		if (meti.getName().equalsIgnoreCase("napkin")){
			items.remove(meti);
			invent.pickUp(meti);
			System.out.println("You pocket the napkin with the poodle drawing on it. You wish you could have gotten a signature.");
		} else {
			System.out.println("You try to take" + meti.getName() + ", but you begrudgingly put it back when the cashier glares at you.");
		}
	}

	@Override
	public Room use(Item meti) {
		if (meti.getName().equalsIgnoreCase("keys")){
			if (!invent.containsItem(meti)){
				System.out.println("You don’t have any keys on you.");
			} else {
				System.out.println("You remove your keys from your pocket and offer them to the cashier "
						+ "who tells you keys are not acceptable currency. You put them back in your pocket.");
			}
		} else if (meti.getName().equalsIgnoreCase("phone")){
			if (!invent.containsItem(meti)){
				System.out.println("You don't have your phone.");
			} else {
				System.out.println("You take your phone out, but you really just want a doughnut and a phone isn't "
						+ "acceptable currency, either. BLUH. You wish you could just go back to the olden days, when people "
						+ "offered items for trade, and chicken-watcher was considered a respectable job. You sigh, but then you"
						+ " remember that you probably would have died back then because medicine kinda sucked. ");
			}
		}else if (meti.getName().equalsIgnoreCase("trash")){
			if (!invent.containsItem(meti)){
				System.out.println("You don’t have any with you.");
			} else {
				System.out.println("You pull out the crumpled pile of junk you picked up earlier, and hold it out to the cashier. "
						+ "The cashier is not amused. Fine then. More junk for you. You put the trash back into your pocket.");
			}
		} else {
			System.out.println("The cashier watches you search your pockets for "+ meti.getName()+ " and you get worried so you stop looking.");
		}
		return this;
	}

	@Override
	public Room attack(Item meti) {
		if (meti.getName().equalsIgnoreCase("cashier")){
			System.out.println("You take a dive at the cashier, who proceeds to flip you over their shoulder, climb on top of you, "
					+ "and put you in a key lock. You feel your arm being ripped off and black out from the pain. ");
			return null;
		} else if (meti.getName().equalsIgnoreCase("doughnut machine")){
			System.out.println("What fool would be so mindless as to damage a gift from the powers that be? Not you. One day, "
					+ "this machine may be your overlord, and honestly, you are excited for that day.");
			return this;
		} else {
			System.out.println("You start wildly trying to attack" + meti.getName() + "but you realize someone is watching, and you are in no fit state to fight and you are losing in front of spectators.");
			return this;
		}
	}

	@Override
	public void look(Item meti) {
		if (meti.getName().equalsIgnoreCase("doughnut machine")){
			System.out.println("You press your face to the glass. It smells so good, and the machine is so entrancing. You want to steal all of the sweetness."
					+ " You think that, if there’s a heaven, it’s gotta have one of these machines, because obviously the birthplace of donuts is the home of goodness and joy."
					+ " It occurs to you that you’re basically watching donuts being born. “This is much better than health class,” you mutter loud enough for the cashier to hear. "
					+ "Now they just look repulsed. ");
		} else if (meti.getName().equalsIgnoreCase("display")){
			System.out.println("You stare longingly at the doughnuts through the glass. The longer you stare, the more they smile. "
					+ "You wave when one of them gives you a thumbs up. Someone (probably the cashier) snaps in your face until the doughnuts return to normal.");
		} else if (meti.getName().equalsIgnoreCase("cashier")){
			System.out.println("You walk up to the cashier and just stare at them. They look like a college student who would much rather be partying than working.");
		} else if (meti.getName().equalsIgnoreCase("table")){
			System.out.println("Someone drew a cute little poodle on a napkin. It’s pretty good.");
		} else
			System.out.println("You stare off into space at something, but you forget about it in favor of imagining a donut being there instead. ");
	}

	@Override
	public void printState() {
		System.out.println("You walk into the Krispy Kreme through an entrance on the south side of the building. You watch the hot light flicker in the window. "
				+ "All you want is a hot doughnut. The counter is in front of you, and a mean looking cashier stares you down behind a full display case .  "
				+ "In classic Krispy Kreme style, there is a window behind which sits a doughnut machine making those sweet dream-cakes you love so much."); 
		System.out.println("You also take a moment to prepare yourself for inconsistent usage of ‘doughnut’ and ‘donut’ because author number two decided to be "
				+ "a spell-checker and refuses to use the ‘ugh’. If you have a problem with that, you can ‘gough’ shove it.");
	}
	@Override
	public void setRooms(Room east, Room south, Room north, Room west) {
		this.east = east;
		this.south = south;
		this.north = north;
		this.west = west;
	}
}