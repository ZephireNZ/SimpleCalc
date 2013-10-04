package me.zephirenz.simplecalc;

import javax.swing.*;

public class SimpleCalc extends JWindow {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    }

    private static void createGUI() {

    }

}
