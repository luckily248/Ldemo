package com.luke.liangzhiying.userlib;

public class Role {
    private Integer id;
    private String name;

    public Role(int id, String rolename) {
        this.id = id;
        this.name = rolename;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
