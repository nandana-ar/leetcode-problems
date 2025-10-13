//------------------------------PROBLEM 146-------------------------------//
//                               LRU CACHE                                //


// Logic:
// -> Use a HashMap to store key-node pairs for O(1) access
// -> Use a doubly linked list to maintain the order of usage
// -> Constructor 
//    - Initialise capacity, HashMap, and dummy head and tail nodes
//    - Link the head and tail nodes
// -> get(key)
//    - If the key is not in the map, return -1
//    - If the key is in the map, retrieve the node
//    - Remove the node from its current position
//    - Add the node to the front (most recently used position)
//    - Return the node's value
// -> put(key, value)
//    - If the key is already in the map, update the node's value
//    - Remove the node from its current position
//    - Add the node to the front
//    - If the key is not in the map, check if the cache is at capacity
//    - If at capacity, remove the least recently used node (node before tail)
//    - Remove the LRU node from the map
//    - Create a new node and add it to the front
//    - Add the new node to the map
// -> Helper methods:
//    - removeNode(node)
//       - Adjust the pointers of the node's previous and next nodes to bypass it
//    - addToFront(node)
//       - Insert the node right after the head node
//       - Adjust the pointers accordingly
// -> Node class
//    - Represents each entry in the cache
//    - Contains key, value, and pointers to previous and next nodes


import java.util.*; 

class LRUCache {

    private HashMap<Integer, Node> map;
    private int capacity; 
    private Node head;
    private Node tail; 

    public LRUCache(int capacity) {
        this.capacity = capacity; 
        map = new HashMap<>();
        head = new Node(0, 0); 
        tail = new Node(0, 0); 
        head.next = tail; 
        tail.prev = head; 
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key); 
        removeNode(node); 
        addToFront(node);

        return node.value; 
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key); 
            node.value = value; 
            removeNode(node); 
            addToFront(node);
        }  else { 
            if (map.size() == capacity) {
                Node lru = tail.prev; 
                removeNode(lru); 
                map.remove(lru.key); 
            }
            Node newNode = new Node(key, value); 
            addToFront(newNode);
            map.put(key, newNode); 

        }
        
    }

    private void removeNode(Node node){ 
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToFront(Node node) {
        node.next = head.next; 
        node.prev = head; 
        head.next.prev = node; 
        head.next = node; 
    }

    private class Node { 
        int key, value; 
        Node prev, next; 

        Node(int key, int value) {
            this.key = key; 
            this.value = value; 
        }
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


// Time Complexity:
// -> Accessing the HashMap: O(1)
// -> Adding/removing nodes in the doubly linked list: O(1)
// Overall, O(1) + O(1) => O(1)
