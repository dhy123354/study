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
 * Jedis测试类
 */
public class JedisTest {

    /**
     * 快速入门
     */
    @Test
    public void test1(){
        //1.获取链接
        Jedis jedis = new Jedis("localhost",6379);
        //2.操作
        jedis.set("username","liyueixin");
        //3.关闭链接
        jedis.close();
    }

    /**
     * string 数据结构操作
     */
    @Test
    public void test2(){
        //1.获取链接
        Jedis jedis = new Jedis("localhost",6379);
        //2.操作
        jedis.set("username", "liyueixin");
        //获取
        String username = jedis.get("username");
        System.out.println(username);

        //可以使用setex()方法存储可以指定过期时间的key value
        jedis.setex("activecode",20,"liping");
        //3.关闭链接
        jedis.close();
    }

    /**
     * hash 数据结构操作
     */
    @Test
    public void test3(){
        //1.获取链接
        Jedis jedis = new Jedis("localhost",6379);
        //2.操作
        jedis.hset("user","name","bufeiyan");
        jedis.hset("user","age","23");
        jedis.hset("user","gender","male");

        //获取hash
        String s = jedis.hget("user", "name");
        System.out.println(s);

        //获取hash的所有map中的数据
        Map<String,String> user = jedis.hgetAll("user");

        //keyset
        Set<String> keyset = user.keySet();
        for (String key : keyset){
            //获取value
            String value = user.get(key);
            System.out.println(key + ":" + value);
        }
        //3.关闭链接
        jedis.close();
    }

    /**
     * List 数据结构操作
     */
    @Test
    public void test4(){
        //1.获取链接
        Jedis jedis = new Jedis("localhost",6379);
        //2.操作
        jedis.lpush("mylist1","a","b","c");
        jedis.rpush("mylist1","a","b","c");


        //list 范围获取
        List<String> mylist = jedis.lrange("mylist1",0,-1);
        System.out.println(mylist);

        //list 弹出
        String element1 = jedis.lpop("mylist1");
        System.out.println(element1);

        String element2 = jedis.rpop("mylist1");//c
        System.out.println(element2);

        // list 范围获取
        List<String> mylist2 = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist2);
        //3.关闭链接
        jedis.close();
    }

    /**
     * SET 数据结构操作
     */
    @Test
    public void test5(){
        //1.获取链接
        Jedis jedis = new Jedis("localhost",6379);
        //2.操作
        jedis.sadd("myset","丁慧源","php","c++");

        //set 获取
        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);

        //3.关闭链接
        jedis.close();
    }

    /**
     * sorttedset 数据结构操作
     */
    @Test
    public void test6(){
        //1.获取链接
        Jedis jedis = new Jedis("localhost",6379);
        //2.操作
        jedis.zadd("mysort",3,"a");
        jedis.zadd("mysort",5,"b");
        jedis.zadd("mysort",34,"c");

        //set 获取
        Set<String> mysort = jedis.zrange("mysoet", 0, 2);
        System.out.println(mysort);
        //3.关闭链接
        jedis.close();
    }

    /**
     * jedis 连接池使用
     */
    @Test
    public void test7(){
        //0.创建一个配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(500);
        config.setMaxIdle(10);

        //1.创建jedis连接池对象
        JedisPool jedisPool = new JedisPool(config,"localhost",6379);

        //2.获取连接
        Jedis jedis = jedisPool.getResource();
        //3.使用
        jedis.set("haha","李乐鑫");

        //4. 关闭 归还到连接池中
        jedis.close();
    }

    /**
     * jedis 连接池工具类使用
     */
    @Test
    public void test8(){
        //通过连接池工具类获取
        Jedis jedis = JedisPoolUtils.getJedis();
        //3.使用
        jedis.set("haha","world");
        jedis.set("dinghuiyuan","lanqiao");
        jedis.del("dinghuiyuan");
        String haha = jedis.get("haha");
        jedis.hset("user","name","lisi");
        jedis.hset("user","age","123");
        jedis.hset("user","gender","female");
        System.out.println(haha);

        //4. 关闭 归还到连接池中
        jedis.close();
    }
}
