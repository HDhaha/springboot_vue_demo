package com.springboot.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.commen.Result;
import com.springboot.domain.User;

/*
@author 申浩东
*/
public interface UserService {

    Result insert(User user);
    Result update(User user);
    Result delete(Integer id);

    Page selectPage(Integer pageNum, Integer pageSize, String search);
}
