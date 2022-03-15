package com.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.commen.Result;
import com.springboot.domain.User;
import com.springboot.mapper.UserMapper;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
@author 申浩东
*/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public Result insert(User user) {
        Result result=Result.error("400", "插入失败");
        try {
            int i = userMapper.insert(user);
            if (i > 0) {
                result = Result.success();
            }
        }catch (Exception e){
//            throw new RuntimeException("插入失败");
            System.out.println("插入失败");
        }
        System.out.println("===================="+result);
        return result;
    }

    @Override
    public Result update(User user) {
        Result result=Result.error("400", "更新失败");
        try {
            int i = userMapper.updateById(user);
            if (i > 0) {
                result= Result.success();
            }
        }catch (Exception e){
            System.out.println("更新失败");
        }
        return result;
    }

    @Override
    public Result delete(Integer id) {
        Result result=Result.error("400", "删除失败");
        try {
            int i = userMapper.deleteById(id);
            if (i > 0) {
                result= Result.success();
            }
        }catch (Exception e){
            System.out.println("删除失败");
        }
        return result;
    }


    @Override
    public Page selectPage(Integer pageNum, Integer pageSize, String search) {
        LambdaQueryWrapper<User> wrappers = Wrappers.<User>lambdaQuery();
        /*  如果 search 不为空的话就模糊查询 ,否则的话  则直接查询空   */
        if(StringUtils.isNotBlank(search)){
            wrappers.like(User::getNickName,search);
        }
        return userMapper.selectPage(new Page<>(pageNum,pageSize),wrappers);
    }

}
