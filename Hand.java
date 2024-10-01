import java.util.*;

public class Hand
{
	private ArrayList<Card> hand;
	private Card changingCard;
	private String name;
	private int handSize;
	private Player player;
	
	public Hand(ArrayList<Card> hand)
	{
		this.changingCard = null;;
		this.handSize = 0;
		this.hand = hand;
	}
	
	public void add(Card card) //to insert a card that has been passed to the player
	{
		hand.add(card);
		this.handSize++;
		
	}
	
	public void remove(Card card)	//for removing a card at the specified position in the players hand
	{
		if(!isEmpty())
		{
			hand.remove(card);
			this.handSize--;
		}
	}
	
	public void swap(Card card)
	{
		this.changingCard = card;
		
		hand.remove(changingCard);
		
	}
	
	public boolean isEmpty() //checks if the hand is finished
	{
		if(this.handSize == 0)
		{
			return true;
		}
		
		return false;
	}
	
	public boolean bothEqual(Hand other) //i don't think i neeed this method so i will probably take it out
	{
		Hand otherhand = other;
		return true;
		//if(this.
	}
	
	public int getHandSize()
	{
		return this.handSize;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	/*public String toString()
	{
		
	}*/
}
	