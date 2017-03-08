package pkgPokerBLL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

import pkgPokerEnum.eRank;
import pkgPokerEnum.eSuit;

public class Deck { 

	private UUID DeckID;
	private ArrayList<Card> DeckCards = new ArrayList<Card>();
	
	public Deck()
	{
		//TODO: Implement This Constructor (no-arg Deck should build up a deck with 52 cards)
		
		//	This method will do a for/each, returning each rank in the enum.
		for (eRank Rank : eRank.values()) {
			for (eSuit Suit: eSuit.values()){
				if (Suit != eSuit.JOKER && Rank != eRank.JOKER) {
				//	System.out.println(Rank + " " + Suit)
					Card c = new Card(Rank, Suit);
					DeckCards.add(c);
				}
			}
		Collections.shuffle(DeckCards);
		}
	}
	
	public Card DrawCard()
	{
	
		
		return DeckCards.remove(0);
	}
}
