import java.util.Scanner;

class BlackJack {
	
	public static void main(String[] args) {
		
		boolean selected = false;
		byte choise = 0;
		
		Scanner scanner = new Scanner(System.in);
		while (!selected) {
			System.out.println("1 - Начать игру");
			System.out.println("2 - Помощь");
			System.out.println("3 - Выход");
			String ch = scanner.nextLine();
			switch (ch){
				case "1":
				case "2":
				case "3":
					selected = true;
					choise = Byte.valueOf(ch);
			}
		}
		
		scanner.close();
		
		switch(choise) {
			case 3:
				System.exit(0);
			case 2:
				break;
			case 1:
				Game game = new Game();
				game.start();
				break;	
		}
		
	}
	
	static int getCardValue(Card card, int sum) {
		int res = 0;
		
		if (card == null) return res;
		
		CardValue value = card.getValue();
		String valueString = value.toString();
		if(valueString.contains("_")) {
			res = Integer.valueOf(valueString.replace("_", ""));
			return res;
		}
		
		switch(value) {
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