public class Tester {
  public static void main (String[] args) {
    RealNumber r1 = new RealNumber (1.73);
    RealNumber r2 = new RealNumber (1.73);
    RealNumber r3 = new RealNumber (4);
    RealNumber r4 = new RealNumber (0);
    System.out.println(r1.getValue());
    System.out.println(r1.equals(r3));
    System.out.println(r1.equals(r2));
    System.out.println(r1.add(r3));
    System.out.println(r1.multiply(r3));
    System.out.println(r1.multiply(r4));
    System.out.println(r1.divide(r2));
    System.out.println(r1.divide(r3));
  }
}
