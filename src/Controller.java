import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class Controller {
    private View theView;
    private Model theModel;
    
    /**
     * Links an instance of the View and Model to the Controller.
     * Implements the creation of the keyEvent listeners for the view components.
     * @param theView the instance of the view to be linked
     * @param theMode the instance of the model to be linked
     */
    public Controller(View theView, Model theModel) {
        this.theView = theView;
        this.theModel = theModel;

        this.theView.addFirstListener(new FirstListener());
        this.theView.addSecondListener(new SecondListener());
    }

    class FirstListener implements KeyListener{
        /**
         * Runs each time a key is released in the first and secondRate fields.
         * Sets the value of the second currency based on the quantity of the first and the exchange rates.
         */
        public void keyReleased(KeyEvent e) {
            try {           
                theModel.setSecondCurrency(theView.getFirsts(),
                                           theView.getFirstRate(), 
                                           theView.getSecondRate());
                theView.setSeconds(theModel.getSecondCurrencyQuantity());
                theView.setComment("Calculations Complete!");
            }
            catch(Exception ex) {
                theView.setComment("Input all values");
            }
        }

        // Irrelevant Overrides
        public void keyTyped(KeyEvent e) {/* Do Nothing */}
        public void keyPressed(KeyEvent e) {/* Do Nothing */}
    }

    class SecondListener implements KeyListener{
        /**
         * Runs each time a key is released in the second and firstRate fields.
         * Sets the value of the first currency based on the quantity of the second and the exchange rates.
         */
        public void keyReleased(KeyEvent e) {
            try {
                theModel.setFirstCurrency(theView.getSeconds(), 
                                          theView.getFirstRate(), 
                                          theView.getSecondRate());
                theView.setFirsts(theModel.getFirstCurrencyQuantity());
                theView.setComment("Calculations Complete!");
            }
            catch (Exception ex) {
                theView.setComment("Input all values");
            }
        }
        
        // Irrelevant Overrides
        public void keyTyped(KeyEvent e) {/* Do Nothing */}
        public void keyPressed(KeyEvent e) {/* Do Nothing */}
    }
}