package pkgPokerBLL;

import java.util.ArrayList;
import java.util.UUID;

import pkgPokerEnum.eRank;
import pkgPokerEnum.eSuit;

public class Deck {

	private UUID DeckID;
	private ArrayList<Card> DeckCards = new ArrayList<Card>();  
	private int[] cardsIndexesForDraw = new int[52]; 			
	private int IndexeForDraw = 0; 								
	
	public Deck()
	{
		Card card = null;
		for (eRank Rank : eRank.values()) {
			if(Rank.getiRankNbr() == eRank.JOKER.getiRankNbr()){
				continue;
			}
			for(eSuit Suit : eSuit.values()){
				if(Suit.getiSuitNbr()== eSuit.JOKER.getiSuitNbr()){
					continue;
				}
				card = new Card(Rank, Suit);
				this.DeckCards.add(card);
			}
		}
		RandomSort randomSort = new RandomSort();
		randomSort.changePosition();
		this.cardsIndexesForDraw = randomSort.getPositions();
	}
	public Card DrawCard()
	{
		Card card = this.DeckCards.get(this.cardsIndexesForDraw[this.IndexeForDraw++]);
		return card;
	}
	
	public static void main(String[] args) {
		Card card = new Deck().DrawCard();
		System.out.println(card.geteRank());
	}
	
}
