package edu.cuny.csi.csc330.lab3;

import edu.cuny.csi.csc330.util.Randomizer;
import java.util.Date;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class LottoQuickPicker {

    // constants specific to current game - BUT NOT ALL GAMES
    public final static int DEFAULT_GAME_COUNT = 1;
    private final static String GAME_NAME = "Lotto";
    private final static int MAXIMUM_LOTTO_NUMBER = 59;
    private final static int MINIMAL_LOTTO_NUMBER = 1;
    private final static int SELECTION_COUNT = 6;

    
    private int gameCount;

    public LottoQuickPicker() {
        init(DEFAULT_GAME_COUNT);
    }

    public LottoQuickPicker(int games) {
        init(games);
    }

    private void init(int games) {
        this.gameCount = games;
    }
    
    
    
    
    
    
    
    private String generateTicket() {
        ArrayList<String> ticket = new ArrayList<>();
        // the game needs to generate amount of numbers
      
        for (int i = 0; i < SELECTION_COUNT; i++) {
            // generate a random randomizer
            int NumAvrege = Randomizer.generateInt(MINIMAL_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER);
 
            String val = NumAvrege < 10 ? "0" + NumAvrege : String.valueOf(NumAvrege);
           
            // one
            if (ticket.contains(val)) {
                i--;
                continue;
            }
            // if the above statement wasn't true add it to the ticket list
            ticket.add(val);
        }

        return ticket.stream()
                .sorted() // sort 
                .collect(Collectors.joining(" ")); // use to collect ticket and join by spaces
    }
    
    
 
    //calculate the odds of wining
    private long calculateOdds() {
    	long calcNum = 1,ans = 1;
    	
    	int selectionCount = SELECTION_COUNT; 
    	int selectionPoolSize = MAXIMUM_LOTTO_NUMBER;
    	
    	for (int i = selectionCount; i > 0; i--) 
    	{
    		ans *= i;
    		calcNum *= selectionPoolSize;
    	selectionPoolSize--;
    	}
    	return calcNum / ans;
    	}

    
    
    
public void displayTicket() {

        // display ticket heading
        displayHeading();
        // display selected numbers
        for (int i = 0; i < gameCount; i++) {
            System.out.println(" (" + (i + 1) + ") " + generateTicket());
        }
        // display ticket footer
        displayFooter();

    }

protected  void displayHeading() {
    System.out.println("----------------------------");
    System.out.println("-----------" + GAME_NAME + "------------");
 
Date current = new Date();
    System.out.println(" " + current + "\n");	
}


    protected void displayFooter() {
    	
    	System.out.println("Odds of Winning : 1 in " + calculateOdds());

        System.out.println("---- (c)S.I Corner Deli ----");
        System.out.println("----------------------------");
    }

    public static void main(String[] args) {
        if (args.length > 0) { 
            
        }

        LottoQuickPicker lotto = new LottoQuickPicker(7);
        lotto.displayTicket();
    }
}
