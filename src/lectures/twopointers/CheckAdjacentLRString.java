package lectures.twopointers;

public class CheckAdjacentLRString {

    public boolean check(String start, String end) {
        if (start == null || end == null || start.length() == 0 || end.length() == 0 || start.length() != end.length()) {
            return false;
        }
        int first = -1;
        int second = -1;
        boolean checkL = false;
        boolean checkR = false;
        do {
            if (!checkL && !checkR && first < start.length() - 1) {
                first++;
                char letter = start.charAt(first);
                if (letter == 'L') {
                    checkL = true;
                } else if (letter == 'R') {
                    checkR = true;
                }
            } else {
                second++;
                char letter = end.charAt(second);
                if (checkL && letter == 'L' && first >= second) {
                    checkL = false;
                } else if (checkR && letter == 'R' && first <= second) {
                    checkR = false;
                } else if (letter != 'X') {
                    return false;
                }
            }
        } while (first < start.length() - 1 || second < end.length() - 1);
        return !checkL && !checkR;
    }

    public static void main(String[] args) {
        CheckAdjacentLRString checkAdjacentLRString = new CheckAdjacentLRString();
        System.out.println(checkAdjacentLRString.check("RXXLRXRXL", "XRLXXRRLX")); // true
        System.out.println(checkAdjacentLRString.check("RXXLRXRXLX", "XRLXXRRLXX")); // true
        System.out.println(checkAdjacentLRString.check("RXXLRXRXLXR", "XRLXXRRLXXL")); // false
        System.out.println(checkAdjacentLRString.check("RXXLRXRXLXRRR", "XRLXXRRLXXLLL")); // false
        System.out.println(checkAdjacentLRString.check("RXXLRXRXLXXXXLR", "XRLXXRRLXXXXX")); // false
        System.out.println(checkAdjacentLRString.check("RXXLRXRXLXXXX", "XRLXXRRLXXXXXLR")); // false
        System.out.println(checkAdjacentLRString.check("XLLR", "LXLX")); // false
        System.out.println(checkAdjacentLRString.check("RXR", "XXR")); // false
    }
}
