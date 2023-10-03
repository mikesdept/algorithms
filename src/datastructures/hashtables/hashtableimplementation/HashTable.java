package datastructures.hashtables.hashtableimplementation;

import java.util.ArrayList;
import java.util.Arrays;

public class HashTable {

    private ArrayList<Item>[] data;
    private int currentLength;

    public HashTable(int size) {
        this.data = new ArrayList[size];
    }

    public void add(String key, int value) {
        int hash = getHash(key);
        if (data[hash] == null) {
            data[hash] = new ArrayList<>();
            data[hash].add(new Item(key, value));
            currentLength++;
        } else {
            ArrayList<Item> arrayList = data[hash];
            if (get(key) == null) {
                arrayList.add(new Item(key, value));
                currentLength++;
            } else {
                for (int i = 0; i < arrayList.size(); i++) {
                    if (arrayList.get(i).getKey().equals(key)) {
                        arrayList.remove(i);
                        arrayList.add(new Item(key, value));
                        return;
                    }
                }
            }
        }
    }

    public void remove(String key) {
        int hash = getHash(key);
        if (data[hash] == null) {
            return;
        }
        if (data[hash].size() == 1 && data[hash].get(0).getKey().equals(key)) {
            data[hash] = null;
            currentLength--;
        } else {
            ArrayList<Item> arrayList = data[hash];
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).getKey().equals(key)) {
                    arrayList.remove(i);
                    return;
                }
            }
        }
    }

    public Integer get(String key) {
        int hash = getHash(key);
        ArrayList<Item> arrayList = data[hash];
        if (arrayList != null && arrayList.size() == 1) {
            String keyCandidate = arrayList.get(0).getKey();
            if (keyCandidate.equals(key)) {
                return arrayList.get(0).getValue();
            }
        } else if (arrayList != null) {
            for (Item item : arrayList) {
                if (item.getKey().equals(key)) {
                    return item.getValue();
                }
            }
        }
        return null;
    }

    public String[] keys() {
        String[] keys = new String[currentLength];
        int currentIndexKeys = 0;
        for (ArrayList<Item> arrayList : data) {
            if (arrayList != null) {
                for (Item item : arrayList) {
                    keys[currentIndexKeys] = item.getKey();
                    currentIndexKeys++;
                }
            }
        }
        return keys;
    }

    public String[] keysWithHashes() {
        String[] keys = new String[currentLength];
        int currentIndexKeys = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                for (Item item : data[i]) {
                    keys[currentIndexKeys] = "Key = " + item.getKey() + ", Hash = " + i;
                    currentIndexKeys++;
                }
            }
        }
        return keys;
    }

    private Integer getHash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash + key.codePointAt(i) * i) % this.data.length;
        }
        return hash;
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        hashTable.add("apple", 5);
        hashTable.add("orange", 9);
        hashTable.add("fruits", 21);
        hashTable.add("orange", 10);
        hashTable.add("apple", 6);
        hashTable.add("qwe", 123);
        hashTable.add("asd", 321);
        hashTable.add("zxc", 456);
        hashTable.add("qaz", 654);
        hashTable.add("wsx", 789);
        System.out.println("get apple value -> " + hashTable.get("apple"));
        System.out.println("get orange value -> " + hashTable.get("orange"));
        System.out.println("get fruitss value -> " + hashTable.get("fruitss"));
        System.out.println("get fruits value -> " + hashTable.get("fruits"));
        System.out.println("get undefined value -> " + hashTable.get("undefined"));
        System.out.println("get all keys -> " + Arrays.toString(hashTable.keys()));
        System.out.println("get all keys -> " + Arrays.toString(hashTable.keysWithHashes()));
        hashTable.remove("undefined");
        hashTable.remove("apple");
        hashTable.remove("fruits");
        System.out.println("remove undefined, apple and fruits");
        System.out.println("get all keys -> " + Arrays.toString(hashTable.keys()));
        System.out.println("get all keys -> " + Arrays.toString(hashTable.keysWithHashes()));
    }

    public class Item {

        private String key;
        private Integer value;

        public Item(String key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }

    }

}
