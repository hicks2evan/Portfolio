
public class Card {
	private int value;
	private int suit;
	
	public final static int SPADES = 0;
	public final static int HEARTS = 1;
	public final static int DIAMONDS = 2;
	public final static int CLUBS = 3;
	// private final static int JOKER = 4;
	
	private static String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
	private static String[] ranks = {null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
	
	public final static int ACE = 1;
	public final static int TWO = 2;
	public final static int THREE = 3;
	public final static int FOUR = 4;
	public static final int FIVE = 5;
	public static final int SIX = 6;
	public static final int SEVEN = 7;
	public static final int EIGHT = 8;
	public static final int NINE = 9;
	public static final int TEN = 10;
	public final static int JACK = 11;
	public final static int QUEEN = 12;
	public final static int KING = 13;
	
	public Card (int theSuit, int theValue)
	{
		value = theValue;
		suit = theSuit;
	}
	
	public String toString()
	{
		return ranks[value] + " of " + suits[suit];
	}
}
