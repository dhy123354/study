package com.文件流.IO流案例.复制单级文件夹;

import java.io.*;

public class CopyFolderDemo {
    public static void main(String[] args) throws IOException {
        File srcFolder = new File("D:\\新建文件夹");

        String srcFolderName = srcFolder.getName();

        File destFolder = new File("D:\\新建文件夹\\字节流",srcFolderName);

        //判断目的地目录对应的File是否存在，如果不存在，就创建
        if(!destFolder.exists()) {
            destFolder.mkdir();
        }

        File[] listFiles = srcFolder.listFiles();

        for(File srcFile : listFiles) {

            String srcFileName = srcFile.getName();

            File destFile = new File(destFolder,srcFileName);

            copyFile(srcFile,destFile);
        }
    }

    private static void copyFile(File srcFile, File destFile) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new
                FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new
                FileOutputStream(destFile));
        byte[] bys = new byte[1024];
        int len;
        while ((len=bis.read(bys))!=-1) {
            bos.write(bys,0,len);
        }
        bos.close();
        bis.close();
    }
}
