package edu.concepts;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MyHashMap<K, V> {

    class HMNode<K, V> {

        K key;
        V val;

        public HMNode(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    private int size;
    private LinkedList<HMNode<K, V>>[] buckets;

    public MyHashMap() {
        initHash(4);
        size = 0;
    }

    private void initHash(int n) {
        buckets = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public void put(K key, V val) {
        int bi = getHash(key);
        int di = getNodeWithinBucket(key, bi);
        if (di == -1) {
            buckets[bi].add(new HMNode<>(key, val));
            size++;
        } else {
            buckets[bi].get(di).val = val;
        }

        double lambda = (size * 1.0) / buckets.length;
        if (lambda > 2.0) {
            rehash();
        }
    }

    public V get(K key) {
        int bi = getHash(key);
        int di = getNodeWithinBucket(key, bi);

        if (di == -1) {
            return null;
        }

        return buckets[bi].get(di).val;
    }

    public V remove(K key) {
        int bi = getHash(key);
        int di = getNodeWithinBucket(key, bi);

        if (di == -1) {
            return null;
        }
        V val = buckets[bi].get(di).val;
        size--;
        return val;
    }

    public boolean containsKey(K key) {
        int bi = getHash(key);
        int di = getNodeWithinBucket(key, bi);

        if (di == -1) {
            return false;
        }

        return true;
    }

    public Set<K> keySet() {
        Set<K> keySet = new HashSet<>();
        for (int i = 0; i < buckets.length; i++) {
            for (HMNode<K, V> node : buckets[i]) {
                keySet.add(node.key);
            }
        }
        return keySet;
    }

    public int size() {
        return size;
    }

    private void rehash() {
        LinkedList<HMNode<K, V>>[] oldBucket = buckets;
        initHash(buckets.length * 2);
        for (int i = 0; i < oldBucket.length; i++) {
            for (HMNode<K, V> node : oldBucket[i]) {
                put(node.key, node.val);
            }
        }
    }

    private int getNodeWithinBucket(K key, int bi) {
        int index = 0;
        for (HMNode node : buckets[bi]) {
            if (node.key == key) {
                return index;
            }
            index++;
        }

        return -1;
    }

    private int getHash(K key) {
        int hash = key.hashCode();
        return Math.abs(hash) % buckets.length;
    }
}
