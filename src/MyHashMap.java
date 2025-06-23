public class MyHashMap<K, V> {

    private static final int DEFAULT_CAPACITY = 16;
    private Entry<K, V>[] buckets;
    private int size = 0;

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }
    public MyHashMap(int capacity) {
        this.buckets = new Entry[capacity];
    }
    private int getBucketIndex(K key) {
        return key == null ? 0 : Math.abs(key.hashCode() % buckets.length);
    }
    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        Entry<K, V> entry = buckets[bucketIndex];
    }

}
