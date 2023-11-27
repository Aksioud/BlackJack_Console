import java.util.ArrayList;
import java.util.List;

class Player {
	private int sum = 0;
	private List<Card> hand = new ArrayList<Card>();
	
	int getSum() {
		return sum;
	}
	
	void takeCard(int count) {
		for(int i = 0; i < count; i++) {
			Card c = Deck.getCard();
			hand.add(c);
			sum += BlackJack.getCardValue(c, sum);
		}
	}
	
	void showHand() {
		for (Card c : hand) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(c.toString() + " ");
		}
		System.out.println("     Sum: " + sum);
	}
}
