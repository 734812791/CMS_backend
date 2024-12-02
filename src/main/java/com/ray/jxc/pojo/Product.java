package com.ray.jxc.pojo;

/**
 * @author ray
 * @create 2023-04-25 11:32
 */
public class Product {

    private String id;

    private String typeId;

    private int total;

    private Type type;

    public Product() {
    }

    public Product(String id, String typeId, int total, Type type) {
        this.id = id;
        this.typeId = typeId;
        this.total = total;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", typeId='" + typeId + '\'' +
                ", total=" + total +
                ", type=" + type +
                '}';
    }
}
