/**
 * @author Vlad Burca, Pauline Lake
 * @version 04-14-2011
 */

/**
 * File: HashTableDictionary.java
 * 
 * A hash table with linear probing using the division method for the hash 
 * function.
 *
 * @author Takunari Miyazaki
 * @see Dictionary
 * @see Entry
 * @see FullHashTableException
 * @see InvalidEntryException
 * @see InvalidKeyException
 * @see Iterable
 */

public class HashTableDictionary<K,V> implements Dictionary<K,V> {

  /** Nested class for hash table entries */
  public static class HashEntry<K,V> implements Entry<K,V> {
    protected K key;
    protected V value;
    public HashEntry(K k, V v) { key = k; value = v; }
    public V getValue() { return value; }
    public K getKey() { return key; }
    public V setValue(V v) {
      V oldValue = value;
      value = v;
      return oldValue;
    }
    public boolean equals(Entry<K,V> e) {
      HashEntry<K,V> he;
      try { he = (HashEntry<K,V>) e; }
      catch (ClassCastException ex) { return false; }
      return (he.getKey() == key) && (he.getValue() == value);
    }
  }

  /** Marker for deactivated buckets */
  protected Entry<K,V> AVAILABLE = new HashEntry<K,V>(null, null);
  /** Number of entries in the dictionary */
  protected int n = 0;
  /** Capacity of the bucket array */
  protected int capacity;
  /** Bucket array */
  protected Entry<K,V>[] H;

  /** Creates a hash table with capacity 1023 */
  public HashTableDictionary() {
    this(1023);
  }
  
  /** Creates a hash table with a given capacity cap */
  public HashTableDictionary(int cap) {
    capacity = cap;
    H = (Entry<K,V>[]) new Entry[capacity];
  }
  
  // Auxiliary methods
  protected boolean available(int i) { return (H[i] == AVAILABLE); }
  protected boolean empty(int i) { return (H[i] == null); }
  protected K key(int i) { return H[i].getKey(); } 
  protected V value(int i) { return H[i].getValue(); }
  protected void checkKey(K k) throws InvalidKeyException {
    if (k == null) throw new InvalidKeyException("Invalid key: null.");
  }
  public int hashValue(K k) {
    return Math.abs(k.hashCode()) % capacity; // compression map
  }

  /** Returns the number of entries in the dictionary. */
  public int size() {
    return n;
  }

  /** Tests whether the dictionary is empty. */
  public boolean isEmpty() {
    return (size() == 0);
  }

  /** Helper search method */
  private int findEntry(K k) throws InvalidKeyException {
    checkKey(k);
    int i = hashValue(k);
    int j = i;
    do {
      if (empty(i)) return -1;  // item is not found
      if (available(i)) i = (i + 1) % capacity;  // bucket is deactivated
      else if (k.equals(key(i)))  // we have found our entry
        return i;
      else  // we must keep looking
        i = (i + 1) % capacity;
    } while (i != j);
    return -1;  // entry is not found
  }

  /** Returns an entry whose key is equal to a given key k. */
  public Entry<K,V> get(K k) throws InvalidKeyException {
    int i = findEntry(k);  // helper method for finding a key
    if (i < 0) return null;
    return H[i];
  }

  /** Puts an entry with a given key k and value x into the hash table, 
   *  returning the entry created. */
  public Entry<K,V> put(K k, V x) 
      throws InvalidKeyException, FullHashTableException {
    checkKey(k);
    int i = hashValue(k);  // division method compression map
    int j = i;  // remember where we are starting
    do {
      if (empty(i) || available(i)) {  // this slot is available
        H[i] = new HashEntry(k, x);
        n++;
        return H[i];
      }
      i = (i + 1) % capacity;  // check next slot
    } while (i != j);  // repeat until we return to start
    throw new FullHashTableException("Hash table is full.");
  }

  /** Removes from the hash table a given entry e, returning the removed 
   *  entry. */
  public Entry<K,V> remove(Entry<K,V> e) throws InvalidEntryException {
    int i = findEntry(e.getKey());  // find this key first
    int j = i;
    if (i < 0)
      throw new InvalidEntryException("There is no such entry.");
    do {
      if (H[i].equals(e)) {
        Entry<K,V> toReturn = H[i];
        H[i] = AVAILABLE; // mark this slot as deactivated
        n--;
        return toReturn;/**
 * File: Entry.java
 *
 * An interface for a key-value pair entry.
 *
 * @author Takunari Miyazaki
 * @see Entry
 * @see InvalidEntryException
 * @see InvalidKeyException
 * @see Iterable
 */
      }
      i = (i + 1) % capacity;
    } while ((!empty(i)) && (i != j));
    throw new InvalidEntryException("There is no such entry.");
  }

  /**
   * Complete the method entrySet() that returns an iterable collection of 
   * all key-value entries in the hash table.
   * @return arrayList - Iterable of all the entries of the Dictionary.
   */
  public Iterable<Entry<K,V>> entrySet() {						// COMPLETED.
	
	ArrayIndexList<Entry<K,V>> arrayList = new ArrayIndexList<Entry<K,V>>();
	int hash_index = 0;
	int arrayList_index = 0;
	while (hash_index < capacity) {
		if (!empty(hash_index) && !available(hash_index)) {
			arrayList.add(arrayList_index, H[hash_index]);
			arrayList_index++;
		}
	    hash_index++;			
	}
	return arrayList;
  }

  /**
   * Complete the method getAll() that returns an iterable collection of 
   * all entries whose keys are equal to a given key k.
   * @param k - K
   * @return arrayList - Iterable of all the entries with key k of the Dictionary.
   */
  public Iterable<Entry<K,V>> getAll(K k) throws InvalidKeyException {  		//COMPLETED

	ArrayIndexList<Entry<K,V>> arrayList = new ArrayIndexList<Entry<K,V>>();
	int arrayList_index = 0;
	int hash_index1 = findEntry(k);
	int hash_index2 = hash_index1;
	if (hash_index1 >= 0) {
		arrayList.add(arrayList_index, H[hash_index1]);
		arrayList_index++;
		hash_index2 = (hash_index2 + 1) % capacity;
		while (hash_index2 != hash_index1) {
			if (!empty(hash_index2) && !available(hash_index2) && key(hash_index2) == k) {
				arrayList.add(arrayList_index, H[hash_index2]);
				arrayList_index++;
			}
			hash_index2 = (hash_index2 + 1) % capacity;
		}
	}			
	return arrayList;
  }

  /**
   * Complete the method removeAll() that removes all entries whose keys are
   * equal to a given key k and returns the removed entries in an iterable
   * collection.
   * @param k - K
   * @return arrayList - Iterable of all the removed entries with key k from the Dictionary.
   */
  public Iterable<Entry<K,V>> removeAll(K k) throws InvalidKeyException {
	
	ArrayIndexList<Entry<K,V>> arrayList = new ArrayIndexList<Entry<K,V>>();
	int arrayList_index = 0;
	int hash_index = findEntry(k);
	while (hash_index >= 0) {
		arrayList.add(arrayList_index, remove(H[hash_index]));
		arrayList_index++;
		hash_index = findEntry(k);
	}
	return arrayList;	
  }

}
