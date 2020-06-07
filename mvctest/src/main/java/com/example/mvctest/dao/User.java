package com.example.mvctest.dao;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Description TODO
 * @Author Administrator
 * @Email wangrqsh@163.com
 * @Date 2020/6/6 0006 下午 23:30
 * @Version 1.0
 */
@Setter
@Getter
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String address;

    public User() {
    }

    public User(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    public User(Long id,String name, Integer age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

}
