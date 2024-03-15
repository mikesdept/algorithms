package leetcode.easy;

public class ExcelSheetColumnNumber171 {

    public int titleToNumber(String columnTitle) {
        int result = 0;
        int pow = 0;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            result += (columnTitle.charAt(i) - 64) * Math.pow(26, pow);
            pow++;
        }
        return result;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber171 excelSheetColumnNumber171 = new ExcelSheetColumnNumber171();
        System.out.println(excelSheetColumnNumber171.titleToNumber("A")); // 1
        System.out.println(excelSheetColumnNumber171.titleToNumber("AB")); // 28
        System.out.println(excelSheetColumnNumber171.titleToNumber("ZY")); // 701
        System.out.println(excelSheetColumnNumber171.titleToNumber("FXSHRXW")); // 2147483647
    }

}
