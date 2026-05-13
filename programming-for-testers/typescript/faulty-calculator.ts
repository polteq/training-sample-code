export class FaultyCalculator {
  constructor() {}

  /**
   * Should return 0 when dividing by 0
   * @param a
   * @param b
   * @returns the quotient a / b
   */
  public divide(a: number, b: number): number {
    return a / b;
  }

  /**
   * Should return the average of two numbers
   * @param a
   * @param b
   * @returns the average of a + b
   */
  public average(a: number, b: number): number {
    return (a + b) / 2;
  }
}
