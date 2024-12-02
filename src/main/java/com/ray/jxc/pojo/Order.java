package com.ray.jxc.pojo;

import java.util.Date;

/**
 * @author ray
 * @create 2023-04-25 16:44
 */
public class Order {

    private String id;

    private String typeId;

    private int number;

    private int price;

    private String creater;

    private String createrId;

    private int orderType;

    private Date createDate;

    private int status;

    private String reason;

    private Type type;

    public Order() {
    }

    public Order(String id, String typeId, int number, int price, String creater, String createrId, int orderType, Date createDate, int status, String reason, Type type) {
        this.id = id;
        this.typeId = typeId;
        this.number = number;
        this.price = price;
        this.creater = creater;
        this.createrId = createrId;
        this.orderType = orderType;
        this.createDate = createDate;
        this.status = status;
        this.reason = reason;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", typeId='" + typeId + '\'' +
                ", number=" + number +
                ", price=" + price +
                ", creater='" + creater + '\'' +
                ", createrId='" + createrId + '\'' +
                ", orderType=" + orderType +
                ", createDate=" + createDate +
                ", status=" + status +
                ", reason='" + reason + '\'' +
                ", type=" + type +
                '}';
    }
}
