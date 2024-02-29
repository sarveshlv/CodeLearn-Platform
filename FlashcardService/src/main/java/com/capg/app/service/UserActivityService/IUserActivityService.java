package com.capg.app.service.UserActivityService;

import com.capg.app.model.UserActivity;
import com.capg.app.repository.UseractivityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IUserActivityService implements UserActivityService{
    @Autowired
    private UseractivityRepo useractivityRepo;
    @Override
    public List<UserActivity> getAllCardsByUserIdAndStatus(String userId, String status) {
        return useractivityRepo.findByUseridAndStatus(userId, status);
    }

    @Override
    public List<UserActivity> getAllCardsByUserIdAndType(String userId, String type) {
        return useractivityRepo.findByUseridAndType(userId, type);
    }
}
