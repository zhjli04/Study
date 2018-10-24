class Node{
    int key;
    int value;
    Node pre;
    Node next;
    
    public Node(int key, int value){
        this.key = key;
        this.value = value;
        pre = null;
        next = null;
    }
}

public class LRUCache {
    int size = 0;
    int capacity = 0;
    
    Node head = null;
    Node tail = null;
    
    /*
    * @param capacity: An integer
    */public LRUCache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        Node node = getNode(key);
        if (node != null){
            moveFront(node);
            return node.value;
        }
        return -1;
    }
    
    public Node getNode(int key){
        if (size == 0){
            return null;
        }
        
        Node cur = head.next;
        while (cur != tail){
            if (key == cur.key){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    
    public void moveFront(Node node){
        if (node.pre != head){
            Node next = node.next;
            Node pre = node.pre;
            
            pre.next = next;
            next.pre = pre;
            
            Node p = head.next;
            p.pre = node;
            node.next = p;
            
            head.next = node;
            node.pre = head;
        }
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if (capacity <= 0){
            return;
        }
        
        if (size == 0){
            add(new Node(key, value));
            size++;
            return;
        }
        
        Node node = getNode(key);
        if (node == null){
            node = new Node(key, value);
            add(node);
           /* Node n = head.next;
            head.next = node;
            
            node.pre = head;
            node.next = n;
            n.pre = node;*/
                
            if (size < capacity){
              //  add(node);
                size++;
            }else{
                Node pre = tail.pre;
                Node p = pre.pre;
                p.next = tail;
                tail.pre = p;
            }
        }else{
            node.value = value;
            moveFront(node);
        }
    }
    
    public void add(Node node){
        Node n = head.next;
        n.pre = node;
        node.next = n;
        head.next = node;
        node.pre = head;
    }
}
