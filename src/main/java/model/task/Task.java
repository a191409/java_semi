package model.task;

import model.Default;

import java.sql.Date;
import java.sql.Timestamp;

public class Task extends Default {
    private String name;
    private String description;
    private Date limit;
    private Boolean didIt;
    private Integer categoryId;
    private Integer userId;

    public Task(Integer id, String name, String description, Date limit, Boolean didIt, Timestamp createdAt, Timestamp updatedAt, Integer categoryId, Integer userId) {
        super(id, createdAt, updatedAt);
        this.name = name;
        this.description = description;
        this.limit = limit;
        this.didIt = didIt;
        this.categoryId = categoryId;
        this.userId = userId;
    }

    //getメソッド
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getLimit() {
        return limit;
    }

    public Boolean getDidIt() {
        return didIt;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public Integer getUserId() {
        return userId;
    }


    //setメソッド
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLimit(Date limit) {
        this.limit = limit;
    }

    public void setDidIt(Boolean didIt) {
        this.didIt = didIt;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void insert() {
        Repository.insert(this);
    }
}
