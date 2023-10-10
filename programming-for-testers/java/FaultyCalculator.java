package app;

public class FaultyCalculator {

    public FaultyCalculator() {}

    /** Should return 0 when dividing by zero
     * @param a
     * @param b
     * @return the quotient a / b
     */
    public double divide(double a, double b) {
        return a / b;
    }

    /** Should return the average of two numbers
     * @param a
     * @param b
     * @return the average of two numbers
     */
    public double average(int a, int b) {
        return (a + b) / 2;
    }

}
