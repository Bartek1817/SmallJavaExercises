package fizzbuzz;

public class FizzBuzz {

    public static void recursiveFizzBuzz(int i, int k) { // Liczenie rekurencyjne - x*3A x*5B x*15AB
        if (i <= k) {
            if (i != 0 && i % 5 == 0 && i % 3 == 0) {
                System.out.println(i + " FizzBuzz");
                recursiveFizzBuzz(++i, k);
                return;
            }
            if (i != 0 && i % 5 == 0) {
                System.out.println(i + " Buzz");
                recursiveFizzBuzz(++i, k);
                return;
            }
            if (i != 0 && i % 3 == 0) {
                System.out.println(i + " Fizz");
                recursiveFizzBuzz(++i, k);
                return;
            }
            System.out.println(i);
            recursiveFizzBuzz(++i, k);
        }
    }

    public static void iterationFizzBuzz(int i, int k) { // Liczenie iteracyjne x*3A x*5B x*15AB
        for (; i <= k; i++) {
            if (i != 0 && i % 5 == 0 && i % 3 == 0) {
                System.out.println(i + " FizzBuzz");
            } else if (i != 0 && i % 5 == 0) {
                System.out.println(i + " Buzz");
            } else if (i != 0 && i % 3 == 0) {
                System.out.println(i + " Fizz");
            } else {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        recursiveFizzBuzz(0, 100);
        iterationFizzBuzz(0, 100);
    }

}
