package pkgPokerBLL;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgPokerEnum.eHandStrength;
import pkgPokerEnum.eRank;
import pkgPokerEnum.eSuit;

public class TestHands {

	@Test
	public void TestHandFlush() {

		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SEVEN, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.EIGHT, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.TEN, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.ACE, eSuit.CLUBS));
		h.EvaluateHand();
		HandScore hs = new HandScore();
		h.isHandFlush(h, hs);
		// Hand better be a TwoPair
		//assertEquals(eHandStrength.Flush.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());
		assertEquals(eHandStrength.Flush.getHandStrength(),h.getHandScore().getHandStrength().getHandStrength());
		// HI hand better be 'Four'
		assertEquals(eRank.ACE.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// Full House has one kickers.
		assertEquals(4, h.getHandScore().getKickers().size());

	}

	@Test
	public void TestTwoPair1() {

		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FIVE, eSuit.SPADES));
		h.EvaluateHand();

		// Hand better be a TwoPair
		assertEquals(eHandStrength.TwoPair.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'Four'
		assertEquals(eRank.FOUR.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// LO hand better be 'Three'
		assertEquals(eRank.THREE.getiRankNbr(), h.getHandScore().getLoHand().getiRankNbr());

		// Full House has one kickers.
		assertEquals(1, h.getHandScore().getKickers().size());

	}

	@Test
	public void TestTwoPair2() {

		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TWO, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.THREE, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.SPADES));
		h.EvaluateHand();

		// Hand better be a TwoPair
		assertEquals(eHandStrength.TwoPair.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'Four'
		assertEquals(eRank.FOUR.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// LO hand better be 'Three'
		assertEquals(eRank.THREE.getiRankNbr(), h.getHandScore().getLoHand().getiRankNbr());

		// Full House has one kickers.
		assertEquals(1, h.getHandScore().getKickers().size());

	}

	@Test
	public void TestTwoPair3() {

		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TWO, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.TWO, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.THREE, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.SPADES));
		h.EvaluateHand();

		// Hand better be a TwoPair
		assertEquals(eHandStrength.TwoPair.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'Four'
		assertEquals(eRank.FOUR.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// LO hand better be 'Three'
		assertEquals(eRank.TWO.getiRankNbr(), h.getHandScore().getLoHand().getiRankNbr());

		// Full House has one kickers.
		assertEquals(1, h.getHandScore().getKickers().size());

	}

	@Test
	public void TestAcesAndEights() {

		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.ACE, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.ACE, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.ACE, eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.EIGHT, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.EIGHT, eSuit.SPADES));
		h.EvaluateHand();

		// Hand better be a full house
	//	assertEquals(eHandStrength.AcesAndEights.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'Four'
		assertEquals(eRank.ACE.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// LO hand better be 'Three'
		assertEquals(eRank.EIGHT.getiRankNbr(), h.getHandScore().getLoHand().getiRankNbr());

		// Full House has no kickers.
		assertEquals(0, h.getHandScore().getKickers().size());

	}
	
	@Test
	public void TestFullHouse1() {

		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.SPADES));
		h.EvaluateHand();

		// Hand better be a full house
		assertEquals(eHandStrength.FullHouse.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'Four'
		assertEquals(eRank.FOUR.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// LO hand better be 'Three'
		assertEquals(eRank.THREE.getiRankNbr(), h.getHandScore().getLoHand().getiRankNbr());

		// Full House has no kickers.
		assertEquals(0, h.getHandScore().getKickers().size());

	}

	@Test
	public void TestFullHouse2() {

		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.THREE, eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.SPADES));
		h.EvaluateHand();

		// Hand better be a full house
		assertEquals(eHandStrength.FullHouse.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'Three'
		assertEquals(eRank.THREE.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// LO hand better be 'FOUR'
		assertEquals(eRank.FOUR.getiRankNbr(), h.getHandScore().getLoHand().getiRankNbr());

		// Full House has no kickers.
		assertEquals(0, h.getHandScore().getKickers().size());

	}

	@Test
	public void TestFourOfAKind1() {

		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.THREE, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.SPADES));
		h.EvaluateHand();

		// Hand better be a ThreeOfAKind
		assertEquals(eHandStrength.FourOfAKind.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'THREE'
		assertEquals(eRank.THREE.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// ThreeOfAKind has 1 kickers
		assertEquals(1, h.getHandScore().getKickers().size());
	}

	@Test
	public void TestFourOfAKind2() {

		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.SPADES));
		h.EvaluateHand();

		// Hand better be a ThreeOfAKind
		assertEquals(eHandStrength.FourOfAKind.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'FOUR'
		assertEquals(eRank.FOUR.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// ThreeOfAKind has 1 kickers
		assertEquals(1, h.getHandScore().getKickers().size());
	}

	@Test
	public void TestThreeOfAKind1() {

		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.TWO, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.SPADES));
		h.EvaluateHand();

		// Hand better be a ThreeOfAKind
		assertEquals(eHandStrength.ThreeOfAKind.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'Four'
		assertEquals(eRank.FOUR.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// ThreeOfAKind has 2 kickers
		assertEquals(2, h.getHandScore().getKickers().size());
	}

	@Test
	public void TestThreeOfAKind2() {

		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FIVE, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.SPADES));
		h.EvaluateHand();

		// Hand better be a ThreeOfAKind
		assertEquals(eHandStrength.ThreeOfAKind.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'Four'
		assertEquals(eRank.FOUR.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// ThreeOfAKind has 2 kickers
		assertEquals(2, h.getHandScore().getKickers().size());

		assertEquals(eRank.FIVE, h.getHandScore().getKickers().get(0).geteRank());
	}

	@Test
	public void TestThreeOfAKind3() {

		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.SIX, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FIVE, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.SPADES));
		h.EvaluateHand();

		// Hand better be a ThreeOfAKind
		assertEquals(eHandStrength.ThreeOfAKind.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'Four'
		assertEquals(eRank.FOUR.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// ThreeOfAKind has 2 kickers
		assertEquals(2, h.getHandScore().getKickers().size());

		assertEquals(eRank.SIX, h.getHandScore().getKickers().get(0).geteRank());
	}

	@Test
	public void TestHandPair1() {

		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FIVE, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.SIX, eSuit.SPADES));
		h.EvaluateHand();

		// Hand better be a Pair
		assertEquals(eHandStrength.Pair.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'THREE'
		assertEquals(eRank.THREE.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// Pair has 3 kickers
		assertEquals(3, h.getHandScore().getKickers().size());
	}

	@Test
	public void TestHandPair2() {

		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FIVE, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.SIX, eSuit.SPADES));
		h.EvaluateHand();

		// Hand better be a Pair
		assertEquals(eHandStrength.Pair.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'Four'
		assertEquals(eRank.FOUR.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// Pair has 3 kickers
		assertEquals(3, h.getHandScore().getKickers().size());
	}

	@Test
	public void TestHandPair3() {

		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FIVE, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FIVE, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.SIX, eSuit.SPADES));
		h.EvaluateHand();

		// Hand better be a Pair
		assertEquals(eHandStrength.Pair.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'FIVE'
		assertEquals(eRank.FIVE.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// Pair has 3 kickers
		assertEquals(3, h.getHandScore().getKickers().size());
	}

	@Test
	public void TestHandPair4() {

		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FIVE, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SIX, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.SIX, eSuit.SPADES));
		h.EvaluateHand();

		// Hand better be a Pair
		assertEquals(eHandStrength.Pair.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'SIX'
		assertEquals(eRank.SIX.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// Pair has 3 kickers
		assertEquals(3, h.getHandScore().getKickers().size());
	}
}
