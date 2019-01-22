import java.util.*;
public class OutsideOffice implements Room{
	private List<Item> items;
	private Inventory invent;
	private Room east, north, south, west;

	public OutsideOffice(Inventory inv) {
		
		this.items = new ArrayList<>();
		items.add(new Item("trash"));
		items.add(new Item("self"));
		items.add(new Item("phone"));
		items.add(new Item("self"));
		this.invent = inv;
	}

	@Override
	public Room waitCom() {
		System.out.println("Sure, yeah. Let’s just stand here and wait to faint on the sidewalk."); 
		return this;
	}
	
	@Override
	public Room go(String next) {
		if (next.equalsIgnoreCase("east")) {
			System.out.println("You turn towards your haven, your home, your cheap, claustrophobic little apartment full of technically-not furniture and you-don’t-want-to-know stains.");
			return east;
		} else if (next.equalsIgnoreCase("north")) {
			System.out.println("You’re feeling kind of adventurous. You think ‘Hey, if I’m gonna get murdered tonight, I might as well try to die in a new shithole.’ and head along the street to the north of the office.");
			return north;
		} else if (next.equalsIgnoreCase("south")) {
			System.out.println("The best remedy to a bad day is cute animals, so you start off towards the park, forgetting that it is night and the kinds of dogs in the park right now, if any, are probably not the cute cuddly ones.");
			return south;
		} else if (next.equalsIgnoreCase("west")) {
			System.out.println("You just really want donuts that haven’t been sitting in someone’s car for three weeks. You go west of the office, towards the Krispy Kreme.");
			return west;
		} else {
			System.out.println("You decide to pick an entirely ridiculous destination. You walk about four steps in some random direction and immediately kiss pavement.");
			System.out.println("Congrats! You fainted from fatigue! Later, you’ll wake up in the back of a truck with some sticky, black substance on your face (you hope it’s"
					+ " melted black licorice), surrounded by people speaking a language you don’t understand. You obviously didn’t make it home, and you obviously aren’t safe.");
			return this;
		}
	}
	

	@Override
	public Room talk(Item meti) {
		if (meti.getName().equalsIgnoreCase("self")) {
			System.out.println("You’re reaaaaaally tired.");
			return this;
		} else {
			System.out.println("You say 'Hey" + meti.getName() + "' No answer.What a surprise.");
			return this;
		}
	}

	@Override
	public void pick(Item meti) {
		if (meti.getName().equalsIgnoreCase("trash")){
			invent.pickUp(meti);
			items.remove(meti);
			System.out.println(" O…kaaaaay. You pick up a wadded-up ball of paper on the sidewalk");
		} else{System.out.println("You grabbed air. Congrats, you're seeing things now.");}
		
	}

	@Override
	public Room use(Item meti) {
		if (meti.getName().equalsIgnoreCase("phone")){
			if (!invent.containsItem(meti)){
				System.out.println("What phone? :-]");
			}else{
				System.out.println("You pull your phone out of your pocket, and open it up. "
						+ "You have 8% battery left. You have no new texts. There are a few junk apps on your main screen, and the Uber app and Pokemon Go "
						+ "(sure, it died out 4 months ago, but you gotta catch ‘em all). You happen to know that the Uber drivers around here are disgusting &/or creepy. "
						+ "You would rather not call for one. You put your phone away in your pocket.");
			}
		}else if (meti.getName().equalsIgnoreCase("keys")){
			if (!invent.containsItem(meti)){
				System.out.println(" You don’t have any keys on you.");
			}else{
				System.out.println("You remove your keys from your pocket and position yourself in the street in front of the office. "
						+ "You make engine-starting noises while turning the keys in an imaginary  ignition. You should probably make an appointment with a psychiatrist soon. "
						+ "You sadly turn off your fake car and put your keys back into your pocket.");
			}
		}else {System.out.println("You look at the world and ask what the fuck you're doing.");}
		return this;
	}

	@Override
	public Room attack(Item meti) {
		if (meti.getName().equalsIgnoreCase("trash")){
			System.out.println("You kick at the wad of trash. It doesn’t react. That wasn’t satisfying at all.");
		}else{
			System.out.println("You try kicking the air. You fall down. You don't want to get back up, but it's late and sleeping outside the office doesn't sound fun.");
		}
		return this;
	}

	@Override
	public void look(Item meti) {
		if (meti.getName().equalsIgnoreCase("trash")) {
			if (!invent.containsItem(meti)) {
				System.out.println("It looks kinda like a piece of shit from here. It’s not a penny, so you don’t really pay much attention to it.");
			} else {
				System.out.println("You pull the trash wad out of your pocket. There’s a coupon in here! Oh, no.. it’s 2 years old. Never mind. The other pieces of trash are from some …used newspaper. Eugh. ");
			}
			if (invent.containsItem(meti)) {
				System.out.println("You look at " + meti.getName()+" and decide it isn't interesting and put it back in your pocket.");
			}else{
				System.out.println("You blink and decide you're going insane.");
				}
		}
		
	}

	@Override
	public void printState() {
		System.out.println("It’s not a bad night out. Why, you might even fancy a stroll through the dim-lighted streets, if you weren’t, you know, 10 seconds from "
				+ "passing out in the nearest bush. Or, at least if the crime rate in this neighborhood wasn’t so ridiculously high that you were likely to be robbed by a "
				+ "pigeon on your way to work. It’s still pretty dark out. You can see the streets alright, but the alleyways offer no information if you try to peer into them."
				+ " There’s trash on the sidewalk. There’s always trash on the sidewalk. On second thought, that might just be the sidewalk. ");
		System.out.println("Your apartment is a few blocks east of the office. There’s a Krispy Kreme a few buildings to the west. There’s a park to the south that you like "
				+ "to go to on Sundays to watch dogs play. You don’t know what lies to the north, because your only real goals in life are to eat junk food, coo at puppies, and live another day.");
	}
	@Override
	public void setRooms(Room east, Room south, Room north, Room west) {
		this.east = east;
		this.south = south;
		this.north = north;
		this.west = west;
	}
}
