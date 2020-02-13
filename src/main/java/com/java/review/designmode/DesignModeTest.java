package com.java.review.designmode;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DesignModeTest {
}

/**
 * 1.设计模式的种类？有哪些？
 *  创建型模式：
 *      单例模式、工厂模式、抽象工厂模式、建造者模式、原型模式
 *  结构型模式：
 *      适配器模式、桥接模式、装饰模式、组合模式、外观模式、享元模式、代理模式
 *  行为模式：
 *      模板方法模式、命令模式、跌代器模式、观察者模式、中介模式、备忘录模式、解释器模式、状态模式、策略模式、职责链模式、访问者模式
 * 2.单例模式实现？
 *  饿汉式、懒汉式、双重检测锁式(不建议使用)、静态内部类式、枚举单例
 */
//饿汉式
class SingletonDemo1 {
    //类初始化时，立即加载这个对象（没有延时加载的优势）。加载类时，天然的是线程安全的！
    private static SingletonDemo1 instance = new SingletonDemo1();
    private SingletonDemo1(){
    }
    //方法没有同步，调用效率高！
    public static SingletonDemo1  getInstance(){
        return instance;
    }
}
//懒汉式
class SingletonDemo2 {
    //类初始化时，不初始化这个对象（延时加载，真正用的时候再创建）。
    private static SingletonDemo2 instance;
    private SingletonDemo2(){ //私有化构造器
    }
    //方法同步，调用效率低！
    public static SingletonDemo2  getInstance() {
        if (instance != null) {
            return instance;
        }
        synchronized (SingletonDemo2.class) {
            if (instance == null) {
                instance = new SingletonDemo2();
            }
            return instance;
        }
    }
}
//静态内部类式
class SingletonDemo4 {
    private static class SingletonClassInstance {
        private static final SingletonDemo4 instance = new SingletonDemo4();
    }
    private SingletonDemo4(){
    }
    //方法没有同步，调用效率高！
    public static SingletonDemo4  getInstance(){
        return SingletonClassInstance.instance;
    }
}
//枚举单例
enum SingletonDemo5 {
    //这个枚举元素，本身就是单例对象！
    INSTANCE;
    //添加自己需要的操作！
    public void singletonOperation(){
    }
}
/**
 * 3.反序列化可以作为clone，如果设置反序列化返回的是同一个对象，如何实现？
 */
