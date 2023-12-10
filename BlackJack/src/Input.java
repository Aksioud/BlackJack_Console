import java.util.Scanner;

class Input {
	
	static Scanner scanner;
	
	static {
		scanner = new Scanner(System.in);
	}
	
	static String readString() {
		return scanner.nextLine();
	}
	
	static int readInt() {
		try {
			return Integer.valueOf(scanner.nextLine());
		} catch (Exception e) {
		}
		return 0;
	}
	
	static void close() {
		scanner.close();
	}
}
