
class Card {
	private CardValue value;
	private CardSuit suit;
	
	Card(CardValue value, CardSuit suit) {
		this.value = value;
		this.suit = suit;
	}
	
	Card(CardValue value) {
		this.value = value;
	}
	
	CardValue getValue() {
		return value;
	}
	
	CardSuit getSuit() {
		return suit;
	}
	
	@Override
	public String toString() {
		return printSuit() + printValue();
	}
	
	private String printValue() {
		String res = "";
		String value = this.value.toString();
		if (value.contains("_")) {
			res = value.replace("_", "");
		}
		else if (this.value == CardValue.Joker) {
			res = "Jok";
		}
		else {
			res = String.valueOf(value.charAt(0));
		}
		return res;
	}
	
	private char printSuit() {
		if (this.suit == null) {
			return Character.MIN_VALUE;
		}
		switch (suit) {
			case Clubs:
				return '♠';
			case Hearts:
				return '♥';
			case Diamonds:
				return '♦';
			case Spades:
				return '♣';	
		}
		return Character.MIN_VALUE;
	}
}
