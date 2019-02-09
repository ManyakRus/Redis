/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanek.redis;

import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Sanek
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ResourceTest {
    
    @Value("${spring.redis.host}")
    private String host;
    
    @Test
    public void showHost() {
        log.info("host: " + host);
    }
}
