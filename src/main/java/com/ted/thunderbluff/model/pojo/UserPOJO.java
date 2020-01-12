package com.ted.thunderbluff.model.pojo;

public class UserPOJO {

    private String username;

    private String firstname;

    private String lastname;

    private String fullname;

    private String email;

    private String address;

    private String phonenumber;

    private String securitynumber;

    public UserPOJO() {
    }

    public UserPOJO(String username, String firstname, String lastname, String fullname , String email, String address, String phonenumber,String securitynumber) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.fullname = fullname;
        this.email = email;
        this.address = address;
        this.phonenumber = phonenumber;
        this.securitynumber = securitynumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String  getPhonenumber() {
        return phonenumber;
    }

    public void setSecuritynumber(String securitynumber) {
        this.securitynumber = securitynumber;
    }

    public String getSecuritynumber() {
        return securitynumber;
    }
}
