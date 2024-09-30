import java.util.*;

public class Hand
{
	private ArrayList<Card> hand;
	private int cardTotal;
	private String name;
	private int handSize;
	
	public Hand(String name)
	{
		this.name = name;
		this.cardTotal = 0;
		this.handSize = 0;
	}
	
	public void insert(Card card) //to insert a card that has been passed to the player
	{
		this.handSize++;
	}
	
	public void remove(int pos)	//for removing a card at the specified position in the players hand
	{
		if((pos<= hand.size()) && (pos>0))
		{
			hand.remove(pos);
			this.handSize--;
		}
	}
	
	public void swap(Card card)
	{
		
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
	
	public int getHandTotal()
	{
		return this.cardTotal;
	}
	
	/*public String toString()
	{
		
	}/*
}
	