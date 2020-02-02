package com.test.robotmoverprogram;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.test.robotmoverprogram.RobotMover;

class RobotMoverTest {

	@Test
	public void testGetPLaceRobotValueNorth() {
		String command = "PLACE0,0,North";
		assertTrue(RobotMover.getPLaceRobotValue(command));
	}

	@Test
	public void testGetPLaceRobotValueSouth() {
		String command = "PLACE0,0,SOUTH";
		assertTrue(RobotMover.getPLaceRobotValue(command));
	}

	@Test
	public void testGetPLaceRobotValueEast() {
		String command = "PLACE0,0,EAST";
		assertTrue(RobotMover.getPLaceRobotValue(command));
	}

	@Test
	public void testGetPLaceRobotValueWest() {
		String command = "PLACE0,0,WEST";
		assertTrue(RobotMover.getPLaceRobotValue(command));
	}

	@Test
	public void testGetPLaceRobotValueXGt5() {
		String command = "PLACE6,0,WEST";
		assertFalse(RobotMover.getPLaceRobotValue(command));
	}

	@Test
	public void testGetPLaceRobotValueXLt0() {
		String command = "PLACE-1,0,WEST";
		assertFalse(RobotMover.getPLaceRobotValue(command));
	}

	@Test
	public void testGetPLaceRobotValueYGt5() {
		String command = "PLACE0,6,WEST";
		assertFalse(RobotMover.getPLaceRobotValue(command));
	}

	@Test
	public void testGetPLaceRobotValueYLt0() {
		String command = "PLACE0,-1,WEST";
		assertFalse(RobotMover.getPLaceRobotValue(command));
	}

	@Test
	public void testGetPLaceRobotValueXYGt5() {
		String command = "PLACE6,6,WEST";
		assertFalse(RobotMover.getPLaceRobotValue(command));
	}

	@Test
	public void testGetPLaceRobotValueXYLt0() {
		String command = "PLACE-1,-1,WEST";
		assertFalse(RobotMover.getPLaceRobotValue(command));
	}

	@Test
	public void testGetPLaceRobotValueWrongPlace() {
		String command = "PLACK-1,0,WEST";
		assertFalse(RobotMover.getPLaceRobotValue(command));
	}

	@Test
	public void testGetPLaceRobotValueXGT5YLt0() {
		String command = "PLACE6,-1,WEST";
		assertFalse(RobotMover.getPLaceRobotValue(command));
	}

	@Test
	public void testGetPLaceRobotValueXLT0YGt5() {
		String command = "PLACE-1,6,WEST";
		assertFalse(RobotMover.getPLaceRobotValue(command));
	}

	@Test
	public void testGetPLaceRobotValueWrongFace() {
		String command = "PLACK-1,0,ASDF";
		assertFalse(RobotMover.getPLaceRobotValue(command));
	}

	@Test
	public void testGetPLaceRobotValueWrongGTValues() {
		String command = "PLACK7,7,ASDF";
		assertFalse(RobotMover.getPLaceRobotValue(command));
	}

	@Test
	public void testGetPLaceRobotValueWrongLTValues() {
		String command = "PLACK-1,-1,ASDF";
		assertFalse(RobotMover.getPLaceRobotValue(command));
	}

	@Test
	public void testGetPLaceRobotValueLenlt10() {
		String command = "PLACK7,7";
		assertFalse(RobotMover.getPLaceRobotValue(command));
	}

	@Test
	public void testFaceDirectionNorthToRight() {
		String command = "RIGHT", face = "NORTH";
		assertEquals("EAST", RobotMover.faceDirection(command, face));
	}

	@Test
	public void testFaceDirectionNorthToLeft() {
		String command = "LEFT", face = "NORTH";
		assertEquals("WEST", RobotMover.faceDirection(command, face));
	}

	@Test
	public void testFaceDirectionSouthToRight() {
		String command = "RIGHT", face = "SOUTH";
		assertEquals("WEST", RobotMover.faceDirection(command, face));
	}

	@Test
	public void testFaceDirectionSouthToLeft() {
		String command = "LEFT", face = "SOUTH";
		assertEquals("EAST", RobotMover.faceDirection(command, face));
	}

	@Test
	public void testFaceDirectionEastToRight() {
		String command = "RIGHT", face = "EAST";
		assertEquals("SOUTH", RobotMover.faceDirection(command, face));
	}

	@Test
	public void testFaceDirectionEastToLeft() {
		String command = "LEFT", face = "EAST";
		assertEquals("NORTH", RobotMover.faceDirection(command, face));
	}

	@Test
	public void testFaceDirectionWestToRight() {
		String command = "RIGHT", face = "WEST";
		assertEquals("NORTH", RobotMover.faceDirection(command, face));
	}

	@Test
	public void testFaceDirectionWestToLeft() {
		String command = "LEFT", face = "WEST";
		assertEquals("SOUTH", RobotMover.faceDirection(command, face));
	}

	@Test
	public void testStartOperations() {
		String command = "PLACE2,2,WEST", face = "WEST";
		assertEquals(face, RobotMover.startOperation(command, face));
	}

	@Test
	public void testStartOperationsMoveNorth() {
		String command = "MOVE", face = "NORTH";
		assertEquals(face, RobotMover.startOperation(command, face));
	}

	@Test
	public void testStartOperationsMoveSouth() {
		String command = "MOVE", face = "SOUTH";
		assertEquals(face, RobotMover.startOperation(command, face));
	}

	@Test
	public void testStartOperationsMoveEast() {
		String command = "MOVE", face = "EAST";
		assertEquals(face, RobotMover.startOperation(command, face));
	}

	@Test
	public void testStartOperationsMoveWest() {
		String command = "MOVE", face = "WEST";
		assertEquals(face, RobotMover.startOperation(command, face));
	}

	@Test
	public void testStartOperationsLeft() {
		String command = "LEFT", face = "EAST";
		assertEquals("NORTH", RobotMover.startOperation(command, face));
	}

	@Test
	public void testStartOperationsRight() {
		String command = "RIGHT", face = "WEST";
		assertEquals("NORTH", RobotMover.startOperation(command, face));
	}

	@Test
	public void testStartOperationsReport() {
		String command = "REPORT", face = "SOUTH";
		assertEquals(face, RobotMover.startOperation(command, face));
	}

	@Test
	public void testStartOperationsBadCommand() {
		String command = "REPRT", face = "SOUTH";
		assertEquals(face, RobotMover.startOperation(command, face));
	}

}
