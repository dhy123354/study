package com.文件流.字节缓冲流;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class J_1_2字节流复制视频 {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        method01();

        //记录结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("共耗时：" + (endTime - startTime) + "毫秒");

    }

    public static void method01() throws IOException{
        FileInputStream fis = new FileInputStream("D:\\新建文件夹\\报告视频.mp4");
        FileOutputStream fos = new FileOutputStream("D:\\新建文件夹\\字节流\\报告视频.mp4");
        int by;
        while ((by=fis.read())!=-1) {
            fos.write(by);
        }
        fos.close();
        fis.close();
    }
}
