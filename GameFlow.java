import java.util.*;

public class GameFlow
{
	private Deck deck;
	private Player [] players;
	private int numplayers;
	
	Scanner in = new Scanner( System.in);
	Random random = new Random ();
	
	public GameFlow()
	{
		deck = new Deck();
	}
	
	public void playersMethod()
	{
		System.out.println("There can only be two to five players in this game");
		System.out.println ("Enter the number of players");
		numplayers= in.nextInt();
		
		players = new Player[numplayers]; // this  will store the array of player objects
		
		// a for loop to populate the player array
		for ( int i =0 ; i < players.length ; i ++ )
		{
			players[i] = new Player ("Player" +( i+1));
		}
		// so this will have  PLayer 1, Player 2 , Player 3,Player 4 up to Player 5
	}
	
	public Player[] getPlayers()
	{
		return players;
    }
	
	public void handingCardsMethod() 
	{
		int cardstodistribute = 41/numplayers;
		int remainingcards= (41%numplayers)*numplayers;
		//while ( deck.getsize() !=0){
		    for ( int i =0 ; i< players.length; i++)
			{
				// this will call the distribute method from the deck class by 
				//giving it n(cardstodistribute)
				List<Card>maincards = deck.Distribute(cardstodistribute);
				for(int j =0 ; j < maincards.size();j++)
				{
					players[i].addcards(maincards.get(j));
				}//above for loop adds cards in the player's hands
				
			    if ( players[i].getHand().size() == cardstodistribute)
				{
					maincards.clear();
				}	
			}
		
		    for (int k=0 ; k< remainingcards; k++)
			{
				List<Card> extracard = deck.Distribute(remainingcards);
				for(int m =0; m<extracard.size();m++)
				{
					players[k].addcards( extracard.get(m));
			
			    }
			
				// players[k]. matchingcards();
               	// i commented this out because it just give the end result doesnt show the cards before removing so makes debugging hard
		    }
			// i just put this into chat to do it to make debugging easier, we can remove it later
			
			for (int i = 0; i < players.length; i++)
			{
				System.out.println("Player " + (i + 1) + " hand before removing matching cards: " + players[i].getHand() +"\n");
				players[i].matchingcards(); // Remove matching cards from each player's hand
				System.out.println("Player " + (i + 1) + " hand after removing matching cards: " + players[i].getHand() + "\n");
            }
	}
}	