package com.atguigu;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;

/**
 * 颜色redis集群操作
 */
public class RedisClusterDemo {
    public static void main(String[] args) throws IOException {
        //创建对象
        HostAndPort hostAndPort = new HostAndPort("192.168.43.28", 6379);
        JedisCluster jedisCluster = new JedisCluster(hostAndPort,2000,200,5,"qq1802702683",new GenericObjectPoolConfig());
        //进行操作
        jedisCluster.set("b1", "value1");
        String value = jedisCluster.get("b1");
        System.out.println("value:"+value);
        jedisCluster.close();
    }
}
