package leetcode.easy;

public class FindTheIndexOfTheFirstOccurrenceInString28 {

    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int index = 0;
        while (index <= haystack.length() - needle.length()) {
            if (needle.equals(haystack.substring(index, index + needle.length()))) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public static void main(String[] args) {
        FindTheIndexOfTheFirstOccurrenceInString28 findTheIndexOfTheFirstOccurrenceInString28 = new FindTheIndexOfTheFirstOccurrenceInString28();
        System.out.println(findTheIndexOfTheFirstOccurrenceInString28.strStr("sadbutsad", "sad")); // 0
        System.out.println(findTheIndexOfTheFirstOccurrenceInString28.strStr("leetcode", "leeto")); // -1
    }

}
