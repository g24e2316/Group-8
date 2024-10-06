// this class defines a regular card ( like how it looks)
import java.util.*;
public class Card
{
	private int face;
	private int value;

	public Card (int face , int value) {
		this.face= face;
		this.value = value;
	}
	public int getface() {
		return face;
	}
	public int getvalue() {
		return value;
	}
	public String toString() {
		String [] faces = { "Clubs", "Diamonds", "Hearts", "Spades"};
		String [] values= {null ,"Ace" , "2" ,"3" , "4" , "5" , "6" ,"7" , "8", "9", "10", "Jack"};
		String ans =  values[this.value] + " of " + faces[this.face];
		return ans;
	}
}