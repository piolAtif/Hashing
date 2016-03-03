class MyHashMap<K, V> {
    private static final int SIZE = 4;
    private Entry<K, V>[] table;

    public MyHashMap(){
        table = new Entry[SIZE];
    };

    public MyHashMap(int capacity){
        table = new Entry[capacity];
    };

    private void isKeyNull(K key){
        if(key == null)
            throw new IllegalArgumentException("key may not be null");
    };

    public int bucketIndexForKey(K key){
        return key.hashCode()%table.length;
    };

    public void put(K key, V value) {
        isKeyNull(key);
        int bucketIndex = bucketIndexForKey(key);
        Entry<K, V> entry  = table[bucketIndex];

        if(entry != null){
            boolean done = false;
            while(!done){
                if(key.equals(entry.getKey())){
                    entry.setValue(value);
                    done = true;
                }
                else if(entry.getNext() == null){
                    entry.setNext(new Entry<K, V>(key, value));
                    done = true;
                }
                entry = entry.getNext();
            }
        }else{
            table[bucketIndex] = new Entry<K, V>(key, value);
        }
    }

    public V get(K key) {
        isKeyNull(key);
        Entry<K, V> entry = table[bucketIndexForKey(key)];

        while (entry != null && !key.equals(entry.getKey()))
            entry = entry.getNext();
        return entry != null ? entry.getValue() : null;
    }

    private String literal(Entry<K, V> collection){
        Entry<K, V> entity = collection;
        return entity.key+"="+entity.value;
    }

    private String seperatedEntity(Entry<K, V> entity, Entry<K, V> []table){
        return entity != table[table.length-2] ? ", ":"";
    }

    public String toString(){
        String s = "[";
        for (Entry<K, V> entity : table){
            if(entity != null){
                s += literal(entity);
                s += seperatedEntity(entity, table);
            }
        }
        return s+"]";
    }

    private boolean removeEntity(K key){
        isKeyNull(key);
        int hash = bucketIndexForKey(key);
        Entry<K, V> previous = null;
        Entry<K, V> current = table[hash];
        while(current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    table[hash] = table[hash].next;
                    return true;
                } else {
                    previous.next = current.next;
                    return true;
                }
            }
            previous = current;
            current = current.next;
        }
        return false;
    }


    public void remove(K key){
        removeEntity(key);
    }

    public boolean containsKey(K key) {
        Entry<K, V> element = table[bucketIndexForKey(key)];
        while(element != null){
            if(element.key.equals(key))
                return true;
            element = element.next;
        }
        return false;
    }

    public boolean containsValue(V value) {
        Entry<K, V>[] entry = table;
        for (int i = 0; i < entry.length; i++)
            for (Entry e = entry[i]; e != null; e = e.next)
                if (value.equals(e.value))
                    return true;
        return false;
    }

    public void clear() {
        table = null;
    }

    public boolean isEmpty() {
        return table == null;
    }

    public int size() {
        int count = 0;
        for (int i = 0; i < table.length; i++)
            for (Entry e = table[i]; e != null; e = e.next)
                count++;

        return count;
    }
}
