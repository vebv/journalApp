package com.practices.practice.services;

import com.practices.practice.entity.journalEntry;
import com.practices.practice.repository.journalEntryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class journalEntryService {

   @Autowired
    public journalEntryRepository journalEntryRepository;

    public List<journalEntry> getData (){
       return journalEntryRepository.findAll();
    }

    public boolean postData(journalEntry reqData){
        journalEntryRepository.save(reqData);
        return true;
    }
}
