class FaultyCalculator
{
        public FaultyCalculator() { }

        /// <summary>
        /// Should return 0 when dividing by zero
        /// </summary>
        /// <param name="a">dividend</param>
        /// <param name="b">divisor</param>
        /// <returns></returns>
        public double Divide(double a, double b)
        {
            return a / b;
        }

        /// <summary>
        /// Should return the average of two numbers
        /// </summary>
        /// <param name="a"></param>
        /// <param name="b"></param>
        /// <returns></returns>
        public double Average(int a, int b)
        {
            return (a + b) / 2;
        }
}
