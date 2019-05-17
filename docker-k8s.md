
## docker
像这样一个程序运起来后的计算机执行环境的总和，就是：进程。对于进程来说，它的静态表现就是程序，平常都安安静静地待在磁盘上；而一旦运行起来，它就变成了计算机里的数据和状态的总和，这就是它的动态表现。    
容器，其实是一种特殊的进程而已。    
容器技术的核心功能，就是通过约束和修改进程的动态表现，从而为其创造出一个“边界”。    
对于 Docker 等大多数 Linux 容器来说，Cgroups 技术是用来制造约束的主要手段，而Namespace 技术则是用来修改进程视图的主要方法。    
- Namespace    
其实只是 Linux 创建新进程的一个可选参数。 在 Linux 系统中创建线程的系统调用是 clone()，比如：    

        int pid = clone(main_function, stack_size, SIGCHLD, NULL); 

而当我们用 clone() 系统调用创建一个新进程时，就可以在参数中指定 CLONE_NEWPID 参数，比如：    
 
         int pid = clone(main_function, stack_size, CLONE_NEWPID | SIGCHLD, NULL); 

这时，新创建的这个进程将会“看到”一个全新的进程空间，在这个进程空间里，它的 PID 是 1。之所以说“看到”，是因为这只是一个“障眼法”，在宿主机真实的进程空间里，这个进程的 PID 还是真实的数值，比如 100。    
除了我们刚刚用到的 PID Namespace，Linux 操作系统还提供了 Mount、UTS、IPC、Network 和 User 这些 Namespace，用来对各种不同的进程上下文进行“障眼法”操作。比如，Mount Namespace，用于让被隔离进程只看到当前 Namespace里的挂载点信息；Network Namespace，用于让被隔离进程看到当前 Namespace里的网络设备和配置。    
这，就是 Linux 容器最基本的实现原理了。
