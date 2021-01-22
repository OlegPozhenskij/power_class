package com.spring.entities;

public class PrivateUser {
    private int id;

    private String username;

    private String email;

    private String phone;

    private String image;

    public static PrivateUser getPrivateEmp(UserEntity em) {
        PrivateUser emp = new PrivateUser();
        emp.setId(em.getId());
        emp.setUsername(em.getUsername());
        emp.setEmail(em.getEmail());
        emp.setPhone(em.getPhone());
        emp.setImage(em.getPhoto());
        return emp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
