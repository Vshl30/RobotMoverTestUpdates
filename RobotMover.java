package practice;

import java.util.Scanner;

public class RobotMoverDrafts {
//	static int[] coordinates = new int[2];
	static int x,y;
	static String north = "NORTH", south = "SOUTH", east = "EAST", west = "WEST";
//	static boolean flag = false;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Start:\n");
		String command, face = new String();

		/*
		 * do { System.out.println("Enter command: "); command = sc.nextLine(); } while
		 * (!command.equalsIgnoreCase("place")); coordinates = placeRobot(); face =
		 * getFace();
		 */
		
		do {
			command = sc.nextLine();
		}while(!getPLaceRobotValue(command));
		
		face = command.substring(10);
		
		do {
			command = sc.nextLine();
			switch (command.toUpperCase()) {
//			case "PLACE":
//				placeRobot();
//				face = getFace();
//				break;
			case "MOVE":
				moveRobot(face);
				break;
			case "LEFT":
				face = faceDirection(command, face);
				break;
			case "RIGHT":
				face = faceDirection(command, face);
				break;
			case "REPORT":
				System.out.println(x + "," + y + "," + face.toUpperCase());
				break;
			default:
				getPLaceRobotValue(command);
				face = command.substring(10);
				break;
			}
		} while (true);
	}

	private static boolean getPLaceRobotValue(String command) {
		boolean flag = false;
		if (command.substring(0, 5).equalsIgnoreCase("place") && Character.isDigit(command.charAt(6))
				&& Character.isDigit(command.charAt(8))
				&& (command.substring(10).equalsIgnoreCase(south) || command.substring(10).equalsIgnoreCase(north)
						|| command.substring(10).equalsIgnoreCase(east) || command.substring(10).equalsIgnoreCase(west))) {
			
			x = Integer.parseInt(String.valueOf(command.charAt(6)));
			y = Integer.parseInt(String.valueOf(command.charAt(8)));
			System.out.println(x);
			System.out.println(y);
			if(x<=5 && x>=0 && y<=5 && y>=0) {
				flag = true;
			}
		}
		System.out.println(flag);
		return flag;
	}

	private static String faceDirection(String command, String face) {
		String right = "right";
		switch (face.toUpperCase()) {
		case "NORTH":
			if (command.equalsIgnoreCase(right))
				face = east;
			else
				face = west;
			break;
		case "SOUTH":
			if (command.equalsIgnoreCase(right))
				face = west;
			else
				face = east;
			break;
		case "EAST":
			if (command.equalsIgnoreCase(right))
				face = south;
			else
				face = north;
			break;
		case "WEST":
			if (command.equalsIgnoreCase(right))
				face = north;
			else
				face = south;
			break;
		}
		return face;
	}

	private static void moveRobot(String face) {
		switch (face.toUpperCase()) {
		case "NORTH":
			if (y <= 4)
				y++;
			break;
		case "SOUTH":
			if (y >= 1)
				y--;
			break;
		case "EAST":
			if (x <= 4)
				x++;
			break;
		case "WEST":
			if (x >= 1)
				x--;
			break;
		default:
			break;
		}
	}

	/*
	 * private static String getFace() { String face = new String(); do {
	 * System.out.println("Enter facing direction: "); face = sc.nextLine(); } while
	 * (!face.equalsIgnoreCase(north) && !face.equalsIgnoreCase(south) &&
	 * !face.equalsIgnoreCase(east) && !face.equalsIgnoreCase(west));
	 * 
	 * return face; }
	 * 
	 * private static int[] placeRobot() { do {
	 * System.out.println("Enter the values X to place the robot on tabletop: ");
	 * coordinates[0] = sc.nextInt(); } while (coordinates[0] > 5 || coordinates[0]
	 * < 0); do {
	 * System.out.println("Enter the values Y to place the robot on tabletop: ");
	 * coordinates[1] = sc.nextInt(); } while (coordinates[1] > 5 || coordinates[1]
	 * < 0); return coordinates; }
	 */

}
