package datastructures.arrays.arrayimplementation;

public class DynamicArray {

    private String[] array;

    private int length;

    private int capacity;

    public DynamicArray() {
        length = 0;
        capacity = 1;
        array = new String[capacity];
    }

    public void add(String item) {
        if (length == capacity) {
            capacity *= 2;
            String[] tempArray = new String[capacity];
            for (int i = 0; i < length; i++) {
                tempArray[i] = array[i];
            }
            array = tempArray;
        }
        array[length] = item;
        length++;
    }

    public String get(int index) throws Exception {
        if (index > -1 && index < length) {
            return array[index];
        } else {
            throw new Exception("Custom Error - Index Out Of Bound Exception, index = " + index + ", length = " + length);
        }
    }

    public String pop() throws Exception {
        if (length > 0) {
            String item = array[length - 1];
            array[length - 1] = null;
            length--;
            return item;
        }
        throw new Exception("Custom Error - no elements in array");
    }

    public void delete(int index) throws Exception {
        if (index > -1 && index < length) {
            for (int i = index; i < length - 1; i++) {
                if (i == length - 1) {
                    array[i] = null;
                } else {
                    array[i] = array[i + 1];
                }
            }
            length--;
        } else {
            throw new Exception("Custom Error - wrong index - " + index);
        }
    }

    @Override
    public String toString() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\n");
            for (int i = 0; i < length; i++) {
                stringBuilder.append("item[" + i + "] = " + get(i)).append("\n");
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Unable to convert to string";
        }
    }

    public static void main(String[] args) throws Exception {
        DynamicArray dynamicArray = new DynamicArray();
        System.out.println("array:" + dynamicArray);
        dynamicArray.add("new string");
        System.out.println("array:" + dynamicArray);
        dynamicArray.add("new item");
        System.out.println("array:" + dynamicArray);
        dynamicArray.add("one more item");
        System.out.println("array:" + dynamicArray);
        dynamicArray.add("4th item");
        System.out.println("array:" + dynamicArray);
        dynamicArray.add("5th item");
        System.out.println("array:" + dynamicArray);
        System.out.println("get item by index = 0 -> " + dynamicArray.get(0));
        System.out.println("get item by index = 1 -> " + dynamicArray.get(1));
        System.out.println("get item by index = 2 -> " + dynamicArray.get(2));
        System.out.println("get item by index = 3 -> " + dynamicArray.get(3));
        System.out.println("get item by index = 4 -> " + dynamicArray.get(4));
        System.out.println("pop item -> " + dynamicArray.pop());
        System.out.println("array:" + dynamicArray);
        dynamicArray.delete(2);
        System.out.println("array:" + dynamicArray);
        dynamicArray.delete(1);
        System.out.println("array:" + dynamicArray);
        System.out.println("array length = " + dynamicArray.length);
    }

}
