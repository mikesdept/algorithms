package algorithms.recursion;

public class ReverseString {

    public String reverseStringRecursively(String input) {
        if (input == null) {
            return null;
        } else if (input.isEmpty()) {
            return input;
        } else {
            char firstChar = input.charAt(0);
            return reverseStringRecursively(input.substring(1)) + firstChar;
        }
    }

    public String reverseStringIteratively(String input) {
        if (input == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            stringBuilder.append(input.charAt(i));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        String item1 = "Hello World!";
        String item2 = "";
        String item3 = "  ";
        String item4 = null;
        String item5 = "Hi";
        String item6 = "H";
        String item7 = "Hi there";
        System.out.println("reverse string iteratively");
        System.out.println("item 1 -> " + reverseString.reverseStringIteratively(item1));
        System.out.println("item 2 -> " + reverseString.reverseStringIteratively(item2));
        System.out.println("item 3 -> " + reverseString.reverseStringIteratively(item3));
        System.out.println("item 4 -> " + reverseString.reverseStringIteratively(item4));
        System.out.println("item 5 -> " + reverseString.reverseStringIteratively(item5));
        System.out.println("item 6 -> " + reverseString.reverseStringIteratively(item6));
        System.out.println("item 7 -> " + reverseString.reverseStringIteratively(item7));
        System.out.println("reverse string recursively");
        System.out.println("item 1 -> " + reverseString.reverseStringRecursively(item1));
        System.out.println("item 2 -> " + reverseString.reverseStringRecursively(item2));
        System.out.println("item 3 -> " + reverseString.reverseStringRecursively(item3));
        System.out.println("item 4 -> " + reverseString.reverseStringRecursively(item4));
        System.out.println("item 5 -> " + reverseString.reverseStringRecursively(item5));
        System.out.println("item 6 -> " + reverseString.reverseStringRecursively(item6));
        System.out.println("item 7 -> " + reverseString.reverseStringRecursively(item7));
    }

}
