package com.java.review.gather;

import java.util.*;

public class GatherTest {
}

/**
 * 1.Java集合体系结构（List、Set、Collection、Map的区别和联系）?
 *  Collection 接口存储一组不唯一，无序的对象
 *  List 接口存储一组不唯一，有序（插入顺序）的对象
 *  Set 接口存储一组唯一，无序的对象
 *  Map接口存储一组键值对象，Key无序
 */
class MapStructure{
    public static void main(String[] args) {
        Map map = null;
        Collection collection = null;
        Iterator iterator = null;
        Collections collections = null;
    }
}
/**
 * 2.Iterator迭代器用来干什么的？和普通for、增强for有什么区别吗？
 *  迭代器：遍历方便，删除方便；Iterator只有3个方法：hasNext()、next()、remove()
 *  普通for：遍历时可删除，可修改
 *  for each：遍历最方便，不可编辑。（实际上调用的还是迭代器）
 *  迭代器实际上是给for each使用的，也可以直接使用迭代器，这个效率比普通for要高
 */
class IteratorDiscuss{
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("eee");
        list.add("fff");
        Iterator<String> iterator = list.iterator();
        //遍历方便，删除方便
        while (iterator.hasNext()) {
            String name = iterator.next();
            if (name.equals("ddd")) {
                iterator.remove();
            }
        }
        System.out.println(list.size());
        //普通for：遍历时可删除，可修改
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i);
            if ("bbb".equals(name)) {
                list.remove(list.get(i));
            }
            if("fff".equals(name)){
                list.set(i, "zzz");
            }
        }
        System.out.println(list.size());
        //增强for：遍历方便
        for (String name : list) {
            System.out.println(name);
        }
    }
}
/**
 * 3.Vector和ArrayList的区别和联系？
 *  Vector是早期JDK版本提供，ArrayList是新版本替代Vector的
 *  Vector线程安全，ArrayList重速度轻安全，线程非安全长度需增长时，Vector默认增长一倍，ArrayList增长50%
 *  线程安全的ArrayList：List threadList = Collections.synchronizedList(new ArrayList());
 * 4.ArrayList和LinkedList的区别和联系？
 *  都是有序的
 *  ArrayList实现了长度可变的数组，在内存中分配连续空间。遍历元素和随机访问元素的效率比较高
 *  LinkedList采用链表存储方式。插入、删除元素时效率比较高
 * 5.HashMap和Hashtable的区别和联系？
 *  Hashtable是早期提供的接口，HashMap是新版JDK提供的接口
 *  Hashtable继承Dictionary类，HashMap实现Map接口
 *  Hashtable线程安全，HashMap非线程安全
 *  Hashtable不允许null值，HashMap允许null值
 * 6.HashSet的使用和原理？hashCode()和equals()？
 *  哈希表的查询速度特别快，O(1)
 *  HashMap、Hashtable、HashSet这些集合采用的是哈希表结构，需要用到hashCode哈希码，hashCode是一个整数值
 *  系统类已经覆盖了hashCode方法 自定义类如果要放入hash类集合，必须重写hashcode。如果不重写，调用的是Object的hashcode，而Object的hashCode实际上是地址
 *  向哈希表中添加数据的原理：当向集合Set中增加对象时，首先集合计算要增加对象的hashCode码，根据该值来得到一个位置用来存放当前对象，如在该位置没有一个对象存在的话，那么集合Set认为该对象在集合中不存在，直接增加进去。如果在该位置有一个对象存在的话，接着将准备增加到集合中的对象与该位置上的对象进行equals方法比较，如果该equals方法返回false,那么集合认为集合中不存在该对象，在进行一次散列，将该对象放到散列后计算出的新地址里。如果equals方法返回true，那么集合认为集合中已经存在该对象了，不会再将该对象增加到集合中了
 *  在哈希表中判断两个元素是否重复要使用到hashCode()和equals()。hashCode决定数据在表中的存储位置，而equals判断是否存在相同数据
 *  Y=K(X) ：K是函数，X是哈希码，Y是地址
 * 7.TreeSet的原理和使用？Comparable和comparator？
 *  TreeSet集合，元素不允许重复且有序(自然顺序)
 *  TreeSet采用树结构存储数据，存入元素时需要和树中元素进行对比，需要指定比较策略
 *  可以通过Comparable(外部比较器)和Comparator(内部比较器)来指定比较策略，实现了Comparable的系统类可以顺利存入TreeSet。自定义类可以实现Comparable接口来指定比较策略
 *  可创建Comparator接口实现类来指定比较策略，并通过TreeSet构造方法参数传入。这种方式尤其对系统类非常适用
 * 8.集合和数组的比较？为什么引入集合？
 *  数组不是面向对象的，集合比数组更灵活更实用，可大大提高软件的开发效率而且不同的集合框架类可适用于不同场合
 *  数组能存放基本数据类型和对象，而集合类中只能放对象
 *  数组容量固定且无法动态改变，集合类容量动态改变
 *  数组无法判断其中实际存有多少元素，length只告诉了array的容量
 *  集合有多种实现方式和不同的适用场合，而不像数组仅采用顺序表方式
 *  集合以类的形式存在，具有封装、继承、多态等类的特性，通过简单的方法和属性调用即可实现各种复杂操作，大大提高软件的开发效率
 * 9.Collection和Collections的区别？
 *  Collection是接口，存储一组不唯一，无序的对象。它有两个子接口List和Set
 *  Collections类，专门用来操作集合类，它提供一系列静态方法实现对各种集合的搜索、排序、线程安全化等操作
 * 10.Java的HashMap和Hashtable有什么区别HashSet和HashMap有什么区别？使用这些结构保存的数需要重载的方法是哪些？
 *  HashMap与Hashtable实现原理相同，功能相同，底层都是哈希表结构，查询速度快，在很多情况下可以互用
 *  HashSet底层是采用HashMap实现的。因此HashSet和HashMap两个集合在实现本质上是相同的
 *  HashMap的key就是放进HashSet中对象，value是Object类型的
 *  当调用HashSet的add方法时，实际上是向HashMap中增加了一行(key-value对)，该行的key就是向HashSet增加的那个对象，该行的value就是一个Object类型的常量
 * 11.列出Java中的集合类层次结构？
 * 12.List，Set，Map各有什么特点？
 *  List 接口存储一组不唯一，有序（插入顺序）的对象
 *  接口存储一组唯一，无序的对象
 *  Map接口存储一组键值对象，提供key到value的映射。key无序，唯一。value不要求有序，允许重复
 * 13.ArrayList list=new ArrayList(20);中的list扩充几次？
 *  0次，已经指定了长度, 所以不扩容
 **
 * 14.合并两个有序的链表？
 */
