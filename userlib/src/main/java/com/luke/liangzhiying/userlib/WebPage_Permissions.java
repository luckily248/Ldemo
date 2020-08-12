package com.luke.liangzhiying.userlib;

public class WebPage_Permissions {
    private Integer permissions;
    private Integer webPage;

    public WebPage_Permissions(Integer permissions, Integer webPage) {
        this.permissions = permissions;
        this.webPage = webPage;
    }

    public Integer getPermissions() {
        return permissions;
    }

    public void setPermissions(Integer permissions) {
        this.permissions = permissions;
    }

    public Integer getWebPage() {
        return webPage;
    }

    public void setWebPage(Integer webPage) {
        this.webPage = webPage;
    }
}
