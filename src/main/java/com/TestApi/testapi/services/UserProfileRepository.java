package com.TestApi.testapi.services;

import com.TestApi.testapi.tables.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserProfileRepository extends MongoRepository<UserProfile,String> {
    public UserProfile findByUsernameAndPassword(String name , String pass);
    public UserProfile findByUsername (String name);
}
