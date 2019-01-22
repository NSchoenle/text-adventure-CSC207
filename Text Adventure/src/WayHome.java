import java.util.*;

public class WayHome implements Room{
	private List<Item> items;
	private Inventory invent;
	private Room east, north, south, west;

	public WayHome(Inventory inv) {

		this.items = new ArrayList<>();
		items.add(new Item("alley"));
		items.add(new Item("apartment"));
		items.add(new Item("phone"));
		items.add(new Item("large figure"));
		items.add(new Item("hunched man"));
		items.add(new Item("window"));
		this.invent = inv;
	}

	@Override
	public Room waitCom() {
		System.out.println(" You figure taking a bit longer to get home at risk of death is better than most certainly getting" 
				+ " caught and most certainly dying. You hear someone walking this way shortly after a few seconds, so you try to " + 
				"huddle up in an entryway to avoid being seen."); 

		System.out.println("“What are you doing here?”");
		System.out.println("It didn’t work.");

		return south;
	}

	@Override
	public Room go(String next) {
		if (next.equalsIgnoreCase("east")) {
			System.out.println("You desperately sprint past the open alleyway towards your apartment. You’ll feel bad about possibly "
					+ "leaving some guy to die when you actually grow a conscience. All that matters is that you’re coming up to your end "
					+ "goal, and you have all of your limbs still."); //—>Go to room: Outside Apartment
			return east;
		} else if (next.equalsIgnoreCase("north")) {
			System.out.println("Okay. It’s time for you to be a hero. You weren’t meant to sit in some cruddy chair in some cruddy office while "
					+ "reading cruddy reports. You were meant to help people - to fight crime. You step into the alley."); //—-> Go to room: The Danger Zone
			return north;
		} else if (next.equalsIgnoreCase("west")) {
			System.out.println("Alright, so, obviously, some higher power has decided that you don’t live in this direction anymore. Noooo sirr-eeeeee. "
					+ "You live in the office now. Forever. You sneak back to the office and curl up under your desk inside.");
			return west;
		} else {
			System.out.println("You’re a little scared to move right now for fear of making noise and luring the hulk out here. You shiver just thinking about it.");
			return this;
		}
	}
	
	@Override
	public Room talk(Item meti) {
		if (meti.getName().equalsIgnoreCase("large figure")){
			System.out.println("You almost shout “Hello!” to the large, fearsome figure brutalizing some poor guy in an alleyway, but you stop yourself just in time. Phew.");
			return this;
		}else if (meti.getName().equalsIgnoreCase("hunched man")){
			System.out.println("You want to call out to the guy shaking on the ground, but he’s got his hands "
					+ "wrapped around his head to protect himself, and you don’t think he’d hear you. You whisper "
					+ "“It’s gonna be okay, buddy.” under your breath. You feel like a hero.");
			return this;
		} else if (meti.getName().equalsIgnoreCase("window")){
			System.out.println("You think whoever it is up there is having a crappy enough night without talking to you. Besides, you want Simone to win.");
			return this;
		} else if (meti.getName().equalsIgnoreCase("self")){
			System.out.println("‘What have I gotten myself into?’ ‘It’s not my fault! I didn’t do anything wrong!’ ‘I did take this job, though; that’s my fault. Maybe this is just karma.’");
			System.out.println("“What are you doing here?”");
			System.out.println("That wasn’t your head voice. That wasn’t even your actual voice.");
			return south;
		} else {
			System.out.println("You say 'Hey" + meti.getName() + "' No answer.What a surprise.");
			return this;
		}
	}

	@Override
	public void pick(Item meti) {
			System.out.println("You grabbed air. Congrats, you're seeing things now.");
	}

	@Override
	public Room use(Item meti) {
		if (meti.getName().equalsIgnoreCase("phone")){
			if (!invent.containsItem(meti)){
				System.out.println("What phone? :-]");
				return this;
			} else {
				System.out.println("You pull your phone out of your pocket to dial 911. Yeeeaaaah. You’re so smart and responsi- ");
				System.out.println("Your phone starts ringing. The caller ID says it’s Kal. He’s probably drunk-calling you from a party"
						+ " again. You don’t have time to pick it up, because the maybe-hulk comes rushing around the corner of the alley, and smashes your face in. ");
				System.out.println("You wake up much later in a hospital bed with a broken nose and, like, 6 black eyes, probably. You aren’t sure. You’re gonna be here for a while.");
				return null;
			}
		}else {
			System.out.println("You can't use that");
			return this;
		}
	}

	@Override
	public Room attack(Item meti) {
		if (meti.getName().equalsIgnoreCase("large figure")){
			System.out.println(" But you’re over here and they’re over there, which, coincidentally, isn’t over here."
					+ "If you were also over there, you could start something, but that’s assuming that the figure was still "
					+ "over there while you were also over there, which is not here. It wouldn’t really work to be over there "
					+ "and try to attack someone over here, which you’re kind of thankful in this case, because you’re over here "
					+ "and not there, and they are over there and not here.");
			return this;
		} else if (meti.getName().equalsIgnoreCase("hunched man")){
			System.out.println(" A) That’s rude, and B) you’re too far away. You’re gonna need to get closer to hit anybody.");
			return this;
		} else {
			System.out.println("Nah, you're too tired to do that.");
			return this;
		}
		
	}

	@Override
	public void look(Item meti) {
		if (meti.getName().equalsIgnoreCase("phone")){
			if (invent.containsItem(meti)) {
				System.out.println("You pull your phone out of your pocket, and open it up. You have 2% battery left."
						+ " You have no new texts. There are a few junk apps on your main screen, and the Uber app and "
						+ "Pokemon Go (sure, it died out 4 months ago, but you gotta catch ‘em all). Uber drivers are creepy, "
						+ "but so is the probably-murderer in the alley. You think they’d get along quite well.");
			}
			else { 
				System.out.println("You don’t have your phone. :-[");
			}
		} else if (meti.getName().equalsIgnoreCase("alley")){
			System.out.println("You peer around the corner of the alley. You can barely make out a dark, hulking figure" +
								"towering over the hunched, quivering figure of a man on the verge of pissing himself, who has +"
								+ "been backed into a corner behind some trash cans.");
		} else if (meti.getName().equalsIgnoreCase("apartment")){
			System.out.println("You look towards where sounds of the lamenting T fan are coming from. The window is closed. "
					+ "Probably a good idea on their part, but also not helpful to your ears.");
		} else {
			System.out.println("You blink and decide you're going insane.");
		}
	}

	@Override
	public void printState() {
		System.out.println("You’re a few buildings west of your apartment, and you can hear that someone in the apartment across"
				+ " the street is upset that Mr. T was eliminated from Dancing With The Stars. You pity the fool.");
		System.out.println("You’re passing by another dark alley to the north when you hear muffled sobs and shuffling under the "
				+ "not-so-muffled wailing covering a resigned Mr. T saying: “You might not have the things you want, but if you check "
				+ "carefully, you got all you need.” ");
	}
	@Override
	public void setRooms(Room east, Room south, Room north, Room west) {
		this.east = east;
		this.south = south;
		this.north = north;
		this.west = west;
	}
}