class SingletonDemo6Test{
    public static void main(String[] args) throws Exception {
        SingletonDemo6 s1 = SingletonDemo6.getInstance();
        SingletonDemo6 s2 = SingletonDemo6.getInstance();
        System.out.println(s1); // 同一对象
        System.out.println(s2); // 同一对象

        //通过反序列化的方式构造多个对象
        FileOutputStream fos = new FileOutputStream("d:/a.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s1);
        oos.close();
        fos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/a.txt"));
        SingletonDemo6 s3 =  (SingletonDemo6) ois.readObject();
        System.out.println(s3); // 同一对象
    }
}
class SingletonDemo6 implements Serializable {
    //类初始化时，不初始化这个对象（延时加载，真正用的时候再创建）。
    private static SingletonDemo6 instance;
    private SingletonDemo6(){ //私有化构造器
    }
    //方法同步，调用效率低！
    public static  synchronized SingletonDemo6  getInstance(){
        if(instance==null){
            instance = new SingletonDemo6();
        }
        return instance;
    }
    //反序列化时，如果定义了readResolve()则直接返回此方法指定的对象。而不需要单独再创建新对象！
    private Object readResolve() throws ObjectStreamException {
        return instance;
    }
}
/**
 * 4.工厂模式、适配器模式、代理模式、模板方法模式是重点，简述？
 *  工厂模式：工厂类可以根据条件生成不同的子类实例，这些子类有一个公共的抽象父类并且实现了相同的方法，但是这些方法针对不同的数据进行了不同的操作（多态方法）
 *  代理模式：给一个对象提供一个代理对象，并由代理对象控制原对象的引用
 *  适配器模式：把一个类的接口变换成客户端所期待的另一种接口，从而使原本因接口不匹配而无法在一起使用的类能够一起工作
 *  模板方法模式：提供一个抽象类，将部分逻辑以具体方法或构造器的形式实现，然后声明一些抽象方法来迫使子类实现剩余的逻辑
 **
 * 5.工厂模式详细？如何实现？
 *  简单工厂、工厂方法、抽象工厂
 */
//简单工厂
class CarFactory {
    public static  Car createAudi(){
        return new Audi();
    }
    public static  Car createByd(){
        return new Byd();
    }
}
//工厂方法
interface CarFactoryMethod {
    Car createCar();
}
class AudiFactory implements CarFactoryMethod {
    @Override
    public Car createCar() {
        return new Audi();
    }
}
class BenzFactory implements CarFactoryMethod {
    @Override
    public Car createCar() {
        return new Benz();
    }
}
class BydFactory implements CarFactoryMethod {
    @Override
    public Car createCar() {
        return new Byd();
    }
}
//抽象工厂
interface Tyre {
    void revolve();
}
class LuxuryTyre implements Tyre {
    @Override
    public void revolve() {
        System.out.println("旋转不磨损！");
    }
}
class LowTyre implements Tyre {
    @Override
    public void revolve() {
        System.out.println("旋转磨损快！");
    }
}
interface Seat {
    void massage();
}
class LuxurySeat implements Seat {
    @Override
    public void massage() {
        System.out.println("可以自动按摩！");
    }
}
class LowSeat implements Seat {
    @Override
    public void massage() {
        System.out.println("不能按摩！");
    }
}
interface Engine {
    void run();
    void start();
}
class LuxuryEngine implements Engine{
    @Override
    public void run() {
        System.out.println("转的快！");
    }
    @Override
    public void start() {
        System.out.println("启动快!可以自动启停！");
    }
}
class LowEngine implements Engine{
    @Override
    public void run() {
        System.out.println("转的慢！");
    }
    @Override
    public void start() {
        System.out.println("启动慢!");
    }
}
interface CarFactoryAbstract {
    Engine createEngine();
    Seat createSeat();
    Tyre createTyre();
}
class LowCarFactory implements CarFactoryAbstract {
    @Override
    public Engine createEngine() {
        return new LowEngine();
    }
    @Override
    public Seat createSeat() {
        return new LowSeat();
    }
    @Override
    public Tyre createTyre() {
        return new LowTyre();
    }
}
class LuxuryCarFactory implements CarFactoryAbstract {
    @Override
    public Engine createEngine() {
        return new LuxuryEngine();
    }
    @Override
    public Seat createSeat() {
        return new LuxurySeat();
    }
    @Override
    public Tyre createTyre() {
        return new LuxuryTyre();
    }
}
/**
 * 6.适配器模式如何实现？
 */
//客户端使用的接口标准(不能修改)
interface Target {
    void handleReq();
}
//客户端使用，需要某个功能但只有Target接口(不能修改)
class AdaptedClient {
    public void test1(Target t){
        t.handleReq();
    }
    public static void main(String[] args) {
        AdaptedClient  c = new AdaptedClient();
        Adapted a = new Adapted();
        Target t = new Adapter2(a);
        c.test1(t);
    }
}
//需要的功能不是Target接口(不能修改)
class Adapted {
    public void request(){
        System.out.println("可以完成客户请求的需要的功能！");
    }
}
//适配器，解决没有接口的问题
class Adapter2  implements Target {
    private Adapted adapted;
    @Override
    public void handleReq() {
        adapted.request();
    }
    public Adapter2(Adapted adapted) {
        super();
        this.adapted = adapted;
    }
}
/**
 * 7.代理模式详细？如何实现？
 *  静态代理、动态代理
 */
//静态代理
//所有的标准
interface Star {
    //面谈
    void confer();
    //签合同
    void signContract();
    //订票
    void bookTicket();
    //唱歌
    void sing();
    //收钱
    void collectMoney();
}
class RealStar implements Star {
    @Override
    public void bookTicket() {
        System.out.println("RealStar.bookTicket()");
    }
    @Override
    public void collectMoney() {
        System.out.println("RealStar.collectMoney()");
    }
    @Override
    public void confer() {
        System.out.println("RealStar.confer()");
    }
    @Override
    public void signContract() {
        System.out.println("RealStar.signContract()");
    }
    @Override
    public void sing() {
        System.out.println("RealStar(明星本人).sing()");
    }
}
class ProxyStar implements Star {
    private Star star;
    public ProxyStar(Star star) {
        super();
        this.star = star;
    }
    @Override
    public void bookTicket() {
        System.out.println("ProxyStar.bookTicket()");
    }
    @Override
    public void collectMoney() {
        System.out.println("ProxyStar.collectMoney()");
    }
    @Override
    public void confer() {
        System.out.println("ProxyStar.confer()");
    }
    @Override
    public void signContract() {
        System.out.println("ProxyStar.signContract()");
    }
    @Override
    public void sing() {
        star.sing();
    }
}
//雇佣方
class ProxyClient {
    public static void main(String[] args) {
        Star real = new RealStar();
        Star proxy = new ProxyStar(real);
        proxy.confer();
        proxy.signContract();
        proxy.bookTicket();
        proxy.sing();
        proxy.collectMoney();
    }
}
//动态代理
class StarHandler implements InvocationHandler {
    Star realStar;
    public StarHandler(Star realStar) {
        super();
        this.realStar = realStar;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        Object object = null;
        System.out.println("真正的方法执行前！");
        System.out.println("面谈，签合同，预付款，订机票");
        if(method.getName().equals("sing")){
            object = method.invoke(realStar, args);
        }
        System.out.println("真正的方法执行后！");
        System.out.println("收尾款");
        return object;
    }
}
//雇佣方
class DynamicProxyClient {
    public static void main(String[] args) {
        Star realStar = new RealStar();
        StarHandler handler = new StarHandler(realStar);
        Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Star.class}, handler);
        proxy.sing();
        proxy.bookTicket();
    }
}
/**
 * 8.模板方法模式如何实现？
 */
