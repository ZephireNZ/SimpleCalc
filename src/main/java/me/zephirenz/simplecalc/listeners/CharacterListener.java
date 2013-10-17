package me.zephirenz.simplecalc.listeners;

import me.zephirenz.simplecalc.elements.CalcDisplay;
import me.zephirenz.simplecalc.util.MathUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharacterListener implements ActionListener {

    private String c;

    public CharacterListener(String c) {
        this.c = c;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        CalcDisplay disp = CalcDisplay.inst();
        if(disp.isError()) {
            disp.setText("");
            disp.setIsError(false);
        }
        // If user is trying to write new equation after calculation (eg writing a number), reset display, otherwise don't
        if(disp.isAnswer() && MathUtil.isInteger(event.getActionCommand())) {
            disp.setText("");
        }
        disp.setIsAnswer(false);
        disp.addText(c);
    }

}
