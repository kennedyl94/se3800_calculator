import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
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
					double[] values = null;
					if(inputArr.length > 1) {
						String[] valuesStringArr = inputArr[1].split(",");
						values = new double[valuesStringArr.length];
						for(int i = 0; i < valuesStringArr.length; i++) {
							if(valuesStringArr[i].toCharArray()[0]=='!'){
								int hist = Integer.parseInt(valuesStringArr[i].substring(1));		
								values[i] = (history.get(hist)==null ? 0 : history.get(hist).result);
							}else{
								values[i] = Double.parseDouble(valuesStringArr[i].trim());
							}
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
	public static void exec(String command, double[] values) throws Exception {
		if(command != null && command.length() > 0) {
			switch (command) {
			case "add":
				if(values != null && values.length > 0)
					System.out.println(add(values));
				break;
			case "sub":
				if(values != null && values.length > 0)
					System.out.println(sub(values));
				break;
			case "mul":
				if(values != null && values.length > 0)
					System.out.println(mul(values));
				break;
			case "div":
				if(values != null && values.length > 0)
					System.out.println(div(values));
				break;
			case "hist":
				hist();
				break;
			case "clear":
				clear();	
				break;
			case "exp":
				if(values != null && values.length > 0)
					System.out.println(exp(values));
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
	public static double add(double[] values) throws Exception {
		history.add(new HistoryCommand("add", values,0));
		return 0;
	}

	/**
	 * Subtracts an array of Integers and prints out the result
	 * 
	 * @param values	Array of Integers to be subtracted
	 * @throws Exception
	 */
	public static double sub(double[] values) throws Exception {
		history.add(new HistoryCommand("sub", values,0));
		return 0;
	}

	/**
	 * Multiplies an array of Integers and prints out the result
	 * 
	 * @param values	Array of Integers to be multiplied
	 * @throws Exception
	 */
	public static double mul(double[] values) throws Exception {
		history.add(new HistoryCommand("mul", values,0));
		return 0;
	}

	/**
	 * Divides an array of Integers and prints out the result
	 * 
	 * @param values	Array of Integers to be divided
	 * @throws Exception
	 */
	public static double div(double[] values) throws Exception {
		double res = values[0];
		for(int i = 1; i< values.length; i++)
		{
			res = res/values[i];
		}
		int r =(int)res;
		history.add(new HistoryCommand("div", values,r));
		return r;
	}

	/**
	 * Prints out the command history
	 */
	public static void hist() {
		for(int i = 0; i< history.size(); i++){
			System.out.println(i+": "+history.get(i) + (history.get(i).result==null ? "" : " = "+history.get(i).result));
		}
		


	}

	/**
	 * Clears the command history
	 */
	public static void clear() {
		history = new ArrayList<HistoryCommand>();
	}

	/**
	 * Exponentiates an array of Integers and prints out the result
	 * 
	 * @param values	Array of Integers to be exponentiated
	 * @throws Exception
	 */
	public static double exp(double[] values) throws Exception {
		
		if(values[1]<0){
			history.add(new HistoryCommand("exp", values,0));
			return 0;
		}
		history.add(new HistoryCommand("exp", values, Math.pow(values[0], values[1])));
		return (int)Math.pow(values[0], values[1]);
		
		
		
		
	}
	
	public ByteArrayOutputStream simulateInput(String in){
		
		PrintStream stdout = System.out;
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		InputStream stdin = System.in;
		System.setIn(new ByteArrayInputStream(in.getBytes()));
		System.setIn(stdin);
		
		System.setOut(stdout);
		return outContent;
		
	}

	/**
	 *	This class represents a command stored in history.
	 *	It manages the command, and the values for that command.
	 *
	 */
	static class HistoryCommand {
		public String command;
		public double[] values;
		public Double result;

		public HistoryCommand(String command, double[] values, double result){
			this.command = command;
			this.values = values;
			this.result = result;
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
