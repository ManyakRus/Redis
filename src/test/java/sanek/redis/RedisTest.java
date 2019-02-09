/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanek.redis;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;
import sanek.redis.models.User;

/**
 *
 * @author Sanek
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    
    private HashOperations hashOperations;
    private SetOperations redisSet;
    private ValueOperations redisValue;
    private ListOperations redisList;
    
    @PostConstruct
    private void init(){
        hashOperations = redisTemplate.opsForHash();
        redisSet = redisTemplate.opsForSet();
        redisValue = redisTemplate.opsForValue();
        redisList = redisTemplate.opsForList();
    }
    
    @Test
    public void add() {
        User user = new User();
        user.setName("name1");
        user.setId("1");
        user.setSalary(100000);
        
        redisValue.set("int1", 100);
        redisValue.increment("int1");
        
        redisList.leftPush("list1", "1");
        redisList.leftPush("list1", "2");
        
        hashOperations.put("users", "user1", user);
        hashOperations.put("users", "1", "11");
        
        redisSet.add("set1", "1", "2");
    }
    
    
    
    @Test
    public void read() {
        
        String s1 = (String) redisValue.get("int1");
        log.info("int1: " + s1);
        
        String s2 = (String) redisList.leftPop("list1");
        log.info("left list1: " + s2);
        
        Long count = redisList.size("list1");
        log.info("list1 size: " + count);
        
//        User user = new User();
//        user.setName("name1");
//        user.setSalary(100000);
        
//        String s = (String) hashOperations.get("s", "1");
//        log.info("user: " + s);
        
        User user = (User) hashOperations.get("users", "user1");
        log.info("user: " + user);
        
        String s3 = (String) hashOperations.get("users", "1");
        log.info("user 1: " + s3);
        
        String s4 = (String) redisSet.pop("set1");
        log.info("set1 1: " + s4);
        
        String s5 = (String) redisSet.pop("set1");
        log.info("set1 2: " + s5);
        
        String s6 = (String) redisSet.pop("set1");
        log.info("set1 3: " + s6);
        
    } 
    
        
    
}
