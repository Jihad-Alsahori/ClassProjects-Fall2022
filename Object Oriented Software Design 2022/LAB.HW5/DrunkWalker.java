package edu.cuny.csi.csc330.lab5;

import java.math.*;
import java.util.*;

public class DrunkWalker {

	private Intersection startIntersection;
	private Intersection currentIntersection;
	private Map<Integer, Intersection> stepHistory = new HashMap<Integer, Intersection>();
	private Map<Intersection, Integer> intersectionCount = new HashMap<Intersection, Integer>();
	private Integer totalSteps = 0;

	private DrunkWalker() {
		init();
	}

	public DrunkWalker(int avenue, int street) {
		this.startIntersection = new Intersection(avenue, street);
		init();
	}

	private void init() {
// What should be do here to initialize an instance??
		if (this.startIntersection == null)
			this.startIntersection = new Intersection();

		currentIntersection = new Intersection();
		currentIntersection.copyIntersection(startIntersection);
	}

	/**
	 * step in a random direction
	 */
	public void step() {

		takeAStep();

		stepHistory.put(++totalSteps, this.currentIntersection);

//if the drunk has already been to the intersection increment value, else add it to map.
		int count = intersectionCount.containsKey(currentIntersection) ? intersectionCount.get(currentIntersection) : 0;
		intersectionCount.put(currentIntersection, count + 1);

	}

	private void takeAStep() {
		Direction dir = Direction.NORTH.getNextRandom();

		Intersection newIntersection = new Intersection(currentIntersection.getStreet(),
				currentIntersection.getAvenue());

		switch (dir) {
		case NORTH:
			newIntersection.incStreet();
			break;

		case NORTHEAST:
			newIntersection.incStreet();
			newIntersection.incAvenue();
			break;

		case EAST:
			newIntersection.incAvenue();
			break;

		case SOUTHEAST:
			newIntersection.decStreet();
			newIntersection.incAvenue();
			break;

		case SOUTH:
			newIntersection.decStreet();
			break;

		case SOUTHWEST:
			newIntersection.decStreet();
			newIntersection.decAvenue();
			break;

		case WEST:
			newIntersection.decStreet();
			break;

		case NORTHWEST:
			newIntersection.incStreet();
			newIntersection.decAvenue();
			break;

		default:
			System.out.println("The drunk fell into a interdimentional portal and was never seen again.");
			System.exit(0);
		}

		currentIntersection = newIntersection;
	}

	@Override
	public String toString() {
		return "DrunkWalker [startIntersection=" + startIntersection + ", currentIntersection=" + currentIntersection
				+ ", stepHistory=" + stepHistory + "]";
	}

	/**
	 * generate string that contains current intersection/location info
	 */
	public String getLocation() {

		return String.format("Current location: DrunkWalker [avenue=%d, street=%d]", currentIntersection.getAvenue(),
				currentIntersection.getStreet());
	}

	/**
	 * Take N number of steps
	 */
	public void fastForward(int steps) {
// Considering that we already have a step() method, how would we
// implement this method? Uhh, think reuse!

		for (int i = 0; i < steps; i++)
			step();
	}

	/**
	 * Display information about this current walker instance
	 */
	public void displayWalkDetails() {

		System.out.println(
				"Starting Location: " + startIntersection + "\n" + "Current Intersection: " + currentIntersection + "\n"
						+ "Distance Travelled: " + howFar() + "\n" + "Total Steps: " + stepHistory.size() + "\n"
						+ "Unique Intersections Visited: " + intersectionCount.entrySet().size() + "\n\n");

		intersectionCount.entrySet().forEach(entry -> {
			if (entry.getValue() > 1)
				System.out.println(entry.getKey() + " was passed " + entry.getValue() + " times.");
		});

	}

	public int howFar() {
		return (Math.abs(startIntersection.getAvenue() - currentIntersection.getAvenue()))
				+ (Math.abs(startIntersection.getStreet() - currentIntersection.getStreet()));

	}

	public static void main(String[] args) {

// create Drunkard with initial position (ave,str)
		DrunkWalker billy = new DrunkWalker(6, 23);

		for (int i = 1; i <= 3; ++i) {
			billy.step();
			System.out.printf("billy's location after %d steps: %s\n", i, billy.getLocation());
		}

// get his current location
		String location = billy.getLocation();

		int distance = billy.howFar();
		System.out.println("Current location after fastForward(): " + location);
		System.out.println("That's " + distance + " blocks from start.");

		billy.fastForward(25);
		billy.displayWalkDetails();

	}

	public char[] Intersection() {
		// TODO Auto-generated method stub
		return null;
	}
}