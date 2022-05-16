package driver;
import table.*;
import cards.*;

public class PokerDriver{

	public static void main(String args[]){
		int h1Rank = 0;
		int h2Rank = 0;
		Player p1 = new Player(1000);
		Player p2 = new Player(1000);

		Table.initialiseCards();
		Table.setUpDeck();
		for (int i = 0; i<2; i++) {
			Card card = Table.getCard(0);
			Card card2 = Table.getCard(1);
			p1.deal(card);
			p2.deal(card2);
			Table.removeCard(card);
			Table.removeCard(card2);
		}
		Table.flop();
		p1.flop(Table.getTabCard(0),Table.getTabCard(1),Table.getTabCard(2));
		p2.flop(Table.getTabCard(0),Table.getTabCard(1),Table.getTabCard(2));
		Table.turn();
		p1.turn(Table.getTabCard(3));
		p2.turn(Table.getTabCard(3));
		Table.river();
		p1.river(Table.getTabCard(4));
		p2.river(Table.getTabCard(4));

		h1Rank = p1.checkHand();
		System.out.println(h1Rank);
		p1.showCards();
		System.out.println("");
		h2Rank = p2.checkHand();
		System.out.println(h2Rank);
		p2.showCards();
		if (h1Rank > h2Rank) {
			System.out.println("Player 1 wins");
		}else if (h2Rank > h1Rank) {
			System.out.println("Player 2 wins");
		}else{
			int temp = Table.checkDraw(p1.getHand(), p2.getHand(), h1Rank);
			if (temp == 1){
				System.out.println("Player 1 wins");
			}else if (temp == -1) {
				System.out.println("Player 2 wins");
			}else{
				System.out.println("draw");
			}
		}
		System.out.println("");
	}

}