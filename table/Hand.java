package table;
import java.util.ArrayList;
import cards.*;
import java.util.Collections;

public class Hand{
	private ArrayList<Card> fullHand;

	public Hand(){
		fullHand = new ArrayList<Card>();
	}

	public void addToHand(Card first){
		fullHand.add(first);
	}

	public void flop(Card first, Card second, Card third){
		fullHand.add(first);
		fullHand.add(second);
		fullHand.add(third);
	}

	public void turn(Card first){
		fullHand.add(first);
	}

	public void river(Card first){
		fullHand.add(first);
	}

	public void showCards(){
		for (int i = 0; i<fullHand.size(); i++) {
			fullHand.get(i).showCard();
		}
	}

	public ArrayList<Card> getHand(){
		return fullHand;
	}

	public int checkHand(){
		boolean straightFlush = false;
		boolean fourOfKind = false; //
		boolean fullHouse = false; //
		boolean straight = false; //
		boolean threeOfKind = false; //
		boolean twoPair = false;
		boolean pair = false; //
		boolean flush = false; //
		int spade = 0;
		int diamond = 0;
		int club = 0;
		int heart = 0;

		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int e = 0;
		int f = 0;
		int g = 0;
		int h = 0;
		int j = 0;
		int k = 0;
		int l = 0;
		int m = 0;
		int n = 0;
		// Four of a kind
		for (int i = 0; i<fullHand.size(); i++) {
			switch (fullHand.get(i).getNum()){
			case 1:
				a += 1;
				break;
			case 2:
				b += 1;
				break;
			case 3:
				c += 1;
				break;
			case 4:
				d += 1;
				break;
			case 5:
				e += 1;
				break;
			case 6:
				f += 1;
				break;
			case 7:
				g += 1;
				break;
			case 8:
				h += 1;
				break;
			case 9:
				j += 1;
				break;
			case 10:
				k += 1;
				break;
			case 11:
				l += 1;
				break;
			case 12:
				m += 1;
				break;
			case 13:
				n += 1;
				break;
			}
		}
		if (a == 4 || b == 4 || c == 4 || d == 4 || e == 4 || f == 4 || g == 4 || h == 4 || n == 4 || j == 4 || k == 4 || l == 4 || m == 4) {
			fourOfKind = true;
		}else if (a == 3 || b == 3 || c == 3 || d == 3 || e == 3 || f == 3 || g == 3 || h == 3 || n == 3 || j == 3 || k == 3 || l == 3 || m == 3) {
			threeOfKind = true;
		}else if (a == 2 || b == 2 || c == 2 || d == 2 || e == 2 || f == 2 || g == 2 || h == 2 || n == 2 || j == 2 || k == 2 || l == 2 || m == 2) {
			pair = true;
		} 

		if (threeOfKind && pair){
			fullHouse = true;
		}

		// Straight
		straight = checkStraight();

		//Flush
		for (int i = 0; i<fullHand.size(); i++) {
			switch (fullHand.get(i).getSuit()){
			case SPADE:
				spade += 1;
				break;
			case DIAMOND:
				diamond += 1;
				break;
			case CLUB:
				club += 1;
				break;
			case HEART:
				heart += 1;
				break;
			}
		}
		if (spade >= 5 || diamond >= 5 || club >= 5 || heart >= 5) {
			flush = true;
		}

		straightFlush = checkStraightFlush(spade,diamond,club,heart);
		
		if (straightFlush) {
			return 9;
		}else if (fourOfKind) {
			return 8;
		}else if (fullHouse) {
			return 7;
		}else if (flush) {
			return 6;
		}else if (straight) {
			return 5;
		}else if (threeOfKind) {
			return 4;
		}else if (twoPair) {
			return 3;
		}else if (pair) {
			return 2;
		}
		return 1;

	}

	public boolean checkStraightFlush(int spade, int diamond, int club, int heart){
		if (spade >= 5) {
			if (checkStraightSuit(Suit.SPADE)){
				return true;
			}
		}else if (diamond >= 5) {
			if (checkStraightSuit(Suit.DIAMOND)){
				return true;
			}
		}else if (club >= 5) {
			if (checkStraightSuit(Suit.CLUB)){
				return true;
			}
		}else if (heart >= 5) {
			if (checkStraightSuit(Suit.HEART)){
				return true;
			}
		}
		return false;
	}

	public boolean checkStraightSuit(Suit suit){
		ArrayList<Integer> cardNums = new ArrayList<Integer>(); 
		for (int i = 0; i<fullHand.size(); i++) {
			int num = fullHand.get(i).getNum();
			if (!cardNums.contains(num) && fullHand.get(i).getSuit() == suit) {
				cardNums.add(num);
				if (num == 1) {
					cardNums.add(14);
				}
			}
		}
		for (int startNum = 0; startNum<cardNums.size()-4; startNum++) {
			int dif1 = cardNums.get(startNum+1) - cardNums.get(startNum);
			int dif2 = cardNums.get(startNum+2) - cardNums.get(startNum+1);
			int dif3 = cardNums.get(startNum+3) - cardNums.get(startNum+2);
			int dif4 = cardNums.get(startNum+4) - cardNums.get(startNum+3);
			if (dif1 == 1 && dif2 == 1 && dif3 == 1 && dif4 == 1) {
				return true;
			}
		}
		return false;
	}

	public boolean checkStraight(){
		ArrayList<Integer> cardNums = new ArrayList<Integer>(); 
		for (int i = 0; i<fullHand.size(); i++) {
			int num = fullHand.get(i).getNum();
			if (!cardNums.contains(num)) {
				cardNums.add(num);
				if (num == 1) {
					cardNums.add(14);
				}
			}
		}
		Collections.sort(cardNums);
		for (int startNum = 0; startNum<cardNums.size()-4; startNum++) {
			int dif1 = cardNums.get(startNum+1) - cardNums.get(startNum);
			int dif2 = cardNums.get(startNum+2) - cardNums.get(startNum+1);
			int dif3 = cardNums.get(startNum+3) - cardNums.get(startNum+2);
			int dif4 = cardNums.get(startNum+4) - cardNums.get(startNum+3);
			if (dif1 == 1 && dif2 == 1 && dif3 == 1 && dif4 == 1) {
				return true;
			}
		}
		return false;
	}
}