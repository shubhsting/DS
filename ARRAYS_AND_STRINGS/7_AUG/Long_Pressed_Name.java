// https://leetcode.com/problems/long-pressed-name/description/
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length()) {
            return false;
        }
        int nameIndex = 0;
        int typedIndex = 0;

        while (nameIndex < name.length() && typedIndex < typed.length()) {
            char namedChar = name.charAt(nameIndex);
            char typedChar = typed.charAt(typedIndex);
            if (namedChar == typedChar) {
                nameIndex++;
                typedIndex++;
            } else {
                if (typedIndex - 1 >= 0 && typed.charAt(typedIndex - 1) == typedChar) {
                    typedIndex++;
                } else {
                    return false;
                }
            }
        }

        if (nameIndex != name.length()) {
            return false;
        } else if (typedIndex != typed.length()) {
            while (typedIndex < typed.length()) {
                if (typed.charAt(typedIndex) != typed.charAt(typedIndex - 1)) {
                    return false;
                }
                typedIndex++;
            }
        }
        return true;
    }
}
