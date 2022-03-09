package com.文件流.字节缓冲流;

import java.io.*;

public class J_1_1字节缓冲流构造方法  {
    public static void main(String[] args) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new
                FileOutputStream("D:\\新建文件夹\\李萍.txt"));

        bos.write("他是我心中的人\r\n".getBytes());
        bos.write("我再也没有\r\n".getBytes());

        bos.close();

//        BufferedOutputStream bos1 = new BufferedOutputStream(new
//                FileOutputStream("D:\\新建文件夹\\李乐鑫.txt"));
//        bos1.write("一个不值得相恋的人\r\n".getBytes());
//        bos1.write("是一个好朋友\r\n".getBytes());

        BufferedInputStream bis = new BufferedInputStream(new
                FileInputStream("D:\\新建文件夹\\李萍.txt"));

//        int by;
//        while ((by=bis.read())!=-1){
//            System.out.println((char)by);
//        }

        byte[] bys = new byte[1024];
        int len;
        while ((len = bis.read(bys))!= -1){
            System.out.println(new String(bys,0,len));
        }

        bis.close();
    }
}
