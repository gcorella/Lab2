package pkgPokerBLL;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import pkgPokerEnum.eCardNo;
import pkgPokerEnum.eHandStrength;
import pkgPokerEnum.eRank;
import pkgPokerEnum.eSuit;

public class Hand {

	private UUID HandID; 
	private boolean bIsScored; 
	private HandScore HS;
	private ArrayList<Card> CardsInHand = new ArrayList<Card>(); 
	
	public Hand()
	{
		
	}
	
	public void AddCardToHand(Card c)
	{
		CardsInHand.add(c);
	}

	public ArrayList<Card> getCardsInHand() {
		return CardsInHand;
	}
	
	public HandScore getHandScore()
	{
		return HS;
	}
	
	public Hand EvaluateHand()
	{
		Hand h = Hand.EvaluateHand(this);
		return h;
	}
	
	private static Hand EvaluateHand(Hand h)  {

		Collections.sort(h.getCardsInHand());
		HandScore hs = new HandScore();
		try {
			Class<?> c = Class.forName("pkgPokerBLL.Hand");

			for (eHandStrength hstr : eHandStrength.values()) {
				Class[] cArg = new Class[2];
				cArg[0] = pkgPokerBLL.Hand.class;
				cArg[1] = pkgPokerBLL.HandScore.class;
				Method meth = c.getMethod(hstr.getEvalMethod(), cArg);
				
				Object o = meth.invoke(null, new Object[] { h, hs });
				if ((Boolean) o) {
					break;
				}
			}

			h.bIsScored = true;
			h.HS = hs;

		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		} catch (IllegalAccessException x) {
			x.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return h;
	}

	public static boolean isHandStraightFlush(Hand h, HandScore hs)
	{
		boolean isHandRoyalFlush = false;
		List<Card> cards =  h.getCardsInHand();
		System.out.print("The Cards In Hand are ：");
		for (Card card : cards) {
			System.out.print(card.geteRank() + ",");
		}
		boolean isSameSuit = false;
		for (eSuit suit : eSuit.values()) {
			int iSuitNbrItem = suit.getiSuitNbr();
			int count = 0;
			for (eCardNo cardNo : eCardNo.values()) {
				int num = cardNo.getCardNo(); 
				int iSuitNbr = cards.get(num).geteSuit().getiSuitNbr(); 
				if(iSuitNbr == iSuitNbrItem){
					count = count + 1; 
				}
			}
			if(count == eCardNo.values().length){
				isSameSuit = true; 
				break;
			}
			
		}
		
		if(!isSameSuit){
			return isHandRoyalFlush;
		}
		
		int biggestRankNbr = cards.get(0).geteRank().getiRankNbr(); 
		boolean isFirstLoop = true;
		for (eCardNo cardNo : eCardNo.values()) {
			if(isFirstLoop) {
				isFirstLoop = false;
				continue;
			}
			int num = cardNo.getCardNo(); 
			int iRankNbr = cards.get(num).geteRank().getiRankNbr(); 
			System.out.println(cards.get(num).geteRank());
			if(--biggestRankNbr != iRankNbr){
				return isHandRoyalFlush;
			}
		}
		isHandRoyalFlush = true;
		hs.setHandStrength(eHandStrength.StraightFlush);
		return isHandRoyalFlush;
	}
	
	public static boolean isHandRoyalFlush(Hand h, HandScore hs)
	{
		boolean isHandRoyalFlush = false;
		List<Card> cards =  h.getCardsInHand();
		if(isHandStraightFlush(h, hs)){
			for (eCardNo cardNo : eCardNo.values()) {
				int iSuitNbr = cards.get(cardNo.getCardNo()).geteSuit().getiSuitNbr(); //第几张手牌的花色值
				if(iSuitNbr != eSuit.HEARTS.getiSuitNbr()){
					return isHandRoyalFlush;
				}
			}
			isHandRoyalFlush = true;
		}
		
		hs.setHandStrength(eHandStrength.RoyalFlush);
		return isHandRoyalFlush;
	}	
	
	
	public static boolean isHandFourOfAKind(Hand h, HandScore hs)
	{
		boolean isHandFourOfAKind = false;
		List<Card> cards =  h.getCardsInHand();
		
		for(Card card : cards){
			int iRankNbr = card.geteRank().getiRankNbr();
			int count = 0;
			for(Card cardItem : cards){
				System.out.println(card.geteRank() + "============" + cardItem.geteRank());
				int iRankNbrItem = cardItem.geteRank().getiRankNbr();
				if(iRankNbrItem == iRankNbr){
					count = count + 1;
					continue;
				}
    				
			}
			if(count == eCardNo.values().length - 1){
				isHandFourOfAKind = true;
				break;
			}
		}
		if(isHandFourOfAKind) hs.setHandStrength(eHandStrength.FourOfAKind); 
		return isHandFourOfAKind;
	}	
	
	public static boolean isHandFlush(Hand h, HandScore hs)
	{
		boolean isHandFlush = false;
		
		List<Card> cards =  h.getCardsInHand();
		
		for (eSuit suit : eSuit.values()) {
			int iSuitNbr = suit.getiSuitNbr(); 
			int count = 0;
			for(Card card : cards){
				if(card.geteSuit().getiSuitNbr() == iSuitNbr){
					count = count + 1;
				}
			}
			if(count == eCardNo.values().length){
				isHandFlush = true;
				break;
			}else{
				continue;
			}
		}
		
		hs.setHandStrength(eHandStrength.Flush);
		
		return isHandFlush;
	}		
	
	public static boolean isHandStraight(Hand h, HandScore hs)
	{
		boolean isHandStraight = false;
		
		List<Card> cards =  h.getCardsInHand();
		
		for (Card card : cards) {
			System.out.print(card.geteRank() + ",");
		}
		
		int biggestRankNbr = cards.get(0).geteRank().getiRankNbr(); 
		
		boolean isFirstLoop = true;
		for (eCardNo cardNo : eCardNo.values()) {
			if(isFirstLoop) {
				isFirstLoop = false;
				continue;
			}
			int num = cardNo.getCardNo(); 
			int iRankNbr = cards.get(num).geteRank().getiRankNbr(); 
			if(--biggestRankNbr != iRankNbr){
				return isHandStraight;
			}
		}
		hs.setHandStrength(eHandStrength.Straight);
		isHandStraight = true;
		return isHandStraight;
	}	
	
	public static boolean isHandThreeOfAKind(Hand h, HandScore hs)
	{
		boolean isHandThreeOfAKind = false;
		List<Card> cards =  h.getCardsInHand();
		
		for(Card card : cards){
			int iRankNbr = card.geteRank().getiRankNbr();
			int count = 0;
			for(Card cardItem : cards){
				int iRankNbrItem = cardItem.geteRank().getiRankNbr();
				if(iRankNbrItem == iRankNbr){
					count = count + 1;
					continue;
				}
			}
			if(count == eCardNo.values().length - 2){
				isHandThreeOfAKind = true;
				break;
			}
		}
		
		hs.setHandStrength(eHandStrength.ThreeOfAKind); 
		
		return isHandThreeOfAKind;
	}		
	
	public static boolean isHandTwoPair(Hand h, HandScore hs)
	{
		int times = 0; 
		boolean isHandTwoPair = false;
		List<Card> cards =  h.getCardsInHand();
		
		for(Card card : cards){
			int iRankNbr = card.geteRank().getiRankNbr();
			int count = 0;
			for(Card cardItem : cards){
				int iRankNbrItem = cardItem.geteRank().getiRankNbr();
				if(iRankNbrItem == iRankNbr){
					count = count + 1;
					continue;
				}
			}
			if(count == eCardNo.values().length - 3){
				times = times + 1;
				continue; 
			}
		}
		
		if(times == 4){
			isHandTwoPair = true;
		}
		
		hs.setHandStrength(eHandStrength.TwoPair); 
		
		return isHandTwoPair;
	}	
	
	public static boolean isHandPair(Hand h, HandScore hs)
	{
		boolean isHandPair = false;
		List<Card> cards =  h.getCardsInHand();
		
		for(Card card : cards){
			int iRankNbr = card.geteRank().getiRankNbr();
			int count = 0;
			for(Card cardItem : cards){
				int iRankNbrItem = cardItem.geteRank().getiRankNbr();
				if(iRankNbrItem == iRankNbr){
					count = count + 1;
					continue;
				}
			}
			if(count == eCardNo.values().length - 3){
				break; 
			}
		}
		
		hs.setHandStrength(eHandStrength.Pair); 
		isHandPair = true;
		return isHandPair;
	}	
	
	public static boolean isHandHighCard(Hand h, HandScore hs)
	{
		return false;
	}	
	
	public static boolean isAcesAndEights(Hand h, HandScore hs)
	{
		boolean isAcesAndEights = false;
		if(isHandTwoPair(h,hs)){
			List<Card> cards = h.getCardsInHand();
			int[] cardNums = new int[cards.size()];
			int index = 0;
			for(Card card : cards){
				int iRankNbr = card.geteRank().getiRankNbr();
				cardNums[index++] = iRankNbr;
			}
			
			int count = 0;
			for (Integer item:cardNums){
			    if (item == eRank.ACE.getiRankNbr()) count++;
			}
			if(count == 2){
				count = 0;
				for (Integer item:cardNums){
				    if (item == eRank.EIGHT.getiRankNbr()) count++;
				}
			}
			
			if(count == 2){
				isAcesAndEights = true;
			}
		}
		
		if(isAcesAndEights) hs.setHandStrength(eHandStrength.AcesAndEights);
		
		return isAcesAndEights;
	}	
	
	public static boolean isHandFullHouse(Hand h, HandScore hs) {

		boolean isFullHouse = false;
		
		if ((h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.ThirdCard.getCardNo()).geteRank())
				&& (h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank() == h.getCardsInHand()
						.get(eCardNo.FifthCard.getCardNo()).geteRank())) {
			isFullHouse = true;
			hs.setHandStrength(eHandStrength.FullHouse);
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank());
			hs.setLoHand(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank());
		} else if ((h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.SecondCard.getCardNo()).geteRank())
				&& (h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank() == h.getCardsInHand()
						.get(eCardNo.FifthCard.getCardNo()).geteRank())) {
			isFullHouse = true;
			hs.setHandStrength(eHandStrength.FullHouse);
			hs.setHiHand(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank());
			hs.setLoHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank());
		}

		return isFullHouse;

	}
}