class OrderNodeLinkTest{
    public static void main(String[] args) {
        OrderNodeLink orderNodeLink = new OrderNodeLink();
        orderNodeLink.insertNode(1, "1");
        orderNodeLink.insertNode(2, "2");
        orderNodeLink.insertNode(10, "3");
        orderNodeLink.insertNode(5, "4");
        orderNodeLink.insertNode(3, "5");
        orderNodeLink.displayList();
    }
}
class CombineLinked {
    public static void main(String[] args) {
        OrderNodeLink orderNodeLink = new OrderNodeLink();
        orderNodeLink.insertNode(1, "1");
        orderNodeLink.insertNode(2, "2");
        orderNodeLink.insertNode(10, "3");
        orderNodeLink.insertNode(5, "4");
        orderNodeLink.insertNode(3, "5");
        System.out.println(orderNodeLink.length);

        OrderNodeLink orderNodeLink2 = new OrderNodeLink();
        orderNodeLink2.insertNode(8, "6");
        orderNodeLink2.insertNode(7, "7");
        orderNodeLink2.insertNode(4, "8");
        orderNodeLink2.insertNode(6, "9");
        orderNodeLink2.insertNode(9, "10");
        orderNodeLink2.insertNode(11, "11");

        OrderNodeLink orderNodeLink3 = mergeTwoLists(orderNodeLink, orderNodeLink2);
        orderNodeLink3.displayList();
    }
    private static OrderNodeLink mergeTwoLists(OrderNodeLink l1, OrderNodeLink l2) {
        if (l1 == null || l2 == null) {
            return l1 != null ? l1 : l2;
        }
        // 长度大作为l1
        if (l1.length<l2.length){
            OrderNodeLink ll = l1;
            l1 = l2;
            l2 = ll;
        }
        // 有序的合并
        Node l2CurrencyNode = l2.first;
        while (l2CurrencyNode != null){
            l1.insertNode(l2CurrencyNode.getOrder(), l2CurrencyNode.getValue());
            l2CurrencyNode = l2CurrencyNode.getNext();
        }
        return l1;
    }
}
/**
 * 15.用递归的方式实现链表的转置？
 */
