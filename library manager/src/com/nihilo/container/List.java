package com.nihilo.container;

public class List<K, V> {

    private K key;
    private V value;
    private List<K, V> next;

    public List(K key, V value, List<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public List getNext() {
        return next;
    }

    public void setNext(List<K, V> next) {
        this.next = next;
    }
}
