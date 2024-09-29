import java.util.*;
public class Player {
	private String name ;        // player name like player 1 , player ,2, player 3 et.c
	private ArrayList<Card> hand;  // arraylist of Card type that will be in the player's hands
	
	// a constructor that has parameters
	// will set the name
	// will set the hand to a new arraylist
	public Player( String name ) {
		this.name = name;
		this.hand = new ArrayList<>();
	}
	// a getter method to get the name of the player
	public String getName() {
		return name;
	}
	// a getter method to get the cards from the player's hands
	public  ArrayList<Card> getHand() {
		return hand;
	}
	// this method will add the cards onto the players hand
	public void addcards ( Card card ) {
		hand.add(card);
	}
	
	// this method will remove the cards from the players hand
	public void removecards( Card card) {
		hand.remove ( card) ;
	}
	
	public int getSize(){
		return hand.size();
		
	}
	
	
	// this method will compare the current card with the next card of the same player
	// if they are the same , it removes both of them
	public void matchingcards() {
		for ( int i =0 ; i < hand.size(); i ++) {
			
			boolean matched = false;
			
			for ( int j =1+i ; j<hand.size() ; j ++) {
				
				if( hand.get(i).getvalue() == hand.get(j).getvalue()) {
					hand.remove(j);
					hand.remove(i);
					i--;
					matched = true;
					break;
				}
			}
			
			
	    }
	}
	
	public  void passcards ( Player anotherplayer) {
		if ( !hand.isEmpty() ) {
			Card card = hand.remove(0);
			anotherplayer.addcards(card);
		}
	}
	// this method check if the player has the jack of spades card
	// but before it makes sure that its the last card the player is left with
	// its giving loser

	public boolean Loser() {
		if ( hand.size() == 1) {
			Card lastCard = hand.get(0); 
            return lastCard.toString().equalsIgnoreCase("Jack of Spades");
	    } else {
			return false;
		}
	
	}
	
	
	// this method handles situation where the are no longer cards in the player's hands
	// its giving winner
	
	public boolean nocards() {
		return hand.isEmpty();
	}
}

	
	
				
		
	
		
		
	
	
	
				
		
	
		
