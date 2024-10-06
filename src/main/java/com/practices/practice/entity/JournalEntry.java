package com.practices.practice.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "journal_Entry")
public class journalEntry {

    private  String name ;

    private  String fname ;

    private String password ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
