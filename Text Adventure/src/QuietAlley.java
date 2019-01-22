import java.util.*;
public class QuietAlley implements Room{
	private List<Item> items;
	private Inventory invent;
	private Room east, north, south, west;

	public QuietAlley(Inventory inv) {

		this.items = new ArrayList<>();
		items.add(new Item("man"));
		items.add(new Item("trash bin"));
		items.add(new Item("rat"));
		items.add(new Item("keys"));
		items.add(new Item("battle axe"));
		items.add(new Item("trash"));
		this.invent = inv;
	}

	@Override
	public Room waitCom() {
		System.out.println("You aren’t sure what to do. You aren’t sure what you’ve done up to this "
				+ "point in your life either, but you got here anyways, so you figure you’ll just wait around silently "
				+ "for a bit until something happens.");
		System.out.println("Something happens about 10 minutes later when a cop car shows up. An officer hops out of the car and runs over to you with their hand on their taser. “FREEZE,” they yell. You realize that you are standing over a seemingly-dead man in a dark alley. Crap. Crappity-crap. You see a head move out of the way of the window that Mr. T was preaching from earlier. That jerk COULD hear what was going outside the window. You shoot the window a dirty look as the officer puts you in cuffs and escorts you to the back of the cruiser. You pout on the way to jail, but hey, look at the bright side: You don’t have to go back to your garbage job tomorrow, you get an actual, legitimate bed to sleep on, food that was made specifically of human consumption, and maybe even entertainment or friends that don’t drunk dial you in the dark of the night. It’s not home but you’ll take it.");
		return null;
	}

	@Override
	public Room go(String next) {
		System.out.println("You’re beat tired, and while you might feel a little braver after surviving the night to"
				+ " this point, you just want to go home. You exit the alleyway and make your way to your apartment"
				+ " while ignoring the urges to turn around or run someplace new. —> Go to room: Outside Apartment");
		return this;
	}

	@Override
	public Room talk(Item meti) {
		System.out.println("You think you’re gonna keep your mouth shut.");	
		return this;
	}

	@Override
	public void pick(Item meti) {
		if (meti.getName().equalsIgnoreCase("keys")){
			items.remove(meti);
			invent.pickUp(meti);
			System.out.println("You grab your keys out of the dumpster, and as you tug them up, the metal object that was wrapped in your lanyard moves up with it so you can see it. You stare, dumbfounded. There’s a friggin’ battle axe in the dumpster. MAN, that would have been useful 3 minutes ago.");
		} else if (meti.getName().equalsIgnoreCase("battle axe")){
			items.remove(meti);
			invent.pickUp(meti);
			System.out.println("You pull the battle axe out and try to tuck it into your pocket. Obviously it doesn’t work, so you settle for running the handle through a belt loop.");
		} else if (meti.getName().equalsIgnoreCase("rat")){
			System.out.println("You’re not gonna mess with that guy.");
		} else if (meti.getName().equalsIgnoreCase("man")){
			System.out.println("He’s average size, but too much for you to carry.");
		} else {
			System.out.println("There’s nothing else here.");
		}
	}

	@Override
	public Room use(Item meti) {
		if (meti.getName().equalsIgnoreCase("phone")){
			System.out.println("You don’t have your phone.");
		} else if (meti.getName().equalsIgnoreCase("keys")){
			if (!invent.containsItem(meti)){
				System.out.println("You didn’t grab your keys yet.");
			} else {
				System.out.println("You don’t really want to mess with too much stuff here, y’know, since this is kinda a crime scene and all. ");
			}
		}else if (meti.getName().equalsIgnoreCase("battle axe")){
			System.out.println("NO. YOU PUT THAT BACK IN YOUR POCKET RIGHT NOW, BUDDY. ");
		} else if (meti.getName().equalsIgnoreCase("trash")){
			System.out.println("You spread the newspapers and coupons over the man as a blanket. It’s not cold or anything out, but you think it makes the whole scene look less bad.");
		} else {
			System.out.println("You don’t have that with you.");
		}
		return this;
	}

	@Override
	public Room attack(Item meti) {
		if (meti.getName().equalsIgnoreCase("dude") || (meti.getName().equalsIgnoreCase("guy")) || (meti.getName().equalsIgnoreCase("man"))){
			System.out.println("You kick at the guy laid against the wall. It kinda feels like you’re just kicking some sad, unconscious pillow. The man doesn’t react. ");
			return this;
		} else if (meti.getName().equalsIgnoreCase("rat")){
			System.out.println("You stomp towards the rat. The rat pauses and makes eye contact with you. You’re overcome with a sense of dread and back away. The rat proceeds to chew at the pizza.");
			return this;
		} else if (meti.getName().equalsIgnoreCase("")){
			System.out.println("You kick at the trash bin, and end up stubbing your toe. You hop it off. ");
			return this;
		} else {
			System.out.println("Woah, buddy. Your eyesight isn’t THAT great. It’s still pretty dark in here. You’re likely to give yourself a black eye if you start swinging your limbs around in here. ");
			return this;
		}
	}

	@Override
	public void look(Item meti) {
		if (meti.getName().equalsIgnoreCase("dude") || (meti.getName().equalsIgnoreCase("guy")) || (meti.getName().equalsIgnoreCase("man"))){
			System.out.println("You step over to the guy and check his pulse. He’s still breathing, but it looks like there’s a pretty sick-looking bruise forming on his temple. "
					+ "He’s gonna be the most bad-ass guy in his workplace. You’re almost jealous. His pockets have been pulled inside-out. They’re empty.");
		} else if (meti.getName().equalsIgnoreCase("rat")){
			System.out.println("You stare hungrily at the rat eating the pizza slice. The rat sees you looking and hisses at you. You aren’t sure what you were considering eating. ");
		} else if (meti.getName().equalsIgnoreCase("trash bin")){
			System.out.println("You look in the trash bin. Yup! There’s your keys! You thank all that is good in the world. "
					+ "The wrist-lanyard on your keys is wrapped around something metal.");
		} else {
			System.out.println("Woah, buddy. Your eyesight isn’t THAT great. It’s still pretty dark in here. ");
		}
	}

	@Override
	public void printState() {
		System.out.println("You step into the alleyway. It’s dim but you can tell that there’s one open trash bin, a rat feeding on an old piece of pizza, and the body of some dude slumped against a wall. ");
	}
	@Override
	public void setRooms(Room east, Room south, Room north, Room west) {
		this.east = east;
		this.south = south;
		this.north = north;
		this.west = west;
	}
}
