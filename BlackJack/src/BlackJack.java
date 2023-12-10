
class BlackJack {
	
	public static void main(String[] args) {
		
		int ch = 0;
		do {
			Message.println("1 - Начать игру", "2 - Выход");
			ch = Input.readInt();
		} while (ch < 1 || ch > 2);
		
		if (ch == 2)
			System.exit(0);
		
		boolean startGame = true;
		Game game = new Game();
		while (startGame) {
			startGame = game.start();
			Message.println("", "", "", "");
		}
		
		Input.close();
		Message.close();
	}
	
	static int getCardValue(Card card, int sum) {
		int res = 0;
		
		if (card == null) return res;
		
		CardValue value = card.getValue();
		String valueString = value.toString();
		if (valueString.contains("_")) {
			res = Integer.valueOf(valueString.replace("_", ""));
			return res;
		}
		
		switch (value) {
			case Ace:
				res = sum + 11 > 21 ? 1 : 11;
				break;
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