class ReversLinked{
    public static void main(String[] args) {
        OrderNodeLink orderNodeLink = new OrderNodeLink();
        orderNodeLink.insertNode(1, "1");
        orderNodeLink.insertNode(2, "2");
        orderNodeLink.insertNode(10, "3");
        orderNodeLink.insertNode(5, "4");
        orderNodeLink.insertNode(3, "5");

        Node node = reverseList(orderNodeLink.first);
        System.out.println(node);
        System.out.println(node.getNext());
        System.out.println(node.getNext().getNext());
        System.out.println(node.getNext().getNext().getNext());
        System.out.println(node.getNext().getNext().getNext().getNext());
    }
    private static Node reverseList(Node node) {
        // 链表为空是时反转为空
        if (node==null || node ==null){
            return node;
        }
        // 把当前节点与下一个节点取出，放入到了java栈
        Node currencyNode = node;
        Node nextNode = currencyNode.getNext();
        // 把当前节点的链接清除掉
        currencyNode.setNext(null);
        // 递归退出条件
        if (nextNode==null){
            return currencyNode;
        }
        // 返回最后一个节点
        Node reverseNode = reverseList(nextNode);
        // 拿到节点最后的位置，如果已经是，直接赋值
        if (reverseNode.getNext() != null){
            Node reverseLast = reverseNode.getNext();
            while (reverseLast.getNext() != null){
                reverseLast = reverseLast.getNext();
            }
            reverseLast.setNext(currencyNode);
        }else {
            reverseNode.setNext(currencyNode);
        }
        // 返回最后一个节点
        return reverseNode;
    }
}
/**
 * 16.给定一个不包含相同元素的整数集合，nums，返回所有可能的子集集合。解答中集合不能包含重复的子集？
 */
class ListSon{
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 8};
        List<List<Integer>> list = subsets(nums);
        System.out.println(list);
    }
    private static List<List<Integer>> subsets (int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> item = new ArrayList<Integer>();
        if(nums.length == 0 || nums == null){
            return res;
        }
        Arrays.sort(nums); //排序
        dfs(nums, 0, item, res);  //递归调用
        res.add(new ArrayList<Integer>());  //最后加上一个空集
        return res;
    }
    private static void dfs(int[] nums, int start, List<Integer> item, List<List<Integer>> res){
        for(int i = start; i < nums.length; i ++){
            item.add(nums[i]);
            //item是以整数为元素的动态数组，而res是以数组为元素的数组，在这一步，当item增加完元素后，item所有元素构成一个完整的子串，再由res纳入
            res.add(new ArrayList<Integer>(item));
            dfs(nums, i + 1, item, res);
            item.remove(item.size() - 1);
        }
    }
}
/**
 * 17.ConcurrentHashMap是Java中的一个线程安全且高效的HashMap实现，涉及高并发使用
 * 18.WeakHashMap的详细理解？
 *  和HashMap一样，WeakHashMap也是一个散列表，它存储的内容也是键值对(key-value)映射，而且键和值都可以是null
 *  和HashMap一样，WeakHashMap是不同步的
 *  当某个键不再正常使用时，会被从WeakHashMap中被自动移除
 * 19.既然有WeakHashMap，那么有WeakHashSet吗？
 *  我们可以通过Collections.newSetFromMap(Map<E,Boolean> map)方法可以将任何 Map包装成一个Set
 * 20.Map的实现类中，哪些是有序的，哪些是无序的，有序的是如何保证其有序性，你觉得哪个有序性性能更高，你有没有更好或者更高效的实现方式？
 *  Map的常用实现类有HashMap,LinkedHashMap,TreeMap
 *  HashMap是有无序的，LinkedHashMap和TreeMap都是有序的（LinkedHashMap记录了添加数据的顺序；TreeMap默认是自然升序）
 *  LinkedHashMap底层存储结构是哈希表+链表，链表记录了添加数据的顺序
 *  TreeMap底层存储结构是二叉树，二叉树的中序遍历保证了数据的有序性
 *  LinkedHashMap有序性能比较高，因为底层数据存储结构采用的哈希表
 * 21.在synchronized阻塞wait()时，外层if最好换成while
 * 22.TreeMap和TreeSet在排序时如何比较元素？Collections工具类中的sort（）方法如何比较元素？
 *  TreeSet要求存放的对象所属的类必须实现Comparable接口，该接口提供了比较元素的compareTo()方法，当插入元素时会 回调该方法比较元素的大小
 *  TreeMap要求存放的键值对映射的键必须实现Comparable接口从而根据键对元素进行排序
 **
 * 23.List里面如何剔除相同的对象？请简单用代码实现一种方法？
 */
