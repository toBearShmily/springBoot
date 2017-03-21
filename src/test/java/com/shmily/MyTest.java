package com.shmily;

import com.shmily.model.User;
import com.shmily.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2017/2/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MyTest {
    @Resource
    private UserService userService;

    @Test
    public void test(){
        List<User> list = userService.allUser();
        list.stream().forEach(System.out::println);
    }
}
