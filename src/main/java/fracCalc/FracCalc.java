/**
 * @author Mr. Rasmussen
 */

package fracCalc;
import java.util.*;
public class FracCalc {

    public static void main(String[] args)
    {
    	Scanner console = new Scanner(System.in);
    	System.out.println("Welcome!");
    	boolean runProgram = true;
    	while (runProgram == true) {
    		System.out.println("Equation: ");
    		String s = console.nextLine();
    		if (s.equals("quit")) {
    			runProgram = false;
    		}
    		produceAnswer(s);
    		System.out.println(produceAnswer(s));
        // TODO: Read the input from the user and call produceAnswer with an equation
    	}
    }

    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input) {
    	String operand1, operator, operand2;
    	int negs = 0;
    	for (int i = 0; i < input.length(); i++) {
    		if (input.charAt(i) == '-') {
    			negs++;
    		}
    	}
    	String answer = "";
    	int whole1, numerator1, denominator1, whole2, numerator2, denominator2;
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
    	whole1 = wholeNum(operand1);
    	whole2 = wholeNum(operand2);
    	numerator1 = numeratorNum(operand1);
    	numerator2 = numeratorNum(operand2);
    	denominator1 = denominatorNum(operand1);
    	denominator2 = denominatorNum(operand2);
    	if (operator.indexOf("+") != -1) {
    		answer = add(whole1, numerator1, denominator1, whole2, numerator2, denominator2);
    	} else if (operator.indexOf("-") != -1) {
    		answer = subtract(whole1, numerator1, denominator1, whole2, numerator2, denominator2);
    	} else if (operator.indexOf("*") != -1) {
    		answer = multiply(Math.abs(whole1), Math.abs(numerator1), denominator1, Math.abs(whole2), Math.abs(numerator2), denominator2, negs);
    	} else if (operator.indexOf("/") != -1) {
    		answer = divide(Math.abs(whole1), Math.abs(numerator1), denominator1, Math.abs(whole2), Math.abs(numerator2), denominator2, negs);
    	}
        return answer;
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
    		denominator = 1;
    	}
    	return "whole:" + whole + " numerator:" + numerator + " denominator:" + denominator;
    }
    
    public static int wholeNum(String operand) {
    	int whole = 0;
    	if (operand.indexOf("_") != -1 && operand.indexOf("/") != -1) {
    		int i = 0;
    		while (operand.charAt(i) != '_') {
    			i++;
    		}
    		whole = Integer.parseInt(operand.substring(0, i));
    	} else if (operand.indexOf("_") == -1 && operand.indexOf("/") != -1) {
    		whole = 0;
    	} else if (operand.indexOf("_") == -1 && operand.indexOf("/") == -1) {
    		whole = Integer.parseInt(operand);
    	}
    	return whole;
    }
    
    public static int numeratorNum(String operand) {
    	int numerator = 0;
    	if (operand.indexOf("_") != -1 && operand.indexOf("/") != -1) {
    		int i = 0;
    		while (operand.charAt(i) != '_') {
    			i++;
    		}
    		int j = i + 1;
    		while (operand.charAt(j) != '/') {
    			j++;
    		}
    		numerator = Integer.parseInt(operand.substring(i + 1, j));
    	} else if (operand.indexOf("_") == -1 && operand.indexOf("/") != -1) {
    		int i = 0;
    		while (operand.charAt(i) != '/') {
    			i++;
    		}
    		numerator = Integer.parseInt(operand.substring(0, i));
    	} else if (operand.indexOf("_") == -1 && operand.indexOf("/") == -1) {
    		numerator = 0;
    	}
    	return numerator;
    }
    
    public static int denominatorNum(String operand) {
    	int denominator = 0;
    	if (operand.indexOf("_") != -1 && operand.indexOf("/") != -1) {
    		int i = 0;
    		while (operand.charAt(i) != '_') {
    			i++;
    		}
    		int j = i + 1;
    		while (operand.charAt(j) != '/') {
    			j++;
    		}
    		denominator = Integer.parseInt(operand.substring(j + 1));
    	} else if (operand.indexOf("_") == -1 && operand.indexOf("/") != -1) {
    		int i = 0;
    		while (operand.charAt(i) != '/') {
    			i++;
    		}
    		denominator = Integer.parseInt(operand.substring(i + 1));
    	} else if (operand.indexOf("_") == -1 && operand.indexOf("/") == -1) {
    		denominator = 1;
    	}
    	return denominator;
    }
    
    public static String add(int whole1, int numerator1, int denominator1, int whole2, int numerator2, int denominator2) {
    	int theNumerator, theDenominator;
    	int theWhole = 0;
    	int newNumer1 = numerator1 + (Math.abs(whole1) * denominator1);
    	if (whole1 < 0) {
    		newNumer1 *= -1;
    	}
    	int newNumer2 = numerator2 + (Math.abs(whole2) * denominator2);
    	if (whole2 < 0) {
    		newNumer2 *= -1;
    	}
    	newNumer1 *= denominator2;
    	newNumer2 *= denominator1;
    	theDenominator = denominator1 * denominator2;
    	theNumerator = newNumer1 + newNumer2;
    	if (Math.abs(theNumerator) > theDenominator) {
    		theWhole = theNumerator / theDenominator;
    		theNumerator = Math.abs(theNumerator) - (Math.abs(theWhole) * theDenominator);
    	}
    	int a = 1;
    	for (int i = 1; i < theDenominator; i++) {
    		if ((theNumerator % i == 0) && (theDenominator % i == 0)) {
    			a = i;
    		}
    	}
    	theNumerator /= a;
    	theDenominator /= a;
    	if (theNumerator == theDenominator) {
    		return "1";
    	}
    	if (theNumerator == 0) {
    		return "" + theWhole;
    	} else if (theWhole == 0){
    		return "" + theNumerator + "/" + theDenominator;
    	} else {
    		return "" + theWhole + "_" + theNumerator + "/" + theDenominator;
    	}
    }
    
    public static String subtract(int whole1, int numerator1, int denominator1, int whole2, int numerator2, int denominator2) {
    	int theNumerator, theDenominator;
    	int theWhole = 0;
    	if (whole1 == whole2 && numerator1 == numerator2) {
    		return "0";
    	}
    	
    	int newNumer1 = numerator1 + (Math.abs(whole1) * denominator1);
    	if (whole1 < 0) {
    		newNumer1 *= -1;
    	}
    	int newNumer2 = numerator2 + (Math.abs(whole2) * denominator2);
    	if (whole2 < 0) {
    		newNumer2 *= -1;
    	}
    	newNumer1 *= denominator2;
    	newNumer2 *= denominator1;
    	theDenominator = denominator1 * denominator2;
    	theNumerator = newNumer1 - newNumer2;
    	if (Math.abs(theNumerator) > theDenominator) {
    		theWhole = theNumerator / theDenominator;
    		theNumerator = Math.abs(theNumerator) - (Math.abs(theWhole) * theDenominator);
    	}
    	int a = 1;
    	for (int i = 1; i < theDenominator; i++) {
    		if ((theNumerator % i == 0) && (theDenominator % i == 0)) {
    			a = i;
    		}
    	}
    	theNumerator /= a;
    	theDenominator /= a;
    	if (theNumerator == 0) {
    		return "" + theWhole;
    	} else if (theWhole == 0){
    		return "" + theNumerator + "/" + theDenominator;
    	} else {
    		return "" + theWhole + "_" + theNumerator + "/" + theDenominator;
    	}
    }
    
    public static String multiply(int whole1, int numerator1, int denominator1, int whole2, int numerator2, int denominator2, int negs) {
    	int theNumerator, theDenominator;
    	int theWhole = 0;
    	if (whole1 == 0 && numerator1 == 0 && denominator1 == 1) {
    		return "0";
    	}
    	if (whole1 == whole2 && numerator1 == numerator2) {
    		return "1";
    	}
    	int newNumer1 = numerator1 + (Math.abs(whole1) * denominator1);
    	if (whole1 < 0) {
    		newNumer1 *= -1;
    	}
    	int newNumer2 = numerator2 + (Math.abs(whole2) * denominator2);
    	if (whole2 < 0) {
    		newNumer2 *= -1;
    	}
    	theNumerator = newNumer1 * newNumer2;
    	if (negs == 1) {
    		theNumerator *= -1;
    	}
    	theDenominator = denominator1 * denominator2;
    	if (Math.abs(theNumerator) > theDenominator) {
    		theWhole = theNumerator / theDenominator;
    		theNumerator = Math.abs(theNumerator) - (Math.abs(theWhole) * theDenominator);
    	}
    	int a = 1;
    	for (int i = 1; i < theDenominator; i++) {
    		if ((theNumerator % i == 0) && (theDenominator % i == 0)) {
    			a = i;
    		}
    	}
    	theNumerator /= a;
    	theDenominator /= a;
    	if (theNumerator == 0) {
    		return "" + theWhole;
    	} else if (theWhole == 0){
    		return "" + theNumerator + "/" + theDenominator;
    	} else {
    		return "" + theWhole + "_" + theNumerator + "/" + theDenominator;
    	}	
    }
    
    public static String divide(int whole1, int numerator1, int denominator1, int whole2, int numerator2, int denominator2, int negs) {
    	int theNumerator, theDenominator;
    	int theWhole = 0;
    	if (whole1 == 0 && numerator1 == 0 && denominator1 == 1) {
    		return "0";
    	}
    	if (whole1 == whole2 && numerator1 == numerator2) {
    		return "1";
    	}
    	int newNumer1 = numerator1 + (Math.abs(whole1) * denominator1);
    	if (whole1 < 0) {
    		newNumer1 *= -1;
    	}
    	int newNumer2 = numerator2 + (Math.abs(whole2) * denominator2);
    	if (whole2 < 0) {
    		newNumer2 *= -1;
    	}
    	theNumerator = newNumer1 * denominator2;
    	if (negs == 1) {
    		theNumerator *= -1;
    	}
    	theDenominator = newNumer2 * denominator1;
    	if (Math.abs(theNumerator) > Math.abs(theDenominator)) {
    		theWhole = theNumerator / Math.abs(theDenominator);
    		theNumerator = Math.abs(theNumerator) - (Math.abs(theWhole) * theDenominator);
    	}
    	int a = 1;
    	for (int i = 1; i < theDenominator; i++) {
    		if ((theNumerator % i == 0) && (theDenominator % i == 0)) {
    			a = i;
    		}
    	}
    	theNumerator /= a;
    	theDenominator /= a;
    	if (theNumerator == 0) {
    		return "" + theWhole;
    	} else if (theWhole == 0){
    		return "" + theNumerator + "/" + theDenominator;
    	} else {
    		return "" + theWhole + "_" + theNumerator + "/" + theDenominator;
    	}
    }
}
