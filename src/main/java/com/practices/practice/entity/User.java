package com.practices.practice.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document (collection = "user")
@Data
public class User {
    private ObjectId Id;
    @NonNull
    @Indexed(unique = true)
    private String userName ;
     @NonNull
    private String password;
}
