package exercise4;
import java.util.*;

/**
 * Exercise 3. Implement a HashMap from scratch. In order to pass all the tests
 * you need to implement all the methods defined below. The key-value pair will
 * be encapsulated in the MyHashMap.MyEntry object defined below.
 *
 * The buckets list in which each MyEntry object will be stored is stored in "buckets" object.
 * The hash function that you will use in order to store a pair in a specific bucket will be
 * the one presented earlier: (hashcode value) modulo (bucket array size)
 */
public class MyHashMap {

    private ArrayList<LinkedList<MyEntry>> buckets;

    private final int BUCKET_ARRAY_SIZE = 16;

    public MyHashMap() {

        // TODO Initialize buckets list
        buckets = new ArrayList<LinkedList<MyEntry>>(BUCKET_ARRAY_SIZE);
        for (int i = 0; i < BUCKET_ARRAY_SIZE; i++)
            buckets.add(new LinkedList<MyEntry>());
    }

    public String get(String key) {
        // TODO
        for (LinkedList<MyEntry> bucket : buckets) {
            if(bucket != null) {
                for (MyEntry myEntry : bucket)
                    if (myEntry != null && myEntry.getKey().equals(key))
                        return myEntry.getValue();
            }
        }
        return null;
    }

    public void put(String key, String value) {
        // TODO
        if (key != null) {
            int hash = Math.abs(key.hashCode());
            for (MyEntry myEntry : buckets.get(hash % BUCKET_ARRAY_SIZE)) {
                if (myEntry != null && myEntry.getKey().equals(key)) {
                    myEntry.setValue(value);
                    return;
                }
            }
            buckets.get(hash % BUCKET_ARRAY_SIZE).add(new MyEntry(key, value));
        } else {
            for (MyEntry myEntry : buckets.get(0)) {
                if (myEntry.getKey() == null)
                    myEntry.setValue(value);
            }
            buckets.get(0).add(new MyEntry(key, value));
        }
    }

    public Set<String> keySet() {
        // TODO
        Set<String> stringSet = new HashSet<String>();
        for (LinkedList<MyEntry> bucket : buckets) {
            for (MyEntry myEntry : bucket) {
                stringSet.add(myEntry.getKey());
            }
        }
        return stringSet;
    }

    public Collection<String> values() {
        // TODO
        Collection<String> stringCollection = new ArrayList<String>();
        for (LinkedList<MyEntry> bucket : buckets) {
            for (MyEntry myEntry : bucket) {
                stringCollection.add(myEntry.getValue());
            }
        }
        return stringCollection;
    }

    public String remove(String key) {
        // TODO Returns the value associated with the key removed from the map or null if the key wasn't found
        String val = null;

        if(key != null) {
            int hash = Math.abs(key.hashCode());
            Iterator<MyEntry> it = buckets.get(hash % BUCKET_ARRAY_SIZE).iterator();

            while (it.hasNext()) {
                MyEntry entry = it.next();
                if (entry.getKey().equals(key)) {
                    val = entry.getValue();
                    it.remove();
                }
            }
        } else {
            Iterator<MyEntry> it = buckets.get(0).iterator();

            while (it.hasNext()) {
                MyEntry entry = it.next();
                if(entry.getKey() == null)
                    it.remove();
            }
        }

        return val;
    }

    public boolean containsKey(String key) {
        // TODO
        int hash = Math.abs(key.hashCode());
        for (MyEntry myEntry : buckets.get(hash % BUCKET_ARRAY_SIZE)) {
            if(myEntry.getKey().equals(key))
                return true;
        }
        return false;
    }

    public boolean containsValue(String value) {
        // TODO
        for (LinkedList<MyEntry> bucket : buckets) {
            for (MyEntry myEntry : bucket) {
                if (myEntry.getValue().equals(value))
                    return true;
            }
        }
        return false;
    }

    public int size() {
        // TODO Return the number of the Entry objects stored in all the buckets
        int total = 0;
        for (LinkedList<MyEntry> bucket : buckets)
            total += bucket.size();

        return total;
    }

    public void clear() {
        // TODO Remove all the Entry objects from the bucket list
        for (LinkedList<MyEntry> bucket : buckets) {
            bucket.clear();
        }
    }

    public Set<MyEntry> entrySet() {
        // TODO Return a Set containing all the Entry objects
        Set<MyEntry> stringSet = new HashSet<MyEntry>();
        for (LinkedList<MyEntry> bucket : buckets) {
            for (MyEntry myEntry : bucket) {
                stringSet.add(myEntry);
            }
        }
        return stringSet;
    }

    public boolean isEmpty() {
        // TODO
        return (size() == 0);
    }

    public static class MyEntry {
        private String key;
        private String value;

        public MyEntry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
