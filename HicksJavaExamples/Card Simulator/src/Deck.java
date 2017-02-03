import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cards;
	private Card c;
	
	public Deck()
	{
		cards = new ArrayList<Card>();
		cards.add(new Card(Card.SPADES, Card.ACE));
		cards.add(new Card(Card.SPADES, Card.TWO));
		cards.add(new Card(Card.SPADES, Card.THREE));
		cards.add(new Card(Card.SPADES, Card.FOUR));
		cards.add(new Card(Card.SPADES, Card.FIVE));
		cards.add(new Card(Card.SPADES, Card.SIX));
		cards.add(new Card(Card.SPADES, Card.SEVEN));
		cards.add(new Card(Card.SPADES, Card.EIGHT));
		cards.add(new Card(Card.SPADES, Card.NINE));
		cards.add(new Card(Card.SPADES, Card.TEN));
		cards.add(new Card(Card.SPADES, Card.JACK));
		cards.add(new Card(Card.SPADES, Card.QUEEN));
		cards.add(new Card(Card.SPADES, Card.KING));
		cards.add(new Card(Card.HEARTS, Card.ACE));
		cards.add(new Card(Card.HEARTS, Card.TWO));
		cards.add(new Card(Card.HEARTS, Card.THREE));
		cards.add(new Card(Card.HEARTS, Card.FOUR));
		cards.add(new Card(Card.HEARTS, Card.FIVE));
		cards.add(new Card(Card.HEARTS, Card.SIX));
		cards.add(new Card(Card.HEARTS, Card.SEVEN));
		cards.add(new Card(Card.HEARTS, Card.EIGHT));
		cards.add(new Card(Card.HEARTS, Card.NINE));
		cards.add(new Card(Card.HEARTS, Card.TEN));
		cards.add(new Card(Card.HEARTS, Card.JACK));
		cards.add(new Card(Card.HEARTS, Card.QUEEN));
		cards.add(new Card(Card.HEARTS, Card.KING)); 
		cards.add(new Card(Card.DIAMONDS, Card.ACE));
		cards.add(new Card(Card.DIAMONDS, Card.TWO));
		cards.add(new Card(Card.DIAMONDS, Card.THREE));
		cards.add(new Card(Card.DIAMONDS, Card.FOUR));
		cards.add(new Card(Card.DIAMONDS, Card.FIVE));
		cards.add(new Card(Card.DIAMONDS, Card.SIX));
		cards.add(new Card(Card.DIAMONDS, Card.SEVEN));
		cards.add(new Card(Card.DIAMONDS, Card.EIGHT));
		cards.add(new Card(Card.DIAMONDS, Card.NINE));
		cards.add(new Card(Card.DIAMONDS, Card.TEN));
		cards.add(new Card(Card.DIAMONDS, Card.JACK));
		cards.add(new Card(Card.DIAMONDS, Card.QUEEN));
		cards.add(new Card(Card.DIAMONDS, Card.KING));
		cards.add(new Card(Card.CLUBS, Card.ACE));
		cards.add(new Card(Card.CLUBS, Card.TWO));
		cards.add(new Card(Card.CLUBS, Card.THREE));
		cards.add(new Card(Card.CLUBS, Card.FOUR));
		cards.add(new Card(Card.CLUBS, Card.FIVE));
		cards.add(new Card(Card.CLUBS, Card.SIX));
		cards.add(new Card(Card.CLUBS, Card.SEVEN));
		cards.add(new Card(Card.CLUBS, Card.EIGHT));
		cards.add(new Card(Card.CLUBS, Card.NINE));
		cards.add(new Card(Card.CLUBS, Card.TEN));
		cards.add(new Card(Card.CLUBS, Card.JACK));
		cards.add(new Card(Card.CLUBS, Card.QUEEN));
		cards.add(new Card(Card.CLUBS, Card.KING));
	}
	
	public void printList()
	{
		for (int i = 0; i < cards.size(); i++)
		{
			System.out.println((i + 1) + " " + cards.get(i));
		}
	}
	
	public void shuffle()
	{
		for (int i = 0; i < cards.size(); i++)
		{
			int randomNumber = (int) (Math.random() * cards.size() - 1) + 1;
			c = cards.get(i);
			cards.set(i, cards.get(randomNumber));
			cards.set(randomNumber, c);
		}
	}
	
	public void shuffle(int j)
	{
		for (int a = 0; a <= j; a++)
		{
			for (int i = 0; i < cards.size(); i++)
			{
				int randomNumber = (int) (Math.random() * cards.size() - 1) + 1;
				c = cards.get(i);
				cards.set(i, cards.get(randomNumber));
				cards.set(randomNumber, c);
			}
		}
	}
	
	public Card drawFromDeck()
	{
		Random generator = new Random();
		int index = generator.nextInt(cards.size());
		return cards.remove(index);
	}
	
	public ArrayList<Card> drawFromDeck(int n)
	{
		ArrayList<Card> tempCards = new ArrayList<Card>();
		for (int i = 0; i < n; i ++)
		{
			Random generator = new Random();
			int index = generator.nextInt(cards.size());
			tempCards.add(cards.remove(index));
		}
		return tempCards;
	}
	
	public int getTotalSize()
	{
		return cards.size();
	}
}
