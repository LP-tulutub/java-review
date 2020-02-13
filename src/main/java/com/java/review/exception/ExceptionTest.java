package com.java.review.exception;

public class ExceptionTest {
}

/**
 * 1.异常处理有2大类，是什么？
 *  检查异常、运行异常
 *  检查异常必须要try+catch或者在方法上throws抛出
 * 2.Java出现OutOf MemoryError（OOM 错误)的原因有哪些？出现OOM错误后，怎么解决？
 *  java.lang.OutOfMemoryError: Java heap space：
 *      错误原因：此OOM是由于JVM中heap的最大值不满足需要
 *      解决方法：1)调高heap的最大值，即-Xmx的值调大。2)如果程序存在内存泄漏，一味的增加heap空间也只是推迟该错误出现的时间而已，所以要检查程序是否存在内存泄漏
 *  java.lang.OutOfMemoryError: GC overhead limit exceeded：
 *      错误原因：此OOM是由于JVM在GC时，对象过多，导致内存溢出
 *      解决方法：改变GC策略，在老代80%时就是开始GC，并且将-XX:SurvivorRatio（-XX:SurvivorRatio=8）和-XX:NewRatio（-XX:NewRatio=4）设置的更合理
 *  java.lang.OutOfMemoryError: Java perm space：
 *      错误原因：此OOM是由于JVM中perm的最大值不满足需要
 *      解决方法：调高heap的最大值，即-XX:MaxPermSize的值调大
 * 3.列举常见的运行时异常？
 *  ClassCastException(类转换异常)
 *  IndexOutOfBoundsException(下标越界异常)
 *  NullPointerException(空指针异常)
 *  ArrayStoreException(数组存储异常)
 *  BufferOverflowException(IO操作时出现的缓冲区上溢异常)
 *  InputMismatchException(输入类型不匹配异常)
 *  ArithmeticException(算术异常)
 *  注意：运行时异常都是RuntimeException子类异常
 * 4. Java.lang.Exception类继承自Throwable，支持Serializable
 **
 * 5.try{}里有一个return语句，那么紧跟在这个try后的finally{}里的code会不会被执行，什么时候被执行，在return前还是后？
 *  会执行
 *  在return之后，注意的是如果finally有return则以finally的return为准
 */
class FinallyTest {
    public static void main(String[] args) {
        System.out.println(FinallyTest.test());
    }
    static int test(){
        int x = 1;
        try {
            return x;
        }finally {
            ++x;
        }
    }
}
/**
 * 6.Java 语言如何进行异常处理，关键字：throws、throw、try、catch、finally分别如何使用？
 *  Java通过面向对象的方法进行异常处理，把各种不同的异常进行分类，并提供了良好的接口
 *  调用捕获到异常并进行处理，用try、catch、throw、throws和finally
 *  用try来执行一段程序，如果出现异常，系统会抛出（throw）一个异常，这时候你可以通过它的类型来捕捉（catch）它，或最后（finally）由缺省处理器来处理
 *  throws是检查异常必须用try+catch或方法上throws抛出
 * 7.运行时异常与受检异常有何异同？
 *  运行时异常表示虚拟机的通常操作中可能遇到的异常，是一种常见运行错误，只要程序设计得没有问题通常就不会发生
 *  受检异常跟程序运行的上下文环境有关，即使程序设计无误，仍然可能因使用的问题而引发
 *  注意：
 *      不要将异常处理用于正常的控制流（设计良好的API不应该强迫它的调用者为了正常的控制流而使用异常）
 *      对可以恢复的情况使用受检异常，对编程错误使用运行时异常
 *      避免不必要的使用受检异常（可以通过一些状态检测手段来避免异常发生）
 *      优先使用标准的异常
 *      每个方法抛出的异常都要有文档
 *      保持异常的原子性
 *      不要在catch中忽略掉捕获到的异常
 * 8.当catch有多个时，是如何接收异常的？
 *  从上到下，只要包含就捕获
 */
class Annoyance extends Exception {}
class Sneeze extends Annoyance {}
class Human {
    public static void main(String[] args)
            throws Exception {
        try {
            try {
                throw new Sneeze();
            }
            catch ( Annoyance a ) {
                System.out.println("Caught Annoyance");
                throw a;
            }
        }
        catch ( Sneeze s ) {
            System.out.println("Caught Sneeze");
            return ;
        }
        finally {
            System.out.println("Hello World!");
        }
    }
}
/**
 * 9.Error和Exception的区别？
 *  Error类：表示仅靠程序本身无法恢复的严重错误，比如说内存溢出、动态链接异常、虚拟机错误
 *  Exception类，由Java应用程序抛出和处理的非严重错误，比如所需文件没有找到、零作除数，数组下标越界等，可分为两类-->Checked异常和Runtime异常
 * 10.Java异常处理try-catch-finally的执行过程？
 *  程序首先执行可能发生异常的try语句块
 *  如果try语句没有出现异常则执行完后跳至finally语句块执行
 *  如果try语句出现异常，则中断执行并根据发生的异常类型跳至相应的catch语句块执行处理(catch语句块可以有多个，分别捕获不同类型的异常)
 *  catch语句块执行完后程序会继续执行finally语句块
 *  注意：finally语句是可选的，如果有的话，则不管是否发生异常，finally语句都会被执行。需要注意的是即使try和catch块中存在return语句，finally语句也会执行，是在执行完finally语句后再通过return退出
 * 11.异常处理中throws和throw的区别？
 *  throw用于程序员自行产生并抛出异常；throw抛出一个异常对象，且只能是一个
 *  throws用于声明在该方法内抛出了异常；throws后面跟异常类，而且可以有多个
 */
































