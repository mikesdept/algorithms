package algorithms.strings;

public class TypedOutStrings {

    public boolean equalsTwoStringsOptimalSolution(String s, String t) {
        int index1 = s.length() - 1;
        int index2 = t.length() - 1;
        while (index1 >= 0 || index2 >= 0) {
            if ((index1 >= 0 && s.charAt(index1) == '#') || (index2 >= 0 && t.charAt(index2) == '#')) {
                if (index1 >= 0 && s.charAt(index1) == '#') {
                    int decrementIndex1 = 2;
                    while (decrementIndex1 > 0) {
                        index1--;
                        decrementIndex1--;
                        if (index1 >= 0 && s.charAt(index1) == '#') {
                            decrementIndex1 += 2;
                        }
                    }
                }
                if (index2 >= 0 && t.charAt(index2) == '#') {
                    int decrementIndex2 = 2;
                    while (decrementIndex2 > 0) {
                        index2--;
                        decrementIndex2--;
                        if (index2 >= 0 && t.charAt(index2) == '#') {
                            decrementIndex2 += 2;
                        }
                    }
                }
            } else if (index1 < 0 || index2 < 0) {
                return false;
            } else if (s.charAt(index1) != t.charAt(index2)) {
                return false;
            } else {
                index1--;
                index2--;
            }
        }
        return true;
    }

    public boolean equalsTwoStringsBruteForce(String s, String t) {
        return modifyStringBruteForce(s).equals(modifyStringBruteForce(t));
    }

    public boolean backspaceCompare(String s, String t) {
        int sIndex = s.length();
        int tIndex = t.length();
        while (sIndex > 0 || tIndex > 0) {
            Character sChar = null;
            Character tChar = null;
            sIndex--;
            tIndex--;
            if (sIndex >= 0) {
                if (s.charAt(sIndex) == '#') {
                    int sDecrement = 2;
                    while (sDecrement > 0) {
                        sIndex--;
                        sDecrement--;
                        if (sIndex >= 0 && s.charAt(sIndex) == '#') {
                            sDecrement += 2;
                        }
                    }
                    if (sIndex >= 0) {
                        sChar = s.charAt(sIndex);
                    }
                } else {
                    sChar = s.charAt(sIndex);
                }
            }
            if (tIndex >= 0) {
                if (t.charAt(tIndex) == '#') {
                    int tDecrement = 2;
                    while (tDecrement > 0) {
                        tIndex--;
                        tDecrement--;
                        if (tIndex >= 0 && t.charAt(tIndex) == '#') {
                            tDecrement += 2;
                        }
                    }
                    if (tIndex >= 0) {
                        tChar = t.charAt(tIndex);
                    }
                } else {
                    tChar = t.charAt(tIndex);
                }
            }
            if (!((sChar == null && tChar == null) || (sChar != null && tChar != null && sChar.equals(tChar)))) {
                return false;
            }
        }
        return true;
    }

    private String modifyStringBruteForce(String string) {
        StringBuilder modifiedString = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char letter = string.charAt(i);
            if (letter == '#' && modifiedString.length() > 0) {
                modifiedString.deleteCharAt(modifiedString.length() - 1);
            } else if (letter != '#') {
                modifiedString.append(letter);
            }
        }
        return modifiedString.toString();
    }

    public static void main(String[] args) {
        TypedOutStrings typedOutStrings = new TypedOutStrings();
        System.out.println("Brute force solution");
        System.out.println(typedOutStrings.equalsTwoStringsBruteForce("12345", "12345")); // true
        System.out.println(typedOutStrings.equalsTwoStringsBruteForce("12#65#9", "12#65#9")); // true
        System.out.println(typedOutStrings.equalsTwoStringsBruteForce("12#65#9", "15#699##921##")); // true
        System.out.println(typedOutStrings.equalsTwoStringsBruteForce("12#65#9", "15#699#921#")); // false
        System.out.println(typedOutStrings.equalsTwoStringsBruteForce("ab##", "c#d#")); // true
        System.out.println(typedOutStrings.equalsTwoStringsBruteForce("y#fo##f", "y#f#o##f")); // true
        System.out.println(typedOutStrings.equalsTwoStringsBruteForce("bxj##tw", "bxj###tw")); // false
        System.out.println("Optimal solution below");
        System.out.println(typedOutStrings.equalsTwoStringsOptimalSolution("12345", "12345")); // true
        System.out.println(typedOutStrings.equalsTwoStringsOptimalSolution("12#65#9", "12#65#9")); // true
        System.out.println(typedOutStrings.equalsTwoStringsOptimalSolution("12#65#9", "15#699##921##")); // true
        System.out.println(typedOutStrings.equalsTwoStringsOptimalSolution("12#65#9", "15#699#921#")); // false
        System.out.println(typedOutStrings.equalsTwoStringsOptimalSolution("ab##", "c#d#")); // true
        System.out.println(typedOutStrings.equalsTwoStringsOptimalSolution("y#fo##f", "y#f#o##f")); // true
        System.out.println(typedOutStrings.equalsTwoStringsOptimalSolution("bxj##tw", "bxj###tw")); // false
        System.out.println("Another optimal solution below");
        System.out.println(typedOutStrings.backspaceCompare("y#fo##f", "y#fx#o##f")); // true
        System.out.println(typedOutStrings.backspaceCompare("bxj##tw", "bxj###tw")); // false
    }

}
