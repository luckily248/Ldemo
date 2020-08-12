package com.luke.liangzhiying.userlib;


//one role assign by many permission with link to webpage
public class Permissions {
    private Integer id;
    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Permissions(Integer id, Integer roleId) {
        this.id = id;
        this.roleId = roleId;
    }
}
