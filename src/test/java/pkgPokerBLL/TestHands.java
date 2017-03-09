package pkgPokerBLL;
import static org.junit.Assert.*;
import org.junit.Test;
import pkgPokerEnum.eHandStrength;
import pkgPokerEnum.eRank;
import pkgPokerEnum.eSuit;

public class TestHands {
// Testing is provided for all the cases
	
	@Test
	public void TestHandStraightFlush01() {
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TWO,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.CLUBS));	
		
		h.EvaluateHand();
		//Hand better be a RoyalFlush
		assertEquals(eHandStrength.StraightFlush.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
	}
	@Test
	public void TestHandStraightFlush02() {
		Hand h = new Hand();
		
		h.AddCardToHand(new Card(eRank.THREE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.CLUBS));	
		h.AddCardToHand(new Card(eRank.SEVEN,eSuit.CLUBS));
		
		h.EvaluateHand();
		assertEquals(eHandStrength.StraightFlush.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
	}
	@Test
	public void TestHandStraightFlush03() {
		Hand h = new Hand();
		
		h.AddCardToHand(new Card(eRank.THREE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.DIAMONDS));	
		h.AddCardToHand(new Card(eRank.SEVEN,eSuit.DIAMONDS));
		
		h.EvaluateHand();
		
		//Hand better be a RoyalFlush
		assertEquals(eHandStrength.StraightFlush.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
	}
	@Test
	public void TestHandRoyalFlush01() {
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TWO,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.HEARTS));	
		
		h.EvaluateHand();
		
		assertEquals(eHandStrength.RoyalFlush.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
	}
	
	@Test
	public void TestHandRoyalFlush02() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.SEVEN,eSuit.HEARTS));	
		
		h.EvaluateHand();
		
		//Hand better be a RoyalFlush
		assertEquals(eHandStrength.RoyalFlush.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
	}
	@Test
	public void TestHandFlush01() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TWO,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.TEN,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.KING,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.HEARTS));	
		
		h.EvaluateHand();
		
		//Hand better be a Flush
		assertEquals(eHandStrength.Flush.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
	}
	
	
	@Test
	public void TestHandFlush02() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TWO,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.TEN,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.KING,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.DIAMONDS));	
		
		h.EvaluateHand();
		
		//Hand better be a Flush
		assertEquals(eHandStrength.Flush.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
	}
	@Test
	public void TestHandStraight01() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TWO,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.JOKER));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.DIAMONDS));	
		
		h.EvaluateHand();
		
		assertEquals(eHandStrength.Straight.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
	}
	@Test
	public void TestHandStraight02() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.DIAMONDS));	
		h.AddCardToHand(new Card(eRank.SEVEN,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.EIGHT,eSuit.JOKER));
		
		h.EvaluateHand();
		
		//Hand better be a Flush
		assertEquals(eHandStrength.Straight.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
	}
	
	@Test
	public void TestisHandFourOfAKind01() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TWO,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.TWO,eSuit.JOKER));
		h.AddCardToHand(new Card(eRank.TWO,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.TWO,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.DIAMONDS));	
		
		h.EvaluateHand();
		
		//Hand better be a Flush
		assertEquals(eHandStrength.FourOfAKind.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
	}
	
	@Test
	public void TestisHandFourOfAKind02() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.SIX,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.JOKER));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.ACE,eSuit.DIAMONDS));	
		
		h.EvaluateHand();
		
		//Hand better be a Flush
		assertEquals(eHandStrength.FourOfAKind.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
	}
	
	@Test
	public void TestisHandThreeOfAKind01() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TWO,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.TWO,eSuit.JOKER));
		h.AddCardToHand(new Card(eRank.TWO,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.EIGHT,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.DIAMONDS));	
		
		h.EvaluateHand();
		
		//Hand better be a Flush
		assertEquals(eHandStrength.ThreeOfAKind.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
	}
	
	@Test
	public void TestisHandThreeOfAKind02() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.SIX,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.JOKER));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.TWO,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.DIAMONDS));	
		
		h.EvaluateHand();
		
		//Hand better be a Flush
		assertEquals(eHandStrength.FourOfAKind.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
	}
	@Test
	public void TestisHandTwoPair01() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TWO,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.TWO,eSuit.JOKER));
		h.AddCardToHand(new Card(eRank.EIGHT,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.EIGHT,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.DIAMONDS));	
		
		h.EvaluateHand();
		
		//Hand better be a Flush
		assertEquals(eHandStrength.TwoPair.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
	}
	
	@Test
	public void TestisHandTwoPair02() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.SIX,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.JOKER));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.TWO,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.DIAMONDS));	
		        
		h.EvaluateHand();
		
		//Hand better be a Flush
		assertEquals(eHandStrength.FourOfAKind.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
	}
	
	@Test
	public void TestisHandPair01() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TWO,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.TWO,eSuit.JOKER));
		h.AddCardToHand(new Card(eRank.TEN,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.EIGHT,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.DIAMONDS));	
		
		h.EvaluateHand();
		
		assertEquals(eHandStrength.Pair.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
	}
	
	@Test
	public void TestisHandPair02() {
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.ACE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.QUEEN,eSuit.JOKER));
		h.AddCardToHand(new Card(eRank.TWO,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.TWO,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.DIAMONDS));	
		        
		h.EvaluateHand();
		
		assertEquals(eHandStrength.Pair.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
	}
	
	@Test
	public void isAcesAndEights01() {
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.ACE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.ACE,eSuit.JOKER));
		h.AddCardToHand(new Card(eRank.EIGHT,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.EIGHT,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.DIAMONDS));	
		        
		h.EvaluateHand();
		
		assertEquals(eHandStrength.AcesAndEights.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
	}
	
	@Test
	public void isAcesAndEights02() {
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.ACE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.ACE,eSuit.JOKER));
		h.AddCardToHand(new Card(eRank.EIGHT,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.EIGHT,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.TWO,eSuit.DIAMONDS));	
		        
		h.EvaluateHand();
		
		assertEquals(eHandStrength.AcesAndEights.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
	}
	
	@Test
	public void TestFullHouse01() {
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.SPADES));	
		h.EvaluateHand();
		
		//	Hand better be a full house
		assertEquals(eHandStrength.FullHouse.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//	HI hand better be 'Four'
		assertEquals(eRank.FOUR.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr()); // 4 4
		
		//	LO hand better be 'Three'
		assertEquals(eRank.THREE.getiRankNbr(),
				h.getHandScore().getLoHand().getiRankNbr()); //3 3
		
		//	Full House has no kickers.
		assertEquals(0,h.getHandScore().getKickers().size()); //0
		
	}
	
	@Test
	public void TestFullHouse02() {
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.SPADES));	
		h.EvaluateHand();
		
		//	Hand better be a full house
		assertEquals(eHandStrength.FullHouse.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//	HI hand better be 'Four'
		assertEquals(eRank.FOUR.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr()); // 4 4
		
		//	LO hand better be 'Three'
		assertEquals(eRank.FIVE.getiRankNbr(),
				h.getHandScore().getLoHand().getiRankNbr()); //3 3
		
		//	Full House has no kickers.
		assertEquals(0,h.getHandScore().getKickers().size()); //0
		
	}
	

}
