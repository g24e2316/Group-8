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
		while (true) //emsures that only between 2 and 5 players are entered
		{
			System.out.println("There can only be two to five players in this game.");
			System.out.println ("Enter the number of players: ");
			numplayers = in.nextInt();
			
			if(numplayers<2 || numplayers >5) //if the number of players is invalid, we ask them to enter again
			{
				continue;
			}
			
			else
			{
				break;
			}
		}
		
		players = new Player[numplayers]; // this  will store the array of player objects
		
		// a for loop to populate the player array
		for (int i =0 ; i < players.length ; i ++ )
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
		    }
			
			
			for (int i = 0; i < players.length; i++)
			{
				//System.out.println("Player " + (i + 1) + " hand before removing matching cards: " + players[i].getHand() +"\n");
				players[i].matchingcards(); // Remove matching cards from each player's hand
				//System.out.println("Player " + (i + 1) + " hand after removing matching cards: " + players[i].getHand() + "\n");
            }
	}
	
	public void play()
	{
		
		boolean ans = true;
		
		do
		{
			for(int x =1; x <= players.length; x++)
			{
				Hand hand = new Hand(players[x-1].getHand());
				
				System.out.println("\nPlayer " + x + ": " + players[x-1].getHand() + "\n");
				System.out.println("Which card would you like to give to the next player?");
				System.out.println("Face (0 - Clubs, 1 - diamonds, 2 - hearts, 3 - spades): ");
				int facePos = in.nextInt();
				
				System.out.println("Number (1 - Ace, 11 - Jack): ");
				int numPos = in.nextInt();
				
				Card card = new Card(facePos, numPos);		//create a new  card variable that the player wants to pass on.
				
				if(x == players.length)		//hands the chosen card to the next player in the game
				{
					hand.swap(card, players[0]);
				}
				else
				{
					hand.swap(card, players[x]);
				}
				
				players[x-1].matchingcards();
				//System.out.println("Player " + x + players[x-1].getHand() + "\n");
			}
			
			for(int i =0; i<players.length; i++)	//if a player has only 1 card left and that card is a jack of spades, they loose and the game ends.
			{
				players[i].matchingcards();
				if((players[i].getSize() == 1) && (players[i].getHand().get(0).getvalue() == 11))
				{
					ans = false;
					System.out.println("The game is over and Player " + (i+1) + " lost.");
				}
			}
			
		} while(ans);
	}
}	