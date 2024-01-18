package datastructures.arrays.reversestring;

class ReverseString {

    private static String reverseString(String string) {
        if (string == null || string.length() < 2) {
            return string;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = string.length() - 1; i >= 0; i--) {
                stringBuilder.append(string.charAt(i));
            }
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseString("Hello My name is Sergei"));
        System.out.println(reverseString("Hi"));
        System.out.println(reverseString("H"));
        System.out.println(reverseString(""));
        System.out.println(reverseString(null));
    }

}
