public class Entry<K, V> {

    private final K key;
    private V value;
    private Entry<K, V> next; // проверяю, есть ли следующий элемент

    public Entry(K key, V value, Entry<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

}
