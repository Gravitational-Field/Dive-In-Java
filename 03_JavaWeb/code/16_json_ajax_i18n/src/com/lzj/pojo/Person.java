package com.lzj.pojo;

/**
 * @ClassName Person
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/1/5 14:30
 * @Version 1.0
 **/
public class Person {
    private Integer id;
    private String username;

    public Person() {
    }

    public Person(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
