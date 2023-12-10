
class Game {
	
	boolean start() {
		
		Deck deck = new Deck(DeckSize._52);
		deck.shuffle(3);
		deck.createStack();
		
		Player human = new Player(">>> You");
		human.takeCard(2);
		
		Player comp = new Player("Computer");
		comp.takeCard(2);
		comp.showHand(1);
		
		human.showHand();
		
		boolean enough = false;
		
		enough = human.sum == 21;
		
		while (!enough) {
			Message.println("Взять карту ?", "1 - Да; 2 - Нет");
			int ch = Input.readInt();
			switch (ch) {
				case 1:
					human.takeCard(1);
					human.showHand();
					if (human.sum >= 21) {
						enough = true;
					}
					break;
				case 2:
					enough = true;
					break;
					
			}
		}
		
		if (human.sum > 21) {
			Message.println("Вы проиграли");
			Message.println("Сыграть еще?", "1 - Да; 2 - Нет");
			
			int res = Input.readInt();
			return res == 1;
		}
		
		while (comp.sum <= 16) {
			comp.takeCard(1);	
		}
		
		comp.showHand();
		human.showHand();
		
		if (comp.sum > 21)
			Message.println("Вы выиграли!");
		else if (human.sum == comp.sum)
			Message.println("Ничья");
		else if (comp.sum > human.sum)
			Message.println("Вы проиграли");
		else 
			Message.println("Вы выиграли!");
		
		Message.println("");
		Message.println("Сыграть еще?", "1 - Да; 2 - Нет");
		
		int res = Input.readInt();
		return res == 1;
	}
}
