package algorithms.strings;

public class TypedOutStrings {

    public boolean equalsTwoStringsBruteForce(String s, String t) {
        return modifyStringBruteForce(s).equals(modifyStringBruteForce(t));
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
        System.out.println(typedOutStrings.equalsTwoStringsBruteForce("12345", "12345")); // true
        System.out.println(typedOutStrings.equalsTwoStringsBruteForce("12#65#9", "12#65#9")); // true
        System.out.println(typedOutStrings.equalsTwoStringsBruteForce("12#65#9", "15#699##921##")); // true
        System.out.println(typedOutStrings.equalsTwoStringsBruteForce("12#65#9", "15#699#921#")); // false
        System.out.println(typedOutStrings.equalsTwoStringsBruteForce("ab##", "c#d#")); // true
        System.out.println(typedOutStrings.equalsTwoStringsBruteForce("y#fo##f", "y#f#o##f")); // true
    }

}
