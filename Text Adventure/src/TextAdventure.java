import java.util.*;

public class TextAdventure {
	/**
	 * Prints list of valid commands
	 */
	public static void printComms(){
		System.out.println("Valid commands are:");
		System.out.println("Wait");
		System.out.println("Go [cardinal direction]");
		System.out.println("Talk to [item]");
		System.out.println("Pick up [item]");
		System.out.println("Attack [item]");
		System.out.println("Use [item]");
		System.out.println("Look at [item]");
		System.out.println("Inventory");
		System.out.println("Help");
		System.out.println("Quit");
	}
	/**
	 * Main driver for game
	 * @param args- takes no arguments
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int turn = 0;
		boolean finished = false;
		Parser parser = new Parser();
		Inventory invent = new Inventory();
		
		Room dangerZone = new DangerZone(invent);
		Room inTrouble = new InTrouble(invent);
		Room krispyKreme = new KrispyKreme(invent); 
		Room outsideApartment = new OutsideApartment(invent);
		Room office = new Office(invent);
		Room outsideOffice = new OutsideOffice(invent);
		Room quietAlley = new QuietAlley(invent);
		Room wayHome = new WayHome(invent);
		Room adventure = new Adventure(invent);
		Room dogPark = new DogPark(invent);
		
		//east, south north west
		
		List<Room> loc = new ArrayList<>();
		loc.add(0,adventure);
		loc.add(1,dangerZone);
		loc.add(2,wayHome);
		loc.add(3,quietAlley);
		loc.add(4,outsideOffice);
		loc.add(5,outsideApartment);
		loc.add(6,office);
		loc.add(7,krispyKreme);
		loc.add(8,inTrouble);
		loc.add(9,dogPark);
		
		//east south north west
		
		office.setRooms(loc.get(6),loc.get(4),loc.get(6), loc.get(6));
		adventure.setRooms(null, null, null, null);
		outsideOffice.setRooms(loc.get(2), loc.get(9), loc.get(0),loc.get(7));
		wayHome.setRooms(loc.get(5), loc.get(8), loc.get(1), null); 
		outsideApartment.setRooms(loc.get(5), null, null, loc.get(5)); 
		inTrouble.setRooms(loc.get(5), null, loc.get(3), loc.get(8));
		krispyKreme.setRooms(null, loc.get(4), null, null);
		dogPark.setRooms(loc.get(9), loc.get(9), loc.get(4), loc.get(9));
		quietAlley.setRooms(loc.get(5), loc.get(5), loc.get(5), loc.get(5));
		dangerZone.setRooms(loc.get(1), loc.get(5), loc.get(1), loc.get(3));
		
		
		Room curRoom = office;
		Room nextRoom = office;
		Command curCom = null;
		System.out.println("This is the “Go Home” Adventure game. Your goal is to get back to your home safely.");
		while (!finished) {
			while (nextRoom != null) {
				nextRoom.printState();
				curRoom = nextRoom;
				while (curRoom == nextRoom) {
					System.out.println(turn + "======");
					String com = in.nextLine();
					if (com.equalsIgnoreCase("quit")){
						nextRoom = null;
					}else if (com.equalsIgnoreCase("help")){
						printComms();
					}else{
						parser.setText(com);
						curCom = parser.parse(curRoom);
						while (curCom.getVerb().equalsIgnoreCase("")){
							parser.setText(in.nextLine());
							curCom = parser.parse(curRoom);
						}
						nextRoom = curCom.doTheThing(invent);
						turn++;
					}
				}
			}
			finished = true;
			System.out.println("Game over.");
		}

	}
}
