package pkgPokerBLL;

import org.junit.Test;

public class TestDeck {
	@Test
	public void testDraw(){
		Deck deck = new Deck();
		for (int i = 0; i < 52 ; i++) {
			Card drawCard = deck.DrawCard();
			System.out.println((i+1)+":"+" ["+drawCard.geteSuit()+"] "+drawCard.geteRank());
		}
	}
}
