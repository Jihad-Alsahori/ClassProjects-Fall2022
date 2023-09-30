/**
 * Class that represents a Street Corner 
 * Instances of this Class will be used to track the history 
 * and current location of DrunkWalker(s)
 */
package edu.cuny.csi.csc330.lab5;
public class Intersection {

	private int avenue;
	private int street;
	
	public Intersection() {
		this(0, 0);
	}

	public Intersection(int ave, int st) {
		this.avenue = ave;
		this.street = st;
	}

	@Override
	public String toString() {
		return "Intersection [avenue=" + avenue + ", street=" + street + "]";
	}

	public int getAvenue() {
		return avenue;
	}

	public void setAvenue(int avenue) {
		this.avenue = avenue;
	}

	public int getStreet() {
		return street;
	}

	public void setStreet(int street) {
		this.street = street;
	}

	public void incStreet() {
		this.street++;
	}

	public void incAvenue() {
		this.avenue++;
	}

	public void decStreet() {
		this.street--;
	}

	public void decAvenue() {
		this.avenue--;
	}

	public void copyIntersection(Intersection otherI) {
		avenue = otherI.getAvenue();
		street = otherI.getStreet();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + avenue;
		result = prime * result + street;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Intersection other = (Intersection) obj;

		if (street != other.street)
			return false;
		return true;
	}

	public static void main(String[] args) {

		
// create 2 instances , populate, display, compare ... does everything look sane??
		Intersection test1 = new Intersection(6, 10);
		Intersection test2 = new Intersection(14, 5);

		System.out.println(test2.toString());
		System.out.println(test1.toString());

		System.out.println(test1.hashCode());
		System.out.println(test2.hashCode());

		
		if (test1.equals(test2))
			System.out.println("These Corners are equal.");
		else
			System.out.println("These Corners are not equal.");
	}
}
