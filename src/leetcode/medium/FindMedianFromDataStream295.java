package leetcode.medium;

import java.util.PriorityQueue;

public class FindMedianFromDataStream295 {

    private final PriorityQueue<Integer> queueMax;
    private final PriorityQueue<Integer> queueMin;

    public FindMedianFromDataStream295() {
        queueMax = new PriorityQueue<>((a, b) -> a > b ? -1 : 1);
        queueMin = new PriorityQueue<>((a, b) -> a > b ? 1 : -1);
    }

    public void addNum(int num) {
        if (queueMax.isEmpty()) {
            queueMax.add(num);
        } else {
            if (queueMax.peek() >= num) {
                queueMax.add(num);
            } else {
                queueMin.add(num);
            }
            if (Math.abs(queueMax.size() - queueMin.size()) > 1) {
                if (queueMax.size() > queueMin.size()) {
                    queueMin.add(queueMax.poll());
                } else {
                    queueMax.add(queueMin.poll());
                }
            }
        }
    }

    public double findMedian() {
        if (queueMax.size() > queueMin.size()) {
            return queueMax.peek();
        } else if (queueMax.size() < queueMin.size()) {
            return queueMin.peek();
        } else {
            return (queueMax.peek() + queueMin.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        FindMedianFromDataStream295 findMedianFromDataStream295 = new FindMedianFromDataStream295();
        findMedianFromDataStream295.addNum(1);
        findMedianFromDataStream295.addNum(2);
        System.out.println(findMedianFromDataStream295.findMedian()); // 1.5
        findMedianFromDataStream295.addNum(3);
        System.out.println(findMedianFromDataStream295.findMedian()); // 2.0
    }

}
