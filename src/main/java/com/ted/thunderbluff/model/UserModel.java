package com.ted.thunderbluff.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ted.thunderbluff.model.pojo.UserPOJO;
import com.ted.thunderbluff.model.pojo.UserXML;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "USER")
public class UserModel {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USERNAME", length = 50, unique = true)
    @NotNull
    @Size(min = 4, max = 50)
    private String username;

    @Column(name = "PASSWORD", length = 100)
    @NotNull
    @Size(min = 4, max = 100)
    private String password;

    @Column(name = "FIRSTNAME", length = 50)
    @NotNull
    @Size(min = 4, max = 50)
    private String firstname;

    @Column(name = "LASTNAME", length = 50)
    @NotNull
    @Size(min = 4, max = 50)
    private String lastname;

    @Column(name = "EMAIL", length = 50, unique = true)
    @NotNull
    @Size(min = 4, max = 50)
    private String email;

    @Column
    @NotNull
    private String phonenumber;

    @Column
    @NotNull
    private String address;

    @Column(unique = true)
    @NotNull
    private String securitynumber;

    @Column(name = "ENABLED")
    private Boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "USER_AUTHORITY",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID")})
    @JsonIgnore
    private List<Authority> authorities;

    @OneToMany(mappedBy = "userModel", cascade = CascadeType.ALL)
    private Set<Bid> bids = new HashSet<>();

    @OneToOne(mappedBy = "userModel")
    private ItemModel item;


    public UserPOJO convertToPOJO() {
        return new UserPOJO(this.username, this.firstname, this.lastname, this.firstname+' '+this.lastname, this.email ,this.address, this.phonenumber, this.securitynumber);
    }


    public UserXML convertToUserXML() {
        return new UserXML(this.username, this.firstname, this.lastname,this.firstname+' '+this.lastname, this.email ,this.address, this.phonenumber, this.securitynumber);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getSecuritynumber() {
        return securitynumber;
    }

    public void setSecuritynumber(String securitynumber) {
        this.securitynumber = securitynumber;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

}
