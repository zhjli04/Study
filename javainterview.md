## 1.TreeMap/HashMap/Hashtable/LinkedHashMap区别
- TreeMap extends AbstractMap<K,V> implements NavigableMap<K,V> (SortedMap) 以key值有序
- HashMap extends AbstractMap<K,V> implements Map 无序
- Hashtable, extends Dictionary<K, V> implements Map 无序，同步
- LinkedHashMap extends HashMap<K,V> implements Map<K,V>, 以插入顺序排序
## 2.TreeSet/HashSet/LinkedHashSet区别
- TreeSet基于TreeMap实现，元素有序
- HashSet基于HashMap实现，元素无序
- LinkedHashSet继承HashSet，底层使用 LinkedHashMap, 元素以插入顺序排序
## 3. HashMap 如何解决冲突，扩容机制 resize()
- 解决冲突用链表，链表长度大于TREEIFY_THRESHOLD则转为红黑树TreeNode
- 扩容机制： threshold=capacity * loadFactor， 当元素数量超过threshold时扩容，新的capacity变成原来的两倍, 
单个元素放在 newTab[e.hash & (newCap - 1)]
链表中 hash & oldCap == 0的放在原来的位置j，不为0的放在 newTab[j + oldCap]
## 4.ConcurrentHashMap 如何做到高并发
- put  
  当前位置没有元素的时候，调研Unsafe.compareAndSwapObject，将Node放到当前位置
  当前位置有元素时，锁住当前元素，将Node插入链表尾部，链表长度超过TREEIFY_THRESHOLD则转为红黑树TreeNode
- get  
  无锁，通过volatile机制实现修改即可见 volatile Node<K,V>[] table

