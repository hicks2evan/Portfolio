import java.util.Scanner;
import java.lang.NumberFormatException;

/**
 * Calculator.java
 * @author Evan Hicks
 *Takes user input and calculates.
 */

public class Calculator {
	
	private String operator;
	private double operand;
	private double currentResult;
	private String answer;
	private String response;
	private boolean isValid;
	
	public Calculator() {
		currentResult = 0.0;
	}
	
	/**
	 * Runs the calculator.
	 */
	public void run() {
		do {
			System.out.println("Calculator is on.");
			System.out.println();
			Scanner keyboard = new Scanner(System.in);
			do {
			System.out.println("Current result: " + currentResult);
				
			System.out.println("Enter your operation or \"r\" to end current calculation:");
			String nextLine = keyboard.nextLine();
			if (nextLine.length() > 1) {
					operator = nextLine.substring(0, 1);
					String data = nextLine.substring(1, nextLine.length());
					try
					{
						operand = Double.parseDouble(data);
						if (validate())
						{
							update();
						}
					}
					catch (NumberFormatException e)
					{
						System.out.println("Invalid double " + e.getMessage());
					}
			}
			else {
				operator = nextLine.substring(0);
			}
			} while (!operator.equals("r"));
			
			System.out.println("Do you want to perform another calculation? Enter y or n");
			Scanner reply = new Scanner(System.in);
			response = reply.nextLine();
			
			if (!response.equalsIgnoreCase("y"))
			{
				System.out.println("Final result: " + currentResult);
			}
			else
			{
				currentResult = 0;
			}
			} while(response.equalsIgnoreCase("y"));
		}
	
	private boolean validate()
	{
		if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/") || operator.equals("r"))
		{
			return true;
		}
		else
		{
			try
			{
				throw new UnknownOperatorException("Invalid operator");
			}
			catch (UnknownOperatorException e)
			{
				System.out.println(e.getMessage());
				return false;
			}
		}
	}
	
	private void update()
	{
		if (operator.equals("+"))
		{
			currentResult += operand;
		}
		if (operator.equals("-"))
		{
			currentResult -= operand;
		}
		if (operator.equals("*"))
		{
			currentResult *= operand;
		}
		if (operator.equals("/"))
		{
			try
			{
				if (operand == 0)
				{
					throw new DivisionByZeroException("Cannot divide by zero");
				}
				else
				{
					currentResult /= operand;
				}
			}
			catch (DivisionByZeroException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
}
			
		