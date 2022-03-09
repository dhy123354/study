package cn.itcast.test;

import cn.itcast.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class JacksonTest {

    //Java对象转为JSON字符串
    @Test
    public void test1() throws Exception {
        //1.创建Person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");

        //2.创建JackSon的核心对象 ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //3.转化
        /*
        * 转化方法
        *
        * */
        String json = mapper.writeValueAsString(p);
        //{"name":"张三“，”age“:23,”gender“:"男"}
        //System.out.println(json);


        //writeValue,将数据写到D://a.txt文件中
        //mapper.writeValue(new File("d://a.txt"),p);

        //writeValue,将数据关联到writer中
        mapper.writeValue(new FileWriter("d://b.txt"),p );
    }

    @Test
    public void test2() throws Exception {
        //1.创建Person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());



        //2.转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(p);

        System.out.println(json);//{"name":"张三","age":23,"gender":"男","birthday":1530958029263}
        //{"name":"张三","age":23,"gender":"男","birthday":"2018-07-07"}
    }

    @Test
    public void test3() throws Exception {
        //1.创建Person对象
        //1.创建Person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());

        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(23);
        p1.setGender("男");
        p1.setBirthday(new Date());

        Person p2 = new Person();
        p2.setName("张三");
        p2.setAge(23);
        p2.setGender("男");
        p2.setBirthday(new Date());



        //2.创建List集合
        List<Person> ps = new ArrayList<>();
        ps.add(p);
        ps.add(p1);
        ps.add(p2);

        //3.转化
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(ps);

        System.out.println(json);
    }

    @Test
    public void test4() throws Exception {
        //1.创建Person对象
        //1.创建map对象
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","张三");
        map.put("age",23);
        map.put("gender","男");


        //2.转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        //{"name":"张三","age":23,"gender":"男"}
        System.out.println(json);//{"gender":"男","name":"张三","age":23}

    }

}