class DelBySame {
    public static void main(String[] args) {
        List<String> li1 = new ArrayList<>();
        li1.add("8");
        li1.add("8");
        li1.add("9");
        li1.add("9");
        li1.add("0");
        System.out.println(li1);
        //方法:将List中数据取出来来存到Set中
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<li1.size();i++){
            set.add(li1.get(i));
        }
        System.out.println(set);
    }
}
/**
 * 24.Java.util.Map的实现类有？
 *  HashMap、Hashtable、LinkedHashMap、TreeMap
 * 25.循环队列中元素的个数是由队首指针和队尾指针共同决定的，元素的动态变化也是通过队首指针和队尾指针来反映的，当队首等于队尾时，队列为空
 * 26.List、Set、Map 是否继承自Collection 接口？
 *  List、Set 的父接口是Collection，Map 不是其子接口，而是与Collection接口是平行关系，互不包含
 * 27.说出ArrayList、Vector、LinkedList 的存储性能和特性？
 *  ArrayList和Vector都是使用数组方式存储数据
 *  它们都允许直接按序号索引元素，但是插入元素要涉及数组元素移动等内存操作，所以索引数据快而插入数据慢
 *  Vector由于使用了synchronized 方法（线程安全），通常性能上较ArrayList差
 *  LinkedList使用双向链表实现存储，插入速度较快
 *  ArrayList和LinkedListed都是非线程安全的
 * 28.List、Map、Set 三个接口，存取元素时，各有什么特点？
 *  List以特定索引来存取元素，可有重复元素，Set不能存放重复元素，Map保存键值对（key-value pair）映射，映射关系可以是一对一或多对一
 *  Set和Map容器都有基于哈希存储和排序树（红黑树）的两种实现版本
 *  基于哈希存储的版本理论存取时间复杂度为O(1)，而基于排序树版本的实现在插入或删除元素时会按照元素或元素的键（key）构成排序树从而达到排序和去重的效果
 * 29.TreeMap和TreeSet在排序时如何比较元素？Collections工具类中的sort()方法如何比较元素？
 *  TreeSet要求存放的对象所属的类必须实现Comparable接口，该接口提供了比较元素的compareTo()方法，当插入元素时会回调该方法比较元素的大小
 *  TreeMap要求存放的键值对映射的键必须实现Comparable接口从而根据键对元素进行排序
 */
class Student implements Comparable<Student> {
    private String name;        // 姓名
    private int age;            // 年龄
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }
    @Override
    public int compareTo(Student o) {
        return this.age - o.age; // 比较年龄(年龄的升序)，加个-号就是降序
    }
}
class TreeSetTest {
    public static void main(String[] args) {
        Set<Student> set = new TreeSet<>();     // Java 7的钻石语法(构造器后面的尖括号中不需要写类型)
        set.add(new Student("Hao LUO", 33));
        set.add(new Student("XJ WANG", 32));
        set.add(new Student("Bruce LEE", 60));
        set.add(new Student("Bob YANG", 22));
        set.add(new Student("Bob YANG", 22));
        for(Student stu : set) {
            System.out.println(stu);
        }
    }
}
class Student2 {
    private String name;    // 姓名
    private int age;        // 年龄
    public Student2(String name, int age) {
        this.name = name;
        this.age = age;
    }
    /**
     * 获取学生姓名
     */
    public String getName() {
        return name;
    }
    /**
     * 获取学生年龄
     */
    public int getAge() {
        return age;
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }
}
class SortListByInstantiation {
    public static void main(String[] args) {
        List<Student2> list = new ArrayList<>();     // Java 7的钻石语法(构造器后面的尖括号中不需要写类型)
        list.add(new Student2("Hao LUO", 33));
        list.add(new Student2("XJ WANG", 32));
        list.add(new Student2("Bruce LEE", 60));
        list.add(new Student2("Bob YANG", 22));
        list.sort(new Comparator<Student2>() {
            @Override
            public int compare(Student2 o1, Student2 o2) {
                return o1.getName().compareTo(o2.getName());    // 比较学生姓名，如果比较age：o1.getAge() - o2.getAge()
            }
        });
        /*Collections.sort(list, new Comparator<Student2> () {
            @Override
            public int compare(Student2 o1, Student2 o2) {
                return o1.getName().compareTo(o2.getName());    // 比较学生姓名
            }
        });*/
        for(Student2 stu : list) {
            System.out.println(stu);
        }
    }
}























