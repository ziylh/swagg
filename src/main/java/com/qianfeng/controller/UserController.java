package com.qianfeng.controller;


import com.qianfeng.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *@Author feri
 *@Date Created in 2019/1/4 09:44
 */
@Api(produces = "这是Java编写的接口文档",value = "接口文档")
@RestController
public class UserController {

    //查询数据
    @ApiOperation(notes = "实现传递参数，响应指定数量的数据",tags = {"数量","名次"},value = "获取名次接口")
    @GetMapping("/datalist.do")
    public List<String> query1(@ApiParam(value = "数量") int count){
        List<String> strs=new ArrayList<String>();
        for(int i=1;i<=count;i++){
            strs.add("第"+i+"名");
        }
        return strs;
    }
    //查询数据
    @ApiOperation(notes = "实现传递参数，响应指定数量的数据",tags = {"随机数字"},value = "随机数")
    @GetMapping("/datarandom.do")
    public List<Integer> query2(){
        List<Integer> strs=new ArrayList<>();
        Random random=new Random();
        int count=random.nextInt(1000)+1;
        for(int i=1;i<=count;i++){
            strs.add(random.nextInt());
        }
        return strs;
    }
    //查询数据
    @ApiOperation(notes = "实现传递参数，响应指定数量的数据",tags = {"随机生成用户信息"},value = "随机数")
    @GetMapping("/userrandom.do")
    public List<User> query3(){
        List<User> strs=new ArrayList<>();
        Random random=new Random();
        int count=random.nextInt(100)+1;
        for(int i=1;i<=count;i++){
           User user=new User();
           user.setId(i);
           user.setSex(random.nextBoolean()?"男":"女");
           user.setPhone(1+createNum(10));
           user.setPassword(createNum(6));
           strs.add(user);
        }
        return strs;
    }
    //随机生成指定位数的数字
    public String createNum(int len){
        Random random=new Random();
        //3  100-999 10(3-1) 10(3)-1
        return (random.nextInt((int) Math.pow(10,len)-(int)Math.pow(10,len-1))+(int)Math.pow(10,len-1))+"";

    }

    public static void main(String[] args) {
        System.out.println(new UserController().createNum(10));
    }

}
