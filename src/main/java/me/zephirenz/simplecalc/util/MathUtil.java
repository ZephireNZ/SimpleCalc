package me.zephirenz.simplecalc.util;

import me.zephirenz.simplecalc.elements.CalcDisplay;
import org.apache.commons.lang3.StringUtils;
import org.matheclipse.parser.client.eval.DoubleEvaluator;

import java.text.DecimalFormat;

public class MathUtil {


    /**
     * Use Symja to work out answer from a equation string.
     * @param eq the equation to parse
     * @return the answer as a double, or null if error
     */
    public static Double calculate(String eq) {
        try {
            DoubleEvaluator engine = new DoubleEvaluator();
            return engine.evaluate(eq);
        }catch(Exception e) {
            // Will throw exception if it can't calculate, so return null
            // In this case, a fuzzy exception is ok
            return null;
        }

    }

    /**
     * Checks if a number is too large to fit on the calculator's screen
     * @param num the double to check
     * @return true if it is too big, false if it's not
     */
    public static boolean isTooBig(double num) {
        // Check if number is too large to fit on screen
//        if(num >= Math.pow(10, CalcDisplay.COLUMNS)) {
//            return true;
//        }
//        return false;
        String str = new DecimalFormat("#").format(num);
        return str.split("[.]")[0].length() > CalcDisplay.COLUMNS;
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static String formatDecimalForDisplay(double num) {

        /*
         LOGIC:
         screen size is 13.
         subtract number of digits needed for integers.
         if screen size left is <= 1 (ie 0 or 1), print only integers.
         subtract by one for decimal place. Any left is decimal accuracy.
        */

        // Get number of digits before the decimal place
        int numInt = Long.toString((long) Math.floor(num)).length();

        // Number of decimal places
        int decChars = CalcDisplay.COLUMNS - 1 - numInt;

        // Decimal section of the DecimalFormat.
        String decString = "";

        if(decChars > 0) {
            decString = "." + StringUtils.repeat("#", decChars); // Repeat the "#" for as many decimal places as needed
        }

        return new DecimalFormat("#" + decString).format(num);
    }
}
