
class Game {
	
	boolean start() {
		
		Deck deck = new Deck(DeckSize._52);
		deck.shuffle(3);
		deck.createStack();
		
		Player human = new Player("You");
		human.takeCard(2);
		human.showHand();
		
		boolean enough = false;
		int sumHuman = 0;
		enough = human.getSum() == 21;
		
		while (!enough) {
			Message.print("Взять карту ?", "1 - Да. 2 - Нет");
			int ch = Input.readInt();
			switch (ch) {
				case 1:
					human.takeCard(1);
					human.showHand();
					sumHuman = human.getSum();
					if (sumHuman >= 21) {
						enough = true;
					}
					break;
				case 2:
					enough = true;
					break;
					
			}
		}
		
		if (sumHuman == 21) {
			Message.print("Вы выиграли!");
		} else if (sumHuman > 21) {
			Message.print("Вы проиграли");
		}
		
		Message.print("Сыграть еще?", "1 - Да. 2 - Нет");
		
		int res = Input.readInt();
		return res == 1;
	}
}
