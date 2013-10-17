package me.zephirenz.simplecalc.elements;

import me.zephirenz.simplecalc.SimpleCalc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * Button class. Used to create all buttons on calculator.
 */
public class CalcButton extends JButton {

    private static HashMap<String, CalcButton> buttons = new HashMap<String, CalcButton>();

    /**
     * Gives a Map of all buttons created with key being their command (eg 5, +, = etc)
     * @return Map of commands and their respective button
     */
    public static HashMap<String, CalcButton> getButtons() {
        return buttons;
    }

    public static CalcButton getInst(String command) {
        return buttons.get(command);
    }

    /**
     * Create a new button, attaching it to the specified parent
     * @param text text to be show on calculator
     * @param command command label to be shown to ActionListener
     * @param listener ActionListener for the button, ran when button clicked
     * @param x x grid location
     * @param y y grid location
     * @param xSpan how many columns to span
     * @param ySpan how many rows to span
     */
    public CalcButton(String text, String command, ActionListener listener, int x, int y, int xSpan, int ySpan) {

        super(text);
        setActionCommand(command);
        addActionListener(listener);
        GridBagConstraints c = SimpleCalc.getGBConstraint();
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = xSpan;
        c.gridheight = ySpan;

        SimpleCalc.inst().add(this, c);
        buttons.put(command, this);

    }

    /**
     * Creates a button with no span. See other constructor for more detail.
     * @param text text to be show on calculator
     * @param command command label to be shown to ActionListener
     * @param listener ActionListener for the button, ran when button clicked
     * @param x x grid location
     * @param y y grid location
     */
    public CalcButton(String text, String command, ActionListener listener, int x, int y) {
        this(text, command, listener, x, y, 1, 1);
    }

}
