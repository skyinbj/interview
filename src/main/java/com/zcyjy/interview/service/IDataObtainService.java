package com.zcyjy.interview.service;

import com.zcyjy.interview.data.UserData;
import com.zcyjy.interview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.TreeSet;
import java.util.Vector;

public interface IDataObtainService {

    public void add(User user);
    public void del(User user);
    public TreeSet<User> find();
    public TreeSet<User> find(User user);
    public User findOne(Long id);
    public void update(User user);
}
