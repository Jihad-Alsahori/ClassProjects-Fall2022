package edu.cuny.csi.csc330.lab6;



import edu.cuny.csi.csc330.util.Randomizer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;


public class QuickPicker {
 
private String PROP_FILE_NAME;
private final static int SELECTION_POOL_SIZE = 30;
public final static int DEFAULT_GAME_COUNT = 3;
private final static int SELECTION_COUNT = 5;
private final static int MINIMAL_LOTTO_NUMBER = 1;
private int gameCount;
 
public enum SupportedGames {
 
MEGA_MILLIONS {
 
@Override
 
public String getPropFileName() {
 
return "megamillions"; 
}
 
};
 
public abstract String getPropFileName();
}
 
public class Pool {
 
private int numbersNeeded;
private int maxNumber;
public Pool(String poolData) {
 
this.numbersNeeded = Integer.parseInt(poolData.split("/")[0]);
 
this.maxNumber = Integer.parseInt(poolData.split("/")[1]); 
}
 
public int getNumbersNeeded() {
 
return this.numbersNeeded; 
}
 
public int getMaxNumber() {
 
return this.maxNumber; 
}
 
}
 
public QuickPicker() {
 
this.gameCount = DEFAULT_GAME_COUNT;
this.PROP_FILE_NAME = SupportedGames.MEGA_MILLIONS.getPropFileName();
 
}
 
public QuickPicker(int games, SupportedGames game) {
 
this.gameCount = games;
this.PROP_FILE_NAME = game.getPropFileName();
 
}
 
// Extra credit
 
private long calculateOdds() {
 
long resultS = 1;
long resultP = 1;
 
int selectionCount = SELECTION_COUNT;
int selectionPoolSize = SELECTION_POOL_SIZE;
 
for (int i = selectionCount; i > 0; i--) {
resultS *= i; 
resultP *= selectionPoolSize; 
selectionPoolSize--; 
}
 
return resultP / resultS;
 
}
 
private String generateTicket() throws QuickPickerException {
 
List<String> ticket = new ArrayList<>();
 
for (int i = 0; i < getPool1().getNumbersNeeded(); i++) {
 
int randomNumber = Randomizer.generateInt(MINIMAL_LOTTO_NUMBER, getPool1().getMaxNumber());
 
String val = randomNumber < 10 ? "0" + randomNumber : String.valueOf(randomNumber);
 
if (ticket.contains(val)) {
 
i--;
 
continue;
 
}
 
ticket.add(val);
 
}
 
ticket = ticket.stream().sorted().collect(Collectors.toList());
 
ticket.add(" ");
 
List<String> pool = new ArrayList<>();
 
// bonus numbers that appear after the"|"
 
for (int i = 0; i < getPool2().getNumbersNeeded(); i++) {
 
int randomNumber = Randomizer.generateInt(MINIMAL_LOTTO_NUMBER, getPool2().getMaxNumber());
 
String val = randomNumber < 10 ? "0" + randomNumber : String.valueOf(randomNumber);
 
if (pool.contains(val)) {
 
i--;
 
continue;
 
}
 
pool.add(val);
 
}
 
pool = pool.stream().sorted().collect(Collectors.toList());
 
ticket.addAll(pool);
 
return String.join(" ", ticket);
 
}
 
// displays the head
 
public void displayTicket() throws QuickPickerException {
 
displayHeading();
 
for (int i = 0; i < gameCount; i++) {
 
System.out.println(" (" + (i + 1) + ") " + generateTicket());
 
}
 
displayFooter();
 
}
 
// displays the time, games name, etc..
 
protected void displayHeading() throws QuickPickerException {
 
System.out.println(" ");
System.out.println("-------------------------------------");
System.out.println(" ------- " + getName() + "--------");
Date current = new Date();
System.out.println(" " + current + "\n");
 
}


// Extra credit
protected void displayFooter() throws QuickPickerException {
 
System.out.println("");
System.out.println("Odds of Winning : 1 in " + calculateOdds());
System.out.println("---- (c) S.I Corner Deli ----");
System.out.println("-------------------------------------");
}
 
public String getName() throws QuickPickerException {
 
return getProperties().getString("GameName");
 
}
 
private ResourceBundle getProperties() throws QuickPickerException {
 
ResourceBundle properties;
 
properties = ResourceBundle.getBundle(PROP_FILE_NAME);
 
return properties;
 
}
 
public Pool getPool1() throws QuickPickerException {
 
return new Pool(getProperties().getString("Pool1"));
 
}
 
public Pool getPool2() throws QuickPickerException {
return new Pool(getProperties().getString("Pool2"));
 
}
 
public static void main(String[] args) throws QuickPickerException {
 
int numberOfGames = DEFAULT_GAME_COUNT;
 
if (args.length > 0) {
 
numberOfGames = Integer.parseInt(args[0]);
 
}
 
for (SupportedGames game : SupportedGames.values()) {
 
QuickPicker lotto = new QuickPicker(numberOfGames, game);

lotto.displayTicket();
 
}
 
}
}

