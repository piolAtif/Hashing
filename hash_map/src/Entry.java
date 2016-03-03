class Entry<K, V>{
    K key;
    V value;
    Entry next;

    Entry(K key, V value){
        this.key = key;
        this.value = value;
    }

    public V getValue(){
        return this.value;
    }

    public void setValue(V value){
        this.value = value;
    }

    public K getKey(){
        return key;
    }

    public Entry<K, V> getNext(){
        return next;
    }

    public void setNext(Entry<K, V> next){
        this.next = next;
    }
}