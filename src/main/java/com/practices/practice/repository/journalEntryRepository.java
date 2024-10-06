package com.practices.practice.repository;

import com.practices.practice.entity.journalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface journalEntryRepository extends MongoRepository<journalEntry, ObjectId> {
}
