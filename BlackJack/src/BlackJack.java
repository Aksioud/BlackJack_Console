import java.util.List;

public class BlackJack {
	
	public static void main(String[] args) {
		
		Deck deck = new Deck(DeckSize._52);
		List<Card> cards = deck.getCards();
		
		deck.shuffle(3);
		
		int sum = 0;
		for(Card c: cards) { 
			System.out.print(c.toString());
			System.out.print(" value = " + getCardValue(c));
			sum += getCardValue(c);
			System.out.println(" sum = " + sum);
			}
		
		
	}
	
	private static int getCardValue(Card card) {
		int res = 0;
		
		if (card == null) return res;
		
		CardValue value = card.getValue();
		String valueString = value.toString();
		if(valueString.contains("_")) {
			res = Integer.valueOf(valueString.replace("_", ""));
		}
		
		switch(value) {
			case Jack:
			case Queen:
			case King:
				res = 10;
				break;
			default:
				break;
		}
		
		return res;
	}

}