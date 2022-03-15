package com.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.domain.User;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.Resource;

/*
@author 申浩东
*/
@Mapper
public interface UserMapper  extends BaseMapper<User> {


}
