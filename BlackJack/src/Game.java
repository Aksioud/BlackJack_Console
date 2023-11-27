
class Game {
	
	void start() {
		
		Deck deck = new Deck(DeckSize._52);
		deck.shuffle(3);
		deck.createStack();
		
		Player human = new Player();
		human.takeCard(2);
		human.showHand();
		
		if (human.getSum() == 21) {
			System.out.println("Вы выиграли!");
			return;
		}
		
		boolean enough = false;
		while (!enough) {
			
		}
	}
}
