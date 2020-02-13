package com.java.review.jvm;

import java.util.Arrays;
import java.util.EmptyStackException;

public class JVMTest {
}

/**
 * 1.简述Java内存管理机制，以及垃圾回收的原理和使用过Java调优工具？
 *  内存管理的职责为分配内存，回收内存。 没有自动内存管理的语言/平台容易发生错误
 *  典型的问题包括悬挂指针问题，一个指针引用了一个已经被回收的内存地址，导致程序的运行完全不可知
 *  另一个典型问题为内存泄露，内存已经分配，但是已经没有了指向该内存的指针，导致内存泄露
 * 2.描述JVM加载class文件的原理机制
 *  JVM中类的装载是由类加载器（ClassLoader）和它的子类来实现的
 *  Java中的类加载器是一个重要的Java运行时系统组件，它负责在运行时查找和装入类文件中的类
 *  类的加载是由类加载器完成的，类加载器包括：
 *      根加载器（BootStrap）
 *      扩展加载器（Extension）
 *      系统加载器（System）
 *      用户自定义类加载器（java.lang.ClassLoader的子类）
 * 3.说说JVM原理？内存泄漏与溢出的区别？何时产生内存泄漏？
 *  JVM原理：
 *      它是整个java实现跨平台的最核心的部分，Java程序会首先被编译为.class的类文件+JVM才与操作系统交互
 *      JVM是Java平台的基础，有自己的指令集，操作不同的内存区域，能保护用户免被恶意程序骚扰
 *  内存泄漏与溢出的区别：
 *      内存溢出是提供的内存不够
 *      内存泄漏是无法再提供内存资源
 *  何时产生内存泄漏：
 *      静态集合类
 *      监听器
 *      各种连接
 *      外部模块的引用
 *      单例模式
 * 4.GC线程是否为守护线程？
 *  GC线程是守护线程
 *  线程分为守护线程和非守护线程，非守护线程结束守护线程才会结束
 * 5.Java的类加载器都有哪些，每个类加载器都有加载那些类，什么是双亲委派模型，是做什么的？
 *  启动类加载器（Bootstrap ClassLoader）
 *  扩展类加载器（Extension ClassLoader）
 *  应用程序类加载器（Application ClassLoader）
 *  双亲委派模型：
 *      双亲委派模型要求除了顶层的启动类加载器外，其他的类加载器都应当有自己的父类加载器
 *      这里类加载器之间的父子关系一般不会以继承关系来实现，而是都使用组合关系来复用父加载器的代码
 *      Java类随着它的类加载器一起具备了一种带有优先级的层次关系
 * 6.垃圾回收器（GC）的基本原理是什么？垃圾回收器可以马上回收内存吗？如何通知虚拟机进行垃圾回收？
 *  对于GC来说，当程序员创建对象时，GC就开始监控这个对象的地址、大小以及使用情况
 *  GC采用有向图的方式记录和管理堆(heap)中的所有对象。通过这种方式确定哪些对象是"可达的"，哪些对象是"不可达的"
 *  可以马上回收。回收的方式有System.gc()或者Runtime.getRuntime().gc()
 * 7.Java中会存在内存泄漏吗，请简单描述？
 *  理论上Java因为有垃圾回收机制（GC）不会存在内存泄露问题
 *  在实际开发中，可能会存在无用但可达的对象，这些对象不能被GC回收也会发生内存泄露
 */
class MyStack<T> {
    private T[] elements;
    private int size = 0;
    private static final int INIT_CAPACITY = 16;
    public MyStack() {
        elements = (T[]) new Object[INIT_CAPACITY];
    }
    public void push(T elem) {
        ensureCapacity();
        elements[size++] = elem;
    }
    public T pop() {
        if(size == 0)
            throw new EmptyStackException();
        return elements[--size]; // 没有回收，可能会发生内存泄漏
    }
    private void ensureCapacity() {
        if(elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
/**
 * 8.GC 是什么？为什么要有GC？
 *  GC是垃圾收集的意思
 *  垃圾回收器通常是作为一个单独的低优先级的线程运行，不可预知的情况下对内存堆中已经死亡的或者长时间没有使用的对象进行清除和回收
 *  忘记或者错误的内存回收会导致程序或系统的不稳定甚至崩溃
 *  垃圾回收可以有效的防止内存泄露，有效的使用可以使用的内存
 *  垃圾回收机制有很多种，可以自己根据现状优化设置
 * 9.Java堆为什么要分代？有哪些分代？
 *  新生代、老年代、永久代(持久代)
 *  为了不造成内存资源浪费、提高垃圾回收的性能
 */





































