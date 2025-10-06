public class LargestOfThree {
    public static void main(String[] args) {
        int a = 15, b = 30, c = 20;
        if (a > b && a > c) {
            System.out.println("Largest: " + a);
        } else if (b > a && b > c) {
            System.out.println("Largest: " + b);
        } else {
            System.out.println("Largest: " + c);
        }
    }
}