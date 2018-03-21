package com.zcyjy.interview.utils;

import com.zcyjy.interview.domain.User;

import java.util.Comparator;

public class UserCompare implements Comparator<User>{
    @Override
    public int compare(User user, User user2) {
        int re = (int)(user.getId() - user2.getId());
        if (re != 0){
            return re;
        }
        return user.getLoginname().compareTo(user2.getLoginname());
    }
}
