package com.mr.controller;


import com.mr.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by yangjiliang on 2019/3/19.
 */
@RestController
public class UserController {

    @Autowired
    private MongoTemplate mongoTemplate;


    //新增
    @RequestMapping("/add")
    public String add(){
        User user = new User();
        user.setUserName("东邪");
        user.setUserAge(20);
        mongoTemplate.save(user);

        return "add------success";
    }

    //修改
    @RequestMapping("/update")
    public String update(){
        Query query = new Query();
        Criteria where = new Criteria();
        where.and("userName").is("hahaha");
        query.addCriteria(where);
        Update update = new Update();
        update.set("userName","娃哈哈");
        mongoTemplate.updateFirst(query,update,User.class);

        return "update------success";
    }

    //删除
    @RequestMapping("/delete")
    public String delete(){
        Query query = new Query();
        Criteria where = new Criteria();
        where.and("userName").is("wcc");
        query.addCriteria(where);
        mongoTemplate.remove(query,User.class);
        return "delete------success";
    }

    //查询
    @RequestMapping("/query")
    public String query(){
        Query query = new Query();
        Criteria where = new Criteria();
        where.and("userName");
        query.addCriteria(where);
        List<User> list = mongoTemplate.findAll(User.class);
        System.out.println(list);

        return "query------success";
    }







}
