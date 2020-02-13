package com.java.review.grammarbasis;

public class UserClone implements Cloneable {
    private int id;
    private String name;
    private int age;
    private User user;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    public UserClone() {
    }

    public UserClone(int id, String name, int age, User user) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserClone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", user=" + user +
                '}';
    }
}
