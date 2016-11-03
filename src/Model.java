import java.math.BigDecimal;
import java.math.RoundingMode;

class Model {
    private double firstCurrencyQuantity = 0;
    private double secondCurrencyQuantity = 0;
    
    /**
     * Grabs the value of firstCurrencyQuantity.
     * @return firstCurrencyQuantity the value of firstCurrencyQuantity
     */
    public double getFirstCurrencyQuantity() { return firstCurrencyQuantity; }
    
    /**
     * Grabs the value of secondCurrencyQuantity.
     * @return secondCurrencyQuantity the value of secondCurrencyQuantity
     */
    public double getSecondCurrencyQuantity() { return secondCurrencyQuantity; }
    
    /**
     * Calculates the firstCurrencyQuantity based on the quantity of "second currency" and the exchange rates.
     * @param value the quantity of the second currency
     * @param firstRate the the first exchange rate
     * @param secondRate the second exchange rate
     */
    public void setFirstCurrency(double value, double firstRate, double secondRate) {
        BigDecimal d = new BigDecimal(value * (firstRate/secondRate));
        firstCurrencyQuantity = d.setScale(2, RoundingMode.HALF_UP).doubleValue(); // Rounds to 2 decimal places
    }
    
    /**
     * Calculates the secondCurrencyQuantity based on the quantity of "first currency" and the exchange rates.
     * @param value the quantity of the first currency
     * @param firstRate the first exchange rate
     * @param secondRate the second exchange rate
     */
    public void setSecondCurrency(double value, double firstRate, double secondRate) {
        BigDecimal d = new BigDecimal(value * (secondRate/firstRate)); 
        secondCurrencyQuantity = d.setScale(2, RoundingMode.HALF_UP).doubleValue(); // Rounds to 2 decimal places
    }
}