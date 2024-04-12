package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfStudentsUnableToEatLunch1700 {

    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentsQueue = new LinkedList<>();
        Queue<Integer> sandwichesQueue = new LinkedList<>();
        for (int student : students) {
            studentsQueue.add(student);
        }
        for (int sandwich : sandwiches) {
            sandwichesQueue.add(sandwich);
        }

        int studentsSwapCounter = 0;
        while (!studentsQueue.isEmpty()) {
            if (studentsQueue.size() == studentsSwapCounter) {
                break;
            }
            int student = studentsQueue.poll();
            if (sandwichesQueue.peek() == student) {
                sandwichesQueue.poll();
                studentsSwapCounter = 0;
            } else {
                studentsQueue.add(student);
                studentsSwapCounter++;
            }
        }

        return studentsQueue.size();
    }

    public static void main(String[] args) {
        NumberOfStudentsUnableToEatLunch1700 numberOfStudentsUnableToEatLunch1700 = new NumberOfStudentsUnableToEatLunch1700();
        System.out.println(numberOfStudentsUnableToEatLunch1700.countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1})); // 0
        System.out.println(numberOfStudentsUnableToEatLunch1700.countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1})); // 3
    }
}
