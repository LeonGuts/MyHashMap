class MyHashMap<K, V> {

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Entry<K, V>[] bucketsTable;
    private int eQuantity = 0; // кол-во элементов
    private static final int DEFAULT_CAPACITY = 16;

    private int bucketNum(K key) { // Вычисляем хеш-код ключа(номер бакета)
        int hash = key == null ? 0 : key.hashCode();
        int index = Math.abs(hash % bucketsTable.length);
        return index;
    }


    public void put (K key, V value) {
        Entry<K, V> entry = bucketsTable[bucketNum(key)];
        while (entry != null) {
            if (entry.key.equals(key)) { // проверка на совпадение ключа
                entry.value = value; // обновление ключа
                return;
            }
            entry = entry.next;
        }

        // Нет ключа -> добавляем в начало цепочки
        Entry<K, V> newEntity = new Entry<>(key, value, bucketsTable[bucketNum(key)]);
        bucketsTable[bucketNum(key)] = newEntity;
        eQuantity++;

    }

    public V get (K key) {
        Entry<K, V> entry = bucketsTable[bucketNum(key)];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    public V remove (K key) {
        Entry<K, V> prev = null;
        Entry<K, V> entry = bucketsTable[bucketNum(key)];
        while (entry != null) {
            if (entry.key.equals(key)) {
                if (prev == null) {
                    bucketsTable[bucketNum(key)] = entry.next; // удаление предыдущего элемента
                } else {
                    prev.next = entry.next; // убираем entry из цепочки
                }
                eQuantity--;
                return entry.value;
            }
            prev = entry;
            entry = entry.next;
        }
        return null;
    }

}
