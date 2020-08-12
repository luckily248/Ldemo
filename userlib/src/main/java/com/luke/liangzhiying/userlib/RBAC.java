package com.luke.liangzhiying.userlib;

import java.util.ArrayList;

//memory layer implementation
public class RBAC implements IRBAC{
    private static RBAC INSTANCE = null;
    private RBAC() {};
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Role> roles = new ArrayList<>();
    private ArrayList<WebPage_Permissions> wplist = new ArrayList<>();
    private ArrayList<WebPage> webPages = new ArrayList<>();
    private ArrayList<Permissions> permissionslist = new ArrayList<>();


    public static RBAC getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RBAC();
        }
        return(INSTANCE);
    }

    @Override
    public User addUser(String username) {
        int id = users.size();
        User u = new User(id,username);
        users.add(u);
        return u;
    }

    @Override
    public void removeUser(Integer userId) {
        users.remove(userId.intValue());
    }

    @Override
    public User getUser(Integer userId) {
        return userId>=users.size()?null:users.get(userId);
    }

    @Override
    public Role addRole(String rolename) {
        int id = roles.size();
        Role r = new Role(id,rolename);
        roles.add(r);
        return r;
    }

    @Override
    public void removeRole(Integer roleId) {
        roles.remove(roleId.intValue());
    }

    @Override
    public Role getRole(Integer roleId) {
        return roles.get(roleId);
    }

    @Override
    public WebPage addWebPage(String url) {
        int id = webPages.size();
        WebPage w = new WebPage(id,url);
        webPages.add(w);
        return w;
    }

    @Override
    public void removeWebPage(Integer webPageId) {
        webPages.remove(webPageId.intValue());
    }

    @Override
    public WebPage getWebPage(Integer webPageId) {
        return webPages.get(webPageId);
    }

    @Override
    public void assignRole(Integer userId, Integer roleId) {
        User u = users.get(userId);
        if (u!=null){
            u.setRoleId(roleId);
        }
    }

    @Override
    public Permissions assignPremission(Integer webpageId, Integer roleId) {
        int id = permissionslist.size();
        Permissions p = new Permissions(id,roleId);
        WebPage_Permissions wp = new WebPage_Permissions(webpageId,id);
        permissionslist.add(p);
        wplist.add(wp);
        return  p;
    }

    @Override
    public Boolean canAccess(Integer userId, Integer webpageId) {
        User u = this.getUser(userId);
        if(u==null)return false;
        for (WebPage_Permissions wp:wplist
             ) {
            if(wp.getWebPage()==webpageId&&permissionslist.get(wp.getPermissions()).getRoleId()==u.getRoleId()) return true;
        }
        return false;
    }
}
