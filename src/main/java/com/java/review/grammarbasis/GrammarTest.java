package com.java.review.grammarbasis;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class GrammarTest {
}
/**
 * 1.java的3大版本？
 *  J2SE、J2EE、J2ME
 * 2.JVM、JDK、JRE是什么？
 *  JVM是java虚拟机，用来编译.class文件，在不同平台不需要重新编译，它有自己完善的硬件架构
 *  JDK是java开发工具，内部有JRE运行环境
 *  JRE是java运行环境
 *3.基本数据类型的转换规则？
 *  低级→高级是自动转换
 *  高级→低级是强制转换
 * 4.java的3中注释？
 * 5.8种基本类型？
 *  byte、short、int、long、float、double、char、boolean
 * 6.i++与++i的异同？
 * 8.&与&&的区别和联系？
 *  &是逻辑于运算符，&&是短路与运算符
 *  &两边都要判断，可以作为位运算符
 *  &&的左边是false则不用判断右边，性能更高
 * 9.最有效率计算2*8是什么？
 *  2<<3
 **
 * 10.if与switch的区别？
 *  注意：switch的default
 */
class SwitchTest{
    public static void main(String[] args) {
        int i=9;
        switch (i) {
            default:
                System.out.println("default");
            case 0:
                System.out.println("zero");
                break;
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
        }
    }
}
/**
 * 11.while与do-while的区别？
 * 12.break与continue的用法？
 **
 * 13.用递归算法计算n的阶乘？
 *  最简单的递归+递归输出目录和下面的文件
 */
class SimpleRecursion{
    public static void main(String[] args) {
        long chen = JieChen(4);
        System.out.println(chen);
    }
    private static long JieChen(int n){
        if ((n-1)==0){
            return 1;
        }
        return n*JieChen(n-1);
    }
}
class SimpleRecursionFile {
    public static void main(String[] args) {
        String path = "E:/笔记";
        recursionFile(path);
    }
    private static void recursionFile(String path) {
        File f = new File(path);
        File[] fs = f.listFiles();
        if (fs == null) {
            return;
        }
        for (File file : fs) {
            if (file.isFile()) {
                System.out.println(file.getPath());
            } else {
                recursionFile(file.getPath());
            }
        }
    }
}
/**
 * 14.冒泡排序法代码？
 *  基础版+优化版
 */
