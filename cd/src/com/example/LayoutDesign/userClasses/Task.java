package com.example.LayoutDesign.userClasses;

/**
 * Created with IntelliJ IDEA.
 * User: nimantha
 * Date: 10/10/13
 * Time: 3:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class Task {

    public enum TASK_STATUS{
        pending,completed
    }
    private String id;
    private String tName;
    private String tType;
    private String srartedAt;
    private String expire;
    private TASK_STATUS  status;
    private String description;

    public Task(String id, String tName, String tType, String srartedAt, String expire, TASK_STATUS status, String description) {
        this.id = id;
        this.tName = tName;
        this.tType = tType;
        this.srartedAt = srartedAt;
        this.expire = expire;
        this.status = status;
        this.description = description;
    }

    public Task(){


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String gettType() {
        return tType;
    }

    public void settType(String tType) {
        this.tType = tType;
    }

    public String getSrartedAt() {
        return srartedAt;
    }

    public void setSrartedAt(String srartedAt) {
        this.srartedAt = srartedAt;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public TASK_STATUS  getStatus() {
        return status;
    }

    public void setStatus(TASK_STATUS  status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
