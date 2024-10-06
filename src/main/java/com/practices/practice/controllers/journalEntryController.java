package com.practices.practice.controllers;

import com.practices.practice.entity.journalEntry;
import com.practices.practice.services.journalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class journalEntryController {

    @Autowired
    public journalEntryService journalEntryService;

    @GetMapping
    public List<journalEntry> getData (){
     return journalEntryService.getData();
    }

    @PostMapping
    public boolean postData(@RequestBody journalEntry myData){
        return journalEntryService.postData(myData);
    }
}
