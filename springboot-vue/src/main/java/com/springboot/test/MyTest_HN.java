package com.springboot.test;

import com.alibaba.fastjson.JSON;
import org.apache.tomcat.util.buf.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/*
@author 申浩东
*/
public class MyTest_HN {
    public static void main(String[] args) {
//        stringUtils_Join();//StringUtils.join();
        json();//JSON.toJSONString  将对象转换程json字符串
        System.out.println(Arrays.asList("0371"));
        System.out.println(Arrays.asList("0371").contains("0"));
    }
    static void json(){
        /**
         * json字符串转化为对象
         */
        String jsonString = "{name:'Antony',age:'12',sex:'male',telephone:'88888'}";
        Staff staff = JSON.parseObject(jsonString, Staff.class);
        System.out.println("staff= "+staff.toString());

        /**
         * 对象转化为json字符串
         */
        String jsonStr = JSON.toJSONString(staff);
        System.out.println("JSON.toJSONString: "+jsonStr);
    }
    static void stringUtils_Join(){
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(StringUtils.join(list, ','));
    }
}


class Staff {
    public String name;
    public Integer age;
    public String sex;
    public Date birthday;

    //省略getter和setter方法
    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}