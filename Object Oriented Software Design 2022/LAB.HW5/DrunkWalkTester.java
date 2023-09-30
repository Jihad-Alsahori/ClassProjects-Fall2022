package edu.cuny.csi.csc330.lab5;
import java.util.*;

public class DrunkWalkTester {
private Scanner input;
	
	public DrunkWalkTester() {
		init();
	}
	
	private void init() {
		input = new Scanner(System.in);
	}

	public void runTest(int steps) {

		System.out.print("Enter the starting avenue value: ");
		int avenue = input.nextInt();
		System.out.print("Enter the starting street value: ");
		int street = input.nextInt();

// make the Drunkard with initial position
		DrunkWalker billy = new DrunkWalker(avenue, street);

		billy.fastForward(steps);

		String location = billy.getLocation();

// get distance from start
		int distance = billy.howFar();

		System.out.println("Billy's " + location);
		System.out.println("That's " + distance + " blocks from start.");

		billy.displayWalkDetails();

		DrunkWalker harvey = new DrunkWalker(avenue, street);

		if (harvey.howFar() > billy.howFar())
			System.out.println("Harvey wins race!");

		else
			System.out.println("Billy wins race!");

		System.out.println("\nHarvey Stats!\n");
		harvey.displayWalkDetails();
		System.out.println("\nBilly stats\n");
		billy.displayWalkDetails();
	}

	public static void main(String[] args) {
		DrunkWalkTester tester = new DrunkWalkTester();

		int steps = 29;
		if (args.length == 1) {
			steps = Integer.parseInt(args[0]);
		}

		tester.runTest(steps);
		System.exit(0);

	}

}
