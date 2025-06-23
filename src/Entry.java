public class Entry<Key, Value> {

    private final Key key;
    private Value value;
    private Entry<Key, Value> next;

    public Entry(Key key, Value value, Entry<Key, Value> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Key getKey() {
        return key;
    }

    public Value getValue() {
        return value;
    }

}
