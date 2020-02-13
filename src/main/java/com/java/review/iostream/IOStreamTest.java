package com.java.review.iostream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IOStreamTest {
}

/**
 * 1.节点流与处理流是什么？
 *  节点流：直接从数据源或目的地读写数据
 *  处理流(包装流)：通过封装提高性能
 * 2.字节流与字符流是什么？
 *  按字节读写还是按字符读写
 *  字符流继承了字节流，有编码解码的操作
 * 3.File用法？
 *  File src = new File(path)：建立一个对象，如果存在path文件则使用，不存在就新建
 *  名称：src.getName()
 * 	路径：src.getPath()
 * 	绝对路径：src.getAbsolutePath()
 * 	父路径：src.getParent()
 * 	父对象：src.getParentFile().getName()
 *	是否存在：src.exists()
 * 	是否文件：src.isFile()
 * 	是否文件夹：src.isDirectory()
 *  创建新文件：src.createNewFile()
 *  删除文件：src.delete()
 *  File dir = new File("D:/java300/IO_study01/dir/test");
 *  创建目录：dir.mkdirs()
 *  下级对象：dir.listFiles()
 *  所有盘符：dir.listRoots()
 *  各个系统都能用的地址分割符：File.separator
 *      path ="D:"+File.separator+"java300"+File.separator+"IO_study01"+File.separator+"IO.png"
 * 4.如何编码，再解码？
 *  String msg ="自定义"
 *  编码，如果不指定则使用工程的字符集：msg.getBytes("utf-8")
 *  解码：new String(msg.getBytes("utf-8"),"utf8")
 **
 * 5.如何读取所有的下级文件？如何统计文件夹大小？
 */
//所有的下级文件
class LowerDir {
    public static void main(String[] args) {
        File src =  new File("E:\\杂物");
        printName(src,0);
    }
    //打印打印子孙级目录和文件的名称
    private static void printName(File src,int deep) {
        //控制前面层次
        for(int i=0;i<deep;i++) {
            System.out.print("-");
        }
        //打印名称
        System.out.println(src.getName());
        if(null==src || !src.exists()) {  //递归头
            return ;
        }else if(src.isDirectory()) { //目录
            for(File s:src.listFiles()) {
                printName(s,deep+1); //递归体
            }
        }
    }
}
//文件夹大小(byte)
class SizeDir {
    public static void main(String[] args) {
        File src =  new File("E:\\杂物");
        count(src);
        System.out.println(len);
    }
    private static long len =0;
    public static void count(File src) {
        //获取大小
        if(null!=src && src.exists()) {
            if(src.isFile()) {  //大小
                len+=src.length();
            }else { //子孙级
                for(File s:src.listFiles()) {
                    count(s);
                }
            }
        }
    }
}
/**
 * 6.磁盘的读取文件的步骤？磁盘的写出文件的步骤？
 *  创建源(File)、选择流(FileInputStream)、操作(read)、释放资源(close)
 *  创建源(File)、选择流(FileOutputStream)、操作(write+flush)、释放资源(close)
 * 7.FileInputStream的read用法？
 *  InputStream is = new FileInputStream(src)
 *  is.read()，不指定时为1个字符一个字符的读取
 *  is.read(flush)，其中flush是一个byte[]，指定一次存多少到flush，byte[] flush = new byte[1024*10]
 * 8.内存的读取文件步骤？内存的写出文件步骤？
 *  创建源(byte[])、选择流(ByteArrayInputStream)、操作(read)、释放资源(close)
 *  创建源(byte[])、选择流(ByteArrayOutputStream)、操作(write+flush)、释放资源(close)
 **
 * 9.磁盘-->磁盘，磁盘-->内存，内存-->磁盘？
 */
