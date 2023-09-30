package edu.cuny.csi.csc330.lab4;

public class Main {
	public static void main(String[] args) {

		TV Tell = new TV();
		System.out.println("New Tv: ");
		System.out.println(Tell.toString());

		Tell.setSource("15, 16");
		Tell.setConnection("Strong");
		Tell.setBrightness(75);
		System.out.println("\nTheSecondDay");
		System.out.println(Tell.toString());

//Take off the flight
		Tell.TTV();
//And set speed
		Tell.setSpeed(200);
		System.out.println("\nMorning News Channels");
		System.out.println(Tell.toString());

//land the flight
		Tell.toString();
//And set speed
		Tell.setSpeed(0);
		System.out.println("\nNight News Channels");
		System.out.println(Tell.toString());
	}
}
