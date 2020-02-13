package com.java.review.grammarbasis;

import java.io.Serializable;

public class UserCloneSerializable implements Serializable {
    private int id;
    private String name;
    private int age;
    private UserSerializable userS;

    public UserCloneSerializable() {
    }

    public UserCloneSerializable(int id, String name, int age, UserSerializable userS) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.userS = userS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserSerializable getUserS() {
        return userS;
    }

    public void setUserS(UserSerializable userS) {
        this.userS = userS;
    }

    @Override
    public String toString() {
        return "UserCloneSerializable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", userS=" + userS +
                '}';
    }
}
