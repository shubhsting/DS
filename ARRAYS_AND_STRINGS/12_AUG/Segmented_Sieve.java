import java.util.Arrays;
import java.util.Scanner;

// https://www.spoj.com/problems/PRIME1/cstart=10
class Main {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scn = new Scanner(System.in);
        int tc = scn.nextInt();
        while (tc-- > 0) {
            int start = scn.nextInt();
            int end = scn.nextInt();

            boolean[] numbers = new boolean[end - start + 1];
            boolean[] primeNumbers = new boolean[(int) (Math.ceil(Math.sqrt(end)) + 1)];
            Arrays.fill(numbers, true);
            Arrays.fill(primeNumbers, true);
            for (int primeNumber = 2; primeNumber * primeNumber < end; primeNumber++) {

                if (primeNumbers[primeNumber]) {
                    // remove all non primes fro original prime numbers array
                    for (int number = primeNumber + 1; number < primeNumbers.length; number++) {
                        if (number % primeNumber == 0) {
                            primeNumbers[number] = false;
                        }
                    }
                    // remove all prime numbers from range
                    for (int index = 0; index < numbers.length; index++) {
                        if ((start + index) > primeNumber && (start + index) % primeNumber == 0) {
                            numbers[index] = false;
                        }
                    }
                }

            }

            for (int index = 0; index < numbers.length; index++) {
                if (numbers[index] && start + index > 1) {
                    System.out.println(start + index);
                }
            }
        }
    }
}
