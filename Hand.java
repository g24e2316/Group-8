import java.util.*;

public class Hand
{
	private ArrayList<Card> hand;
	private Card changingCard;
	private String name;
	private int handSize;
	private Player player;
	
	public Hand(ArrayList<Card> handx)
	{
		this.handSize = 0;
		this.hand = handx;
	}
	
	public void add(Card card) //to insert a card that has been passed to the player
	{
		hand.add(card);
		this.handSize++;
	}

	
	public void swap(Card card, Player nextPlayer)
	{
		this.hand.add(card);
		nextPlayer.getHand().add(card);
	}
	
	public boolean isEmpty() //checks if the hand is finished
	{
		if(this.handSize == 0)
		{
			return true;
		}
		
		return false;
	}
	
	
	public int getHandSize()
	{
		return this.handSize;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String toString()
	{
		return "Cards: [" + this.hand + "]\n";
	}
}
	