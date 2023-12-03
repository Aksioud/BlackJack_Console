import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

class Deck {

	private ArrayList<Card> cards = new ArrayList<Card>();
	private DeckSize deckSize;
	private static Stack<Card> stack;
	
	Deck(DeckSize deckSize) {
		this.deckSize = deckSize;
		initializeDeck(deckSize);
	}
	
	DeckSize getDeckSize() {
		return deckSize;
	}
	
	ArrayList<Card> getCards() {
		return cards;
	}
	
	private void initializeDeck(DeckSize deckSize) {
		int startNum = 2;
		boolean needJoker = false;
		
		switch (deckSize) {
			case _24:
				startNum = 9;
				break;
			case _32:
				startNum = 7;
				break;
			case _36:
				startNum = 6;
				break;
			case _52:
				break;
			case _54:
				needJoker = true;
				break;
		}
		
		for (; startNum <= 10; startNum++) {
			addCards(CardValue.valueOf("_" + startNum));
		}
		
		addCards(CardValue.Jack);
		addCards(CardValue.Queen);
		addCards(CardValue.King);
		addCards(CardValue.Ace);
		
		if (needJoker) {
			cards.add(new Card(CardValue.Joker));
			cards.add(new Card(CardValue.Joker));
		}
		
	}
	
	private void addCards(CardValue value) {
		for (CardSuit s: CardSuit.values()) {
			cards.add(new Card(value, s));
		}
	}
	
	void shuffle(int count) {
		for (int i = 0; i < count; i++)
			Collections.shuffle(cards);
	}
	
	void createStack() {
		stack = new Stack<Card>();
		
		for (Card c : cards)
			stack.push(c);
	}

	static Card getCard() {
		return stack.pop();
	}
	
}
