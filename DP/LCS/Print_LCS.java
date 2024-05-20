import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'longestCommonSubsequence' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     * 1. INTEGER_ARRAY a
     * 2. INTEGER_ARRAY b
     */

    public static List<Integer> longestCommonSubsequence(List<Integer> a, List<Integer> b) {
        int length1 = a.size();
        int length2 = b.size();
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int index1 = 0; index1 <= length1; index1++) {
            for (int index2 = 0; index2 <= length2; index2++) {

                if (index1 == 0 || index2 == 0) {
                    dp[index1][index2] = 0;
                    continue;
                }
                if (a.get(index1 - 1) == b.get(index2 - 1)) {
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                } else {
                    dp[index1][index2] = Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]);
                }

            }
        }

        List<Integer> ans = new ArrayList<>();
        if (dp[length1][length2] == 0) {
            return ans;
        }

        int index1 = length1;
        int index2 = length2;
        while (index1 > 0 && index2 > 0) {
            if (a.get(index1 - 1) == b.get(index2 - 1)) {
                ans.add(0, a.get(index1 - 1));
                index1--;
                index2--;
            } else {
                if (dp[index1][index2] == dp[index1 - 1][index2]) {
                    index1--;
                } else {
                    index2--;
                }
            }
        }
        return ans;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.longestCommonSubsequence(a, b);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
