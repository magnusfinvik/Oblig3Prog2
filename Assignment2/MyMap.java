import java.util.LinkedList;

public interface MyMap<K, V> {

    public void clear();

    public boolean containsKey(K key);

    public boolean containsValue(V value);

    public java.util.Set<Entry<K, V>> entrySet();

    public V get(K key);

    public boolean isEmpty();

    public java.util.Set<K> keySet();

    public V put(K key, V value);

    public void remove(K key);

    public int size();

    public java.util.Set<V> values();

    public static class Entry<K, V> {
        K key;
        LinkedList<V> valueList;

        public Entry(K key, V value) {
            this.key = key;
            valueList  = new LinkedList<>();
            valueList.add(value);
        }

        public K getKey() {
            return key;
        }

        public LinkedList<V> getValues() {
            return valueList;
        }

        @Override
        public String toString() {
            return "[" + key + ", " + valueList + "]";
        }

        public LinkedList<V> getValue() {
            return valueList;
        }
    }
}    