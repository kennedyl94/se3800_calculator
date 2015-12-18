import java.util.Scanner;

public class Calculator {
	public static void main(String args[]) {
		
		Scanner s = new Scanner(System.in);

		String command = "";
		while (!command.equals("EXIT")) {
			System.out.println("Enter a command: ");
			command = s.next().toUpperCase();
			System.out.println(command);
		}
		s.close();
	}

}