abstract class BankTemplateMethod {
    //具体方法
    public void takeNumber(){
        System.out.println("取号排队");
    }
    public abstract void transact(); //办理具体的业务	//钩子方法
    public void evaluate(){
        System.out.println("反馈评分");
    }
    public final void process(){	//模板方法！！！
        this.takeNumber();
        this.transact();
        this.evaluate();
    }
}
class DrawMoney extends BankTemplateMethod {
    @Override
    public void transact() {
        System.out.println("我要取款！！！");
    }
}
class TemplateClient {
    public static void main(String[] args) {
        //方法1：
        BankTemplateMethod btm = new DrawMoney();
        btm.process();
        //方法2：采用匿名内部类
        BankTemplateMethod btm2 = new BankTemplateMethod() {
            @Override
            public void transact() {
                System.out.println("我要存钱！");
            }
        };
        btm2.process();
    }
}
/**
 * 9.说说你所熟悉或听说过的设计模式以及你对设计模式的看法？
 *  根据GOF的23种设计模式，分为3大类：创建型、结构型、行为型
 *  创建型模式：
 *      单例模式、工厂模式、抽象工厂模式、建造者模式、原型模式
 *  结构型模式：
 *      适配器模式、桥接模式、装饰模式、组合模式、外观模式、享元模式、代理模式
 *  行为模式：
 *      模板方法模式、命令模式、跌代器模式、观察者模式、中介模式、备忘录模式、解释器模式、状态模式、策略模式、职责链模式、访问者模式
 * 10.Java企业级开发中常用的设计模式有哪些？
 *  表层设计模式：
 *      Interceptor Filter：拦截过滤器
 *      Front Controller：通过中央控制器提供请求管理和处理
 *      View Helper：视图帮助器
 *      Composite View：复合视图
 *  业务逻辑层设计模式：
 *      Business Delegate：业务委托，减少表示层和业务逻辑层之间的耦合
 *      Value Object：值对象，解决层之间交换数据的开销问题
 *      Session Facade：会话门面，隐藏业务逻辑组件的细节，集中工作流程
 *      Value Object Assembler：灵活的组装不同的值对象
 *      Value List Handler：提供执行查询和处理结果的解决方案，还可以缓存查询结果，从而达到提升性能的目的
 *      Service Locator：服务定位器，可以查找、创建和定位服务工厂，封装其实现细节，减少复杂性，提供单个控制点，通过缓存提高性能
 *  持久层设计模式：
 *      Data Access Object：数据访问对象，以面向对象的方式完成对数据的增删改查
 * 11.什么是设计模式，设计模式的作用？
 *  设计模式是经过分类编目的优秀代码设计经验的总结，是特定环境下特定问题的处理方法
 *  是针对面对对象的7大原则的实现
 * 12.你在开发中都用到了那些设计模式？用在什么场合？
 * 13.请对你所熟悉的一个设计模式进行介绍？
 */



