class BubbleSort{
    private static void sort(int[] arr){
        int temp = 0;
        for (int i=0; i<arr.length-1; i++){
            for (int j=0; j<arr.length-i-1; j++){
                //如果后比前小，则交换
                if (arr[j+1] < arr[j]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    private static void sort2(int[] arr){
        int temp = 0;
        for (int i=0; i<arr.length-1; i++){
            //在某种情况下可以证明数组已经完成排序，这时候可以直接退出循环了
            int flag = 0;
            for (int j=0; j<arr.length-i-1; j++){
                //如果后比前小，则交换
                if (arr[j+1] < arr[j]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = 1;
                }
            }
            if (flag==1){
                break;
            }
        }
    }
}
/**
 * 15.选择排序法代码？
 *  基础版
 */
class SelectSort{
    private static void sort(int[] arr){
        int temp = 0;
        for (int i=0; i<arr.length-1; i++){
            //找出最小的数的位置
            int minIndex = i;
            for (int j=i+1; j<arr.length; j++){
                if (arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            //把最小的放到当前位置
            if (i != minIndex){
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
/**
 * 16.插入排序法代码？
 *  基础版
 */
class InsertSort{
    private static void sort(int[] arr){
        int i, j;
        for (i=1; i<arr.length; i++){
            //用当前的数找到应该在前面的位置
            int temp = arr[i];
            //整体向后移，留出空位
            for (j=i; j>0 && temp<arr[j-1]; j--){
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
    }
}
/**
 * 17.递归的优缺点？
 * 18.数组的特征？
 *  相同类型数据的有序集合(加入的顺序)
 *  索引从0开始
 *  不知道具体存了多少，无法用length探知
 *  长度固定
 * 19.可变参数如：private void nameOne(int... arr){...}
 *  只能是方法的形参
 *  可以对应多个实参或者对应数组
 *  有了可变参数不能再定义相同类型的数组
 * 20.类和对象的关系？
 *  类和对象（class）是两种以计算机为载体的计算机语言的合称
 *  对象是对客观事物的抽象，类是对对象的抽象
 *  类是一种抽象的数据类型
 *  它们的关系是，对象是类的实例，类是对象的模板
 *  对象是通过new className产生的，用来调用类的方法;类的构造方法。
 * 21.面向过程和面向对象的区别？
 *  面向对象就是构成问题事务分解成各个对象，建立对象的目的不是为了完成一个步骤，而是为了描叙某个事物在整个解决问题的步骤中的行为
 *  面向过程不同于面向对象，面向过程分析出解决问题所需要的步骤，然后用函数把这些步骤一步一步实现，使用的时候一个一个依次调用就可以了
 **
 * 22.this和super的作用？
 *  this在构造方法中不能省略，其他普通方法可以省略
 *  super可以直接调用父类成员的方法(不能访问private)，继承的对象构造器要加上super
 */
class SuperUserTest extends Person{
    private String run;

    public SuperUserTest() {
        super();
    }

    public SuperUserTest(int id, String name, int age, String run) {
        super(id, name, age);
        this.run = run;
    }
}
/**
 * 23.static与非static区别？
 *  内存中份数不同-static只有一份，内存中存放的位置不同
 * 24.static关键字的作用？
 *  可以修饰变量、方法、代码块、内部类
 *  static变量或方法时，不不用new对象就可以直接调用
 *  static代码块，启动编译时最先加载代码块且只加载一次
 *  static内部类不能访问外部类的非静态成员
 */
class StaticTest{
    static class StaticInnerTest{
        public void testVoid(){
            System.out.println("StaticInnerTest");
        }
    }
}
class StaticTestRun{
    public static void main(String[] args) {
        StaticTest.StaticInnerTest staticTest = new StaticTest.StaticInnerTest();
        staticTest.testVoid();
    }
}
class StaticA{
    static{
        System.out.print("1");
    }
    public StaticA(){
        System.out.print("2");
    }
}
class StaticB extends StaticA{
    static{
        System.out.print("a");
    }
    public StaticB(){
        System.out.print("b");
    }
}
class StaticTestRun2{
    public static void main(String[] args){
        StaticA ab = new StaticB();
        ab = new StaticB();
    }
}
/**
 * 25.final和abstract的作用？
 *  final修饰类、方法、属性，不能被重写修改(注意：如果是修饰类，类的位置不能改变，但是内容可以改变)
 *  abstract修饰类、方法，需要子类重写
 * 26.final、finally、finalize的区别？
 * 27.java.lang.Object类的6个常用方法？
 *  equals、hashCode、toString、finalize、clone、wait、notify、notifyAll
 *      public boolean equals(java.lang.Object) 比较对象的地址值是否相等，如果子类重写，则比较对象的内容是否相等
 *      public native int hashCode() 获取哈希码
 *      public java.lang.String toString() 把数据转变成字符串
 *      protected void finalize() throws java.lang.Throwable 垃圾回收前执行的方法
 *      protected native Object clone() throws java.lang.CloneNotSupportedException 克隆
 *      public final void wait() throws java.lang.InterruptedException 多线程中等待功能
 *      public final native void notify() 多线程中唤醒功能
 *      public final native void notifyAll() 多线程中唤醒所有等待线程的功能
 * 28.访问权限关键字？
 *  public、default、protected、private
 * 29.==与equals的区别和联系？
 *  ==两边为基本类型比较值，两边为类型比较地址，不能比较没有父子关系的2个对象
 *  equals比较内容，如果没有重写用的Object的equals，比较的是地址即Object的==与equals相同
 * 30.java的多态？
 *  3个条件：继承、子类重写父类方法、父类引用变量指向子类对象
 * 31.java的垃圾回收机制？
 *  垃圾回收机制回收JVM堆内存里的对象空间,不负责回收栈内存数据
 *  对其他物理连接，比如数据库连接、输入流输出流、Socket连接无能为力
 *  垃圾回收发生具有不可预知性，程序无法精确控制垃圾回收机制执行
 *  可以将对象的引用变量设置为null，暗示垃圾回收机制可以回收该对象
 * 32.基本数据类型和包装类？
 * 33.Integer与int的区别？
 * 34.java.sql.Date和java.util.Date的联系和区别？
 *  如果使用sql的Date规范到毫秒，则用sql的Date
 * 35.java编译后会产生byte code
 * 36.constructor在一个对象被new时执行
 * 37.Java中接口的修饰符可以为abstract
 * 38.在继承关系下，创建子类对象，先执行父类的构造方法，再执行子类的构造方法
 * 39.abstract不能与final并列修饰同一个类、abstract类中可以有private的成员、abstract方法必须在abstract类中
 * 40.内存回收程序负责释放无用内存
 * 41.标识符的命令规范，可以包含字母、数字、下划线、$，不能以数字开头，不能是Java关键字
 * 42.说明内存泄漏和内存溢出的区别和联系，结合项目经验描述Java程序中如何检测？如何解决？
 *  内存溢出 out of memory，是指程序在申请内存时，没有足够的内存空间供其使用，出现out of memory
 *  比如申请了一个integer,但给它存了long才能存下的数，那就是内存溢出
 *  内存泄露 memory leak，是指程序在申请内存后，无法释放已申请的内存空间，一次内存泄露危害可以忽略，但内存泄露堆积后果很严重，无论多少内存,迟早会被占光
 *  memory leak会最终会导致out of memory
 * 43.什么是Java的序列化，如何实现Java的序列化？列举在哪些程序中见过Java序列化？
 *  implements Serializable
 *  最常见的是Web服务器中的Session对象，当有 10万用户并发访问，就有可能出现10万个Session对象，内存可能吃不消
 *  于是Web容器就会把一些session先序列化到硬盘中，等要用了，再把保存在硬盘中的对象还原到内存中
 * 44.不通过构造函数也能创建对象吗？
 *  用new
 *  用反射
 *  clone()方法
 *  用反序列化
 * 45.匿名内部类可不可以继承或实现接口。为什么？
 *  匿名内部类是没有名字的内部类,不能继承其它类,但一个内部类可以作为一个接口,由另一个内部类实现
 *  由于匿名内部类没有名字，所以它没有构造函数
 *  因为没有构造函数，所以它必须完全借用父类的构造函数来实例化
 * 46.HashMap的key有自动装箱操作
 * 47.接口和抽象类的区别？
 * 48.同步代码块和同步方法有什么区别？
 *  同步方法直接在方法上加synchronized实现加锁，同步代码块则在方法内部加锁
 *  一般同步代码块的范围更小，即性能更高
 * 49.静态内部类和内部类有什么区别？
 *  静态内部类可以有静态成员(方法，属性)，而非静态内部类则不能有静态成员(方法，属性)
 *  非静态内部类能够访问外部类的静态和非静态成员。静态内部类不能访问外部类的非静态成员，只能访问外部类的静态成员
 *  实例化方式不同
 * 50.反射的概念与作用？
 *  反射，一种计算机处理方式。是程序可以访问、检测和修改它本身状态或行为的一种能力
 *  反射使java这种静态语言有了动态的特性
 *  java反射使得我们可以在程序运行时动态加载一个类，动态获取类的基本信息和定义的方法,构造函数,域等
 *  增加程序的灵活性，一般框架中使用较多
 * 51.形式参数可被视为local Variable
 * 52.javac—次可同时编译数个Java源文件
 * 53.数组是—种对象
 * 54.call by value不会改变实际参数的数值、call by reference 不能改变实际参数的参考地址、call by reference 能改变实际参数的内容
 *  Java中参数的传递有两种，一种是按值传递（call by value：传递的是具体的值，如基础数据类型）
 *  另一种是按引用传递（call by reference：传递的是对象的引用，即对象的存储地址）
 *  前者不能改变实参的数值
 *  后者虽然不能改变实参的参考地址，但可以通过该地址访问地址中的内容从而实现内容的改变
 * 55.在类方法中可用this来调用本类的类办法，类方法是在类加载时被加载到方法区存储的，此时还没有创建对象，所以不能使用this或者super关键字
 * 56.Java语言中的方法必定隶属于某一类（对象），调用方法与过程或函数相同
 * 57.Java接口的修饰符可以为abstract
 * 58.存在使(i+1<i)的数
 * 59.接口可否继承接口？抽象类是否可实现接口？抽象类是否可继承实体类？
 *  接口可以继承接口，抽象类可以实现接口，抽象类可以继承实体类
 * 60.可序列化对象为什么要定义SerialVersionUid值?
 *  如果在新版本中这个值修改了，新版本就不兼容旧版本，反序列化时会抛出InvalidClassException异常
 *  如果修改较小，比如仅仅是增加了一个属性，我们希望向下兼容，老版本的数据都能保留，那就不用修改
 *  如果我们删除了一个属性，或者更改了类的继承关系，必然不兼容旧数据，这时就应该手动更新版本号
 * 61.Java程序中创建新的类对象，使用关键字new，回收无用的类对象使用关键字free正确么？
 *  Java程序中创建新的类对象，使用关键字new是正确的; 回收无用的类对象使用关键字free是错误的
 * 62.请解释以下常用正则含义：\d,\D,\s,.,*,?,|,[0-9]{6},\d+
 *  \d: 匹配一个数字字符。等价于[0-9]
 *  \D: 匹配一个非数字字符。等价于[^0-9]
 *  \s: 匹配任何空白字符，包括空格、制表符、换页符等等。等价于 [ \f\n\r\t\v]
 *  .	：匹配除换行符 \n 之外的任何单字符。要匹配 . ，请使用 \.
 *  *：匹配前面的子表达式零次或多次。要匹配 * 字符，请使用 \*
 *  +：匹配前面的子表达式一次或多次。要匹配 + 字符，请使用 \+
 *  |:将两个匹配条件进行逻辑“或”（Or）运算
 *  [0-9]{6}:匹配连续6个0-9之间的数字
 *  \d+：匹配至少一个0-9之间的数字
 **
 * 63.try+finally就算return了也会执行finally
 */
class TryFinally{
    public static void main(String args[]){
        TryFinally t=new TryFinally();
        int b = t.get();
        System.out.println(b);
    }
    private int get(){
        try {
            return 1;
        }finally{
            return 2;
        }
    }
}
/**
 * 64.解释继承、重载、覆盖？
 *  如果一个类A继承了类B，就把这个A称为B的子类，B是A的父类→B是A的超类
 *  子类继承父类的同时，可以重新定义某些属性，并重写某些方法
 *  覆盖重载overload在同一个类中，提供多种实现方式并提高可读性
 *  覆盖重写override在子类中，父类方法无法满足子类的要求，子类通过重写满足要求
 * 65.什么是编译型语言，什么是解释型语言？java可以归类到那种？
 *  JAVA语言是一种编译型-解释型语言，同时具备编译特性和解释特性
 * 66.Java类可以作为类型定义机制和数据封装机制
 * 67.在调用方法时，若要使方法改变实参的值，可以用对象作为参数
 * 68.Java语言具有许多优点和特点，可移植反映了java程序的并行机制
 * 69.构造函数的名字与类的名字相同，并且不能指定返回类型
 * 70.若需要定义一个类域或类方法，应使用哪种修饰符？
 *  static
 **
 * 71.循环指定名字
 */
class ForSName {
    public static void main(String[] args) {
        outer: for (int i = 0; i < 3; i++)
            inner: for (int j = 0; j < 2; j++) {
                if (j == 1)
                    continue outer;
                System.out.println(j + " and " + i);
            }
    }
}
/**
 * 72.如果有两个类A、B（注意不是接口），你想同时使用这两个类的功能，那么你会如何编写这个C类呢？
 *  因为类A、B不是接口，所以是不可以直接实现的
 *  但可以将A、B类定义成父子类，那么C类就能实现A、B类的功能了
 * 73.一个类的构造方法是否可以被重载（overloading），是否可以被子类重写（override）？
 *  构造方法可以被重载，但是构造方法不能被重写，子类也不能继承到父类的构造方法
 * 74.Java中byte表示的数值范围是什么？
 *  范围是-128至127
 **
 * 75.Date与DateFormat与Calender怎么相互转换使用？
 */
class DateCalender{
    public static void main(String[] args) throws ParseException {
        //当前的年份
        System.out.println("当前的年份: "+Calendar.getInstance().get(Calendar.YEAR));
        //1970到现在的毫秒数
        System.out.println("1970到现在的毫秒数: "+Calendar.getInstance().getTimeInMillis());
        //当前时间
        System.out.println("当前时间: "+Calendar.getInstance().getTime());
        //昨天当前时间
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        Date time = cal.getTime();
        System.out.println("昨天当前时间: "+time);
        //转换格式
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("转换格式: "+df.format(time));
        //String→→Date→→Calender
        String str = "2020-11-11 11:11:11";
        Date parse = df.parse(str);
        Calendar cal2 = new GregorianCalendar();
        cal2.setTime(parse);
        System.out.println("String→→Date→→Calender: "+cal2.getTime());
        //Calender→→Date
        System.out.println("Calender→→Date: "+cal2.getTime());
        System.out.println("Calender→→Date+DateFormat: "+df.format(cal2.getTime()));
        //Calender→→Date→→String
        System.out.println("Date→→String: "+cal2.getTime().toString());
        System.out.println("Date→→String+DateFormat: "+df.format(cal2.getTime()));
    }
}
/**
 * 76.对称加密算法、非对称加密算法、单项三列函数的加密算法？
 *  常用的对称加密算法有：DES、3DES、RC2、RC4、AES
 *  常用的非对称加密算法有：RSA、DSA、ECC
 *  使用单向散列函数的加密算法：MD5、SHA
 * 77.String的直接赋值3个，会产生几个对象？
 *  一个对象，因为编译期进行了优化，3个字符串常量直接折叠为一个
 * 78.Math.round(xx)的各种运行情况？
 *  Math.round(11.5)=12
 *  Math.round(-11.5)=-11
 *  Math.round(11.46)=11
 *  Math.round(-11.46)=-11
 *  Math.round(11.68)=12
 *  Math.round(-11.68)=-12
 * 79.System.out.println('a'+1);的结果是？
 *  'a'是char型，1 是int行，int与char相加，char会被强转为int行，char的ASCII码对应的值是97，所以加一起打印98
 * 80.abstract不能修饰字段。既然是抽象方法，当然是没有实现的方法，根本就没有body部分
 * 81.形式参数可以是对象、形式参数为方法被调用时，传递的是实参、形式参数只可被final字段修饰符修饰
 * 82.成员变量用static修饰和不用static修饰有什么区别？
 *  两个变量的生命周期不同：成员变量随着对象的创建而存在，随着对象的被回收而释放；静态变量随着类的加载而存在，随着类的消失而消失
 *  调用方式不同：成员变量只能被对象调用
 *  别名不同：成员变量也称为实例变量；静态变量称为类变量
 *  数据存储位置不同：成员变量数据存储在堆内存的对象中；静态变量数据存储在方法区(共享数据区)的静态区
 *  特有数据(!static)与共享数据(static)
 * 83.面向对象的特征有哪些方面？
 *  抽象
 *  继承
 *  封装
 *  多态性
 *  后面3个被称为java的3大特征
 * 84.short s1=1; s1=s1+1;有错吗?short s1=1; s1+=1;有错吗?
 *  对于short s1=1; s1=s1+1;由于1是int类型，因此s1+1运算结果也是int型，需要强制转换类型才能赋值给short型
 *  而short s1=1; s1+= 1;可以正确编译，因为s1+= 1;相当于s1=(short)(s1+1);其中有隐含的强制类型转换
 * 85.Java的goto是保留字
 **
 * 86.自动拆箱与自动装箱？
 */
class AutoUnboxingTest {
    public static void main(String[] args) {
        Integer a = new Integer(3);
        Integer b = 3;              // 将3自动装箱成Integer类型
        int c = 3;
        System.out.println(a == b); // false 两个引用没有引用同一对象，地址不同
        System.out.println(a == c); // true a自动拆箱成int类型再和c比较，值相同
        //-128~127范围外的不自动拆箱了
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.println(f1 == f2); // true 自动拆箱，值相同
        System.out.println(f3 == f4); // false 没有自动拆箱，地址不同
    }
}
/**
 * 87.switch是否能作用在byte上，是否能作用在long上，是否能作用在String上？
 *  switch(expr)，expr可以是byte、short、char、int、(enum)、(String)
 *  long不行
 * 88.在Java中，如何跳出当前的多重嵌套循环？
 *  在最外层循环前加一个标记如A，然后用break A;可以跳出多重循环
 * 89.两个对象值相同(x.equals(y) == true)，但却可有不同的hash code，这句话对不对？
 *  不对，如果两个对象x和y满足x.equals(y) == true，它们的哈希码（hash code）应当相同
 * 90.当一个对象被当作参数传递到一个方法后，此方法可改变这个对象的属性，并可返回变化后的结果，那么这里到底是值传递还是引用传递？
 *  是值传递。Java 编程语言只有值传递参数
 * 91.重载（Overload）和重写（Override）的区别？重载的方法能否根据返回类型进行区分?
 *  重载（overload）发生在同一个类中，相同的方法
 *  重写（override）发生在子类与父类之间也就是继承机制当中，当父类的方法不能满足子类的要求，此时子类重写父类的方法
 *  重载对返回类型没有特殊的要求
 * 92.为什么不能根据返回类型来区分重载？
 *  不要返回值，直接用方法时无法区分调用的是谁
 **
 * 93.静态嵌套类(Static Nested Class)和内部类（Inner Class）的不同？
 */
class StaticInnerClass{
    public static void main(String[] args) {
        StaticInnerClassTest staticTest = new StaticInnerClassTest();
        staticTest.testVoid();
    }
    private static class StaticInnerClassTest{
        private void testVoid(){
            System.out.println("StaticInnerTest2");
        }
    }
}
class InnerClass{
    public static void main(String[] args) {
        InnerClass InnerClass = new InnerClass();
        InnerClassTest test = InnerClass.new InnerClassTest();
        test.testVoid();
    }
    private class InnerClassTest{
        private void testVoid(){
            System.out.println("InnerClassTest");
        }
    }
}
 /**
 * 94.抽象的（abstract）方法是否可同时是静态的（static）,是否可同时是本地方法（native），是否可同时被synchronized修饰？
 *  都不能。抽象方法需要子类重写，而静态的方法是无法被重写的，因此二者是矛盾的
 *  本地方法是由本地代码（如C代码）实现的方法，而抽象方法是没有实现的，也是矛盾的
 *  synchronized和方法的实现细节有关，抽象方法不涉及实现细节，因此也是相互矛盾的
 * 95.静态变量和实例变量的区别？
 *  静态变量是被static修饰符修饰的变量，也称为类变量，它属于类，不属于类的任何一个对象，一个类不管创建多少个对象，静态变量在内存中有且仅有一个拷贝
 *  实例变量必须依存于某一实例，需要先创建对象然后通过对象才能访问到它，静态变量可以实现让多个对象共享内存
 *  两者的相同点：都有默认值而且在类的任何地方都可以调用
 * 96.是否可以从一个静态（static）方法内部发出对非静态（non-static）方法的调用？
 *  不可以，静态方法只能访问静态成员，因为非静态方法的调用要先创建对象，因此在调用静态方法时可能对象并没有被初始化
 **
 * 97.如何实现对象克隆？深克隆？
 * my:clone方式+序列化方式+Orika框架
 * clone方式性能最高，serializable更易管理维护
 */
class CloneTest{
     public static void main(String[] args) throws CloneNotSupportedException {
         User user = new User(1, "张三", 22);
         UserClone userClone = new UserClone(2, "王五", 23, user);
         UserClone userClone2 = (UserClone) userClone.clone();
         userClone2.getUser().setName("李四"); // 2个的user的name属性都变成了一样，浅克隆
         System.out.println(userClone);
         System.out.println(userClone2);
     }
 }
class CloneDeepTest{
    public static void main(String[] args) throws CloneNotSupportedException {
        User user = new User(1, "张三", 22);
        UserCloneDeep userCloneDeep = new UserCloneDeep(2, "王五", 23, user);
        UserCloneDeep userCloneDeep2 = (UserCloneDeep) userCloneDeep.clone();
        userCloneDeep2.getUser().setName("李四"); //2个user的name属性不一样，深克隆
        System.out.println(userCloneDeep);
        System.out.println(userCloneDeep2);
    }
}
class CloneSerializableTest{
    public static void main(String[] args) throws Exception {
        UserSerializable userS = new UserSerializable(1, "张三", 22);
        UserCloneSerializable userCS = new UserCloneSerializable(2, "王五", 23, userS);
        //用内存实现复制
        UserCloneSerializable userCS2 = CloneSerializableUtil.clone(userCS);
        userCS2.getUserS().setName("李四"); //2个user的name属性不一样，深克隆
        System.out.println(userCS);
        System.out.println(userCS2);
    }
}
class CloneByOrikaCore{
    public static void main(String[] args) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(UserCloneSerializable.class, UserCloneSerializable.class)
                .byDefault().register();
        //ConverterFactory converterFactory = mapperFactory.getConverterFactory();
        MapperFacade mapper = mapperFactory.getMapperFacade();

        UserSerializable userS = new UserSerializable(1, "张三", 22);
        UserCloneSerializable userCS = new UserCloneSerializable(2, "王五", 23, userS);
        UserCloneSerializable userCS2 = mapper.map(userCS, UserCloneSerializable.class);
        userCS2.getUserS().setName("李四"); //2个user的name属性不一样，深克隆
        System.out.println(userCS);
        System.out.println(userCS2);
    }
}
/**
 * 98.接口是否可继承（extends）接口? 抽象类是否可实现（implements）接口? 抽象类是否可继承具体类（concrete class）?
 *  接口可以继承接口
 *  抽象类可以实现(implements)接口
 *  抽象类可以继承具体类
 *  抽象类中可以有静态的main方法
 *  抽象类与普通类的唯一区别就是不能创建实例对象和允许有abstract方法
 * 99.一个“.java”源文件中是否可以包含多个类（不是内部类）？有什么限制？
 *  可以，但一个源文件中最多只能有一个公开类（public class）而且文件名必须和公开类的类名完全保持一致
 * 100.Anonymous Inner Class(匿名内部类)是否可以继承其它类？是否可以实现接口？
 *  可以继承其他类或实现其他接口，在Swing编程中常用此方式来实现事件监听和回调。 但是有一点需要注意，它只能继承一个类或一个接口
 * 101.内部类可以引用它的包含类（外部类）的成员吗？有没有什么限制？
 *  静态内部类、成员内部类、局部内部类、匿名内部类
 *      静态内部类：它只能访问外部类中的static所修饰的成员变量或者是方法
 *      成员内部类：可以访问创建它的外部类对象的成员，包括私有成员
 *      局部内部类：可以直接访问外围类的所有成员，如果要访问外部类的局部变量，此时局部变量必须使用final修饰，否则无法访问
 *      匿名内部类：同局部内部类
 *  注意：当成员内部类拥有和外部类同名的成员变量或者方法时，会发生隐藏现象，即默认情况下访问的是成员内部类的成员
 * 102.说说数据类型之间的转换？
 *  Integer.parseInt("String")
 *  Integer.valueOf("String")
 *  String.valueOf("int")
 **
 * 103.如何实现字符串的反转及替换？
 */
class InversionString{
    public static void main(String[] args) {
        System.out.println(reverse("abc"));
    }
    private static String reverse(String str){
        if (str == null || str.length() <= 1){
            return str;
        }
        return reverse(str.substring(1))+str.charAt(0);
    }
}
/**
 * 104.怎样将GB2312编码的字符串转换为ISO-8859-1编码的字符串？
 *  String s1 = "你好";
 *  String s2 = newString(s1.getBytes("GB2312"), "ISO-8859-1");
 * 105.Java反射技术主要实现类有哪些，作用分别是什么？
 *  Class类：代表一个类
 *  Field 类：代表类的成员变量(属性)
 *  Method类：代表类的成员方法
 *  Constructor 类：代表类的构造方法
 *  Array类：提供了动态创建数组，以及访问数组的元素的静态方法
 * 106.Class类的作用？生成Class对象的方法有哪些？
 *  Class类是Java反射机制的起源和入口，用于获取与类相关的各种信息，提供了获取类信息的相关方法
 *  对象名.getClass()
 *  对象名.getSuperClass()
 *  Class.forName()
 *  类名.class
 *  包装类.TYPE
 * 107.反射的使用场合和作用、及其优缺点
 *  使用场合：在编译时根本无法知道该对象或类可能属于哪些类，程序只依靠运行时信息来发现该对象和类的真实信息
 *  主要作用：获取已装载类的构造方法信息
 *  优点：灵活性、扩展性
 *  确定：性能低、维护复杂
 * 108.面向对象设计原则有哪些
 *  单一职责原则SRP：只能让一个类/接口/方法有且仅有一个职责
 *  开闭原则OCP：对扩展开放、对修改关闭
 *  里氏替代原则LSP：不应该出现if/else之类的判断、继承类应当可以替换基类并出现在基类能够出现的任何地方
 *  依赖注入原则DIP：复杂的模块依赖简单的模块，也可以说是高层模块总是依赖于低层模块
 *  接口分离原则ISP：最小接口原则，接口的设计与被依赖都遵循不能“过胖”
 *  迪米特原则LOD：一个软件实体应当尽可能少地与其他实体发生相互作用、每一个软件单位对其他的单位都只有最少的知识，而且局限于那些与本单位密切相关的软件单位
 *  组合/聚合复用原则CARP：一个组合关系的成分对象是不能与另一个组合关系共享
 * 109.缓存池？
 *  new Integer(123) 与 Integer.valueOf(123) 的区别在于
 *  new Integer(123) 每次都会新建一个对象
 *  Integer.valueOf(123) 会使用缓存池中的对象，多次调用会取得同一个对象的引用
 */






















