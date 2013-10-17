package me.zephirenz.simplecalc.listeners;

import me.zephirenz.simplecalc.elements.CalcDisplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        CalcDisplay disp = CalcDisplay.inst();
        if(disp.isError() || disp.isAnswer()) {
            disp.setText("");
            disp.setIsError(false);
            disp.setIsAnswer(false);
        }
        String text = disp.getText();
        if(text.length() > 0) {
            disp.setText(text.substring(0, text.length() - 1));
        }
    }
}
