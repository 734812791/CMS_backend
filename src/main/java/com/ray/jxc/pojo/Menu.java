package com.ray.jxc.pojo;

/**
 * @author ray
 * @create 2023-04-15 9:16
 */
public class Menu {

    private String id;

    private String text;

    private String icon;

    private String url;

    private String pid;

    private int order;

    private String flag;

    public Menu() {
    }

    public Menu(String id, String text, String icon, String url, String pid, int order, String flag) {
        this.id = id;
        this.text = text;
        this.icon = icon;
        this.url = url;
        this.pid = pid;
        this.order = order;
        this.flag = flag;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", icon='" + icon + '\'' +
                ", url='" + url + '\'' +
                ", pid='" + pid + '\'' +
                ", order=" + order +
                ", flag='" + flag + '\'' +
                '}';
    }
}
