package com.example.OA.model.activiti;

public class ActUser {
    private String id;

    private Integer rev;

    private String first;

    private String last;

    private String email;

    private String pwd;

    private String pictureId;

    public ActUser(String id, Integer rev, String first, String last, String email, String pwd, String pictureId) {
        this.id = id;
        this.rev = rev;
        this.first = first;
        this.last = last;
        this.email = email;
        this.pwd = pwd;
        this.pictureId = pictureId;
    }

    public ActUser() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getRev() {
        return rev;
    }

    public void setRev(Integer rev) {
        this.rev = rev;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first == null ? null : first.trim();
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last == null ? null : last.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId == null ? null : pictureId.trim();
    }
}