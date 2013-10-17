package me.zephirenz.simplecalc.elements;

import me.zephirenz.simplecalc.SimpleCalc;

import javax.swing.*;
import java.awt.*;

public class CalcDisplay extends JTextField {

    private static CalcDisplay inst;
    private boolean error;
    private boolean answer;
    public static final int COLUMNS = 13;

    public static CalcDisplay inst() {
        if(inst == null) {
            inst = new CalcDisplay();
        }
        return inst;
    }

    private CalcDisplay() {
        super(COLUMNS);
        GridBagConstraints c = SimpleCalc.getGBConstraint();
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 4;
        setEditable(false);
        setFont(new Font("Courier New", Font.PLAIN, 20));
        setPreferredSize(new Dimension(134, 40));
        setHorizontalAlignment(JTextField.RIGHT);
        SimpleCalc.inst().add(this, c);
    }

    /**
     * Add text to the display
     * @param str the text to add to the display
     * @return true if character can and has been added, otherwise will return false if it can't
     */
    public boolean addText(String str) {
        if(getText().length()+ str.length() <= getColumns()) {
            setText(getText()+str);
            return true;
        }
        return false;
    }

    public void showError() {
        error = true;
        setText("ERROR");
    }

    public boolean isError() {
        return error;
    }

    public void setIsError(boolean val) {
        this.error = val;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setIsAnswer(boolean val) {
        this.answer = val;
    }
}