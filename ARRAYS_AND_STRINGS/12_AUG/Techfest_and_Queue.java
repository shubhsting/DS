import java.util.Arrays;
// https://www.geeksforgeeks.org/problems/techfest-and-the-queue1044/1
class Solution {
    public static long sumOfPowers(long a, long b) {
        int noOfPrimeFactors = (int) b + 1;
        boolean[] prime = new boolean[noOfPrimeFactors];
        Arrays.fill(prime, true);
        for (int index = 2; index * index <= b; index++) {
            int multiplyingFactor = 2;

            while (index * multiplyingFactor < noOfPrimeFactors) {
                prime[index * multiplyingFactor] = false;
                multiplyingFactor += 1;
            }
        }

        long ans = 0;

        for (long n = a; n <= b; n++) {
            int currentPrimeFactor = (int) Math.ceil(Math.sqrt(n)) + 1;
            long number = n;
            if (prime[(int) n] && n != 1) {
                ans += 1;
                continue;
            }
            int power = 0;
            while (currentPrimeFactor > 1 && number > 1) {
                if (!prime[currentPrimeFactor]) {
                    currentPrimeFactor--;
                    continue;
                }

                if (number % currentPrimeFactor == 0) {
                    power++;
                    number = number / currentPrimeFactor;
                } else {
                    ans += power;
                    power = 0;
                    currentPrimeFactor--;
                }
            }
            ans += power;
            if (prime[(int) number] && number != 1) {
                ans += 1;
            }
        }
        return ans;
    }
}
