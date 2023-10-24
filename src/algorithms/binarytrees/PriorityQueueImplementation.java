package algorithms.binarytrees;

public class PriorityQueueImplementation {

    public PriorityQueueImplementation() {
        this.array = new Integer[1];
        this.capacity = 1;
        this.size = 0;
    }

    private Integer[] array;

    private int capacity;

    int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public Integer peek() {
        if (size > 0) {
            return array[0];
        }
        return null;
    }

    public Integer pop() {
        if (size == 1) {
            int returnValue = array[0];
            array[0] = null;
            size--;
            return returnValue;
        } else if (size > 1) {
            int returnValue = array[0];
            int latestValue = array[size - 1];

            array[size - 1] = null;
            array[0] = latestValue;
            size--;

            int valueIndex = 0;
            Integer maxChildIndex = getMaxChildIndex(valueIndex);

            while (maxChildIndex != null && array[valueIndex] < array[maxChildIndex]) {
                int tempValue = array[valueIndex];
                array[valueIndex] = array[maxChildIndex];
                array[maxChildIndex] = tempValue;
                valueIndex = maxChildIndex;
                maxChildIndex = getMaxChildIndex(valueIndex);
            }

            return returnValue;
        } else {
            return null;
        }
    }

    public void push(int value) {
        if (size == capacity) {
            capacity *= 2;
            Integer[] tempArray = new Integer[capacity];
            for (int i = 0; i < array.length; i++) {
                tempArray[i] = array[i];
            }
            array = new Integer[capacity];
            for (int i = 0; i < tempArray.length; i++) {
                array[i] = tempArray[i];
            }
        }
        size++;
        int valueIndex = size - 1;
        int parentIndex = getParentIndex(valueIndex);
        array[valueIndex] = value;

        while (array[valueIndex] > array[parentIndex]) {
            int tempValue = array[valueIndex];
            array[valueIndex] = array[parentIndex];
            array[parentIndex] = tempValue;
            valueIndex = parentIndex;
            parentIndex = getParentIndex(valueIndex);
        }
    }

    private int getParentIndex(int currentIndex) {
        return (currentIndex - 1) / 2;
    }

    private Integer getMaxChildIndex(int currentIndex) {
        int leftChildIndex = (currentIndex * 2) + 1;
        int rightChildIndex = (currentIndex * 2) + 2;
        Integer maxChildIndex;
        if (leftChildIndex >= size && rightChildIndex >= size) {
            maxChildIndex = null;
        } else if (leftChildIndex >= size) {
            maxChildIndex = rightChildIndex;
        } else if (rightChildIndex >= size) {
            maxChildIndex = leftChildIndex;
        } else {
            if (array[leftChildIndex] > array[rightChildIndex]) {
                maxChildIndex = leftChildIndex;
            } else {
                maxChildIndex = rightChildIndex;
            }
        }
        return maxChildIndex;
    }

    public static void main(String[] args) {
        PriorityQueueImplementation priorityQueueImplementation = new PriorityQueueImplementation();
        priorityQueueImplementation.push(15);
        priorityQueueImplementation.push(12);
        priorityQueueImplementation.push(50);
        priorityQueueImplementation.push(7);
        priorityQueueImplementation.push(40);
        priorityQueueImplementation.push(22);
        while (!priorityQueueImplementation.isEmpty()) {
            System.out.println(priorityQueueImplementation.pop());
        }
        // output is: 50, 40, 22, 15, 12, 7
    }

}
