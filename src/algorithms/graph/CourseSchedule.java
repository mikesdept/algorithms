package algorithms.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class CourseSchedule {

    // bad time and space complexity using bread first search approach
    public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int index = prerequisites[i][1];
            List<Integer> prerequisitesCourses = adjList.get(index);
            prerequisitesCourses.add(prerequisites[i][0]);
        }

        for (int v = 0; v < numCourses; v++) {
            Queue<Integer> queue = new LinkedBlockingQueue<>();
            List<Integer> seen = new ArrayList<>();
            for (int i = 0; i < adjList.get(v).size(); i++) {
                queue.add(adjList.get(v).get(i));
            }
            while (!queue.isEmpty()) {
                int current = queue.poll();
                seen.add(current);
                if (current == v) {
                    return false;
                }
                List<Integer> adjacent = adjList.get(current);
                for (int i = 0; i < adjacent.size(); i++) {
                    int next = adjacent.get(i);
                    if (!seen.contains(next)) {
                        queue.add(next);
                    }
                }
            }
        }
        return true;
    }

    // TODO: should be simplified and rechecked this logic
    public boolean canFinishTopologicalSort(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int index = prerequisites[i][1];
            List<Integer> prerequisitesCourses = adjList.get(index);
            prerequisitesCourses.add(prerequisites[i][0]);
        }
        List<Integer> inDegree = new ArrayList<>();
        for (int i = 0; i < adjList.size(); i++) {
            inDegree.add(0);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree.set(prerequisites[i][0], inDegree.get(prerequisites[i][0]) + 1);
        }
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        for (int i = 0; i < inDegree.size(); i++) {
            if (inDegree.get(i) == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;
            List<Integer> adjacent = adjList.get(current);
            for (int i = 0; i < adjacent.size(); i++) {
                int next = adjacent.get(i);
                inDegree.set(next, inDegree.get(next) - 1);
                if (inDegree.get(next) == 0) {
                    queue.add(next);
                }
            }
        }
        return count == numCourses;
    }

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        int[][] prerequisites = new int[][]{{1, 0}, {2, 1}, {2, 5}, {0, 3}, {4, 3}, {3, 5}, {4, 5}};
        System.out.println(courseSchedule.canFinishBFS(6, prerequisites));
        System.out.println(courseSchedule.canFinishTopologicalSort(6, prerequisites));
    }

}
