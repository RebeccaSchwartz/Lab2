package pkgPokerBLL;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgPokerEnum.eHandStrength;
import pkgPokerEnum.eRank;
import pkgPokerEnum.eSuit;

public class TestHands { 
	
	@Test
	public void TestRoyalFlush() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.ACE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.KING,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.QUEEN,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.JACK,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.TEN,eSuit.CLUBS));
		h.EvaluateHand();
		
		// Hand is Royal Flush 
		assertEquals(eHandStrength.RoyalFlush.getHandStrength(),h.getHandScore().getHandStrength().getHandStrength());
	}
	@Test 
	public void TestStraightFlush(){
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.KING,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.NINE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.QUEEN,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.JACK,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.TEN,eSuit.CLUBS));
		h.EvaluateHand();
		
		// Hand is Straight Flush 
		assertEquals(eHandStrength.StraightFlush.getHandStrength(),h.getHandScore().getHandStrength().getHandStrength());
		// HI hand better be 'King'
		assertEquals(eRank.KING.getiRankNbr(),h.getHandScore().getHiHand().getiRankNbr());
	}
	@Test
	public void TestFourOfAKind() {

		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.THREE, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE, eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.THREE, eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.TWO, eSuit.CLUBS));
		h.EvaluateHand();

		// Hand is Four of a Kind
		assertEquals(eHandStrength.FourOfAKind.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());
		// Hi Hand is three
		assertEquals(eRank.THREE.getiRankNbr(),h.getHandScore().getHiHand().getiRankNbr());
		// Full House has one kickers.
		assertEquals(1,h.getHandScore().getKickers().size());
	}
	
	@Test
	public void TestFourOfAKind2() { 

		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TEN, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.EIGHT, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.EIGHT, eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.EIGHT, eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.EIGHT, eSuit.CLUBS));
		h.EvaluateHand();
		
		// Hand is Four of a Kind
		assertEquals(eHandStrength.FourOfAKind.getHandStrength(),h.getHandScore().getHandStrength().getHandStrength());
		// Hi Hand is two
		assertEquals(eRank.EIGHT.getiRankNbr(),h.getHandScore().getHiHand().getiRankNbr());
		// Full House has one kickers.
		assertEquals(1,h.getHandScore().getKickers().size());
	}
	@Test
	public void TestAcesAndEights1() {
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.ACE,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.ACE,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.EIGHT,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.EIGHT,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.CLUBS));
		h.EvaluateHand();
		// Hand is Aces and Eights
		assertEquals(eHandStrength.AcesAndEights.getHandStrength(),h.getHandScore().getHandStrength().getHandStrength());
		// Aces and Eights has one kickers.
		assertEquals(1,h.getHandScore().getKickers().size());
	}
	@Test
	public void TestAcesAndEights2() {
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.ACE,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.ACE,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.EIGHT,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.EIGHT,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.JACK,eSuit.CLUBS));
		h.EvaluateHand();
		// Hand is Aces and Eights
		assertEquals(eHandStrength.AcesAndEights.getHandStrength(),h.getHandScore().getHandStrength().getHandStrength());
		// Aces and Eights has one kickers.
		assertEquals(1,h.getHandScore().getKickers().size());
	}
	@Test
	public void TestFlush() {
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TWO,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.NINE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SEVEN,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.JACK,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.CLUBS));
		h.EvaluateHand();
		// Hand is Flush
		assertEquals(eHandStrength.Flush.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());
		// Hi Hand is two
		assertEquals(eRank.JACK.getiRankNbr(),h.getHandScore().getHiHand().getiRankNbr());
		// Flush has no kickers.
		assertEquals(4,h.getHandScore().getKickers().size());
		
	}
	
	@Test
	public void TestStraight() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.SIX, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.TEN, eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.NINE, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.EIGHT, eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.SEVEN, eSuit.SPADES));
		h.EvaluateHand();
		//Hand is Straight
		assertEquals(eHandStrength.Straight.getHandStrength(),h.getHandScore().getHandStrength().getHandStrength());
		// Hi Hand is Jack
		assertEquals(eRank.TEN.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());
		// Straight has no kickers
		assertEquals(0,h.getHandScore().getKickers().size());
	}


	@Test
	public void TestFullHouse() { 
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.SPADES));		
		h.EvaluateHand();
		
		//	Hand better be a full house
		assertEquals(eHandStrength.FullHouse.getHandStrength(),h.getHandScore().getHandStrength().getHandStrength());
		
		//	HI hand better be 'Four'
		assertEquals(eRank.FOUR.getiRankNbr(),h.getHandScore().getHiHand().getiRankNbr());
		
		//	LO hand better be 'Three'
		assertEquals(eRank.THREE.getiRankNbr(),h.getHandScore().getLoHand().getiRankNbr());
		
		//	Full House has no kickers.
		assertEquals(0,h.getHandScore().getKickers().size());
		
	}
	@Test
	public void TestThreeOfAKind1() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.TWO,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.SPADES));		
		h.EvaluateHand();
		
		//		Hand better be a three of a kind
		assertEquals(eHandStrength.ThreeOfAKind.getHandStrength(),h.getHandScore().getHandStrength().getHandStrength());
		
		//		HI hand better be 'Four'
		assertEquals(eRank.FOUR.getiRankNbr(),h.getHandScore().getHiHand().getiRankNbr());
		
		//		Three of a kind has 2 kickers.
		assertEquals(2,h.getHandScore().getKickers().size());
	}	
	@Test
	public void TestThreeOfAKind2() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.SPADES));		
		h.EvaluateHand();
		
		//		Hand better be a three of a kind
		assertEquals(eHandStrength.ThreeOfAKind.getHandStrength(),h.getHandScore().getHandStrength().getHandStrength());
		
		//		HI hand better be 'Four'
		assertEquals(eRank.FOUR.getiRankNbr(),h.getHandScore().getHiHand().getiRankNbr());
		
		//		Full House has no kickers.
		assertEquals(2,h.getHandScore().getKickers().size());

	}			
	@Test
	public void TestThreeOfAKind3() {
		
		Hand h = new Hand(); 
		h.AddCardToHand(new Card(eRank.SIX,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.SPADES));		
		h.EvaluateHand();
		
		//		Hand better be a three of a kind
		assertEquals(eHandStrength.ThreeOfAKind.getHandStrength(),h.getHandScore().getHandStrength().getHandStrength());
		
		//		HI hand better be 'Four'
		assertEquals(eRank.FOUR.getiRankNbr(),h.getHandScore().getHiHand().getiRankNbr());
		
		//		Three of a kind has 2 kickers.
		assertEquals(2,h.getHandScore().getKickers().size());
	}	
	@Test
	public void TestisHandTwoPair1(){
		//Testing when kicker is highest ranked card
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.ACE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.JACK,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.JACK,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.ACE,eSuit.CLUBS));
		h.EvaluateHand();

		//Hand better be two pair
		assertEquals(eHandStrength.TwoPair.getHandStrength(),h.getHandScore().getHandStrength().getHandStrength());
		//HI hand better be 'Ace'
		assertEquals(eRank.ACE.getiRankNbr(),h.getHandScore().getHiHand().getiRankNbr());	
		//LO Hand better be "Jack"
		assertEquals(eRank.JACK.getiRankNbr(),h.getHandScore().getLoHand().getiRankNbr());	
		//TwoPair has 1 Kicker
		assertEquals(1,h.getHandScore().getKickers().size());
	}
	
	@Test
	public void TestisHandTwoPair2(){
		//Testing when kicker is highest ranked card
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.JACK,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.JACK,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.ACE,eSuit.CLUBS));
		h.EvaluateHand();

		//Hand better be two pair
		assertEquals(eHandStrength.TwoPair.getHandStrength(),h.getHandScore().getHandStrength().getHandStrength());
		//HI hand better be 'Jack'
		assertEquals(eRank.JACK.getiRankNbr(),h.getHandScore().getHiHand().getiRankNbr());	
		//LO Hand better be "Four"
		assertEquals(eRank.FOUR.getiRankNbr(),h.getHandScore().getLoHand().getiRankNbr());	
		//TwoPair has 1 Kicker
		assertEquals(1,h.getHandScore().getKickers().size());


	}
	@Test
	public void TestisHandTwoPair3(){
		//Testing when kicker is middle ranked card
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.ACE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.ACE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.JACK,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.JACK,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.KING,eSuit.CLUBS));
		h.EvaluateHand();

		//Hand better be two pair
		assertEquals(eHandStrength.TwoPair.getHandStrength(),h.getHandScore().getHandStrength().getHandStrength());
		//HI hand better be 'Ace'
		assertEquals(eRank.ACE.getiRankNbr(),h.getHandScore().getHiHand().getiRankNbr());	
		//LO Hand better be "Jack"
		assertEquals(eRank.JACK.getiRankNbr(),h.getHandScore().getLoHand().getiRankNbr());	
		//TwoPair has 1 Kicker
		assertEquals(1,h.getHandScore().getKickers().size());
	}
	@Test
	public void TestisHandPair(){
			//Testing when pair is highest ranked card
			Hand h = new Hand();
			h.AddCardToHand(new Card(eRank.ACE,eSuit.CLUBS));
			h.AddCardToHand(new Card(eRank.ACE,eSuit.DIAMONDS));
			h.AddCardToHand(new Card(eRank.KING,eSuit.CLUBS));
			h.AddCardToHand(new Card(eRank.JACK,eSuit.HEARTS));
			h.AddCardToHand(new Card(eRank.QUEEN,eSuit.CLUBS));
			h.EvaluateHand();
			
			//Hand better be two pair
			assertEquals(eHandStrength.Pair.getHandStrength(),h.getHandScore().getHandStrength().getHandStrength());
			//Pair better be "ACE"
			assertEquals(eRank.ACE.getiRankNbr(),h.getHandScore().getHiHand().getiRankNbr());	
			//TwoPair has 3 Kickers
			assertEquals(3,h.getHandScore().getKickers().size());
			
			
		}
	@Test
	public void TestisHandPair2(){
		//Testing when pair is second highest ranked card
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.ACE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.KING,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.KING,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.JACK,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.QUEEN,eSuit.CLUBS));
		h.EvaluateHand();
		
		//Hand better be two pair
		assertEquals(eHandStrength.Pair.getHandStrength(),h.getHandScore().getHandStrength().getHandStrength());
		//Pair better be "KING"
		assertEquals(eRank.KING.getiRankNbr(),h.getHandScore().getHiHand().getiRankNbr());	
		//TwoPair has 1 Kickers
		assertEquals(3,h.getHandScore().getKickers().size());;
	}
	@Test
	public void TestisHandPair3(){
		//Testing when pair is third highest ranked card
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.ACE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.KING,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.QUEEN,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.JACK,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.QUEEN,eSuit.CLUBS));
		h.EvaluateHand();
		
		//Hand better be two pair
		assertEquals(eHandStrength.Pair.getHandStrength(),h.getHandScore().getHandStrength().getHandStrength());
		//Pair better be "Queen"
		assertEquals(eRank.QUEEN.getiRankNbr(),h.getHandScore().getHiHand().getiRankNbr());	
		//TwoPair has 1 Kickers
		assertEquals(3,h.getHandScore().getKickers().size());;
	}
	@Test
	public void TestisHandPair4(){
		//Testing when pair is lowest ranked card
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.ACE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.JACK,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.KING,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.JACK,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.QUEEN,eSuit.CLUBS));
		h.EvaluateHand();
			
		//Hand better be two pair
		assertEquals(eHandStrength.Pair.getHandStrength(),h.getHandScore().getHandStrength().getHandStrength());
		//Pair better be "ACE"
		assertEquals(eRank.JACK.getiRankNbr(),h.getHandScore().getHiHand().getiRankNbr());	
		//TwoPair has 3 Kickers
		assertEquals(3,h.getHandScore().getKickers().size());;
	}
	@Test
	public void TestHighHand(){
		//Testing high hand
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.NINE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.TWO,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.DIAMONDS));
		h.EvaluateHand();
		//Hand better be high car
		assertEquals(eHandStrength.HighCard.getHandStrength(),h.getHandScore().getHandStrength().getHandStrength());
		assertEquals(eRank.NINE.getiRankNbr(),h.getHandScore().getHiHand().getiRankNbr());
	}


}
