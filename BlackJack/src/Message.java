import java.io.PrintWriter;

class Message {
	
	private static PrintWriter pw;
	
	static {
		pw = new PrintWriter(System.out, true);
	}
	
	static void println(String ... strings) {
		for (String s : strings) {
			pw.println(s);
		}
	}
	
	static void print(String s) {
		pw.print(s);
	}
	
	static void close() {
		pw.close();
	}
}
