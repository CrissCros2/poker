package cards;
public class Card{
	protected Suit suit;
	protected int num;

	public Card(Suit newSuit, int number){
		suit = newSuit;
		num = number;
	}

	public Suit getSuit(){
		return this.suit;
	}

	public int getNum(){
		return this.num;
	}

	public void showCard(){
		System.out.println(Integer.toString(this.num) + " "  + this.suit);
	}
}