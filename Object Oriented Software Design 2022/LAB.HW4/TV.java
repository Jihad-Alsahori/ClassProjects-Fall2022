package edu.cuny.csi.csc330.lab4;

import java.util.Date;

public class TV {
// Private instance variable

	private String channel;
	private String Connection;
	private int Brightness;
	private double Internetspeed;
	private boolean isTurnedON;
	private Date TVOnDate;
	private boolean isTurnedOFF;
	private Date TVOFFDate;

	/**
	 * Default Does nothing
	 * 
	 * @return
	 */
	public TV() {

	}

	/**
	 * @return the Channel
	 */
	public String getChannel() {
		return channel;
	}

	/**
	 * @return the Connection
	 */
	public String getConnection() {
		return Connection;
	}

	/**
	 * @return the Brightness
	 */
	public int getBrightness() {
		return Brightness;
	}

	/**
	 * @return the speed
	 */
	public double getInternetspeed() {
		return Internetspeed;
	}

	/**
	 * @return the isTurnedON
	 */
	public boolean isTurnedON() {
		return isTurnedON;
	}

	/**
	 * @return TheTVOnDate
	 */
	public Date getTVOnDate() {
		return TVOnDate;
	}

	/**
	 * @return the isTurnedOFF
	 */
	public boolean isTurnedOFF() {
		return isTurnedOFF;
	}

	/**
	 * @return The getTVOFFDate
	 */
	public Date getTVOFFDate() {
		return TVOFFDate;
	}

	public void setSource(String channel) {
		this.channel = channel;
	}

	public void setConnection(String Connection) {
		this.Connection = Connection;
	}

	public void setBrightness(int Brightness) {
		this.Brightness = Brightness;
	}

	public void setSpeed(double Internetspeed) {
		this.Internetspeed = Internetspeed;
	}

	/**
	 * @param isTurnedON the isTurnedOFF to set
	 */
	public void TTV() {
// if TV not on
		if (!TVSignal()) {
			this.isTurnedON = true;
			this.isTurnedOFF = false;
// Set date and time
			this.TVOnDate = new Date();
		}
	}

	/**
	 * @param isTurnedOFF the isTurnedON to set
	 */
	public void land() {
		// if TV on
		if (TVSignal()) {
			this.isTurnedOFF = true;
			this.isTurnedON = false;
// Set date and time
			this.TVOFFDate = new Date();
		}
	}

	public boolean TVSignal() {

		return isTurnedON && !isTurnedOFF;
	}

	@Override
	public String toString() {
		return "TV [channel =" + channel + ", Connection=" + Connection + ", Brightness=" + Brightness
				+ ", Internetspeed=" + Internetspeed + "mph \nisTurnedON=" + isTurnedON + ", TVOnDate=" + TVOnDate
				+ "\nisTurnedOFF=" + isTurnedOFF + ", TVOFFDate=" + TVOFFDate + ",  The TVSignal: " + TVSignal() + "]";
	}

}
