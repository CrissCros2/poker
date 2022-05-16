package cards;
public class Card{
	protected Suit suit;
	protected int num;
	protected String symbol;

	public Card(Suit newSuit, int number){
		suit = newSuit;
		num = number;
		switch (newSuit){
			case HEART:
				symbol = "♥";
				break;
			case DIAMOND:
				symbol = "♦";
				break;
			case CLUB:
				symbol = "♣";
				break;
			case SPADE:
				symbol = "♠";
				break;
		}
	}

	public String getCardDisplay(){
		return this.num + " " + this.suit;
	}

	public Suit getSuit(){
		return this.suit;
	}

	public int getNum(){
		return this.num;
	}

	public String getSymbol(){
		return this.symbol;
	}

	public void showCard(){
		System.out.println(getCardDisplay());
	}
}