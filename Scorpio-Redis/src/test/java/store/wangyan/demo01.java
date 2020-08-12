package store.wangyan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import store.wangyan.utils.RedisUtil;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class demo01 {

    private static int ExpireTime = 60;   // redis中存储的过期时间60s

    @Resource
    private RedisUtil redisUtil;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void redisSet(){
         redisUtil.set("asdf","123456");
        
    }
    @Test
    public void redisGet(){
      Object obj =   redisUtil.get("asdf");
    }



    @Test
    public void test01(){

        redisTemplate.opsForValue().set("aaaa","1111");

    }

}
