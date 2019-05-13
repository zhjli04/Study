* [TreeMap-HashMap-Hashtable-LinkedHashMap区别](#TreeMap-HashMap-Hashtable-LinkedHashMap区别)  
* [TreeSet-HashSet-LinkedHashSet区别](#TreeSet-HashSet-LinkedHashSet区别)  
* [HashMap如何解决冲突和扩容机制](#HashMap如何解决冲突和扩容机制)  
* [ConcurrentHashMap如何做到高并发](#ConcurrentHashMap如何做到高并发)  
* [线程池ThreadPoolExecutor](#线程池ThreadPoolExecutor)  
* [Thread-Runnable-Callable之间的区别](#Thread-Runnable-Callable之间的区别)  
* [CyclicBarrier-CountDownLatch-Semaphore](#CyclicBarrier-CountDownLatch-Semaphore)
* [JDK命令行工具](#JDK命令行工具)
* [ThreadLocal](#ThreadLocal)
* [GCRoots](#GCRoots)
* [引用](#引用)

## TreeMap-HashMap-Hashtable-LinkedHashMap区别
- TreeMap extends AbstractMap<K,V> implements NavigableMap<K,V> (SortedMap) 以key值有序
- HashMap extends AbstractMap<K,V> implements Map 无序
- Hashtable, extends Dictionary<K, V> implements Map 无序，同步
- LinkedHashMap extends HashMap<K,V> implements Map<K,V>, 以插入顺序排序
## TreeSet-HashSet-LinkedHashSet区别
- TreeSet基于TreeMap实现，元素有序
- HashSet基于HashMap实现，元素无序
- LinkedHashSet继承HashSet，底层使用 LinkedHashMap, 元素以插入顺序排序
## HashMap如何解决冲突和扩容机制
- table长度为capacity，元素加入到table的位置为 (table.length -1)&hash
- 解决冲突用链表，链表长度大于TREEIFY_THRESHOLD则转为红黑树TreeNode
- 扩容机制： threshold=capacity * loadFactor， 当元素数量超过threshold时扩容，新的capacity变成原来的两倍, 
单个元素放在 newTab[e.hash & (newCap - 1)]
链表中 hash & oldCap == 0的放在原来的位置j，不为0的放在 newTab[j + oldCap], 也可以理解为旧位置用的是 j=hash&(oldCap-1)，扩容时
用 hash&oldCap==0判断
## ConcurrentHashMap如何做到高并发
- put  
  当前位置没有元素的时候，调研Unsafe.compareAndSwapObject，将Node放到当前位置
  当前位置有元素时，锁住当前元素，将Node插入链表尾部，链表长度超过TREEIFY_THRESHOLD则转为红黑树TreeNode
- get  
  无锁，通过volatile机制实现修改即可见 volatile Node<K,V>[] table
## 线程池ThreadPoolExecutor
java.util.concurrent.ThreadPoolExecutor
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
### Thread-Runnable-Callable之间的区别
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
  
## CyclicBarrier-CountDownLatch-Semaphore
- CyclicBarrier    
  字面意思回环栅栏，通过它可以实现让一组线程等待至某个状态之后再全部同时执行。叫做回环是因为当所有等待线程都被释放以后，CyclicBarrier可以被重用。我们暂且把这个状态就叫做barrier，当调用await()方法之后，线程就处于barrier了。    
 CyclicBarrier类位于java.util.concurrent包下，CyclicBarrier提供2个构造器：      
  
        public CyclicBarrier(int parties, Runnable barrierAction) {}    
        public CyclicBarrier(int parties){}     
      
  参数parties指让多少个线程或者任务等待至barrier状态；参数barrierAction为当这些线程都达到barrier状态时会执行的内容。    
  然后CyclicBarrier中最重要的方法就是await方法，它有2个重载版本:    
  
      public int await() throws InterruptedException, BrokenBarrierException { };    
      public int await(long timeout, TimeUnit unit)throws InterruptedException,BrokenBarrierException,TimeoutException { };    
      
  第一个版本比较常用，用来挂起当前线程，直至所有线程都到达barrier状态再同时执行后续任务；第二个版本是让这些线程等待至一定的时间，如果还有线程没有到达barrier状态就直接让到达barrier的线程执行后续任务.    
  
          public class Test {    
              public static void main(String[] args) {    
                  int N = 4;    
                  CyclicBarrier barrier  = new CyclicBarrier(N);    
                  for(int i=0;i<N;i++)    
                      new Writer(barrier).start();    
              }    
            static class Writer extends Thread{    
                private CyclicBarrier cyclicBarrier;    
                public Writer(CyclicBarrier cyclicBarrier) {    
                    this.cyclicBarrier = cyclicBarrier;    
                }    
     
                @Override    
                public void run() {    
                    System.out.println("线程"+Thread.currentThread().getName()+"正在写入数据...");    
                    try {    
                        Thread.sleep(5000);      //以睡眠来模拟写入数据操作    
                        System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");    
                        cyclicBarrier.await();    
                    } catch (InterruptedException e) {    
                        e.printStackTrace();    
                    }catch(BrokenBarrierException e){    
                        e.printStackTrace();    
                    }    
                    System.out.println("所有线程写入完毕，继续处理其他任务...");
                }    
            }    
          }      
  
- CountDownLatch    
CountDownLatch类位于java.util.concurrent包下，利用它可以实现类似计数器的功能。比如有一个任务A，它要等待其他4个任务执行完毕之后才能执行，此时就可以利用CountDownLatch来实现这种功能了。    
CountDownLatch类只提供了一个构造器：    

    public CountDownLatch(int count) {  };  //参数count为计数值   
    
然后下面这3个方法是CountDownLatch类中最重要的方法：    

    public void await() throws InterruptedException { };   //调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行    
    public boolean await(long timeout, TimeUnit unit) throws InterruptedException { };  //和await()类似，只不过等待一定的时间后count值还没变为0的话就会继续执行    
    public void countDown() { };  //将count值减1    
    
        public class Test {    
         public static void main(String[] args) {    
             final CountDownLatch latch = new CountDownLatch(2);    
              
             new Thread(){    
                 public void run() {    
                     try {    
                         System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");    
                        Thread.sleep(3000);    
                        System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");    
                        latch.countDown();    
                    } catch (InterruptedException e) {    
                        e.printStackTrace();    
                    }    
                 };    
             }.start();    
              
             new Thread(){    
                 public void run() {    
                     try {    
                         System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");    
                         Thread.sleep(3000);    
                         System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");    
                         latch.countDown();    
                    } catch (InterruptedException e) {    
                        e.printStackTrace();    
                    }    
                 };    
             }.start();    
              
             try {    
                 System.out.println("等待2个子线程执行完毕...");    
                latch.await();    
                System.out.println("2个子线程已经执行完毕");    
                System.out.println("继续执行主线程");    
            } catch (InterruptedException e) {    
                e.printStackTrace();    
            }    
         }    
        }    
    
- Semaphore    
Semaphore翻译成字面意思为 信号量，Semaphore可以控同时访问的线程个数，通过 acquire() 获取一个许可，如果没有就等待，而 release() 释放一个许可。Semaphore类位于java.util.concurrent包下，它提供了2个构造器：    

     public Semaphore(int permits) {          //参数permits表示许可数目，即同时可以允许多少线程进行访问    
         sync = new NonfairSync(permits);    
     }
     public Semaphore(int permits, boolean fair) {    //这个多了一个参数fair表示是否是公平的，即等待时间越久的越先获取许可    
         sync = (fair)? new FairSync(permits) : new NonfairSync(permits);    
     }    
    
Semaphore类中比较重要的几个方法，首先是acquire()、release()方法：    

    public void acquire() throws InterruptedException {  }     //获取一个许可    
    public void acquire(int permits) throws InterruptedException { }    //获取permits个许可    
    public void release() { }          //释放一个许可    
    public void release(int permits) { }    //释放permits个许可    
    
acquire()用来获取一个许可，若无许可能够获得，则会一直等待，直到获得许可。release()用来释放许可。注意，在释放许可之前，必须先获获得许可。这4个方法都会被阻塞，如果想立即得到执行结果，可以使用下面几个方法：    

    public boolean tryAcquire() { };    //尝试获取一个许可，若获取成功，则立即返回true，若获取失败，则立即返回false    
    public boolean tryAcquire(long timeout, TimeUnit unit) throws InterruptedException { };  //尝试获取一个许可，若在指定的时间内获取成功，则立即返回true，否则则立即返回false    
    public boolean tryAcquire(int permits) { }; //尝试获取permits个许可，若获取成功，则立即返回true，若获取失败，则立即返回false    
    public boolean tryAcquire(int permits, long timeout, TimeUnit unit) throws InterruptedException { }; //尝试获取permits个许可，若在指定的时间内获取成功，则立即返回true，否则则立即返回false    
    
        public class Test {    
        public static void main(String[] args) {    
            int N = 8;            //工人数       
            Semaphore semaphore = new Semaphore(5); //机器数目       
            for(int i=0;i<N;i++)    
                new Worker(i,semaphore).start();    
        }    
         
        static class Worker extends Thread{    
            private int num;    
            private Semaphore semaphore;    
            public Worker(int num,Semaphore semaphore){    
                this.num = num;    
                this.semaphore = semaphore;    
            }    
             
            @Override    
            public void run() {    
                try {    
                    semaphore.acquire();    
                    System.out.println("工人"+this.num+"占用一个机器在生产..."");    
                    Thread.sleep(2000);    
                    System.out.println("工人"+this.num+"释放出机器");    
                    semaphore.release();    
                } catch (InterruptedException e) {    
                    e.printStackTrace();    
                }    
            }    
        }    
    }    
    
- 总结    
    CountDownLatch和CyclicBarrier都能够实现线程之间的等待，只不过它们侧重点不同：CountDownLatch一般用于某个线程A等待若干个其他线程执行完任务之后，它才执行；而CyclicBarrier一般用于一组线程互相等待至某个状态，然后这一组线程再同时执行；另外，CountDownLatch是不能够重用的，而CyclicBarrier是可以重用的。    
    Semaphore其实和锁有点类似，它一般用于控制对某组资源的访问权限。
    
## JDK命令行工具
- jps:虚拟机进程状况工具    
   jps -l    
- jstat：虚拟机统计信息监视工具    
jstat命令可用于显示本地或远程虚拟机进程中的类装载 ，内存，垃圾收集，JIT编译等运行数据。    
jstat [options  vmid  [interval[s|ms]]  [count] ]    
- jinfo:查看虚拟机配置参数信息    
jinfo  [option] pid    
- jmap:生成虚拟机内存转储快照    
jmap命令用于获取heapdump文件，且可以查询finalize执行队列，Java堆与永久代的一些信息。    
jmap  [option ]  vmid    
- jhat:分析虚拟机转储快照信息    
jhat命令与jmap命令搭配使用，用于分析jmap生成的堆转储快照，jhat内置了一个微型的HTTP/HTML服务器，生成dump文件的分析结果后，可以在浏览器中查看。    
jhat  heapdumpFileName    
- jstack:虚拟机堆栈跟踪    
jstack命令用于生成虚拟机当前时刻的线程快照。线程快照指的是当前虚拟机内的每一条线程正在执行的方法堆栈的集合，生成线程快照的作用是，可用于定位线程出现长时间停顿的原因，如线程间死锁，死循环，请求外部资源导致的长时间等待等问题，当线程出现停顿时 就可以用jstack各个线程调用的堆栈情况。     
jstack  [option] vmid    

## ThreadLocal    
- 它是一个数据结构，有点像HashMap，可以保存"key : value"键值对，但是一个ThreadLocal只能保存一个，并且各个线程的数据互不干扰。    

        ThreadLocal<String> localName = new ThreadLocal();    
        localName.set("xxx");
        String name = localName.get();    
        
- 在ThreadLoalMap中，也是初始化一个大小16的Entry数组，Entry对象用来保存每一个key-value键值对，只不过这里的key永远都是ThreadLocal对象.hreadLoalMap的Entry是继承WeakReference，和HashMap很大的区别是，Entry中没有next字段，所以就不存在链表的情况了。在插入过程中，根据ThreadLocal对象的hash值，定位到table中的位置i，过程如下：1、如果当前位置是空的，那么正好，就初始化一个Entry对象放在位置i上；2、不巧，位置i已经有Entry对象了，如果这个Entry对象的key正好是即将设置的key，那么重新设置Entry中的value；3、很不巧，位置i的Entry对象，和即将设置的key没关系，那么只能找下一个空位置；    
## GCRoots    
在Java语言中，可作为GC Roots的对象包括下面几种：    
- 虚拟机栈（栈帧中的本地变量表）中引用的对象。    
- 方法区中类静态属性引用的对象。    
- 方法区中常量引用的对象。    
- 本地方法栈中JNI（即一般说的Native方法）引用的对象    
## 引用    
- 强引用：在代码中普遍存在的，类似Object obj = new Object();。只要强引用还存在，垃圾回收期就永远不会回收被引用的对象    
- 软引用：用来描述一些还有用，但并非必须的对象。这样当系统要发生内存溢出异常之前，就会把软引用列进第二次垃圾回收的计划中。SoftReference    
- 弱引用：比软引用还弱的引用，被弱引用的对象只能存活到下一次垃圾回收之前。WeakReference    
- 虚引用：最弱的一种引用关系了。使用虚引用的唯一目的就是在这个对象回收前收到一个系统回收通知。PhantomReference    

