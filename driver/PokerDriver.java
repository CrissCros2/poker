package driver;
import table.*;
import java.util.ArrayList;
import cards.*;

public class PokerDriver{

	public static void main(String args[]){
		int h1Rank = 0;
		while (h1Rank != 9){
			Hand h1 = new Hand();
			Hand h2 = new Hand();

			Table.initialiseCards();
			Table.setUpDeck();
			for (int i = 0; i<2; i++) {
				Card card = Table.getCard(0);
				Card card2 = Table.getCard(1);
				h1.deal(card);
				h2.deal(card2);
				Table.removeCard(card);
				Table.removeCard(card2);
			}
			Table.flop();
			h1.flop(Table.getTabCard(0),Table.getTabCard(1),Table.getTabCard(2));
			h2.flop(Table.getTabCard(0),Table.getTabCard(1),Table.getTabCard(2));
			Table.turn();
			h1.turn(Table.getTabCard(3));
			h2.turn(Table.getTabCard(3));
			Table.river();
			h1.river(Table.getTabCard(4));
			h2.river(Table.getTabCard(4));

			h1Rank = h1.checkHand();
			System.out.println(h1Rank);
			h1.showCards();
			System.out.println("");
			int h2Rank = h2.checkHand();
			System.out.println(h2Rank);
			h2.showCards();
			if (h1Rank > h2Rank) {
				System.out.println("Player 1 wins");
			}else if (h2Rank > h1Rank) {
				System.out.println("Player 2 wins");
			}else{
				int temp = Table.checkDraw(h1.getHand(), h2.getHand(), h1Rank);
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

}