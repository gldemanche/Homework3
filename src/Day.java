/**
 * day class helps get month from 8 digit
 * @author Gabe Demanche & Chris Chow
 */
public class Day {
    Double value = 0.0;
    int monthOfData;
    double date;
    public Day(double day) {
        this.date = day;
    }
    /**
     * Extracts month from teh 8 digit code
     * @param dateNum the input 8 diget code
     * @return the month in the form mm
     */
    int extractMonth(double dateNum) { return ((int)dateNum % 10000) / 100; }

    /**
     * Gets the month in the form mm
     * @return the month in the form mm
     */
    public int getMonth(){
      return extractMonth(this.date);
    }

    /**
     * Gets value of the highest data point
     * @return data pint
     */
    public double getValue(){
        return value;
    }

    /**
     * Set the current value to the given value
     * @param val the value being replaced
     */
    public void setValue(double val){
        this.value = val;
    }

}
