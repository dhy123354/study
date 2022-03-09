package com.文件流.Properties集合;

import java.util.Properties;
import java.util.Set;

public class Properties作为Map集合的使用 {
    public static void main(String[] args) {
        //创建集合对象
        Properties prop = new Properties();

        //存储元素
        prop.setProperty("itheima001", "林青霞");
        prop.setProperty("itheima002", "张曼玉");
        prop.setProperty("itheima003", "王祖贤");
        //Set<String> stringPropertyNames()：从该属性列表中返回一个不可修改的键集，其中键及其对应的值是字符串
        Set<String> names = prop.stringPropertyNames();
        for (String key : names) {
        // System.out.println(key);
            String value = prop.getProperty(key);
            System.out.println(key + "," + value);
        }
    }
}
