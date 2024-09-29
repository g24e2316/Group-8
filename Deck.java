// this class creates the deck of 41 cards and shuffles them
import java.util.*;

public class Deck {
	private ArrayList<Card> cards;
	
	public Deck () {
		cards = new ArrayList<>();  
		
		for ( int i =0 ; i < 4 ; i ++ ) {         // looping though faces
			for ( int k =1 ; k <=11 ; k ++ ) {   // looping though values
				if(k==11 & i ==3) { 
				cards.add(new Card (i ,k ));
				} else if (k!=11) {
					cards.add(new Card(i,k));
				}// i add a new type of object of the face (i) and value(k)
			
			}
		}
		//so this will go ahead and create a club of aces , a club of two's , a club of 3's e.t.c
	
	// to shuffle ( from stack verflow)
	Collections.shuffle(cards);
    }
	// a getter method to get the cards from the arraylist
	public ArrayList<Card> getCards () {
		return cards;
	}
	
	// this part i saw on the internet , feel free to modify
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card.toString()).append("\n");
        }
        return sb.toString();
    }
    
}	
