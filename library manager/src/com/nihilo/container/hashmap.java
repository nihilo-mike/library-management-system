package com.nihilo.container;
/* written by zeyede mikyas
 * on 5/12/2020*/


public class hashmap<K, V> {
    // initialized capacity with 64
    private int capacity = 64;


    //Array of List object
    private final List<K, V>[] table;

    public hashmap() {
        table = new List[capacity];
    }

    public hashmap(int capacity) {
        this.capacity = capacity;
        table = new List[capacity];
    }

    private int index(K key) {
        if (key == null) {
            return 0;
        }
        return Math.abs(key.hashCode() % capacity);
    }



    public void put(K key, V value) {
        int index = index(key);
        List newList = new List(key, value, null);
        if (table[index] == null) {
            table[index] = newList;
        } else {
            List<K, V> previousNode = null;
            List<K, V> currentNode = table[index];
            while (currentNode != null) {
                if (currentNode.getKey().equals(key)) {
                    currentNode.setValue(value);
                    break;
                }
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }
            if (previousNode != null)
                previousNode.setNext(newList);
        }
    }

    public V get(K key) {
        V value = null;
        int index = index(key);
        List<K, V> list = table[index];
        while (list != null) {
            if (list.getKey().equals(key)) {
                value = list.getValue();
                break;
            }
            list = list.getNext();
        }
        return value;
    }

    public void remove(K key) {
        int index = index(key);
        List previous = null;
        List list = table[index];
        while (list != null) {
            if (list.getKey().equals(key)) {
                if (previous == null) {
                    list = list.getNext();
                    table[index] = list;
                    return;
                } else {
                    previous.setNext(list.getNext());
                    return;
                }
            }
            previous = list;
            list = list.getNext();
        }
    }
//in java.util hashmap method to print you have to put them in a set here we cant use
//predefined containers so i have chosen to iterate over the bucket instead if the bucket is not null
    public void print() {
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                List<K, V> currentNode = table[i];
                while (currentNode != null) {
                    System.out.println(currentNode.getValue());
                    currentNode = currentNode.getNext();
                }
            }
        }
    }


}