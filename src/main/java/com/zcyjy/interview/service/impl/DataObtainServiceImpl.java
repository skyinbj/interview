package com.zcyjy.interview.service.impl;

import com.zcyjy.interview.data.UserData;
import com.zcyjy.interview.domain.User;
import com.zcyjy.interview.service.IDataObtainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.TreeSet;
import java.util.Vector;

@Service
public class DataObtainServiceImpl implements IDataObtainService{
    @Autowired
    UserData userData;
    private static Vector<User> vector = new Vector<User>();
    private volatile boolean init = false;



    public synchronized Vector<User> init(){
        init = true;
        String[] ids = userData.getId().split(",");
        String[] LoginNames = userData.getLoginname().split(",");
        String[] names = userData.getUsernames().split(",");
        String[] passwords = userData.getPassword().split(",");
        int len = ids.length;
        for (int i = 0; i < len; i++){
            User user = new User();
            if (ids.length >i){
                user.setId(Long.parseLong(ids[i]));
            }
            if (LoginNames.length > i){
                user.setLoginname(LoginNames[i]);
            }
            if (names.length > i){
                user.setName(names[i]);
            }
            if (passwords.length > i){
                user.setPassword(passwords[i]);
            }
            vector.add(user);
        }
        return vector;
    }

    public void add(User user){
        if (!init){
            init();
        }
        vector.add(user);
    }
    public void del(User user){
        if (!init){
            init();
        }
        Iterator<User> iterator = vector.iterator();
        while (iterator.hasNext()){
            User user1 = iterator.next();
            if (user1.equals2(user)){
                iterator.remove();
            }

        }
    }
    public TreeSet<User> find(){
        return find(null);
    }
    public TreeSet<User> find(User user){
        if (!init){
            init();
        }
        TreeSet<User> users= new TreeSet<User>();
        if (user == null){
            users.addAll(vector);
            return users;
        }
        Iterator<User> iterator = vector.iterator();
        while (iterator.hasNext()){
            User user1 = iterator.next();
            if (user1.equals2(user)){
                users.add(user1);
            }

        }
        return  users;
    }

    @Override
    public User findOne(Long id) {
        if (!init){
            init();
        }

        Iterator<User> iterator = vector.iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
            if (id == user.getId()){
                return user;
            }

        }
        return  null;
    }

    @Override
    public void update(User user) {
        User temp = findOne(user.getId());
        temp.setName(user.getName());
    }
}
