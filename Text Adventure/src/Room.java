public interface Room {
	/**
	 * Prints setting
	 */
	public void printState();
	/**
	 * Prints wait command message
	 * @return - room for next command
	 */
	public Room waitCom();
	/**
	 * Prints Go command message
	 * @param next - name of next direction
	 * @return - room for next command
	 */
	public Room go(String next);
	/**
	 * Prints talk command message
	 * @param meti- the item to talk to
	 * @return - room for next command
	 */
	public Room talk(Item meti);
	/**
	 * Prints talk command message
	 * @param meti - item to pick up
	 */
	public void pick(Item meti);
	/**
	 * Prints use command message
	 * @param meti- item to use
	 * @return - room for next command
	 */
	public Room use(Item meti);
	/**
	 * Prints attack command message
	 * @param meti - item to attack
	 * @return - room for next command
	 */
	public Room attack(Item meti);
	/**
	 * Prints look command message
	 * @param meti - the item to look at
	 */
	public void look(Item meti);
	/**
	 * Sets room fields for each room
	 * @param east - a room
	 * @param south - a room
	 * @param north - a room
	 * @param west - a room
	 */
	public void setRooms(Room east, Room south, Room north, Room west);
}
