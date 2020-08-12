package com.luke.liangzhiying.userlib;


//interface for all functions
interface IRBAC {
    User addUser(String username);
    void removeUser(Integer userId);
    User getUser(Integer userId);
    Role addRole(String rolename);
    void removeRole(Integer roleId);
    Role getRole(Integer roleId);
    WebPage addWebPage(String url);
    void removeWebPage(Integer webPageId);
    WebPage getWebPage(Integer webPageId);
    void assignRole(Integer userId, Integer roleId);
    Permissions assignPremission(Integer webpageId,Integer roleId);
    Boolean canAccess(Integer userId,Integer webpageId);
}
