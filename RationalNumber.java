public class RationalNumber extends Number{
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *  If the denominator is negative, negate both numerator and denominator
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    super();//this value is ignored!
    if (deno == 0) {
      nume = 0;
      deno = 1;
    }
    if (deno < 0) {
      nume = -1 * nume;
      deno = -1 * deno;
    }
    numerator = nume;
    denominator = deno;
    reduce();
  }

  public double getValue(){
    return (double) numerator / (double) denominator;
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
    return new RationalNumber(denominator, numerator);
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    return ((numerator == other.getNumerator()) && (denominator == other.getDenominator()));
  }


  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    if (denominator == 1) {
      return "" + numerator;
    }
    else if (numerator == 0) {
      return ""  + 0;
    }
    return numerator + "/" + denominator;
  }

  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
    /*use euclids method or a better one*/
    while (b != 0) {
      int r = a % b;
      a = b;
      b = r;
    }
    return a;
  }

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    int common_factor = gcd(numerator, denominator);
    numerator = numerator / common_factor;
    denominator = denominator / common_factor;
  }
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    return new RationalNumber(numerator * other.getNumerator(), denominator * other.getDenominator());
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    return multiply(other.reciprocal());
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    int num1 = numerator * other.getDenominator();
    int num2 = other.getNumerator() * denominator;
    int sum1 = num1 + num2;
    int common_den = denominator * other.getDenominator();
    return new RationalNumber(sum1, common_den);
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    int num1 = numerator * other.getDenominator();
    int num2 = other.getNumerator() * denominator;
    int difference = num1 - num2;
    int common_den = denominator * other.getDenominator();
    return new RationalNumber(difference, common_den);
  }
}
