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
		Message.print(name + ": ");
		for (Card c : hand) {
			Message.print(c.toString() + " ");
		}
		Message.println("     Sum: " + this.sum, "");
	}
	
	void showHand(int count) {
		System.out.print(name + ": ");
		int sum = 0;
		for (int i = 0; i < count; i++) {
			Card c = hand.get(i);
			Message.print(c.toString() + " ");
			sum += BlackJack.getCardValue(c, sum); 
		}
		Message.println("     Sum: " + sum, "");
	}
}
