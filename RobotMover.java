package com.test.robotmoverprogram;

import java.util.Scanner;

/** The class takes the following commands as input:
 * PLACE X,Y,F: To place the robot on coordinates X(0-5),Y(0-5) facing(F) North, South, East or West
 * MOVE: To move the robot one unit in the direction it is facing.
 * LEFT: To rotate the robot 90 degrees to its left.
 * RIGHT: To rotate the robot 90 degrees to its right.
 * REPORT: To display the current position and face of the robot.
 */

public class RobotMover {
	static int x, y;
	static final String NORTH = "NORTH", SOUTH = "SOUTH", 
			EAST = "EAST", WEST = "WEST", PLACE = "PLACE",
			RIGHT = "RIGHT", LEFT = "LEFT", REPORT="REPORT",
			MOVE = "MOVE";

	/** 
	 * Takes command until PLACE command is given in the correct format.
	 * All the commands until then are ignored.
	 */
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Start giving commands:\n");
		String command, face = new String();
		do {
			command = sc.nextLine().replaceAll("\\s+", "");;
		} while (!getPLaceRobotValue(command));

		face = command.substring(9);

		do {
			command = sc.nextLine().replaceAll("\\s+", "");;
			face = startOperation(command, face);
		} while (true);
	}

	/**
	 * Takes command and direction that the robot is currently facing.
	 * It then checks which of the 5 commands was given and delegates accordingly.
	 * Ignores the command if it is invalid.
	 */
	
	public static String startOperation(String command, String face) {
		boolean flag = false;
		switch (command.toUpperCase()) {
		case MOVE:
			moveRobot(face);
			break;
		case LEFT:
			face = faceDirection(command, face);
			break;
		case RIGHT:
			face = faceDirection(command, face);
			break;
		case REPORT:
			System.out.println(x + "," + y + "," + face.toUpperCase());
			break;
		default:
			flag = getPLaceRobotValue(command);
			if (flag) {
				face = command.substring(9);
			}
			break;
		}
		return face;
	}

	/** 
	 * Takes PLACE command and validates its structure w.r.t. given PLACE X,Y,F format.
	 * If the format is correct, it sets the coordinates and then returns true if the 
	 * command is in expected format.
	 */
	
	public static boolean getPLaceRobotValue(String command) {
		boolean flag = false;
		if (command.length() > 9 
				&& command.substring(0, 5).equalsIgnoreCase(PLACE)
				&& Character.isDigit(command.charAt(5)) 
				&& Character.isDigit(command.charAt(7))
				&& (command.substring(9).equalsIgnoreCase(SOUTH) 
					|| command.substring(9).equalsIgnoreCase(NORTH)
					|| command.substring(9).equalsIgnoreCase(EAST)
					|| command.substring(9).equalsIgnoreCase(WEST))) {

			x = Integer.parseInt(String.valueOf(command.charAt(5)));
			y = Integer.parseInt(String.valueOf(command.charAt(7)));
			if (x <= 5 && x >= 0 && y <= 5 && y >= 0) {
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * Takes two inputs, i.e., command and direction in which the robot is currently facing.
	 * Then turns the face of the robot as asked.
	 */
	
	public static String faceDirection(String command, String face) {
		switch (face.toUpperCase()) {
		case NORTH:
			if (command.equalsIgnoreCase(RIGHT))
				face = EAST;
			else
				face = WEST;
			break;
		case SOUTH:
			if (command.equalsIgnoreCase(RIGHT))
				face = WEST;
			else
				face = EAST;
			break;
		case EAST:
			if (command.equalsIgnoreCase(RIGHT))
				face = SOUTH;
			else
				face = NORTH;
			break;
		case WEST:
			if (command.equalsIgnoreCase(RIGHT))
				face = NORTH;
			else
				face = SOUTH;
			break;
		}
		return face;
	}

	/**
	 * Takes direction in which the robot is currently facing as input.
	 * Checks if the robot will stay within the table if moved.
	 * If so, then moves it by one unit, otherwise, ignores the command.
	 */
	
	public static void moveRobot(String face) {
		switch (face.toUpperCase()) {
		case NORTH:
			if (y <= 4)
				y++;
			break;
		case SOUTH:
			if (y >= 1)
				y--;
			break;
		case EAST:
			if (x <= 4)
				x++;
			break;
		case WEST:
			if (x >= 1)
				x--;
			break;
		default:
			break;
		}
	}
}
