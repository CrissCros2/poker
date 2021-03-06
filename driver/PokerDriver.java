package driver;
import table.*;
import cards.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PokerDriver{
	private static boolean win;
	public static void main(String args[]) throws IOException{
		int h1Rank = 0;
		int h2Rank = 0;
		Player p1 = new Player(1000, "Player 1");
		Player p2 = new Player(1000, "Player 2");
		int bigBlind = 100;
		Player currentBigBlind = p1;
		Player currentSmallBlind = p2;

		Table.initialiseCards();
		Table.setUpDeck();
		for (int i = 0; i<2; i++) {
			Card card = Table.getCard(0);
			Card card2 = Table.getCard(1);
			p1.addToHand(card);
			p2.addToHand(card2);
			Table.removeCard(card);
			Table.removeCard(card2);
		}

		currentBigBlind.bet(bigBlind);
		currentSmallBlind.bet(bigBlind/2);

		System.out.println("The current pot is: £" + Integer.toString(Table.getPot()));
		System.out.println("");

		p1.showCards();
		System.out.println("");
		p2.showCards();
		System.out.println("");

		int sel = getSelection(currentSmallBlind.getName());

		switch (sel){
			case 1:
				int inp = 0;
				System.out.println("Enter how much: ");
				do{
					inp = getInput();
				}while (inp < bigBlind/2);
				currentSmallBlind.bet(inp);
			case 2:
				currentSmallBlind.bet(bigBlind/2);
			case 3:
				currentSmallBlind.fold();
				win(p1.getFold(), p2.getFold());
		}

		Table.flop();
		p1.addToHand(Table.getTabCard(0)); p2.addToHand(Table.getTabCard(0));
		p1.addToHand(Table.getTabCard(1)); p2.addToHand(Table.getTabCard(1));
		p1.addToHand(Table.getTabCard(2)); p2.addToHand(Table.getTabCard(2));

		Table.newCard();
		p1.addToHand(Table.getTabCard(3)); p2.addToHand(Table.getTabCard(3));

		Table.newCard();
		p1.addToHand(Table.getTabCard(4)); p2.addToHand(Table.getTabCard(4));

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

	private static int getInput() throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String data = reader.readLine();
		return Integer.parseInt(data);
	}

	private static int getSelection(String name) throws IOException{
		int inp = 0;
		do{
			System.out.println(name + " Do you wish to bet, call or fold?");
			System.out.println("1. Bet");
			System.out.println("2. Call");
			System.out.println("3. Fold");
			System.out.println("");
			inp = getInput();
		}while (inp < 4);
		return inp;
	}

	private static void win(boolean p1, boolean p2){
		if (p1 == true && p2 == false){
			win = true;
			System.out.println("P2 Wins");
		}else if (p1 == false && p2 == true){
			win = true;
			System.out.println("P1 Wins");
		}else{
			win = false;
		}
	}
}