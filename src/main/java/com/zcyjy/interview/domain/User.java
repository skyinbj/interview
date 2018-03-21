package com.zcyjy.interview.domain;

import java.io.Serializable;

public class User implements Comparable {
    private long id;

    private String loginname;

    private String password; // 加密

    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals2(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        if (id == user.id){
            return true;
        }else {
            if(loginname!= null && user.getLoginname()!= null &&
                    this.getLoginname().indexOf(user.getLoginname()) != -1){
                return true;
            }else {
                return false;
            }
        }
    }

    @Override
    public int compareTo(Object o) {
        User user = (User)o;
        int re = (int)(this.getId() - user.getId());
        if (re != 0){
            return re;
        }
        return this.getLoginname().compareTo(user.getLoginname());
    }

    @Override
    public String toString() {
        return this.getId()+"======"+this.getLoginname();
    }
}
