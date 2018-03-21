package com.zcyjy.interview.controller;

import com.zcyjy.interview.domain.User;
import com.zcyjy.interview.service.IDataObtainService;
import com.zcyjy.interview.service.impl.DataObtainServiceImpl;
import com.zcyjy.interview.utils.Result;
import com.zcyjy.interview.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.TreeSet;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IDataObtainService dataObtainService;

    /**
     * 查询所有用户列表
     * @return
     */
    @GetMapping(value = "/users")
    public TreeSet<User> userList() {

        return dataObtainService.find();
    }

    /**
     * 添加一个用户
     * @return
     */
    @PostMapping(value = "/users")
    public Result<User> girlAdd(@RequestBody User user) {

        dataObtainService.add(user);

        return ResultUtil.success(dataObtainService.find());
    }

    //查询一个用户
    @GetMapping(value = "/users/{id}")
    public User girlFindOne(@PathVariable("id") long id) {

        return dataObtainService.findOne(id);
    }

    //更新
    @PutMapping(value = "/users/{id}")
    public TreeSet<User> usersUpdate(@PathVariable("id") long id,
                           @RequestParam("name") String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        dataObtainService.update(user);
        return dataObtainService.find();
    }

    //删除
    @DeleteMapping(value = "/users/{id}")
    public TreeSet<User> girlDelete(@PathVariable("id") long id) {
        User user = new User();
        user.setId(id);
        dataObtainService.del(user);
        return dataObtainService.find();
    }

    //通过登录名获取用户列表
    @GetMapping(value = "/users/loginname/{loginname}")
    public TreeSet<User>  girlListByAge(@PathVariable("loginname") String loginName) {
        User user = new User();
        user.setLoginname(loginName);
        return dataObtainService.find(user);
    }




}
