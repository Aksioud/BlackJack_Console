import java.util.ArrayList;
import java.util.List;

class Player {
	private String name;
	int sum = 0;
	private List<Card> hand = new ArrayList<Card>();
	
	Player(String name) {
		this.name = name;
	}
	
	void takeCard(int count) {
		for (int i = 0; i < count; i++) {
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
		Message.print("     Sum: " + this.sum, "");
	}
	
	void showHand(int count) {
		System.out.print(name + ": ");
		int sum = 0;
		for (int i = 0; i < count; i++) {
			Card c = hand.get(i);
			System.out.print(c.toString() + " ");
			sum += BlackJack.getCardValue(c, sum); 
		}
		Message.print("     Sum: " + sum, "");
	}
}
