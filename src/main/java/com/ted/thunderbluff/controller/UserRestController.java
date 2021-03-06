package com.ted.thunderbluff.controller;

import com.ted.thunderbluff.model.*;
import com.ted.thunderbluff.model.pojo.UserPOJO;
import com.ted.thunderbluff.model.pojo.XMLPojo;
import com.ted.thunderbluff.security.JwtTokenUtil;
import com.ted.thunderbluff.security.JwtUser;
import com.ted.thunderbluff.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@RestController
public class UserRestController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;


    @RequestMapping(value = "/api/user", method = RequestMethod.GET)
    public JwtUser getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader).substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        return user;
    }



    @PostMapping("/api/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@Valid @RequestBody UserModel user) {
        userService.addUser(user);
    }

    public List<UserModel> getAllUsers() {
        List<UserModel> retList = userService.getAllUsers();
        retList.remove(0);
        return retList;
    }

    @GetMapping("/api/users")
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserPOJO> getAllUsersPOJO() {
        List<UserPOJO> retList = new ArrayList<>();
        for (UserModel user : getAllUsers()) {
            retList.add(user.convertToPOJO());
        }
        return retList;
    }

    @GetMapping("/api/users/xml")
    @PreAuthorize("hasRole('ADMIN')")
    public void getAllUsersToXML() {
        XMLPojo xmlPojo = new XMLPojo(getAllUsers());
        try {
            Date current = new Date();
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy'_'HH:mm:ss");
            File file = new File("AllUsers_"+format.format(current)+".xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(XMLPojo.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(xmlPojo, file);
            jaxbMarshaller.marshal(xmlPojo, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @PutMapping("/api/confirm/user/{username}")
    @PreAuthorize("hasRole('ADMIN')")
    public void confirmUser(@PathVariable String username) {
        userService.confirmUser(username);
    }

    @GetMapping("/api/users/{username}")
    @PreAuthorize("hasRole('USER')")
    @ResponseBody
    public UserModel getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @GetMapping("/api/users/pojo/{username}")
    @PreAuthorize("hasRole('USER')")
    public UserPOJO getUserPOJO(@PathVariable String username) {
        return userService.getUserByUsername(username).convertToPOJO();
    }

    @GetMapping("/api/get/other/users/{username}")
    @PreAuthorize("hasRole('USER')")
    public List<UserPOJO> getOtherUsers(@PathVariable String username) {
        return userService.getOtherUsers(username);
    }



}
