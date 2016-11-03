import java.awt.Dimension;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class View extends JFrame {
    private static final long serialVersionUID = 9109534948590246118L;
    
    private JLabel firstRateLabel  = new JLabel("First Currency Rate:");
    private JTextField firstRate   = new JTextField(5);
    private JLabel secondRateLabel = new JLabel("Second Currency Rate:");
    private JTextField secondRate  = new JTextField(5);
    private JLabel poundLabel      = new JLabel("First Currency Quantity:");
    private JTextField firsts      = new JTextField(5);
    private JLabel dollarLabel     = new JLabel("Second Currency Quantity:");
    private JTextField seconds     = new JTextField(5);
    private JTextField comment     = new JTextField(30);
    
    /**
     * Constructs the panel in which the program is displayed.
     */
    public View() {
        int gap = 10;
        JPanel thePanel = new JPanel();
        thePanel.setLayout(new BoxLayout(thePanel,BoxLayout.PAGE_AXIS));
       
        this.setTitle("Currency Converter");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(200,250);
        
        thePanel.add(firstRateLabel);
        thePanel.add(firstRate);
        thePanel.add(Box.createRigidArea(new Dimension(0,gap)));
        thePanel.add(secondRateLabel);
        thePanel.add(secondRate);
        thePanel.add(Box.createRigidArea(new Dimension(0,gap)));
        thePanel.add(poundLabel);
        thePanel.add(firsts);
        thePanel.add(Box.createRigidArea(new Dimension(0,gap)));
        thePanel.add(dollarLabel);
        thePanel.add(seconds);
        thePanel.add(Box.createRigidArea(new Dimension(0,gap)));
        thePanel.add(comment);
        
        firstRate.setHorizontalAlignment(JTextField.CENTER);
        secondRate.setHorizontalAlignment(JTextField.CENTER);
        firsts.setHorizontalAlignment(JTextField.CENTER);
        seconds.setHorizontalAlignment(JTextField.CENTER);
        comment.setHorizontalAlignment(JTextField.CENTER);        
        
        setComment("You need to fill in more data");
        this.add(thePanel);
    }
    
    /**
     * Grabs the value of the first exchange rate in the text field.
     * @returns aDouble the first exchange rate
     */
    public double getFirstRate() { return Double.parseDouble(firstRate.getText()); }
    
    /**
     * Grabs the value of the second exchange rate in the text field.
     * @returns aDouble double format of the exchange rate
     */
    public double getSecondRate() { return Double.parseDouble(secondRate.getText()); }
    
    /**
     * Grabs the quantity in the firsts text field.
     * @returns aDouble double format of the quantity
     */
    public double getFirsts() { return Double.parseDouble(firsts.getText()); }
    
    /**
     * Grabs the quantity in the seconds text field.
     * @returns aDouble double format of the quantity
     */
    public double getSeconds() { return Double.parseDouble(seconds.getText()); }
    
    /**
     * Sets the firsts text field to the given argument.
     * @param value the value to display
     */
    public void setFirsts(double value) { firsts.setText(Double.toString(value)); }
    
    /**
     * Sets the seconds text field to the given argument.
     * @param value the value to display
     */
    public void setSeconds(double value) { seconds.setText(Double.toString(value)); }
    
    /**
     * Sets the comment text field to the given argument
     * @param theComment the string to display
     */
    public void setComment(String theComment) { comment.setText(theComment); }     
    
    /**
     * If a key is typed in the firsts or secondRate fields
     * execute a method in the controller named PoundListener.
     */
    void addFirstListener(KeyListener listenForKeyTyped) {
        firsts.addKeyListener(listenForKeyTyped);
        secondRate.addKeyListener(listenForKeyTyped);
    }
    
    /**
     * If a key is typed in the seconds or firstRate fields
     * execute a method in the controller named DollarListener
     */
    void addSecondListener(KeyListener listenForKeyTyped) {
        seconds.addKeyListener(listenForKeyTyped);
        firstRate.addKeyListener(listenForKeyTyped);
    }
}
