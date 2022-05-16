package table;
import java.util.ArrayList;
import cards.*;
import java.util.Collections;
public class Table{
	private static ArrayList<Card> tabCards;
	private static ArrayList<Card> deck;
	private static int pot;

	public static void initialiseCards(){
		tabCards = new ArrayList<Card>();
		deck = new ArrayList<Card>();
	}

	public static void setUpDeck(){
		for (int i = 1; i<14; i++) {
			deck.add(new Card(Suit.HEART, i));
			deck.add(new Card(Suit.DIAMOND, i));
			deck.add(new Card(Suit.CLUB, i));
			deck.add(new Card(Suit.SPADE, i));
		}
		Collections.shuffle(deck);
	}

	public static ArrayList<Card> getDeck(){
		return deck;
	}

	public static Card getCard(int index){
		return deck.get(index);
	}

	public static Suit getCardSuit(int index){
		return deck.get(index).getSuit();
	}

	public static int getCardNum(int index){
		return deck.get(index).getNum();
	}

	public static void removeCard(Card card){
		deck.remove(card);
	}

	public static Card getTabCard(int index){
		return tabCards.get(index);
	}

	public static void flop(){
		Card card1 = deck.get(0);
		Card card2 = deck.get(1);
		Card card3 = deck.get(2);
		Card card4 = deck.get(3);
		tabCards.add(card2);
		tabCards.add(card3);
		tabCards.add(card4);
		deck.remove(card1);
		deck.remove(card2);
		deck.remove(card3);
		deck.remove(card4);
	}

	public static void newCard(){
		Card card = deck.get(1);
		tabCards.add(card);
		deck.remove(deck.get(0));
		deck.remove(card);
	}

	public static int checkDraw(ArrayList<Card> h1, ArrayList<Card> h2, int rank){
		int h1High = 0;
		int h2High = 0;
		for (int i = 0; i<h1.size(); i++) {
		 	if (h1.get(i).getNum() > h1High) {
		 		h1High = h1.get(i).getNum();
		 	}
		 	if (h2.get(i).getNum() > h2High) {
		 		h2High = h2.get(i).getNum();
		 	}
		}
		switch (rank){
		case 9:
			if (h1High > h2High) {
				return 1;
			}else if (h1High < h2High){
				return -1;
			}else{
				return 0;
			}
		case 6:
			if (h1High > h2High) {
				return 1;
			}else if (h1High < h2High){
				return -1;
			}else{
				return 0;
			}
		case 5:
			if (h1High > h2High) {
				return 1;
			}else if (h1High < h2High){
				return -1;
			}else{
				return 0;
			}
		case 1:
			if (h1High > h2High) {
				return 1;
			}else if (h1High < h2High){
				return -1;
			}else{
				return 0;
			}
		}
		return 0;
	}

	public static void addToPot(int money){
		pot += money;
	}

	public static int getPot(){
		return pot;
	}
}