class FileUtilsTest{
    public static void main(String[] args) {
        //文件到文件，磁盘-->磁盘
        try {
            InputStream is = new FileInputStream("abc.txt");
            OutputStream os = new FileOutputStream("abc-copy.txt");
            MyFileUtils.copy(is,os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //文件到字节数组，磁盘-->内存
        byte[] datas = null;
        try {
            InputStream is = new FileInputStream("p.png");
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            MyFileUtils.copy(is,os);
            datas = os.toByteArray();
            System.out.println(datas.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //字节数组到文件，内存-->磁盘
        try {
            InputStream is = new ByteArrayInputStream(datas);
            OutputStream os = new FileOutputStream("p-copy.png");
            MyFileUtils.copy(is,os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/**
 * 10.缓冲流 的作用？为什么要用？
 *  处理流(装饰流)
 *  BufferedInputStream、BufferedOutputStream、BufferedReader、BufferedWriter套在字节字符流外面
 *  通过更大的打包，一次读写更多来提高性能
 *  他们是处理流，套在节点流的外层，分别是：
 *      FileInputStream、FileOutputStream、FileReader、FileWriter
 * 11.转换流 的作用是什么？为什么要用？
 *  处理流(装饰流)
 *  InputStreamReader、OutputStreamWriter在缓冲流与字节字符流之间
 *  InputStreamReader字节流转换为字符流
 *  OutputStreamWriter字符流转换为字节流
 *  字符流有更多的方法操作字符，更方便，有时候字节流需要转换为字符流来操作
 * 12.数据流 的作用是什么？为什么要用？
 *  处理流(装饰流)
 *  DataInputStream、DataOutputStream套在缓冲流外
 *  DataInputStream：xxx.writeUTF("内容")，xxx.writeChar("内容")
 *  DataOutputStream：xxx.readUTF()，xxx.readChar()
 *  操作基本数据类型和字符串，能保存数据类型，不用强转
 * 13.对象流 的作用是什么？为什么要用？
 *  处理流(装饰流)
 *  ObjectInputStream、ObjectOutputStream套在字节缓冲流外
 *  ObjectInputStream：xxx.readObject("对象")
 *  ObjectOutputStream：xxx.writeObject("对象")
 *  也称反序列化、序列化，包含了数据流的功能
 * 14.打印流 的作用是什么？为什么要用？
 *  处理流(装饰流)
 *  PrintStream套在：File外面、输出流外面、String外面
 *  控制台打印，常用的System.out.println()就是打印流
 * 15.随机流 的作用是什么？为什么要用？
 *  处理流(装饰流)
 *  RandomAccessFile读写都是这个，操作与字节流一样，套在File外面
 *  xxx.seek(int a)，a是开始的位置，读取剩余的所有内容
 *  虽然读取只能设置起始位置，但是写出xxx.write(new byte[1024], 0, end)有end设置，能实现分块
 * 16.序列流 是什么？
 *  SequenceInputStream同时操作多个流
 *  把多个流放入Vector<InputStream> vi; SequenceInputStream(vi.elements())当做一个字节流用
 *  通常用来合并文件或者批量操作
 * 17.Java中如何实现序列化，有什么意义？
 *  序列化就是一种用来处理对象流的机制，所谓对象流也就是将对象的内容进行流化
 *  可以保存当前对象的状态
 **
 * 18.写一个方法，输入一个文件名和一个字符串，统计这个字符串在这个文件中出现的次数？
 */
class CountChar {
    // 工具类中的方法都是静态方式访问的因此将构造器私有不允许创建对象(绝对好习惯)
    private CountChar() {
        throw new AssertionError();
    }
    //统计给定文件中给定字符串的出现次数
    //@param filename  文件名
    //@param word 字符串
    //@return 字符串在文件中出现的次数
    public static int countWordInFile(String filename, String word) {
        int counter = 0;
        try (FileReader fr = new FileReader(filename)) {
            try (BufferedReader br = new BufferedReader(fr)) {
                String line = null;
                while ((line = br.readLine()) != null) {
                    int index = -1;
                    while (line.length() >= word.length() && (index = line.indexOf(word)) >= 0) {
                        counter++;
                        line = line.substring(index + word.length());
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return counter;
    }
}
/**
 * 19.输入流和输出流联系和区别，节点流和处理流联系和区别？
 *  输入流是得到数据，输出流是输出数据
 *  节点流，可以从或向一个特定的地方(节点)读写数据
 *  处理流是对一个已存在的流的连接和封装，通过所封装的流的功能调用实现数据读写
 * 20.字符流字节流联系区别；什么时候使用字节流和字符流？
 *  字符流和字节流是按处理照流的数据单位进行的划分
 *  字符流处理的单元为2个字节的Unicode字符，分别操作字符、字符数组或字符串
 *  字节流处理单元为1个字节，操作字节和字节数组
 * 21.列举常用字节输入流和输出流并说明其特点？
 *  字节流：FileInputStream、FileOutputStream
 *  字符流：FileReader、FileWriter
 *  字节数组流：ByteArrayInputStream、ByteArrayOutputStream
 *  缓冲流：BufferedInputStream、BufferedOutputStream
 *  转换流：InputStreamReader、OutputStreamWriter
 *  数据流、对象流、打印流、随机流、序列流
 * 22.说明缓冲流的优点和原理？
 *  不带缓冲的流的工作原理：它读取到一个字节/字符
 *  带缓冲的流的工作原理：读取到一个字节/字符，先不输出，等凑足了缓冲的最大容量后一次性写出去
 * 23.序列化的定义、实现和注意事项？
 *  流对象才能在内存、硬盘、网络中传输
 *  实现接口Serializable
 *  如果对象中的某个属性是对象类型，必须也实现Serializable接口才可以，序列化对静态变量无效
 *  如果不希望某个属性参与序列化，不是将其static，而是transient串行化保存的只是变量的值，对于变量的任何修饰符，都不能保存序列化版本不兼容
 * 24.说说BIO、NIO和AIO的区别
 *  Java BIO：同步并阻塞，服务器实现模式为一个连接一个线程，即客户端有连接请求时服务器端就需要启动一个线程进行处理，如果这个连接不做任何事情会造成不必要的线程开销，当然可以通过线程池机制改善
 *  Java NIO：同步非阻塞，服务器实现模式为一个请求一个线程，即客户端发送的连接请求都会注册到多路复用器上，多路复用器轮询到连接有I/O请求时才启动一个线程进行处理
 *  Java AIO：异步非阻塞，服务器实现模式为一个有效请求一个线程，客户端的I/O请求都是由OS先完成了再通知服务器应用去启动线程进行处理
 *  NIO比BIO的改善之处是把一些无效的连接挡在了启动线程之前，减少了这部分资源的浪费（因为我们都知道每创建一个线程，就要为这个线程分配一定的内存空间）
 *  AIO比NIO的进一步改善之处是将一些暂时可能无效的请求挡在了启动线程之前，比如在NIO的处理方式中，当一个请求来的话，开启线程进行处理，但这个请求所需要的资源还没有就绪，此时必须等待后端的应用资源，这时线程就被阻塞了
 **
 * 25.流操作commons框架？
 */
class CIOTest01 {
    public static void main(String[] args) {
        //文件大小
        long len = FileUtils.sizeOf(new File("E:\\杂物\\毕业论文\\1.png"));
        System.out.println(len);
        //目录大小
        len = FileUtils.sizeOf(new File("E:\\杂物"));
        System.out.println(len);
    }
}
class CIOTest02 {
    public static void main(String[] args) {
        Collection<File> files =FileUtils.listFiles(new File("E:\\杂物"),
                EmptyFileFilter.NOT_EMPTY, null);
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
        System.out.println("---------------------");
        files =FileUtils.listFiles(new File("E:\\杂物"),
                EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
        System.out.println("---------------------");
        files =FileUtils.listFiles(new File("E:\\杂物"),
                new SuffixFileFilter("java"), DirectoryFileFilter.INSTANCE);
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
        System.out.println("---------------------");
        files =FileUtils.listFiles(new File("E:\\杂物"),
                FileFilterUtils.or(new SuffixFileFilter("java"),
                        new SuffixFileFilter("class"),EmptyFileFilter.EMPTY), DirectoryFileFilter.INSTANCE);
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
        System.out.println("---------------------");
        files =FileUtils.listFiles(new File("E:\\杂物"),
                FileFilterUtils.and(new SuffixFileFilter("java"),
                        EmptyFileFilter.NOT_EMPTY), DirectoryFileFilter.INSTANCE);
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }
}
//读取文件
class CIOTest03 {
    public static void main(String[] args) throws IOException {
        //读取文件
        String msg =FileUtils.readFileToString(new File("emp.txt"),"UTF-8");
        System.out.println(msg);
        byte[] datas = FileUtils.readFileToByteArray(new File("emp.txt"));
        System.out.println(datas.length);
        //逐行读取
        List<String> msgs= FileUtils.readLines(new File("emp.txt"),"UTF-8");
        for (String string : msgs) {
            System.out.println(string);
        }
        LineIterator it =FileUtils.lineIterator(new File("emp.txt"),"UTF-8");
        while(it.hasNext()) {
            System.out.println(it.nextLine());
        }
    }
}
//写出内容
class CIOTest04 {
    public static void main(String[] args) throws IOException {
        //写出文件
        FileUtils.write(new File("happy.sxt"), "学习是一件伟大的事业\r\n","UTF-8");
        FileUtils.writeStringToFile(new File("happy.sxt"), "学习是一件辛苦的事业\r\n","UTF-8",true);
        FileUtils.writeByteArrayToFile(new File("happy.sxt"), "学习是一件幸福的事业\r\n".getBytes("UTF-8"),true);
        //写出列表
        List<String> datas =new ArrayList<String>();
        datas.add("马云");
        datas.add("马化腾");
        datas.add("弼马温");
        FileUtils.writeLines(new File("happy.sxt"), datas,"。。。。。",true);
    }
}
//拷贝
class CIOTest05 {
    public static void main(String[] args) throws IOException {
        //复制文件
        //FileUtils.copyFile(new File("p.png"),new File("p-copy.png"));
        //复制文件到目录
        //FileUtils.copyFileToDirectory(new File("p.png"),new File("lib"));
        //复制目录到目录
        //FileUtils.copyDirectoryToDirectory(new File("lib"),new File("lib2"));
        //复制目录
        //FileUtils.copyDirectory(new File("lib"),new File("lib2"));
        //拷贝URL内容
        //String url = "https://pic2.zhimg.com/v2-7d01cab20858648cbf62333a7988e6d0_qhd.jpg";
        //FileUtils.copyURLToFile(new URL(url), new File("marvel.jpg"));
        String datas = IOUtils.toString(new URL("http://www.163.com"), "gbk");
        System.out.println(datas);
    }
}




























