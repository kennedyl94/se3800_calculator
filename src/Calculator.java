import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {

	/**
	 * The list containing the history of the commands
	 */
	private static ArrayList<HistoryCommand> history = new ArrayList<HistoryCommand>();

	public static void main(String args[]) {

		Scanner s = new Scanner(System.in);

		String input = "";
		while (!input.equals("exit")) {
			System.out.println("Enter a command: ");
			input = s.nextLine();
			if (input != null && input.length() > 0 && !input.equals("exit")) {
				try {
					String[] inputArr = input.trim().split(" ");
					String command = inputArr[0].toLowerCase();
					int[] values = null;
					if(inputArr.length > 1) {
						String[] valuesStringArr = inputArr[1].split(",");
						values = new int[valuesStringArr.length];
						for(int i = 0; i < valuesStringArr.length; i++) {
							values[i] = Integer.parseInt(valuesStringArr[i].trim());
						}
					}
					exec(command, values);
				} catch (Exception e) {
					// If any error is thrown, ERR will be displayed
					System.out.println("ERR");
				}
			} else {
				System.exit(-1);
			}
		}
		s.close();
	}

	/**
	 * Executes the command, optionally passing an array of values depending on
	 * the command
	 * 
	 * @param command	Command to be executed
	 * @param values	Values to execute command on
	 * @throws Exception
	 */
	static private void exec(String command, int[] values) throws Exception {
		if(command != null && command.length() > 0) {
			switch (command) {
			case "add":
				if(values != null && values.length > 0)
					add(values);
				break;
			case "sub":
				if(values != null && values.length > 0)
					sub(values);
				break;
			case "mul":
				if(values != null && values.length > 0)
					mul(values);
				break;
			case "div":
				if(values != null && values.length > 0)
					div(values);
				break;
			case "hist":
				hist();
				break;
			case "clear":
				clear();
				break;
			case "exp":
				if(values != null && values.length > 0)
					exp(values);
				break;
			default:
				throw new Exception("Unkown command");
			}
		}
	}

	/**
	 * Adds an array of Integers and prints out the result
	 * 
	 * @param values	Array of Integers to be added
	 * @throws Exception
	 */
	static private void add(int[] values) throws Exception {
		history.add(new HistoryCommand("add", values));
	}

	/**
	 * Subtracts an array of Integers and prints out the result
	 * 
	 * @param values	Array of Integers to be subtracted
	 * @throws Exception
	 */
	static private void sub(int[] values) throws Exception {
		history.add(new HistoryCommand("sub", values));
	}

	/**
	 * Multiplies an array of Integers and prints out the result
	 * 
	 * @param values	Array of Integers to be multiplied
	 * @throws Exception
	 */
	static private void mul(int[] values) throws Exception {
		history.add(new HistoryCommand("mul", values));
	}

	/**
	 * Divides an array of Integers and prints out the result
	 * 
	 * @param values	Array of Integers to be divided
	 * @throws Exception
	 */
	static private void div(int[] values) throws Exception {
		history.add(new HistoryCommand("div", values));
		float res = values[0];
		for(int i = 1; i< values.length; i++)
		{
			System.out.println(res);
			res = res/values[i];
		}
		int r =(int)res;
		System.out.println(r);
	}

	/**
	 * Prints out the command history
	 */
	static private void hist() {
		for(int i = 0; i< history.size(); i++){
			System.out.println(i+": "+history.get(i));
		}

	}

	/**
	 * Clears the command history
	 */
	static private void clear() {
		history = new ArrayList<HistoryCommand>();
	}

	/**
	 * Exponentiates an array of Integers and prints out the result
	 * 
	 * @param values	Array of Integers to be exponentiated
	 * @throws Exception
	 */
	static private void exp(int[] values) throws Exception {
		history.add(new HistoryCommand("exp", values));
		System.out.println(Math.pow(values[0], values[1]));
	}

	/**
	 *	This class represents a command stored in history.
	 *	It manages the command, and the values for that command.
	 *
	 */
	static class HistoryCommand {
		public String command;
		public int[] values;

		public HistoryCommand(String command, int[] values) {
			this.command = command;
			this.values = values;
		}
		@Override
		public String toString()
		{
			String vals ="";
			for(int i = 0; i<values.length; i++){
				vals+=values[i]+",";
			}
			vals=vals.substring(0,vals.length()-1);
			return this.command+" "+vals;
		}
	}
}
