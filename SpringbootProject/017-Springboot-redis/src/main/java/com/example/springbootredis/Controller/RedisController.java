package com.example.springbootredis.Controller;

import com.example.springbootredis.vo.Student;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RedisController {

    /*注入RedisTemplate
     * RedisTemplate 泛型
     * RedisTemplate<String,String>
     * RedisTemplate<Object,Object>
     * RedisTemplate
     * 注意:RedisTemplate对象的名称 redisTemplate
     * */
    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /*添加数据到redis*/
    @PostMapping("/redis/addstring")
    public String addToRedis(String name, String value) {
        /*操作Redis中String类型的数据,先获取ValueOperations对象*/
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("myname", "lisi");
        return "向redis添加String类型的数据";
    }

    /*从redis获取数据*/
    @GetMapping("/redis/getKey")
    public String getData(String key) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Object value = valueOperations.get(key);
        return "key是" + key + ",它的值是:" + value;
    }

    @PostMapping("/redis/{key}/{value}")
    public String addStringKV(@PathVariable String key, @PathVariable String value) {
        /*使用StringRedisTemplate对象*/
        stringRedisTemplate.opsForValue().set(key, value);
        return "使用StringRedisTemplate对象";
    }

    @GetMapping("redis/getstr/{key}")
    public String getStringValue(@PathVariable String key) {
        String value = stringRedisTemplate.opsForValue().get(key);
        return "key的value:" + value;
    }

    /*设置RedisTemplate序列化
     * 可以设置key的序列化,可以设置value的序列化
     * 可以同时设置key和value的序列化
     * */
    @PostMapping("/redis/addstr")
    public String addString(String key, String value) {
        /*使用RedisTemplate,设置key使用String的序列化*/
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        /*设置 value 的序列化*/
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.opsForValue().set(key, value);
        return "定义RedisTemplate对象的key,value的序列化";
    }

    /*使用json序列化,把Java对象转为json存储*/
    @PostMapping("/redis/addJson")
    public String addJson() {
        Student student = new Student();
        student.setId(1001);
        student.setName("Morries_Wu");
        student.setAge(18);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        /*要把值作为json序列化*/
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(Student.class));
        redisTemplate.opsForValue().set("mystudent", student);
        return "Json序列化";
    }

    @PostMapping("/redis/getJson")
    public String getJson() {
        Student student = new Student();
        student.setId(1001);
        student.setName("Morries_Wu");
        student.setAge(18);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        /*要把值作为json序列化*/
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(Student.class));
        Object mystudent = redisTemplate.opsForValue().get("mystudent");
        return "Json反序列化" + mystudent;
    }

}
