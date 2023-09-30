/**
 * Partially completed Direction ENUM 
 */

package edu.cuny.csi.csc330.lab5;
import edu.cuny.csi.csc330.util.Randomizer;

public enum Direction {
	NORTH, NORTHEAST, NORTHWEST, EAST, WEST, SOUTH, SOUTHEAST, SOUTHWEST;

	public static Direction getNextRandom() {
		Randomizer randomizer = new Randomizer();
		int direction = randomizer.generateInt(1, 8);

// 1 = south, 2 = west, 3 = north, 4 = east

		if (direction == 1) { // south
			return SOUTH;
		} else if (direction == 2) { // west
			return WEST;
		} else if (direction == 3) { // north
			return NORTH;
		} else if (direction == 4) { // east
			return EAST;
		} else if (direction == 5) {
			return NORTHEAST;
		} else if (direction == 6) {
			return NORTHWEST;
		} else if (direction == 7) {
			return SOUTHEAST;
		} else {
			return SOUTHWEST;
		}

	}

	public static void main(String[] args) {

		int c = 0;
		while (c++ < 100) {
			System.out.println(Direction.getNextRandom());
		}

	}

}
