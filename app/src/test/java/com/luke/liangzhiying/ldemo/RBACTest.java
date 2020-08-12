package com.luke.liangzhiying.ldemo;

import com.luke.liangzhiying.userlib.*;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>


///*/
//run all the tests
public class RBACTest {

    @Test
    public void testAddUser(){
        RBAC rbac = RBAC.getInstance();
        User u  =rbac.addUser("Dan");
        assertEquals(u,rbac.getUser(u.getId()));
    }
    @Test
    public void testRemoveUser(){
        RBAC rbac = RBAC.getInstance();
        User u  =rbac.addUser("Dan");
        rbac.removeUser(u.getId());
        assertEquals(null,rbac.getUser(u.getId()));
    }
    @Test
    public void testAddRole(){
        RBAC rbac = RBAC.getInstance();
        Role r  =rbac.addRole("Admin");
        assertEquals(r,rbac.getRole(r.getId()));
    }

    @Test
    public void testRemoveRole(){
        RBAC rbac = RBAC.getInstance();
        Role r  =rbac.addRole("Admin");
        rbac.removeRole(r.getId());
        assertEquals(null,rbac.getUser(r.getId()));
    }

    @Test
    public void testAssignRole(){
        RBAC rbac = RBAC.getInstance();
        User u = rbac.addUser("dan");
        Role r = rbac.addRole("Admin");
        rbac.assignRole(u.getId(),r.getId());
        assertEquals(r.getId(), rbac.getUser(u.getId()).getRoleId());
    }

    @Test
    public void testPermissions(){
        RBAC rbac = RBAC.getInstance();
        User u = rbac.addUser("Dan");
        Role r = rbac.addRole("Admin");
        WebPage w = rbac.addWebPage("google.com");
        rbac.assignRole(u.getId(),r.getId());
        rbac.assignPremission(w.getId(),r.getId());
        assertTrue(rbac.canAccess(u.getId(),w.getId()));
    }
    @Test
    public void testPermissionsF(){
        RBAC rbac = RBAC.getInstance();
        User u = rbac.addUser("Dan");
        User u2 = rbac.addUser("Tom");
        Role r = rbac.addRole("Admin");
        WebPage w = rbac.addWebPage("google.com");
        rbac.assignRole(u.getId(),r.getId());
        //rbac.assignRole(u2.getId(),r.getId());
        rbac.assignPremission(w.getId(),r.getId());
        assertFalse(rbac.canAccess(u2.getId(),w.getId()));
    }
}