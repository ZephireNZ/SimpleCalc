package me.zephirenz.simplecalc.listeners;

import me.zephirenz.simplecalc.elements.CalcDisplay;
import me.zephirenz.simplecalc.util.MathUtil;
import org.apache.commons.lang3.StringUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * Listener that runs when the equals button has been clicked.
 */
public class EqualsListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        CalcDisplay disp = CalcDisplay.inst();
        String eq = disp.getText();

        if(disp.isError()) {
            return;
        }

        Double val = MathUtil.calculate(eq);
        if(val == null) {
            disp.showError();
            return;
        }

        if(MathUtil.isTooBig(val)) {
            disp.showError();
            return;
        }

        /* screen size is 13.
           subtract number of digits needed for integers.
           if screen size left is <= 1 (ie 0 or 1), print only integers.
           subtract by one for decimal place. Any left is decimal accuracy. */

        // Get number of digits before the decimal place
        int numInt = Integer.toString((int) Math.floor(val)).length();
        int decChars = CalcDisplay.COLUMNS;

        decChars -= numInt;

        if(decChars <= 1) {
            // Return integer (long) of double, as it's to large to have decimals
            disp.setText(Long.toString(Math.round(val)));
            return;
        }
        // Number of decimal places for DecimalFormat, as hashes
        String numDec = StringUtils.repeat("#", decChars -1);

        DecimalFormat format = new DecimalFormat("#." + numDec);
        disp.setText(format.format(val));
        disp.setIsAnswer(true);
    }


}
