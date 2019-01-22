import java.util.*;
public class DangerZone implements Room{
	private List<Item> items;
	private Inventory invent;
	private Room east, north, south, west;

	public DangerZone(Inventory inv) {

		this.items = new ArrayList<>();
		items.add(new Item("thug"));
		items.add(new Item("man"));
		items.add(new Item("trash bin"));
		items.add(new Item("pizza"));
		items.add(new Item("metal thing"));
		items.add(new Item("phone"));
		this.invent = inv;
	}

	@Override
	public Room waitCom() {
		System.out.println("You don’t do anything. No one does anything. "
				+ "You all just stare at each other in confusion and expectation.");
		return this;
	}

	@Override
	public Room go(String next) {
		if (next.equalsIgnoreCase("south")){
			System.out.println("Your nerves leave you the moment you lay eyes on the thug.");
			System.out.println(" You quickly turn and book it out of the alley and back to the safety of your apartment.");
			//  —> Go to room: Outside Apartment
			return south;
		} else {
			System.out.println("Nowhere to go, my friend.");
			return this;
		}
	}

	@Override
	public Room talk(Item meti) {
		System.out.println("Don't waste your time, focus!");
		return this;
	}

	@Override
	public void pick(Item meti) {
		if (meti.getName().equalsIgnoreCase("pizza")){
			System.out.println("Ew, gross. You’re not that hungry.");
		} else if (meti.getName().equalsIgnoreCase("thug")){
			System.out.println("You aren’t sure how you could manage to do that.");
		} else if (meti.getName().equalsIgnoreCase("man")){
			System.out.println("He’s a bit jumpy, so you’re not gonna try to get close to him. ");
		} else if (meti.getName().equalsIgnoreCase("trash bin")){
			System.out.println("Nah, there’s no way you can lift all of that garbage. You can barely lift yourself.");
		} else if (meti.getName().equalsIgnoreCase("metal thing")){
			items.remove(meti);
			invent.pickUp(meti);
			System.out.println("You grab the metal thing sticking out of the trash bin. It’s… Holy hell! It’s a battle axe. Sweeeeeeet!");
			
		} else {
			System.out.println("It’s dark here, and you don’t see anything that looks like that.");
		}
	}

	@Override
	public Room use(Item meti) {
		if (meti.getName().equalsIgnoreCase("keys")){
			System.out.println("You take your keys out of your pocket and jingle them in front of you.");
			System.out.println("You whistle at the thug as if you’re calling a dog. He’s not amused. The man on the ground looks even more terrified. "
					+ "You put your keys back into your pocket.");
		} else if (meti.getName().equalsIgnoreCase("phone")){
			System.out.println("You open your phone to see that it has 1% battery left. That’s not good. What’s worse is that the thug thinks you’re"
					+ " gonna call the cops, and slams his fist into your face.");
			System.out.println("You wake up much later in a hospital bed with a broken nose and, like, 6 black eyes, probably. You aren’t sure. You’re gonna be here for a while.");
			return null;
		} else if (meti.getName().equalsIgnoreCase("trash")){
			invent.removeItem(meti);
			System.out.println("You fold the coupons into a paper airplane and launch it. It actually flies pretty well. It catches an updraft and drifts up over the edge of a building. Cool.");
		} else if (meti.getName().equalsIgnoreCase("man")){
			System.out.println("As much as you love the ‘Hit a motherfucker with another motherfucker’ jokes, you don’t think you have the strength to lift the poor guy up.");
		} else if (meti.getName().equalsIgnoreCase("thug")){
			System.out.println("The author questions your life choices for you. ");
		} else if (meti.getName().equalsIgnoreCase("axe")){
			System.out.println("You pull out the battle axe. The thug jumps in surprise and then hurriedly shuffles around you, and out of the alley, away into the night. ");
			System.out.println("You look over to the man on the ground, who is frozen in fear at the sight of you holding a battle axe. He faints against the wall. Oops.");
			return west; //--> Go to Quiet Alley
		}else{
			System.out.println("The what?");
		}
		return this;
	}

	@Override
	public Room attack(Item meti) {
		if (meti.getName().equalsIgnoreCase("man")){
			System.out.println("You run up to the man on the ground and kick him. He whimpers in pain and then faints. The thug is visibly confused. ");
			System.out.println("That was HIS job. What’s he supposed to do if some tired office-worker picks on the weak instead of him? He looks pretty crestfallen.");
			System.out.println("He feels purposeless. Lost. Outdated. He sadly stumbles out of the alley, turns down the street, "
					+ "and is gone."); // Go to room: Quiet Alley
			return west;
		} else if (meti.getName().equalsIgnoreCase("thug")){
			System.out.println("You try to throw a punch at the thug. You miss horribly. You probably got so excited "
					+ "that you forgot you were beat tired and need a nap. The guy helps you fulfill your goal of a nice long"
					+ " rest by smashing your face in. ");
			System.out.println("You wake up much later in a hospital bed with a broken nose and, like, 6 black eyes, probably. You aren’t sure. You’re gonna be here for a while.");
			return null;
		}else if (meti.getName().equalsIgnoreCase("pizza")){
			System.out.println("Woooaaah, kid. The food did nothing wrong. The food is never at fault.");
			return this;
		} else if (meti.getName().equalsIgnoreCase("trash bin")){
			System.out.println("You kick at the trash bin, and end up stubbing your toe. You hop it off. ");
			return this;
		} else {
			System.out.println("It’s dark here, and you really don’t want to take your eyes off of the thug.");
			return this;
		}
		
	}

	@Override
	public void look(Item meti) {
		if (meti.getName().equalsIgnoreCase("thug")){
			System.out.println("The guy on the ground looks back at you with an expression of fear mixed with hope.");
		} else if (meti.getName().equalsIgnoreCase("man")){
			System.out.println("");
		} else if (meti.getName().equalsIgnoreCase("trash bin")){
			System.out.println("You see something metal sticking out of the bin. Looks useful.");
		}else if (meti.getName().equalsIgnoreCase("pizza")){
			System.out.println("You’re not that hungry.");
		} else {
			System.out.println("It’s dark here, and you really don’t want to take your eyes off of the thug.");
		}
	}

	@Override
	public void printState() {
		System.out.println("As you step into the alley, both figures stop and turn towards you. They both look"
				+ " like they’re expecting something to happen. There’s a trash bin nearby and a piece of old pizza on the ground. "
				+ "You don’t really have much to work with.");
	}
	@Override
	public void setRooms(Room east, Room south, Room north, Room west) {
		this.east = east;
		this.south = south;
		this.north = north;
		this.west = west;
	}
}
