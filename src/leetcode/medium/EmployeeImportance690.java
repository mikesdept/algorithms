package leetcode.medium;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class EmployeeImportance690 {

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }

        int importance = 0;
        Employee employee = map.get(id);
        importance += employee.importance;
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        for (int subordinateId : employee.subordinates) {
            queue.add(subordinateId);
        }

        while (!queue.isEmpty()) {
            int subordinateId = queue.poll();
            Employee subordinate = map.get(subordinateId);
            importance += subordinate.importance;

            for (int subordinateSubordinateId : subordinate.subordinates) {
                queue.add(subordinateSubordinateId);
            }
        }
        return importance;
    }

    public static void main(String[] args) {
        EmployeeImportance690 employeeImportance690 = new EmployeeImportance690();

        List<Employee> employees1 = new ArrayList<>();
        employees1.add(new Employee(1, 5, new ArrayList<>(Arrays.asList(2, 3))));
        employees1.add(new Employee(2, 3, new ArrayList<>()));
        employees1.add(new Employee(3, 3, new ArrayList<>()));

        List<Employee> employees2 = new ArrayList<>();
        employees2.add(new Employee(1, 2, new ArrayList<>(Collections.singletonList(5))));
        employees2.add(new Employee(5, -3, new ArrayList<>()));

        List<Employee> employees3 = new ArrayList<>();
        employees3.add(new Employee(1, 5, new ArrayList<>(Arrays.asList(2, 3))));
        employees3.add(new Employee(2, 3, new ArrayList<>(Collections.singletonList(4))));
        employees3.add(new Employee(3, 4, new ArrayList<>()));
        employees3.add(new Employee(4, 1, new ArrayList<>()));

        System.out.println(employeeImportance690.getImportance(employees1, 1)); // 11
        System.out.println(employeeImportance690.getImportance(employees2, 5)); // -3
        System.out.println(employeeImportance690.getImportance(employees3, 1)); // 13
    }

    private static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }

}
