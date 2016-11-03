/**
 * Creates the instance of the Model, View and Controller.
 * 
 * @author LewisAllen
 */
class Main 
{
    /**
     * Main method to launch
     */
    public static void main( String args[] )
    {
        View theView = new View();
        Model theModel = new Model();
        
        new Controller(theView, theModel);
        
        theView.setVisible(true);
    }
}