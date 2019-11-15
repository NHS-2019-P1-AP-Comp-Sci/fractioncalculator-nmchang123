/**
 * @author Mr. Rasmussen
 */

package fracCalc;
import java.util.*;
public class FracCalc {

    public static void main(String[] args)
    {
    	System.out.println("what you want");
    	Scanner console = new Scanner(System.in);
    	String s = console.nextLine();
    	produceAnswer(s);
    	System.out.print(produceAnswer(s));
        // TODO: Read the input from the user and call produceAnswer with an equation

    }

    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    {
    	String operand1, operator, operand2;
        // TODO: Implement this function to produce the solution to the input
    	int i = 0;
    	while (input.charAt(i) != ' ') {
    		i++;
    	}
    	operand1 = input.substring(0, i);
    	int j = i;
    	while (input.charAt(j) != ' ') {
    		j++;
    	}
    	operator = input.substring(j + 1, j + 3);
    	operand2 = input.substring(j + 3, input.length());
    	String parseOperand1 = parse(operand1);
    	String parseOperand2 = parse(operand2);
        return parseOperand2;
    }
    
    public static String parse(String operand) {
    	int whole, numerator, denominator;
    	if (operand.indexOf("_") != -1 && operand.indexOf("/") != -1) {
    		int i = 0;
    		while (operand.charAt(i) != '_') {
    			i++;
    		}
    		whole = Integer.parseInt(operand.substring(0, i));
    		int j = i + 1;
    		while (operand.charAt(j) != '/') {
    			j++;
    		}
    		numerator = Integer.parseInt(operand.substring(i + 1, j));
    		denominator = Integer.parseInt(operand.substring(j + 1));
    	} else if (operand.indexOf("_") == -1 && operand.indexOf("/") != -1) {
    		whole = 0;
    		int i = 0;
    		while (operand.charAt(i) != '/') {
    			i++;
    		}
    		numerator = Integer.parseInt(operand.substring(0, i));
    		denominator = Integer.parseInt(operand.substring(i + 1));
    	} else if (operand.indexOf("_") == -1 && operand.indexOf("/") == -1) {
    		whole = Integer.parseInt(operand);
    		numerator = 0;
    		denominator = 1;
    	} else {
    		whole = 0;
    		numerator = 0;
    		denominator = 0;
    	}
    	return "whole:" + whole + " numerator:" + numerator + " denominator:" + denominator;
    }
    // TODO: Fill in the space below with any helper methods that you think you will need

}
