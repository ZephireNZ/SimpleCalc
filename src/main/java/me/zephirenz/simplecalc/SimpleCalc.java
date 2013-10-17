package me.zephirenz.simplecalc;

import me.zephirenz.simplecalc.elements.CalcButton;
import me.zephirenz.simplecalc.elements.CalcDisplay;
import me.zephirenz.simplecalc.listeners.CharacterListener;
import me.zephirenz.simplecalc.listeners.DeleteListener;
import me.zephirenz.simplecalc.listeners.EqualsListener;

import javax.swing.*;
import java.awt.*;


/**
 * SimpleCalc main class.
 *
 * Extends the JFrame class to create the main GUI. Also used on run to create GUI elements.
 * @author Brynley McDonald
 */
public class SimpleCalc extends JFrame {

    private static SimpleCalc inst;

    /**
     * Creates the main calculator window.
     */
    public SimpleCalc() {
        super();
        inst = this;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setResizable(false);
        setLocationRelativeTo(null);

    }

    /**
     * Gets the instance of the calculator
     * @return instance
     */
    public static SimpleCalc inst() {
        return inst;
    }

    /**
     * Invoke creating the GUI when most appropriate
     * @param args args passed on execution
     * @throws ExceptionInInitializerError thrown when trying to create another instance of the window
     */
    public static void main(String[] args) {
        if(inst != null) throw new ExceptionInInitializerError("Can't create more than one window simultaneously.");
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    }

    /**
     * Creates the Calculator GUI, such as buttons.
     */
    private static void createGUI() {

        SimpleCalc main = new SimpleCalc();

        // Create all GUI elements
        CalcDisplay.inst();

        new CalcButton("⇦", "delete", new DeleteListener(),       1, 2);
        new CalcButton("(",  "(",      new CharacterListener("("), 2, 2);
        new CalcButton(")",  ")",      new CharacterListener(")"), 3, 2);
        new CalcButton("/",  "/",      new CharacterListener("/"), 4, 2);

        /**
         * Variable to store button text. Used to loop over to make button creating more efficient.
         */
        String[][] buttonText = {
                {"7", "8", "9", "*"},
                {"4", "5", "6", "-"},
                {"1", "2", "3", "+"}
        };

        for(int y : new int[] {3, 4, 5}) {
            for(int x : new int[] {1, 2, 3, 4}) {
                String text = buttonText[y-3][x-1];
                new CalcButton(text, text, new CharacterListener(text), x, y);
            }
        }

        new CalcButton(".", ".", new CharacterListener("."), 1, 6);
        new CalcButton("0", "0", new CharacterListener("0"), 2, 6);
        new CalcButton("=", "=", new EqualsListener(),       3, 6, 2, 1);

        main.pack();
        main.setVisible(true);

    }

    public static GridBagConstraints getGBConstraint() {

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        return c;

    }
}
