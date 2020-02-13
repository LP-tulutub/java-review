package com.java.review.multithreading;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultithreadingTest {
}

/**
 * 1.浅谈线程runnable和callable的使用及区别?Thread？
 *  runnable是无返回值的执行线程
 *  callable是有返回值的执行线程
 *  Callable使用call方法，Runnable使用run方法，call可以抛出受检查的异常，比如ClassNotFoundException，而run不能抛出受检查的异常
 *  Thread是一个类，只能被继承，子类就无法有其他父类
 **
 * 2.Thread、runnable、callable实现？
 */
class ThreadTest extends Thread{
    public static void main(String[] args) throws InterruptedException {
        ThreadTest threadTest = new ThreadTest();
        threadTest.start();
        for (int i=0; i<20; i++) {
            System.out.println("一边看电影");
            //线程堵塞
            Thread.sleep(1);
        }
    }
    @Override
    public void run() {
        for (int i=0; i<20; i++){
            System.out.println("一边吃零食");
            //线程堵塞
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class RunnableTest implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RunnableTest());
        thread.start();
        for (int i=0; i<20; i++) {
            System.out.println("一边看电影");
            //线程堵塞
            Thread.sleep(1);
        }
    }
    @Override
    public void run() {
        for (int i=0; i<20; i++){
            System.out.println("一边吃零食");
            //线程堵塞
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class CallableTest implements Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建执行服务
        ExecutorService ser= Executors.newFixedThreadPool(3);
        //提交执行
        Future<Object> result1 =ser.submit(new CallableTest(1)) ;
        Future<Object> result2 =ser.submit(new CallableTest(2)) ;
        Future<Object> result3 =ser.submit(new CallableTest(3)) ;
        //获取结果
        Object r1 =result1.get();
        Object r2 =result2.get();
        Object r3 =result3.get();
        System.out.println(r3);
        //关闭服务
        ser.shutdownNow();
    }
    private int id;
    public CallableTest(int id) {
        this.id = id;
    }
    @Override
    public Object call() throws Exception {
        for (int i=0; i<20; i++){
            System.out.println(id+"：吃零食");
            //线程堵塞
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "returnValue";
    }
}
/**
 * 3.考题注意多线程是调用的run还是start
 * 4.说明类java.lang.ThreadLocal的作用和原理。列举在哪些程序中见过ThreadLocal的使用？
 *  ThreadLocal是除了加锁这种同步方式之外的一种保证一种规避多线程访问出现线程不安全的方法
 */
class ThreadLocalTest {
    public static void main(String[] args) {
        Thread t1  = new Thread(new Runnable() {
            @Override
            public void run() {
                //设置线程1中本地变量的值
                localVar.set("localVar1");
                //调用打印方法
                print("thread1");
                //打印本地变量，无法在共享区取到localVar
                System.out.println("after remove : " + localVar.get());
            }
        });
        Thread t2  = new Thread(new Runnable() {
            @Override
            public void run() {
                //设置线程1中本地变量的值
                localVar.set("localVar2");
                //调用打印方法
                print("thread2");
                //打印本地变量，无法在共享区取到localVar
                System.out.println("after remove : " + localVar.get());
            }
        });
        t1.start();
        t2.start();
    }
    static ThreadLocal<String> localVar = new ThreadLocal<>();
    static void print(String str) {
        //打印当前线程中本地内存中本地变量的值
        System.out.println(str + " :" + localVar.get());
        //清除本地内存中的本地变量
        localVar.remove();
    }
}
/**
 * 5.如何设置多线程的优先级？优先级大代表什么？
 *  在xxx.start()前先xxx.setPriority(10)
 *  优先级大代表先执行的概率高
 * 6.线程的状态？
 *  新生→就绪→运行→死亡
 * 7.线程终止stop()与destroy()好用吗？怎么停止最好？
 *  stop()与destroy()已经过时，可以通过标识flag来让线程执行完毕→停止线程
 * 8.多线程的暂停、礼让、插队是什么？
 *  暂停Tread.sleep(1000)，不释放资源
 *  礼让Tread.yield()，回到就绪状态
 *  插队join与前2个不同的是要Tread对象才能调用，即xxx.join()→执行join的线程被阻塞了直到xxx线程执行完
 * 9.如果观察线程状态？
 *  启动线程A，在线程B中使用A.getState()获得，不停地监控就可以看到A线程的各个状态值
 * 10.守护线程如何实现？
 *  默认都是用户进程，守护线程xxx.setDaemon(true)在xxx.start()之前
 *  守护线程只有在其他所有用户线程都停止了才会停止
 *  守护线程不能持有需要关闭的资源，如打开文件等
 * 11.乐观锁与悲观锁是什么？
 *  悲观锁(Pessimistic Lock)，每次去拿数据的时候都认为别人会修改，每次使用都会上锁
 *  乐观锁(Optimistic Lock)，每次去拿数据的时候都认为别人不会修改，在数据进行提交更新的时候才会检测是否有冲突
 * 12.乐观锁与悲观锁的实现方式？？
 *  悲观锁：
 *      悲观锁的实现，每次都上锁(可以是数据库中，可以是Java中)
 *      数据库版：
 *          使用悲观锁，我们必须关闭MySQL数据库的自动提交属性set autocommit=0
 *          begin; select * from items where id=1 for update; update items set name="test" where id = 1; commit;
 *      Java版：
 *          使用synchronized或者lock
 *  乐观锁：
 *      乐观锁的实现，冲突检测和数据更新
 *      CAS有ABA问题，一直和预期值不对的情况下会一直循环，只能保证一个共享变量的原子操作
 *      CAS是乐观锁技术，当多个线程尝试用CAS同时升级同一个变量时，只有其中一个线程可以升级变量的值，而其它线程都失败，失败的线程并不会被挂起，而是被告知这次竞争中失败，并能再次尝试
 */
class OptimisticLock {
    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerCounter counter = new AtomicIntegerCounter();
        Thread addThread = new AddDataThread(counter);
        Thread decThread = new DecDataThread(counter);
        addThread.start();
        decThread.start();
        addThread.join();
        decThread.join();
        System.out.println(counter.getCount());
    }
}
//多线程争用的数据类
class AtomicIntegerCounter {
    //int count = 0;
    //使用AtomicInteger代替基本数据类型
    AtomicInteger count = new AtomicInteger(0);
    public int getCount() {
        //return count;
        return count.get();
    }
    public void add() {
        //count += 1;
        count.addAndGet(1);
    }
    public void dec() {
        //count -= 1;
        count.decrementAndGet();
    }
}
//争用数据做加操作的线程
class AddDataThread extends Thread {
    private AtomicIntegerCounter counter;
    private int times = 10000;
    public AddDataThread(AtomicIntegerCounter counter) {
        this.counter = counter;
    }
    @Override
    public void run() {
        for (int i = 0; i<times; ++i) {
            counter.add();
        }
    }
}
//争用数据做减法操作的线程
class DecDataThread extends Thread {
    private AtomicIntegerCounter counter;
    private int times = 10000;
    public DecDataThread(AtomicIntegerCounter counter) {
        this.counter = counter;
    }
    @Override
    public void run() {
        for (int j=0; j<times; j++) {
            counter.dec();
        }
    }
}
/**
 * 13.在Java中怎么实现多线程?描述线程状态的变化过程？
 * 14.在多线程编程里，wait方法的调用方式是怎样的？
 *  wait方法是线程通信的方法之一，必须用在 synchronized方法或者synchronized代码块中
 * 15.Java线程的几种状态？
 *  新建、就绪、运行、死亡、堵塞
 * 16.在Java多线程中，xxx.yield()会是线程进入就绪状态不是堵塞状态
 * 17.suspend()挂起、resume()继续执行线程，这2个方法已经过时，不建议使用
 * 18.volatile关键字是否能保证线程安全？
 *  虽然volatile提供了同步的机制，但是只是一种弱的同步机制，如需要强线程安全，还需要使用synchronized
 * 19.Executors线程池有几种常用类型？
 *  FixedThreadPool这个线程池可以创建固定线程数的线程池
 *  SingleThreadExecutor是使用单个worker线程的Executor
 *  CachedThreadPool是一个”无限“容量的线程池，它会根据需要创建新线程
 * 20.sleep是线程类（Thread）的方法，wait是Object类的方法
 * 21.Sleep不释放对象锁，wait放弃对象锁
 * 22.Sleep暂停线程、但监控状态任然保持，结束后会自动恢复
 * 23.针对此对象的notify方法后获取对象锁并进入就绪状态，而不是运行状态
 * 24.进程和线程的区别是什么？
 *  根本区别、开销、所处环境(分配内存)、包含关系
 **
 * 25.创建n多个线程，如何保证这些线程同时启动？
 *  用一个for循环创建线程对象，同时调用wait()方法，让所有线程等待；直到最后一个线程也准备就绪后，调用notifyAll(), 同时启动所有线程
 */
class TogetherRun{
    public static void main(String[] args) {
        CarCompetition carCompetition = new CarCompetition();
        final ExecutorService carPool = Executors.newFixedThreadPool(carCompetition.totalCarNum);
        for (int i = 0; i < carCompetition.totalCarNum; i++) {
            carPool.execute(new Car(i, carCompetition));
        }
        carPool.shutdown();
    }
}
class CarCompetition {
    // 参赛赛车的数量
    protected final int totalCarNum = 10;
    // 当前在起跑线的赛车数量
    protected int nowCarNum = 0;
}
class Car implements Runnable{
    private int carNum;
    private CarCompetition competition = null;
    public Car(int carNum, CarCompetition competition) {
        this.carNum = carNum;
        this.competition = competition;
    }
    @Override
    public void run() {
        synchronized (competition) {
            competition.nowCarNum++;
            while (competition.nowCarNum < competition.totalCarNum) {
                try {
                    competition.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            competition.notifyAll();
        }
        startCar();
    }
    private void startCar() {
        System.out.println("Car num " + this.carNum + " start to run.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Car num " + this.carNum + " get to the finish line.");
    }
}
/**
 * 26.同步和异步有何异同，在什么情况下分别使用它们？
 * 27.创建进程做必须的步骤有？
 *  建立一个进程控制块
 *  为进程分配内存
 * 28.无锁化编程有哪些常见方法？
 *  CAS（Compare-and-Swap），如无锁栈，无锁队列等待
 * 29.sleep()和yield()有什么区别?
 *  sleep()方法给其他线程运行机会时不考虑线程的优先级，因此会给低优先级的线程以运行的机会；yield()方法只会给相同优先级或更高优先级的线程以运行的机会；
 *  线程执行sleep()方法后转入阻塞（blocked）状态，而执行yield()方法后转入就绪（ready）状态；
 *  sleep()方法声明抛出InterruptedException，而yield()方法没有声明任何异常；
 *  sleep()方法比yield()方法（跟操作系统相关）具有更好的可移植性
 * 30.当一个线程进入一个对象的synchronized方法A之后，其它线程是否可进入此对象的synchronized方法？
 *  不能。其它线程只能访问该对象的非同步方法，同步方法则不能进入
 * 31.synchronized能锁哪些？
 *  修饰普通方法、修饰静态方法、修饰代码块
 *  对象锁、类锁，即只能锁对象
 *  注意：对象里的常量不能锁，synchronized(包装类)→值发生了改变就不是同一对象了
 * 32.高并发容器CopyOnWriteArrayList自带锁
 * 33.什么是死锁？什么时候可能发生？
 *  2个锁相互不释放资源
 *  同步方法比较多的时候
 * 34.多线程的指令重排是什么？
 *  编译器为了优化程序的性能，会重新对字节码指令排序
 *  指令重排序在单线程中对我们程序的帮助一定是正向的，它能够很好的优化我们程序的性能，在多线程情况下，就不一定了
 *  最简单的例子：双检查锁单例模式
 */
class HappensBefore {
    //变量1
    private static int a = 0;
    //变量2
    private static boolean flag = false;
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            a = 0;
            flag = false;
            //线程1 更改数据
            Thread t1 = new Thread(() -> {
                a = 1;
                flag = true;
            });
            //线程2 读取数据
            Thread t2 = new Thread(() -> {
                if (flag) {
                    a *= 1;
                }
                //指令重排
                if (a == 0) {
                    System.out.println("happen before a->" + a);
                }
            });
            t1.start();
            t2.start();
            //合并线程
            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
/**
 * 35.volatile用于保证数据同步，也就是可见性
 */
class VolatileTest {
    //如果没有volatile则一直是死循环无法同步，电脑忙不过来没时间同步数据
    private volatile static int num = 0;
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while(num==0) { //此处不要编写代码

            }
        }) .start();
        Thread.sleep(1000);
        num = 1;
    }

}
/**
 * 36.可重入锁ReentrantLock如何使用？与Synchronized区别？
 *  锁的细粒度和灵活度：很明显ReentrantLock优于Synchronized
 *  很明显Synchronized的使用比较方便简洁
 *  ReentrantLock是公平锁，Synchronized是非公平锁
 *  ReentrantLock等待可中断、锁绑定多个条件、公平锁
 */
class ReentrantLockTest {
    ReentrantLock lock = new ReentrantLock();
    private void a() throws InterruptedException {
        lock.lock();
        System.out.println(lock.getHoldCount());
        doSomething();
        lock.unlock();
        System.out.println(lock.getHoldCount());
    }
    //可重入
    private void doSomething() throws InterruptedException {
        lock.lock();
        System.out.println(lock.getHoldCount());
        //...................
        lock.unlock();
        System.out.println(lock.getHoldCount());
    }
    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest test = new ReentrantLockTest();
        test.a();
        Thread.sleep(1000);
        System.out.println(test.lock.getHoldCount());
    }

}
class ReentrantLockTest2{
    public static void main(String[] args) {
        ReentrantLockThread t1 = new ReentrantLockThread();
        new Thread(t1, "t1").start();
        new Thread(t1, "t2").start();
    }
}
class ReentrantLockThread implements Runnable {
    private Lock lock=new ReentrantLock();
    public void run() {
        lock.lock();
        try{
            for(int i=0; i<5; i++)
                System.out.println(Thread.currentThread().getName()+":"+i);
        }finally{
            lock.unlock();
        }
    }
}
/**
 * 37.请说出与线程同步相关的方法？
 *   wait()、 sleep()、notify()、notifyAll()
 * 38.什么是线程池（thread pool）？
 *  在面向对象编程中，创建和销毁对象是很费时间的，因为创建一个对象要获取内存资源或者其它更多资源
 *  newSingleThreadExecutor：创建一个单线程的线程池
 *  newFixedThreadPool：创建固定大小的线程池
 *  newCachedThreadPool：创建一个可缓存的线程池
 *  newScheduledThreadPool：创建一个大小无限的线程池
 * 39.简述synchronized 和java.util.concurrent.locks.Lock的异同？
 *  Lock能完成synchronized所实现的所有功能
 *  Lock有比synchronized 更精确的线程语义和更好的性能
 *  synchronized会自动释放锁，而Lock一定要求程序员手工释放，并且必须在finally块中释放
 * 40.创建线程的方式分别是什么,优缺点是什么？
 *  继承Java.lang.Thread类
 *      编写简单，但单继承的限制----无法继承其它父类，同时不能实现资源共享
 *  实现Java.lang.Runnable接口
 *      可继承其它类，多线程可共享同一个Thread对象，但编程方式稍微复杂
 *  实现java.util.concurrent.Callable接口
 *      线程方法可以定义返回值
 * 41.Java创建线程后，调用start()方法和run()的区别？
 *  用start方法来启动线程，真正实现了多线程运行
 *  run()方法只是类的一个普通方法而已，如果直接调用run方法，程序中依然只有主线程这一个线程
 * 42如何实现线程同步？
 *  2种可重入锁：synchronized、ReentrantLock
 * 43.Java中实现线程通信的三个方法的作用是什么？
 *  wait()、wait(long timeout)、wait(long timeout, int nanos)
 *  notify()
 *  notifyAll()
 **
 * 44.ReentrantLock如何确定是否锁住？
 *  保证每个线程用的是同一个ReentrantLock
 *  可以把private Lock lock=new ReentrantLock();放在改变的对象里
 *  可以把private static Lock lock=new ReentrantLock();放在执行的传递信息对象里
 */
