import java.util.*;
import java.io.*;
import java.util.ArrayList;
// https://www.codingninjas.com/studio/problems/smallest-number-whose-digits-multiplication-is-n_1463973?leftPanelTabValue=PROBLEM
class Solution {
    public static int smallestDigitMuliply(int n) {
        int ans = 0;
        int currentDivisor = 9;
        while (currentDivisor > 1 && n != 1) {
            if (n % currentDivisor == 0) {
                ans = ans * 10 + currentDivisor;
                n = n / currentDivisor;
            } else {
                currentDivisor--;
            }
        }
        if (n != 1) {
            ans = 0;
        }
        int finalAns = 0;
        while (ans != 0) {
            finalAns = finalAns * 10 + ans % 10;
            ans = ans / 10;
        }
        return finalAns;
    }
}
