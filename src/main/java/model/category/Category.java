package model.category;

import model.Default;

import java.sql.Timestamp;

public class Category extends Default {
    private String name;

    public Category(Integer id, String name, Timestamp createdAt, Timestamp updatedAt) {
        super(id, createdAt, updatedAt);
        this.name = name;
    }

    //getメソッド
    public String getName() {
        return name;
    }

    //setメソッド
    public void setName(String name) {
        this.name = name;
    }

    public void insert() {
        Repository.insert(this);
    }
}
