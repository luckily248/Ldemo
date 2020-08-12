package com.luke.liangzhiying.userlib;

public class WebPage {
    private Integer id;
    private String url;

    public WebPage(Integer id, String url) {
        this.id = id;
        this.url = url;
    }

    @Override
    public String toString() {
        return "WebPage{" +
                "id=" + id +
                ", url='" + url + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
