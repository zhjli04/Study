  * [1.TreeMap/HashMap/Hashtable/LinkedHashMap区别]()
  * [2.TreeSet/HashSet/LinkedHashSet区别]()
  * [3. HashMap 如何解决冲突，扩容机制 resize()]()
  * [4.ConcurrentHashMap 如何做到高并发]()
  * [5.线程池 java.util.concurrent.ThreadPoolExecutor]()
  * [6.Thread/Runnable/Callable之间的区别]()
      
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
- table长度为capacity，元素加入到table的位置为 (table.length -1)&hash
- 解决冲突用链表，链表长度大于TREEIFY_THRESHOLD则转为红黑树TreeNode
- 扩容机制： threshold=capacity * loadFactor， 当元素数量超过threshold时扩容，新的capacity变成原来的两倍, 
单个元素放在 newTab[e.hash & (newCap - 1)]
链表中 hash & oldCap == 0的放在原来的位置j，不为0的放在 newTab[j + oldCap], 也可以理解为旧位置用的是 j=hash&(oldCap-1)，扩容时
用 hash&oldCap==0判断
## 4.ConcurrentHashMap 如何做到高并发
- put  
  当前位置没有元素的时候，调研Unsafe.compareAndSwapObject，将Node放到当前位置
  当前位置有元素时，锁住当前元素，将Node插入链表尾部，链表长度超过TREEIFY_THRESHOLD则转为红黑树TreeNode
- get  
  无锁，通过volatile机制实现修改即可见 volatile Node<K,V>[] table
## 5.线程池 java.util.concurrent.ThreadPoolExecutor
-   ThreadPoolExecutor(int corePoolSize,  
                              int maximumPoolSize,  
                              long keepAliveTime,  
                              TimeUnit unit,  
                              BlockingQueue<Runnable> workQueue,  
                              ThreadFactory threadFactory,  
                              RejectedExecutionHandler handler)  
   corePoolSize: the number of threads to keep in the pool 核心线程数  
   maximumPoolSize: the maximum number of threads to allow in the pool 最大可运行线程数  
   keepAliveTime: when the number of threads is greater than the core, this is the maximum time that excess idle threads will wait for new tasks before terminating.  当前线程执行完这个任务后等待下一个任务到来的最长时间  
  unit: the time unit for the {@code keepAliveTime} argument  时间单位  
  workQueue: the queue to use for holding tasks before they are executed.  阻塞队列，用于存放等待执行的任务  
  threadFactory: the factory to use when the executor creates a new thread  为runnable任务创建线程的工厂  
  handler: the handler to use when execution is blocked because the thread bounds and queue capacities are reached 用户传入的任务无法被接收时调用此方法  
 - 执行流程
      1. 当前运行线程数量小于核心线程数，直接创建新线程执行该任务
      2. 当前运行线程数量大于核心线程数，将该任务添加到阻塞队列，等待核心线程执行完上一个任务再来获取
      3. 如果添加到阻塞队列失败（已满），尝试创建一个非核心线程执行该任务，前提是核心线程的数量少于等于最大线程数，如果队列用的LinkedBlockingQueue,永远不会满，非核心线程不会被创建  
 - allowCoreThreadTimeOut默认为false,核心线程不会退出，设置为true，则核心线程也会退出  
 - RejectedExecutionHandler 拒绝策略  
  如果线程池中的数量大于corePoolSize，缓冲队列workQueue满，并且线程池中的数量等于maximumPoolSize，那么通过 handler所指定的策略来处理此任务。也就是：处理任务的优先级为：核心线程corePoolSize、任务队列workQueue、最大线程maximumPoolSize，如果三者都满了，使用handler处理被拒绝的任务。  
      1. AbortPolicy 放弃任务，抛出java.util.concurrent.RejectedExecutionException异常  
      2. CallerRunsPolicy 直接在 execute 方法的调用线程中运行被拒绝的任务；如果执行程序已关闭，则会丢弃该任务。
      3. DiscardPolicy 默默丢弃被拒绝的任务。  
      4. DiscardOldestPolicy 丢一个队列中最老的任务，把新任务加进去 
  - 用法  
  BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(10);  
  ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 6, 1, TimeUnit.SECONDS, queue);   
  executor.execute(Runnable)   
## 6.Thread/Runnable/Callable之间的区别
  - Thread     
  1. 是一个类      
  2. 只能被继承      
  3. 实现方式      
    class ThreadTest extends Thread{      
      private int ticket = 100;      
      public void run(){      
        while(true){      
          if(ticket > 0){   ticket-   }else{ break;     
    }}}    
    new ThreadTest().start();    
 - Runnable      
 1、是一个接口, thread实现了runnable接口     
 2、资源可以共享    
 3. 实现方式    
       class ThreadTest implements Runnable{      
       private int ticket = 100;      
       public void run(){      
         while(true){      
           if(ticket > 0){   ticket-   }else{ break;     
     }}}    
     ThreadTest t = new ThreadTest();    
     new Thread(t).start();     
  - Callable    
  1、是一个接口    
  2、Callable 使用 call（） 方法， Runnable 使用 run() 方法     
  3、call() 可以返回值， 而 run()方法不能返回    
  4、call() 可以抛出受检查的异常，比如ClassNotFoundException， 而run()不能抛出受检查的异常    
  5. 实现方式    
      //1、线程池实现    
    ThreadPoolExecutor aa =   (ThreadPoolExecutor)Executors.newFixedThreadPool (100);    
    Future<Integer> task1 = aa.submit(new Callable<Integer>() {    
                @Override    
                public Integer call() throws Exception {    
                    return 11;    
                }    
            });    
    //2、直接start    
    FutureTask<String> task = new FutureTask(new Callable(){    
                public String call(){    
                    return "";    
                }    
            });    
    Thread thread = new Thread(task);    
    thread.start();    
