public class CustomMap<K, V> {

    // Define the maximum size of the List (can be adjusted based on needs)
    private final int MAX_SIZE = 1000;

    // Keep track of the current number of elements in the map
    private int SIZE = 0;

    // Inner class representing a node in the linked list used for storing key-value pairs
    class CustomNode<K, V> {
        private int hash;
        private K key;
        private V value;
        CustomNode<K, V> next;

        public CustomNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.hash = key.hashCode() % MAX_SIZE;  // Calculate hash for this node
            this.next = null;
            SIZE++;     // Increment size counter when a new node is created
        }
    }

    /* Array of CustomNode objects to store key-value pairs. This array acts as a hash table where the index is calculated using the hash code of the key.
    Collisions are handled by creating linked lists at the corresponding index.*/
    private CustomNode<K, V>[] nodeContainer;

    public CustomMap() {
        // Initialize the nodeContainer array with the specified size
        nodeContainer = new CustomNode[MAX_SIZE];
    }

    public void put(K key, V value) {
        // Calculate the hash code for the key
        int itemHashCode = key.hashCode() % MAX_SIZE;

        // Get the head node at the corresponding index in the nodeContainer
        CustomNode<K, V> head = nodeContainer[itemHashCode];

        // If the list at this index is empty, add the new node directly
        if (head == null) {
            CustomNode<K, V> newCustomNode = new CustomNode<>(key, value);
            nodeContainer[newCustomNode.hash] = newCustomNode;
            return;
        }

        // Check if the first node has the same key and update value if so
        if (head.next == null && head.key.equals(key)) {
            head.value = value;
            return;
        }

        // Iterate through the linked list at this index
        while (head.next != null) {
            // Check for existing key and update value if found
            if (head.key.hashCode() == key.hashCode()) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // If no existing key found, add the new node at the end of the list
        head.next = new CustomNode<>(key, value);
    }

    public V get(K key) {
        // Calculate the hash code for the key
        int itemHashCode = key.hashCode() % MAX_SIZE;

        // Get the head node at the corresponding index
        CustomNode<K, V> head = nodeContainer[itemHashCode];

        // Traverse the linked list searching for the key
        while (head != null) {
            // Check if key matches and return value if found
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        // Key not found, return null
        return null;
    }

    public boolean contains(K key) {
        // Similar logic to get, checks for key existence and returns true/false
        int itemHashCode = key.hashCode() % MAX_SIZE;

        CustomNode<K, V> head = nodeContainer[itemHashCode];

        while (head != null) {
            if (head.key.equals(key)) {
                return true;
            }
            head = head.next;
        }

        return false;
    }

    public int size() {
        // Return the current number of elements
        return SIZE;
    }
}


