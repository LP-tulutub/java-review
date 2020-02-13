package com.java.review.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {
}

/**
 * 1.this在实例对象的用法？
 */
class ThisVoid {
    public static void main(String[] args) {
        ThisVoid ex=new ThisVoid();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str+"and");
        System.out.print(ex.ch);
    }
    String str=new String("good");
    char [] ch={'a','b','c'};
    private void change(String  str,char ch[]){
        str="test ok"; // 不能修改新建对象的str，修改的是原来的str，如果修改当前的加上this.
        ch[0]='g'; // 指向的是一个空间，当前与原来都共用这个，所以不用this.也能修改
    }
}
/**
 * 2.String[] s=new String[10];中s默认值为null
 **
 * 3.实现String类的replaceAll方法？
 */
class MyReplaceAll {
    public static void main(String[] args) {
        String str = "a1s2d3f4h5j6k7";
        // 将字符串中的数字全部替换为0
        System.out.println(replaceAll(str, "\\d", "0"));
    }
     // @param str:源字符串
     // @param regex:正则表达式
     // @param newStr:替换后的子字符串
     // @return 返回替换成功后的字符串
    private static String replaceAll(String str, String regex, String newStr) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        String result = matcher.replaceAll(newStr);
        return result;
    }
}
/**
 * 4.String[] a=new String[10]与int[] b=new int[10]有什么不同？
 *  a[0]~a[9]=null，b[0]~b[9]=0
 * 5.是否可以继承String类?
 *  不可以，因为String类有final修饰符
 **
 * 6.给定两个字符串s和t， 写一个函数来决定是否t是s的重组词。你可以假设字符串只包含小写字母？
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(isAnagram("abc", "cba"));
    }
    private static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        // 代表26个小字母的位置
        int bit[] = new int[26];
        // 统计每个小字母个数
        for(int i=0;i<s.length();i++){
            bit[s.charAt(i)-'a']++;
        }
        // 判断2个字符转的小字母个数是否相同，只要有一个不同立马返回false
        for(int i=0;i<s.length();i++){
            if(--bit[t.charAt(i)-'a']<0)
                return false;
        }
        return true;
    }
}
/**
 * 7.String s=new String("abc");创建了几个String对象？
 *  两个或一个，new String("abc")在Java堆，String s在Java栈，abc在常量池(方法区)
 *  使用String s=new String("abc")时常量池有abc则创建1个，否则2个
 * 8.字符串如何转换为int类型？
 *  int num=Integer.parseInt("123");
 *  int num2=Integer.valueOf("123");
 **
 * 9.用循环实现字符串反转？
 */
class StrReverse{
    public static void main(String[] args) {
        String result=reverse("abc");
        System.out.println(result);
    }
    private static String reverse(String str){
        StringBuilder result=new StringBuilder("");
        char[] chArr=str.toCharArray();
        for (int i=chArr.length-1; i>=0; i--){
            char ch=chArr[i];
            result.append(ch);
        }
        return result.toString();
    }
}
/**
 * 10.编写java，将"I follow Bill Gate.Tom Gate.John Gate"中的"Gate"全部替换为"Gates"？
 * 11.String 是最基本的数据类型吗?
 *  不是
 *  基本数据类型：byte、short、int、long、float、double、char、boolean
 *  除了基本类型（primitive type）和枚举类型（enumeration type），剩下的都是引用类型（reference type）
 * 12..String 和StringBuilder、StringBuffer 的区别?
 *  它们都可以储存和操作字符串，同时三者都使用final修饰，都属于终结类不能派生子类
 *  其中String是只读字符串，也就意味着String引用的字符串内容是不能被改变的
 *  StringBuilder和StringBuffer的方法完全相同，区别在于StringBuilder是在单线程环境下使用的，没有synchronized，效率更高
 */
class smallT {
    public static void main(String[] args) {
        String a = "Programming";
        String b = new String("Programming");
        String c = "Program" + "ming";
        System.out.println(a == b); //false
        System.out.println(a == c); //true
        System.out.println(a.equals(b)); //true
        System.out.println(a.equals(c)); //true
        System.out.println(a.intern() == b.intern()); //true 相当于a.equals(b)
    }
}
/**
 * 13.String类为什么是final的？
 *  为了效率。若允许被继承，则其高度的被使用率可能会降低程序的性能
 *  为了安全
 * 14.String类型是基本数据类型吗？基本数据类型有哪些？
 *  基本数据类型包括byte、short/char、int、long、float、double、boolean
 *   java.lang.String类是引用数据类型，为了提高效率节省空间，我们应该用StringBuffer类
 * 15.String s="Hello";s=s+"world!";执行后，是否是对前面s指向空间内容的修改？
 *  不是对前面s指向空间内容的直接修改
 * 16.String s = new String("xyz");创建几个String Object?
 *  1个或2个
 * 17.下面这条语句一共创建了多少个对象：String s="a"+"b"+"c"+"d"
 *  1个
 *  javac编译可以对字符串常量直接相加的表达式进行优化，不必要等到运行期去进行加法运算处理，而是在编译时去掉其中的加号，直接将其编译成一个这些常量相连的结果
 *  注意：String s1 = "a";String s2 = s1 + "b";System.out.println(s2 == "ab");结果是false，s2相当于new了一个String
 *
 */
































