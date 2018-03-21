package com.zcyjy.interview.service.impl;

import com.zcyjy.interview.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.TreeSet;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataObtainServiceImplTest {
    @Autowired
    DataObtainServiceImpl dataObtainService;
    @Test
    public void init() throws Exception {
        dataObtainService.init();
        User user = new User();
        user.setLoginname("c");
        TreeSet<User> users = dataObtainService.find(user);
        System.out.println("------------>"+users);
    }

    @Test
    public void add() throws Exception {
        User user = new User();
        user.setLoginname("c");
        user.setId(111L);
        dataObtainService.add(user);
        TreeSet<User> users = dataObtainService.find(user);
        System.out.println("------------>"+users);
    }

    @Test
    public void del() throws Exception {
        User user = new User();
        user.setLoginname("c");
        dataObtainService.del(user);
        TreeSet<User> users = dataObtainService.find(null);
        System.out.println("------------>"+users);
    }

    @Test
    public void find() throws Exception {
        User user = new User();
        user.setLoginname("c");
        TreeSet<User> users = dataObtainService.find(user);
        System.out.println("------------>"+users);
    }

}