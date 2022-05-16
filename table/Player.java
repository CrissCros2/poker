package table;
import cards.*;
import java.util.ArrayList;

public class Player {
    private int money;
    private Hand hand;

    public Player(int buyIn){
        money = buyIn;
        hand = new Hand();
    }

    public void deal(Card card){
        hand.addToHand(card);
    }

    public boolean bet(int betAmount){
        if (betAmount <= money){
            Table.addToPot(betAmount);
            money -= betAmount;
            return true;
        }
        return false;
    }

    public void flop(Card first, Card second, Card third){
		hand.addToHand(first);
        hand.addToHand(second);
        hand.addToHand(third);
	}

    public void turn(Card first){
		hand.addToHand(first);
	}

	public void river(Card first){
		hand.addToHand(first);
	}

    public void showCards(){
		hand.showCards();
	}

    public int checkHand(){
        return hand.checkHand();
    }

    public ArrayList<Card> getHand(){
        return hand.getHand();
    }
}
