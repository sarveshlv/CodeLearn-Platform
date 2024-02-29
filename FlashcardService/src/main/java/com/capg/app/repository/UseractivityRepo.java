package com.capg.app.repository;

import com.capg.app.model.UserActivity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UseractivityRepo extends MongoRepository<UserActivity, String> {
    List<UserActivity> findByUseridAndStatus(String userid, String status);

    List<UserActivity> findByUseridAndType(String userId, String type);
}
