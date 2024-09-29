// this class creates the deck of 41 cards and shuffles them
// we saw from chapter 12 that they used an array of objects but following our proposal we will be using arraylists to hold the objects
import java.util.*;

public class Deck {
	// its private so that it is exclusive to this class 
	// we declare an arraylist that will hold  acard data type named cards
	private ArrayList<Card> cards;
	
	// this is the constructor for the deck class
	public Deck () {
		// now we properly initialize the  arraylist
		// we are basically saying that the arraylist that holds card objects should be referred to as cards
		cards = new ArrayList<>();  
		
		for ( int i =0 ; i < 4 ; i ++ ) {          // looping through faces
			for ( int k =1 ; k <=11 ; k ++ ) {     // looping through values
				if( k==11 && i==3){
				   cards.add(new Card (i ,k )); // we add a new type of object of the face (i) and value(k)
			    } else if (k!=11) {
					cards.add(new Card(i,k));
				}
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
	// since the cards will be given in "bulk" and not by 2's
	// this methhod will handle distribution o fthe cards among the players given n which is the numbe ro fplayers
	// we are basically removing fro the cards and adding to the bunch
	public List<Card> Distribute (int n) {
		List<Card> bunch = new ArrayList<>();
		
		for (int i =0 ; i < n && getsize() !=0; i ++ ) {
				bunch.add(cards.remove(0));
		}
		return bunch;
    } 		
	
	public int getsize() {
		return cards.size();
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
