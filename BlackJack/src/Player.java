import java.util.ArrayList;
import java.util.List;

class Player {
	private String name;
	private int sum = 0;
	private List<Card> hand = new ArrayList<Card>();
	
	Player(String name) {
		this.name = name;
	}
	
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
		System.out.print(name + ": ");
		for (Card c : hand) {
			System.out.print(c.toString() + " ");
		}
		Message.print("     Sum: " + sum);
	}
}
