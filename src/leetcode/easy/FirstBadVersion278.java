package leetcode.easy;

public class FirstBadVersion278 {

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int firstBadVersion = -1;
        while (left <= right) {
            int version = left + (right - left) / 2;
            if (isBadVersion(version)) {
                firstBadVersion = version;
                right = version - 1;
            } else {
                left = version + 1;
            }
        }
        return firstBadVersion;
    }

    private boolean isBadVersion(int version) {
        if (version == 1) {
            return false;
        } else if (version == 2) {
            return false;
        } else if (version == 3) {
            return false;
        } else if (version == 4) {
            return true;
        } else if (version == 5) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        FirstBadVersion278 firstBadVersion278 = new FirstBadVersion278();
        System.out.println(firstBadVersion278.firstBadVersion(5)); // 4
    }
}
