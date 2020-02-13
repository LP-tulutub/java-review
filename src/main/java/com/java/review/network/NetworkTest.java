package com.java.review.network;

import java.io.*;
import java.net.*;

public class NetworkTest {
}

/**
 * 1.IP地址和端口号？
 *  IP地址：用来标志网络中的一个通信实体的地址
 *  IP地址分类：IPV4、IPV6
 *  特殊的IP地址：127.0.0.1 本机地址；192.168.0.0--192.168.255.255私有地址，属于非注册地址，专门为组织机构内部使用
 *  端口：端口范围0---65535
 *  端口分类：公认端口0—1023、注册端口1024—49151分配给用户进程或应用程序、动态/私有端口 49152--65535
 *  理解IP和端口的关系：IP地址好比每个人的地址、端口好比是房间号
 * 2.介绍OSI七层模型和TCP/IP模型？
 *  OSI(Open System Interconnection)，开放式系统互联参考模型，是一个逻辑上的定义，一个规范
 *  TCP/IP协议是Internet最基本的协议
 *  ISO制定的OSI参考模型的过于庞大
 * 3.TCP协议和UDP协议的比较？
 *  TCP和UDP是TCP/IP协议栈中传输层的两个协议
 *  TCP的server和client之间通信就好比两个人打电话、UDP的server和client之间的通信就像两个人互相发信
 *  TCP是面向连接的传输，UDP是无连接的传输
 *  TCP有流量控制、拥塞控制，检验数据数据按序到达，而UDP则相反
 *  TCP的路由选择只发生在建立连接的时候，而UDP的每个报文都要进行路由选择
 *  TCP是可靠性传输，他的可靠性是由超时重发机制实现的，而UDP则是不可靠传输
 *  UDP因为少了很多控制信息，所以传输速度比TCP速度快
 *  TCP适合用于传输大量数据，UDP适合用于传输小量数据
 * 4.什么是Socket编程？
 *  socket通常也称作"套接字"，用于描述IP地址和端口，是一个通信链的句柄
 *  Socket实际是传输层供给应用层的编程接口，Socket就是应用层与传输层之间的桥梁
 *  应用程序只要将数据交给Socket，就算完成了数据的发送
 * 5.简述基于TCP和UDP的Socket编程的主要步骤？
 *  TCP服务端：
 *      构建一个ServerSocket实例，指定本地的端口。这个socket就是用来监听指定端口的连接请求的
 *      调用socket的accept()方法来获得下面客户端的连接请求，通过accept()方法返回的socket实例，建立了一个和客户端的新连接
 *      通过这个返回的socket实例获取InputStream和OutputStream,可以通过这两个stream来分别读和写数据
 *      结束的时候调用socket实例的close()方法关闭socket连接
 *  TCP客户端：
 *      构建Socket实例，通过指定的远程服务器地址和端口来建立连接
 *      通过Socket实例包含的InputStream和OutputStream来进行数据的读写
 *      操作结束后调用socket实例的close方法，关闭
 *  UDP服务端：
 *      构造DatagramSocket实例，指定本地端口
 *      通过DatagramSocket实例的receive方法接收DatagramPacket.DatagramPacket中间就包含了通信的内容
 *      通过DatagramSocket的send和receive方法来收和发DatagramPacket
 *  客户端：
 *      构造DatagramSocket实例
 *      通过DatagramSocket实例的send和receive方法发送DatagramPacket报文
 *      结束后，调用DatagramSocket的close方法关闭
 */
class IPTest{
    public static void main(String[] args) throws Exception {
        //使用getLocalHost方法创建InetAddress对象  本机
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println(addr.getHostAddress());  //返回：192.168.1.110
        System.out.println(addr.getHostName());  //输出计算机名

        //根据域名得到InetAddress对象
        addr = InetAddress.getByName("www.shsxt.com");
        System.out.println(addr.getHostAddress());  //返回 shsxt服务器的ip:
        System.out.println(addr.getHostName());  //输出：www.shsxt.com

        //根据ip得到InetAddress对象
        addr = InetAddress.getByName("123.56.138.176");
        System.out.println(addr.getHostAddress());  //返回 shsxt的ip:123.56.138.176
        System.out.println(addr.getHostName());  //输出ip而不是域名。如果这个IP地 址不存在或DNS服务器不允许进行IP地址和域名的映射，
    }
}
class PortTest{
    public static void main(String[] args) {
        //包含端口
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1",8080);
        InetSocketAddress socketAddress2 = new InetSocketAddress("localhost",9000);
        System.out.println(socketAddress.getHostName());
        System.out.println(socketAddress.getAddress());
        System.out.println(socketAddress2.getAddress());
        System.out.println(socketAddress2.getPort());
    }
}
class SpiderTest{
    public static void main(String[] args) throws Exception {
        //获取URL
        URL url =new URL("https://www.dianping.com");
        //下载资源
        HttpURLConnection conn =(HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36");
        BufferedReader br =new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
        String msg =null;
        while(null!=(msg=br.readLine())) {
            System.out.println(msg);
        }
        br.close();
        //分析
        //处理。。。。
    }
}
class URLTest {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://www.baidu.com:80/index.html?uname=shsxt&age=18#a");
        //获取四个值
        System.out.println("协议:"+url.getProtocol());
        System.out.println("域名|ip:"+url.getHost());
        System.out.println("端口:"+url.getPort());
        System.out.println("请求资源1:"+url.getFile());
        System.out.println("请求资源2:"+url.getPath());
        //参数
        System.out.println("参数:"+url.getQuery());
        //锚点
        System.out.println("锚点:"+url.getRef());
    }
}
//TCP
class FileServer {
    public static void main(String[] args) throws IOException {
        System.out.println("-----Server-----");
        // 1、指定端口 使用ServerSocket创建服务器
        ServerSocket server =new ServerSocket(8888);
        // 2、阻塞式等待连接 accept
        Socket  client =server.accept();
        System.out.println("一个客户端建立了连接");
        // 3、操作: 文件拷贝 存储
        InputStream is =new BufferedInputStream(client.getInputStream());
        OutputStream os =new BufferedOutputStream(new FileOutputStream("src/tcp.png"));
        byte[] flush =new byte[1024];
        int len = -1;
        while((len=is.read(flush))!=-1) {
            os.write(flush,0,len);
        }
        os.flush();
        //3、释放资源
        os.close();
        is.close();
        // 4、释放资源
        client.close();
        server.close();
    }
}
class FileClient {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("-----Client-----");
        //1、建立连接: 使用Socket创建客户端 +服务的地址和端口
        Socket client =new Socket("localhost",8888);
        //2、操作: 拷贝 上传
        InputStream is =new BufferedInputStream(new FileInputStream("src/ndl.png"));
        OutputStream os =new BufferedOutputStream(client.getOutputStream());
        byte[] flush =new byte[1024];
        int len = -1;
        while((len=is.read(flush))!=-1) {
            os.write(flush,0,len);
        }
        os.flush();
        //3、释放资源
        os.close();
        is.close();
        client.close();
    }
}
