//模拟取款
class SafeDrawing extends Thread{
    public static void main(String[] args) {
        //账户
        Account account =new Account(100,"结婚礼金");
        SafeDrawing you = new SafeDrawing(account,80,"可悲的你");
        SafeDrawing wife = new SafeDrawing(account,90,"happy的她");
        you.start();
        wife.start();
    }
    Account account ; //取钱的账户
    int drawingMoney ;//取的钱数
    int packetTotal ; //口袋的总数
    private static Lock lock=new ReentrantLock();
    public SafeDrawing(Account account, int drawingMoney,String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }
    @Override
    public void run() {
        test();
    }
    private void test() {
        lock.lock();
        try {
            if (account.money - drawingMoney < 0) {
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money -= drawingMoney;
            packetTotal += drawingMoney;
            System.out.println(this.getName() + "-->账户余额为:" + account.money);
            System.out.println(this.getName() + "-->口袋的钱为:" + packetTotal);
        }finally {
            lock.unlock();
        }
    }
}
/**
 * 45.ReentrantLock如何转换条件？
 */
class NewConditionTest{
    private double[] accounts;
    private Lock bankLock;
    private Condition sufficientFunds;
    public NewConditionTest() {
        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();
    }
    public void transfer(int from, int to, int amount) throws InterruptedException{
        bankLock.lock();
        try {
            while (accounts[from] < amount)
                sufficientFunds.await();  //账户钱不够线程阻塞
            //transfer
            sufficientFunds.signalAll();
        } finally {
            bankLock.unlock();
        }
    }
}
/**
 * 46.静态方法不能用synchronized(this)，用synchronized(xxx.class)
 **
 * 47.如何测试多线程执行时间？
 *  用CountDownLatch类
 *  主进程：final CountDownLatch  countDownLatch = new CountDownLatch(10);
 *  10个线程：countDownLatch.countDown();
 *  主进程：countDownLatch.await();
 */
class TimeTest {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        int threadNum = 10;
        final CountDownLatch  countDownLatch = new CountDownLatch(threadNum);

        for(int i=0;i<threadNum;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<1000000;i++){
                    }
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();	//main线程阻塞，直到计数器变为0，才会继续往下执行！
        long end = System.currentTimeMillis();
        System.out.println("总耗时："+(end-start));
    }
}























