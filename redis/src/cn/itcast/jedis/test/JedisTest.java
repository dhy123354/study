package cn.itcast.jedis.test;

import cn.itcast.jedis.test.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Jedis������
 */
public class JedisTest {

    /**
     * ��������
     */
    @Test
    public void test1(){
        //1.��ȡ����
        Jedis jedis = new Jedis("localhost",6379);
        //2.����
        jedis.set("username","liyueixin");
        //3.�ر�����
        jedis.close();
    }

    /**
     * string ���ݽṹ����
     */
    @Test
    public void test2(){
        //1.��ȡ����
        Jedis jedis = new Jedis("localhost",6379);
        //2.����
        jedis.set("username", "liyueixin");
        //��ȡ
        String username = jedis.get("username");
        System.out.println(username);

        //����ʹ��setex()�����洢����ָ������ʱ���key value
        jedis.setex("activecode",20,"liping");
        //3.�ر�����
        jedis.close();
    }

    /**
     * hash ���ݽṹ����
     */
    @Test
    public void test3(){
        //1.��ȡ����
        Jedis jedis = new Jedis("localhost",6379);
        //2.����
        jedis.hset("user","name","bufeiyan");
        jedis.hset("user","age","23");
        jedis.hset("user","gender","male");

        //��ȡhash
        String s = jedis.hget("user", "name");
        System.out.println(s);

        //��ȡhash������map�е�����
        Map<String,String> user = jedis.hgetAll("user");

        //keyset
        Set<String> keyset = user.keySet();
        for (String key : keyset){
            //��ȡvalue
            String value = user.get(key);
            System.out.println(key + ":" + value);
        }
        //3.�ر�����
        jedis.close();
    }

    /**
     * List ���ݽṹ����
     */
    @Test
    public void test4(){
        //1.��ȡ����
        Jedis jedis = new Jedis("localhost",6379);
        //2.����
        jedis.lpush("mylist1","a","b","c");
        jedis.rpush("mylist1","a","b","c");


        //list ��Χ��ȡ
        List<String> mylist = jedis.lrange("mylist1",0,-1);
        System.out.println(mylist);

        //list ����
        String element1 = jedis.lpop("mylist1");
        System.out.println(element1);

        String element2 = jedis.rpop("mylist1");//c
        System.out.println(element2);

        // list ��Χ��ȡ
        List<String> mylist2 = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist2);
        //3.�ر�����
        jedis.close();
    }

    /**
     * SET ���ݽṹ����
     */
    @Test
    public void test5(){
        //1.��ȡ����
        Jedis jedis = new Jedis("localhost",6379);
        //2.����
        jedis.sadd("myset","����Դ","php","c++");

        //set ��ȡ
        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);

        //3.�ر�����
        jedis.close();
    }

    /**
     * sorttedset ���ݽṹ����
     */
    @Test
    public void test6(){
        //1.��ȡ����
        Jedis jedis = new Jedis("localhost",6379);
        //2.����
        jedis.zadd("mysort",3,"a");
        jedis.zadd("mysort",5,"b");
        jedis.zadd("mysort",34,"c");

        //set ��ȡ
        Set<String> mysort = jedis.zrange("mysoet", 0, 2);
        System.out.println(mysort);
        //3.�ر�����
        jedis.close();
    }

    /**
     * jedis ���ӳ�ʹ��
     */
    @Test
    public void test7(){
        //0.����һ�����ö���
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(500);
        config.setMaxIdle(10);

        //1.����jedis���ӳض���
        JedisPool jedisPool = new JedisPool(config,"localhost",6379);

        //2.��ȡ����
        Jedis jedis = jedisPool.getResource();
        //3.ʹ��
        jedis.set("haha","������");

        //4. �ر� �黹�����ӳ���
        jedis.close();
    }

    /**
     * jedis ���ӳع�����ʹ��
     */
    @Test
    public void test8(){
        //ͨ�����ӳع������ȡ
        Jedis jedis = JedisPoolUtils.getJedis();
        //3.ʹ��
        jedis.set("haha","world");
        jedis.set("dinghuiyuan","lanqiao");
        jedis.del("dinghuiyuan");
        String haha = jedis.get("haha");
        jedis.hset("user","name","lisi");
        jedis.hset("user","age","123");
        jedis.hset("user","gender","female");
        System.out.println(haha);

        //4. �ر� �黹�����ӳ���
        jedis.close();
    }
}
